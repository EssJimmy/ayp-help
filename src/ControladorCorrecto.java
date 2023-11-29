import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class ControladorCorrecto extends VistaCorrecto{

	public ControladorCorrecto(String titulo) {
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
