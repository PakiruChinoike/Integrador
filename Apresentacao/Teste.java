import java.util.List;
import java.util.ArrayList;

public class Teste {
    
    public static void main(String[] args) {

        MonstroDAO monstroDAO = new MonstroDAO();

        Monstro hidra = monstroDAO.buscar(1);
        Monstro elemental = monstroDAO.buscar(2);

        List<Criatura> listaMonstros = new ArrayList<>();
        listaMonstros.add(hidra);
        listaMonstros.add(elemental);

        Equipe monstros = new Equipe(0, listaMonstros);


        List<Criatura> listaJogadores = new ArrayList<>();
        listaJogadores.addAll(Metodos.criarPersonagens(3));

        Equipe jogadores = new Equipe(1, listaJogadores);

        Metodos.realizarEncontro(jogadores, monstros);
    }

}
