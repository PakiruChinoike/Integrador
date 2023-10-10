import java.lang.Math;
import java.util.List;

public class Garantido extends Habilidade{
    
    private int maxRoll;
    private int minRoll;
    private int tipoDano;

    public Garantido(int id, String nome, String descricao, int maxRoll, int minRoll, int tipoDano) {
        super(id, nome, descricao);
        this.maxRoll = maxRoll;
        this.minRoll = minRoll;
        this.tipoDano = tipoDano;
    }

    protected int rolagemValor() {
        int valor = (int)(Math.random() * maxRoll) + minRoll;
        return valor;
    }

    protected int rolagemValor(boolean isFraco) {
        int valor = (int)(Math.random() * maxRoll) + minRoll;
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

    public String usaHabilidade(Personagem usuario, List<Criatura> inimigos, int alvo) {
        if(inimigos.get(0) instanceof Monstro) {
            int damage = rolagemValor(inimigos.get(alvo).getFraquezas(tipoDano));
            int vidaAtual = causaDano(damage, inimigos.get(alvo));
            return usuario.getNome() + " acertou " + inimigos.get(alvo).getNome() + " causando "
            + damage + " de dano, e o deixando com " + vidaAtual + " pontos de vida.";
        }else if(inimigos.get(0) instanceof Personagem) {
            int cura = rolagemValor();
            int vidaAtual = causaCura(cura, inimigos.get(alvo));
            return usuario.getNome() + " curou " + inimigos.get(alvo).getNome() + " " + cura + " pontos de vida, " + 
            " o deixando com " + vidaAtual;
        }
        else {
            return null;
        }
    }

    public String usaHabilidade(Monstro usuario, List<Criatura> inimigos, int alvo) {
        int damage = rolagemValor(inimigos.get(alvo).getFraquezas(tipoDano));
        int vidaAtual = causaDano(damage, inimigos.get(alvo));
        return usuario.getNome() + " acertou " + inimigos.get(alvo).getNome() + " causando "
        + damage + " de dano, e o deixando com " + vidaAtual + " pontos de vida.";
    }

    public String usaHabilidade(Personagem usuario, List<Criatura> aliados) {
        int cura = rolagemValor();
        for (int i = 0; i<aliados.size(); i++) {
            causaCura(cura, aliados.get(i));
        }
        return usuario.getNome() + " curou " + cura + " pontos de vida de sua equipe.";
    }

    public String usaHabilidade(Monstro usuario, List<Criatura> aliados ) {
        int cura = rolagemValor();
        for (int i = 0; i<aliados.size(); i++) {
            causaCura(cura, aliados.get(i));
        }
        return usuario.getNome() + " curou " + cura + " pontos de vida de sua equipe.";
    }
}
