/*Jaime
 *nov/2021
 *Esta clase funciona como controlador para la baja de videojuegos individualmente
 */
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class ControladorBajaVideojuego extends ControladorTienda {
	private VistaBajaVideojuego vbv;
	
	public ControladorBajaVideojuego(String titulo) {
		super(titulo);
		vbv = new VistaBajaVideojuego("Baja de videojuego");
		vbv.darDeBaja.addActionListener(new EscuchadorBaja());
		vbv.cancelar.addActionListener(new EscuchadorCancelar());
	}
	
	private class EscuchadorBaja implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String nombreStr, clasificacionStr;
			ControladorCorrecto cc;
			ControladorIncorrecto ci;
			
			nombreStr = vbv.nombreTxt.getText();
			clasificacionStr = vbv.clasificacionTxt.getText();
			if(tienda.bajaVideojuegoEnCatalogo(nombreStr, clasificacionStr))
				cc = new ControladorCorrecto("Operacion exitosa");
			else
				ci = new ControladorIncorrecto("Error en la operacion");
		}
		
	}
	
	private class EscuchadorCancelar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg1) {
			vbv.dispose();
		}
	}
}
