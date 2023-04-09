package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import vista.helpers.ImagenLogo;
import vista.helpers.ImagenUtec;

import java.awt.Color;

public class BienvenidoPanel extends JPanel {
	
	private ImagenLogo imagenLogo = new ImagenLogo();
	private ImagenUtec imagenUtec = new ImagenUtec();	
	
	/**
	 * Create the panel.
	 */
	public BienvenidoPanel() {
		setLayout(null);
		
		JPanel panelBienvenido = new JPanel();
		panelBienvenido.setBackground(new Color(145, 242, 189));
		panelBienvenido.setBounds(0, 0, 798, 550);
		add(panelBienvenido);
		panelBienvenido.setLayout(null);
		
		JLabel labelTitulo1 = new JLabel("Bienvenido al");
		labelTitulo1.setBounds(196, 120, 405, 60);
		labelTitulo1.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo1.setFont(new Font("Cambria", Font.BOLD, 40));
		panelBienvenido.add(labelTitulo1);
		
		JLabel labelTitulo2 = new JLabel("Sistema de Ventas");
		labelTitulo2.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo2.setFont(new Font("Cambria", Font.BOLD, 40));
		labelTitulo2.setBounds(196, 177, 405, 60);
		panelBienvenido.add(labelTitulo2);
		
		JPanel panelImagenLogo = new JPanel();
		panelImagenLogo.setBounds(446, 299, 115, 67);
		panelBienvenido.add(panelImagenLogo);
		panelImagenLogo.setLayout(null);
		
		imagenLogo.setBounds(0, 0, 115, 67);
		panelImagenLogo.add(imagenLogo);
		
		JPanel panelImagenUtec = new JPanel();
		panelImagenUtec.setBounds(231, 285, 115, 81);
		panelBienvenido.add(panelImagenUtec);
		panelImagenUtec.setLayout(null);
		
		imagenUtec.setBounds(0, 0, 115, 81);
		panelImagenUtec.add(imagenUtec);
		
		

	}
}
