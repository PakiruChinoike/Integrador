import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Metodos {

    public static List<Personagem> criarPersonagens(int n) {
        Scanner keyboardLine = new Scanner(System.in);
        Scanner keyboardInt = new Scanner(System.in);

        List<Personagem> listaPersonagens = new ArrayList<>();

        for (int i = 0; i<n; i++) {
            System.out.println("Decida o nome do Personagem:");
            String nome = keyboardLine.nextLine();

            System.out.printf("Decida a classe do seu Personagem:%n1 - Guerreiro%n2 - Ladino%n3 - Mago%n");
            int classe = keyboardInt.nextInt();

            Personagem personagem = new Personagem(nome, classe);

            listaPersonagens.add(personagem);
        }

        keyboardLine.close();
        keyboardInt.close();
        
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
            else {
                return false;
            }
        }
        return false;
    }

    public static String realizarCombate(List<Criatura> equipe1, List<Criatura> equipe2) {
        int num1 = 0;
        int num2 = 0;

        for(int i = 0; ; i++) {
            if(i%2==0) {
                System.out.println(ativa(equipe1.get(num1), equipe2, 0, 0));
                num1++;
                if(!isLutando(equipe2)) {
                    System.out.println("A primeira equipe venceu!");
                }
            }
            else {
                System.out.println(ativa(equipe2.get(num2), equipe1, 0, 0));
                num2++;
                if(!isLutando(equipe1)) {
                    System.out.println("A segunda equipe venceu!");
                }
            }
        }

    }

}
