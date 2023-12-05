public class Recompensa{

    private long id;
    private int tipo;
    private int raridade;
    private int experiencia;
    private Item item;
    private Habilidade habilidade;

    public Recompensa() {
        this.id = 0;
        this.tipo = 0;
        this.raridade = 0;
        this.experiencia = 0;
        this.item = new Item();
        this.habilidade = null;
    }

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
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getRaridade() {
        return raridade;
    }

    public void setRaridade(int raridade) {
        this.raridade = raridade;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Habilidade getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(Habilidade habilidade) {
        this.habilidade = habilidade;
    }

    //METODO QUE TRANSFORMA TODAS AS RECOMPENSAS EM STRING
    public String toString() {
        String toString = experiencia + " de experiencia";
        if (getItem()!=null) {
            toString = toString + ", " + item.getNome();
        }
        if (getHabilidade()!=null) {
            toString = toString + ", " + habilidade.getNome();
        }
        toString = toString + "!";
        return toString;
    }

}