import java.util.List;

public abstract class Habilidade {

    private long id;
    private String nome;
    private String descricao;
    private int tipo;

    private int maxRoll;
    private int minRoll;
    private int minTeste;
    private int tipoDano;
    private int atributo;

    protected Habilidade(int id, String nome, String descricao, int tipo, int maxRoll, int minRoll, int minTeste, int tipoDano, int atributo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public abstract String usaHabilidade(Personagem usuario, List<Criatura> inimigos, int alvo);

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getTipo() {
        return tipo; 
    }

    public int getMaxRoll() {
        return maxRoll;
    }

    public int getMinRoll() {
        return minRoll;
    }

    public int getMinTeste() {
        return minTeste;
    }

    public int getTipoDano() {
        return tipoDano;
    }

    public int getAtributo() {
        return atributo;
    }

}
