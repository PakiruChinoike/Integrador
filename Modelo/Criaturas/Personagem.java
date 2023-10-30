import java.util.ArrayList;
import java.util.List;

public class Personagem extends Criatura{
    
        private long id;

        private Classe classe;
        private List<Item> listaItens;

        private int experiencia;

        private int poder;

        private Equipe equipe;

        public Personagem(String nome, int classe) {
            super(nome);
            this.classe = new Classe(classe);
            
            super.setAtributos(this.classe.getPadrao());
            super.setFraquezas(this.classe.getListaFraquezas());
            super.setHabilidades(this.classe.getListaHabilidades());

            this.listaItens = new ArrayList<Item>();

            super.setArmadura((5+super.getAtributos(0)+super.getNivel()));
            super.setVida((10+super.getAtributos(1))*super.getNivel());
            this.poder = ((10+super.getAtributos(2)+super.getNivel()));
        }

        public long getId() {
            return id;
        }

        public int getClasse() {
            String nomeClasse = classe.getNome();
            switch(nomeClasse) {
                case "Ladino": {
                    return 1;
                }
                case "Guerreiro": {
                    return 2;
                }
                case "Mago": {
                    return 3;
                }
                default: {
                    return 0;
                }
            }
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

        public Equipe getEquipe() {
            return equipe;
        }

        public void setEquipe(Equipe equipe) {
            this.equipe = equipe;
        }

        public List<Item> getListaItens() {
            return listaItens;
        }

        public String addItem(Item item) {
            listaItens.add(item);
            return item.getNome() + " foi adicionado ao inventário de " + super.getNome();
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
