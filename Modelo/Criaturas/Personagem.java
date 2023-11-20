import java.util.ArrayList;
import java.util.List;

public class Personagem extends Criatura{
    
        private long id;

        private Classe classe;
        private List<Item> listaItens;

        private int experiencia;

        private int poder;

        //CONSTRUTOR COM TODOS OS PARÂMETROS 
        public Personagem(String nome, int classe, int armadura, int vida, int nivel, int poder) {
            super(nome, vida, armadura, nivel);
            this.poder = poder;

            this.classe = new Classe(classe);

            this.listaItens = new ArrayList<Item>();
        }

        //CONSTRUTOR BÁSICO, ONDE O JOGADOR SELECIONA UM NOME E UMA CLASSE PARA O PERSONAGEM
        public Personagem(String nome, int classe) {
            super(nome);
            this.classe = new Classe(classe);
            
            super.setAtributos(this.classe.getPadrao());

            this.listaItens = new ArrayList<Item>();
            this.experiencia = 0;

            super.setArmadura((5+super.getAtributos(0)+super.getNivel()));
            super.setVida((10+super.getAtributos(1))*super.getNivel());
            this.poder = ((10+super.getAtributos(2)+super.getNivel()));
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        //RETORNA O VALOR INTEIRO RELATIVO A CLASSE
        public int getClasse() {
            String nomeClasse = classe.getNome();
            switch(nomeClasse) {
                case "Guerreiro": {
                    return 1;
                }
                case "Ladino": {
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

        public List<Item> getItens() {
            return listaItens;
        }

        public Item getItem(int index) {
            return listaItens.get(index);
        }

        public String addItem(Item item) {
            listaItens.add(item);
            return item.getNome() + " foi adicionado ao inventário de " + super.getNome();
        }

        public String toString() {
            return super.getNome() + " é um " + classe.getNome() + " de nível " + super.getNivel();
        }

        //RECEBE UM ATRIBUTO AUMENTAR E O AUMENTA EM UM, DEFINE O NIVEL DO PERSONAGEM E O AUMENTA 
        public void subirNivel(int atributoAumentar) {
            super.setNivel(super.getNivel()+1);
            this.experiencia = 0;
            super.setAtributos(atributoAumentar, (super.getAtributos(atributoAumentar))+1);
        }
}
