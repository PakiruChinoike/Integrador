import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Scanner keyboardString = new Scanner(System.in);
        PersonagemDAO personagemDAO = new PersonagemDAO();

        String nome = keyboardString.nextLine();
        int classe = keyboard.nextInt();

        Personagem personagem = new Personagem(nome, classe);
        personagem.setId(personagemDAO.salvar(personagem));
        System.out.println(personagem.getAtributos(1));

        keyboard.close();
        keyboardString.close();
    }

}
