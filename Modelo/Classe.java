import java.util.ArrayList;

public class Classe {
    
    private String nome;
    private int[] padrao;

    public Classe(int tipo) {

        padrao = new int[3];

        switch(tipo) {
            case 1: {
                this.nome = "Guerreiro";
                padrao[0] = 2;
                padrao[1] = 3;
                padrao[2] = 1;
                break;
            }
            case 2: {
                this.nome = "Ladino";
                padrao[0] = 3;
                padrao[1] = 2;
                padrao[2] = 1;
                break;
            }
            case 3: {
                this.nome = "Mago";
                padrao[0] = 2;
                padrao[1] = 1;
                padrao[2] = 3;
                break;
            }
        }

    }

    public int getPadrao(int pointer) {
        return padrao[pointer];
    }

}
