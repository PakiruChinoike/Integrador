import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Personagem_ItemDAO{

    private ConexaoMYSQL conexao;

    public Personagem_ItemDAO() {
		this.conexao = new ConexaoMYSQL();
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

            ItemDAO itemDAO = new ItemDAO();
            if (rs.next()) {
                long id_item = rs.getLong("id_item");
                Item item = itemDAO.buscar(id_item);

                return item;
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