package lab16;
import java.util.Random;

public class Mapa {
    private String tipoTerritorio;
    private Ejercito[][] tablero;
    private Random random = new Random();
    private static final String[] TERRITORIOS = {"bosque", "campo abierto", "montaña", "desierto", "playa"};

    public Mapa(int dimension) {
        this.tipoTerritorio = generarTerritorioAleatorio();
        this.tablero = new Ejercito[dimension][dimension];
        posicionarEjercitos();
    }

    private String generarTerritorioAleatorio() {
        return TERRITORIOS[random.nextInt(TERRITORIOS.length)];
    }

    private void posicionarEjercitos() {
        // logica para crear y posicionar ejercitos aleatoriamente en el tablero
        // asegurando que cada ejercito tenga entre 1 y 10 soldados y que no haya guerra civil
        // ejemplo basico, a personalizar para la logica deseada
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (random.nextBoolean()) {
                    tablero[i][j] = new Ejercito(generarNombreReino());
                    tablero[i][j].aplicarBonusTerritorio(tipoTerritorio);
                }
            }
        }
    }

    private String generarNombreReino() {
        // genera aleatoriamente uno de los dos reinos en guerra
        return random.nextBoolean() ? "Inglaterra" : "Francia";
    }

    public void mostrarMapa() {
        System.out.println("Territorio: " + tipoTerritorio);
        for (Ejercito[] fila : tablero) {
            for (Ejercito e : fila) {
                System.out.print((e != null ? e.getReino().charAt(0) : "-") + " ");
            }
            System.out.println();
        }
    }

    public String getTipoTerritorio() {
        return tipoTerritorio;
    }
}

