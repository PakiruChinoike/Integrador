import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class Classe {
    
    private String nome;
    private List<Integer> padrao;
    private List<Habilidade> listaHabilidades;
    private List<Boolean> fraquezas;
    private int idAtrib;

    //
    public Classe(int tipo) {

        padrao = new ArrayList<Integer>(3);
        listaHabilidades = new ArrayList<Habilidade>(4);
        fraquezas = new ArrayList<Boolean>(5);
        for (int i = 0; i<5; i++) {
            fraquezas.add(false);
        }

        switch(tipo) {
            case 1: {
                this.nome = "Guerreiro";
                padrao.add(2);
                padrao.add(3);
                padrao.add(1);

                fraquezas.set(0, true);
                break;
            }
            case 2: {
                this.nome = "Ladino";
                padrao.add(3);
                padrao.add(2);
                padrao.add(1);
                
                fraquezas.set(1, true);
                break;
            }
            case 3: {
                this.nome = "Mago";
                padrao.add(2);
                padrao.add(1);
                padrao.add(3);

                fraquezas.set(2, true);
                break;
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public List<Integer> getPadrao() {
        return padrao;
    }

    public List<Habilidade> getListaHabilidades() {
        return listaHabilidades;
    }

    public List<Boolean> getListaFraquezas() {
        return fraquezas;
    }

    public boolean getFraqueza(int index) {
        return fraquezas.get(index);
    }

}
