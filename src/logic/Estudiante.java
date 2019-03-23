package logic;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Estudiante extends Thread {
	
	
	private OficinaMonitor oficina;
	private String Nombre;             // El nombre del carro
	private Random GenAleat;           // Un generador de números aleatorios
	
	
	public Estudiante(OficinaMonitor ofi, String nombre, long semilla) {
		super();
		oficina=ofi;
		Nombre = nombre;
		GenAleat = new Random(semilla);
	}
	public void run() {
//		Boolean isAtendido=false;
			while (true) {
				try {
					
					if(oficina.getListaEstudiantes().size()<3) {
						System.out.println("- ["+Nombre+"] Estoy en la oficina esperando en las sillas...");
						oficina.llegaEstudiante(Nombre);
//						isAtendido=true;
					}else {
						// si la sala de espera esta ocupada se va a dormir "Estudiar"

						System.out.println("- ["+Nombre+"] Estoy en la oficina pero esta lleno, me voy :(");
					sleep(Math.abs(GenAleat.nextInt()) % 1000);
					}
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
	}
	

}
