import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MonstroDAO {

    private ConexaoMYSQL conexao;

    public MonstroDAO() {
		this.conexao = new ConexaoMYSQL();
	}

    public long salvar(Monstro monstro) {
        try {
            this.conexao.abrirConexao();
            String sql = "INSERT INTO monstro VALUES(null, ?, ?, ?, ?, ?)";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setString(1, monstro.getNome());
            statement.setInt(2, monstro.getVida());
            statement.setInt(3, monstro.getArmadura());
            statement.setInt(4, monstro.getNivel());
            statement.setLong(5, monstro.getEquipe());
            statement.executeUpdate();

            String sql0 = "SELECT id_monstro FROM monstro ORDER BY id_monstro DESC LIMIT 1";
            PreparedStatement statement0 = this.conexao.getConexao().prepareStatement(sql0);
            ResultSet rs0 = statement0.executeQuery();

            if (rs0.next()) {
                long id_monstro = rs0.getLong("id_monstro");

            String sql2 = "INSERT INTO atributos VALUES(null, ?, ?, ?, null, ?)";
            PreparedStatement statement2 = this.conexao.getConexao().prepareStatement(sql2);
            statement2.setInt(1, monstro.getAtributos(0));
            statement2.setInt(2, monstro.getAtributos(1));
            statement2.setInt(3, monstro.getAtributos(2));
            statement2.setLong(4, id_monstro);
            statement2.executeUpdate();

            String sql3 = "INSERT INTO fraquezas VALUES(null, ?, ?, ?, ?, ?, null, ?)";
            PreparedStatement statement3 = this.conexao.getConexao().prepareStatement(sql3);
            statement3.setBoolean(1, monstro.getFraquezas(0));
            statement3.setBoolean(2, monstro.getFraquezas(1));
            statement3.setBoolean(3, monstro.getFraquezas(2));
            statement3.setBoolean(4, monstro.getFraquezas(3));
            statement3.setBoolean(5, monstro.getFraquezas(4));
            statement3.setLong(6, id_monstro);
            statement3.executeUpdate();

            for (int i = 0; i<monstro.getHabilidades().size(); i++) {
                String sql4 = "INSERT INTO monstro_habilidade VALUES(null, ?, ?)";
                PreparedStatement statement4 = this.conexao.getConexao().prepareStatement(sql4);
                statement4.setLong(1, id_monstro);
                statement4.setLong(2, monstro.getHabilidade(i).getId());
                statement4.executeUpdate();
            }

            return id_monstro;
        }
        else {
            return (Long)null;
        }

        } catch(SQLException e) {
            e.printStackTrace();
            return (Long)null;
        } finally {
            this.conexao.fecharConexao();
        }
    }

    public void editar(Monstro monstro) {
        try {
            this.conexao.abrirConexao();
            String sql = "UPDATE monstro SET nome=?, classe=?, vida=?, armadura=?, nivel=?, equipe=? WHERE id_monstro=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setString(1, monstro.getNome());
            statement.setInt(2, monstro.getNivel());
            statement.setInt(3, monstro.getVida());
            statement.setInt(4, monstro.getArmadura());
            statement.setLong(5, monstro.getEquipe());
            statement.setLong(6, monstro.getId());
            statement.executeUpdate();

            String sql2 = "UPDATE atributos SET agilidade=?, forca=?, inteligencia=? WHERE id_monstro=?";
            PreparedStatement statement2 = this.conexao.getConexao().prepareStatement(sql2);
            statement2.setInt(1, monstro.getAtributos(0));
            statement2.setInt(2, monstro.getAtributos(1));
            statement2.setInt(3, monstro.getAtributos(3));
            statement2.setLong(4, monstro.getId());
            statement2.executeUpdate();

            String sql3 = "UPDATE fraquezas SET flamejante=?, congelante=?, eletrico=?, fisico=?, arcano=? WHERE id_monstro=?";
            PreparedStatement statement3 = this.conexao.getConexao().prepareStatement(sql3);
            statement3.setBoolean(1, monstro.getFraquezas(0));
            statement3.setBoolean(2, monstro.getFraquezas(1));
            statement3.setBoolean(3, monstro.getFraquezas(2));
            statement3.setBoolean(4, monstro.getFraquezas(3));
            statement3.setBoolean(5, monstro.getFraquezas(4));
            statement3.setLong(6, monstro.getId());
            statement3.executeUpdate();

            for (int i = 0; i<monstro.getHabilidades().size(); i++) {
                String sql4 = "UPDATE monstro_habilidade SET id_habilidade=? WHERE id_monstro=?";
                PreparedStatement statement4 = this.conexao.getConexao().prepareStatement(sql4);
                statement4.setLong(1, monstro.getHabilidade(i).getId()); 
                statement4.setLong(2, monstro.getId());
                statement4.executeUpdate();
            }

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
                Monstro monstro = new Monstro(rs.getString("nome"), rs.getInt("vida"), rs.getInt("armadura"), rs.getInt("nivel"), rs.getInt("experiencia"), rs.getLong("equipe"));

                String sql2 = "SELECT * FROM monstro_habilidade WHERE id_monstro=?";
                PreparedStatement statement2 = this.conexao.getConexao().prepareStatement(sql2);
                statement2.setLong(1, id);
                ResultSet rs2 = statement2.executeQuery();

                Monstro_HabilidadeDAO monstro_habilidadeDao = new Monstro_HabilidadeDAO();

                while (rs2.next()) {
                    monstro.addHabilidade(monstro_habilidadeDao.buscarHabilidade(id));
                }

                String sql3 = "SELECT * FROM atributos WHERE id_monstro=?";
                PreparedStatement statement3 = this.conexao.getConexao().prepareStatement(sql3);
                statement3.setLong(1, id);
                ResultSet rs3 = statement3.executeQuery();

                List<Integer> listaAtributos = new ArrayList<Integer>();

                if (rs3.next()) {
                    listaAtributos.add(rs3.getInt("agilidade"));
                    listaAtributos.add(rs3.getInt("forca"));
                    listaAtributos.add(rs3.getInt("inteligencia"));

                    monstro.setAtributos(listaAtributos);
                }

                String sql4 = "SELECT * FROM fraquezas WHERE id_monstro=?";
                PreparedStatement statement4 = this.conexao.getConexao().prepareStatement(sql4);
                statement4.setLong(1, id);
                ResultSet rs4 = statement4.executeQuery();

                List<Boolean> listaFraquezas = new ArrayList<Boolean>();

                if (rs4.next()) {
                    listaFraquezas.add(rs4.getBoolean("flamejante"));
                    listaFraquezas.add(rs4.getBoolean("congelante"));
                    listaFraquezas.add(rs4.getBoolean("eletrico"));
                    listaFraquezas.add(rs4.getBoolean("fisico"));
                    listaFraquezas.add(rs4.getBoolean("arcano"));

                    monstro.setFraquezas(listaFraquezas);
                }

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
                Monstro monstro = new Monstro(rs.getString("nome"), rs.getInt("vida"), rs.getInt("armadura"), rs.getInt("nivel"), rs.getInt("experiencia"), rs.getLong("equipe"));                
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