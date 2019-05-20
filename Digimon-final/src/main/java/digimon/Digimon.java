package digimon;

public class Digimon {
	
	private String nombre;
	private String nivel;
	private int salud;
	private int fuerza;
	private int defensa;
	private int hambre;
	private int sueño;
	private int higiene;
	private int afinidad;
	private int entretenimiento;
	
	public Digimon(String nombre, String nivel, int salud, int fuerza, int defensa, int hambre, int sueño, int higiene,
			int afinidad, int entretenimiento) {
		super();
		this.nombre = nombre;
		this.nivel = nivel;
		this.salud = salud;
		this.fuerza = fuerza;
		this.defensa = defensa;
		this.hambre = hambre;
		this.sueño = sueño;
		this.higiene = higiene;
		this.afinidad = afinidad;
		this.entretenimiento = entretenimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getHambre() {
		return hambre;
	}

	public void setHambre(int hambre) {
		this.hambre = hambre;
	}

	public int getSueño() {
		return sueño;
	}

	public void setSueño(int sueño) {
		this.sueño = sueño;
	}

	public int getHigiene() {
		return higiene;
	}

	public void setHigiene(int higiene) {
		this.higiene = higiene;
	}

	public int getAfinidad() {
		return afinidad;
	}

	public void setAfinidad(int afinidad) {
		this.afinidad = afinidad;
	}

	public int getEntretenimiento() {
		return entretenimiento;
	}

	public void setEntretenimiento(int entretenimiento) {
		this.entretenimiento = entretenimiento;
	}
	
	

}
