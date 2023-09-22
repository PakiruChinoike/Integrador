import java.util.ArrayList;

public class Classe {
    
    private String nome;
    private ArrayList<Integer> padrao;

    public Classe(int tipo) {

        padrao = new ArrayList<Integer>(3);

        switch(tipo) {
            case 1: {
                this.nome = "Guerreiro";
                padrao.add(2);
                padrao.add(3);
                padrao.add(1);
                break;
            }
            case 2: {
                this.nome = "Ladino";
                padrao.add(3);
                padrao.add(2);
                padrao.add(1);
                break;
            }
            case 3: {
                this.nome = "Mago";
                padrao.add(2);
                padrao.add(1);
                padrao.add(3);
                break;
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public int getPadrao(int index) {
        return padrao.get(index);
    }

}
