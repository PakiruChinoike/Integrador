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

            rs0.next();
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

            String sql2 = "DELETE FROM monstro_sala WHERE id_sala=?";
            PreparedStatement statement2 = this.conexao.getConexao().prepareStatement(sql2);
            statement2.setLong(1, id);
            statement2.executeUpdate();

            String sql3 = "DELETE FROM sala_fase WHERE id_sala=?";
            PreparedStatement statement3 = this.conexao.getConexao().prepareStatement(sql3);
            statement3.setLong(1, id);
            statement3.executeUpdate();

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

                RecompensaDAO recompensaDAO = new RecompensaDAO();
                Recompensa recompensa = recompensaDAO.buscar(rs.getLong("id_recompensa"));
                sala.setRecompensa(recompensa);

                String sql3 = "SELECT * FROM monstro_sala WHERE id_sala=?";
                PreparedStatement statement3 = this.conexao.getConexao().prepareStatement(sql3);
                statement3.setLong(1, id);
                ResultSet rs3 = statement3.executeQuery();

                MonstroDAO monstroDAO = new MonstroDAO();

                while (rs3.next()) {
                    Monstro monstro = monstroDAO.buscar(rs3.getLong("id_monstro"));

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