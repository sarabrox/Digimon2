package componentes;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class LabelBatalla extends JLabel {
	
	public LabelBatalla(String txt) {
		
		super(txt);
		this.setFont(new Font("Pixel Digivolve", Font.PLAIN, 20));
		this.setForeground(new Color(255, 255, 255));
		
	}

}
