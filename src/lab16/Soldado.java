package lab16;
import java.util.*;
public class Soldado {
    private int vida;
    private int defensa;
    private int ataque;

    public Soldado() {
        Random random = new Random();
        vida = random.nextInt(6) + 5;
        defensa = random.nextInt(6) + 5;
        ataque = random.nextInt(6) + 5;
    }

    public int getVida() {
        return vida;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getAtaque() {
        return ataque;
    }

    public double getPromedioEstadisticas() {
        return (vida + defensa + ataque) / 3.0;
    }
}
