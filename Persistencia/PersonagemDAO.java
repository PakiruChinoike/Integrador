import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonagemDAO {

    private ConexaoMYSQL conexao;

    public PersonagemDAO() {
		this.conexao = new ConexaoMYSQL("localhost", "3306", "root", "root", "bd_comunicacao_java_mysql_2i_2023");
	}

    public void salvar(Personagem personagem) {
        try {
            this.conexao.abrirConexao();
            String sql = "INSERT INTO personagem VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setString(1, personagem.getNome());
            statement.setInt(2, personagem.getClasse());
            statement.setInt(3, personagem.getVida());
            statement.setInt(4, personagem.getArmadura());
            statement.setInt(5, personagem.getPoder());
            statement.setInt(6, personagem.getExperiencia());
            statement.setLong(7, personagem.getEquipe().getId());
            //setar habilidade
            //setar inventario
            statement.setLong(9, personagem.getAtributosId());
            statement.setLong(10, personagem.getId());
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
            String sql = "UPDATE personagem SET nome=?, classe=?, vida=?, armadura=?, poder=?, nivel=?, experiencia=? WHERE id_personagem=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setString(1, personagem.getNome());
            statement.setInt(2, personagem.getClasse());
            statement.setInt(3, personagem.getVida());
            statement.setInt(4, personagem.getArmadura());
            statement.setInt(5, personagem.getPoder());
            statement.setInt(6, personagem.getExperiencia());
            statement.setLong(7, personagem.getId());
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
            String sql = "DELETE FROM personagem WHERE id_personagem=?";
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
            String sql = "SELECT * FROM personagem WHERE id_personagem=?";
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
            return null;
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
            return null;
        } finally {
            this.conexao.fecharConexao();
        }
    }

}