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
        listaHabilidades = new ArrayList<Habilidade>(3);
        listaFraquezas = new ArrayList<Boolean>(5);
        for (int i = 0; i<5; i++) {
            listaFraquezas.add(i, false);
        }

        HabilidadeDAO habilidadeDAO = new HabilidadeDAO();

        //DEFINE OS ATRIBUTOS BASE DE CADA CLASSE
        switch(tipo) {
            case 0: {
                this.nome = "Ladino";
                padrao.add(3);
                padrao.add(2);
                padrao.add(1);
                
                listaFraquezas.add(2, true);
                listaHabilidades.add(0, habilidadeDAO.buscar(1));
                listaHabilidades.add(1, habilidadeDAO.buscar(2));
                listaHabilidades.add(2, habilidadeDAO.buscar(3));

                break;
            }
            case 1: {
                this.nome = "Guerreiro";
                padrao.add(2);
                padrao.add(3);
                padrao.add(1);

                listaFraquezas.add(0, true);
                listaHabilidades.add(0, habilidadeDAO.buscar(5));
                listaHabilidades.add(1, habilidadeDAO.buscar(6));
                listaHabilidades.add(2, habilidadeDAO.buscar(7));

                break;
            }
            case 2: {
                this.nome = "Mago";
                padrao.add(2);
                padrao.add(1);
                padrao.add(3);

                listaFraquezas.add(1, true);
                listaHabilidades.add(0, habilidadeDAO.buscar(9));
                listaHabilidades.add(1, habilidadeDAO.buscar(10));
                listaHabilidades.add(2, habilidadeDAO.buscar(11));

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
