public class Atributos {
    
    private Personagem personagem;
    private int agilidade;
    private int forca;
    private int inteligencia;
    private int vida;
    private int armadura;
    private int mana;
    private int vigor;

    public Atributos(Personagem personagem) {
        this.agilidade = personagem.getClasse().getPadrao()[0];
        this.forca = personagem.getClasse().getPadrao()[1];
        this.inteligencia = personagem.getClasse().getPadrao()[2];
    }

}
