package interfaz;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import componentes.BotonMenu;
import componentes.MiLabel;
import principal.Digimon;
import principal.Usuario;

import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.Font;

/**
 * Clase que da forma a la pantalla de inicio de sesión
 * 
 * @author SaraB
 *
 */
public class Login extends JPanel {
	private JTextField campoUsuario;
	private JPasswordField campoPassword;
	private Ventana ventana;

	/**
	 * 
	 * @param v parámetros de la pantalla principal que recogerá el reso de
	 *          pantallas
	 */
	public Login(Ventana v) {
		super();
		setSize(new Dimension(580, 400));
		this.ventana = v;
		setLayout(null);

		MiLabel usuario = new MiLabel("Usuario");
		usuario.setHorizontalAlignment(SwingConstants.RIGHT);
		usuario.setBounds(87, 166, 113, 21);
		add(usuario);

		MiLabel password = new MiLabel("Contrase\u00F1a");
		password.setHorizontalAlignment(SwingConstants.RIGHT);
		password.setBounds(87, 208, 145, 21);
		add(password);

		campoUsuario = new JTextField();
		campoUsuario.setBounds(275, 165, 193, 31);
		add(campoUsuario);
		campoUsuario.setColumns(10);

		campoPassword = new JPasswordField();
		campoPassword.setBounds(275, 207, 193, 31);
		add(campoPassword);

		BotonMenu login = new BotonMenu("Login");
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				Connection conexion;
				try {
					conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/usuario", "root", "admin");
					Statement smt = conexion.createStatement();

					ResultSet rs = smt.executeQuery("select * from usuario");
					while (rs.next()) {

						String usuario = rs.getString("id_usuario");
						String password = rs.getString("contraseña");
						String cUsuario = campoUsuario.getText();
						String cPassword = String.copyValueOf(campoPassword.getPassword());
						if (cUsuario.equals(usuario) && cPassword.equals(password)) {

							Statement smt2 = (Statement) conexion.createStatement();

							ResultSet misPartidas = smt2.executeQuery("select * from partida where id_usuario='"
									+ ventana.getUsuario().getUsuario() + "'");
							if (misPartidas.next()) {
								String nombre = misPartidas.getString("nombre");
								String nivel = misPartidas.getString("nivel");
								int salud = misPartidas.getInt("salud");
								int fuerza = misPartidas.getInt("fuerza");
								int defensa = misPartidas.getInt("defensa");
								int hambre = misPartidas.getInt("hambre");
								int energia = misPartidas.getInt("energia");
								int higiene = misPartidas.getInt("higiene");
								int afinidad = misPartidas.getInt("afinidad");
								int entretenimiento = misPartidas.getInt("entretenimiento");

								Digimon digi = new Digimon(nombre, nivel, salud, fuerza, defensa, hambre, energia,
										higiene, afinidad, entretenimiento);
								ventana.setUsuario(new Usuario(usuario, "", password));
								ventana.setMiDigimon(digi);
							}

							conexion.close();
						}
						ventana.irAPet();
					}
					conexion.close();

				} catch (SQLException ex) {
					ex.printStackTrace();
				}

			}
		});
		login.setSize(193, 51);
		login.setLocation(199, 265);
		login.setText("ENTRAR");

		add(login);

		JLabel atras = new JLabel("atr\u00E1s");
		atras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		atras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irALoginRegistro();
			}
		});
		atras.setForeground(Color.WHITE);
		atras.setFont(new Font("Pixel Digivolve", Font.BOLD, 20));
		atras.setBounds(470, 316, 75, 51);
		add(atras);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon("logo4.png"));
		logo.setBounds(76, 11, 405, 121);
		add(logo);

		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon("fondo.jpg"));
		fondo.setBounds(0, 0, 580, 400);
		add(fondo);

		this.setVisible(true);
	}
}
