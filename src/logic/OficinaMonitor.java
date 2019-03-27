package logic;

import java.util.PriorityQueue;
import java.util.concurrent.Semaphore;

public class OficinaMonitor {

	/**
	 * semaforo para acceder al recurso compartido lista de espera
	 */
	private Semaphore AreaEspera;
	/**
	 * lista de espera en la oficina del monitor
	 */
	private PriorityQueue<String> listaEstudiantes;

	/**
	 * Constructor de la clase oficina monitor
	 */
	public OficinaMonitor() {
		super();
		this.AreaEspera = new Semaphore(1);
		this.listaEstudiantes = new PriorityQueue<String>();
	}

	/**
	 * Metodo para agregar a un estudiante a la lista de espera
	 * 
	 * @param nombre
	 */
	public void llegaEstudiante(String nombre) {
		try {
			AreaEspera.acquire();
			listaEstudiantes.add(nombre);
			System.out.println("- [" + nombre + "] Agregado a la lista de espera");
			AreaEspera.release();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * Metodo para sacar a un estudiante de la lista de espera
	 * 
	 * @return
	 */
	public String saleEstudiante() {
		try {
			if (listaEstudiantes.size() > 0) {
				AreaEspera.acquire();
				String act = listaEstudiantes.poll();
				System.out.println("- [" + act + "] Saliendo de la lista de espera");
				AreaEspera.release();
				return act;
			}
			return "";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";
	}

	/**
	 * Metodo para obtener las lista de estudiantes
	 * 
	 * @return
	 */
	public PriorityQueue<String> getListaEstudiantes() {
		return listaEstudiantes;
	}

}
