import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
    
    Personagem personagem = new Personagem("Pakiru", 1); 
    Monstro monstro = new Monstro("Esqueleto", 10, 10, 5);
    Habilidade ataque = new Ataque(1, "Espadada", "Espada", 10, 2, 4, 1);
    
    monstro.setFraquezas(personagem.getFraquezas());
    monstro.setAtributos(personagem.getAtributos());

    personagem.addHabilidade(ataque);
    monstro.addHabilidade(ataque);

    List<Criatura> listaMonstro = new ArrayList<Criatura>();
    listaMonstro.add(monstro);

    List<Criatura> listaPersonagem = new ArrayList<Criatura>();
    listaPersonagem.add(personagem);

    while (personagem.getVida()>0 || monstro.getVida()>0) {
        System.out.println(personagem.getHabilidade(0).usaHabilidade(personagem, listaMonstro, 0));
        System.out.println(monstro.getHabilidade(0).usaHabilidade(monstro, listaPersonagem, 0));
        if (monstro.getVida()<=0) {
            System.out.println(personagem.getNome() + " venceu!");
            break;
        }
        if (personagem.getVida()<=0) {
            System.out.println(monstro.getNome() + " venceu!");
            break;
        }
    }
    
    
    }

}