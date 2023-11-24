import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Metodos {

    private static Scanner keyboardInt = new Scanner(System.in);
    private static Scanner keyboardString = new Scanner(System.in);

    public static List<Personagem> criarPersonagens(int n) {
        List<Personagem> listaPersonagens = new ArrayList<>();

        for (int i = 0; i<n; i++) {
            System.out.println("Decida o nome do Personagem:");
            String nome = keyboardString.nextLine();

            System.out.printf("Decida a classe do seu Personagem:%n1 - Ladino%n2 - Guerreiro%n3 - Mago%n");
            int classe = keyboardInt.nextInt()-1;

            Personagem personagem = new Personagem(nome, classe);

            listaPersonagens.add(personagem);
        }
        
        return listaPersonagens;
    }

    private static String ativa(Criatura usuario, List<Criatura> inimigos, int numHab, int alvo) {
        return usuario.getHabilidade(numHab).usaHabilidade(usuario, inimigos, alvo);
    }

    private static boolean isLutando(List<Criatura> combatentes) {
        for(int i = 0; i<combatentes.size(); i++) {
            if(combatentes.get(i).getVida()>0) {
                return true;
            }
        }
        return false;
    }

    public static String realizarCombate(List<Criatura> equipe1, List<Criatura> equipe2) {
        int num1 = 0;
        int num2 = 0;

        for(int i = 0; ; i++) {
            if(i%2==0) {
                if (num1>=equipe1.size()) {
                    num1 = 0;
                }
                Criatura atual = equipe1.get(num1);

                System.out.printf(atual.getNome() + " qual será a sua ação?%n");
                for(int j = 0; j<atual.getHabilidades().size(); j++) {
                    System.out.printf(j+1 + " - " + atual.getHabilidade(j).getNome() + "%n");
                }
                int hab = keyboardInt.nextInt()-1;

                System.out.printf(atual.getNome() + " qual será o seu alvo?%n"); 
                for(int j = 0; j<equipe2.size(); j++) {
                    System.out.printf(j+1 + " - " + equipe2.get(j).getNome() + "%n");
                }
                int alvo = keyboardInt.nextInt()-1;

                System.out.println(ativa(atual, equipe2, hab, alvo));
                num1++;
                if(!isLutando(equipe2)) {
                    return "A primeira equipe venceu!";
                }
            }
            else {
                if (num2>=equipe2.size()){
                    num2 = 0;
                }
                Criatura atual = equipe2.get(num2);

                System.out.printf(atual.getNome() + " qual será a sua ação?%n");
                for(int j = 0; j<atual.getHabilidades().size(); j++) {
                    System.out.printf(j+1 + " - " + atual.getHabilidade(j).getNome() + "%n");
                }
                int hab = keyboardInt.nextInt()-1;

                System.out.printf(atual.getNome() + " qual será o seu alvo?%n"); 
                for(int j = 0; j<equipe1.size(); j++) {
                    System.out.printf(j+1 + " - " + equipe1.get(j).getNome() + "%n");
                }
                int alvo = keyboardInt.nextInt()-1;

                System.out.println(ativa(equipe2.get(num2), equipe1, hab, alvo));
                num2++;
                if(!isLutando(equipe1)) {
                    return "A segunda equipe venceu!";
                }
            }
        }
    }

}
