import java.lang.Math;

public class RecuperarFolego extends Habilidade{
    
    public RecuperarFolego(){
        super(4, "Recuperar Fôlego", "Você respira fundo, recuperando suas forças vitais.");
    }

    protected static int habilidadeAtiva(Personagem usuario) {
        int cura = (int)(Math.random() * 16) + 2;
        usuario.setVida((usuario.getVida())+cura);
        return 10;
    }

}