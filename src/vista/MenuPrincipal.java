package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

public class MenuPrincipal implements MostrarPanel {

	private JFrame frame;
	private JPanel panelMenu = new JPanel();
	private JPanel panelContent = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal window = new MenuPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void mostrarMenu() {
		panelMenu.setVisible(true);
		panelContent.setBounds(220, 10, 798, 550);
	}

	public void ocultarMenu() {
		panelContent.setBounds(10, 10, 1008, 550);
		panelContent.setBackground(new Color(145, 242, 189));
		panelMenu.setVisible(false);
	}

	public void inciarLogin() {
		ocultarMenu();

		LoginPanel loginPanel = new LoginPanel(this);
		loginPanel.setSize(1008, 550);
		loginPanel.setLocation(0, 0);
		mostrarPanelContent(loginPanel);

	}

	/**
	 * Create the application.
	 */
	public MenuPrincipal() {
		initialize();
		inciarLogin();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(172, 249, 214));
		frame.setBounds(100, 100, 1042, 607);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		panelMenu.setBackground(new Color(117, 236, 164));
		panelMenu.setBounds(10, 10, 200, 550);

		frame.getContentPane().add(panelMenu);
		frame.getContentPane().add(panelMenu);
		panelMenu.setLayout(null);
		panelContent.setBackground(new Color(192, 192, 192));
		panelContent.setBounds(220, 10, 798, 550);
		frame.getContentPane().add(panelContent);
		panelContent.setLayout(null);

	}

	public void mostrarPanelMenu(JPanel panel) {
		panelMenu.removeAll();
		panelMenu.add(panel, BorderLayout.CENTER);
		panelMenu.revalidate();
		panelMenu.repaint();
	}

	public void mostrarPanelContent(JPanel panel) {
		panelContent.removeAll();
		panelContent.add(panel, BorderLayout.CENTER);
		panelContent.revalidate();
		panelContent.repaint();

	}

}