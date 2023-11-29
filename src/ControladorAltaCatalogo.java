/*Jaime
 *nov/2021
 *Esta clase actua como controlador de la vista de alta catalogo
 */
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class ControladorAltaCatalogo extends ControladorTienda{
	private VistaAltaCatalogo vac;
	
	public ControladorAltaCatalogo(String titulo) {
		super(titulo);
		vac = new VistaAltaCatalogo("Alta de catalogo");
		vac.darDeAlta.addActionListener(new EscuchadorAlta());
		vac.cancelar.addActionListener(new EscuchadorCancelar());
	}
	
	private class EscuchadorAlta implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String clasificacion;
			ControladorCorrecto cc;
			ControladorIncorrecto ci;
			
			clasificacion = vac.clasificacionTxt.getText();
			if(tienda.altaCatalogo(clasificacion))
				cc = new ControladorCorrecto("Operacion exitosa");
			else
				ci = new ControladorIncorrecto("Error en la operacion");
		}
	}
	
	private class EscuchadorCancelar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg1) {
			vac.dispose();
		}
	}
}
