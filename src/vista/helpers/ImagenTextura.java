package vista.helpers;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagenTextura extends JPanel{
	
	public ImagenTextura() {
		this.setSize(1200, 1200); // se selecciona el tamaño del panel
	}

	// Se crea un método cuyo parámetro debe ser un objeto Graphics

	public void paint(Graphics grafico) {
		Dimension height = getSize();

		// Se selecciona la imagen que tenemos en el paquete de la //ruta del programa

		ImageIcon Img = new ImageIcon(getClass().getResource("/vista/imagenes/Textura.png"));

		// se dibuja la imagen que tenemos en el paquete Images //dentro de un panel

		grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);

		setOpaque(false);
		super.paintComponent(grafico);
	}

}
