/*Jaime
 *nov/2021
 *clase prueba de la tienda videojuegos para el proyecto final
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class MainPruebaProyecto {

	public static void main(String[] args) {
		TiendaVideojuegos t = new TiendaVideojuegos("Game Planet");
		//CatalogoVideojuegos cv = new CatalogoVideojuegos("M");
		File ent = new File("AltaVideojuegos.txt");
		String nombre, estudioCreador, genero, clasificacion;
		int fechaPublicacion, existencia;
		double precio;
		//int i = 0;
		//int j = 1;
		
		//Prueba CV: Me equivoque en el toString de CatalogoVideojuegos, puse [j][k] en vez de [k][j]
		/*
		cv.altaVideojuego("SMT V", "Atlus", 2021, "RPG", 1599.00, 5);
		System.out.println(cv.toString());
		
		//El anterior error genero un error en donde el videojuego se daba de alta pero no se imprimia el videojuego correcto
		if(t.altaVideojuegoEnCatalogo("SMT V", "Atlus", 2021, "RPG", 1599.00, 5, "M"))
			System.out.println("Alta exitosa");
		else
			System.out.println("Alta fallida");
		System.out.println(t.toString());
		*/
		
		//Prueba con muchas altas desde un archivo
		try(Scanner read = new Scanner(ent)){
			System.out.println(t.altaCatalogo("Everyone")); //Prueba de alta de catalogos, hubo un error al poner nomCatalogos[cantCatalogos] = clasificacion despues del alta. Corregido.
			System.out.println(t.altaCatalogo("Everyone +10"));
			System.out.println(t.altaCatalogo("Teen"));
			System.out.println(t.altaCatalogo("Mature"));
			System.out.println(t.altaCatalogo("Adults Only"));
			System.out.println(t.altaCatalogo("Rating Pending"));
			System.out.println(t.getNomCatalogos()); //Metodo correcto
			while(read.hasNext()) {
				nombre = read.nextLine();
				//System.out.println(nombre);
				estudioCreador = read.nextLine();
				//System.out.println(estudioCreador);
				fechaPublicacion = read.nextInt();
				//System.out.println(fechaPublicacion);
				genero = read.next();
				//System.out.println(genero);
				precio = read.nextDouble();
				//System.out.println(precio);
				existencia = read.nextInt();
				//System.out.println(existencia);
				read.nextLine();
				clasificacion = read.nextLine();
				//System.out.println(clasificacion);
				t.altaVideojuegoEnCatalogo(nombre, estudioCreador, fechaPublicacion, genero, precio, existencia, clasificacion);
			}
			read.close();
			System.out.println(t.toString());
			/*System.out.println(t.getCantVideojuegosTotal());
			System.out.println(t.buscaUnVideojuego("Videojuego 1")); //Prueba de metodo busca un videojuego: Tuve un error en el tipo de busqueda, quise buscar en toda la matriz al mismo tiempo, lo correcto fue buscar por columna
			System.out.println(t.buscaUnVideojuego("Videojuego 10"));
			System.out.println(t.getCantVideojuegosPorCatalogo("Everyone")); //Metodo correcto
			System.out.println(t.bajaVideojuegoEnCatalogo("Videojuego 1", "Everyone")); //Mismo error que en buscaUnVideojuego
			System.out.println(t.buscaUnVideojuego("Videojuego 1")); //Prueba si se borro correctamente el videojuego
			System.out.println(t.getCantVideojuegosPorCatalogo("Everyone")); //Prueba si se elimino el correcto del catalogo, tambien pruebva del metodo getCantVideojuegosPorCatalogo
			System.out.println(t.vendeVideojuegoDeCatalogo("Videojuego 10", "Mature")); //Mismo error que en bajaVideojuego
			System.out.println(t.buscaUnVideojuego("Videojuego 10")); //Prueba si se actualizo la existencia del videojuego
			System.out.println(t.getVideojuegosDeEstudio("Atlus")); //Prueba de metodo, añadí un if para evitar que se añadan los catalogos que no tengan videojuegos de estudio, tambien cambie el metodo en CatalogoVideojuegos para que devolviera un ArrayList de Strings en vez de un String 
			System.out.println(t.getVideojuegosDeGenero("Terror")); //Lo mismo que la prueba anterior
			System.out.println(t.getUnCatalogo("Adults Only")); //Metodo sin problemas*/
		}
		catch(FileNotFoundException fnfe) {
			System.err.println("Ya valio madres "+fnfe);
			System.exit(-1);
		}
	}
}