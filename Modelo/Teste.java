import java.util.ArrayList;

public class Teste {
    
       public static void main(String[] args) {

        Personagem pakiru = new Personagem("Pakiru", 1, 1);
        Inimigo esqueleto = new Inimigo("Esqueleto", 1, 3);

        System.out.println(pakiru.getNome());
        System.out.println(esqueleto.getNome());

        if (Habilidade.personagemHabilidade(1, pakiru, esqueleto)==1) {
            System.out.println("Pakiru acertou Esqueleto");
            System.out.println(esqueleto.getVida());
        }
        else {
            System.out.println("Pakiru errou!");
        }
        
        if (Habilidade.monstroHabilidade(5, esqueleto, pakiru)==1) {
            System.out.println("Esqueleto acertou Pakiru");
            System.out.println(pakiru.getVida());
        }
        else {
            System.out.println("Esqueleto errou!");
        }
        
    }

}
