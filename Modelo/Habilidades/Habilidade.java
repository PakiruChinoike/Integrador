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

    public static int usaHabilidade(int id, Personagem usuario, Monstro alvo) {
        switch(id) {
            case 1: {
                return Golpeada.habilidadeAtiva(usuario, alvo);
            }
            case 2: {
                return Bloquear.habilidadeAtiva(usuario);
            }
            case 4: {
                return RecuperarFolego.habilidadeAtiva(usuario);
            }
            default: {
                return 0;
            }
        }
    }

    public static int usaHabilidade(int id, Personagem usuario, ArrayList<Monstro> alvos) {
        switch(id) {
            case 3: {
                return AtaquePesado.habilidadeAtiva(usuario, alvos);
            }
            default: {
                return 0;
            }
        }
    }

    public static int usaHabilidade(int id, Monstro usuario, Personagem alvo) {
        switch(id) {
            case 13: {
                return Garras.habilidadeAtiva(usuario, alvo);
            }
            default: {
                return 0;
            }
        }
    }

    public static int usaHabilidade(int id, Monstro usuario, ArrayList<Personagem> alvos) {
        switch(id) {
            default: {
                return 0;
            }
        }
    }

}
