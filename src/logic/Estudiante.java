package logic;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Estudiante extends Thread {
	
	private Semaphore Monitor;
	private Semaphore SalaEspera;
	private String Nombre;             // El nombre del carro
	private Random GenAleat;           // Un generador de números aleatorios
	
	
	
	
	
	public Estudiante(Semaphore monitor, Semaphore salaEspera, String nombre, long semilla) {
		super();
		Monitor = monitor;
		SalaEspera = salaEspera;
		Nombre = nombre;
		GenAleat = new Random(semilla);
	}





	public void run() {
			while (true) {
				
			}
	}
	

}
