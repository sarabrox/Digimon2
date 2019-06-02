package componentes;

import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JMenu;
import javax.swing.SwingConstants;

/**
 * Clase que marca el estilo de los elementos del menú de acciones de la
 * pantalla Pet (juego principal)
 * 
 * @author SaraB
 *
 */
public class LabelMenu extends JMenu {
	public LabelMenu(String txt) {
		super(txt);
		this.setFont(new Font("Pixel Digivolve", Font.PLAIN, 13));
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
}
