package laTierraDeLaFantasia;
import java.util.*;
//la clase Mapa implementa el patron Singleton

public class Mapa {
	private static Mapa mapaUnico; // Instancia única de la clase Mapa
    private int cantidadPueblos;
    private int puebloInicial;
    private int puebloFinal;
    private Map<Integer,Pueblo> pueblos; // Mapa de nodos Pueblo
    private Map<Integer,List<Camino>> adyacencias; // lista de adyacencias, 

    private Mapa() {//privado para evitar la creacion de una nueva instancia
        this.pueblos = new HashMap<>();
        this.adyacencias = new HashMap<>();
    }
    
    // Estático para obtener la única instancia de Mapa
    public static Mapa obtenerInstancia() {
        if (mapaUnico == null) {   //sino hay instancia creada 
            mapaUnico = new Mapa();  
        }
        return mapaUnico;
    }

    public void setCantidadPueblos(int cantidadPueblos) {
        this.cantidadPueblos = cantidadPueblos;
    }

    public void setPuebloInicial(int puebloInicial) {
        this.puebloInicial = puebloInicial;
    }

    public void setPuebloFinal(int puebloFinal) {
        this.puebloFinal = puebloFinal;
    }

    public void agregarPueblo(Pueblo pueblo) {    	
    	pueblos.put(pueblo.getId(), pueblo);
    	adyacencias.put(pueblo.getId(),new ArrayList<>() ); // Creamos la lista de caminos del pueblo
        this.cantidadPueblos++;
    }

    public void agregarCamino(int origen, int destino, int distancia) {
        if (pueblos.containsKey(origen)&& pueblos.containsKey(destino)) 
        	adyacencias.get(origen).add(new Camino(destino, distancia));    
    }

    public List<Camino> obtenerCaminos(int idPueblo) {//////////////////
        return adyacencias.get(idPueblo);
    }

    public Pueblo obtenerPueblo(int idPueblo) {
        return pueblos.get(idPueblo);
    }

    public int getPuebloInicial() {
        return puebloInicial;
    }

    public int getPuebloFinal() {
        return puebloFinal;
    }
	public int getCantidadPueblos() {
		// TODO Auto-generated method stub
		return this.cantidadPueblos;
	}
	
	public int caminoMasCorto() {
		return cantidadPueblos;
		
	
	}
	
	

    
}
