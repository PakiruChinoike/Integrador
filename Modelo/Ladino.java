import java.util.ArrayList;

public class Ladino extends Classe {

    private ArrayList<Habilidade> listaHabilidades;

    public Ladino(int tipo, ArrayList<Habilidade> listaHabilidades) {
        super(tipo);
        this.listaHabilidades = new ArrayList<Habilidade>(4);
        this.listaHabilidades.addAll(listaHabilidades);
    }

}