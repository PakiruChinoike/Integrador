import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Monstro_HabilidadeDAO{

    private ConexaoMYSQL conexao;

    public Monstro_HabilidadeDAO() {
		this.conexao = new ConexaoMYSQL("localhost", "3306", "root", "Pipoka!821", "CatacombsIntegrador");
    }

    public void salvar(Monstro monstro, Habilidade habilidade) {
        try {
            this.conexao.abrirConexao();
            String sql = "INSERT INTO monstro_habilidade VALUES(null, ?, ?)";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, monstro.getId());
            statement.setLong(2, habilidade.getId());
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
    }

    public void excluir(long id) {
        try {
            this.conexao.abrirConexao();
            String sql = "DELETE FROM monstro_habilidade WHERE id_monstro_habilidade=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
    }

    public long buscarMonstro(long id) {
        try {
            this.conexao.abrirConexao();
            String sql = "SELECT id_monstro FROM monstro_habilidade WHERE id_monstro_habilidade=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                long id_monstro = rs.getLong("id_monstro");
                return id_monstro;
            }   
            else {
                return (Long)null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return (Long)null;
        } finally {
            conexao.fecharConexao();
        }
    }

    public Habilidade buscarHabilidade(long id) {
        try {
            this.conexao.abrirConexao();
            String sql = "SELECT id_habilidade FROM monstro_habilidade WHERE id_monstro=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                long id_habilidade = rs.getLong("id_habilidade");
                
                HabilidadeDAO habilidadeDAO = new HabilidadeDAO();
                Habilidade habilidade = habilidadeDAO.buscar(id_habilidade);

                return habilidade;
            }   
            else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            conexao.fecharConexao();
        }
    }

}