package lab16;
import java.util.*;

public class Juego {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Mapa mapa = new Mapa(5);
        mapa.mostrarMapa();

        Ejercito ejercito1 = new Ejercito("Inglaterra");
        Ejercito ejercito2 = new Ejercito("Francia");

        System.out.println("Selecciona modo de batalla: 1) Rapida 2) Por Turnos");
        int opcion = scanner.nextInt();
        Ejercito ganador;

        if (opcion == 1) {
            ganador = Batalla.batallaRapida(ejercito1, ejercito2);
        } else {
            ganador = Batalla.batallaPorTurnos(ejercito1, ejercito2);
        }

        System.out.println("El ganador es el ejercito de: " + ganador.getReino());
        scanner.close();
    }
}