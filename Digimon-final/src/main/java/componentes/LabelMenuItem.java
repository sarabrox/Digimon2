package componentes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JMenuItem;

/**
 * Clase que marca el estilo de los items de las diferentes opciones del menú en
 * la pantalla Pet (juego principal)
 * 
 * @author SaraB
 *
 */
public class LabelMenuItem extends JMenuItem {

	public LabelMenuItem(String txt) {
		super(txt);
		this.setFont(new Font("Pixel Digivolve", Font.PLAIN, 12));
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.setBackground(new Color(255, 204, 102));
	}

}
