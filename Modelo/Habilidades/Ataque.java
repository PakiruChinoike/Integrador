import java.lang.Math;

public class Ataque extends Habilidade{

    public Ataque() {
        super();
    }

    public Ataque(long id, String nome, String descricao, int maxRoll, int minRoll, int tipoDano, int atributo, int custo) {
        super(id, nome, descricao, 0, maxRoll, minRoll, 0, tipoDano, atributo, custo);
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
    public String usaHabilidade(Criatura usuario, Equipe inimigos, int alvo) {
        if (usuario instanceof Personagem && ((Personagem)usuario).getPoder()<super.getCusto()) {
            return usuario.getNome() + " não possui Poder suficiente para esta ação.";
        }
        else {
            int hit = rolagemAtaque(usuario.getAtributos(super.getAtributo()));
            int damage = rolagemDano(inimigos.get(alvo).getFraquezas(super.getTipoDano()));
            if (testeAtaque(hit, inimigos.get(alvo).getArmadura())) {
                int vidaAtual = causaDano(damage, inimigos.get(alvo));

                if (usuario instanceof Personagem) {
                    ((Personagem)usuario).setPoder(((Personagem)usuario).getPoder()-super.getCusto());
                }

                return usuario.getNome() + " acertou " + super.getDescricao() + " em " + inimigos.get(alvo).getNome() + " com um " + hit + " causando "
                + damage + " de dano, e o deixando com " + vidaAtual + " pontos de vida.";
            }
            else {
                return usuario.getNome() + " errou " + super.getNome();
            }
        }
    }

}