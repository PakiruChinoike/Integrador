public class Recompensa{

    private int tipo;
    private int experiencia;
    private Item item;
    private Habilidade habilidade;

    public Recompensa(int tipo, int experiencia) {
        this.tipo = tipo;
        this.experiencia = experiencia;
    }

    public Recompensa(int tipo, int experiencia, Item item) {
        this.tipo = tipo;
        this.experiencia = experiencia;
        this.item = item;
    }

    public Recompensa(int tipo, int experiencia, Habilidade habilidade) {
        this.tipo = tipo;
        this.experiencia = experiencia;
        this.habilidade = habilidade;
    }

    public Recompensa(int tipo, int experiencia, Item item, Habilidade habilidade) {
        this.tipo = tipo;
        this.experiencia = experiencia;
        this.item = item;
        this.habilidade = habilidade;
    }

    public int getTipo() {
        return tipo;
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