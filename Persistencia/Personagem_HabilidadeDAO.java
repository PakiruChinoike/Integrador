import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Personagem_HabilidadeDAO{

    private static ConexaoMYSQL conexao;

    public Personagem_HabilidadeDAO() {
		this.conexao = new ConexaoMYSQL("localhost", "3306", "root", "root", "CatacombsIntegrador");
    }

    public void salvar(Personagem personagem, Habilidade habilidade) {
        try {
            this.conexao.abrirConexao();
            String sql = "INSERT INTO personagem_habilidade VALUES(null, ?, ?)";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, personagem.getId());
            statement.setLong(2, habilidade.getId());
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
            String sql = "DELETE FROM personagem_habilidade WHERE id_personagem_habilidade=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
    }

    public static long buscarPersonagem(long id) {
        try {
            conexao.abrirConexao();
            String sql = "SELECT id_personagem FROM personagem_habilidade WHERE id_personagem_habilidade=?";
            PreparedStatement statement = conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                long id_personagem = rs.getLong("id_personagem");
                return id_personagem;
            }   
            else {
                return (Long)null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return (Long)null;
        } finally {
            conexao.fecharConexao();
        }
    }

    public static Habilidade buscarHabilidade(long id) {
        try {
            conexao.abrirConexao();
            String sql = "SELECT id_habilidade FROM personagem_habilidade WHERE id_personagem=?";
            PreparedStatement statement = conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                long id_habilidade = rs.getLong("id_habilidade");
                
                String sql2 = "SELECT * FROM  WHERE id_habilidade=?";
                PreparedStatement statement2 = conexao.getConexao().prepareStatement(sql2);
                statement.setLong(1, id_habilidade);
                ResultSet rs2 = statement2.executeQuery();

                if(rs2.next()) {
                    int tipo = rs.getInt("tipo");
                        switch (tipo) {
                            case 0: {
                                Habilidade habilidade = new Ataque(id_habilidade, rs2.getString("nome"), rs2.getString("descricao"), rs2.getInt("max_roll"), rs2.getInt("min_roll"), rs2.getInt("tipo_dano"), rs2.getInt("atributo"));
                                return habilidade;
                            }
                            case 1: {
                                Habilidade habilidade = new Resistencia(id_habilidade, rs2.getString("nome"), rs2.getString("descricao"), rs2.getInt("max_roll"), rs2.getInt("min_roll"), rs2.getInt("min_teste"), rs2.getInt("tipo_dano"), rs2.getInt("atributo"));
                                return habilidade;
                            }
                            case 2: {
                                Habilidade habilidade = new Garantido(id_habilidade, rs2.getString("nome"), rs2.getString("descricao"), rs2.getInt("max_roll"), rs2.getInt("min_roll"), rs2.getInt("tipo_dano"));
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