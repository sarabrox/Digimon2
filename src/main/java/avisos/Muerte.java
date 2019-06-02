package avisos;

import interfaz.Ventana;
import principal.Digimon;

import javax.swing.JLabel;

import componentes.BotonMenu;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

/**
 * Clase que crea una nueva ventana para avisar de la muerte del Digimon
 * 
 * @author SaraB
 *
 */
public class Muerte extends JFrame {

	private Digimon miDigimon;
	private Ventana ventana;

	public Muerte(Ventana v) {
		super();
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
		this.ventana = v;
		miDigimon = ventana.getMiDigimon();
		this.setTitle("¡OH, NO!");
		this.setSize(456, 300);
		getContentPane().setLayout(null);

		BotonMenu botonElegir = new BotonMenu("Elegir huevo");
		botonElegir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ventana.irAEligeHuevo();
				dispose();
			}
		});
		botonElegir.setBounds(108, 84, 213, 65);
		getContentPane().add(botonElegir);

		BotonMenu botonMenu = new BotonMenu("Men\u00FA Principal");
		botonMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irALoginRegistro();
				dispose();
			}
		});
		botonMenu.setBounds(108, 167, 213, 65);
		getContentPane().add(botonMenu);

		JLabel texto = new JLabel("¡" + miDigimon.getNombre() + " ha muerto!");
		texto.setHorizontalAlignment(SwingConstants.CENTER);
		texto.setFont(new Font("Pixel Digivolve", Font.PLAIN, 22));
		texto.setForeground(Color.WHITE);
		texto.setBounds(10, 11, 414, 82);
		getContentPane().add(texto);

		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon("fondo.jpg"));
		fondo.setBounds(-22, -118, 476, 379);
		getContentPane().add(fondo);

	}
}
