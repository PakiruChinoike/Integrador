public class Personagem extends Criatura{
    
        private Classe classe;
        private int agilidade;
        private int forca;
        private int inteligencia;

        public Personagem(int classe) {
            this.classe = new Classe(classe); 
            // switch(classe) {
            //     case 1: {
            //         this.classe = new Guerreiro();
            //         break;
            //     }
            //     case 2: {
            //         this.classe = new Ladino();
            //     }
            //     case 3: {
            //         this.classe = new Mago(); 
            //     }
            // }
            this.agilidade = this.classe.getPadrao(0);
            this.forca = this.classe.getPadrao(1);
            this.inteligencia = this.classe.getPadrao(2);
        }

        public Classe getClasse() {
            return classe;
        }

        public String getAtributos() {
            return "Agilidade: " + agilidade + "%nForça: " + forca + "%nInteligência: " + inteligencia;
        }
}
