import java.util.ArrayList;

public abstract class Habilidade {

    protected int id;
    protected String nome;
    protected String descricao;

    public Habilidade(int id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
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
