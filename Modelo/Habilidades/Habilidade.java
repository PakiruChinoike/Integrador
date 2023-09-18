public abstract class Habilidade {

    protected String nome;
    protected String descricao;

    public Habilidade(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    protected abstract boolean habilidadeAtiva();

}
