package logic;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Monitor extends Thread {

	/**
	 * Semaforo que corresponde a si el monitor de encuentra ocupado
	 */
	private Semaphore isOcupado;
	/**
	 * Relacion del monitor con la oficina
	 */
	private OficinaMonitor oficina;
	/**
	 * Nombre del monitor
	 */
	private String Nombre;
	/**
	 * Generador de numeros aleatorios
	 */
	private Random GenAleat;

	/**
	 * Constructor del monitor
	 * 
	 * @param oficina
	 * @param nombre
	 * @param semilla
	 */
	public Monitor(OficinaMonitor oficina, String nombre, long semilla) {
		super();
		this.isOcupado = new Semaphore(1);
		this.oficina = oficina;
		Nombre = nombre;
		GenAleat = new Random(semilla);
	}

	/**
	 * Metodo principal del hilo
	 */
	public void run() {
		while (true) {
			try {
				// verifica si tiene estudiantes para atender
				if (oficina.getListaEstudiantes().size() > 0) {
					isOcupado.acquire();
					sleep(Math.abs(GenAleat.nextInt()) % 1000);
					String act = oficina.saleEstudiante();
					System.out.println("- [" + Nombre + "] " + act + " atendido...");
					isOcupado.release();
				} else {
					// si la lista esta vacia, no tiene estudiantes, se puede dormir un rato
					sleep(Math.abs(GenAleat.nextInt()) % 1000);
					System.out.println("- [" + Nombre + "] Voy a dormir...");
				}

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
