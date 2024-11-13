package lab16;
import java.util.*;

public class Tablero {
    private String[][] tablero;
    private Random random;

    public Tablero(Reino norte, Reino sur) {
        tablero = new String[10][10];
        random = new Random();
        colocarEjercitos(norte);
        colocarEjercitos(sur);
    }

    private void colocarEjercitos(Reino reino) {
        for (Ejercito ejercito : reino.getEjercitos()) {
            int x, y;
            do {
                x = random.nextInt(10);
                y = random.nextInt(10);
            } while (tablero[x][y] != null);
            tablero[x][y] = ejercito.getId();
        }
    }

    public void mostrarTablero() {
        for (String[] fila : tablero) {
            for (String celda : fila) {
                System.out.print((celda != null ? celda : " . ") + " ");
            }
            System.out.println();
        }
    }

    public void moverEjercito(Reino reino, Scanner scanner) {
        System.out.println("Selecciona el ejercito que quieres mover:");
        ArrayList<Ejercito> ejercitos = reino.getEjercitos();
        for (int i = 0; i < ejercitos.size(); i++) {
            System.out.println(i + ": " + ejercitos.get(i).getId());
        }
        int opcion = scanner.nextInt();
        Ejercito ejercito = ejercitos.get(opcion);

        System.out.println("Selecciona la direccion (1: arriba, 2: abajo, 3: izquierda, 4: derecha):");
        int direccion = scanner.nextInt();

        moverEjercitoEnTablero(ejercito, direccion, reino);
    }

    private void moverEjercitoEnTablero(Ejercito ejercito, int direccion, Reino reino) {
        int[] posicion = encontrarPosicion(ejercito.getId());
        if (posicion == null) return;

        int x = posicion[0];
        int y = posicion[1];
        tablero[x][y] = null;

        switch (direccion) {
            case 1 -> x = Math.max(x - 1, 0);
            case 2 -> x = Math.min(x + 1, 9);
            case 3 -> y = Math.max(y - 1, 0);
            case 4 -> y = Math.min(y + 1, 9);
        }

        if (tablero[x][y] == null) {
            tablero[x][y] = ejercito.getId();
        } else {
            Ejercito enemigo = encontrarEjercito(tablero[x][y], reino);
            if (enemigo != null) {
                resolverBatalla(ejercito, enemigo, reino);
            }
        }
    }

    private void resolverBatalla(Ejercito ejercito, Ejercito enemigo, Reino reino) {
        System.out.println("Batalla entre " + ejercito.getId() + " y " + enemigo.getId());
        if (new Random().nextBoolean()) {
            if (ejercito.getPromedioEstadisticas() > enemigo.getPromedioEstadisticas()) {
                System.out.println(ejercito.getId() + " gana la batalla!");
                reino.removerEjercito(enemigo);
            } else {
                System.out.println(enemigo.getId() + " gana la batalla!");
                reino.removerEjercito(ejercito);
            }
        } else {
            System.out.println("Batalla por turnos - aun no implementada");
        }
    }

    private int[] encontrarPosicion(String id) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (id.equals(tablero[i][j])) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private Ejercito encontrarEjercito(String id, Reino reino) {
        for (Ejercito ejercito : reino.getEjercitos()) {
            if (ejercito.getId().equals(id)) {
                return ejercito;
            }
        }
        return null;
    }
}
