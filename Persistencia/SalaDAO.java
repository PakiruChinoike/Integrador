import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SalaDAO {

    private ConexaoMYSQL conexao;

    public SalaDAO() {
		this.conexao = new ConexaoMYSQL();
    }

    public long salvar(Sala sala) {
        try {
            this.conexao.abrirConexao();
            String sql = "INSERT INTO sala VALUES(null, ?, ?, ?)";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setString(1, sala.getNome());
            statement.setString(2, sala.getDescricao());
            statement.setLong(3, sala.getRecompensa().getId());
            statement.executeUpdate();

            String sql0 = "SELECT id_sala FROM sala ORDER BY id_sala DESC LIMIT 1"; 
            PreparedStatement statement0 = this.conexao.getConexao().prepareStatement(sql0);
            ResultSet rs0 = statement0.executeQuery();
            long id_sala = rs0.getLong("id_sala");
            return id_sala;

        } catch(SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.conexao.fecharConexao();
        }
    }

    public void editar(Sala sala) {
        try {
            this.conexao.abrirConexao();
            String sql = "UPDATE sala SET nome=?, descricao=?, id_recompensa=? WHERE id_sala=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setString(1, sala.getNome());
            statement.setString(2, sala.getDescricao());
            statement.setLong(3, sala.getRecompensa().getId());
            statement.setLong(4, sala.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
    }

    public void excluir(long id) {
        try {
            this.conexao.abrirConexao();
            String sql = "DELETE FROM sala WHERE id_sala=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
    }

    public Sala buscar(long id) {
        try {
            this.conexao.abrirConexao();
            String sql = "SELECT * FROM sala WHERE id_sala=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                Sala sala = new Sala(rs.getLong("id_sala"), rs.getString("nome"), rs.getString("descricao"));

                String sql2 = "SELECT * FROM recompensa WHERE id_sala=?";
                PreparedStatement statement2 = this.conexao.getConexao().prepareStatement(sql2);
                statement2.setLong(1, id);
                ResultSet rs2 = statement2.executeQuery();

                if (rs2.next()) {
                    HabilidadeDAO habilidadeDao = new HabilidadeDAO();
                    Habilidade habilidade = habilidadeDao.buscar(rs2.getLong("id_habilidade"));

                    ItemDAO itemDao = new ItemDAO();
                    Item item = itemDao.buscar(rs2.getLong("id_item"));

                    Recompensa recompensa = new Recompensa(rs2.getInt("tipo"), rs2.getInt("raridade"), rs2.getInt("experiencia"), item, habilidade);
                    sala.setRecompensa(recompensa);
                }

                String sql3 = "SELECT COUNT(id_monstro_sala) FROM monstro_sala WHERE id_sala=?";
                PreparedStatement statement3 = this.conexao.getConexao().prepareStatement(sql3);
                statement3.setLong(1, id);
                ResultSet rs3 = statement3.executeQuery();

                Monstro_SalaDAO monstro_SalaDAO = new Monstro_SalaDAO();

                while (rs3.next()) {
                    Monstro monstro = monstro_SalaDAO.buscarMonstro(id);

                    sala.addInimigos(monstro);
                }

                return sala;
            }   
            else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            this.conexao.fecharConexao();
        }
    }

}