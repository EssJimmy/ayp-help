/*Jaime
 * nov/2021
 * Esta clase funciona como vista para la alta de videojuegos individualmente
 */
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;
public class VistaAltaVideojuego extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel nombreLbl, estudioCreadorLbl, fechaPublicacionLbl, generoLbl, precioLbl, existenciaLbl, clasificacionLbl;
	protected JTextField nombreTxt, estudioCreadorTxt, fechaPublicacionTxt, generoTxt, precioTxt, existenciaTxt, clasificacionTxt;
	protected JButton darDeAlta, cancelar;
	
	public VistaAltaVideojuego(String titulo) {
		super(titulo);
		nombreLbl = new JLabel("Nombre del videojuego:");
		estudioCreadorLbl = new JLabel("Estudio creador:");
		fechaPublicacionLbl = new JLabel("Fecha de salida:");
		generoLbl = new JLabel("Genero:");
		precioLbl = new JLabel("Precio:");
		existenciaLbl = new JLabel("Existencia:");
		clasificacionLbl = new JLabel("Clasificacion:");
		nombreTxt = new JTextField(30);
		estudioCreadorTxt = new JTextField(40);
		fechaPublicacionTxt = new JTextField(40);
		generoTxt = new JTextField(40);
		precioTxt = new JTextField(40);
		existenciaTxt = new JTextField(40);
		clasificacionTxt = new JTextField(40);
		darDeAlta = new JButton("Alta de videojuego");
		cancelar = new JButton("Cancelar");
		
		this.setLayout(new FlowLayout());
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(14,1));
		p1.add(nombreLbl);
		p1.add(nombreTxt);
		p1.add(estudioCreadorLbl);
		p1.add(estudioCreadorTxt);
		p1.add(fechaPublicacionLbl);
		p1.add(fechaPublicacionTxt);
		p1.add(generoLbl);
		p1.add(generoTxt);
		p1.add(precioLbl);
		p1.add(precioTxt);
		p1.add(existenciaLbl);
		p1.add(existenciaTxt);
		p1.add(clasificacionLbl);
		p1.add(clasificacionTxt);
		this.add(p1);
		
		JPanel p2 = new JPanel();
		p2.add(darDeAlta);
		p2.add(cancelar);
		this.add(p2);
		
		this.setBounds(20,20,512,390);
		this.setVisible(true);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setResizable(false);
	}
}
