public class Classe {
    
    private String nome;
    private ArrayList<Int> padrao;

    public Classe(int tipo) {

        padrao = new ArrayList(Int);

        switch(tipo) {
            case 1: {
                this.nome = "Guerreiro";
                padrao.add(2, 3, 1);
            }
            case 2: {
                this.nome = "Ladino";
                padrao.add(3, 2, 1);
            }
            case 3: {
                this.nome = "Mago";
                padrao.add(2, 1, 3);
            }
        }

    }

    public ArrayList<Int> getPadrao() {
        return padrao;
    }

}
