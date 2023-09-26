public final class Bloquear extends Habilidade{
    
    private static int id;
    private static String nome;
    private static String descricao;

    public Bloquear() {
        id = 2;
        nome = "Bloquear";
        descricao = "Você bloqueia o próximo ataque";
    }

    public static int habilidadeAtiva(Personagem usuario) {
        return 10;
    }

}
