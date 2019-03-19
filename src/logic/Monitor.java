package logic;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Monitor extends Thread {

	private Semaphore isOcupado;
	private OficinaMonitor oficina;
	private String Nombre;             // El nombre del carro
	private Random GenAleat;           // Un generador de números aleatorios
	
	
	
	public Monitor(OficinaMonitor oficina, String nombre, long semilla) {
		super();
		this.isOcupado = new Semaphore(1);
		this.oficina = oficina;
		Nombre = nombre;
		GenAleat = new Random(semilla);
	}


	public void run() {
	
		while (oficina.getListaEstudiantes().size()>0) {
			try {
				
				isOcupado.acquire();
				
				sleep(Math.abs(GenAleat.nextInt()) % 1000);
				
				oficina.saleEstudiante();
				
				isOcupado.release();
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	

}
