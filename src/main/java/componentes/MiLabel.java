package componentes;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Clase que marca el estilo de la fuente en el menú principal
 * 
 * @author SaraB
 *
 */
public class MiLabel extends JLabel {

	public MiLabel(String txt) {
		super(txt);
		this.setFont(new Font("Pixel Digivolve", Font.ITALIC, 20));
		this.setForeground(new Color(255, 255, 255));

	}
}