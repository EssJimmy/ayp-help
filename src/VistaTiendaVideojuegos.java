/*Jaime
 *nov/2021
 *Vista de la GUI para el proyecto final
 */
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;
public class VistaTiendaVideojuegos extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JButton altaCatalogo, bajaCatalogo, altaVideojuego, bajaVideojuego, venta, altaArchivo, busVideojuego, busGenero, busCatalogo, busEstudio, catalogoCompleto, nomCatalogos;
	protected JTextField busqueda;
	protected JTextArea resultadoBusqueda;
	private JScrollPane scrollbar;
	
	public VistaTiendaVideojuegos(String titulo) {
		super(titulo);
		altaCatalogo = new JButton("Alta de catalogo");
		bajaCatalogo = new JButton("Baja de catalogo");
		altaVideojuego = new JButton("Alta de videojuego");
		bajaVideojuego = new JButton("Baja de videojuego");
		venta = new JButton("Venta de videojuego");
		altaArchivo = new JButton("Alta desde archivo de videojuegos");
		busVideojuego = new JButton("Busqueda por nombre");
		busCatalogo = new JButton("Busqueda por catalogo");
		busGenero = new JButton("Busqueda por genero");
		busEstudio = new JButton("Busqueda por estudio");
		catalogoCompleto = new JButton("Catalogos completos");
		nomCatalogos = new JButton("Nombres de los catalogos");
		busqueda = new JTextField(50);
		resultadoBusqueda = new JTextArea(12,28);
		scrollbar = new JScrollPane(resultadoBusqueda);
		
		scrollbar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		this.setLayout(new FlowLayout());
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(3,2));
		p1.add(altaCatalogo);
		p1.add(bajaCatalogo);
		p1.add(altaVideojuego);
		p1.add(bajaVideojuego);
		p1.add(venta);
		p1.add(altaArchivo);
		this.add(p1);
		
		JPanel p2 = new JPanel();
		p2.add(busqueda);
		this.add(p2);
		
		JPanel p3 = new JPanel();
		p3.add(scrollbar);
		this.add(p3);
		
		JPanel p4 = new JPanel();
		p4.setLayout(new GridLayout(3,2));
		p4.add(busVideojuego);
		p4.add(busCatalogo);
		p4.add(busGenero);
		p4.add(busEstudio);
		p4.add(catalogoCompleto);
		p4.add(nomCatalogos);
		this.add(p4);
		
		this.setBounds(20,20,800,380);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
