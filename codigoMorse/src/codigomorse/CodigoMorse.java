package codigomorse;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*@author Liz */
public class CodigoMorse {

    public static final String ANSI_MAGENTA = "\u001B[35m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";

    public static List<String> abecedario = Arrays.asList(
            "a", "b", "c", "d", "e",//linea 1 
            "f", "g", "h", "i", "j",//linea 2
            "k", "l", "m", "n", "o",//linea 3
            "p", "q", "r", "s", "t",//linea 4
            "u", "v", "w", "x", "y", "z",//linea 5
            "1", "2", "3", "4", "5",//linea 6 nums
            "6", "7", "8", "9", "0");//linea 7
    public static List<String> morse = Arrays.asList(
            ".-", "-...", "-.-.", "-..", ".",//linea 1
            "..-.", "--.", "....", "..", ".---",//linea 2
            "-.-", ".-..", "--", "-.", "---",//linea 3
            ".--.", "--.-", ".-.", "...", "-",//linea 4
            "..-", "...-", ".--", "-..-", "-.--", "--..",//linea 5
            ".----", "..---", "...--", "....-", ".....",//linea 6 nums
            "-.", "--...", "---..", "----.", "-----");//linea 7
    public static String tipo = "init";
    public static Scanner entrada;

    public static void main(String[] args) {
        String aux1;
        String aux2;
        entrada = new Scanner(System.in);
        System.out.println(ANSI_BLACK_BACKGROUND + ANSI_MAGENTA
                + "****))  Bienvenido al traductor Morse  ((****");
        System.out.println("Solo ingrese el texto a convertir y presione enter.\n"
                + "De igual manera ingrese codigo morse y lo convertirá a texto.");
        System.out.println("Ingrese texto o codigo a convertir:   (Escriba # para salir)");

        aux1 = entrada.nextLine();
        while (aux1.isEmpty()) {
            System.out.println("Codigo ilegible.");
            System.out.println("Volver a ingresar:     (Escriba # para salir));");
            aux1 = entrada.nextLine();
        }
        while ((int) aux1.charAt(0) != 35) { //confirmar que es gato (#), ascii 35
            if (esCodigoLegible(aux1)) {
//                System.out.println("tipo: " + tipo);
                switch (tipo) {
//                    case "especial":
//                        System.out.println("Se recibio codigo ilegible. Volver a ingresar texto:");
//
//                        aux1 = entrada.nextLine();
//                        break;
                    case "letra":
                        aux2 = traduceAMorse(aux1);
                        System.out.println("Convirtió a morse:\n" + aux2);
                        break;
                    case "morse":
                        aux2 = traduceATexto(aux1);
                        System.out.println("Convirtió a texto:\n" + aux2);
                        break;

                }
            }
            System.out.println("Volver a ingresar:     (Escriba # para salir)");
            aux1 = entrada.nextLine();
            while (aux1.isEmpty()) {
                System.out.println("Codigo ilegible");
                aux1 = entrada.nextLine();
            }
        }
        System.exit(0);

    }

    public static boolean esCodigoLegible(String cadena) {
        tipo = esEspecial4(cadena.charAt(0));
        for (int i = 0; i < cadena.length(); i++) {
//                System.out.println("tipo: " + tipo);
            if (!tipo.equalsIgnoreCase(esEspecial4(cadena.charAt(i)))
                    || tipo.equalsIgnoreCase("especial")) {
                System.out.println("Codigo ilegible.\n"
                        + "Volver a ingresar texto:       (Escriba # para cerrar)");
                return false;
            }
        }
        return true;
    }

    public static String esEspecial4(char caracter) {
        //coparará el primer valor con todos los demas para determinar 
        //que tipo de cadena es. si todos los caracteres son del mismo tipo 
        //entonces es una cadena leible, si no se considerará ilegible
        String tipoAux = "init";
        if (caracter == 45 || caracter == 46) {//morse, ascii del 45 y 46
            tipoAux = "morse";
        } else if (Character.isLetter(caracter)//letras, ascii del 65 al 90
                || (Character.isDigit(caracter) && caracter != '.')) {//numeros ascii 48 al 57
            tipoAux = "letra";
        } else if (caracter == 32) {//espacio en blanco ascii 32
//            tipoAux = "blank";
            tipoAux = tipo;// si es morse se vuelve morse, si es letra se vuelve letra.
        } else {
            tipoAux = "especial";
        }
        return tipoAux;
    }

    public static String traduceAMorse(String texto) {
        String salidaMorse = "";
        texto = texto.toLowerCase();
        for (int pos = 0; pos < texto.length(); pos++) {
            if (texto.charAt(pos) != ' ') {
                int index = abecedario.indexOf("" + texto.charAt(pos));
//                System.out.println("index: " + index + " caracter: " + texto.charAt(pos));
                salidaMorse += morse.get(index) + " ";
            } else {
                salidaMorse += "   ";
            }
        }
        salidaMorse = salidaMorse.trim();
        return salidaMorse;
    }

    public static String traduceATexto(String codigo) {
        String salidaTexto = "";
        int ilegibles = 0;
        String[] palabras = codigo.split("   ");//detectará separacion de 3 esp
        for (String palabra : palabras) {
            String[] letras = palabra.split(" ");
            for (String letra : letras) {
                int index = morse.indexOf(letra);
                if (index != -1) {
                    salidaTexto += abecedario.get(index);
                } else {
                    salidaTexto += " _ ";
                    ilegibles++;
                }
            }
            salidaTexto += " ";
        }
        salidaTexto = salidaTexto.trim();
        if (salidaTexto.contains("_")) {
            salidaTexto += " (" + ilegibles + ")letras ilegibles.";
        }
        return salidaTexto;
    }

}
