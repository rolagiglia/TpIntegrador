package laTierraDeLaFantasia;

import java.util.Scanner;

public class Juego {

	public void iniciar() throws Exception {

		Scanner scanner = new Scanner(System.in);
		boolean salir = false;

		while (!salir) {
			System.out.println("Opciones:");
			System.out.println("1. Cargar archivo de mapa");
			System.out.println("2. Verificar factibilidad del juego");
			System.out.println("3. Salir");
			System.out.print("Seleccione una opción: ");
			int opcion = scanner.nextInt();
			scanner.nextLine(); // Consumir la nueva línea

			switch (opcion) {
			case 1:
				cargarArchivo(scanner);
				break;
			case 2:
				verificarFactibilidad();
				break;
			case 3:
				salir = true;
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opción inválida. Intente nuevamente.");
			}
		}
		scanner.close();
	}

	// Método para cargar el archivo de mapa
	private void cargarArchivo(Scanner scanner) throws Exception {
		LeerArchivo leerArchivo = new LeerArchivo();
		if (!mapaEstaVacio()) {
			System.out.println("Ya existe un archivo de mapa cargado. ¿Desea sobrescribir los datos? (S/N)");
			String respuesta = scanner.nextLine().toUpperCase();

			if (!respuesta.equals("S")) {
				System.out.println("Operación cancelada. No se sobrescribió el archivo.\\n");
				return;
			}
		}

		System.out.print("Ingrese la ruta del archivo de mapa: ");
		String rutaArchivo = scanner.nextLine();
		
		try {
		leerArchivo.cargarDatosMapa(rutaArchivo);
		
		System.out.println("Archivo cargado exitosamente.\\n");
		
		}catch(Exception E) {
			System.out.println("\n"+E.getMessage()+"\n");
		}
		
		
		////solo fines demostrativos
		for(int i=0;i<Mapa.obtenerInstancia().getCantidadPueblos();i++) {
			if(Mapa.obtenerInstancia().obtenerPueblo(i)!=null) {
			System.out.println("Pueblo: " + Mapa.obtenerInstancia().obtenerPueblo(i));
			
			System.out.println("Camino: " + Mapa.obtenerInstancia().obtenerCaminos(i));
			}
		}
		
		////

	}

	// Método para verificar la factibilidad del juego
	private void verificarFactibilidad() {
		// Aquí puedes invocar algún método del Mapa o del sistema de juego para
		// verificar la factibilidad.
		// Esto es solo un placeholder que puedes implementar dependiendo de tus reglas.
		boolean esFactible = true; // Lógica a definir para verificar si la misión es factible

		if (esFactible) {
			System.out.println("El juego es factible con la configuración actual.");
		} else {
			System.out.println("El juego no es factible con la configuración actual.");
		}
	}

	// Método auxiliar para verificar si el mapa ya tiene datos cargados
	private boolean mapaEstaVacio() {
		return Mapa.obtenerInstancia().getCantidadPueblos() == 0; // Consideramos que está vacío si no hay pueblos
																	// cargados
	}
}
