import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecompensaDAO {

private ConexaoMYSQL conexao;

    public RecompensaDAO(){
        this.conexao = new ConexaoMYSQL("localhost", "3306", "root", "1237353h", "CatacombsIntegrador");
    }

    public long salvar(Recompensa recompensa) {
        try{
            this.conexao.abrirConexao();
            String sql = "INSERT INTO recompensa VALUES(null, ?, ?, ?, ?, ?)";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setInt(1, recompensa.getTipo());
            statement.setInt(2, recompensa.getExperiencia());
            statement.setInt(3, recompensa.getRaridade());

            if(recompensa.getHabilidade()!=null) {
                statement.setLong(4, recompensa.getHabilidade().getId());
            }
            else {
                statement.setRef(4, null);
            }

            if(recompensa.getItem()!=null){
                statement.setLong(5, recompensa.getItem().getId());
            }
            else {
                statement.setRef(5, null);
            }

            statement.executeUpdate();

            String sql0 = "SELECT * FROM recompensa ORDER BY id_recompensa DESC LIMIT 1";
            PreparedStatement statement0 = this.conexao.getConexao().prepareStatement(sql0);
            ResultSet rs0 = statement0.executeQuery();

            if (rs0.next()) {
                long id_recompensa = rs0.getLong("id_recompensa");
                return id_recompensa;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return (Long)null;
        }
        finally {
            this.conexao.fecharConexao();
            return (Long)null;
        }
    }

    public void editar(Recompensa recompensa) {
        try {
            this.conexao.abrirConexao();
            String sql = "UPDATE recompensa SET tipo=?, experiencia=?, raridade=?, id_habilidade=?, id_item=? WHERE id_recompensa=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setInt(1, recompensa.getTipo());
            statement.setInt(2, recompensa.getExperiencia());
            statement.setInt(3, recompensa.getRaridade());
            statement.setLong(4, recompensa.getHabilidade().getId());
            statement.setLong(5, recompensa.getItem().getId());
            statement.setLong(6, recompensa.getId());
            statement.executeUpdate();
        } 
        catch (SQLException e) {
            e.printStackTrace();
        } 
        finally {
            this.conexao.fecharConexao();
        }
    }

    public Recompensa buscar(long id) {
        try {
            this.conexao.abrirConexao();
            String sql = "SELECT * FROM recompensa WHERE id_recompensa=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();

            if(rs.next()) {
                Recompensa recompensa = new Recompensa(rs.getInt("tipo"), rs.getInt("raridade"), rs.getInt("experiencia"));
                recompensa.setId(rs.getLong("id_recompensa"));
            }
        }
    }

    public void excluir(long id) {

    }
}