import java.util.ArrayList;
import java.util.List;

public class Personagem extends Criatura{
    
        private int id;
        private Classe classe;
        private List<Habilidade> listaHabilidades;
        private List<Item> listaItens;

        private int experiencia;

        private int poder;

        private Equipe equipe;

        public Personagem(String nome, int classe) {
            super(nome);
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
            super.setHabilidades(this.classe.getListaHabilidades());

            this.listaItens = new ArrayList<Item>();

            super.setArmadura((5+super.getAtributos(0)+super.getNivel()));
            super.setVida((10+super.getAtributos(1))*super.getNivel());
            this.poder = ((10+super.getAtributos(2)+super.getNivel()));
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

        public int getPoder() {
            return poder;
        }

        public void setPoder(int poder) {
            this.poder = poder;
        }

        public List<Habilidade> getListaHabilidades() {
            return listaHabilidades;
        }

        public Equipe getEquipe() {
            return equipe;
        }

        public void setEquipe(Equipe equipe) {
            this.equipe = equipe;
        }

        public List<Item> getListaItens() {
            return listaItens;
        }

        public String toString() {
            return super.getNome() + " é um " + classe.getNome() + " de nível " + super.getNivel();
        }

        public void subirNivel(int atributoAumentar) {
            super.setNivel(super.getNivel()+1);
            this.experiencia = 0;
            super.setAtributos(atributoAumentar, (super.getAtributos(atributoAumentar))+1);
        }
}
