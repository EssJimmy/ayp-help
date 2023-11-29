/*Jaime
 * nov/2021
 * Esta clase funciona como vista para la baja de videojuegos individualmente
 */
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;
public class VistaBajaVideojuego extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JTextField nombreTxt, clasificacionTxt;
	private JLabel nombreLbl, clasificacionLbl;
	protected JButton darDeBaja, cancelar;
	
	public VistaBajaVideojuego(String titulo) {
		super(titulo);
		nombreLbl = new JLabel("Nombre del videojuego:");
		clasificacionLbl = new JLabel("Clasificacion:");
		nombreTxt = new JTextField(30);
		clasificacionTxt = new JTextField(40);
		darDeBaja = new JButton("Baja de videojuego");
		cancelar = new JButton("Cancelar");
		
		this.setLayout(new FlowLayout());
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(4,1));
		p1.add(nombreLbl);
		p1.add(nombreTxt);
		p1.add(clasificacionLbl);
		p1.add(clasificacionTxt);
		this.add(p1);
		
		JPanel p2 = new JPanel();
		p2.add(darDeBaja);
		p2.add(cancelar);
		this.add(p2);
		
		this.setBounds(20,20,512,178);
		this.setVisible(true);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setResizable(false);
	}
}
