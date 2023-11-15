import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Personagem_ItemDAO{

    private ConexaoMYSQL conexao;

    public Personagem_ItemDAO() {
		this.conexao = new ConexaoMYSQL("localhost", "3306", "root", "Pipoka!821", "CatacombsIntegrador");
    }

    public void salvar(Personagem personagem, Item item) {
        try {
            this.conexao.abrirConexao();
            String sql = "INSERT INTO personagem_item VALUES(null, ?, ?)";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, personagem.getId());
            statement.setLong(2, item.getId());
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
            String sql = "DELETE FROM personagem_item WHERE id_personagem_itemitem=?";
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
            String sql = "SELECT id_personagem FROM personagem_item WHERE id_item=?";
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

    public Item buscarItem(long id) {
        try {
            this.conexao.abrirConexao();
            String sql = "SELECT id_item FROM personagem_item WHERE id_personagem=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                long id_item = rs.getLong("id_item");
                
                String sql2 = "SELECT * FROM item WHERE id_item=?";
                PreparedStatement statement2 = this.conexao.getConexao().prepareStatement(sql2);
                statement.setLong(1, id_item);
                ResultSet rs2 = statement.executeQuery();

                if(rs2.next()) {
                    String sql3 = "SELECT * FROM habilidade WHERE id_habilidade=?";
                    PreparedStatement statement3 = this.conexao.getConexao().prepareStatement(sql3);
                    statement2.setLong(1, rs.getLong("id_habilidade"));
                    ResultSet rs3 = statement.executeQuery();
                    
                    if (rs3.next()) {
                        Habilidade habilidade;
    
                        int tipo = rs.getInt("tipo");
                        switch (tipo) {
                            case 0: {
                                habilidade = new Ataque();
                                break;
                            }
                            case 1: {
                                habilidade = new Resistencia();
                                break;
                            }
                            case 2: {
                                habilidade = new Garantido();
                                break;
                            }
                            default: {
                                return null;
                            }
                        }
    
                        Item item = new Item(rs3.getString("nome"), rs3.getInt("raridade"), habilidade);
                        return item;
                    }
                    else {
                        return null;
                    }
                }
                else return null;
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