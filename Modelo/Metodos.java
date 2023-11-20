import java.util.Scanner;

public abstract class Metodos {
    
    public static Personagem criarPersonagem() {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Defina o nome do seu personagem");
        String nome = keyboard.nextLine();
        System.out.printf("Selecione uma dentre as 3 classes:%n 1, Guerreiros%n 2, Ladino%n 3, Mago");
        int classe = keyboard.nextInt();

        Personagem personagem = new Personagem(nome, classe);
        personagem.toString();
        return personagem;

    }

}
