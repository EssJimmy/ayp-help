import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControladorIncorrecto extends VistaIncorrecto {

	public ControladorIncorrecto(String titulo) {
		super(titulo);
		ok.addActionListener(new EscuchadorCerrar());
	}
	
	private class EscuchadorCerrar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}

}
