import java.util.ArrayList;

public class TesteParty {
    
    public static void main(String[] args) {

        Personagem Guerreiro = new Personagem("Guerreiro", 1, 1);
        Personagem Ladino = new Personagem("Ladino", 2, 1);
        Personagem Mago = new Personagem("Mago", 3, 1);

        ArrayList<Personagem> party = new ArrayList<Personagem>(3);
        party.add(Guerreiro);
        party.add(Ladino);
        party.add(Mago);

        Monstro Esqueleto1 = new Monstro("Esqueleto1", 1, 4);
        Monstro Esqueleto2 = new Monstro("Esqueleto1", 1, 4);
        Monstro Esqueleto3 = new Monstro("Esqueleto1", 1, 4);
        Monstro Esqueleto4 = new Monstro("Esqueleto1", 1, 4);

        ArrayList<Monstro> inimigos = new ArrayList<Monstro>();
        inimigos.add(Esqueleto1);
        inimigos.add(Esqueleto2);
        inimigos.add(Esqueleto3);
        inimigos.add(Esqueleto4);

        Party personagens = new Party(1, party);
        Inimigos monstros = new Inimigos(2, inimigos);

        System.out.println(personagens.getId());
        System.out.println(personagens.getPersonagem(0).getNome());

        System.out.println(monstros.getId());
        System.out.println(monstros.getMonstro(0).getNome());

    }

}
