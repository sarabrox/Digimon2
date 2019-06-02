package interfaz;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import componentes.BotonMenu;

/**
 * Clase que da forma a la pantalla principal de la aplicación
 * 
 * @author SaraB
 *
 */
public class EligeLoginRegistro extends JPanel {
	private Ventana ventana;
	JLabel salir;

	/**
	 * 
	 * @param v parámetros de la ventana principal sobre la que se mostrarán las
	 *          pantallas
	 */
	public EligeLoginRegistro(Ventana v) {
		super();
		salir = new JLabel("Salir");
		setBackground(Color.WHITE);
		this.ventana = v;
		setSize(new Dimension(580, 400));
		setLayout(null);

		/**
		 * Para importar una fuente personalizada
		 */
		try {
			// create the font to use. Specify the size!
			Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("Pixel Digivolve.otf")).deriveFont(12f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			// register the font
			ge.registerFont(customFont);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FontFormatException e) {
			e.printStackTrace();
		}

		BotonMenu registro = new BotonMenu("Registro");
		registro.setLocation(195, 277);
		registro.setText("REGISTRAR");
		registro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ventana.irARegistro();
			}
		});
		add(registro);

		BotonMenu login = new BotonMenu("Login");
		login.setLocation(195, 178);

		login.setText("ENTRAR");

		add(login);

		salir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int opcionElegida = JOptionPane.showConfirmDialog(salir, "¿Seguro que quieres salir?",
						"Digimon - Virtual Pet", JOptionPane.YES_NO_OPTION);
				if (opcionElegida == 0) {
					System.exit(0);
				}
			}
		});
		salir.setForeground(new Color(255, 255, 255));
		salir.setFont(new Font("Pixel Digivolve", Font.BOLD, 20));
		salir.setBounds(461, 313, 65, 51);
		salir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(salir);

		JLabel texto1 = new JLabel("\u00BFTienes una partida guardada?");
		texto1.setForeground(new Color(255, 255, 255));
		texto1.setFont(new Font("Pixel Digivolve", Font.ITALIC, 16));
		texto1.setBounds(145, 152, 297, 25);
		add(texto1);

		JLabel texto2 = new JLabel("\u00BFA\u00FAn no tienes cuenta?");
		texto2.setForeground(Color.WHITE);
		texto2.setFont(new Font("Pixel Digivolve", Font.ITALIC, 16));
		texto2.setBounds(183, 251, 243, 25);
		add(texto2);

		JLabel logo = new JLabel("");
		logo.setName("logo");
		logo.setIcon(new ImageIcon("logo4.png"));
		logo.setBounds(87, 11, 450, 130);
		add(logo);

		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon("fondo.jpg"));
		fondo.setSize(new Dimension(600, 400));
		fondo.setBounds(-20, -68, 620, 514);
		add(fondo);
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ventana.irALogin();

			}

		});

		this.setVisible(true);

	}
}
