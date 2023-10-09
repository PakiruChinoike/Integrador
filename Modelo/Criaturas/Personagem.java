import java.util.ArrayList;
import java.util.List;

public class Personagem extends Criatura{
    
        private int id;
        private Classe classe;
        private List<Habilidade> listaHabilidades;
        private List<Item> listaItens;

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
            super.setAtributos(this.classe.getPadrao());
            super.setFraquezas(this.classe.getListaFraquezas());

            this.listaHabilidades = new ArrayList<Habilidade>();
            this.listaHabilidades.addAll(this.classe.getListaHabilidades());

            super.setArmadura((5+super.getAtributos(0)+nivel));
            super.setVida((10+super.getAtributos(1))*nivel);
            this.poder = ((10+super.getAtributos(2)+nivel));
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

        // public void subirNivel(int atributoAumentar) {
        //     this.nivel++;
        //     this.experiencia = 0;
        //     switch(atributoAumentar) {
        //         case 1: {
        //             this.agilidade++;
        //             break;
        //         }
        //         case 2: {
        //             this.forca++;
        //             break;
        //         }
        //         case 3: {
        //             this.inteligencia++;
        //         }
        //     }
        //}
}
