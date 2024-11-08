package laTierraDeLaFantasia;

public class Camino {
    private int destino;
    private int distancia;

    public Camino( int destino, int distancia) {
        this.destino = destino;
        this.distancia = distancia;
    }

  

    public int getDestino() {
        return destino;
    }

    public int getDistancia() {
        return distancia;
    }
    
    
    public String toString() {
		String concat =new String();
    	return concat.concat("Destino:" + destino +" Distancia: " + distancia);
    	
    }
}
