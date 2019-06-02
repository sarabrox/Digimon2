package principal;

import java.util.ArrayList;
import java.util.HashMap;

import excepciones.AfinidadException;
import excepciones.EnergiaException;
import excepciones.EntretenimientoException;
import excepciones.HambreException;
import excepciones.SaludException;

/**
 * Clase que declara el Digimon, sus estadísticas y funciones
 * 
 * @author SaraB
 *
 */
public class Digimon {

	private String nombre;
	private String nivel;
	private int salud;
	private int fuerza;
	private int defensa;
	private int hambre;
	private int energia;
	private int higiene;
	private int afinidad;
	private int entretenimiento;
	private static HashMap<String, String> evolucionesPosibles;

	
	/**
	 * 
	 * @param nombre nombre del Digimon
	 * @return nombres de las digievoluciones de ese digimon
	 */
	public static String getNombreEvolucion(String nombre) {
		return evolucionesPosibles.get(nombre);
	}
	/**
	 * Función que cambia un nombre por otro cuando digievoluciona el Digimon
	 */
	private static void inicializarEvoluciones() {
		if (evolucionesPosibles == null) {
			evolucionesPosibles = new HashMap<String, String>();
			evolucionesPosibles.put("Koromon", "Agumon");
			evolucionesPosibles.put("Agumon", "Greymon");
			evolucionesPosibles.put("Greymon", "MetalGreymon");
			evolucionesPosibles.put("MetalGreymon", "WarGreymon");

			evolucionesPosibles.put("Tsunomon", "Gabumon");
			evolucionesPosibles.put("Gabumon", "Garurumon");
			evolucionesPosibles.put("Garurumon", "WereGarurumon");
			evolucionesPosibles.put("WereGarurumon", "MetalGarurumon");

			evolucionesPosibles.put("Nyaromon", "Salamon");
			evolucionesPosibles.put("Salamon", "Gatomon");
			evolucionesPosibles.put("Gatomon", "Angewomon");
			evolucionesPosibles.put("Angewomon", "Ophanimon");
		}
	}

	/**
	 * Constructor para el Digimon del jugador
	 * 
	 * @param nombre          nombre del digimon
	 * @param nivel           nivel actual del digimon
	 * @param salud           salud actual del digimon (0 - 10, muere si llega a 0)
	 * @param fuerza          fuerza del digimon para las batallas
	 * @param defensa         defensa del digimon para las batallas (0 - 100)
	 * @param hambre          nivel de hambre actual del digimon (0 - 10, muere si
	 *                        es mayor de 10)
	 * @param energia         nivel actual de energía del digimon (0 - 10)
	 * @param higiene         nivel actual de higiene del digimon (0 - 10)
	 * @param afinidad        nivel actual de afinidad entre el jugador y el digimon
	 * @param entretenimiento nivel actual de diversión del digimon (0 - 10)
	 * @param evoluciones     array con los nombres de las distintas digievoluciones
	 *                        del digimon
	 */
	public Digimon(String nombre, String nivel, int salud, int fuerza, int defensa, int hambre, int energia,
			int higiene, int afinidad, int entretenimiento) {
		super();
		inicializarEvoluciones();
		this.nombre = nombre;
		this.nivel = nivel;
		this.setSalud(salud);
		this.setFuerza(fuerza);
		this.setDefensa(defensa);
		this.setHambre(hambre);
		this.setEnergia(energia);
		this.setHigiene(higiene);
		this.setAfinidad(afinidad);
		this.setEntretenimiento(entretenimiento);
	}

	/**
	 * Constructor para los digimons enemigos
	 * 
	 * @param nombre  nombre del digimon
	 * @param nivel   nivel del digimon
	 * @param salud   salud del digimon
	 * @param fuerza  fuerza del digimon
	 * @param defensa defensa del digimon
	 */

	public Digimon(String nombre, String nivel,int fuerza) {
		super();
		inicializarEvoluciones();
		this.nombre = nombre;
		this.nivel = nivel;
		this.setFuerza(fuerza);
	}


	/**
	 * 
	 * @return nombre del digimon
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * 
	 * @param nombre nombre del digimon
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * @return nivel actual del digimon
	 */
	public String getNivel() {
		return nivel;
	}

	/**
	 * 
	 * @param nivel nivel del digimon (bebé, infante, adulto, perfecto)
	 */
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	/**
	 * 
	 * @return salud actual del digimon
	 */
	public int getSalud() {
		return salud;
	}

	/**
	 * 
	 * @param salud salud del digimon (no puede ser mayor de 10, muere cuando llega
	 *              a 0)
	 */
	public void setSalud(int salud) {
		if (salud > 10) {
			this.salud = 10;
		} else {
			this.salud = salud;
		}
	}

	/**
	 * 
	 * @return fuerza actual del digimon
	 */
	public int getFuerza() {
		return fuerza;
	}

	/**
	 * 
	 * @param fuerza fuerza del digimon (no puede ser menor que 0)
	 */
	public void setFuerza(int fuerza) {
		if (defensa > 800) {
			this.defensa = 800;
		} else if (fuerza < 0) {
			this.fuerza = 0;
		} else {
			this.fuerza = fuerza;
		}
	}

	/**
	 * 
	 * @return nivel de defensa del digimon
	 */
	public int getDefensa() {
		return defensa;
	}

	/**
	 * 
	 * @param defensa nivel de defensa del digimon (0 - 100)
	 */
	public void setDefensa(int defensa) {
		if (defensa > 500) {
			this.defensa = 500;
		} else if (defensa < 0) {
			this.defensa = 0;
		}
		this.defensa = defensa;

	}

	/**
	 * 
	 * @return nivel de hambre del digimon
	 */
	public int getHambre() {
		return hambre;
	}

	/**
	 * 
	 * @param hambre hambre del digimon (no puede ser menor que 0, muere si es mayor
	 *               de 10)
	 */
	public void setHambre(int hambre) {
		if (hambre < 0) {
			this.hambre = 0;
		} else {
			this.hambre = hambre;
		}
	}

	/**
	 * 
	 * @return nivel de energía actual del digimon
	 */
	public int getEnergia() {
		return energia;
	}

	/**
	 * 
	 * @param enrgia nivel de energia actual del digimon (0 - 10)
	 */
	public void setEnergia(int energia) {
		if (energia > 10) {
			this.energia = 10;
		} else if (energia < 0) {
			this.energia = 0;
		}
		this.energia = energia;
	}

	/**
	 * 
	 * @return nivel de higiene actual del digimon
	 */
	public int getHigiene() {
		return higiene;
	}

	/**
	 * 
	 * @param higiene nivel de higiene del digmon (0 - 10)
	 */
	public void setHigiene(int higiene) {
		if (higiene > 10) {
			this.higiene = 10;
		} else if (higiene < 0) {
			this.higiene = 0;
		} else {
			this.higiene = higiene;
		}
	}

	/**
	 * 
	 * @return nivel de afinidad actual del digmon
	 */
	public int getAfinidad() {
		return afinidad;
	}

	/**
	 * 
	 * @param afinidad afinidad entre el jugador y el digimon (no puede ser menor de
	 *                 0)
	 */
	public void setAfinidad(int afinidad) {
		if (afinidad > 100) {
			this.afinidad = 100;
		} else if (afinidad < 0) {
			this.afinidad = 0;
		} else {
			this.afinidad = afinidad;
		}
	}

	/**
	 * 
	 * @return nivel de entretenimiento actual del digimon
	 */
	public int getEntretenimiento() {
		return entretenimiento;
	}

	/**
	 * 
	 * @param entretenimiento diversión del digimon (0 - 10)
	 */
	public void setEntretenimiento(int entretenimiento) {
		if (entretenimiento > 10) {
			this.entretenimiento = 10;
		} else if (entretenimiento < 0) {
			this.entretenimiento = 0;
		} else {
			this.entretenimiento = entretenimiento;
		}
	}

	/**
	 * Función que aumenta o rebaja las estadísticas cada 30 segundos
	 */
	public void run() {
		while (true) {
			setHambre(getHambre() + 1);
			setEnergia(getEnergia() - 1);
			setHigiene(getHigiene() - 1);
			setEntretenimiento(getEntretenimiento() - 1);
			if (getHigiene() < 5) {
				setSalud(getSalud() - 1);
			}
			if (getHambre() <= 3) {
				setEnergia(getEnergia() - 1);
			}
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * El principal objetivo de esta función es bajar el hambre del digimon, aunque
	 * también sube su salud y afinidad
	 * 
	 * @param miDigimon Digimon sobre el que se alteran las estadísticas
	 * @param efecto    número que se resta al nivel de hambre actual
	 */
	public void alimentar(int efecto) {

		setHambre(getHambre() - efecto);
		setSalud(getSalud() + 1);
		setAfinidad(getAfinidad() + 1);
	}

	/**
	 * El principal objetivo de esta función es aumentar la salud del digimon,
	 * aunque también sube su afinidad
	 * 
	 * @param miDigimon Digimon sobre el que se alteran las estadísticas
	 * @param efecto    número que se suma al nivel de salud actual
	 */
	public void curar(int efecto) {

		setSalud(getSalud() + efecto);
		setAfinidad(getAfinidad() + 1);
	}

	/**
	 * El principal objetivo de esta función es aumentar la higiene del digimon,
	 * aunque también sube su salud y afinidad)
	 * 
	 * @param miDigimon Digimon sobre el que se alteran las estadísticas
	 * @param efecto    número que se suma al nivel de higiene actual
	 */
	public void limpiar(int efecto) {

		setHigiene(getHigiene() + efecto);
		setSalud(getSalud() + 1);
		setAfinidad(getAfinidad() + 1);
	}

	/**
	 * El principal objetivo de esta función es aumentar la diversión del digimon,
	 * aunque tambien sube su afinidad y baja su energía
	 * 
	 * @param miDigimon Digimon sobre el que se alteran las estadísticas
	 * @param efecto    número que se suma al nivel de entretenimiento actual
	 * @throws EnergiaException no se puede realizar esta función si la energía está
	 *                          por debajo de 3
	 * @throws SaludException   no se puede realizar esta función si la salud está
	 *                          por debajo de 3
	 */
	public void jugar(int efecto) throws EnergiaException, SaludException {

		if (energia <= 3) {
			throw new EnergiaException();
		}
		if (salud <= 3 || higiene <= 3) {
			throw new SaludException();
		}
		setEntretenimiento(getEntretenimiento() + efecto);
		setAfinidad(getAfinidad() + 3);
		setEnergia(getEnergia() - 1);
	}

	/**
	 * El principal objetivo de esta función es bajar el nivel de energía del
	 * digimon, aunque también sube su salud
	 * 
	 * @param miDigimon Digimon sobre el que se alteran las estadísticas
	 * @param efecto    número que se suma al nivel de energia actual
	 * 
	 */
	public void dormir(int efecto) {

		setEnergia(getEnergia() + efecto);
		setSalud(getSalud() + 3);
	}

	/**
	 * El principal objetivo de esta función es aumentar los niveles de fuerza y
	 * defensa del Digimon aunque también sube el hambre y baja la energía
	 * 
	 * @param miDigimon Digimon sobre el que se alteran las estadísticas
	 * @param efecto    número que se suma al nivel de fuerza actual
	 * @throws EnergiaException  no se puede realizar esta función si la energía
	 *                           está por debajo de 3
	 * @throws HambreException   no se puede realizar esta función si el hambre está
	 *                           por debajo de 3
	 * @throws AfinidadException no se puede realizar esta función si la salud está
	 *                           por debajo de 20
	 */
	public void entrenar(int efecto)
			throws EnergiaException, HambreException, SaludException, EntretenimientoException, AfinidadException {
		if (energia <= 3) {
			throw new EnergiaException();
		}
		if (hambre >= 7) {
			throw new HambreException();
		}
		if (salud <= 3 || higiene <= 3) {
			throw new SaludException();
		}
		if (entretenimiento <= 3) {
			throw new EntretenimientoException();
		}
		if (afinidad <= 20) {
			throw new AfinidadException();
		}

		setDefensa(getDefensa() + 15);

		setFuerza(getFuerza() + efecto);

		setHambre(getHambre() + 2);
		setEnergia(getEnergia() - 2);
	}

}
