import java.util.ArrayList;

public class Mago extends Classe {

    private ArrayList<Habilidade> listaHabilidades;

    public Mago(int tipo, ArrayList<Habilidade> listaHabilidades) {
        super(tipo);
        this.listaHabilidades = new ArrayList<Habilidade>(4);
        this.listaHabilidades.addAll(listaHabilidades);
    }

}