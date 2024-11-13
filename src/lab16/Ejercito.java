package lab16;
import java.util.*;

public class Ejercito {
    private String reino;
    private List<Soldado> soldados;
    private static final Random random = new Random();

    public Ejercito(String reino) {
        this.reino = reino;
        this.soldados = new ArrayList<>();
        generarSoldadosAleatorios();
    }

    private void generarSoldadosAleatorios() {
        int cantidadSoldados = random.nextInt(10) + 1;
        for (int i = 0; i < cantidadSoldados; i++) {
            soldados.add(new Soldado());
        }
    }

    public void aplicarBonusTerritorio(String territorio) {
        if ((reino.equals("Inglaterra") && territorio.equals("bosque")) ||
            (reino.equals("Francia") && territorio.equals("campo abierto"))) {
            for (Soldado s : soldados) {
                s.incrementarVida(1);
            }
        }
    }

    public String getReino() {
        return reino;
    }

    public int obtenerVidaTotal() {
        int totalVida = 0;
        for (Soldado s : soldados) {
            totalVida += s.getVida();
        }
        return totalVida;
    }

    public boolean estaVivo() {
        return !soldados.isEmpty();
    }
}
