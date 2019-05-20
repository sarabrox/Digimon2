package interfaz;

public class Usuario {

private String email;

private String usuario;
private String password;

public Usuario(String usuario,String email,String password) {
	super();
	this.email = email;
	this.password=password;
	this.usuario=usuario;
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