public class Item {

    private int id;
    private String nome;
    private int raridade;
    private Habilidade habilidade;

    public Item(String nome, int raridade, Habilidade habilidade) {
        this.nome = nome;
        this.raridade = raridade;
        this.habilidade = habilidade;
    }

    public int getId() {
        return id;
    }

    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }

}