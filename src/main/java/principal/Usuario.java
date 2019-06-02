package principal;

/**
 * Clase que declara un usuario
 * 
 * @author SaraB
 *
 */
public class Usuario {

	private String email;

	private String usuario;
	private String password;

	/**
	 * Constructor del usuario
	 * 
	 * @param usuario  nombre de usuario del jugador
	 * @param email    correo electrónico del jugador (no se puede repetir)
	 * @param password contraseña del jugador para poder ingrear a su cuenta
	 */
	public Usuario(String usuario, String email, String password) {
		super();
		this.email = email;
		this.password = password;
		this.usuario = usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {

		this.email = email;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}