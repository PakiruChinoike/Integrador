import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FaseDAO {

    private ConexaoMYSQL conexao;

    public FaseDAO() {
		this.conexao = new ConexaoMYSQL();
    }

    public long salvar(Fase fase) {
        try {
            this.conexao.abrirConexao();
            String sql = "INSERT INTO fase VALUES(null, ?, ?, ?)";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setString(1, fase.getNome());
            statement.setInt(2, fase.getListaSalas().size());
            statement.setLong(3, fase.getEquipe().getId());
            statement.executeUpdate();

            String sql0 = "SELECT id_fase FROM fase ORDER BY id_fase DESC LIMIT 1";
            PreparedStatement statement0 = this.conexao.getConexao().prepareStatement(sql0);
            ResultSet rs0 = statement0.executeQuery();

            rs0.next();
            long id_fase = rs0.getLong("id_fase");
            return id_fase;

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.conexao.fecharConexao();
        }
    }

    public void editar(Fase fase) {
        try {
            this.conexao.abrirConexao();
            String sql = "UPDATE fase SET nome=?, num_salas=?, id_equipe=? WHERE id_fase=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setString(1, fase.getNome());
            statement.setInt(2, fase.getListaSalas().size());
            statement.setLong(3, fase.getEquipe().getId());
            statement.setLong(4, fase.getId());
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

            String sql2 = "DELETE FROM sala_fase WHERE id_fase=?";
            PreparedStatement statement2 = this.conexao.getConexao().prepareStatement(sql2);
            statement2.setLong(1, id);
            statement2.executeUpdate();

            String sql = "DELETE FROM fase WHERE id_fase=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
    }

    public Fase buscar(long id) {
        try {
            this.conexao.abrirConexao();
            String sql = "SELECT * FROM fase WHERE id_fase=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                SalaDAO salaDAO = new SalaDAO();

                String sql2 = "SELECT * FROM sala_fase WHERE id_fase=?";
                PreparedStatement statement2 = this.conexao.getConexao().prepareStatement(sql2);
                statement2.setLong(1, id);
                ResultSet rs2 = statement2.executeQuery();

                List<Sala> listaSalas = new ArrayList<Sala>();

                while (rs2.next()) {
                    Sala sala = salaDAO.buscar(rs2.getLong("id_sala"));
                    listaSalas.add(sala);
                }

                String sql3 = "SELECT * FROM equipe WHERE id_equipe=?";
                PreparedStatement statement3 = this.conexao.getConexao().prepareStatement(sql3);
                statement3.setLong(1, rs.getLong("id_equipe"));
                ResultSet rs3 = statement3.executeQuery();
                
                Fase fase = new Fase(rs.getString("nome"), listaSalas);

                if (rs3.next()) {
                    EquipeDAO equipeDAO = new EquipeDAO();
                    Equipe equipe = equipeDAO.buscar(rs3.getLong("id_equipe"));

                    fase.setEquipe(equipe);
                }

                return fase;
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