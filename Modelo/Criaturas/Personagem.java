public class Personagem extends Criatura{
    
        private long id;
        private int poder;
        private Classe classe;

        //CONSTRUTOR COM TODOS OS PARÂMETROS 
        public Personagem(long id, String nome, int classe, int armadura, int vida, int nivel, int poder, int experiencia, long equipe) {
            super(nome, vida, armadura, nivel, experiencia, equipe);
            this.id = id;
            this.poder = poder;

            this.classe = new Classe(classe);
        }

        //CONSTRUTOR BÁSICO, ONDE O JOGADOR SELECIONA UM NOME E UMA CLASSE PARA O PERSONAGEM
        public Personagem(String nome, int classe) {
            super(nome);
            this.classe = new Classe(classe);
            
            super.setAtributos(this.classe.getPadrao());
            super.setFraquezas(this.classe.getListaFraquezas());
            super.setHabilidades(this.classe.getListaHabilidades());

            super.setArmadura((10+super.getAtributos(0)+super.getNivel()));
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

        public int getPoder() {
            return poder;
        }

        public void setPoder(int poder) {
            this.poder = poder;
        }

        public String toString() {
            return super.getNome() + " é um " + classe.getNome() + " de nível " + super.getNivel();
        }
}
