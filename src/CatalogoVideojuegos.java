/*Jaime
 *nov/2021
 *Clase para el proyecto final, describe un catalogo de videojuegos por su clasificacion de la ESRB, utiliza una matriz de la clase Videojuego
 */
import java.util.ArrayList;
public class CatalogoVideojuegos implements Comparable<CatalogoVideojuegos> {
	
	private String clasificacion;
	private Videojuego [][] videojuegos;
	private final int MAX_VIDEOJUEGOS = 20;
	private int [] cantVideojuegos;
	private final int MAX_GENEROS = 9;
	private final String [] GENEROS = {"Accion","Aventura","Shooters","MOBA","MMO","RPG","Puzzle","Deportes","Terror"};
	
	public CatalogoVideojuegos(String clasificacion) {
		this.clasificacion = clasificacion;
		videojuegos = new Videojuego[MAX_VIDEOJUEGOS][MAX_GENEROS];
		cantVideojuegos = new int[MAX_GENEROS];
		for(int k = 0; k<MAX_GENEROS; k++)
			cantVideojuegos[k] = 0;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	
	//Obtener la informacion de un videojuego cuando se conoce el catalogo en el que se encuentra
	public String getUnVideojuego(String nombreConsulta) {
		String res = "No hay resultados para ese videojuego";
		int i = 0, pos;
		Videojuego videojuegoConsulta;
		
		videojuegoConsulta = new Videojuego(nombreConsulta);
		pos = ManejadorMatricesGenerico.buscaEnCol(videojuegos, cantVideojuegos[i], i, videojuegoConsulta);
		i++;
		while(i<MAX_GENEROS && pos==-1) {
			pos = ManejadorMatricesGenerico.buscaEnCol(videojuegos, cantVideojuegos[i], i, videojuegoConsulta);
			i++;
		}
		if(pos!=-1)
			res = videojuegos[pos][i-1].toString();
		return res;
	}
	
	//Saber si un videojuego se encuentra o no dentro de este catalogo, este metodo esta pensado para buscar en una arreglo de catalogos si se encuentra un videojuego o no
	public boolean consultaVideojuego(String nombreConsulta) {
		boolean res = false;
		int i = 0, pos;
		Videojuego videojuegoConsulta;
		
		videojuegoConsulta = new Videojuego(nombreConsulta);
		pos = ManejadorMatricesGenerico.buscaEnCol(videojuegos, cantVideojuegos[i], i, videojuegoConsulta);
		while(i<MAX_GENEROS && pos==-1) {
			pos = ManejadorMatricesGenerico.buscaEnCol(videojuegos, cantVideojuegos[i], i, videojuegoConsulta);
			i++;
		}
		if(pos!=-1)
			res = true;
		return res;
	}
	
	public int getCantVideojuegosTotal() {
		int res = 0;
		
		for(int i = 0; i<MAX_GENEROS; i++)
			res += cantVideojuegos[i];
		return res;
	}
	
	public int getCantVideojuegos(String generoConsulta) {
		int pos, res = -1;
		
		pos = ManejadorArreglosGenerico.busSecDesordenada(GENEROS, MAX_GENEROS, generoConsulta);
		if(pos>0)
			res = cantVideojuegos[pos];
		return res;
	}
	
	public boolean altaVideojuego(String nombre, String estudioCreador, int fechaPublicacion, String genero, double precio, int existencia) {
		boolean res = false;
		int pos;

		pos = ManejadorArreglosGenerico.busSecDesordenada(GENEROS, MAX_GENEROS, genero);
		if(pos>=0) 
			if(cantVideojuegos[pos]<videojuegos.length) {
				videojuegos[cantVideojuegos[pos]][pos] = new Videojuego(nombre, estudioCreador, fechaPublicacion, genero, precio, existencia);
				cantVideojuegos[pos]++;
				res = true;
			}
		return res;
	}
	
	public boolean ventaVideojuego(String nombreVideojuego) {
		boolean res = false;
		int pos, i = 0, nuevaExistencia;
		Videojuego v;
		
		v = new Videojuego(nombreVideojuego);
		pos = ManejadorMatricesGenerico.buscaEnCol(videojuegos, cantVideojuegos[i], i, v);
		i++;
		while(i<MAX_GENEROS && pos==-1) {
			pos = ManejadorMatricesGenerico.buscaEnCol(videojuegos, cantVideojuegos[i], i, v);
			i++;
		}
		if(pos!=-1){
			if(videojuegos[pos][i-1].getExistencia()>0) {
				nuevaExistencia = videojuegos[pos][i-1].getExistencia() - 1;
				videojuegos[pos][i-1].setExistencia(nuevaExistencia);
				res = true;
			}
		}
		return res;
	}
	
	public boolean bajaVideojuego(String nombreVideojuego) {
		boolean res = false;
		int pos, i = 0;
		Videojuego v;
		
		v = new Videojuego(nombreVideojuego);
		pos = ManejadorMatricesGenerico.buscaEnCol(videojuegos, cantVideojuegos[i], i, v);
		i++;
		while(i<MAX_GENEROS && pos==-1) {
			pos = ManejadorMatricesGenerico.buscaEnCol(videojuegos, cantVideojuegos[i], i, v);
			i++;
		}
		if(pos!=-1){
			for(int j = pos; j<cantVideojuegos[i-1]; j++) //Corrimientos para eliminar el videojuego de la matriz
				videojuegos[j][i-1] = videojuegos[j+1][i-1];
			cantVideojuegos[i-1]--;
			videojuegos[cantVideojuegos[i-1]][i-1] = null;
			res = true;
		}
		return res;
	}
	
	public ArrayList<String> videojuegoPorEstudio(String estudioCreador) {
		ArrayList<String> res = new ArrayList <String> ();
		String estudio;
		
		for(int i = 0; i<MAX_GENEROS; i++)
			for(int j = 0; j<cantVideojuegos[i]; j++) {
				estudio = videojuegos[j][i].getEstudioCreador();
				if(estudio.equalsIgnoreCase(estudioCreador))
					res.add(videojuegos[j][i].toString());
			}
		return res;
	}
	
	public ArrayList<String> videojuegoPorGenero(String genero) {
		ArrayList<String> res = new ArrayList <String> ();
		int pos;
		
		pos = ManejadorArreglosGenerico.busSecDesordenada(GENEROS, MAX_GENEROS, genero);
		if(pos>=0)
			for(int i = 0; i<cantVideojuegos[pos]; i++)
				res.add(videojuegos[i][pos].toString());
		return res;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		int suma=0;
		
		str.append("Catalogo: "+clasificacion);
		for(int i = 0; i<cantVideojuegos.length; i++)
			suma += cantVideojuegos[i];
		str.append("\nCon "+suma+" videojuego(s): ");
		for(int j = 0; j<MAX_GENEROS; j++)
			for(int k = 0; k<cantVideojuegos[j]; k++)
				str.append("\n"+videojuegos[k][j].toString());
		return str.toString();
	}
	
	public int compareTo(CatalogoVideojuegos otro) {
		return clasificacion.compareTo(otro.clasificacion);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clasificacion == null) ? 0 : clasificacion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CatalogoVideojuegos other = (CatalogoVideojuegos) obj;
		if (clasificacion == null) {
			if (other.clasificacion != null)
				return false;
		} else if (!clasificacion.equals(other.clasificacion))
			return false;
		return true;
	}
}
