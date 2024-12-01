// Enunciado => https://campusvirtual.uva.es/pluginfile.php/5408664/mod_resource/content/10/Enunciado-P-2023-24.pdf

package Practica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class practicaDefinitiva {
    public static void main(String[] args) {
        // Creo el objeto scanner
        Scanner scanner = new Scanner(System.in);

        limpiadorTerminal();

        System.out.print("############### M E N U ###############");
        System.out.println(); // Salto de linea
        System.out.println(); // Salto de linea
        System.out.println(); // Salto de linea

        // Opciones del menu
        System.out.print("1. Ver las normas");
        System.out.println(); // Salto de linea
        System.out.println(); // Salto de linea
        System.out.print("2. Como  se juega");
        System.out.println(); // Salto de linea
        System.out.println(); // Salto de linea
        System.out.print("3. Creditos");
        System.out.println(); // Salto de linea
        System.out.println(); // Salto de linea
        System.out.println("4. JUGAR!");
        System.out.println(); // Salto de linea
        System.out.println(); // Salto de linea
        System.out.print("Por favor, inserte la accion que desea realizar: ");

        // Variable para navegar a traves del menu
        int opcionMenu = scanner.nextInt();

        // Meto el switch en un bucle de forma que sea infinito y lo evaluo con la
        // siguiente variable
        boolean finMenu = false;
        // Compruebo la accion que desea realizar el jugador
        while (finMenu == false) {
            switch (opcionMenu) {
                case 0:
                    limpiadorTerminal();

                    System.out.print("################### M E N U ###################");
                    System.out.println(); // Salto de linea
                    System.out.println(); // Salto de linea
                    System.out.println(); // Salto de linea

                    // Opciones del menu
                    System.out.print("1. Ver las normas");
                    System.out.println(); // Salto de linea
                    System.out.println(); // Salto de linea
                    System.out.print("2. Como  se juega");
                    System.out.println(); // Salto de linea
                    System.out.println(); // Salto de linea
                    System.out.print("3. Creditos");
                    System.out.println(); // Salto de linea
                    System.out.println(); // Salto de linea
                    System.out.println("4. JUGAR!");
                    System.out.println(); // Salto de linea
                    System.out.println(); // Salto de linea
                    System.out.print("Por favor, inserte la accion que desea realizar: ");

                    opcionMenu = scanner.nextInt();
                    break;

                case 1:
                    limpiadorTerminal();
                    System.out.println("############### N O R M A S ###############");

                    System.out.println(); // Salto de linea
                    System.out.println(); // Salto de linea

                    System.out.print("Las normas del juego son las siguientes: ");
                    System.out.println(); // Salto de linea
                    System.out.println(); // Salto de linea
                    System.out.print("Norma 1: Cada casilla debe contener uno de los 2 valores posibles ('x' / 'o').");
                    System.out.println(); // Salto de linea
                    System.out.println(); // Salto de linea
                    System.out.println("Norma 2: Por cada fila, debe haber el mismo numero de casillas de cada valor.");
                    System.out.print(
                            "Y lo mismo para las columnas, debe haber el mismo numero de casillas de cada elemento.");
                    System.out.println(); // Salto de linea
                    System.out.println(); // Salto de linea
                    System.out.print("Norma 3: No debe haber mas de 2 valores iguales en casillas contiguas.");
                    System.out.println(); // Salto de linea
                    System.out.println(); // Salto de linea
                    System.out.println(); // Salto de linea
                    System.out.println(); // Salto de linea
                    System.out.print("Inserte '0' para volver al menu anterior: ");

                    opcionMenu = scanner.nextInt();
                    break;

                case 2:
                    limpiadorTerminal();
                    System.out.println("############### C O M O   J U G A R ###############");

                    System.out.println(); // Salto de linea
                    System.out.println(); // Salto de linea

                    System.out.print("La forma de jugar es la siguiente: ");
                    System.out.println(); // Salto de linea
                    System.out.println(); // Salto de linea
                    System.out
                            .println("Paso 1: Se te pedira la jugada que desea realizar, ha de ser del formato 'nC' ");
                    System.out.println("    n -> Es un numero correspondiente a la fila");
                    System.out.print("    C -> Letra MAYUSCULA correspondiente a las columnas.");
                    System.out.println(); // Salto de linea
                    System.out.println(); // Salto de linea
                    System.out.print(
                            "Paso 2: Justo debajo, te aparecera el tablero con el movimiento realizado y te volvera a pedir la jugada que desea realizar.");
                    System.out.println(); // Salto de linea
                    System.out.println(); // Salto de linea
                    System.out.print(
                            "Paso 3: Para realizar las jugadas, insertara las coordenadas primero indicando la fila y luego la columna (3C).");
                    System.out.println(); // Salto de linea
                    System.out.println(); // Salto de linea
                    System.out.print("Paso 4: Si quiere volver atras en las jugadas, inserte '-'.");
                    System.out.println(); // Salto de linea
                    System.out.println(); // Salto de linea
                    System.out.print("Paso 5: Para finalizar la partida, pulse 'intro'.");
                    System.out.println();
                    System.out.println();
                    System.out.print("Inserte '0' para volver al menu anterior: ");

                    opcionMenu = scanner.nextInt();
                    break;

                case 3:
                    limpiadorTerminal();

                    System.out.println("############### C R E D I T O S ###############");
                    System.out.println(); // Salto de linea
                    System.out.println("Practica hecha por: ");
                    System.out.print("Alejandro Garcia Lavandera y David Blasco Polo");
                    System.out.println(); // Salto de linea
                    System.out.println();
                    System.out.print("Curso: 2023 - 2024");
                    System.out.println();
                    System.out.println(); // Salto de linea
                    System.out.print("Inserte '0' para volver al menu anterior: ");

                    opcionMenu = scanner.nextInt();
                    break;

                case 4:
                    // Muestro un menu para que el jugador eliga la dificultad del juego
                    limpiadorTerminal();

                    // Salimos del menu
                    finMenu = true;

                    break;

                default:
                    // El valor insertado no es valido, muestro el mensaje por pantalla y vuelov a
                    // pedir el numero

                    limpiadorTerminal();

                    System.out.println("############### E R R O R ###############");
                    System.out.println(); // Salto de linea
                    System.out.println("El numero insertado no es valido...");
                    System.out.println("Por favor, inserte de nuevo el numero de la opcion deseada: ");
                    System.out.println(); // Salto de linea

                    System.out.println("############### M E N U ###############");
                    System.out.println(); // Salto de linea
                    // Opciones del menu
                    System.out.print("1. Ver las normas");
                    System.out.println(); // Salto de linea
                    System.out.println(); // Salto de linea
                    System.out.print("2. Como  se juega");
                    System.out.println(); // Salto de linea
                    System.out.println(); // Salto de linea
                    System.out.print("3. Creditos");
                    System.out.println(); // Salto de linea
                    System.out.println(); // Salto de linea
                    System.out.println("4. JUGAR!");
                    System.out.println(); // Salto de linea
                    System.out.println(); // Salto de linea
                    System.out.print("Por favor, inserte la accion que desea realizar: ");

                    opcionMenu = scanner.nextInt();
                    break;
            }
        }

        limpiadorTerminal();
        int LongditudTablero = 6;
        // Creo una matriz que almacene al tablero
        int[][] tablero = new int[LongditudTablero][LongditudTablero];
        // Array que almacena las jugadas y el contador que lleva la cuenta inversa
        int[] almacenJugadas = new int[69420];
        int contadorJugadas = 0;
        int recuperaciones = 1;

        String jugada = "";
        int fila = 0;
        int columna = 0;
        boolean finPartida = true;

        int contPartidas = 1;
        int contVictorias = 0;
        double porcentajeVictorias = 0;

        tablero = generadorTablero(tablero, LongditudTablero);
        mostrarTablero(tablero);

        while (finPartida) {
            jugada = "";

            System.out.print("Inserte la jugada que desea realizar: ");
            jugada = verificaJugada(LongditudTablero);

            if (!jugada.equals("finPartida")) {
                // Retrocedemos una la jugada tantas veces como el usuario quiera
                if (jugada.equals("-")) {
                    if ((contadorJugadas - recuperaciones) < 0) {
                        System.out.println("No hay jugadas disponibles para recuperar.");
                    } else {
                        // Recupero la jugada inmediatamente anterior
                        int jugadaAnterior = almacenJugadas[contadorJugadas - recuperaciones];
                        recuperaciones++;

                        // Extraigo la fila y la columna
                        fila = jugadaAnterior / 10;
                        columna = jugadaAnterior % 10;

                        // Recuperamos la jugada inmediatamente anterior
                        recuperarJugada(fila, columna, tablero);
                    }

                } else {
                    // Extraigo la fila y la columna
                    fila = extraeFila(jugada);
                    columna = extraeColumna(jugada);

                    // Almaceno la jugada realizada
                    almacenaJugadasUsuario(fila, columna, almacenJugadas, contadorJugadas);
                    contadorJugadas++;

                    // Inserto la jugada en el tablero
                    tablero = realizarJugada(fila, columna, tablero);
                }

                System.out.println(); // Salto de linea
                System.out.println(); // Salto de linea
                System.out.println(); // Salto de linea

                // Muestro el tablero
                mostrarTablero(tablero);
            } else {

                System.out.println("Va a finalizar la partida, ¿Esta seguro de hacerlo?");

                // Pregunto si quiere volver a jugar
                System.out.println("¿Quieres volver a jugar?");
                System.out.println("En caso de que quiera retomar la partida, inserte: \"Volver\"");
                System.out.println("Si / No: ");
                jugada = scanner.next();

                if (jugada.length() == 2 && jugada.toUpperCase().equals("SI")) {
                    // Limpio el almacen de jugadas
                    for (int cont = 0; cont < almacenJugadas.length; cont++) {
                        almacenJugadas[cont] = 0;
                    }
                    contadorJugadas = 0;
                    recuperaciones = 1;

                    // Sumo un intento a la partida
                    contPartidas++;
                    limpiadorTerminal();

                    // Si todas las verificaciones son validas, es una victoria
                    System.out.println("Resumen de las reglas del tablero finalizado: ");
                    System.out.println();
                    if (tableroRellenado(tablero) && tresElementosIguales(tablero)
                            && compruebaFilasRepetidas(tablero, LongditudTablero)
                            && compruebaColumnasRepetidas(tablero, LongditudTablero)) {
                        contVictorias++;

                        System.out.println();
                        System.out.println();

                        System.out.println("¡¡ ENHORABUENA !!");
                        System.out.println("El tablero es valido");
                        System.out.println("Victorias: " + contVictorias);
                    }

                    System.out.println();
                    System.out.println();
                    System.out.println();

                    tablero = generadorTablero(tablero, LongditudTablero);
                    mostrarTablero(tablero);

                } else if (jugada.length() == 2 && jugada.toUpperCase().equals("NO")) {

                    limpiadorTerminal();

                    System.out.println("¿Sera un tablero valido segun las normas?");
                    System.out.println();

                    if (tableroRellenado(tablero) && tresElementosIguales(tablero)
                            && compruebaFilasRepetidas(tablero, LongditudTablero)
                            && compruebaColumnasRepetidas(tablero, LongditudTablero)) {
                        contVictorias++;

                        System.out.println();
                        System.out.println();

                        System.out.println("¡¡ ENHORABUENA  !!");
                        System.out.println("El tablero es valido");
                        System.out.println("Victorias: " + contVictorias);
                    }

                    System.out.println();
                    System.out.println();

                    System.out.println("Tus estadisticas son: ");
                    System.out.println("Tableros jugados: " + contPartidas);
                    porcentajeVictorias = (((double) contVictorias) / ((double) contPartidas)) * 100;
                    System.out.println("Porcentaje de victorias: " + porcentajeVictorias + "%");

                    System.out.println();
                    System.out.println();

                    System.out.println("Nos vemos en la proxima partida!!");

                    finPartida = false;
                } else {
                    System.out.println(); // Salto de linea
                    System.out.println(); // Salto de linea
                    System.out.println(); // Salto de linea

                    // Muestro el tablero
                    mostrarTablero(tablero);
                }
            }
        }

        // Cierro el objeto scanner
        scanner.close();
    }

    // #################################### //
    // ########## M E T O D 0 S ########### //
    // #################################### //

    // Funcion que limpia la terminal
    public static void limpiadorTerminal() {
        for (int contador = 0; contador < 73; contador++) {
            System.out.println();
        }
    }

    // Funcion que genera el tablero
    public static int[][] generadorTablero(int[][] tablero, int longditudTablero) {
        // Especifico la ruta del archivo
        String rutaArchivo = "/workspaces/FPRO-Pr-ctica-2023/tableros.txt";

        // Variable para almacenar la linea leida del archivo
        String[] lineaLeida = new String[24];

        // Abro el archivo
        try {
            // Creo un objeto scanner para leer el archivo
            Scanner scannerTableros = new Scanner(new File(rutaArchivo));

            // Leo una fila entera del archivo
            int cont = 0;
            while (scannerTableros.hasNextLine()) {
                // System.out.print("Linea leida: " + scannerTableros);
                lineaLeida[cont] = scannerTableros.nextLine();
                cont++;
            }
            // Cierro el objeto scanner
            scannerTableros.close();

            // En caso de que haya algun problema a la hora de encontrar el archivo, manda
            // un mensaje de error
        } catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado: " + rutaArchivo);
            System.err.println("Por favor, comprueba que tienes el archivo en la misma direccion que el juego.");
        }

        // Eligo una linea al hazar del array con los tableros
        String lineaElegida = lineaLeida[(int) (Math.random() * lineaLeida.length)];

        String linea = lineaElegida.replaceAll("\\s", "");

        // Creo el array elementos que almacena cada caracter de linea de forma
        // independiente
        int[] elementos = new int[linea.length()];
        for (int i = 0; i < elementos.length; i++) {
            elementos[i] = 0;
        }

        // Inserto los valores de linea en elementos
        for (int cont = 0; cont < elementos.length; cont++) {
            elementos[cont] = (linea.charAt(cont) - '0');
        }

        // Imprimo el array
        for (int cont = 0; cont < elementos.length; cont++) {
            int fila = cont % longditudTablero;
            int columna = cont / longditudTablero;

            tablero[fila][columna] = (-1 * elementos[cont]);
        }

        return tablero;
    }

    // Funcion que imprime el tablero
    public static void mostrarTablero(int[][] tableroAImprimir) {
        // Muestro una guia de las columnas
        System.out.print("___| ");
        for (int cont = 0; cont < tableroAImprimir.length; cont++) {
            System.out.print(" " + (char) ('A' + cont) + " ");
        }

        System.out.println(); // Salto de linea

        // Imprimo el tablero en funcion de su tamaño con la fila marcada
        for (int fila = 0; fila < tableroAImprimir.length; fila++) {
            System.out.print(" " + (fila + 1) + " |  ");
            for (int columna = 0; columna < tableroAImprimir.length; columna++) {
                if (tableroAImprimir[fila][columna] == 0) {
                    System.out.print("   ");
                }
                if (Math.abs(tableroAImprimir[fila][columna]) == 1) {
                    System.out.print("x  ");
                }
                if (Math.abs(tableroAImprimir[fila][columna]) == 2) {
                    System.out.print("o  ");
                }
            }
            System.out.println(); // Salto de linea
        }
        System.out.println(); // Salto de linea
    }

    public static String verificaJugada(int longditudTablero) {

        Scanner scanner2 = new Scanner(System.in);
        String jugada = scanner2.nextLine();

        if (jugada.equals("-")) {
            return jugada;
        }

        if (jugada.equals("")) {
            jugada = "finPartida";
            return jugada;

        } else {
            // Creo una variable para controla el bucle
            boolean entradaCorrecta = false;
            // Compruebo si la entrada es correcta, en caso de que no lo sea, la vuelve ha
            // pedir hasta que lo sea
            while (!entradaCorrecta) {
                // Verifico que la entrada es valida
                if (jugada.length() == 2) {
                    // Extraigo cada caracter de la entrada por separado
                    char filaNumero = jugada.charAt(0);
                    char columnaLetra = jugada.charAt(1);

                    // Verifico que los caracteres son validos y se corresponde con la forma nC
                    if (filaNumero >= '1' && filaNumero <= '6' && columnaLetra >= 'A' && columnaLetra <= 'F') {
                        // Paso los caracteres a enteros
                        int fila = (int) (filaNumero - '0');
                        int columna = (int) (columnaLetra - 'A' + 1);

                        // Compruebo que los valores estan dentro del rango permitido
                        if (fila < 1 || fila > longditudTablero) {
                            System.out.println("La fila insertada no existe...");
                            System.out.println("Las filas van desde la 1 hasta la 6...");
                            System.out.println("Inserte de nuevo la jugada: ");
                            System.out.println(); // Salto de linea

                            jugada = scanner2.nextLine();
                        }
                        if (columna < 1 || columna > longditudTablero) {
                            System.out.println("La  columna insertada no existe...");
                            System.out.println("Las columnas van desde la A hasta la F...");
                            System.out.println("Inserte de nuevo la jugada: ");
                            System.out.println(); // Salto de linea

                            jugada = scanner2.nextLine();
                        }

                        entradaCorrecta = true;
                        return jugada;

                    } else {
                        System.out.println("Jugada no valida, debe de ser del formato 'nC': ");
                        System.out.println("    Donde [ n ] es un numero entre el 1 y el 6.");
                        System.out.println("    Donde [ C ] es una letra MAYUSCULA entre la A y la F.");
                        System.out.println(); // Salto de linea
                        System.out.print("Por favor, vuelva a insertar la jugada que desea realizar: ");
                        jugada = scanner2.nextLine();
                    }

                } else {
                    System.out.println("La longitud de la jugada insertada no es valida...");
                    System.out.print("Por favor, vuelva a insertar la jugada que desea realizar: ");
                    jugada = scanner2.nextLine();
                }
            }

        }
        // Cierro el objeto scanner
        scanner2.close();
        return jugada;
    }

    // Funcion que devuelva la jugada como valores entero para insertarlo en la
    // matriz
    public static int extraeFila(String jugada) {
        int filaExtraida = (int) ((jugada.charAt(0) - '0') - 1);
        return filaExtraida;
    }

    // Funcion que devuelve de la jugada la columna
    public static int extraeColumna(String jugada) {
        int columnaExtraida = (int) ((jugada.charAt(1) - 'A' + 1) - 1);
        return columnaExtraida;
    }

    // Funcion que se encarga de insertar las jugadas
    public static int[][] realizarJugada(int fila, int columna, int[][] tableroJuego) {
        // Compruebo que valor es la posicion y modifico en funcion del que sea
        if (tableroJuego[fila][columna] < 0) {
            System.out.print("Esa casilla no se puede editar...");
        } else {
            tableroJuego[fila][columna] = (tableroJuego[fila][columna] + 1) % 3;
        }

        return tableroJuego;
    }

    // Funcion que almacena las jugadas del usuario
    public static int[] almacenaJugadasUsuario(int fila, int columna, int[] almacenJugadas, int contadorJugadas) {
        // Juntamos las coordenadas en 1 solo numero para almacenarlo en el array
        // jugadaConjunta
        int jugadaConjunta = (fila * 10) + columna;
        almacenJugadas[contadorJugadas] = jugadaConjunta;
        return almacenJugadas;
    }

    // Funcion que se encarga de insertar las jugadas
    public static int[][] recuperarJugada(int fila, int columna, int[][] tableroJuego) {
        System.out.println("Fila: " + fila);
        System.out.println("Columna: " + columna);
        // Compruebo que valor es la posicion y modifico en funcion del que sea
        if (tableroJuego[fila][columna] < 0) {
            System.out.print("Esa casilla no se puede editar...");
        } else {
            tableroJuego[fila][columna] = (tableroJuego[fila][columna] + 2) % 3;
        }

        return tableroJuego;
    }

    // Funcion que comprueba si el tablero esta completo o no
    public static boolean tableroRellenado(int[][] tableroACorregir) {
        for (int cont = 0; cont < tableroACorregir.length * tableroACorregir.length; cont++) {

            int fila = cont % tableroACorregir.length;
            int columna = cont / tableroACorregir.length;

            if (tableroACorregir[fila][columna] == 0) {
                System.out.println("Error, el tablero no esta completo...");
                System.out.println("Faltan huecos por rellenar...");
                return false;
            }

        }
        System.out.println("El tablero esta completado");
        return true;
    }

    // Compruebo si hay tres elementos iguales tanto en vertical como en horizontal
    public static boolean tresElementosIguales(int[][] tableroACorregir) {
        boolean validoFila = true;
        boolean validoColumna = true;

        // Compruebo si hay mas de 3 elementos iguales en cada fila
        for (int fila = 0; fila < tableroACorregir.length / 2; fila++) {
            for (int columna = 0; columna < tableroACorregir.length / 2; columna++) {
                // Comparo la posicion actual, con las 2 siguientes
                // Para la fila
                if (tableroACorregir[fila][columna] == tableroACorregir[fila][columna + 1]
                        && tableroACorregir[fila][columna] == tableroACorregir[fila][columna + 2]) {
                    validoFila = false;
                }
                // Para la columna
                if (tableroACorregir[columna][fila] == tableroACorregir[columna][fila + 1]
                        && tableroACorregir[columna][fila] == tableroACorregir[columna][fila + 2]) {
                    validoColumna = false;
                }
            }
        }

        // Muestro los mensajes correspondientes
        if (!validoFila) {
            System.out.println("Hay 3 elementos iguales seguidos en una fila.");
        } else {
            System.out.println("No hay 3 elementos iguales seguidos en una fila.");
        }

        if (!validoColumna) {
            System.out.println("Hay 3 elementos iguales seguidos en una columna.");
        } else {
            System.out.println("No hay 3 elementos iguales seguidos en una columna.");
        }
        if (validoFila && validoColumna) {
            return true;
        } else {
            return false;
        }
    }

    // Compruebo si hay filas iguales
    public static boolean compruebaFilasRepetidas(int[][] tablero, int longditudTablero) {
        int elementosIguales = 0;
        // Elegimos la fila que queremos comparar
        for (int filaInicial = 0; filaInicial < longditudTablero - 1; filaInicial++) {
            // Elegimos la fila con la que vamos a comparar
            for (int filaComparar = filaInicial + 1; filaComparar < longditudTablero; filaComparar++) {
                elementosIguales = 0;
                // Comparamos cada elemento
                for (int cont = 0; cont < longditudTablero; cont++) {
                    if (Math.abs(tablero[filaInicial][cont]) == Math.abs(tablero[filaComparar][cont])) {
                        elementosIguales++;
                    }
                }
                if (elementosIguales == longditudTablero) {
                    System.out.println("Se repite al menos una fila");
                    System.out.println("Se repite la fila: " + (filaInicial + 1) + ", con la fila: " + (filaComparar + 1));
                    // Tiene filas repetidas
                    return false;
                }
            }
        }

        System.out.println("No se repite ninguna fila");
        return true;
    }

    // Compruebo si hay columnas iguales
    public static boolean compruebaColumnasRepetidas(int[][] tablero, int longditudTablero) {
        int elementosIguales = 0;
        // Elegimos la fila que queremos comparar
        for (int columnaInicial = 0; columnaInicial < longditudTablero - 1; columnaInicial++) {
            // Elegimos la fila con la que vamos a comparar
            for (int columnaComprobar = columnaInicial + 1; columnaComprobar < longditudTablero; columnaComprobar++) {
                elementosIguales = 0;
                // Comparamos cada elemento
                for (int cont = 0; cont < longditudTablero; cont++) {
                    if (Math.abs(tablero[cont][columnaInicial]) == Math.abs(tablero[cont][columnaComprobar])) {
                        elementosIguales++;
                    }
                }
                if (elementosIguales == longditudTablero) {
                    System.out.println("Se repite al menos una columna.");
                    System.out.println("Se repite la columna: " + (char) (columnaInicial + 'A') + ", con la columna: " + (char) (columnaComprobar + 'A'));
                    // Tiene filas repetidas
                    return false;
                }
            }
        }

        System.out.println("No se repite ninguna columna.");
        return true;
    }
}
