/*Jaime
 *nov/2021
 *Esta clase es la clase base del proyecto final, describe un videojuego
 */
public class Videojuego implements Comparable<Videojuego>{

	private String nombre;
	private String estudioCreador;
	private int fechaPublicacion;
	private String genero;
	private double precio;
	private int existencia;
	
	public Videojuego(String nombre) {
		this.nombre = nombre;
	}
	
	public Videojuego(String nombre, String estudioCreador, int fechaPublicacion, String genero, double precio, int existencia) {
		this.nombre = nombre;
		this.estudioCreador = estudioCreador;
		this.fechaPublicacion = fechaPublicacion;
		this.genero = genero;
		this.precio = precio;
		this.existencia = existencia;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getEstudioCreador() {
		return estudioCreador;
	}

	public int getFechaPublicacion() {
		return fechaPublicacion;
	}

	public String getGenero() {
		return genero;
	}

	public double getPrecio() {
		return precio;
	}

	public int getExistencia() {
		return existencia;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEstudioCreador(String estudioCreador) {
		this.estudioCreador = estudioCreador;
	}

	public void setFechaPublicacion(int fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setExistencia(int existencia) {
		this.existencia = existencia;
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		
		str.append("\n  Nombre del videojuego: "+nombre);
		str.append("\n Estudio del videojuego: "+estudioCreador);
		str.append("\n   Fecha de publicacion: "+fechaPublicacion);
		str.append("\n  Genero del videojuego: "+genero);
		str.append("\n       Precio de compra: "+precio);
		str.append("\n   Existencia en tienda: "+existencia);
		return str.toString();
	}
	
	public int compareTo(Videojuego otro) {
		return nombre.compareTo(otro.nombre);
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
		Videojuego other = (Videojuego) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
}
