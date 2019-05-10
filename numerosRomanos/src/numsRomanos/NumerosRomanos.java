package numsRomanos;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/* @author Liz */
public class NumerosRomanos {
//1-1000 
    public static final String ANSI = "\u001B[32m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";


    public static Scanner entrada;
            
    public static List<String> unidades = Arrays.asList(
            "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX");
    public static List<String> decenas = Arrays.asList(
            "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC");
    public static List<String> centenas = Arrays.asList(
            "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM");
    public static String millar = "M";

    public static void main(String[] args) {
        String numeroIn;
        String numRomano;
        int entero;
        entrada = new Scanner(System.in);
         System.out.println(ANSI_BLACK_BACKGROUND + ANSI);
        System.out.println("****))  Numeración romana  ((****");
        System.out.println("Ingrese numeros y presione enter.  (Escriba # para salir)");
        numeroIn = entrada.nextLine();
        while (numeroIn.isEmpty()) {
            System.out.println("Entrada vacia.\n"
                    + "Volver a ingresar numeros:     (Escriba # para salir)");
            numeroIn = entrada.nextLine();
        }

        while ((int) numeroIn.charAt(0) != 35) { //confirmar que es gato (#), ascii 35
            if (esNumerico(numeroIn) && !numeroIn.contains(".")) {
                entero = Integer.parseInt(numeroIn);
                if (entero >= 1 && entero <= 1000) {
                    numRomano = convertir(numeroIn);
                    System.out.println("Romano: " + numRomano);
                } else {
                    System.out.println("Valor fuera de rango, permitidos del 1 a 1,000\n"
                            + "Volver a ingresar numeros:     (Escriba # para salir)");
                }
            } else {
                System.out.println("No es entero. No se permiten decimales ni letras\n"
                        + "Volver a ingresar numeros:     (Escriba # para salir)");
            }
            numeroIn = entrada.nextLine();
            while (numeroIn.isEmpty()) {
                System.out.println("Entrada vacia.\n"
                        + "Volver a ingresar numeros:     (Escriba # para salir)");
                numeroIn = entrada.nextLine();
            }
        }
        System.exit(0);

    }

    public static String convertir(String entero) {
        String salida = "";
        int[] digs2 = getEnteros(entero);

        int index = 0;//pos actual de los digitos M C D U
        int aux = 0;//digito a convertir romano
        switch (digs2.length - 1) {
            case 3:
                salida = millar;
//                salida += unidades.get(aux - 1) + " ";
//                System.out.println("millar ");
                break;
            case 2:
                aux = digs2[index];
                if (aux != 0) {//el 9 se encuentra en la pos 8 del array:
                    salida += centenas.get(aux - 1);
                }
//                System.out.println("centena " + aux);
                index++;
            case 1:
                aux = digs2[index];
                if (aux != 0) {
                    salida += decenas.get(aux - 1);
                }
//                System.out.println("decena " + aux);
                index++;
//                break;
            case 0:
                aux = digs2[index];
                if (aux != 0) {
                    salida += unidades.get(aux - 1);
                }
//                System.out.println("unidad " + aux);
//                break;
//            }
        }
//        System.out.println("salida " + salida);
        return salida;
    }

    public static boolean esNumerico(String cadena) {
//comprueba si toda la cadena es numerica
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException e) {
//            System.out.println("sonNumeros:La cadena no es un numero");
            return false;
        }
    }

    public static int[] getEnteros(String cadena) {
        int[] nums = new int[cadena.length()];
        String[] digitos = cadena.split("");
        for (int i = 0; i < digitos.length; i++) {
            nums[i] = Integer.parseInt(digitos[i]);
        }
        return nums;
    }

}
