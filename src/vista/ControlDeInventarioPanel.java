package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;

import vista.helpers.ImagenInventario;

public class ControlDeInventarioPanel extends JPanel {
	
	private JPanel panelControlDeInventario;
	private JLabel labelControlDeInventario;
	
	private JPanel panelImagenInventario;
	private ImagenInventario imagenInventario;

	/**
	 * Create the panel.
	 */
	public ControlDeInventarioPanel() {
		setLayout(null);
		
		panelControlDeInventario = new JPanel();
		panelControlDeInventario.setBounds(0, 0, 798, 550);
		panelControlDeInventario.setBackground(Color.decode("#9ED7E2"));
		add(panelControlDeInventario);
		panelControlDeInventario.setLayout(null);
		
		labelControlDeInventario = new JLabel("Control de Inventario");
		labelControlDeInventario.setFont(new Font("Cambria", Font.BOLD, 40));
		labelControlDeInventario.setHorizontalAlignment(SwingConstants.CENTER);
		labelControlDeInventario.setBounds(156, 75, 486, 111);
		panelControlDeInventario.add(labelControlDeInventario);
		
		panelImagenInventario = new JPanel();
		panelImagenInventario.setLayout(null);
		panelImagenInventario.setBounds(200, 206, 398, 215);
		panelControlDeInventario.add(panelImagenInventario);
		
		imagenInventario = new ImagenInventario();
		imagenInventario.setBounds(0, 0, 398, 215);
		panelImagenInventario.add(imagenInventario);

	}
}
