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
    private int custo;

    public Habilidade() {
        this.id = 0;
        this.nome = "";
        this.descricao = "";
        this.tipo = 0;
        this.maxRoll = 0;
        this.minRoll = 0;
        this.minTeste = 0;
        this.tipoDano = 0;
        this.atributo = 0;
        this.custo = 0;
    }

    protected Habilidade(long id, String nome, String descricao, int tipo, int maxRoll, int minRoll, int minTeste, int tipoDano, int atributo, int custo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.maxRoll = maxRoll;
        this.minRoll = minRoll;
        this.minTeste = minTeste;
        this.tipoDano = tipoDano;
        this.atributo = atributo;
        this.custo = custo;
    }

    public abstract String usaHabilidade(Criatura usuario, List<Criatura> inimigos, int alvo);

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

    public int getCusto() {
        return custo;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setMaxRoll(int maxRoll) {
        this.maxRoll = maxRoll;
    }

    public void setMinRoll(int minRoll) {
        this.minRoll = minRoll;
    }

    public void setMinTeste(int minTeste) {
        this.minTeste = minTeste;
    }

    public void setTipoDano(int tipoDano) {
        this.tipoDano = tipoDano;
    }

    public void setAtributo(int atributo) {
        this.atributo = atributo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

}
