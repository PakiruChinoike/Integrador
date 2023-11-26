import java.util.List;
import java.util.ArrayList;

public class Teste {
    
    public static void main(String[] args) {

        MonstroDAO monstroDAO = new MonstroDAO();

        Monstro hidra = monstroDAO.buscar(1);
        Monstro elemental = monstroDAO.buscar(2);

        List<Criatura> monstros = new ArrayList<>();
        monstros.add(hidra);
        monstros.add(elemental);
        
        List<Criatura> jogadores = new ArrayList<>();
        jogadores.addAll(Metodos.criarPersonagens(3));

        Metodos.realizarEncontro(jogadores, monstros);

    }

}
