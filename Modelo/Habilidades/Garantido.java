import java.lang.Math;
import java.util.List;

public class Garantido extends Habilidade{

    public Garantido() {
        super();
    }

    public Garantido(long id, String nome, String descricao, int maxRoll, int minRoll, int tipoDano, int custo) {
        super(id, nome, descricao, 2, maxRoll, minRoll, 0, tipoDano, 0, custo);
    }

    protected int rolagemValor() {
        int valor = (int)(Math.random() * super.getMaxRoll()) + super.getMinRoll();
        return valor;
    }

    protected int rolagemValor(boolean isFraco) {
        int valor = (int)(Math.random() * super.getMaxRoll()) + super.getMinRoll();
        if(isFraco) {
            valor = valor*2;
        }
        return valor;
    }

    protected int causaDano(int damage, Criatura inimigo) {
        int vidaAtual = inimigo.setVida((inimigo.getVida())-damage);
        return vidaAtual;
    }

    protected int causaCura(int cura, Criatura aliado) {
        int vidaAtual = aliado.setVida((aliado.getVida()+cura));
        return vidaAtual;
    }

    public String usaHabilidade(Criatura usuario, Equipe inimigos, int alvo) {
        if(usuario.getEquipe() != inimigos.getId()) {
            int damage = rolagemValor(inimigos.get(alvo).getFraquezas(super.getTipoDano()));
            int vidaAtual = causaDano(damage, inimigos.get(alvo));
            return usuario.getNome() + " acertou " + inimigos.get(alvo).getNome() + " causando "
            + damage + " de dano, e o deixando com " + vidaAtual + " pontos de vida.";
        } else {
             int cura = rolagemValor();
             int vidaAtual = causaCura(cura, inimigos.get(alvo));
             return usuario.getNome() + " curou " + inimigos.get(alvo).getNome() + " " + cura + " pontos de vida, " + 
             "o deixando com " + vidaAtual;
        }
    }

    public String usaHabilidade(Criatura usuario, Equipe aliados) {
        int cura = rolagemValor();
        for (int i = 0; i<aliados.size(); i++) {
            causaCura(cura, aliados.get(i));
        }
        return usuario.getNome() + " curou " + cura + " pontos de vida de sua equipe.";
    }
}
