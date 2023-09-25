import java.util.ArrayList;

public class Classe {
    
    private String nome;
    private ArrayList<Integer> padrao;
    private ArrayList<Integer> listaHabilidades;

    public Classe(int tipo) {

        padrao = new ArrayList<Integer>(3);
        listaHabilidades = new ArrayList<Integer>(4);

        switch(tipo) {
            case 1: {
                this.nome = "Guerreiro";
                padrao.add(2);
                padrao.add(3);
                padrao.add(1);
                for (int id = 1; id<=4; id++) {
                    listaHabilidades.add(id);
                }
                break;
            }
            case 2: {
                this.nome = "Ladino";
                padrao.add(3);
                padrao.add(2);
                padrao.add(1);
                for (int id = 5; id<=8; id++) {
                    listaHabilidades.add(id);
                }
                break;
            }
            case 3: {
                this.nome = "Mago";
                padrao.add(2);
                padrao.add(1);
                padrao.add(3);
                for (int id = 9; id<=12; id++) {
                    listaHabilidades.add(id);
                }
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

    public ArrayList<Integer> getListaHabilidades() {
        return listaHabilidades;
    }

}
