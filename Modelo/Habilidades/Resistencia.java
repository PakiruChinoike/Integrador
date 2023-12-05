import java.lang.Math;

public class Resistencia extends Habilidade{

    public Resistencia() {
        super();
    }

    public Resistencia(long id, String nome, String descricao, int maxRoll, int minRoll, int minTeste, int tipoDano, int atributo, int custo) {
        super(id, nome, descricao, 1, maxRoll, minRoll, minTeste, tipoDano, atributo, custo);
    }


    protected int rolagemResistencia(int nivel, int atributo) {
        int teste = ((int)(Math.random() * 20) + nivel) + atributo;
        return teste;
    }

    //METODO QUE DEFINE QUANTO DE DANO O PERSONAGEM
    protected int rolagemDano(boolean isFraco) {
        int damage = (int)(Math.random() * super.getMaxRoll()) + super.getMinRoll();
        if(isFraco) {
            damage = damage*2;
        }
        return damage;
    }

    //METODO QUE CAUSA O DANO NO PERSONAGEM 
    protected int causaDano(int damage, Criatura inimigo) {
        int vidaAtual = inimigo.setVida((inimigo.getVida())-damage);
        return vidaAtual;
    }

    public String usaHabilidade(Criatura usuario, Equipe inimigos, int alvo) {
        if (usuario instanceof Personagem && ((Personagem)usuario).getPoder()<super.getCusto()) {
            return usuario.getNome() + " não possui Poder suficiente para esta ação.";
        }
        else {
            int teste = rolagemResistencia(inimigos.get(alvo).getNivel(), inimigos.get(alvo).getAtributos(super.getAtributo()));
            int damage = rolagemDano(inimigos.get(alvo).getFraquezas(super.getTipoDano()));
            if (teste<(super.getMinTeste())) {
                int vidaAtual = causaDano(damage, inimigos.get(alvo));

                if (usuario instanceof Personagem) {
                    ((Personagem)usuario).setPoder(((Personagem)usuario).getPoder()-super.getCusto());
                }

                return usuario.getNome() + " utilizou " + super.getDescricao() + " em " + inimigos.get(alvo).getNome() + 
                " que falhou em resistir ao efeito, sofrendo " + damage + " de dano, e ficando com " + 
                vidaAtual + " pontos de vida.";
            }
            else {
                return inimigos.get(alvo).getNome() + " resistiu ao efeito de " + usuario.getNome();
            }
        }
    }

}