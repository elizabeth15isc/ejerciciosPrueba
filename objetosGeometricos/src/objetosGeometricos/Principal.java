package objetosGeometricos;

import java.util.Scanner;

/*@author Liz*/
public class Principal {

    public static final String ANSI = "\u001B[34m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";

    public static Scanner entrada;

    public static void main(String[] args) {
        Cuadrado cuadro;
        Cubo cubo;
        double dato;
        String aux;
        String salida = "";
        int opcion1, opcion2;
        boolean hayError;

        entrada = new Scanner(System.in);
         System.out.println(ANSI_BLACK_BACKGROUND + ANSI);
        System.out.println("****))  Figuras geometricas.  ((****\n");
        do {
            do {//comprueba que el dato sea double, hasta entonces seguirá con el programa
                System.out.println("Inicio.     Ingrese la longitud del lado:");
                aux = entrada.nextLine();
                if (aux.isEmpty()) {
                    hayError = true;
                    System.out.println("Entrada vacia. debe ingresar un número");
                } else if (!esDouble(aux)) {
                    hayError = true;
                    System.out.println("Entrada ilegal. solo se permiten números");
                } else {
                    hayError = false;
//                    System.out.println("correcto");
                }
            } while (hayError);
            dato = Double.parseDouble(aux);//ya comprobado, guarda el dato
//            System.out.println("dato double:" + dato);

            opcion1 = opcion2 = 0;
            do {
                System.out.println("Longitud del lado: ( " + dato + " )");

                System.out.println("Menú de opciones:");
                System.out.println("1) Calcular área de un cuadrado ");
                System.out.println("2) Calcular perímetro de un cuadrado");
                System.out.println("3) Calcular volumen de un cubo ");
                System.out.println("4) Calcular perímetro de un cubo");
                System.out.println("5) Cancelar");//vuelve a inicio
                System.out.println("6) Salir del programa");
                do {
                    opcion1 = opcion2 = 0;
                    aux = entrada.nextLine();
                    if (aux.isEmpty()) {
                        hayError = true;
                        System.out.println("Entrada vacia. Debe seleccinar una opcion");
                    } else if (!esEntero(aux)) {
                        hayError = true;
                        System.out.println("Solo se permiten números enteros");
                    } else {
                        opcion1 = Integer.parseInt(aux);
//                System.out.println("convirtio " + opcion1);
                        if (opcion1 >= 1 && opcion1 <= 6) {
                            hayError = false;
//                    System.out.println("rango correcto");
                        } else {
                            hayError = true;
                            System.out.println("Solo permite las opciones del 1 al 6");
                        }
                    }
//            System.out.println("seleccion: " + opcion1);
                } while (hayError);
                if (opcion1 == 6) {
                    System.exit(0);
                }

                if (opcion1 != 5) {
                    switch (opcion1) {
                        case 1://area cuadro
                            cuadro = new Cuadrado(dato);
//                            cuadro.calcularArea();
                            salida = "" + cuadro.calcularArea();
                            break;
                        case 2://perimetro cuadro
                            cuadro = new Cuadrado(dato);
//                            cuadro.calcularPerimetro();
                            salida = "" + cuadro.calcularPerimetro();
                            break;
                        case 3://volumen cubo
                            cubo = new Cubo(dato);
                            salida = "" + cubo.calcularVolumen();
                            break;
                        case 4://perimetro cubo
                            cubo = new Cubo(dato);
                            salida = "" + cubo.calcularPerimetro();
                            break;
                    }
//                    System.out.println("Resultado: " + salida + "\n");

                    do {
                        System.out.println("1) Volver al menú      2) Volver a iniciar");
                        aux = entrada.nextLine();
                        if (aux.isEmpty()) {
                            hayError = true;
                            System.out.println("Entrada vacia. debe seleccinar una opcion");
                        } else if (esEntero(aux) && ((aux.equals("1") || aux.equals("2")))) {
                            opcion2 = Integer.parseInt(aux);
                            hayError = false;
                        } else {
                            System.out.println("Solo permiten opciones 1 y 2");
                            hayError = true;
                        }
                    } while (hayError);
                } else {
                    opcion2 = 2;
                }
            } while (opcion2 == 1);
        } while (opcion2 == 2);
    }

    public static boolean esEntero(String cadena) {
        try {
            Integer.parseInt(cadena);
//            System.out.println("es un entero");

            return true;
        } catch (Exception e) {
//            System.out.println("La cadena no es entero");
            return false;
        }
    }

    public static boolean esDouble(String cadena) {
//comprueba si toda la cadena es numerica
        try {
            Double.parseDouble(cadena);
//            System.out.println("es un double");

            return true;
        } catch (Exception e) {
//            System.out.println("La cadena no es un numero");
            return false;
        }
    }

    /*
     case 5://volver a inicio
                        opcion2 = 2;
                        break;
                    case 6://salir
                        System.exit(0);
                        break;
    
                    case 6://salir
                        System.exit(0);
                        break;
     */
}
