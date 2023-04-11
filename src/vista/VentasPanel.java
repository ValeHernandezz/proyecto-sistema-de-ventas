package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

import vista.helpers.ImagenVentas;

public class VentasPanel extends JPanel {
	
	private ImagenVentas imagenVentas = new ImagenVentas();
	
	/**
	 * Create the panel.
	 */
	public VentasPanel() {
		setLayout(null);
		
		JPanel panelVentas = new JPanel();
		panelVentas.setBounds(0, 0, 798, 550);
		panelVentas.setBackground(Color.decode("#9ED7E2"));
		add(panelVentas);
		panelVentas.setLayout(null);
		
		JLabel labelVentas = new JLabel("Ventas");
		labelVentas.setHorizontalAlignment(SwingConstants.CENTER);
		labelVentas.setFont(new Font("Cambria", Font.BOLD, 40));
		labelVentas.setBounds(156, 75, 486, 111);
		panelVentas.add(labelVentas);
		
		JPanel panelImagenVentas = new JPanel();
		panelImagenVentas.setBounds(224, 176, 350, 305);
		panelVentas.add(panelImagenVentas);
		panelImagenVentas.setLayout(null);
		
		imagenVentas.setBounds(0, 0, 350, 305);
		panelImagenVentas.add(imagenVentas);
		imagenVentas.setLayout(null);
		
	}

}
