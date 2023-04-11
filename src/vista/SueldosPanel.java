package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

import vista.helpers.ImagenSueldos;

public class SueldosPanel extends JPanel {
	
	private ImagenSueldos imagenSueldos = new ImagenSueldos();
	
	/**
	 * Create the panel.
	 */
	public SueldosPanel() {
		setLayout(null);
		
		JPanel panelSueldos = new JPanel();
		panelSueldos.setBounds(0, 0, 798, 550);
		panelSueldos.setBackground(Color.decode("#9ED7E2"));
		add(panelSueldos);
		panelSueldos.setLayout(null);
		
		JLabel labelSueldos = new JLabel("Sueldos");
		labelSueldos.setHorizontalAlignment(SwingConstants.CENTER);
		labelSueldos.setFont(new Font("Cambria", Font.BOLD, 40));
		labelSueldos.setBounds(156, 75, 486, 111);
		panelSueldos.add(labelSueldos);
		
		JPanel panelImagenSueldos = new JPanel();
		panelImagenSueldos.setBounds(265, 206, 267, 215);
		panelSueldos.add(panelImagenSueldos);
		panelImagenSueldos.setLayout(null);
		
		imagenSueldos.setBounds(0, 0, 267, 215);
		panelImagenSueldos.add(imagenSueldos);

	}
}
