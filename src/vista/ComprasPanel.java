package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

import vista.helpers.ImagenCompras;

public class ComprasPanel extends JPanel {
	
	private JPanel panelCompras;
	private JLabel labelCompras;
	
	private JPanel panelImagenCompras;
	private ImagenCompras imagenCompras;
	
	/**
	 * Create the panel.
	 */
	public ComprasPanel() {
		setLayout(null);
		
		panelCompras = new JPanel();
		panelCompras.setBounds(0, 0, 798, 550);
		panelCompras.setBackground(Color.decode("#9ED7E2"));
		add(panelCompras);
		panelCompras.setLayout(null);
		
		labelCompras = new JLabel("Compras");
		labelCompras.setHorizontalAlignment(SwingConstants.CENTER);
		labelCompras.setFont(new Font("Cambria", Font.BOLD, 40));
		labelCompras.setBounds(156, 75, 486, 111);
		panelCompras.add(labelCompras);
		
		panelImagenCompras = new JPanel();
		panelImagenCompras.setBounds(244, 206, 310, 215);
		panelCompras.add(panelImagenCompras);
		panelImagenCompras.setLayout(null);
		
		imagenCompras = new ImagenCompras();
		imagenCompras.setBounds(0, 0, 310, 215);
		panelImagenCompras.add(imagenCompras);

	}

}
