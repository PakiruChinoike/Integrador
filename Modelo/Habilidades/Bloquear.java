public class Bloquear extends Habilidade{
    
    public Bloquear() {
        super(2, "Bloquear", "Protege um aliado de um ataque próximo.");
    }

    public static int habilidadeAtiva(Personagem usuario) {
        return 10;
    }

}
