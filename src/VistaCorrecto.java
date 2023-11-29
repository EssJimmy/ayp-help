/*Jaime
 *nov/2021
 *Esta clase muestra un mensaje afirmativo cuando se da correctamente de alta o baja de un catalogo o videojuego o en la venta de un videojuego
 */
import javax.swing.*;
import java.awt.FlowLayout;
public class VistaCorrecto extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel altaCorrecta;
	protected JButton ok;
	
	public VistaCorrecto(String titulo){
		super(titulo);
		altaCorrecta = new JLabel("Proceso realizado correctamente");
		ok = new JButton("Cerrar");
		
		this.setLayout(new FlowLayout());
		JPanel p1 = new JPanel();
		p1.add(altaCorrecta);
		this.add(p1);
		
		JPanel p2 = new JPanel();
		p2.add(ok);
		this.add(p2);
		
		this.setVisible(true);
		this.setBounds(20,20,256,128);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setResizable(false);
	}
}
