package interfaz;

import java.sql.Connection;
import javax.swing.JFrame;

import principal.Digimon;
import principal.Usuario;
import java.awt.Toolkit;

/**
 * Clase que define la ventana principal sobre la que se mostrarán las distintas
 * pantallas del juego
 * 
 * @author SaraB
 *
 */

public class Ventana extends JFrame {
	private EligeLoginRegistro elr;
	private Login login;
	private Registro registro;
	private Usuario usuario;
	private Pet pet;
	private Digimon miDigimon;
	private EligeHuevo eligeHuevo;
	private Connection con;
	private CampoBatalla batalla;

	public Digimon getMiDigimon() {
		return miDigimon;
	}

	public void setMiDigimon(Digimon miDigimon) {
		this.miDigimon = miDigimon;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Ventana() {
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
		elr = new EligeLoginRegistro(this);
		this.setTitle("Digimon - Virtual Pet");
		this.setSize(580, 400);
		this.setContentPane(elr);
		this.setResizable(false);// no se puede ajustar el tamaño
		this.setVisible(true);

	}

	/**
	 * Función que abre la pantalla de inicio de sesión
	 */
	public void irALogin() {
		// 1- iniciar login (si no lo está)
		if (login == null) {
			this.login = new Login(this);
		}
		// 2- hacer invisibles las ventanas anteriores
		elr.setVisible(false);
		// 3- establecer el contentPane a esta nueva pantalla (JPanel)
		this.setContentPane(login);
		this.login.setVisible(true);

	}

	/**
	 * Función que abre la partida
	 */
	public void irAPet() {

		if (pet == null) {
			pet = new Pet(this);
		}
		if (registro != null) {
			registro.setVisible(false);
		}
		if (login != null) {
			login.setVisible(false);
		}
		this.setContentPane(pet);
		this.setVisible(true);

	}

	/**
	 * Función que lleva a la pantalla de elección de huevo (inicio de partida)
	 */
	public void irAEligeHuevo() {

		eligeHuevo = new EligeHuevo(this);

		if (registro != null) {
			registro.setVisible(false);
		}
		if (login != null) {
			login.setVisible(false);
		}
		this.setContentPane(eligeHuevo);
		this.setVisible(true);

	}

	/**
	 * Función que lleva a la pantalla inicial del juego
	 */
	public void irALoginRegistro() {
		if (elr == null) {

			this.elr = new EligeLoginRegistro(this);
		}

		this.setContentPane(elr);
		this.elr.setVisible(true);
	}

	/**
	 * Función que lleva a la pantalla de registro
	 */
	public void irARegistro() {
		if (this.registro == null) {
			registro = new Registro(this);
		}

		this.setContentPane(registro);
		this.registro.setVisible(true);

	}

	/**
	 * Función que lleva al menú principal
	 */
	public void irAMenu() {
		if (this.registro == null) {
			registro = new Registro(this);
		}

		this.setContentPane(registro);
		this.registro.setVisible(true);

	}
}
