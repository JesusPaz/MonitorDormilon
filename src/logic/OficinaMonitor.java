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
				AreaEspera.release();
				
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void saleEstudiante() {
		try {
			if(listaEstudiantes.size()>0) {
				AreaEspera.acquire();
				listaEstudiantes.poll();
				AreaEspera.release(); 
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public PriorityQueue<String> getListaEstudiantes() {
		return listaEstudiantes;
	}
	
	

}
