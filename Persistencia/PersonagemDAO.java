import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        } finally {
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
        } finally {
            this.conexao.fecharConexao();
        }
    }

    public void excluir(long id) {
        try {
            this.conexao.abrirConexao();
            String sql = "DELETE FROM personagem WHERE id_usuario=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
    }

    public Personagem buscar(long id) {
        try {
            this.conexao.abrirConexao();
            String sql = "SELECT * FROM personagem WHERE id_usuario=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Personagem personagem = new Personagem(rs.getString("nome"), rs.getInt("classe"));
                return personagem;
            }   
            else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
    }

    public List<Personagem> buscarTodos() {
        try {
            this.conexao.abrirConexao();
            String sql = "SELECT * FROM personagem";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            List<Personagem> listaPersonagens = new ArrayList<Personagem>();
            while (rs.next()) {
                Personagem personagem = new Personagem(rs.getString("nome"), rs.getInt("classe"));
                listaPersonagens.add(personagem);
            }
            return listaPersonagens;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
    }

}