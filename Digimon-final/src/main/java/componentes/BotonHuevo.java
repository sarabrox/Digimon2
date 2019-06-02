package componentes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.BevelBorder;

/**
 * Clase que marca el estilo de los botones para elegir Digimon en la pantalla
 * EligeHuevo
 * 
 * @author SaraB
 *
 */
public class BotonHuevo extends JButton {

	public BotonHuevo(String txt) {
		super(txt);
		this.setSize(147, 187);
		this.setBackground(new Color(255, 204, 102));
		this.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(153, 204, 255), new Color(255, 255, 255),
				new Color(255, 102, 51), new Color(255, 153, 51)));
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}

}
