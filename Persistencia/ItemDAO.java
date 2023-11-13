import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO{

    private ConexaoMYSQL conexao;

    public ItemDAO() {
		this.conexao = new ConexaoMYSQL("localhost", "3306", "root", "Bufalovictor!8", "CatacombsIntegrador");
    }

    public long salvar(Item item) {
        try {
            this.conexao.abrirConexao();
            String sql = "INSERT INTO item VALUES(null, ?, ?, ?)";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setString(1, item.getNome());
            statement.setInt(2, item.getRaridade());
            statement.setLong(3, item.getHabilidade().getId());
            statement.executeUpdate();

            String sql0 = "SELECT id_item FROM item ORDER BY id_item DESC LIMIT 1";
            PreparedStatement statement0 = this.conexao.getConexao().prepareStatement(sql0);
            ResultSet rs0 = statement0.executeQuery();
            long id_item = rs0.getLong("id_item");
            return id_item;

        } catch(SQLException e) {
            e.printStackTrace();
            return (Long)null;
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
                String sql2 = "SELECT * FROM habilidade WHERE id_habilidade=?";
                PreparedStatement statement2 = this.conexao.getConexao().prepareStatement(sql2);
                statement2.setLong(1, rs.getLong("id_habilidade"));
                ResultSet rs2 = statement.executeQuery();
                
                if (rs2.next()) {
                    HabilidadeDAO habilidadeDao = new HabilidadeDAO();
                    Habilidade habilidade = habilidadeDao.buscar(rs2.getLong("id_habilidade"));

                    Item item = new Item(rs.getString("nome"), rs.getInt("raridade"), habilidade);
                    return item;
                }
                else {
                    return null;
                }
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
            List<Item> listaItens = new ArrayList<Item>();
            while (rs.next()) {
                String sql2 = "SELECT * FROM habilidade WHERE id_habilidade=?";
                PreparedStatement statement2 = this.conexao.getConexao().prepareStatement(sql2);
                statement2.setLong(1, rs.getLong("id_habilidade"));
                ResultSet rs2 = statement.executeQuery();
                
                if (rs2.next()) {
                    HabilidadeDAO habilidadeDao = new HabilidadeDAO();
                    Habilidade habilidade = habilidadeDao.buscar(rs2.getLong("id_habilidade"));

                    Item item = new Item(rs.getString("nome"), rs.getInt("raridade"), habilidade);
                    listaItens.add(item);
                }
            }
            return listaItens;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            this.conexao.fecharConexao();
        }
    }

}