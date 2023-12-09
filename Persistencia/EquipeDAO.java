import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipeDAO {
    
    private ConexaoMYSQL conexao;

    public EquipeDAO() {
        this.conexao = new ConexaoMYSQL();
    }

    public long salvar(Equipe equipe) {
        try {
            this.conexao.abrirConexao();

            if (equipe.get(0)!=null) {
                String sql = "INSERT INTO equipe VALUES(?, ?, ?, ?)";
                PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
                statement.setLong(1, equipe.getId());
                statement.setLong(2, ((Personagem)equipe.get(0)).getId());
                statement.setLong(3, ((Personagem)equipe.get(1)).getId());
                statement.setLong(4, ((Personagem)equipe.get(2)).getId());
                statement.executeUpdate();
            }
            else {
                String sql = "INSERT INTO equipe VALUES(?, null, null, null)";
                PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
                statement.setLong(1, equipe.getId());
            }

            String sql0 = "SELECT id_equipe FROM equipe ORDER BY id_equipe DESC LIMIT 1";
            PreparedStatement statement0 = this.conexao.getConexao().prepareStatement(sql0);
            ResultSet rs0 = statement0.executeQuery();

            rs0.next();
            long id_equipe = rs0.getLong("id_equipe");
            return id_equipe;

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.conexao.fecharConexao();
        }
    }

    public void editar(Equipe equipe) {
        try {
            this.conexao.abrirConexao();
            String sql = "UPDATE equipe SET id_personagem1=?, id_personagem2=?, id_personagem3=? WHERE id_equipe=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, ((Personagem)equipe.get(0)).getId());
            statement.setLong(2, ((Personagem)equipe.get(1)).getId());
            statement.setLong(3, ((Personagem)equipe.get(2)).getId());
            statement.setLong(4, equipe.getId());
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
            String sql = "DELETE FROM equipe WHERE id_equipe=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
    }

    public Equipe buscar(long id) {
        try {
            this.conexao.abrirConexao();
            String sql = "SELECT * FROM equipe WHERE id_equipe=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                PersonagemDAO personagemDAO = new PersonagemDAO();

                Criatura personagem1 = personagemDAO.buscar(rs.getLong("id_personagem1"));
                Criatura personagem2 = personagemDAO.buscar(rs.getLong("id_personagem2"));
                Criatura personagem3 = personagemDAO.buscar(rs.getLong("id_personagem3"));

                List<Criatura> listaPersonagens = new ArrayList<Criatura>();
                listaPersonagens.add(personagem1);
                listaPersonagens.add(personagem2);
                listaPersonagens.add(personagem3);

                Equipe equipe = new Equipe(id, listaPersonagens);
                return equipe;
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

}
