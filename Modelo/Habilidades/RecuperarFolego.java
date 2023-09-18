import java.lang.Math;

public class RecuperarFolego extends Habilidade{
    
    public RecuperarFolego(){
        super("Recuperar Fôlego", "Você respira fundo, recuperando suas forças vitais.");
    }

    protected boolean habilidadeAtiva(Personagem usuario) {
        int cura = (int)(Math.random() * 16) + 2;
        usuario.setVida(usuario.getVida()+cura);
        return true;
    }

}