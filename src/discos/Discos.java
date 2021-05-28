/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discos;

import java.util.Scanner;

/**
 * Clase Disco
 * @author miguel_roman_parraga
 */
public class Discos {

    // N determina el tamaño del array
    static int N = 100;

    /**
     * Programa principal para controlar la clase
     * @param args
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        //Crea el array de discos
        Disco[] arrayAlbum = new Disco[N];

        // Crea todos los discos que van en cada una de
        // las celdas del array
        for (int i = 0; i < N; i++) {
            arrayAlbum[i] = new Disco();
        }

        int opcion;
        int i = 0;

        do {
            System.out.println("\n\nCOLECCIÓN DE DISCOS");
            System.out.println("===================");
            System.out.println("1. Listado");
            System.out.println("2. Nuevo disco");
            System.out.println("3. Modificar");
            System.out.println("4. Borrar");
            System.out.println("5. Salir");
            System.out.print("Introduzca una opción: ");
            opcion = Integer.parseInt(entrada.nextLine());

            switch (opcion) {
                case 1:
                    listado(i, arrayAlbum, false);
                    break;
                case 2:
                    nuevoDisco(arrayAlbum, entrada);
                    break;
                case 3:
                    i = modificarDisco(entrada, i, arrayAlbum);
                    break;
                case 4:
                    i = borrar(entrada, i, arrayAlbum);
                    break;
                default:

            } // switch
        } while (opcion != 5);
    }

    private static int borrar(Scanner entrada, int i, Disco[] arrayAlbum) {
        String codigoIntroducido;
        System.out.println("\nBORRAR");
        System.out.println("======");
        System.out.print("Por favor, introduzca el código del disco que desea borrar: ");
        codigoIntroducido = entrada.nextLine();
        int b = -1;
        do {
            b++;
        } while (!((arrayAlbum[i].getCodigo().equals(codigoIntroducido))));
        arrayAlbum[i].setCodigo("LIBRE");
        System.out.println("Album borrado.");
        return b;
    }

    private static int modificarDisco(Scanner entrada, int i, Disco[] arrayAlbum) throws NumberFormatException {
        String codigoIntroducido;
        String autorIntroducido;
        String tituloIntroducido;
        String generoIntroducido;
        String duracionIntroducidaString;
        System.out.println("\nMODIFICAR");
        System.out.println("===========");
        System.out.print("Por favor, introduzca el código del disco cuyos datos desea cambiar: ");
        codigoIntroducido = entrada.nextLine();
        i = -1;
        do {
            i++;
        } while (!((arrayAlbum[i].getCodigo().equals(codigoIntroducido))));
        System.out.println("Introduzca los nuevos datos del disco o INTRO para dejarlos igual.");
        System.out.println("Código: " + arrayAlbum[i].getCodigo());
        System.out.print("Nuevo código: ");
        codigoIntroducido = entrada.nextLine();
        if (!codigoIntroducido.equals("")) {
            arrayAlbum[i].setCodigo(codigoIntroducido);
        }
        System.out.println("Autor: " + arrayAlbum[i].getAutor());
        System.out.print("Nuevo autor: ");
        autorIntroducido = entrada.nextLine();
        if (!autorIntroducido.equals("")) {
            arrayAlbum[i].setAutor(autorIntroducido);
        }
        System.out.println("Título: " + arrayAlbum[i].getTitulo());
        System.out.print("Nuevo título: ");
        tituloIntroducido = entrada.nextLine();
        if (!tituloIntroducido.equals("")) {
            arrayAlbum[i].setTitulo(tituloIntroducido);
        }
        System.out.println("Género: " + arrayAlbum[i].getGenero());
        System.out.print("Nuevo género: ");
        generoIntroducido = entrada.nextLine();
        if (!generoIntroducido.equals("")) {
            arrayAlbum[i].setGenero(generoIntroducido);
        }
        System.out.println("Duración: " + arrayAlbum[i].getDuracion());
        System.out.print("Duración: ");
        duracionIntroducidaString = entrada.nextLine();
        if (!duracionIntroducidaString.equals("")) {
            arrayAlbum[i].setDuracion(Integer.parseInt(duracionIntroducidaString));
        }
        return i;
    }

    private static void nuevoDisco(Disco[] arrayAlbum, Scanner entrada) throws NumberFormatException {
        int primeraLibre;
        String codigoIntroducido;
        String autorIntroducido;
        String tituloIntroducido;
        String generoIntroducido;
        int duracionIntroducida;
        System.out.println("\nNUEVO DISCO");
        System.out.println("===========");
        // Busca la primera posición libre del array
        primeraLibre = -1;
        do {
            primeraLibre++;
        } while (!((arrayAlbum[primeraLibre].getCodigo().equals("LIBRE"))));
        System.out.println("Por favor, introduzca los datos del disco.");
        System.out.print("Código: ");
        codigoIntroducido = entrada.nextLine();
        arrayAlbum[primeraLibre].setCodigo(codigoIntroducido);
        System.out.print("Autor: ");
        autorIntroducido = entrada.nextLine();
        arrayAlbum[primeraLibre].setAutor(autorIntroducido);
        System.out.print("Título: ");
        tituloIntroducido = entrada.nextLine();
        arrayAlbum[primeraLibre].setTitulo(tituloIntroducido);
        System.out.print("Género: ");
        generoIntroducido = entrada.nextLine();
        arrayAlbum[primeraLibre].setGenero(generoIntroducido);
        System.out.print("Duración: ");
        duracionIntroducida = Integer.parseInt(entrada.nextLine());
        arrayAlbum[primeraLibre].setDuracion(duracionIntroducida);
    }

    private static void listado(int i, Disco[] arrayAlbum, boolean orden) {
        System.out.println("\nLISTADO");
        System.out.println("=======");
        for (i = 0; i < N; i++) {
            if (!arrayAlbum[i].getCodigo().equals("LIBRE")) {
                System.out.println(arrayAlbum[i]);
            }
        }
    }
}
