import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
    
    List<Criatura> equipe1 = new ArrayList<>(); 
    List<Criatura> equipe2 = new ArrayList<>();

    List<Criatura> listaPersonagens = new ArrayList<>();
    listaPersonagens.addAll(Metodos.criarPersonagens(2));
    equipe1.add(listaPersonagens.get(0));
    equipe2.add(listaPersonagens.get(1));

    System.out.println(Metodos.realizarCombate(equipe1, equipe2));
    }

}