import java.util.ArrayList;
import java.util.List;

public class Classe {
    
    private String nome;
    private List<Integer> padrao;
    private List<Habilidade> listaHabilidades;
    private List<Boolean> listaFraquezas;

    //CONSTRUTOR VAZIO QUE RECEBE O TIPO DA CLASSE 
    public Classe(int tipo) {

        padrao = new ArrayList<Integer>(3);
        listaHabilidades = new ArrayList<Habilidade>(4);
        listaFraquezas = new ArrayList<Boolean>(5);
        for (int i = 0; i<5; i++) {
            listaFraquezas.add(i, false);
        }

        //DEFINE OS ATRIBUTOS BASE DE CADA CLASSE
        switch(tipo) {
            case 1: {
                this.nome = "Guerreiro";
                padrao.add(2);
                padrao.add(3);
                padrao.add(1);

                listaFraquezas.set(0, true);
                break;
            }
            case 2: {
                this.nome = "Ladino";
                padrao.add(3);
                padrao.add(2);
                padrao.add(1);
                
                listaFraquezas.set(1, true);
                break;
            }
            case 3: {
                this.nome = "Mago";
                padrao.add(2);
                padrao.add(1);
                padrao.add(3);

                listaFraquezas.set(2, true);
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
        return listaFraquezas;
    }

    public boolean getFraqueza(int index) {
        return listaFraquezas.get(index);
    }

}
