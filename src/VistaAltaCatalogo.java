/*Jaime
 * nov/2021
 * Esta clase funciona como vista para el alta de catalogos
 */
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;
public class VistaAltaCatalogo extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JTextField clasificacionTxt; 
	private JLabel clasificacionLbl;
	protected JButton darDeAlta, cancelar;
	
	public VistaAltaCatalogo(String titulo) {
		super(titulo);
		clasificacionTxt = new JTextField(15);
		clasificacionLbl = new JLabel("Clasificacion: ");
		darDeAlta = new JButton("Alta de catalogo");
		cancelar = new JButton("Cancelar");
		
		this.setLayout(new FlowLayout());
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(2,1));
		p1.add(clasificacionLbl);
		p1.add(clasificacionTxt);
		this.add(p1);
		
		JPanel p2 = new JPanel();
		p2.add(darDeAlta);
		p2.add(cancelar);
		this.add(p2);
		
		this.setBounds(20,20,300,128);
		this.setVisible(true);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setResizable(false);
	}
}
