package interfaz;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import componentes.BotonMenu;
import componentes.MiLabel;

import principal.Usuario;

import javax.swing.JPasswordField;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Font;

/**
 * Clase que define la pantalla de registro y crea el usuario
 * 
 * @author SaraB
 *
 */
public class Registro extends JPanel {
	private Ventana ventana;
	private JTextField campoUsuario;
	private JPasswordField campoPassword;
	private JTextField campoEmail;

	/**
	 * 
	 * @param v parámetros de la ventana principal sobre la que se muestran el resto
	 *          de pantallas del juego
	 */
	public Registro(Ventana v) {
		super();
		setSize(new Dimension(580, 400));
		this.ventana = v;
		setBackground(Color.WHITE);
		setSize(580, 400);
		setLayout(null);

		MiLabel password = new MiLabel("Contrase\u00F1a");
		password.setHorizontalAlignment(SwingConstants.RIGHT);
		password.setBounds(79, 250, 154, 30);
		add(password);

		MiLabel mail = new MiLabel("Email");
		mail.setHorizontalAlignment(SwingConstants.RIGHT);
		mail.setBounds(65, 204, 132, 35);
		add(mail);

		campoUsuario = new JTextField();
		campoUsuario.setBounds(278, 150, 221, 35);
		add(campoUsuario);
		campoUsuario.setColumns(10);

		campoPassword = new JPasswordField();
		campoPassword.setBounds(278, 246, 221, 34);
		add(campoPassword);

		BotonMenu registrar = new BotonMenu("Registrar");
		registrar.setText("REGISTRAR");

		registrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		registrar.setBounds(217, 302, 154, 45);
		add(registrar);

		campoEmail = new JTextField();
		campoEmail.setBounds(278, 196, 221, 35);
		add(campoEmail);
		campoEmail.setColumns(10);

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
		atras.setBounds(453, 325, 75, 51);
		add(atras);

		MiLabel usuario2 = new MiLabel("Usuario");
		usuario2.setHorizontalAlignment(SwingConstants.RIGHT);
		usuario2.setBounds(79, 158, 138, 35);
		add(usuario2);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon("logo4.png"));
		logo.setBounds(92, 11, 407, 115);
		add(logo);

		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon("fondo.jpg"));
		fondo.setBounds(0, -17, 601, 430);
		add(fondo);
		setVisible(true);

		registrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String usuario = campoUsuario.getText();
				String email = campoEmail.getText();
				String password = String.copyValueOf(campoPassword.getPassword());

				if (usuario.isEmpty() || email.isEmpty() || password.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Hay campos vacíos");
				}

				try {
					ventana.setUsuario(new Usuario(usuario, email, password));
					Connection conexion = (Connection) DriverManager
							.getConnection("jdbc:mysql://127.0.0.1:3306/usuario", "root", "admin");
					Statement smt = (Statement) conexion.createStatement();

					smt.execute("insert into usuario values('" + usuario + "','" + email + "','" + password + "')");

					conexion.close();
					ventana.irAEligeHuevo();
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(ventana, "El usuario ya está registrado", "Registro no válido",
							JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				}

			}
		});
	}
}
