import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonagemDAO {

    private ConexaoMYSQL conexao;

    public PersonagemDAO() {
		this.conexao = new ConexaoMYSQL();
	}

    public long salvar(Personagem personagem) {
        try {
            this.conexao.abrirConexao();
            String sql = "INSERT INTO personagem VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setString(1, personagem.getNome());
            statement.setInt(2, personagem.getClasse());
            statement.setInt(3, personagem.getVida());
            statement.setInt(4, personagem.getArmadura());
            statement.setInt(5, personagem.getPoder());
            statement.setInt(6, personagem.getNivel());
            statement.setInt(7, personagem.getExperiencia());
            statement.setLong(8, personagem.getEquipe());
            statement.executeUpdate();

            String sql0 = "SELECT id_personagem FROM personagem ORDER BY id_personagem DESC LIMIT 1";
            PreparedStatement statement0 = this.conexao.getConexao().prepareStatement(sql0);
            ResultSet rs0 = statement0.executeQuery();

            if (rs0.next()) {
                long id_personagem = rs0.getLong("id_personagem");

                String sql2 = "INSERT INTO atributos VALUES(null, ?, ?, ?, ?, null)";
                PreparedStatement statement2 = this.conexao.getConexao().prepareStatement(sql2);
                statement2.setInt(1, personagem.getAtributos(0));
                statement2.setInt(2, personagem.getAtributos(1));
                statement2.setInt(3, personagem.getAtributos(2));
                statement2.setLong(4, id_personagem);
                statement2.executeUpdate();

                String sql3 = "INSERT INTO fraquezas VALUES(null, ?, ?, ?, ?, ?, ?, null)";
                PreparedStatement statement3 = this.conexao.getConexao().prepareStatement(sql3);
                statement3.setBoolean(1, personagem.getFraquezas(0));
                statement3.setBoolean(2, personagem.getFraquezas(1));
                statement3.setBoolean(3, personagem.getFraquezas(2));
                statement3.setBoolean(4, personagem.getFraquezas(3));
                statement3.setBoolean(5, personagem.getFraquezas(4));
                statement3.setLong(6, id_personagem);
                statement3.executeUpdate();

                for (int i = 0; i<personagem.getHabilidades().size(); i++) {
                    String sql4 = "INSERT INTO personagem_habilidade VALUES(null, ?, ?)"; 
                    PreparedStatement statement4 = this.conexao.getConexao().prepareStatement(sql4);
                    statement4.setLong(1, id_personagem);
                    statement4.setLong(2, personagem.getHabilidade(i).getId());
                    statement4.executeUpdate();
                }

                for (int i = 0; i<personagem.getItens().size(); i++) {
                    String sql5 = "INSERT INTO personagem_item VALUES(null, ?, ?)"; 
                    PreparedStatement statement5 = this.conexao.getConexao().prepareStatement(sql5);
                    statement5.setLong(1, id_personagem);
                    statement5.setLong(2, personagem.getItem(i).getId());
                    statement5.executeUpdate();
                }

                return id_personagem;

            } else {
                return 0;
            }
        } catch(SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.conexao.fecharConexao();
        }
    }

    public void editar(Personagem personagem) {
        try {
            this.conexao.abrirConexao();
            String sql = "UPDATE personagem SET nome=?, classe=?, vida=?, armadura=?, poder=?, nivel=?, experiencia=?, equipe=? WHERE id_personagem=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setString(1, personagem.getNome());
            statement.setInt(2, personagem.getClasse());
            statement.setInt(3, personagem.getVida());
            statement.setInt(4, personagem.getArmadura());
            statement.setInt(5, personagem.getPoder());
            statement.setInt(6, personagem.getExperiencia());
            statement.setLong(7, personagem.getEquipe());
            statement.setLong(8, personagem.getId());
            statement.executeUpdate();

            String sql2 = "UPDATE atributos SET agilidade=?, forca=?, inteligencia=? WHERE id_personagem=?";
            PreparedStatement statement2 = this.conexao.getConexao().prepareStatement(sql2);
            statement2.setInt(1, personagem.getAtributos(0));
            statement2.setInt(2, personagem.getAtributos(1));
            statement2.setInt(3, personagem.getAtributos(2));
            statement2.setLong(4, personagem.getId());
            statement2.executeUpdate();

            String sql3 = "UPDATE fraquezas SET flamejante=?, congelante=?, eletrico=?, fisico=?, arcano=? WHERE id_personagem=?";
            PreparedStatement statement3 = this.conexao.getConexao().prepareStatement(sql3);
            statement3.setBoolean(1, personagem.getFraquezas(0));
            statement3.setBoolean(2, personagem.getFraquezas(1));
            statement3.setBoolean(3, personagem.getFraquezas(2));
            statement3.setBoolean(4, personagem.getFraquezas(3));
            statement3.setBoolean(5, personagem.getFraquezas(4));
            statement3.setLong(6, personagem.getId());
            statement3.executeUpdate();

            for (int i = 0; i<personagem.getHabilidades().size(); i++) {
                String sql4 = "UPDATE personagem_habilidade SET id_habilidade=? WHERE id_personagem=?";
                PreparedStatement statement4 = this.conexao.getConexao().prepareStatement(sql4);
                statement4.setLong(1, personagem.getHabilidade(i).getId()); 
                statement4.setLong(2, personagem.getId());
                statement4.executeUpdate();
            }

            for (int i = 0; i<personagem.getItens().size(); i++) {
                String sql5 = "UPDATE personagem_item SET id_item=? WHERE id_personagem=?";
                PreparedStatement statement5 = this.conexao.getConexao().prepareStatement(sql5);
                statement5.setLong(1, personagem.getItem(i).getId());
                statement5.setLong(2, personagem.getId());
                statement5.executeUpdate();
            }

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
                Personagem personagem = new Personagem(rs.getLong("id"), rs.getString("nome"), rs.getInt("classe"), rs.getInt("armadura"), rs.getInt("vida"), rs.getInt("nivel"), rs.getInt("poder"), rs.getInt("experiencia"), rs.getInt("id_equipe"));

                String sql2 = "SELECT * FROM item WHERE id_personagem=?";
                PreparedStatement statement2 = this.conexao.getConexao().prepareStatement(sql2);
                statement2.setLong(1, id);
                ResultSet rs2 = statement2.executeQuery();

                Personagem_ItemDAO personagem_ItemDAO = new Personagem_ItemDAO();
                Personagem_HabilidadeDAO personagem_HabilidadeDAO = new Personagem_HabilidadeDAO();

            while (rs2.next()) {
                personagem.addItem(personagem_ItemDAO.buscarItem(id));
            }
            
                String sql3 = "SELECT * FROM personagem_habilidade WHERE id_personagem=?";
                PreparedStatement statement3 = this.conexao.getConexao().prepareStatement(sql3);
                statement3.setLong(1, id);
                ResultSet rs3 = statement3.executeQuery();

            while (rs3.next()) {
                personagem.addHabilidade(personagem_HabilidadeDAO.buscarHabilidade(id));
            }

                String sql4 = "SELECT * FROM atributos WHERE id_personagem=?";
                PreparedStatement statement4 = this.conexao.getConexao().prepareStatement(sql4);
                statement4.setLong(1, id);
                ResultSet rs4 = statement4.executeQuery();

                List<Integer> listaAtributos = new ArrayList<Integer>();

            if (rs4.next()) {
                listaAtributos.add(rs4.getInt("agilidade"));
                listaAtributos.add(rs4.getInt("forca"));
                listaAtributos.add(rs4.getInt("inteligencia"));

                personagem.setAtributos(listaAtributos);
            }

                String sql5 = "SELECT * FROM fraquezas WHERE id_personagem=?";
                PreparedStatement statement5 = this.conexao.getConexao().prepareStatement(sql5);
                statement5.setLong(1, id);
                ResultSet rs5 = statement5.executeQuery();

                List<Boolean> listaFraquezas = new ArrayList<Boolean>();

            if (rs5.next()) {
                listaFraquezas.add(rs5.getBoolean("flamejante"));
                listaFraquezas.add(rs5.getBoolean("congelante"));
                listaFraquezas.add(rs5.getBoolean("eletrico"));
                listaFraquezas.add(rs5.getBoolean("fisico"));
                listaFraquezas.add(rs5.getBoolean("arcano"));

                personagem.setFraquezas(listaFraquezas);
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
