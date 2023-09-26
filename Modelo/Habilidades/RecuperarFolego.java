import java.lang.Math;

public final class RecuperarFolego extends Habilidade{
    
    private static int id;
    private static String nome;
    private static String descricao;

    public RecuperarFolego(){
        id = 4;
        nome = "Recuperar Fôlego";
        descricao = "Você respira fundo e trata de seus ferimentos";
    }

    protected static int habilidadeAtiva(Personagem usuario) {
        int cura = (int)(Math.random() * 16) + 2;
        usuario.setVida((usuario.getVida())+cura);
        return 10;
    }

}