import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonagemDAO {

    private ConexaoMYSQL conexao;

    public void salvar(Personagem personagem) {
        try {
            this.conexao.abrirConexao();
            String sql = "INSERT INTO personagem VALUES(null, ?)";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setString(1, personagem.getNome());
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            this.conexao.fecharConexao();
        }
    }

    public void editar(Personagem personagem) {
        try {
            this.conexao.abrirConexao();
            String sql = "UPDATE personagem SET nome=? WHERE id_personagem=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setString(1, personagem.getNome());
            statement.setLong(2, personagem.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            this.conexao.fecharConexao();
        }
    }

    public void excluir(long id) {
        try {
            this.conexao.abrirConexao();
            String sql = "DELETE FROM personagem WHERE id_usuario=?";
            PreparedStatement statement = this.conexaxo.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            this.conexao.fecharConexao();
        }
    }

}