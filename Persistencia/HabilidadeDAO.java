import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HabilidadeDAO {

    private ConexaoMYSQL conexao;

    public HabilidadeDAO() {
		this.conexao = new ConexaoMYSQL("localhost", "3306", "root", "root", "bd_comunicacao_java_mysql_2i_2023");
	}

    public void salvar(Habilidade habilidade) {
        try {
            this.conexao.abrirConexao();
            String sql = "INSERT INTO habilidade VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setString(1, habilidade.getNome());
            statement.setInt(2, habilidade.getTipo());
            statement.setString(3, habilidade.getDescricao());
            statement.setInt(4, habilidade.getMaxRoll());
            statement.setInt(5, habilidade.getMinRoll());
            statement.setInt(6, habilidade.getTipoDano());
            statement.setLong(7, habilidade.getAtributo());
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
    }

    public void editar(Habilidade habilidade) {
        try {
            this.conexao.abrirConexao();
            String sql = "UPDATE habilidade SET nome=?, classe=?, vida=?, armadura=?, poder=?, nivel=?, experiencia=? WHERE id_habilidade=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setString(1, habilidade.getNome());
            statement.setInt(2, habilidade.getTipo());
            statement.setString(3, habilidade.getDescricao());
            statement.setInt(4, habilidade.getMaxRoll());
            statement.setInt(5, habilidade.getMinRoll());
            statement.setInt(6, habilidade.getTipoDano());
            statement.setLong(7, habilidade.getAtributo());
            statement.setLong(8, habilidade.getId());
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
            String sql = "DELETE FROM habilidade WHERE id_habilidade=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
    }

    public Habilidade buscar(long id) {
        try {
            this.conexao.abrirConexao();
            String sql = "SELECT * FROM habilidade WHERE id_habilidade=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Habilidade habilidade = new Habilidade();
                return habilidade;
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

    public List<Habilidade> buscarTodos() {
        try {
            this.conexao.abrirConexao();
            String sql = "SELECT * FROM habilidade";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            List<Habilidade> listaPersonagens = new ArrayList<Habilidade>();
            while (rs.next()) {
                Habilidade habilidade = new Habilidade();
                listaPersonagens.add(habilidade);
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