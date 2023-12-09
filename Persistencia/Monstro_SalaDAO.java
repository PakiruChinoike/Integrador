import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Monstro_SalaDAO{

    private ConexaoMYSQL conexao;

    public Monstro_SalaDAO() {
		this.conexao = new ConexaoMYSQL();
    }

    public void salvar(Monstro monstro, Sala sala) {
        try {
            this.conexao.abrirConexao();
            String sql = "INSERT INTO monstro_sala VALUES(null, ?, ?)";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, monstro.getId());
            statement.setLong(2, sala.getId());
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
            String sql = "DELETE FROM monstro_sala WHERE id_monstro_sala=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
    }

    public Monstro buscarMonstro(long id) {
        try {
            this.conexao.abrirConexao();
            String sql = "SELECT * FROM monstro_sala WHERE id_sala=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();

            MonstroDAO monstroDao = new MonstroDAO();

            if (rs.next()) {
                Monstro monstro = monstroDao.buscar(rs.getLong("id_monstro"));
                return monstro;
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