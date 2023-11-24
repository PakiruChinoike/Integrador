import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HabilidadeDAO {

    private ConexaoMYSQL conexao;

    public HabilidadeDAO() {
		this.conexao = new ConexaoMYSQL("localhost", "3306", "root", "Pipoka!821", "CatacombsIntegrador");
	}

    public long salvar(Habilidade habilidade) {
        try {
            this.conexao.abrirConexao();
            String sql = "INSERT INTO habilidade VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setString(1, habilidade.getNome());
            statement.setInt(2, habilidade.getTipo());
            statement.setString(3, habilidade.getDescricao());
            statement.setInt(4, habilidade.getMaxRoll());
            statement.setInt(5, habilidade.getMinRoll());
            statement.setInt(6, habilidade.getMinTeste());
            statement.setInt(7, habilidade.getTipoDano());
            statement.setLong(8, habilidade.getAtributo());
            statement.executeUpdate();

            String sql0 = "SELECT id_habilidade FROM habilidade ORDER BY id_habilidade DESC LIMIT 1";
            PreparedStatement statement0 = this.conexao.getConexao().prepareStatement(sql0);
            ResultSet rs0 = statement0.executeQuery();
            long id_habilidade = rs0.getLong("id_habilidade");
            return id_habilidade;

        } catch(SQLException e) {
            e.printStackTrace();
            return (Long)null;
        } finally {
            this.conexao.fecharConexao();
        }
    }

    public void editar(Habilidade habilidade) {
        try {
            this.conexao.abrirConexao();
            String sql = "UPDATE habilidade SET nome=?, tipo=?, descricao=?, max_roll=?, min_roll=?, min_test=?, tipo_dano=?, atributo=? WHERE id_habilidade=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setString(1, habilidade.getNome());
            statement.setInt(2, habilidade.getTipo());
            statement.setString(3, habilidade.getDescricao());
            statement.setInt(4, habilidade.getMaxRoll());
            statement.setInt(5, habilidade.getMinRoll());
            statement.setInt(6, habilidade.getMinTeste());
            statement.setInt(7, habilidade.getTipoDano());
            statement.setLong(8, habilidade.getAtributo());
            statement.setLong(9, habilidade.getId());
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
                int tipo = rs.getInt("tipo");
                switch (tipo) {
                    case 0: {
                        Habilidade habilidade = new Ataque(id, rs.getString("nome"), rs.getString("descricao"), rs.getInt("max_roll"), rs.getInt("min_roll"), rs.getInt("tipo_dano"), rs.getInt("atributo"), rs.getInt("custo"));
                        return habilidade;
                    }
                    case 1: {
                        Habilidade habilidade = new Resistencia(id, rs.getString("nome"), rs.getString("descricao"), rs.getInt("max_roll"), rs.getInt("min_roll"), rs.getInt("min_teste"), rs.getInt("tipo_dano"), rs.getInt("atributo"), rs.getInt("custo"));
                        return habilidade;
                    }
                    case 2: {
                        Habilidade habilidade = new Garantido(id, rs.getString("nome"), rs.getString("descricao"), rs.getInt("max_roll"), rs.getInt("min_roll"), rs.getInt("tipo_dano"), rs.getInt("custo"));
                        return habilidade;
                    }
                    default: {
                        return null;
                    }
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

    public List<Habilidade> buscarTodos() {
        try {
            this.conexao.abrirConexao();
            String sql = "SELECT * FROM habilidade";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            List<Habilidade> listaPersonagens = new ArrayList<Habilidade>();
            while (rs.next()) {
                int tipo = rs.getInt("tipo");
                switch (tipo) {
                    case 0: {
                        Habilidade habilidade = new Ataque();
                        listaPersonagens.add(habilidade);
                        break;
                    }
                    case 1: {
                        Habilidade habilidade = new Resistencia();
                        listaPersonagens.add(habilidade);
                        break;
                    }
                    case 2: {
                        Habilidade habilidade = new Garantido();
                        listaPersonagens.add(habilidade);
                        break;
                    }
                    default: {
                        break;
                    }
                }
            return listaPersonagens;
            } 
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            this.conexao.fecharConexao();
        }
        return null;

    }

}