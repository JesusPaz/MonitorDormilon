package logic;

import java.util.PriorityQueue;
import java.util.concurrent.Semaphore;

public class OficinaMonitor {
	
	private Semaphore AreaEspera;
	
	private PriorityQueue<String> listaEstudiantes;

	public OficinaMonitor() {
		super();
		this.AreaEspera = new Semaphore(1);
		this.listaEstudiantes = new PriorityQueue<String>();
	}
	
	public void llegaEstudiante(String nombre) {
		try {
				AreaEspera.acquire();
				listaEstudiantes.add(nombre);
				System.out.println("- ["+nombre+"] Agregado a la lista de espera");
				AreaEspera.release();
				
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public String saleEstudiante() {
		try {
			if(listaEstudiantes.size()>0) {
				AreaEspera.acquire();
				String act =listaEstudiantes.poll();
				System.out.println("- ["+act+"] Saliendo de la lista de espera");
				AreaEspera.release(); 
				return act;
			}
			return "";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";
	}

	public PriorityQueue<String> getListaEstudiantes() {
		return listaEstudiantes;
	}
	
	

}
