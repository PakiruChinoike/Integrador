import java.util.ArrayList;

public abstract class Habilidade {

    private int id;
    private String nome;
    private String descricao;
    private int dano;

    protected Habilidade(int id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    protected Habilidade(int id, String nome, String descricao, int dano) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dano = dano;
    }

    public int habilidadeAtiva() {
        return 0;
    }

    public static int usaHabilidade(int id, Personagem usuario, ArrayList<Monstro> inimigos, int alvo) {
        switch(id) {
            case 1: {
                return Golpeada.habilidadeAtiva(usuario, inimigos, alvo);
            }
            case 2: {
                return Bloquear.habilidadeAtiva(usuario);
            }
            case 3: {
                return AtaquePesado.habilidadeAtiva(usuario, inimigos);
            }
            case 4: {
                return RecuperarFolego.habilidadeAtiva(usuario);
            }
            default: {
                return 0;
            }
        }
    }

    public static int usaHabilidade(int id, Monstro usuario, Personagem inimigos) {
        switch(id) {
            case 13: {
                return Garras.habilidadeAtiva(usuario, inimigos);
            }
            default: { 
                return 0;
            }
        }
    }

}
