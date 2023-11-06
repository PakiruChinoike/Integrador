import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO{

    private ConexaoMYSQL conexao;

    public ItemDAO() {
		this.conexao = new ConexaoMYSQL("localhost", "3306", "root", "root", "bd_comunicacao_java_mysql_2i_2023");
    }

    public void salvar(Item item) {
        try {
            this.conexao.abrirConexao();
            String sql = "INSERT INTO item VALUES(null, ?, ?, ?)";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setString(1, item.getNome());
            statement.setInt(2, item.getRaridade());
            statement.setLong(3, item.getHabilidade().getId());
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
    }

    public void editar(Item item) {
        try {
            this.conexao.abrirConexao();
            String sql = "UPDATE item SET nome=?, raridade=?, id_habilidade=? WHERE id_item=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setString(1, item.getNome());
            statement.setInt(2, item.getRaridade());
            statement.setLong(3, item.getHabilidade().getId());
            statement.setLong(4, item.getId());
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
            String sql = "DELETE FROM item WHERE id_item=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
    }

    public Item buscar(long id) {
        try {
            this.conexao.abrirConexao();
            String sql = "SELECT * FROM item WHERE id_item=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Item item = new Item();
                return item;
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

    public List<Item> buscarTodos() {
        try {
            this.conexao.abrirConexao();
            String sql = "SELECT * FROM item";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            List<Item> listaPersonagens = new ArrayList<Item>();
            while (rs.next()) {
                Item item = new Item();
                listaPersonagens.add(item);
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