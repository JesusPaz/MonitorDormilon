package logic;

import java.util.Random;

public class Estudiante extends Thread {

	/**
	 * Relación con el objeto oficina monitor
	 */
	private OficinaMonitor oficina;
	/**
	 * Nombre del estudiante
	 */
	private String Nombre;
	/**
	 * generador numeros aleatorios
	 */
	private Random GenAleat;

	/**
	 * Constructor del estudiante
	 * 
	 * @param ofi
	 * @param nombre
	 * @param semilla
	 */
	public Estudiante(OficinaMonitor ofi, String nombre, long semilla) {
		super();
		oficina = ofi;
		Nombre = nombre;
		GenAleat = new Random(semilla);
	}

	/**
	 * metodo principal del hilo
	 */
	public void run() {
		while (true) {
			try {
				// mira si las sala de espera es menor a 3, es decir no esta llena
				if (oficina.getListaEstudiantes().size() < 3) {
					System.out.println("- [" + Nombre + "] Estoy en la oficina esperando en las sillas...");
					oficina.llegaEstudiante(Nombre);

				} else {
					// si la sala de espera esta ocupada se va a dormir "Estudiar"

					System.out.println("- [" + Nombre + "] Estoy en la oficina pero esta lleno, me voy :(");
					sleep(Math.abs(GenAleat.nextInt()) % 1000);
				}

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
