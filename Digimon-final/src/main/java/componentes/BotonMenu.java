package componentes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.border.BevelBorder;

public class BotonMenu extends JButton {
	public BotonMenu(String txt) {
		super (txt);
		
		this.setFont(new Font("Pixel Digivolve", Font.BOLD, 20));
		this.setBounds(195, 189, 183, 51);
		this.setForeground(new Color(0, 0, 153));
		this.setBackground(new Color(255, 204, 102));
		this.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(153, 204, 255), new Color(255, 255, 255), new Color(255, 102, 51), new Color(255, 153, 51)));
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		
	}

}
