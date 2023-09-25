import java.util.ArrayList;

public class Personagem extends Criatura{
    
        private int id;
        private Classe classe;
        private ArrayList<Integer> listaHabilidades;
        private ArrayList<Boolean> listaFraquezas;

        private int agilidade;
        private int forca;
        private int inteligencia;

        private int experiencia;
        private int nivel;

        private int poder;

        public Personagem(String nome, int classe, int nivel) {
            super(nome);
            this.nivel = nivel; 
            switch(classe) {
                case 1: {
                    this.classe = new Classe(1);
                    break;
                }
                case 2: {
                    this.classe = new Classe(2);
                    break;
                }
                case 3: {
                    this.classe = new Classe(3); 
                    break;
                }
            }
            this.agilidade = this.classe.getPadrao(0);
            this.forca = this.classe.getPadrao(1);
            this.inteligencia = this.classe.getPadrao(2);

            this.listaHabilidades = new ArrayList<Integer>();
            this.listaHabilidades.addAll(this.classe.getListaHabilidades());

            this.listaFraquezas = new ArrayList<Boolean>();
            this.listaFraquezas.addAll(this.classe.getListaFraquezas());

            super.setVida((10+forca)*nivel);
            super.setArmadura((10+agilidade+nivel));
            this.poder = ((10+inteligencia+nivel));
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

        public int getPoder() {
            return poder;
        }

        public void setPoder(int poder) {
            this.poder = poder;
        }

        public ArrayList<Integer> getListaHabilidades() {
            return listaHabilidades;
        }

        public String toString() {
            return super.getNome() + " é um " + classe.getNome() + " de nível " + nivel;
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
