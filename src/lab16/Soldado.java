package lab16;
import java.util.*; 

public class Soldado {
    private int ataque;
    private int defensa;
    private int vida;
    private static final Random random = new Random();

    public Soldado() {
        this.ataque = random.nextInt(10) + 1;
        this.defensa = random.nextInt(10) + 1;
        this.vida = random.nextInt(10) + 5;
    }

    public void recibirDanio(int danio) {
        this.vida -= danio;
        if (vida < 0) vida = 0;
    }

    public void incrementarVida(int cantidad) {
        this.vida += cantidad;
    }

    public int getVida() {
        return vida;
    }
}
