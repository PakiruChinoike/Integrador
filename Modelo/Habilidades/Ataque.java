import java.lang.Math;
import java.util.List;

public class Ataque extends Habilidade{

    public Ataque() {
        super();
    }

    public Ataque(long id, String nome, String descricao, int maxRoll, int minRoll, int tipoDano, int atributo) {
        super(id, nome, descricao, 0, maxRoll, minRoll, 0, tipoDano, atributo);
    }

    protected int rolagemAtaque(int atributo) {
        int hit = ((int)(Math.random() * 20) + 1) + atributo;
        return hit;
    }

    protected int rolagemDano(boolean isFraco) {
        int damage = (int)(Math.random() * super.getMaxRoll()) + super.getMinRoll();
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

    //METODO PARA O PERSONAGEM USAR A HABILIDADE EM ALVO UNICO 
    public String usaHabilidade(Criatura usuario, List<Criatura> inimigos, int alvo) {
        int hit = rolagemAtaque(usuario.getAtributos(super.getAtributo()));
        int damage = rolagemDano(inimigos.get(alvo).getFraquezas(super.getTipoDano()));
        if (testeAtaque(hit, inimigos.get(alvo).getArmadura())) {
            int vidaAtual = causaDano(damage, inimigos.get(alvo));
            return usuario.getNome() + " acertou " + inimigos.get(alvo).getNome() + " com um " + hit + " causando "
            + damage + " de dano, e o deixando com " + vidaAtual + " pontos de vida.";
        }
        else {
            return usuario.getNome() + " errou " + super.getNome();
        }
    }

    //METODO PARA O PERSONAGEM USAR A HABILIDADE EM AREA  
    public String usaHabilidade(Criatura usuario, List<Criatura> inimigos) {
        int hit = rolagemAtaque(usuario.getAtributos(super.getAtributo()));
        int acertos = 0;
        for (int i = 0; i<inimigos.size(); i++) {
            int damage = rolagemDano(inimigos.get(i).getFraquezas(super.getTipoDano()));
            if (testeAtaque(hit, inimigos.get(i).getArmadura())) {
                causaDano(damage, inimigos.get(i));
                acertos++;
            }
        }
        return usuario.getNome() + " acertou " + acertos + " inimigos.";
    }

}