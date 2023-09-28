import java.util.ArrayList;
import java.util.List;

public class Criatura {

    private String nome;
    private int vida;
    private int armadura;
    private List<Boolean> fraquezas;
    private List<Integer> atributos;

//0-4 (5) 
//0=Congelante
//1=Flamejante
//2=Elétrico
//3=Físico
//4=Arcano

//0-2 (3)
//0=Agilidade
//1=Força
//2=Inteligência

    public Criatura(String nome) {
        this.nome = nome;
        this.vida = 10;
        this.armadura = 10;
        this.fraquezas = new ArrayList<Boolean>(5);
        this.atributos = new ArrayList<Integer>(3);
    }

    public Criatura(String nome, List<Boolean> fraquezas, List<Integer> atributos) {
        this.nome = nome;
        this.vida = 10;
        this.armadura = 10;
        this.fraquezas = new ArrayList<Boolean>(5);
        this.fraquezas.addAll(fraquezas);
        this.atributos = new ArrayList<Integer>(3);
        this.atributos.addAll(atributos);
    }

    public Criatura(String nome, int vida, int armadura, List<Boolean> fraquezas) {
        this.nome = nome;
        this.vida = vida;
        this.armadura = armadura;
        this.fraquezas = new ArrayList<Boolean>(5);
        this.fraquezas.addAll(fraquezas);
        this.atributos = new ArrayList<Integer>(3);
        this.atributos.addAll(atributos);
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

    public void setAtributos(int index, boolean atributo) {
        atributos.set(index, atributo);
    }

}