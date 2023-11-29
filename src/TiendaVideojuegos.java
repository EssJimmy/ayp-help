/*Jaime
 *nov/2021
 *Esta clase es para el proyecto final de algoritmos, describe a una tienda de videojuegos utilizando un arreglo de la clase CatalogoVideojuegos 
 */
import java.util.ArrayList;
public class TiendaVideojuegos {
	private String nombre;
	private CatalogoVideojuegos [] catalogos;
	private final int MAX_CATALOGOS = 6;
	private int cantCatalogos;
	private final String [] nomCatalogos;
	
	public TiendaVideojuegos(String nombre) {
		this.nombre = nombre;
		catalogos = new CatalogoVideojuegos[MAX_CATALOGOS];
		nomCatalogos = new String[MAX_CATALOGOS];
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getUnCatalogo(String catalogo) {
		String res =  "No existe ese catalogo";
		int pos;
		
		pos = ManejadorArreglosGenerico.busSecDesordenada(nomCatalogos, cantCatalogos, catalogo);
		if(pos>=0)
			res = catalogos[pos].toString();
		return res;
	}

	public boolean altaCatalogo(String clasificacion) {
		CatalogoVideojuegos c;
		boolean res = false;
		int pos;
		
		c = new CatalogoVideojuegos(clasificacion);
		pos = ManejadorArreglosGenerico.busSecDesordenada(catalogos, cantCatalogos, c);
		if(pos==-1 && cantCatalogos<nomCatalogos.length) {
			nomCatalogos[cantCatalogos] = clasificacion;
			cantCatalogos = ManejadorArreglosGenerico.insertaAlFinal(catalogos, cantCatalogos, c);
			res = true;
		}
		return res;
	}
	
	public String getNomCatalogos() {
		String res = "No existen catalogos";
		StringBuilder ans = new StringBuilder();
		
		if(cantCatalogos>0) {
			for(int i = 0; i<cantCatalogos; i++)
				ans.append(nomCatalogos[i]+"\n");
			res = ans.toString();
		}
		return res;
	}
	
	public boolean bajaCatalogo(String clasificacion) {
		boolean res = false;
		CatalogoVideojuegos c;
		int pos;
		
		c = new CatalogoVideojuegos(clasificacion);
		pos = ManejadorArreglosGenerico.busSecDesordenada(catalogos, cantCatalogos, c);
		if(pos!=-1) {
			ManejadorArreglosGenerico.eliminaEnDesordenado(nomCatalogos, cantCatalogos, clasificacion);
			cantCatalogos = ManejadorArreglosGenerico.eliminaEnDesordenado(catalogos, cantCatalogos, c);
			res = true;
		}
		return res;
	}
	
	public String buscaUnVideojuego(String nomVideojuego) {
		String res = "El videojuego no existe en en ningun catalogo";
		int pos = 0;
		
		while(pos<cantCatalogos && !catalogos[pos].consultaVideojuego(nomVideojuego)) {
			pos++;
		}
		if(pos<cantCatalogos)
			res = catalogos[pos].getUnVideojuego(nomVideojuego);
		return res;
	}
	
	private boolean verificaVideojuego(String nomVideojuego) {
		boolean res = false;
		int pos = 0;
		
		while(pos<cantCatalogos && !catalogos[pos].consultaVideojuego(nomVideojuego)) {
			pos++;
		}
		if(pos<cantCatalogos)
			res = true;
		return res;
	}
	
	public boolean altaVideojuegoEnCatalogo(String nombre, String estudioCreador, int fechaPublicacion, String genero, double precio, int existencia, String clasificacion) {
		boolean res = false;
		int pos;
		
		if(!verificaVideojuego(nombre)) {
			pos = ManejadorArreglosGenerico.busSecDesordenada(nomCatalogos, cantCatalogos, clasificacion);
			if(pos>=0)
				res = catalogos[pos].altaVideojuego(nombre, estudioCreador, fechaPublicacion, genero, precio, existencia);
		}
		return res;
	}
	
	public boolean bajaVideojuegoEnCatalogo(String nombreVideojuego, String catalogo) {
		boolean res = false;
		int pos;
		
		if(verificaVideojuego(nombreVideojuego)) {
			pos = ManejadorArreglosGenerico.busSecDesordenada(nomCatalogos, cantCatalogos, catalogo);
			if(pos>=0)
				res = catalogos[pos].bajaVideojuego(nombreVideojuego);
		}
		return res;
	}
	
	public boolean vendeVideojuegoDeCatalogo(String nombreVideojuego, String catalogo) {
		boolean res = false;
		int pos;
		
		if(verificaVideojuego(nombreVideojuego)) {
			pos = ManejadorArreglosGenerico.busSecDesordenada(nomCatalogos, cantCatalogos, catalogo);
			if(pos>=0)
				res = catalogos[pos].ventaVideojuego(nombreVideojuego);
		}
		return res;
	}
	
	public int getCantVideojuegosPorCatalogo(String catalogo) {
		int res = -1, pos;
		
		pos = ManejadorArreglosGenerico.busSecDesordenada(nomCatalogos, cantCatalogos, catalogo);
		if(pos>=0)
			res = catalogos[pos].getCantVideojuegosTotal();
		return res;
	}
	
	public int getCantVideojuegosTotal() {
		int res = 0;
		
		for(int i = 0; i<cantCatalogos; i++)
			res += catalogos[i].getCantVideojuegosTotal();
		return res;
	}
		
	public String getVideojuegosDeGenero(String genero) {
		ArrayList<String> res = new ArrayList<String>();
		
		for(int i = 0; i<cantCatalogos; i++)
			if(!catalogos[i].videojuegoPorGenero(genero).isEmpty())
				res.add(catalogos[i].videojuegoPorGenero(genero).toString());
		return res.toString();
	}
	
	public String getVideojuegosDeEstudio(String estudio) {
		ArrayList<String> res = new ArrayList<String>();
		
		for(int i = 0; i<cantCatalogos; i++)
			if(!catalogos[i].videojuegoPorEstudio(estudio).isEmpty())
				res.add(catalogos[i].videojuegoPorEstudio(estudio).toString());
		return res.toString();
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		
		str.append("\n Tienda: "+nombre);
		str.append("\n Con catalogos: \n");
		for(int i = 0; i<cantCatalogos; i++)
			str.append("\n "+catalogos[i].toString()+"\n");
		return str.toString();
	}
	
	public int compareTo(TiendaVideojuegos otra) {
		return nombre.compareTo(otra.nombre);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		TiendaVideojuegos other = (TiendaVideojuegos) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
}
