public class Recompensa{

    private int id;
    private int tipo;
    private int raridade;
    private int experiencia;
    private Item item;
    private Habilidade habilidade;

    public Recompensa(int tipo, int raridade, int experiencia) {
        this.tipo = tipo;
        this.raridade = raridade;
        this.experiencia = experiencia;
    }

    public Recompensa(int tipo, int raridade, int experiencia, Item item) {
        this.tipo = tipo;
        this.raridade = raridade;
        this.experiencia = experiencia;
        this.item = item;
    }

    public Recompensa(int tipo, int raridade, int experiencia, Habilidade habilidade) {
        this.tipo = tipo;
        this.raridade = raridade;
        this.experiencia = experiencia;
        this.habilidade = habilidade;
    }

    public Recompensa(int tipo, int raridade, int experiencia, Item item, Habilidade habilidade) {
        this.tipo = tipo;
        this.raridade = raridade;
        this.experiencia = experiencia;
        this.item = item;
        this.habilidade = habilidade;
    }
    
    public int getId() {
        return id;
    }

    public int getTipo() {
        return tipo;
    }

    public int getRaridade() {
        return raridade;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public Item getItem() {
        return item;
    }

    public Habilidade getHabilidade() {
        return habilidade;
    }

}