import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MonstroDAO {

    private ConexaoMYSQL conexao;

    public MonstroDAO() {
		this.conexao = new ConexaoMYSQL("localhost", "3306", "root", "root", "bd_comunicacao_java_mysql_2i_2023");
	}

    public void salvar(Monstro monstro) {
        try {
            this.conexao.abrirConexao();
            String sql = "INSERT INTO monstro VALUES(null, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setString(1, monstro.getNome());
            statement.setInt(2, monstro.getNivel());
            statement.setInt(3, monstro.getVida());
            statement.setInt(4, monstro.getArmadura());
            statement.executeUpdate();

            String sql2 = "UPDATE atributos SET agilidade=?, forca=?, inteligencia=? WHERE id_monstro=?";
            PreparedStatement statement2 = this.conexao.getConexao().prepareStatement(sql2);
            statement2.setInt(1, monstro.getAtributos(0));
            statement2.setInt(2, monstro.getAtributos(1));
            statement2.setInt(3, monstro.getAtributos(3));
            statement2.setLong(4, monstro.getId());

            String sql3 = "UPDATE fraquezas SET flamejante=?, congelante=?, eletrico=?, fisico=?, arcano=? WHERE id_monstro=?";
            PreparedStatement statement3 = this.conexao.getConexao().prepareStatement(sql3);
            statement3.setBoolean(1, monstro.getFraquezas(0));
            statement3.setBoolean(2, monstro.getFraquezas(1));
            statement3.setBoolean(3, monstro.getFraquezas(2));
            statement3.setBoolean(4, monstro.getFraquezas(3));
            statement3.setBoolean(5, monstro.getFraquezas(4));
            statement3.setLong(6, monstro.getId());
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
    }

    public void editar(Monstro monstro) {
        try {
            this.conexao.abrirConexao();
            String sql = "UPDATE monstro SET nome=?, classe=?, vida=?, armadura=?, poder=?, nivel=?, experiencia=? WHERE id_monstro=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setString(1, monstro.getNome());
            statement.setInt(2, monstro.getNivel());
            statement.setInt(3, monstro.getVida());
            statement.setInt(4, monstro.getArmadura());
            statement.setLong(7, monstro.getId());
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
            String sql = "DELETE FROM monstro WHERE id_monstro=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
    }

    public Monstro buscar(long id) {
        try {
            this.conexao.abrirConexao();
            String sql = "SELECT * FROM monstro WHERE id_monstro=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Monstro monstro = new Monstro(rs.getString("nome"), rs.getInt("vida"), rs.getInt("armadura"), rs.getInt("nivel"));
                return monstro;
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

    public List<Monstro> buscarTodos() {
        try {
            this.conexao.abrirConexao();
            String sql = "SELECT * FROM monstro";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            List<Monstro> listaMonstros = new ArrayList<Monstro>();
            while (rs.next()) {
                Monstro monstro = new Monstro(rs.getString("nome"), rs.getInt("vida"), rs.getInt("armadura"), rs.getInt("nivel"));                
                listaMonstros.add(monstro);
            }
            return listaMonstros;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            this.conexao.fecharConexao();
        }
    }

}