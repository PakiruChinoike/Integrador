import java.util.ArrayList;

public class Teste {
    
    public static void main(String[] args) {

        Habilidade habilidade = new Habilidade("Boa noite");
        ArrayList<Habilidade> listaHabilidades = new ArrayList<Habilidade>();
        listaHabilidades.add(habilidade);

        Criatura inimigo = new Inimigo("Esqueleto", 1, 1, listaHabilidades);
        Criatura personagem = new Personagem(1);

        System.out.println(inimigo.usaHabilidade(1));
        System.out.println(number1);
    }

}
