// https://campusvirtual.uva.es/pluginfile.php/6320700/mod_resource/content/2/%5BFPRO%5D%20Enunciado%20Pr%C3%A1ctica%20v1.3.pdf

package Practica;

import java.util.Scanner;


public class practica {
    public static void main(String[] args){
        // Creo el objeto scanner
        Scanner sc = new Scanner(System.in);
        
        // Limpio el terminal para mayor claridad visual
        limpiar_terminal();

        // Mostramos por pantalla el menu de inicio del juego
        imprime_menu();
        
        System.out.print("Elije una opcion...");
        int opcion_menu = sc.nextInt();

        // Pedimos la opcion y realizamos comprobaciones para que sea una opcion correcta
        boolean loop_menu = false;      // No se puede salir del bucle hasta que la entrada sea valida
        while(!loop_menu){

            // Creamos un switch para el menu
            switch (opcion_menu) {
                case 0:
                // Si la opcion es 0, volvemos a mostrar el menu
                    limpiar_terminal();
                    imprime_menu();
                    break;

                // Nuevo juego
                case 1:
                    loop_menu = true;
                    System.out.println("Caso 1");
                    break;

                // Cargar partida
                case 2:
                    loop_menu = true;
                    System.out.println("Caso 2");
                    break;
            
                // Ver Resultados
                case 3:
                    loop_menu = true;
                    System.out.println("Caso 3");
                    break;

                // Salir del programa
                case 4:
                    loop_menu = true;
                    System.out.println("");
                    System.out.println("Terminando el programa...");
                    System.out.println("");
                    System.exit(0);
                    break;

                // Opcion insertada no valida, volvemosa pedirlo
                default:
                    limpiar_terminal();
                    System.out.println("Opcion insertada no valida, inserte una opcion valida...");
                    imprime_menu();
                    System.out.print("Elije una opcion...");
                    opcion_menu = sc.nextInt();
                    break;
            }
        }


        // Dependiendo de la opcion seleccionada en el switch, se ejecutara el caso correspondiente
        // Si la opcion es 1, se piden las dimensiones del tablero y se inicia el juego
        if (opcion_menu == 1) {
            // Limpiamos el terminal por claridad visual
            limpiar_terminal();

            // Pedimos las dimensiones del tablero
            System.out.println("Inserte las dimensiones del tablero");
            System.out.println("Nota: Las dimensiones deben ser como maximo 5x5");
            System.out.print("");
            System.out.print("Numero de filas: ");
            int filas = sc.nextInt();
            System.out.print("Numero de columnas: ");
            int columnas = sc.nextInt();

            
            boolean dimensiones_validas = false;
            while(!dimensiones_validas){
                // Si las filas no son validas, muestro el error por pantalla y las vuelvo a pedir
                if (filas < 1 || filas > 5){
                    System.out.print("");
                    System.out.println("Dimensiones no validas...");
                    System.out.print("");
                    System.out.println("El numero de filas debe ser entre 1 y 5");
                    System.out.print("Inserte las filas deseadas de nuevo: ");
                    filas = sc.nextInt();

                    System.out.print("");
                }
                // Si las columnas no son validas, muestro el error por pantalla y las vuelvo
                else if (columnas < 1 || columnas > 5){
                    System.out.print("");
                    System.out.println("Dimensiones no validas...");
                    System.out.print("");
                    System.out.println("El numero de columnas debe ser entre 1 y 5");
                    System.out.print("Inserte las columnas deseadas de nuevo: ");
                    columnas = sc.nextInt();

                    System.out.print("");
                }
                
                // Las dimensiones son validas, salimos del bucle para continuar con el juego
                if(filas >= 1 && filas <= 5 && columnas >= 1 && columnas <= 5){
                    System.out.println("Las dimensiones insertadas son validas...");
                    System.out.println("Generando tablero para la partida...");
                    dimensiones_validas = true;
                }
            }

            System.out.println("");

            // Pregunto el nombre de los jugadores
            System.out.print("Inserte el nombre del Jugador 1: ");
            String jugador_1 = sc.next();

            System.out.println("");

            System.out.print("Inserte el nombre del Jugador 2: ");
            String jugador_2 = sc.next();
            
            System.out.println("");

            // 1. Generamos la matriz del tablero
            char[][] matriz = new char[2*filas + 1][2 * columnas + 1];
            // 2. Generamos y asignamos la estructura del tablero
            matriz = genera_tablero(matriz, filas, columnas);

            String jugada;

            // Creamos el bucle del juego
            boolean loop_game = false;
            while(!loop_game){
                // Mostramos el mensaje para notificar en caso de querer parar la partida
                System.out.println("┌─────────────────────────────────────────────────────────────────┐");
                System.out.println("│ Introduzca [ ** ] en caso de querer guardar la partida y salir. │");
                System.out.println("└─────────────────────────────────────────────────────────────────┘");

                System.out.println("");

                // Mostramos el tablero en pantalla
                render_matriz(matriz);

                System.out.println("");
                System.out.println("");

                // Turno jugador 1
                System.out.print("[J1] " + jugador_1 + " su turno: ");
                jugada = sc.next();

                // Validamos que la entrada sea valida
                while(!valida_entrada(jugada)){
                    System.out.println("Jugada no valida, inserte la jugada de nuevo: ");
                    jugada = sc.next();
                }

                // Ahora ejecutamos la jugada



                // Turno jugador 2
                System.out.print("[J2] " + jugador_2 + " su turno: ");
                jugada = sc.next();

            }












            // Comprobamos que la entrada sea valida ()
        }else if(opcion_menu == 2){

        }


        // Ciouto el objeto scanner
        sc.close();
    }











    /////////////
    // METODOS //
    /////////////
    // Limpiar la terminal con saltos de linea
    public static void limpiar_terminal(){
        for (int i = 0; i < 100; i++){
            System.out.println();
        }
        System.out.println();
    }
    

    // Imprimir el menu
    public static void imprime_menu(){
        // Creamos el menu para el inicio del juego
        System.out.println("┌─────────────────────────────┐");
        System.out.println("│ Bienvenido a ¡La Conquista! │");
        System.out.println("├─────────────────────────────┤");
        System.out.println("│ 1. Nuevo Juego              │");
        System.out.println("│ 2. Cargar Partida           │");
        System.out.println("│ 3. Ver Resultados           │");
        System.out.println("│ 4. Salir                    │");
        System.out.println("└─────────────────────────────┘");
    }


    // Generador del tablero
    // Entrada: 2 Variables (Filas [1, 5], columnas [1, 5])
    // Salida: Matriz de 2n+1 Filas x 2n+1 columnas
    public static char[][] genera_tablero(char[][] matriz, int filas, int columnas){
        // Corrigo el valor de las filas y las columnas en base de la funcion 2n + 1
        int row = 2 * filas + 1;
        int colum = 2 * columnas + 1;

        // Creo la variable para asignar las letras
        char letra_mayusc = 'A';
        char letra_min = 'a';
        char nums = '0';


        // Recorremos las filas de la matriz y las columnas
        for(int fil = 0; fil < row; fil++){
            for(int col = 0; col < colum; col++){
                // Asigno a cada posicion de la matriz, el valor correspondiente
                // En las filas y columnas pares asignamos el "■"
                if(fil % 2 == 0 && col % 2 == 0){
                    matriz[fil][col] = '•';
                
                // En las que no son pares, el valor para cada jugada [A,Z], [a, z], [0, 9] 
                }else if(fil % 2 != 0 && col % 2 != 0){
                    matriz[fil][col] = ' ';

                }else{
                    if (letra_mayusc <= 'Z'){
                        matriz[fil][col] = letra_mayusc;
                        letra_mayusc++;
                    
                    // Si todas las mayusculas se han usado, pasamos a usar las minusculas
                    }else if(letra_min <= 'z'){
                        matriz[fil][col] = letra_min;
                        letra_min++;
                    }else if(nums <= '9'){
                        matriz[fil][col] = nums;
                        nums++;
                    }
                }
            }
        }
        return matriz;
    }


    // Funcion para mostrar el tablero
    public static void render_matriz(char[][] matriz) {
        for (int i = 0; i < matriz.length; i++) { // Recorrer filas
            for (int j = 0; j < matriz[i].length; j++) { // Recorrer columnas
                System.out.print(matriz[i][j] + " "); // Imprimir elemento
            }
            System.out.println(); // Nueva línea después de cada fila
        }
    }

    
    // Funcion para validar la entrada de las jugadas
    // Entrada --> Char (por teclado)
    // Salida --> boolean
    public static boolean valida_entrada (char jugada){
        // Tenemos que comprobar que la jugada este disponible

        
        return true;
    }


    // Funcion que realiza las jugadas en la matriz
    // Entrada --> char jugada
    // Salida --> char[][] matriz
    public static char[][] realiza_jugada(char[][] matriz, char jugada){
        
        
        return matriz;
    }


}
