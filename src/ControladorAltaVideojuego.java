/*Jaime
 * nov/2021
 * Esta clase funciona como controlador para la alta de videojuegos individualmente
 */
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class ControladorAltaVideojuego extends ControladorTienda{
	private VistaAltaVideojuego vav;
	
	public ControladorAltaVideojuego(String titulo) {
		super(titulo);
		vav = new VistaAltaVideojuego("Alta de Videojuego");
		vav.darDeAlta.addActionListener(new EscuchadorAlta());
		vav.cancelar.addActionListener(new EscuchadorCancelar());
	}
	
	private class EscuchadorAlta implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String nombreStr, estudioStr, fechaStr, generoStr, precioStr, existenciaStr, clasificacionStr;
			int fechaInt, existenciaInt;
			double precioDb;
			ControladorCorrecto cc;
			ControladorIncorrecto ci;
			
			nombreStr = vav.nombreTxt.getText();
			estudioStr = vav.estudioCreadorTxt.getText();
			fechaStr = vav.fechaPublicacionTxt.getText();
			generoStr = vav.generoTxt.getText();
			precioStr = vav.precioTxt.getText();
			existenciaStr = vav.existenciaTxt.getText();
			clasificacionStr = vav.clasificacionTxt.getText();
			fechaInt = Integer.parseInt(fechaStr);
			existenciaInt = Integer.parseInt(existenciaStr);
			precioDb = Double.parseDouble(precioStr);
			if(tienda.altaVideojuegoEnCatalogo(nombreStr, estudioStr, fechaInt, generoStr, precioDb, existenciaInt, clasificacionStr))
				cc = new ControladorCorrecto("Operacion exitosa");
			else
				ci = new ControladorIncorrecto("Error en la operacion");
		}
	}
	
	private class EscuchadorCancelar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg1) {
			vav.dispose();
		}
	}
}
