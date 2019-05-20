package interfaz;

import javax.swing.JFrame;

import digimon.Digimon;



public class Ventana extends JFrame {
	private EligeLoginRegistro elr;
	private Login login;
	private Registro registro;
	private Usuario usuario;
	private Pet pet;
	private Digimon miDigimon;
	private EligeHuevo eligeHuevo;
	
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
public Ventana (){
	super();
	elr=new EligeLoginRegistro(this);
	this.setTitle("Digimon - Virtual Pet");
	this.setSize(580,400);
	this.setContentPane(elr);
	this.setResizable(false);//no se puede ajustar el tamaño
	this.setVisible(true);
	
}
public void irALogin() {
	//1- iniciar login (si no lo está)
	if(login==null) {
		this.login=new Login(this);
	}
	// 2- hacer invisibles las ventanas anteriores
	elr.setVisible(false);
	//3- establecer el contentPane a esta nueva pantalla (JPanel)
	this.setContentPane(login);
	this.login.setVisible(true);
	
	
}
public void irAPet() {
	
	if(pet==null) {
		pet=new Pet(this);
	}
	if(registro!=null) {
		registro.setVisible(false);
	}
	if(login!=null) {
		login.setVisible(false);
	}
	this.setContentPane(pet);
	this.setVisible(true);
	
	
}

public void irAEligeHuevo() {
	
	if(eligeHuevo==null) {
		eligeHuevo=new EligeHuevo(this);
	}
	if(registro!=null) {
		registro.setVisible(false);
	}
	if(login!=null) {
		login.setVisible(false);
	}
	this.setContentPane(eligeHuevo);
	this.setVisible(true);
	
	
}

public void irALoginRegistro() {
	if (elr==null) {
		
		this.elr=new EligeLoginRegistro(this);
	}
	
	this.setContentPane(elr);
	this.elr.setVisible(true);
}
public void irARegistro() {
	if(this.registro==null) {
		registro=new Registro(this);
	}
	
	this.setContentPane(registro);
	this.registro.setVisible(true);
	
	
}
public void irAMenu() {
	if(this.registro==null) {
		registro=new Registro(this);
	}
	
	this.setContentPane(registro);
	this.registro.setVisible(true);
	
	
}
}
