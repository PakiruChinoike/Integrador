import java.util.ArrayList;

public abstract class Habilidade {

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

    public static int usaHabilidade(int id, Monstro usuario, ArrayList<Personagem> inimigos, int alvo) {
        switch(id) {
            case 13: {
                return Garras.habilidadeAtiva(usuario, inimigos, alvo);
            }
            default: { 
                return 0;
            }
        }
    }

}
