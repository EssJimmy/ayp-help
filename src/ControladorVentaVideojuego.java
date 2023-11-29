/*Jaime
 *nov/2021
 *Esta clase funciona como controlador para la venta de videojuegos
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ControladorVentaVideojuego extends ControladorTienda {
	private VistaVentaVideojuego vvv;
	
	public ControladorVentaVideojuego(String titulo) {
		super(titulo);
		vvv = new VistaVentaVideojuego("Baja de videojuego");
		vvv.venta.addActionListener(new EscuchadorVenta());
		vvv.cancelar.addActionListener(new EscuchadorCancelar());
	}
	
	private class EscuchadorVenta implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String nombreStr, clasificacionStr;
			ControladorCorrecto cc;
			ControladorIncorrecto ci;
			
			nombreStr = vvv.nombreTxt.getText();
			clasificacionStr = vvv.clasificacionTxt.getText();
			if(tienda.vendeVideojuegoDeCatalogo(nombreStr, clasificacionStr))
				cc = new ControladorCorrecto("Operacion exitosa");
			else
				ci = new ControladorIncorrecto("Error en la operacion");
		}
	}
	
	private class EscuchadorCancelar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg1) {
			vvv.dispose();
		}
	}

}
