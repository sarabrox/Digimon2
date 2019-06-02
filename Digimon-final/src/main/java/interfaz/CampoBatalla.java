package interfaz;

import javax.swing.JPanel;

import principal.Digimon;

import javax.swing.JLabel;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

import avisos.Ganar;
import avisos.Muerte;
import avisos.Perder;
import componentes.LabelBatalla;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Clase que genera una nueva ventana con la información de nuestro digimon y la
 * del enemigo
 * 
 * @author SaraB
 *
 */
public class CampoBatalla extends JFrame {

	private Ventana ventana;
	public Digimon digimonEnemigo;

	public Digimon getDigimonEnemigo() {
		return digimonEnemigo;
	}

	public CampoBatalla(Ventana v) {
		super();
		this.ventana = v;

		this.setTitle("Digimon - Virtual Pet - BATALLA");
		this.setSize(500, 400);
		getContentPane().setLayout(null);

		HashMap<String, BufferedImage> imagenesDigimon = new HashMap<String, BufferedImage>();
		try {
			imagenesDigimon.put("koromon", ImageIO.read(new File("./koromon.png")));
			imagenesDigimon.put("agumon", ImageIO.read(new File("./agumon.png")));
			imagenesDigimon.put("greymon", ImageIO.read(new File("./greymon.png")));
			imagenesDigimon.put("metalgreymon", ImageIO.read(new File("./metalgreymon.png")));
			imagenesDigimon.put("wargreymon", ImageIO.read(new File("./wargreymon.png")));
			imagenesDigimon.put("tsunomon", ImageIO.read(new File("./tsunomon.png")));
			imagenesDigimon.put("gabumon", ImageIO.read(new File("./gabumon.png")));
			imagenesDigimon.put("garurumon", ImageIO.read(new File("./garurumon.png")));
			imagenesDigimon.put("weregarurumon", ImageIO.read(new File("./weregarurumon.png")));
			imagenesDigimon.put("metalgarurumon", ImageIO.read(new File("./metalgarurumon.png")));
			imagenesDigimon.put("nyaromon", ImageIO.read(new File("./nyaromon.png")));
			imagenesDigimon.put("salamon", ImageIO.read(new File("./salamon.png")));
			imagenesDigimon.put("gatomon", ImageIO.read(new File("./gatomon.png")));
			imagenesDigimon.put("angewomon", ImageIO.read(new File("./angewomon.png")));
			imagenesDigimon.put("ophanimon", ImageIO.read(new File("./ophanimon.png")));
			imagenesDigimon.put("demidevimon", ImageIO.read(new File("./demidevimon.png")));
			imagenesDigimon.put("devimon", ImageIO.read(new File("./devimon.png")));
			imagenesDigimon.put("myotismon", ImageIO.read(new File("./myotismon.png")));
			imagenesDigimon.put("apocalymon", ImageIO.read(new File("./apocalymon.png")));
			imagenesDigimon.put("piedmon", ImageIO.read(new File("./piedmon.png")));
			imagenesDigimon.put("ogremon", ImageIO.read(new File("./ogremon.png")));
			imagenesDigimon.put("puppetmon", ImageIO.read(new File("./puppetmon.png")));
			imagenesDigimon.put("diaboromon", ImageIO.read(new File("./diaboromon.png")));
			imagenesDigimon.put("impmon", ImageIO.read(new File("./impmon.png")));
			imagenesDigimon.put("leomon", ImageIO.read(new File("./leomon.png")));

		} catch (IOException e) {
		}

		JLabel texto = new JLabel("Batalla");
		texto.setVerticalAlignment(SwingConstants.TOP);
		texto.setHorizontalAlignment(SwingConstants.CENTER);
		texto.setForeground(new Color(255, 153, 0));
		texto.setFont(new Font("Pixel Digivolve", Font.ITALIC, 28));
		texto.setBounds(10, 11, 464, 64);
		getContentPane().add(texto);

		LabelBatalla nombreEnemigo = new LabelBatalla("Enemigo");
		nombreEnemigo.setFont(new Font("Pixel Digivolve", Font.PLAIN, 22));
		nombreEnemigo.setHorizontalAlignment(SwingConstants.CENTER);
		nombreEnemigo.setBounds(269, 55, 205, 50);
		getContentPane().add(nombreEnemigo);

		LabelBatalla nivelEnemigo = new LabelBatalla("Nivel: ");
		nivelEnemigo.setBounds(245, 94, 229, 39);
		getContentPane().add(nivelEnemigo);

		LabelBatalla fuerzaEnemigo = new LabelBatalla("Fuerza: ");
		fuerzaEnemigo.setBounds(243, 131, 231, 39);
		getContentPane().add(fuerzaEnemigo);

		JLabel imagenEnemigo = new JLabel("");
		imagenEnemigo.setHorizontalAlignment(SwingConstants.CENTER);
		imagenEnemigo.setForeground(new Color(153, 153, 153));
		imagenEnemigo.setBackground(new Color(153, 153, 153));
		imagenEnemigo.setBounds(60, 55, 144, 148);
		getContentPane().add(imagenEnemigo);

		JLabel imagenDigimon = new JLabel("");
		imagenDigimon.setHorizontalAlignment(SwingConstants.CENTER);
		imagenDigimon.setForeground(new Color(153, 153, 153));
		imagenDigimon.setBackground(new Color(153, 153, 153));
		imagenDigimon.setBounds(309, 202, 144, 148);
		getContentPane().add(imagenDigimon);

		LabelBatalla nombreDigimon = new LabelBatalla("Enemigo");
		nombreDigimon.setText(ventana.getMiDigimon().getNombre());
		nombreDigimon.setHorizontalAlignment(SwingConstants.CENTER);
		nombreDigimon.setFont(new Font("Pixel Digivolve", Font.PLAIN, 22));
		nombreDigimon.setBounds(70, 214, 216, 50);
		getContentPane().add(nombreDigimon);

		LabelBatalla nivelDigimon = new LabelBatalla("Nivel: ");
		nivelDigimon.setBounds(57, 253, 229, 39);
		nivelDigimon.setText("Nivel: " + ventana.getMiDigimon().getNivel());
		getContentPane().add(nivelDigimon);

		LabelBatalla fuerzaDigimon = new LabelBatalla("Fuerza: ");
		fuerzaDigimon.setBounds(55, 289, 231, 31);
		fuerzaDigimon.setText("Fuerza: " + ventana.getMiDigimon().getFuerza());
		getContentPane().add(fuerzaDigimon);

		JButton botonGo = new JButton("GO!");

		botonGo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonGo.setFont(new Font("Pixel Digivolve", Font.PLAIN, 24));
		botonGo.setForeground(new Color(255, 153, 51));
		botonGo.setBackground(new Color(255, 255, 255, 0));
		botonGo.setOpaque(false);
		botonGo.setBounds(177, 174, 108, 39);
		getContentPane().add(botonGo);

		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon("fondo.jpg"));
		fondo.setBounds(0, -33, 615, 459);
		getContentPane().add(fondo);

		if (ventana.getMiDigimon().getNombre().equals("Koromon")) {
			imagenDigimon.setIcon(new ImageIcon(imagenesDigimon.get("koromon")));
		} else if (ventana.getMiDigimon().getNombre().contentEquals("Tsunomon")) {
			imagenDigimon.setIcon(new ImageIcon(imagenesDigimon.get("tsunomon")));
		} else if (ventana.getMiDigimon().getNombre().contentEquals("Nyaromon")) {
			imagenDigimon.setIcon(new ImageIcon(imagenesDigimon.get("nyaromon")));
		}
		if (ventana.getMiDigimon().getNombre().equals("Agumon")) {
			imagenDigimon.setIcon(new ImageIcon(imagenesDigimon.get("agumon")));
		} else if (ventana.getMiDigimon().getNombre().contentEquals("Gabumon")) {
			imagenDigimon.setIcon(new ImageIcon(imagenesDigimon.get("gabumon")));
		} else if (ventana.getMiDigimon().getNombre().contentEquals("Salamon")) {
			imagenDigimon.setIcon(new ImageIcon(imagenesDigimon.get("salamon")));
		}
		if (ventana.getMiDigimon().getNombre().equals("Greymon")) {
			imagenDigimon.setIcon(new ImageIcon(imagenesDigimon.get("greymon")));
		} else if (ventana.getMiDigimon().getNombre().contentEquals("Garurumon")) {
			imagenDigimon.setIcon(new ImageIcon(imagenesDigimon.get("garurumon")));
		} else if (ventana.getMiDigimon().getNombre().contentEquals("Gatomon")) {
			imagenDigimon.setIcon(new ImageIcon(imagenesDigimon.get("gatomon")));
		}
		if (ventana.getMiDigimon().getNombre().equals("MetalGreymon")) {
			imagenDigimon.setIcon(new ImageIcon(imagenesDigimon.get("metalgreymon")));
		} else if (ventana.getMiDigimon().getNombre().contentEquals("WereGarurumon")) {
			imagenDigimon.setIcon(new ImageIcon(imagenesDigimon.get("weregarurumon")));
		} else if (ventana.getMiDigimon().getNombre().contentEquals("Angewomon")) {
			imagenDigimon.setIcon(new ImageIcon(imagenesDigimon.get("angewomon")));
		}
		if (ventana.getMiDigimon().getNombre().equals("WarGreymon")) {
			imagenDigimon.setIcon(new ImageIcon(imagenesDigimon.get("wargreymon")));
		} else if (ventana.getMiDigimon().getNombre().contentEquals("MetalGarurumon")) {
			imagenDigimon.setIcon(new ImageIcon(imagenesDigimon.get("metalgarurumon")));
		} else if (ventana.getMiDigimon().getNombre().contentEquals("Ophanimon")) {
			imagenDigimon.setIcon(new ImageIcon(imagenesDigimon.get("ophanimon")));
		}

		// Generar un enemigo aleatorio dependiendo del nivel digimon
		Random r = new Random();
		int enemigo = r.nextInt(2);
		if (ventana.getMiDigimon().getNivel().equals("Infantil")) {
			switch (enemigo) {
			case 0:
				digimonEnemigo = new Digimon("DemiDevimon", "Infantil", 50);
				imagenEnemigo.setIcon(new ImageIcon(imagenesDigimon.get("demidevimon")));
				nombreEnemigo.setText(digimonEnemigo.getNombre());
				nivelEnemigo.setText("Nivel: " + digimonEnemigo.getNivel());
				fuerzaEnemigo.setText("Fuerza: " + digimonEnemigo.getFuerza());

				break;
			case 1:
				digimonEnemigo = new Digimon("Puppetmon", "Infantil", 70);
				imagenEnemigo.setIcon(new ImageIcon(imagenesDigimon.get("puppetmon")));
				nombreEnemigo.setText(digimonEnemigo.getNombre());
				nivelEnemigo.setText("Nivel: " + digimonEnemigo.getNivel());
				fuerzaEnemigo.setText("Fuerza: " + digimonEnemigo.getFuerza());
				break;
			case 2:
				digimonEnemigo = new Digimon("Impmon", "Infantil", 60);
				imagenEnemigo.setIcon(new ImageIcon(imagenesDigimon.get("impmon")));
				nombreEnemigo.setText(digimonEnemigo.getNombre());
				nivelEnemigo.setText("Nivel: " + digimonEnemigo.getNivel());
				fuerzaEnemigo.setText("Fuerza: " + digimonEnemigo.getFuerza());
				break;
			}
		}
		if (ventana.getMiDigimon().getNivel().equals("Adulto")) {
			switch (enemigo) {
			case 0:
				digimonEnemigo = new Digimon("Devimon", "Adulto", 130);
				imagenEnemigo.setIcon(new ImageIcon(imagenesDigimon.get("devimon")));
				nombreEnemigo.setText(digimonEnemigo.getNombre());
				nivelEnemigo.setText("Nivel: " + digimonEnemigo.getNivel());
				fuerzaEnemigo.setText("Fuerza: " + digimonEnemigo.getFuerza());
				break;
			case 1:
				digimonEnemigo = new Digimon("Ogremon", "Adulto", 110);
				imagenEnemigo.setIcon(new ImageIcon(imagenesDigimon.get("ogremon")));
				nombreEnemigo.setText(digimonEnemigo.getNombre());
				nivelEnemigo.setText("Nivel: " + digimonEnemigo.getNivel());
				fuerzaEnemigo.setText("Fuerza: " + digimonEnemigo.getFuerza());
				break;
			case 2:
				digimonEnemigo = new Digimon("Leomon", "Adulto", 100);
				imagenEnemigo.setIcon(new ImageIcon(imagenesDigimon.get("leomon")));
				nombreEnemigo.setText(digimonEnemigo.getNombre());
				nivelEnemigo.setText("Nivel: " + digimonEnemigo.getNivel());
				fuerzaEnemigo.setText("Fuerza: " + digimonEnemigo.getFuerza());
				break;
			}
		}
		if (ventana.getMiDigimon().getNivel().equals("Campeón")) {
			switch (enemigo) {
			case 0:
				digimonEnemigo = new Digimon("Myotismon", "Campeón", 180);
				imagenEnemigo.setIcon(new ImageIcon(imagenesDigimon.get("myotismon")));
				nombreEnemigo.setText(digimonEnemigo.getNombre());
				nivelEnemigo.setText("Nivel: " + digimonEnemigo.getNivel());
				fuerzaEnemigo.setText("Fuerza: " + digimonEnemigo.getFuerza());
				break;
			case 1:
				digimonEnemigo = new Digimon("Seadramon", "Campeón", 160);
				imagenEnemigo.setIcon(new ImageIcon(imagenesDigimon.get("seadramon")));
				nombreEnemigo.setText(digimonEnemigo.getNombre());
				nivelEnemigo.setText("Nivel: " + digimonEnemigo.getNivel());
				fuerzaEnemigo.setText("Fuerza: " + digimonEnemigo.getFuerza());
				break;
			case 2:
				digimonEnemigo = new Digimon("DeviDramon", "Campeón", 170);
				imagenEnemigo.setIcon(new ImageIcon(imagenesDigimon.get("devidramon")));
				nombreEnemigo.setText(digimonEnemigo.getNombre());
				nivelEnemigo.setText("Nivel: " + digimonEnemigo.getNivel());
				fuerzaEnemigo.setText("Fuerza: " + digimonEnemigo.getFuerza());
				break;
			}
		}
		if (ventana.getMiDigimon().getNivel().equals("Perfecto")) {
			switch (enemigo) {
			case 0:
				digimonEnemigo = new Digimon("Apocalymon", "Perfecto", 300);
				imagenEnemigo.setIcon(new ImageIcon(imagenesDigimon.get("apocalymon")));
				nombreEnemigo.setText(digimonEnemigo.getNombre());
				nivelEnemigo.setText("Nivel: " + digimonEnemigo.getNivel());
				fuerzaEnemigo.setText("Fuerza: " + digimonEnemigo.getFuerza());
				break;
			case 1:
				digimonEnemigo = new Digimon("Piedmon", "Perfecto", 250);
				imagenEnemigo.setIcon(new ImageIcon(imagenesDigimon.get("piedmon")));
				nombreEnemigo.setText(digimonEnemigo.getNombre());
				nivelEnemigo.setText("Nivel: " + digimonEnemigo.getNivel());
				fuerzaEnemigo.setText("Fuerza: " + digimonEnemigo.getFuerza());
				break;
			case 2:
				digimonEnemigo = new Digimon("Diaboromon", "Perfecto", 280);
				imagenEnemigo.setIcon(new ImageIcon(imagenesDigimon.get("diaboromon")));
				nombreEnemigo.setText(digimonEnemigo.getNombre());
				nivelEnemigo.setText("Nivel: " + digimonEnemigo.getNivel());
				fuerzaEnemigo.setText("Fuerza: " + digimonEnemigo.getFuerza());
				break;
			}
		}

		// EMPIEZA LA BATALLA
		botonGo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (digimonEnemigo.getFuerza() < ventana.getMiDigimon().getFuerza()) {
					Ganar ventanaGanar = new Ganar(ventana);
					ventanaGanar.setVisible(true);
					setVisible(false);
					dispose();
				} else {
					Perder ventanaPerder = new Perder(null, ventana);
					ventanaPerder.setVisible(true);
					setVisible(false);
					dispose();
				}
			}
		});

		// RESULTADO DEL ENFRENTAMIENTO
		/**
		 * try { if( pelea(digimonEnemigo, ventana.getMiDigimon())) { Ganar ventanaGanar
		 * = new Ganar(ventana); ventanaGanar.setVisible(true); this.setVisible(false);
		 * this.dispose(); }else { Perder ventanaPerder = new Perder(null, ventana);
		 * ventanaPerder.setVisible(true); this.setVisible(false); this.dispose(); }
		 * Thread.sleep(3000); } catch (Exception e) { }
		 **/
		/**
		 * Función que compara la fuerza de dos Digimons
		 */
	}
	/**
	 * public static boolean pelea (Digimon enemigo, Digimon miDigimon) {
	 * if(enemigo.getFuerza()>miDigimon.getFuerza()) { return false; } return true;
	 * }
	 **/
}
