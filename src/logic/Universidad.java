package logic;

public class Universidad {

	public static void main(String[] args) {
		// semilla para el experimento
		long semilla = 12345;
		// clase oficina del monitor
		OficinaMonitor oficina = new OficinaMonitor();

		// crea 6 estudiantes con sus hilos y los inicia
		int numeroEstudiantes = 6;
		Estudiante[] estudiantes = new Estudiante[numeroEstudiantes];
		for (int i = 0; i < numeroEstudiantes; i++) {

			estudiantes[i] = new Estudiante(oficina, "Estudiante " + i, semilla);
			estudiantes[i].start();
		}

		// crea el monitor y lo inicia
		Monitor monitor = new Monitor(oficina, "Monitor Master", semilla);
		monitor.start();

	}

}
