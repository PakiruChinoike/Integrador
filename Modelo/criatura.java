public class Criatura {

    private String nome;
    private int vida;
    private int armadura;
    private ArrayList<Boolean> fraquezas;

    public Criatura(String nome) {
        this.nome = nome;
        this.vida = 10;
        this.armadura = 10;
    }

    public Criatura(String nome, int vida, int armadura, ArrayList<Boolean> fraquezas) {
        this.nome = nome;
        this.vida = vida;
        this.armadura = vida;
        this.fraquezas = new ArrayList<Boolean>();
        this.fraquezas.addAll(fraquezas);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getArmadura() {
        return armadura;
    }

    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }

}