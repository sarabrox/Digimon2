package componentes;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Clase que marca el estilo para la columna de estadísticas de la ventana Pet
 * (juego principal)
 * 
 * @author SaraB
 *
 */
public class LabelEstadisticas extends JLabel {

	public LabelEstadisticas(String txt) {
		super();
		this.setFont(new Font("Pixel Digivolve", Font.PLAIN, 20));
		this.setHorizontalAlignment(SwingConstants.LEFT);
	}

}
