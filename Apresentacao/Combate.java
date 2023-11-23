import java.util.List;
import java.util.ArrayList;

public class Combate {
    
    public static void main(String[] args) {

        List<Personagem> listaPersonagens = Metodos.criarPersonagens(2);

        Habilidade habilidade = new Ataque(1, "Espadada", "Espadada", 10, 1, 4, 0);
        listaPersonagens.get(0).addHabilidade(habilidade);
        listaPersonagens.get(1).addHabilidade(habilidade);

        List<Criatura> equipe1 = new ArrayList<>();
        equipe1.add(listaPersonagens.get(0));

        List<Criatura> equipe2 = new ArrayList<>();
        equipe2.add(listaPersonagens.get(1));

        while(listaPersonagens.get(0).getVida()>0 || listaPersonagens.get(1).getVida()>0) {
            System.out.println(listaPersonagens.get(0).getHabilidade(0).usaHabilidade(listaPersonagens.get(1), equipe1, 0));
            System.out.println(listaPersonagens.get(0).getHabilidade(0).usaHabilidade(listaPersonagens.get(0), equipe2, 0));
            if (listaPersonagens.get(0).getVida()<0) {
                System.out.println(listaPersonagens.get(1).getNome() + " venceu!");
                break;
            }
            if (listaPersonagens.get(1).getVida()<0) {
                System.out.println(listaPersonagens.get(0).getVida() + " venceu!");
                break;
            }
        }

    }

}
