import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonagemDAO {

    private ConexaoMYSQL conexao;

    public PersonagemDAO() {
		this.conexao = new ConexaoMYSQL("localhost", "3306", "root", "root", "CatacombsIntegrador");
	}

    public void salvar(Personagem personagem) {
        try {
            this.conexao.abrirConexao();
            String sql = "INSERT INTO personagem VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setString(1, personagem.getNome());
            statement.setInt(2, personagem.getClasse());
            statement.setInt(3, personagem.getVida());
            statement.setInt(4, personagem.getArmadura());
            statement.setInt(5, personagem.getPoder());
            statement.setInt(6, personagem.getExperiencia());
            statement.setLong(7, personagem.getEquipe().getId());
            statement.setLong(8, personagem.getAtributosId());
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

            String sql2 = "UPDATE atributos SET agilidade=?, forca=?, inteligencia=? WHERE id_personagem=?";
            PreparedStatement statement2 = this.conexao.getConexao().prepareStatement(sql2);
            statement2.setInt(1, personagem.getAtributos(0));
            statement2.setInt(2, personagem.getAtributos(1));
            statement2.setInt(3, personagem.getAtributos(3));
            statement2.setLong(4, personagem.getId());

            String sql3 = "UPDATE fraquezas SET flamejante=?, congelante=?, eletrico=?, fisico=?, arcano=? WHERE id_personagem=?";
            PreparedStatement statement3 = this.conexao.getConexao().prepareStatement(sql3);
            statement3.setBoolean(1, personagem.getFraquezas(0));
            statement3.setBoolean(2, personagem.getFraquezas(1));
            statement3.setBoolean(3, personagem.getFraquezas(2));
            statement3.setBoolean(4, personagem.getFraquezas(3));
            statement3.setBoolean(5, personagem.getFraquezas(4));
            statement3.setLong(6, personagem.getId());
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

            String sql2 = "SELECT COUNT(id_personagem_item) FROM personagem_item WHERE id_personagem=?";
            PreparedStatement statement2 = this.conexao.getConexao().prepareStatement(sql2);
            statement2.setLong(1, id);
            ResultSet rs2 = statement2.executeQuery();

            if (rs2.next()) {
                personagem.addItem(Personagem_ItemDAO.buscarItem(id));
            }
            
            String sql3 = "SELECT COUNT(id_personagem_habilidade) FROM personagem_habilidade WHERE id_personagem=?";
            PreparedStatement statement3 = this.conexao.getConexao().prepareStatement(sql3);
            statement3.setLong(1, id);
            ResultSet rs3 = statement3.executeQuery();

            if (rs3.next()) {
                personagem.addHabilidade(Personagem_HabilidadeDAO.buscarHabilidade(id));
            }

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