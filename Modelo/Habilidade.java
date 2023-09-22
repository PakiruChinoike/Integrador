public abstract class Habilidade {

    protected int id;
    protected String nome;
    protected String descricao;

    public Habilidade(int id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public abstract boolean habilidadeAtiva();

    public static int personagemHabilidade(int id, Personagem usuario, Inimigo alvo) {
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

    public static int monstroHabilidade(int id, Inimigo usuario, Personagem alvo) {
        switch(id) {
            case 5: {
                return Garras.habilidadeAtiva(usuario, alvo);
            }
            default: {
                return 0;
            }
        }
    }

}
