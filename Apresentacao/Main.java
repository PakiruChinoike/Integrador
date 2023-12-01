import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
    
        List<Criatura> listaJogadores = new ArrayList<>();
        listaJogadores.addAll(Metodos.criarPersonagens(3));

        Equipe jogadores = new Equipe(1, listaJogadores);

        Sala sala = new Sala(0, 0, 5, "Entrada", "Pênis Roxo...");

        List<Criatura> listaMonstros = new ArrayList<>();
        MonstroDAO monstroDAO = new MonstroDAO();
        Monstro hidra = monstroDAO.buscar(1);
        Monstro elemental = monstroDAO.buscar(2);
        listaMonstros.add(hidra);
        listaMonstros.add(elemental);

        RecompensaDAO recompensaDAO = new RecompensaDAO();

        sala.addInimigos(listaMonstros);
        sala.setRecompensa(recompensaDAO.buscar(sala.getId()));

        List<Sala> listaSalas = new ArrayList<>();
        listaSalas.add(sala);

        Fase fase = new Fase("rola", listaSalas);

        Metodos.realizaTentativa(fase);

    }

}