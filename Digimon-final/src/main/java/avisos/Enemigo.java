package avisos;

import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import interfaz.CampoBatalla;
import interfaz.Ventana;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

import componentes.BotonMenu;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * Clase que abre una ventana avisando de la presencia de un enemigo
 * @author SaraB
 *
 */
public class Enemigo extends JFrame{
	
	private Ventana ventana;
	
	public Enemigo (Ventana v) {
		super();
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
		this.ventana = v;
		this.setTitle("¡OH, NO!");
		this.setSize(456, 300);
		getContentPane().setLayout(null);
		
		JLabel texto1 = new JLabel("");
		texto1.setHorizontalAlignment(SwingConstants.CENTER);
		texto1.setText("Un digimon oscuro est\u00E1 destruyendo");
		texto1.setFont(new Font("Pixel Digivolve", Font.ITALIC, 18));
		texto1.setForeground(new Color(255, 153, 51));
		texto1.setBounds(10, 23, 420, 57);
		getContentPane().add(texto1);
		
		JLabel texto2 = new JLabel("el mundo digital");
		texto2.setFont(new Font("Pixel Digivolve", Font.ITALIC, 18));
		texto2.setForeground(new Color(255, 153, 51));
		texto2.setHorizontalAlignment(SwingConstants.CENTER);
		texto2.setBounds(20, 57, 410, 43);
		getContentPane().add(texto2);
		
		JLabel texto3 = new JLabel("\u00BFQu\u00E9 quieres hacer?");
		texto3.setHorizontalAlignment(SwingConstants.CENTER);
		texto3.setFont(new Font("Pixel Digivolve", Font.PLAIN, 20));
		texto3.setForeground(Color.WHITE);
		texto3.setBounds(10, 102, 420, 57);
		getContentPane().add(texto3);
		
		BotonMenu luchar = new BotonMenu("Luchar");
		luchar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				CampoBatalla nuevaVentana = new CampoBatalla(ventana);
				nuevaVentana.setVisible(true);
			}
		});
		luchar.setBounds(81, 170, 137, 47);
		getContentPane().add(luchar);
		
		BotonMenu salir = new BotonMenu("Salir");
		salir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		salir.setBounds(240, 170, 137, 47);
		getContentPane().add(salir);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon("fondo.jpg"));
		fondo.setBounds(-22, -118, 476, 379);
		getContentPane().add(fondo);
		
		
	}
}
