package logic;

public class Universidad {

	public static void main(String[] args) {
		
		long semilla = 12345;
		
		OficinaMonitor oficina = new OficinaMonitor();
		
		int numeroEstudiantes=6;
		Estudiante[] estudiantes = new Estudiante[numeroEstudiantes];
		for (int i = 0; i < numeroEstudiantes; i++) {
			
			estudiantes[i]= new Estudiante(oficina, "Estudiante "+i, semilla);
			estudiantes[i].start();
		}
		
		Monitor monitor = new Monitor(oficina, "Monitor Master", semilla);
		monitor.start();

	}

}
