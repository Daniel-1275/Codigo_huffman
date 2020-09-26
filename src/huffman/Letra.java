package huffman;

import java.util.ArrayList;
import java.util.List;

public class Letra {
    private final char letra;
    private int contador;
    private final List<Integer> binarioOptimo;

    public Letra(char letra) {
        this.letra = letra;
        this.contador = 1;
        binarioOptimo = new ArrayList<>();
    }

    public Letra(char letra, int contador) {
        this.letra = letra;
        this.contador = contador;
        binarioOptimo = new ArrayList<>();
    }

    public void aumentarContador(){
        this.contador++;
    }

    public void agregarBinario(Integer binario){
        binarioOptimo.add(binario);
    }
    public void agregarBinario(Letra letra){
        this.binarioOptimo.addAll(letra.binarioOptimo);
    }

    public char getLetra() {
        return letra;
    }

    public int getContador() {
        return contador;
    }

    public List<Integer> getBinarioOptimo() {
        return binarioOptimo;
    }

    @Override
    public String toString() {
        return "Letra{" +
                "letra=" + letra +
                ", contador=" + contador +
                '}';
    }
    public static Letra obtenerLetra(List<Letra> letras, char caracter){
        for(Letra letra: letras){
            if(letra.getLetra() == caracter){
                return letra;
            }
        }
        return null;
    }
}
