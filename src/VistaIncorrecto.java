/*Jaime
 *nov/2021
 *Esta clase muestra un mensaje negativo cuando se da incorrectamente de alta o baja de un catalogo o videojuego o en la venta de un videojuego
 */
import java.awt.FlowLayout;
import javax.swing.*;
public class VistaIncorrecto extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private JLabel altaIncorrecta;
		protected JButton ok;
		
		public VistaIncorrecto(String titulo){
			super(titulo);
			altaIncorrecta = new JLabel("Error en el proceso");
			ok = new JButton("Cerrar");
			
			this.setLayout(new FlowLayout());
			JPanel p1 = new JPanel();
			p1.add(altaIncorrecta);
			this.add(p1);
			
			JPanel p2 = new JPanel();
			p2.add(ok);
			this.add(p2);
			
			this.setVisible(true);
			this.setBounds(20,20,200,128);
			this.setDefaultCloseOperation(HIDE_ON_CLOSE);
			this.setResizable(false);
		}
}
