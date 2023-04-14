package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

import vista.helpers.ImagenSueldos;

public class SueldosPanel extends JPanel {

	private JPanel panelSueldos;
	private JLabel labelSueldos;

	private JPanel panelImagenSueldos;
	private ImagenSueldos imagenSueldos;

	/**
	 * Create the panel.
	 */
	public SueldosPanel() {
		setLayout(null);

		panelSueldos = new JPanel();
		panelSueldos.setBounds(0, 0, 798, 550);
		panelSueldos.setBackground(Color.decode("#9ED7E2"));
		add(panelSueldos);
		panelSueldos.setLayout(null);

		labelSueldos = new JLabel("Sueldos");
		labelSueldos.setHorizontalAlignment(SwingConstants.CENTER);
		labelSueldos.setFont(new Font("Cambria", Font.BOLD, 40));
		labelSueldos.setBounds(156, 75, 486, 111);
		panelSueldos.add(labelSueldos);

		panelImagenSueldos = new JPanel();
		panelImagenSueldos.setBounds(265, 206, 267, 215);
		panelSueldos.add(panelImagenSueldos);
		panelImagenSueldos.setLayout(null);

		imagenSueldos = new ImagenSueldos();
		imagenSueldos.setBounds(0, 0, 267, 215);
		panelImagenSueldos.add(imagenSueldos);

	}
}
