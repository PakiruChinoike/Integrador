import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalaDAO {

    private ConexaoMYSQL conexao;

    public SalaDAO() {
		this.conexao = new ConexaoMYSQL("localhost", "3306", "root", "root", "bd_comunicacao_java_mysql_2i_2023");
    }

    public void salvar(Sala sala) {
        try {
            this.conexao.abrirConexao();
            String sql = "INSERT INTO sala VALUES(null, ?, ?)";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setString(1, sala.getNome());
            statement.setInt(2, sala.getTipo());
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
    }

    public void editar(Sala sala) {
        try {
            this.conexao.abrirConexao();
            String sql = "UPDATE sala SET nome=?, tipo=? WHERE id_sala=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setString(1, sala.getNome());
            statement.setInt(2, sala.getTipo());
            statement.setLong(8, sala.getId());
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
            String sql = "DELETE FROM sala WHERE id_sala=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
    }

    public Sala buscar(long id) {
        try {
            this.conexao.abrirConexao();
            String sql = "SELECT * FROM sala WHERE id_sala=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Sala sala = new Sala();
                return sala;
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

    public List<Sala> buscarTodos() {
        try {
            this.conexao.abrirConexao();
            String sql = "SELECT * FROM sala";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            List<Sala> listaPersonagens = new ArrayList<Sala>();
            while (rs.next()) {
                Sala sala = new Sala();
                listaPersonagens.add(sala);
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