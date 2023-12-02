import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Personagem_HabilidadeDAO{

    private ConexaoMYSQL conexao;

    public Personagem_HabilidadeDAO() {
		this.conexao = new ConexaoMYSQL();
    }

    public void salvar(Personagem personagem, Habilidade habilidade) {
        try {
            this.conexao.abrirConexao();
            String sql = "INSERT INTO personagem_habilidade VALUES(null, ?, ?)";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, personagem.getId());
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
            String sql = "DELETE FROM personagem_habilidade WHERE id_personagem_habilidade=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
    }

    public long buscarPersonagem(long id) {
        try {
            this.conexao.abrirConexao();
            String sql = "SELECT id_personagem FROM personagem_habilidade WHERE id_personagem_habilidade=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                long id_personagem = rs.getLong("id_personagem");
                return id_personagem;
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
            String sql = "SELECT id_habilidade FROM personagem_habilidade WHERE id_personagem=?";
            PreparedStatement statement = conexao.getConexao().prepareStatement(sql);
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