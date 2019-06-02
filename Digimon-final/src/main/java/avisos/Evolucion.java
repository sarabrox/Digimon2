package avisos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import interfaz.Ventana;
import principal.Digimon;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import componentes.BotonMenu;
import javax.swing.JButton;

/**
 * Clase que crea una ventana para avisar de una digievolución
 * 
 * @author SaraB
 *
 */
public class Evolucion extends JFrame {

	private Digimon miDigimon;
	private Ventana ventana;

	/**
	 * 
	 * @param v
	 */
	public Evolucion(Ventana v) {
		super();
		this.ventana = v;

		setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));

		this.setTitle("¡Digievolución!");
		this.setSize(456, 300);
		getContentPane().setLayout(null);

		JLabel texto = new JLabel("");
		texto.setHorizontalAlignment(SwingConstants.CENTER);
		texto.setBounds(10, 75, 420, 39);
		texto.setText("¡Tu digimon ha digievolucionado!");
		texto.setFont(new Font("Pixel Digivolve", Font.PLAIN, 22));
		texto.setForeground(Color.WHITE);
		getContentPane().add(texto);

		BotonMenu botonAceptar = new BotonMenu("Aceptar");
		botonAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		botonAceptar.setBounds(157, 147, 119, 39);
		getContentPane().add(botonAceptar);

		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon("fondo.jpg"));
		fondo.setBounds(-55, -90, 495, 351);
		getContentPane().add(fondo);

	}
}
