import java.util.ArrayList;

public class Inimigo extends Criatura{
    
    private int dificuldade;
    private ArrayList<Habilidade> listaHabilidades;

    public Inimigo(String nome, int dificuldade, int n, ArrayList<Habilidade> listaHabilidades) {
        super(nome);
        this.dificuldade = dificuldade;
        this.listaHabilidades = new ArrayList<Habilidade>(n);
        this.listaHabilidades.addAll(listaHabilidades);
    }

    public String usaHabilidade(int i) {
        return listaHabilidades.get(i-1).getFuncao();
    }

}
