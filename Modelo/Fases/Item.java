public class Item {

    private long id;
    private String nome;
    private int raridade;
    private int usos;
    private Habilidade habilidade;

    public Item() {
        this.id = 0;
        this.nome = "";
        this.raridade = 0;
        this.usos = 1;
        this.habilidade = null;
    }

    public Item(String nome, int raridade, int usos, Habilidade habilidade) {
        this.nome = nome;
        this.raridade = raridade;
        this.usos = usos;
        this.habilidade = habilidade;
    }

    public long getId() {
        return id;
    }

    public String getNome(){
        return nome;
    }
    
    public int getRaridade() {
        return raridade;
    }

    public int getUsos() {
        return usos;
    }

    public Habilidade getHabilidade() {
        return habilidade;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRaridade(int raridade) {
        this.raridade = raridade;
    }

    public void setUsos(int usos) {
        this.usos = usos;
    }

    public void setHabilidade(Habilidade habilidade) {
        this.habilidade = habilidade;
    }

}