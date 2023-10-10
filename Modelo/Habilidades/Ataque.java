import java.lang.Math;
import java.util.List;

public abstract class Ataque extends Habilidade{

    private int maxRoll;
    private int minRoll;
    private int tipoDano;
    private int atributo;

    protected Ataque(int id, String nome, String descricao, int maxRoll, int minRoll, int tipoDano, int atributo) {
        super(id, nome, descricao);
        this.maxRoll = maxRoll;
        this.minRoll = minRoll;
        this.tipoDano = tipoDano;
        this.atributo = atributo;
    }

    protected int rolagemAtaque(int atributo) {
        int hit = ((int)(Math.random() * 20) + 1) + atributo;
        return hit;
    }

    protected int rolagemDano(boolean isFraco) {
        int damage = (int)(Math.random() * maxRoll) + minRoll;
        if(isFraco) {
            damage = damage*2;
        }
        return damage;
    }

    protected boolean testeAtaque(int hit, int armadura) {
        if (hit>armadura) {
            return true;
        }
        else {
            return false;
        }
    }

    protected int causaDano(int damage, Criatura inimigo) {
        int vidaAtual = inimigo.setVida((inimigo.getVida())-damage);
        return vidaAtual;
    }

    public String usaHabilidade(Personagem usuario, List<Criatura> inimigos, int alvo) {
        int hit = rolagemAtaque(usuario.getAtributos(atributo));
        int damage = rolagemDano(inimigos.get(alvo).getFraquezas(tipoDano));
        if (testeAtaque(hit, inimigos.get(alvo).getArmadura())) {
            int vidaAtual = causaDano(damage, inimigos.get(alvo));
            return usuario.getNome() + " acertou " + inimigos.get(alvo).getNome() + " com um " + hit + " causando "
            + damage + " de dano, e o deixando com " + vidaAtual + " pontos de vida.";
        }
        else {
            return usuario.getNome() + " errou " + super.getNome();
        }
    }

    public String usaHabilidade(Personagem usuario, List<Criatura> inimigos) {
        int hit = rolagemAtaque(usuario.getAtributos(atributo));
        int acertos = 0;
        for (int i = 0; i<inimigos.size(); i++) {
            int damage = rolagemDano(inimigos.get(i).getFraquezas(tipoDano));
            if (testeAtaque(hit, inimigos.get(i).getArmadura())) {
                causaDano(damage, inimigos.get(i));
                acertos++;
            }
        }
        return usuario.getNome() + " acertou " + acertos + " inimigos.";
    }

    public String usaHabilidade(Monstro usuario, List<Criatura> inimigos, int alvo) {
        int hit = rolagemAtaque(usuario.getAtributos(atributo));
        int damage = rolagemDano(inimigos.get(alvo).getFraquezas(tipoDano));
        if (testeAtaque(hit, inimigos.get(alvo).getArmadura())) {
            int vidaAtual = causaDano(damage, inimigos.get(alvo));
            return usuario.getNome() + " acertou " + inimigos.get(alvo).getNome() + " com um " + hit + " causando "
            + damage + " de dano, e o deixando com " + vidaAtual + " pontos de vida.";
        }
        else {
            return usuario.getNome() + " errou " + super.getNome();
        }        
    }

    public String usaHabilidade(Monstro usuario, List<Criatura> inimigos) {
        int hit = rolagemAtaque(usuario.getAtributos(atributo));
        int acertos = 0;
        for (int i = 0; i<inimigos.size(); i++) {
            int damage = rolagemDano(inimigos.get(i).getFraquezas(tipoDano));
            if (testeAtaque(hit, inimigos.get(i).getArmadura())) {
                causaDano(damage, inimigos.get(i));
                acertos++;
            }
        }
        return usuario.getNome() + " acertou " + acertos + " inimigos.";
    }

    public int getTipoDano() {
        return tipoDano;
    }

}
