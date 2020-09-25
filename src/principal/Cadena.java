package principal;

public class Cadena {
    private final Letra letraIzquierda;
    private final Letra letraDerecha;

    public Cadena(Letra letraIzquierda, Letra letraDerecha) {
        this.letraIzquierda = letraIzquierda;
        this.letraDerecha = letraDerecha;
    }

    public Letra getLetraIzquierda() {
        return letraIzquierda;
    }

    public Letra getLetraDerecha() {
        return letraDerecha;
    }

    @Override
    public String toString() {
        return  letraIzquierda.getLetra() + " -- " + letraDerecha.getLetra();
    }
}
