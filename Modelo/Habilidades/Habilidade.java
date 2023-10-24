import java.util.List;

public abstract class Habilidade {

    private long id;
    private String nome;
    private String descricao;

    protected Habilidade(int id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public abstract String usaHabilidade(Personagem usuario, List<Criatura> inimigos, int alvo);

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

}
