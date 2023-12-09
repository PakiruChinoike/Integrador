import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecompensaDAO {

private ConexaoMYSQL conexao;

    public RecompensaDAO(){
        this.conexao = new ConexaoMYSQL();
    }

    public long salvar(Recompensa recompensa) {
        try{
            this.conexao.abrirConexao();

            if (recompensa.getTipo()==3) {
                String sql = "INSERT INTO recompensa VALUES(null, ?, ?, ?, ?)";
                PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
                statement.setInt(1, recompensa.getTipo());
                statement.setInt(2, recompensa.getExperiencia());
                statement.setLong(3, recompensa.getItem().getId());
                statement.setLong(4, recompensa.getHabilidade().getId());
                statement.executeUpdate();
            }
            else if (recompensa.getTipo()==2) {
                String sql = "INSERT INTO recompensa VALUES(null, ?, ?, null, ?)";
                PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
                statement.setInt(1, recompensa.getTipo());
                statement.setInt(2, recompensa.getExperiencia());
                statement.setLong(3, recompensa.getHabilidade().getId());
                statement.executeUpdate();
            }
            else if (recompensa.getTipo()==1) {
                String sql = "INSERT INTO recompensa VALUES(null, ?, ?, ?, null)";
                PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
                statement.setInt(1, recompensa.getTipo());
                statement.setInt(2, recompensa.getExperiencia());
                statement.setLong(3, recompensa.getItem().getId());
                statement.executeUpdate();
            }
            else {
                String sql = "INSERT INTO recompensa VALUES(null, ?, ?, null, null)";
                PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
                statement.setInt(1, recompensa.getTipo());
                statement.setInt(2, recompensa.getExperiencia());
                statement.executeUpdate();
            }

            String sql0 = "SELECT * FROM recompensa ORDER BY id_recompensa DESC LIMIT 1";
            PreparedStatement statement0 = this.conexao.getConexao().prepareStatement(sql0);
            ResultSet rs0 = statement0.executeQuery();

            rs0.next();
            long id_recompensa = rs0.getLong("id_recompensa");
            return id_recompensa;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        finally {
            this.conexao.fecharConexao();
        }
    }

    public void editar(Recompensa recompensa) {
        try {
            this.conexao.abrirConexao();

            if (recompensa.getTipo()==3) {
                String sql = "UPDATE recompensa SET tipo=?, experiencia=?, id_habilidade=?, id_item=? WHERE id_recompensa=?";
                PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
                statement.setInt(1, recompensa.getTipo());
                statement.setInt(2, recompensa.getExperiencia());
                statement.setLong(3, recompensa.getHabilidade().getId());
                statement.setLong(4, recompensa.getItem().getId());
                statement.setLong(5, recompensa.getId());
                statement.executeUpdate();
            }
            else if (recompensa.getTipo()==2) {
                String sql = "UPDATE recompensa SET tipo=?, experiencia=?, id_habilidade=? WHERE id_recompensa=?";
                PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
                statement.setInt(1, recompensa.getTipo());
                statement.setInt(2, recompensa.getExperiencia());
                statement.setLong(3, recompensa.getHabilidade().getId());
                statement.setLong(4, recompensa.getId());
                statement.executeUpdate();
            }
            else if (recompensa.getTipo()==1) {
                String sql = "UPDATE recompensa SET tipo=?, experiencia=?, id_item=? WHERE id_recompensa=?";
                PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
                statement.setInt(1, recompensa.getTipo());
                statement.setInt(2, recompensa.getExperiencia());
                statement.setLong(3, recompensa.getItem().getId());
                statement.setLong(4, recompensa.getId());
                statement.executeUpdate();
            }
            else {
                String sql = "UPDATE recompensa SET tipo=?, experiencia=? WHERE id_recompensa=?";
                PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
                statement.setInt(1, recompensa.getTipo());
                statement.setInt(2, recompensa.getExperiencia());
                statement.setLong(3, recompensa.getId());
                statement.executeUpdate();
            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
        } 
        finally {
            this.conexao.fecharConexao();
        }
    }

    public void excluir(long id) {
        try {
            this.conexao.abrirConexao();
            String sql = "DELETE FROM recompensa WHERE id_recompensa=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
                Recompensa recompensa = new Recompensa(rs.getInt("tipo"), rs.getInt("experiencia"));
                recompensa.setId(rs.getLong("id_recompensa"));

                switch (rs.getInt("tipo")) {
                    case 1: {
                        ItemDAO itemDAO = new ItemDAO();
                        recompensa.setItem(itemDAO.buscar(rs.getLong("id_item")));
                        return recompensa;
                    }
                    case 2: {
                        HabilidadeDAO habilidadeDAO = new HabilidadeDAO();
                        recompensa.setHabilidade(habilidadeDAO.buscar(rs.getLong("id_habilidade")));
                        return recompensa;
                    }
                    case 3: {
                        ItemDAO itemDAO = new ItemDAO();
                        HabilidadeDAO habilidadeDAO = new HabilidadeDAO();
                        recompensa.setItem(itemDAO.buscar(rs.getLong("id_item")));
                        recompensa.setHabilidade(habilidadeDAO.buscar(rs.getLong("id_habilidade")));
                        return recompensa;
                    }
                    default: {
                        return recompensa;
                    }
                }
            }
            else {
                return null;
            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        finally {
            conexao.fecharConexao();
        }
    }
}