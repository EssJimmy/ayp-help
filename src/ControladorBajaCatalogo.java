import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorBajaCatalogo extends ControladorTienda {
	private VistaBajaCatalogo vbc; 
	
	public ControladorBajaCatalogo(String titulo) {
		super(titulo);
		vbc = new VistaBajaCatalogo("Baja de catalogos");
		vbc.darDeBaja.addActionListener(new EscuchadorBaja());
		vbc.cancelar.addActionListener(new EscuchadorCancelar());
	}
	
	private class EscuchadorBaja implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String clasificacion;
			ControladorCorrecto cc;
			ControladorIncorrecto ci;
			
			clasificacion = vbc.clasificacionTxt.getText();
			if(tienda.bajaCatalogo(clasificacion))
				cc = new ControladorCorrecto("Operacion exitosa");
			else
				ci = new ControladorIncorrecto("Error en la operacion");
		}
	}
	
	private class EscuchadorCancelar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg1) {
			vbc.dispose();
		}
	}

}
