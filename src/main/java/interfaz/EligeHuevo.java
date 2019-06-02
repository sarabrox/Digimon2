package interfaz;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import componentes.BotonHuevo;
import principal.Digimon;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.SwingConstants;

/**
 * Clase que define la ventana para elegir huevo al principio de la partida y lo
 * crea dependiendo el huevo elegido
 * 
 * @author SaraB
 *
 */
public class EligeHuevo extends JPanel {

	private Ventana ventana;

	public EligeHuevo(Ventana v) {
		super();
		setSize(new Dimension(580, 400));
		this.ventana = v;
		setBackground(Color.WHITE);
		setLayout(null);

		JLabel textoElige = new JLabel("Elige un DigiHuevo");
		textoElige.setFont(new Font("Pixel Digivolve", Font.PLAIN, 28));
		textoElige.setForeground(Color.WHITE);
		textoElige.setBounds(162, 29, 362, 63);
		add(textoElige);

		BotonHuevo huevo1 = new BotonHuevo("");
		huevo1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ventana.setMiDigimon(new Digimon("Koromon", "Bebé", 10, 3, 0, 0, 10, 5, 0, 5));

				try {
					Connection conexion = (Connection) DriverManager
							.getConnection("jdbc:mysql://127.0.0.1:3306/usuario", "root", "admin");
					Statement smt = (Statement) conexion.createStatement();

					PreparedStatement psmt = conexion
							.prepareStatement("insert into partida values (?,?,?,?,?,?,?,?,?,?,?)");
					psmt.setString(1, ventana.getUsuario().getUsuario());
					psmt.setString(2, ventana.getMiDigimon().getNombre());
					psmt.setString(3, ventana.getMiDigimon().getNivel());
					psmt.setInt(4, ventana.getMiDigimon().getFuerza());
					psmt.setInt(5, ventana.getMiDigimon().getDefensa());
					psmt.setInt(6, ventana.getMiDigimon().getSalud());
					psmt.setInt(7, ventana.getMiDigimon().getHambre());
					psmt.setInt(8, ventana.getMiDigimon().getEnergia());
					psmt.setInt(9, ventana.getMiDigimon().getHigiene());
					psmt.setInt(10, ventana.getMiDigimon().getAfinidad());
					psmt.setInt(11, ventana.getMiDigimon().getEntretenimiento());

					psmt.executeUpdate();

					conexion.close();
				}

				catch (SQLException ex) {
					ex.printStackTrace();
				}
				ventana.irAPet();
			}
		});
		huevo1.setLocation(211, 161);
		huevo1.setIcon(new ImageIcon("huevo1.png"));
		huevo1.setFont(new Font("Pixel Digivolve", Font.PLAIN, 16));
		add(huevo1);

		JLabel texto1 = new JLabel("tipo Fuego");
		texto1.setHorizontalAlignment(SwingConstants.CENTER);
		texto1.setFont(new Font("Pixel Digivolve", Font.BOLD | Font.ITALIC, 16));
		texto1.setForeground(Color.WHITE);
		texto1.setBounds(211, 116, 147, 34);
		add(texto1);

		BotonHuevo huevo2 = new BotonHuevo("");
		huevo2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.setMiDigimon(new Digimon("Tsunomon", "Bebé", 10, 0, 0, 0, 10, 5, 0, 5));

				try {
					Connection conexion = (Connection) DriverManager
							.getConnection("jdbc:mysql://127.0.0.1:3306/usuario", "root", "admin");
					// Statement smt = (Statement) conexion.createStatement();

					PreparedStatement psmt = conexion
							.prepareStatement("insert into partida values (?,?,?,?,?,?,?,?,?,?,?");
					psmt.setString(1, ventana.getUsuario().getUsuario());
					psmt.setString(2, ventana.getMiDigimon().getNombre());
					psmt.setString(3, ventana.getMiDigimon().getNivel());
					psmt.setInt(4, ventana.getMiDigimon().getFuerza());
					psmt.setInt(5, ventana.getMiDigimon().getDefensa());
					psmt.setInt(6, ventana.getMiDigimon().getSalud());
					psmt.setInt(7, ventana.getMiDigimon().getHambre());
					psmt.setInt(8, ventana.getMiDigimon().getEnergia());
					psmt.setInt(9, ventana.getMiDigimon().getHigiene());
					psmt.setInt(10, ventana.getMiDigimon().getAfinidad());
					psmt.setInt(11, ventana.getMiDigimon().getEntretenimiento());

					psmt.executeUpdate();

					conexion.close();
				}

				catch (SQLException ex) {
					ex.printStackTrace();
				}
				ventana.irAPet();
			}
		});
		huevo2.setLocation(26, 161);
		huevo2.setIcon(new ImageIcon("huevo2.png"));
		add(huevo2);

		BotonHuevo huevo3 = new BotonHuevo("");
		huevo3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.setMiDigimon(new Digimon("Nyaromon", "Bebé", 10, 0, 3, 0, 10, 5, 0, 5));

				try {
					Connection conexion = (Connection) DriverManager
							.getConnection("jdbc:mysql://127.0.0.1:3306/usuario", "root", "admin");
					// Statement smt = (Statement) conexion.createStatement();

					PreparedStatement psmt = conexion
							.prepareStatement("insert into partida values (?,?,?,?,?,?,?,?,?,?,?)");
					psmt.setString(1, ventana.getUsuario().getUsuario());
					psmt.setString(2, ventana.getMiDigimon().getNombre());
					psmt.setString(3, ventana.getMiDigimon().getNivel());
					psmt.setInt(4, ventana.getMiDigimon().getFuerza());
					psmt.setInt(5, ventana.getMiDigimon().getDefensa());
					psmt.setInt(6, ventana.getMiDigimon().getSalud());
					psmt.setInt(7, ventana.getMiDigimon().getHambre());
					psmt.setInt(8, ventana.getMiDigimon().getEnergia());
					psmt.setInt(9, ventana.getMiDigimon().getHigiene());
					psmt.setInt(10, ventana.getMiDigimon().getAfinidad());
					psmt.setInt(11, ventana.getMiDigimon().getEntretenimiento());

					psmt.executeUpdate();

					conexion.close();
				}

				catch (SQLException ex) {
					ex.printStackTrace();
				}
				ventana.irAPet();
			}
		});
		huevo3.setLocation(393, 161);
		huevo3.setIcon(new ImageIcon("huevo3.png"));
		add(huevo3);

		JLabel texto2 = new JLabel("tipo Bestia");
		texto2.setHorizontalAlignment(SwingConstants.CENTER);
		texto2.setForeground(Color.WHITE);
		texto2.setFont(new Font("Pixel Digivolve", Font.BOLD | Font.ITALIC, 16));
		texto2.setBounds(26, 116, 147, 34);
		add(texto2);

		JLabel texto3 = new JLabel("tipo Sagrado");
		texto3.setHorizontalAlignment(SwingConstants.CENTER);
		texto3.setForeground(Color.WHITE);
		texto3.setFont(new Font("Pixel Digivolve", Font.BOLD | Font.ITALIC, 16));
		texto3.setBounds(393, 116, 147, 34);
		add(texto3);

		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon("fondo.jpg"));
		fondo.setBounds(-13, -26, 619, 450);
		add(fondo);

		setVisible(true);
	}
}
