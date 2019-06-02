package avisos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import componentes.BotonMenu;
import interfaz.CampoBatalla;
import interfaz.Ventana;

public class Perder extends JFrame {
	private Ventana ventana;
	private CampoBatalla cb;

	public Perder(CampoBatalla cb, Ventana v) {
		super();
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
		this.setTitle("¡Has perdido!");
		this.setSize(430, 200);

		JLabel texto = new JLabel("");
		texto.setHorizontalAlignment(SwingConstants.CENTER);
		texto.setBounds(0, 24, 414, 39);
		texto.setText("El enemigo ha ganado la batalla");
		texto.setFont(new Font("Pixel Digivolve", Font.PLAIN, 20));
		texto.setForeground(Color.WHITE);
		getContentPane().add(texto);

		BotonMenu botonAceptar = new BotonMenu("Aceptar");
		botonAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				dispose();
				ventana.getMiDigimon().setSalud(ventana.getMiDigimon().getSalud() - 3);
				ventana.getMiDigimon().setHambre(ventana.getMiDigimon().getHambre() + 3);
				ventana.getMiDigimon().setHigiene(ventana.getMiDigimon().getHigiene() - 3);

			}
		});
		botonAceptar.setBounds(147, 80, 119, 39);
		getContentPane().add(botonAceptar);

		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon("fondo.jpg"));
		fondo.setBounds(0, 0, 440, 211);
		getContentPane().add(fondo);
	}
}
