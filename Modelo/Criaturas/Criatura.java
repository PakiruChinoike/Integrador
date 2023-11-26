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
    private int equipe;

    //METODO QUE CRIA UMA CRIATURA A PARTIR DE UM NOME 
    public Criatura(String nome) {
        this.nome = nome;
        this.vida = 10;
        this.armadura = 10;
        this.nivel = 1;
        this.fraquezas = new ArrayList<Boolean>(5);
        this.atributos = new ArrayList<Integer>(4);
        this.habilidades = new ArrayList<Habilidade>();
        this.equipe = 0;
    }

    //METODO QUE DEFINE O NIVEL, VIDA E ARMADURA DA CRIATURA
    public Criatura(String nome, int vida, int armadura, int nivel, int equipe) {
        this.nome = nome;
        this.vida = vida;
        this.armadura = armadura;
        this.nivel = nivel;
        this.fraquezas = new ArrayList<Boolean>(5);
        this.atributos = new ArrayList<Integer>(4);
        this.habilidades = new ArrayList<Habilidade>();
        this.equipe = equipe;
    }

    //METODO QUE DEFINE AS FRAQUEZAS E ATRIBUTOS DA CRIATURA 
    public Criatura(String nome, List<Boolean> fraquezas, List<Integer> atributos) {
        this.nome = nome;
        this.vida = 10;
        this.armadura = 10;
        this.nivel = 1;
        this.fraquezas = new ArrayList<Boolean>(5);
        this.fraquezas.addAll(fraquezas);
        this.atributos = new ArrayList<Integer>(4);
        this.atributos.addAll(atributos);
        this.habilidades = new ArrayList<Habilidade>();
        this.equipe = 0;
    }

    //METODO QUE DEFINE TODOS OS VALORES DA CRIATURA
    public Criatura(String nome, int vida, int armadura, int nivel, List<Boolean> fraquezas, List<Integer> atributos, List<Habilidade> habilidades, Equipe equipe) {
        this.nome = nome;
        this.vida = vida;
        this.armadura = armadura;
        this.nivel = nivel;
        this.fraquezas = new ArrayList<Boolean>(5);
        this.fraquezas.addAll(fraquezas);
        this.atributos = new ArrayList<Integer>(4);
        this.atributos.addAll(atributos);
        this.habilidades = new ArrayList<Habilidade>();
        this.habilidades.addAll(habilidades);
        this.equipe = 0;
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

    //METODO DEFINE AS FRAQUEZAS DA CRIATURA 
    public void setFraquezas(int index, boolean fraqueza) {
        fraquezas.set(index, fraqueza);
    }

    public List<Integer> getAtributos() {
        return this.atributos;
    }

    public int getAtributos(int index) {
        return this.atributos.get(index);
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

    //METODO QUE ADICIONA HABILIDADES CASO A LISTA DE HABILIDADES ESTEJA VAZIA 
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

    //METODO QUE ADICIONA UMA HABILIDADE 
    public void addHabilidade(Habilidade habilidade) {
        habilidades.add(habilidade);
    }

    public int getEquipe() {
        return equipe;
    }

    public void setEquipe(int equipe) {
        this.equipe = equipe;
    }

}