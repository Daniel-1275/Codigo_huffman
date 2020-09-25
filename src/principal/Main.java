package principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite una cadena: ");
        String line = entrada.nextLine();

        List<Letra> letras = new ArrayList<>();

        for (int i = 0; i < line.length(); i++) {
            char caracter_leido = line.charAt(i);
            if (letras.isEmpty()) {
                Letra letra = new Letra(caracter_leido);
                letras.add(letra);
            } else {
                if (esNuevoCaracter(letras, caracter_leido)) {
                    Letra letra = new Letra(caracter_leido);
                    letras.add(letra);
                } else {
                    Letra repetida = Letra.obtenerLetra(letras, caracter_leido);
                    if (repetida != null) {
                        repetida.aumentarContador();
                    }
                }
            }
        }


        List<Letra> letrasHuffman = new ArrayList<>(letras);
        List<Cadena> cadenas = new ArrayList<>();

        while (letrasHuffman.size() != 1) {

            Letra letra1 = letra_menor_frecuencia(letrasHuffman);
            Letra letra2 = letra_menor_frecuencia(letrasHuffman);

            cadenas.add(new Cadena(letra1,letra2));
            Letra letracomb = new Letra(letra1.getLetra(), letra1.getContador() + letra2.getContador());

            letrasHuffman.add(letracomb);
        }


        List<List<Cadena>> niveles = new ArrayList<>();
        List<Cadena> lista = new ArrayList<>();

        for (int i = cadenas.size() - 1; i >= 0; i--){
            Cadena cadena_actual = cadenas.get(i);
            if (niveles.isEmpty()){
                List<Cadena> nivelInicial = new ArrayList<>();
                nivelInicial.add(cadena_actual);
                niveles.add(nivelInicial);
            }else{
                if (!lista.isEmpty()) {
                    if (hayInterseccion(lista, cadena_actual)) {
                        niveles.add(new ArrayList<>(lista));
                        lista.clear();
                    }
                }
                lista.add(cadena_actual);
            }
            if (i == 0 && !lista.isEmpty()){
                niveles.add(new ArrayList<>(lista));
                lista.clear();
            }
        }
        for (int i = 0; i < niveles.size(); i++){
            List<Cadena> nivel = niveles.get(i);
            for (Cadena cadena: nivel){
                Letra izq = Letra.obtenerLetra( letras, cadena.getLetraIzquierda().getLetra() );
                Letra der = Letra.obtenerLetra( letras, cadena.getLetraDerecha().getLetra() );
                if (i == 0){
                    if (izq != null) {
                        izq.agregarBinario(0);
                    }
                    if (der!= null) {
                        der.agregarBinario(1);
                    }
                }else{
                    if (der != null) {
                        if (izq != null) {
                            der.agregarBinario(izq);
                            der.agregarBinario(1);
                            izq.agregarBinario(0);
                        }
                    }
                }
            }
        }
        print(letras);


        int total = 0;
        for (Letra letra: letras){
            total += (letra.getContador()) * letra.getBinarioOptimo().size();
        }
        System.out.print("\nNumero de bits utilizados: " + total);

        System.out.println();
    }
    public static boolean hayInterseccion(List<Cadena> cadenasList, Cadena cadena_comparar) {
        List<Letra> letrasActuales = new ArrayList<>();

        Letra li = cadena_comparar.getLetraIzquierda();
        Letra ld = cadena_comparar.getLetraDerecha();

        for (Cadena cad: cadenasList){
          Letra i = cad.getLetraIzquierda();
          Letra d = cad.getLetraDerecha();

          letrasActuales.add(i);
          letrasActuales.add(d);
        }

        return !esNuevoCaracter(letrasActuales, li.getLetra())  || !esNuevoCaracter(letrasActuales, ld.getLetra());


    }
    public static void print(List<Letra> letras){

        System.out.println("\nTenemos la siguiente tabla: ");
        System.out.println();
        System.out.println(" |  Letra  |   Contador  |        Huffman        |");
        System.out.println(" +---------+-------------+-----------------------+ ");

        for (Letra letra : letras) {

            System.out.printf(" |    %s    |      %-2d     |  %-15s      |", letra.getLetra(), letra.getContador(), letra.getBinarioOptimo());
            System.out.println();
        }

    }
    public static boolean esNuevoCaracter(List<Letra> letras, char caracter){
        for (Letra letra : letras) {
            char caracterArreglo = letra.getLetra();
            if (caracter == caracterArreglo) {
                return false;
            }
        }
        return true;
    }

    public static Letra letra_menor_frecuencia(List<Letra> letras){

        Letra menor_letra = letras.get(0);

        for (Letra letra : letras) {
            if (letra.getContador() < menor_letra.getContador()) {
                menor_letra = letra;
            }
        }
        letras.remove(menor_letra);

        return menor_letra;
    }

}
