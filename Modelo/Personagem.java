public class Personagem extends Criatura{
    
        private int id;
        private Classe classe;
        private Equipe equipe;
        private int agilidade;
        private int forca;
        private int inteligencia;
        private int experiencia;
        private int nivel;

        public Personagem(int classe, int nivel) {
            super("Pakiru");
            this.nivel = nivel;
            this.classe = new Classe(classe); 
            switch(classe) {
                case 1: {
                    this.classe = new Guerreiro(1);
                    break;
                }
                case 2: {
                    this.classe = new Ladino(2);
                }
                case 3: {
                    this.classe = new Mago(3); 
                }
            }
            this.agilidade = this.classe.getPadrao(0);
            this.forca = this.classe.getPadrao(1);
            this.inteligencia = this.classe.getPadrao(2);
        }

        public int getId() {
            return id;
        }

        public Classe getClasse() {
            return classe;
        }

        public String getClasseNome() {
            return classe.getNome();
        }

        public Equipe getEquipe() {
            return equipe;
        }

        public String getAtributos() {
            return "Agilidade: " + agilidade + "%nForça: " + forca + "%nInteligência: " + inteligencia;
        }

        public int getAgilidade() {
            return agilidade;
        }

        public void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
        }

        public int getForca() {
            return forca;
        }

        public void setForca(int forca) {
            this.forca = forca;
        }

        public int getInteligencia() {
            return inteligencia;
        }

        public void setInteligencia(int inteligencia) {
            this.inteligencia = inteligencia;
        }

        public int getExperiencia() {
            return experiencia;
        }

        public void setExperiencia(int experiencia) {
            this.experiencia = experiencia;
        }

        public int getNivel() {
        return nivel;
        }

        public void setNivel(int nivel) {
            this.nivel = nivel;
        }

        public void subirNivel(int atributoAumentar) {
            this.nivel++;
            this.experiencia = 0;
            switch(atributoAumentar) {
                case 1: {
                    this.agilidade++;
                    break;
                }
                case 2: {
                    this.forca++;
                    break;
                }
                case 3: {
                    this.inteligencia++;
                }
            }
        }
}
