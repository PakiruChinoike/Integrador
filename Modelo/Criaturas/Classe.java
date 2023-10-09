import java.util.ArrayList;
import java.util.List;

public class Classe {
    
    private String nome;
    private List<Integer> padrao;
    private List<Habilidade> listaHabilidades;
    private List<Boolean> fraquezas;

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

                // Habilidade golpeada = new Golpeada();
                // Habilidade bloquear = new Bloquear();
                // Habilidade ataquePesado = new AtaquePesado();
                // Habilidade recuperarFolego = new RecuperarFolego();
                // listaHabilidades.add(golpeada);
                // listaHabilidades.add(bloquear);
                // listaHabilidades.add(ataquePesado);
                // listaHabilidades.add(recuperarFolego);

                fraquezas.set(0, true);
                break;
            }
            case 2: {
                this.nome = "Ladino";
                padrao.add(3);
                padrao.add(2);
                padrao.add(1);
                // for (int id = 5; id<=8; id++) {
                //     listaHabilidades.add(id);
                // }
                fraquezas.set(1, true);
                break;
            }
            case 3: {
                this.nome = "Mago";
                padrao.add(2);
                padrao.add(1);
                padrao.add(3);
                // for (int id = 9; id<=12; id++) {
                //     listaHabilidades.add(id);
                // }
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

    public ArrayList<Integer> getListaHabilidades() {
        return listaHabilidades;
    }

    public ArrayList<Boolean> getListaFraquezas() {
        return fraquezas;
    }

    public boolean getFraqueza(int index) {
        return fraquezas.get(index);
    }

}
