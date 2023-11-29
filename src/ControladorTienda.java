/*Jaime
 *nov/2021
 *Esta clase actua como controlador general de todos los controladores
 */
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
public class ControladorTienda extends VistaTiendaVideojuegos{
	protected static TiendaVideojuegos tienda = new TiendaVideojuegos("Game Planet");
	
	public ControladorTienda(String titulo) {
		super(titulo);
		altaCatalogo.addActionListener(new EscuchadorAltaBaja());
		bajaCatalogo.addActionListener(new EscuchadorAltaBaja());
		altaVideojuego.addActionListener(new EscuchadorAltaBaja());
		bajaVideojuego.addActionListener(new EscuchadorAltaBaja());
		venta.addActionListener(new EscuchadorAltaBaja());
		altaArchivo.addActionListener(new EscuchadorAltaArchivo());
		busVideojuego.addActionListener(new EscuchadorBusquedas());
		busCatalogo.addActionListener(new EscuchadorBusquedas());
		busGenero.addActionListener(new EscuchadorBusquedas());
		busEstudio.addActionListener(new EscuchadorBusquedas());
		catalogoCompleto.addActionListener(new EscuchadorBusquedas());
		nomCatalogos.addActionListener(new EscuchadorBusquedas());
	}
	
	private class EscuchadorAltaBaja implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String nomBoton;
			ControladorAltaCatalogo alta;
			ControladorBajaCatalogo baja;
			ControladorVentaVideojuego venta;
			ControladorAltaVideojuego altaV;
			ControladorBajaVideojuego bajaV;
			
			nomBoton = arg0.getActionCommand();
			dispose();
			switch(nomBoton) {
				case "Alta de catalogo":
					alta = new ControladorAltaCatalogo(nomBoton);
					break;
				case "Baja de catalogo":
					baja = new ControladorBajaCatalogo(nomBoton);
					break;
				case "Alta de videojuego":
					altaV = new ControladorAltaVideojuego(nomBoton);
					break;
				case "Baja de videojuego":
					bajaV = new ControladorBajaVideojuego(nomBoton);
					break;
				case "Venta de videojuego":
					venta = new ControladorVentaVideojuego(nomBoton);
					break;
			}
		}
	}
	
	private class EscuchadorBusquedas implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent arg1) {
			String nomBoton, txt, info;
			
			txt = busqueda.getText();
			nomBoton = arg1.getActionCommand();
			switch(nomBoton) {
				case "Busqueda por nombre":
					info = tienda.buscaUnVideojuego(txt);
					break;
				case "Busqueda por catalogo":
					info = tienda.getUnCatalogo(txt);
					break;
				case "Busqueda por genero":
					info = tienda.getVideojuegosDeGenero(txt);
					break;
				case "Busqueda por estudio":
					info = tienda.getVideojuegosDeEstudio(txt);
					break;
				case "Catalogos completos":
					info = tienda.toString();
					break;
				default: 
					info = tienda.getNomCatalogos();
					break;
			}
			resultadoBusqueda.setText(info);
		}
	}
	
	private class EscuchadorAltaArchivo implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg2) {
			altaArchivo();
		}
		
	}
	
	public static void altaArchivo() {
		File ent = new File("AltaVideojuegos.txt");
		String nombre, estudioCreador, genero, clasificacion;
		int fechaPublicacion, existencia;
		double precio;
		boolean ans = true;
		ControladorIncorrecto ci;
		ControladorCorrecto cc;
		
		try(Scanner read = new Scanner(ent)){
			while(read.hasNext()) {
				nombre = read.nextLine();
				estudioCreador = read.nextLine();
				fechaPublicacion = read.nextInt();
				genero = read.next();
				precio = read.nextDouble();
				existencia = read.nextInt();
				read.nextLine();
				clasificacion = read.nextLine();
				if(!tienda.altaVideojuegoEnCatalogo(nombre, estudioCreador, fechaPublicacion, genero, precio, existencia, clasificacion) && ans){
					ci = new ControladorIncorrecto("ERROR");
					ans = false;
				}
			}
			read.close();
			if(ans)
				cc = new ControladorCorrecto("Operacion exitosa");
		}
		catch(FileNotFoundException fnfe) {
			ci = new ControladorIncorrecto("Archivo no encontrado");
		}
	}
	
	public static void main(String[] args) {
		ControladorTienda yo = new ControladorTienda("GamePlanet");
	}
}
