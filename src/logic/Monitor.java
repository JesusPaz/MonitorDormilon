package logic;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Monitor extends Thread {

	private Semaphore isOcupado;
	private OficinaMonitor oficina;
	private String Nombre; // El nombre del carro
	private Random GenAleat; // Un generador de números aleatorios

	public Monitor(OficinaMonitor oficina, String nombre, long semilla) {
		super();
		this.isOcupado = new Semaphore(1);
		this.oficina = oficina;
		Nombre = nombre;
		GenAleat = new Random(semilla);
	}

	public void run() {

		while (true) {
			try {

				if (oficina.getListaEstudiantes().size() > 0) {
					isOcupado.acquire();

					sleep(Math.abs(GenAleat.nextInt()) % 1000);

					String act = oficina.saleEstudiante();

					System.out.println("- ["+Nombre+"] "+act+" atendido...");
					isOcupado.release();
				} else {
					sleep(Math.abs(GenAleat.nextInt()) % 1000);

					System.out.println("- ["+Nombre+"] Voy a dormir...");
				}

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
