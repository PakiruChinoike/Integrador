import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonagemDAO {

    private Connection conexao;

    public void salvar(Personagem personagem) {
        try {
            this.conexao.abrirConexao();
            String sql = "INSER INTO personagem VALUES(null, ?)";
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

}