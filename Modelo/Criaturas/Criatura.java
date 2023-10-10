import java.util.ArrayList;
import java.util.List;

public class Criatura {

    private String nome;
    private int vida;
    private int armadura;
    private int nivel;
    private List<Boolean> fraquezas;
    private List<Integer> atributos;
    private List<Habilidade> habilidades;

    public Criatura(String nome) {
        this.nome = nome;
        this.vida = 10;
        this.armadura = 10;
        this.nivel = 1;
        this.fraquezas = new ArrayList<Boolean>(5);
        this.atributos = new ArrayList<Integer>(3);
    }

    public Criatura(String nome, List<Boolean> fraquezas, List<Integer> atributos) {
        this.nome = nome;
        this.vida = 10;
        this.armadura = 10;
        this.nivel = 1;
        this.fraquezas = new ArrayList<Boolean>(5);
        this.fraquezas.addAll(fraquezas);
        this.atributos = new ArrayList<Integer>(3);
        this.atributos.addAll(atributos);
    }

    public Criatura(String nome, int vida, int armadura, int nivel, List<Boolean> fraquezas, List<Integer> atributos, List<Habilidade> habilidades) {
        this.nome = nome;
        this.vida = vida;
        this.armadura = armadura;
        this.nivel = nivel;
        this.fraquezas = new ArrayList<Boolean>(5);
        this.fraquezas.addAll(fraquezas);
        this.atributos = new ArrayList<Integer>(3);
        this.atributos.addAll(atributos);
        this.habilidades = new ArrayList<Habilidade>();
        this.habilidades.addAll(habilidades);
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

    public int setVida(int vida) {
        this.vida = vida;
        return vida;
    }

    public int getArmadura() {
        return armadura;
    }

    public int setArmadura(int armadura) {
        this.armadura = armadura;
        return armadura;
    }

    public int getNivel() {
        return nivel;
    }

    public int setNivel(int nivel) {
        this.nivel = nivel;
        return nivel;
    }

    public List<Boolean> getFraquezas() {
        return fraquezas;
    }

    public boolean getFraquezas(int index) {
        return fraquezas.get(index);
    }

    public boolean setFraquezas(List<Boolean> fraquezas) {
        if (this.fraquezas.isEmpty()) {
            this.fraquezas.addAll(fraquezas);
            return true;
        }
        else {
            return false;
        }
    }

    public void setFraquezas(int index, boolean fraqueza) {
        fraquezas.set(index, fraqueza);
    }

    public List<Integer> getAtributos() {
        return atributos;
    }

    public int getAtributos(int index) {
        return atributos.get(index);
    }

    public boolean setAtributos(List<Integer> atributos) {
        if(this.atributos.isEmpty()) {
            this.atributos.addAll(atributos);
            return true;
        }
        else {
            return false;
        }
    }

    public void setAtributos(int index, int atributo) {
        atributos.set(index, atributo);
    }

    public List<Habilidade> getHabilidades() {
        return habilidades;
    }

    public Habilidade getHabilidade(int index) {
        return habilidades.get(index);
    }

    public boolean setHabilidades(List<Habilidade> habilidades) {
        if (this.habilidades.isEmpty()) {
            this.habilidades.addAll(habilidades);
            return true;
        }
        else {
            return false;
        }
    }

    public void setHabilidades(int index, Habilidade habilidade) {
        habilidades.set(index, habilidade);
    }

    public void addHabilidade(Habilidade habilidade) {
        habilidades.add(habilidade);
    }

}