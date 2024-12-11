/* 
Cosas por hacer:
    - Comprobar cuadrado hecho (extremos hecho, falta en centro)
    - Si Jugador completa cuadrado, vuelve a jugar
    
    - Caso 2
        - El programa cargará la última partida guardada, y pudiendo continuarla en el mismo punto donde se dejó cuando se guardó misma situación del tablero y mismo turno de jugador. 
        - La partida se cargará de un fichero amado “partidaGuardada.txt” situado en el mismo directorio “ficheros” que en la opción anterior.
*/ 

// Importo las librerias necesarias
import java.util.Scanner;
// Importo las librerias necesarias relacionadas con el tema de leer y escribir ficheros en java
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
// Libreria para la fecha de las partidas
import java.time.LocalDate;


public class practica {
    public static void main(String[] args){
        // Creo el objeto scanner
        Scanner sc = new Scanner(System.in);

        // ################################################################ //
        // DEFINICION DE LAS VARIABLES QUE VOY A USAR A LO LARGO DEL CODIGO //
        // ################################################################ //
        int opcion_menu;    // Variable para la seleccion del menu principal
        boolean loop_menu = false;      // Variable para que en el menu se responda correctamente
        boolean dimensiones_validas = false; // Variable para que las dimensiones del tablero sean validas
        String jugador_1 = " ";   // Variable para establecer el nombre al jugador 1 (opcional)
        String jugador_2 = " ";   // Variable para establecer el nombre al jugador 2 (opcional)
        boolean loop_game = false;  // Variable para el bucle de la partida
        double resultado = 0;    // Dado para ver quien empieza jugando entre J1 y J2
        boolean entrada_valida = false;     // Entrada del jugador que sea valida
        String jugada = " ";
        int puntuacion_1 = 0;
        int puntuacion_2 = 0;
        boolean selector = true;
        int filas = 0;
        int columnas = 0;
        

        // Limpio el terminal para mayor claridad visual
        limpiar_terminal();

        // Mostramos por pantalla el menu de inicio del juego
        imprime_menu();
        
        System.out.print("Elije una opcion... ");
        opcion_menu = sc.nextInt();

        // Pedimos la opcion y realizamos comprobaciones para que sea una opcion correcta
        // No se puede salir del bucle hasta que la entrada sea valida
        while(!loop_menu){
            // Creamos un switch para el menu
            switch(opcion_menu) {
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
                    limpiar_terminal();
                    muestra_resultados();
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
            System.out.println("┌─────────────────────────────────────────────────┐");
            System.out.println("│ DIMENSIONES DEL TABLERO                         │");
            System.out.println("├─────────────────────────────────────────────────┤");
            System.out.println("│ Inserte las dimensiones del tablero             │");
            System.out.println("│ Nota: Las dimensiones deben ser como maximo 5x5 │");
            System.out.println("└─────────────────────────────────────────────────┘");
            System.out.print("");
            System.out.print("Numero de filas: ");
            filas = sc.nextInt();
            System.out.print("Numero de columnas: ");
            columnas = sc.nextInt();

            
            
            while(!dimensiones_validas){
                // Si las filas no son validas, muestro el error por pantalla y las vuelvo a pedir
                if (filas < 1 || filas > 5){
                    System.out.print("");
                    System.out.println("Dimensiones de las filas no validas...");
                    System.out.print("");
                    System.out.println("El numero de filas debe ser entre 1 y 5");
                    System.out.print("Inserte las filas deseadas de nuevo: ");
                    filas = sc.nextInt();

                    System.out.print("");
                }
                // Si las columnas no son validas, muestro el error por pantalla y las vuelvo
                else if (columnas < 1 || columnas > 5){
                    System.out.print("");
                    System.out.println("Dimensiones de las columnas no validas...");
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

            limpiar_terminal();

            System.out.println("┌─────────────────────────────────────────────────┐");
            System.out.println("│ NOMBRE DE LOS JUGADORES                         │");
            System.out.println("└─────────────────────────────────────────────────┘");

            // Pregunto el nombre de los jugadores
            System.out.print("Inserte el nombre para el Jugador 1: ");
            jugador_1 = sc.next();
            System.out.print("Inserte el nombre para el Jugador 2: ");
            jugador_2 = sc.next();

            // 1. Generamos la matriz del tablero
            char[][] matriz = new char[2*filas + 1][2 * columnas + 1];
            // 2. Generamos y asignamos la estructura del tablero
            matriz = genera_tablero(matriz, filas, columnas);

            limpiar_terminal();

            //-------------//
            // BUCLE JUEGO //
            //-------------//
            // INICIO PRIMER TURNO
            
            // Mostramos por pantalla la informacion de la partida
            info_partida(matriz, jugador_1, jugador_2, puntuacion_1, puntuacion_2);

            // Primer turno
            resultado = (Math.random() < 0.5) ? 1 : 2;
            if(resultado == 1){
                selector = true;
                turno_jugador(selector, jugada, entrada_valida, matriz, filas, columnas, jugador_1, jugador_2, puntuacion_1, puntuacion_2, sc);
                // Ahora ejecutamos la jugada y mostramos el tablero actualizado
                // No hace falta comprobar si se completan cuadritos por ser la primera jugada
                realiza_jugada(matriz, jugada, filas, columnas);
            
            }else {
                selector = false;
                turno_jugador(selector, jugada, entrada_valida, matriz, filas, columnas, jugador_1, jugador_2, puntuacion_1, puntuacion_2, sc);
                // Ahora ejecutamos la jugada y mostramos el tablero actualizado
                // No hace falta comprobar si se completan cuadritos por ser la primera jugada
                realiza_jugada(matriz, jugada, filas, columnas);
            }

            // Resto de la partida
            while(!loop_game){
                info_partida(matriz, jugador_1, jugador_2, puntuacion_1, puntuacion_2);

                System.out.println("");

                // Cambiamos el valor de selector para que cambie de jugador
                if(!selector){
                    selector = true;
                }else {
                    selector = false;
                }

                turno_jugador(selector, jugada, entrada_valida, matriz, filas, columnas, jugador_1, jugador_2, puntuacion_1, puntuacion_2, sc);
                
                // Compruebo si quedan jugadas disponibles
                if(jugadas_disponibles(matriz) == false){
                    loop_game = true;
                }
            }

            // Guardo los datos de la partida
            escribe_resultado(filas, columnas, puntuacion_1, puntuacion_2, jugador_1, jugador_2);
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
                    matriz[fil][col] = '■'; //•
                
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
    } // Fin render_matriz

    
    // Funcion para validar la entrada de las jugadas
    // Entrada --> Char (por teclado), Char[][] matriz, int filas, int columnas
    // Salida --> boolean
    public static boolean valida_entrada (String jugada, char[][] matriz, int filas, int columnas){
        // Convierto la jugada de string a char para poder compararla con las posibilidades de la matriz
        char input = jugada.charAt(0);

        if(jugada == "**"){

        }

        // Compruebo que la longitud de la cadena sea valida (minimo 1 y maximo 2 para el caso de salir y guardar)
        if(jugada.length() < 1 || jugada.length() > 2){
            return false;
        }

        // Compruebo el resto de casos
        // Tenemos que comprobar que la jugada este disponible en la matriz
        // Recorro el array en busca de la jugada insertada
        // En caso de que la jugada no se encuentre, sera una entraa no valida
        for(int fil = 0; fil < 2*filas+1; fil++){
            for(int col = 0; col < 2*columnas+1; col++){
                if(matriz[fil][col] == input){
                    return true;
                }
            }
        }

        // En caso de que no sea valido, devolvemos false
        return false;
    } // Fin valida_entrada

    public static void guarda_sal(){
        
    }


    // Funcion que realiza las jugadas en la matriz
    // Entrada --> char jugada
    // Salida --> char[][] matriz
    public static char[][] realiza_jugada(char[][] matriz, String jugada, int filas, int columnas){
        // Cambio de string a char la jugada
        char input = jugada.charAt(0);

        // Recorro la matriz para encontrar la posicion indicada para la jugada
        for(int col = 0; col < matriz[0].length; col++){
            for(int fil = 0; fil < matriz.length; fil++){
                // Comprobamos si la jugada tiene que ser vertical u horizontal
                // Vertical
                if(col % 2 == 0 && matriz[fil][col] == input){
                    matriz[fil][col] = '│';

                // Horizontal
                }else if(fil % 2 == 0 && matriz[fil][col] == input){
                    matriz[fil][col] = '─';
                }
            }
        }
        return matriz;
    } // Fin realiza_jugada

    // Funcion que comprueba si quedan jugadas disponibles en el tablero
    // Entrada:
    // Salida:
    public static boolean jugadas_disponibles(char[][] matriz) {
        for (int fil = 0; fil < matriz.length; fil++) {
            for (int col = 0; col < matriz[fil].length; col++) {
                // Comprobamos si la celda contiene un carácter que representa una jugada
                if ((matriz[fil][col] >= 'A' && matriz[fil][col] <= 'Z') || (matriz[fil][col] >= 'a' && matriz[fil][col] <= 'z') || (matriz[fil][col] >= '0' && matriz[fil][col] <= '9')) {
                    return true; // Hay al menos una jugada disponible
                }
            }
        }
        return false; // No hay jugadas disponibles
    }

    // Funcion que comprueba si se ha cerrado un cuadrado
    // Entrada: char[][] matriz, String jugada, int filas, int columnas
    // Salida: char[][] matriz (con el cuadro resuelto en caso de que haya exito con la jugada)
    public static void comprueba_cuadritos(char[][] matriz, String jugada, int filas, int columnas, boolean selector, int puntuacion_1, int puntuacion_2, Scanner sc){    
        // Variables para la fila y columna de la posicion de la jugada
        int pos_fila = 0;
        int pos_columna = 0;
        char pos = jugada.charAt(0);
        char equis = ' ';
        boolean punto = false;

        // Recupero la posicion exacta de la jugada
        for(int fil = 0; fil < matriz.length; fil++){
            for(int col = 0; col < matriz[0].length; col++){
                if(matriz[fil][col] == pos){
                    pos_fila = fil;
                    pos_columna = col;
                }
            }
        }

        // Jugador 1 --> '#'
        // Jugador 2 --> '×'
        if(selector == true){
            equis = '×';
        }else {
            equis = '#';
        }
        
        // Compruebo por separado las esquinas
        // Comprueo para el borde para fila = 0
        if(pos_fila == 0){
            if(matriz[pos_fila + 2][pos_columna] == '─' && matriz[pos_fila + 1][pos_columna - 1] == '│' && matriz[pos_fila + 1][pos_columna + 1] == '│'){
                matriz[pos_fila + 1][pos_columna] = equis;
                punto = true;
            }
        }
        // Compruebo el borde para la fila = 10
        if(pos_fila == 10){
            if(matriz[pos_fila - 2][pos_columna] == '─' && matriz[pos_fila - 1][pos_columna - 1] == '│' && matriz[pos_fila - 1][pos_columna + 1] == '│'){
                matriz[pos_fila - 1][pos_columna] = equis;
                punto = true;
            }
        }


        // Compruebo para la columna = 0
        if(pos_columna == 0){
            if(matriz[pos_fila - 1][pos_columna + 1] == '─' && matriz[pos_fila + 1][pos_columna + 1] == '─' && matriz[pos_fila][pos_columna + 2] == '│'){
                matriz[pos_fila][pos_columna + 1] = equis;
                punto = true;
            }
        }
        // Compruebo para la columna = 10
        if(pos_columna == 10){
            if(matriz[pos_fila - 1][pos_columna - 1] == '─' && matriz[pos_fila + 1][pos_columna - 1] == '─' && matriz[pos_fila][pos_columna - 2] == '│'){
                matriz[pos_fila][pos_columna - 1] = equis;
                punto = true;
            }
        }

        // Para el resto de casos (fila [2,8] y columna [2,8])
        
        
        if(selector == true && punto == true){
            puntuacion_1++;
       
        }else if(selector == false && punto == true) {
            puntuacion_2++;
            
        }
    }


    public static void info_partida(char[][] matriz, String jugador_1, String jugador_2, int puntuacion_1, int puntuacion_2){
        // Limpiamos la terminal
        limpiar_terminal();
        // Mostramos el mensaje para notificar en caso de querer parar la partida
        System.out.println("┌───────────────────────────────────────────────────────────────┐");
        System.out.println("│ Introduzca [**] en caso de querer guardar la partida y salir. │");
        System.out.println("└───────────────────────────────────────────────────────────────┘");

        System.out.println("┌──────────────────────────┐");
        System.out.println("│ PUNTUACION DE LA PARTIDA │");
        System.out.println("├──────────────────────────┤");
        System.out.printf("│ [J1] %-10s:     %d   │\n", jugador_1, puntuacion_1);
        System.out.printf("│ [J2] %-10s:     %d   │\n", jugador_2, puntuacion_2);
        System.out.println("└──────────────────────────┘");
        // Mostramos el tablero en pantalla
        render_matriz(matriz);
    }

    public static void turno_jugador(boolean selector, String jugada, boolean entrada_valida, char[][] matriz, int filas, int columnas, String jugador_1, String jugador_2, int puntuacion_1, int puntuacion_2, Scanner sc){
        // Variable para declarar el turno de cada jugador
            // true --> Jugador 1
            // false --> Jugador 2
         
        if(selector == true){
            // Turno jugador 1
            System.out.print("[J1] " + jugador_1 + " su turno: ");
            jugada = sc.next();

            entrada_valida = valida_entrada(jugada, matriz, filas, columnas);
            while(!entrada_valida){
                System.out.println("Jugada no valida, inserte la jugada de nuevo: ");
                jugada = sc.next();
                entrada_valida = valida_entrada(jugada, matriz, filas, columnas);
            }
            comprueba_cuadritos(matriz, jugada, filas, columnas, selector, puntuacion_1, puntuacion_2, sc);
            realiza_jugada(matriz, jugada, filas, columnas);

        }else {
            // Turno jugador 2
            System.out.print("[J2] " + jugador_2 + " su turno: ");
            jugada = sc.next();

            entrada_valida = valida_entrada(jugada, matriz, filas, columnas);
            while(!entrada_valida){
                System.out.println("Jugada no valida, inserte la jugada de nuevo: ");
                jugada = sc.next();
                entrada_valida = valida_entrada(jugada, matriz, filas, columnas);
            }

            comprueba_cuadritos(matriz, jugada, filas, columnas, selector, puntuacion_1, puntuacion_2, sc);
            realiza_jugada(matriz, jugada, filas, columnas);
        }
    }// Fin turno_jugador



    // Caso 3 guardar datos
    public static void escribe_resultado(int filas, int columnas, int puntuacion_1, int puntuacion_2, String jugador_1, String jugador_2){
        // Ruta y nombre del archivo
        String ruta = "src\\ficheros\\resultados.txt";
        File archivo = new File(ruta);

        // Guardo las variables que me interesa almacenar
        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();
        // Guardar la fecha en una variable
        String fecha = fechaActual.toString();
        String dimensiones_tablero = filas + "x" + columnas;



        try (FileWriter escritor = new FileWriter(archivo, true)) {
            // Escribimos en el archivo los datos requeridosS
            escritor.write("Fecha: " + fecha + "; Dimensiones: " + dimensiones_tablero + "; Puntuaciones: [J1]" + jugador_1 + ": " + puntuacion_1 + "; [J2]" + jugador_2 + ": " + puntuacion_2 + "\n");

        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public static void muestra_resultados(){
        // Ruta y nombre del archivo
        String ruta = "src\\ficheros\\resultados.txt";
        File archivo = new File(ruta);

        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea); // Muestra cada línea del archivo
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }


} // Fin de la clase