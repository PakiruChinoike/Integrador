public class Item extends Acao{

    private long id;
    private String nome;
    private int usos;
    private Habilidade habilidade;

    public Item() {
        this.id = 0;
        this.nome = "";
        this.usos = 1;
        this.habilidade = null;
    }

    public Item(long id, String nome, int usos, Habilidade habilidade) {
        this.id = id;
        this.nome = nome;
        this.usos = usos;
        this.habilidade = habilidade;
    }

    public long getId() {
        return id;
    }

    public String getNome(){
        return nome;
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

    public void setUsos(int usos) {
        this.usos = usos;
    }

    public void setHabilidade(Habilidade habilidade) {
        this.habilidade = habilidade;
    }

    public String toString() {
        return nome + ", " + habilidade.getDescricao() + " (" + usos + ")%n";
    }

    public String usaItem(Criatura usuario, Equipe inimigos, int alvo) {
        return this.habilidade.usaHabilidade(usuario, inimigos, alvo);
    }

    public void gastaUso() {
        this.usos = this.usos-1;
    }

}