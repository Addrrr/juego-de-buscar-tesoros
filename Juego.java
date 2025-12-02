package juegoBuscatesoros;

import java.util.Random;
import java.util.Scanner;

public class Juego {
	
	public static final int Filas = 5;
	public static final int Columnas = 5;
	public static Casilla[][] tablero;
	public static int intentos = 0;
	public static final int maxIntentos = 7;
	public static int encontrados = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Iniciando juego...");
		tablero = new Casilla[Filas][Columnas];
		// Inicializaci�n del tablero
		inicializar();
		// Colocar tesoros mal (puede repetir posiciones)
		colocarTesoro();
		while (intentos <= maxIntentos) {
			System.out.println("Introduce fila:");
			int f = sc.nextInt();
			System.out.println("Introduce columna:");
			int c = sc.nextInt();
			// Sin validaci�n de rango
			revelarCasilla(f, c);
		// Imprime el tablero
			imprimirTablero();
			if (encontrados == 5) {
				System.out.println("Has ganado");
				break;
			}
			if (intentos > maxIntentos) {
				System.out.println("Has perdido");
			}
		}
	}

	private static void imprimirTablero() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if (tablero[i][j].visitada) {
					if (tablero[i][j].tesoro) {
						System.out.print(" O ");
					} else {
						System.out.print(" X ");
					}
				} else {
					System.out.print(" - ");
				}
			}
			System.out.println();
		}
	}

	private static void revelarCasilla(int f, int c) {
		if (tablero[f][c].tesoro == true) {
			System.out.println("Tesoro encontrado!");
			encontrados = encontrados + 1;
			tablero[f][c].visitada = true;
		} else {
			System.out.println("Nada aqu�...");
			tablero[f][c].visitada = true;
		}
		intentos++;
	}

	private static void colocarTesoro() {
		Random r = new Random();
		for (int i = 0; i < 5; i++) {
			int f = r.nextInt(Filas);
			int c = r.nextInt(Columnas);
			tablero[f][c].tesoro = true;
		}
	}

	private static void inicializar() {
		for (int i = 0; i < Filas; i++) {
			for (int j = 0; j < Columnas; j++) {
				tablero[i][j] = new Casilla();
			}
		}
	} 
}
