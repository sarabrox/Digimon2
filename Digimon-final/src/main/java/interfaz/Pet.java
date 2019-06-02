package interfaz;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Random;

import avisos.Enemigo;
import avisos.Evolucion;
import avisos.Muerte;
import componentes.LabelEstadisticas;
import componentes.LabelMenu;
import componentes.LabelMenuItem;
import excepciones.AfinidadException;
import excepciones.EnergiaException;
import excepciones.EntretenimientoException;
import excepciones.HambreException;
import excepciones.SaludException;
import principal.Digimon;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

/**
 * Clase que da forma a la pantalla principal del juego
 * 
 * @author SaraB
 *
 */
public class Pet extends JPanel implements Runnable {

	private Ventana ventana;
	private LabelEstadisticas fuerza;
	private LabelEstadisticas fuerzaNumero;
	private LabelEstadisticas hambre;
	private LabelEstadisticas hambreNumero;
	private LabelEstadisticas salud;
	private LabelEstadisticas saludNumero;
	private LabelEstadisticas energia;
	private LabelEstadisticas energiaNumero;
	private LabelEstadisticas higiene;
	private LabelEstadisticas higieneNumero;
	private LabelEstadisticas entretenimiento;
	private LabelEstadisticas diversionNumero;
	private LabelEstadisticas defensa;
	private LabelEstadisticas defensaNumero;
	private LabelEstadisticas afinidad;
	private LabelEstadisticas afinidadNumero;
	private final String[] niveles = { "Infantil", "Adulto", "Campeón", "Perfecto" };
	private boolean tieneCaca; // mientras sea true, las estadísticas cambian y solo limpiarla lo cambia a
								// false
	private JLabel labelNombre;
	private JLabel labelNivel;
	private JLabel imagenDigimon;
	private HashMap<String, BufferedImage> imagenesDigimon;
	private int contador = 0; // este contador me va a servir para aumentarlo y usarlo como condición en las
								// evoluciones

	/**
	 * 
	 * @param v parámetros de la ventana principal que recoge el resto de pantallas
	 *          del juego
	 */
	public Pet(Ventana v) {
		super();
		this.ventana = v;
		tieneCaca = false;

		imagenesDigimon = new HashMap<String, BufferedImage>();
		try {
			imagenesDigimon.put("koromon", ImageIO.read(new File("./koromon.png")));
			imagenesDigimon.put("agumon", ImageIO.read(new File("./agumon.png")));
			imagenesDigimon.put("greymon", ImageIO.read(new File("./greymon.png")));
			imagenesDigimon.put("metalgreymon", ImageIO.read(new File("./metalgreymon.png")));
			imagenesDigimon.put("wargreymon", ImageIO.read(new File("./wargreymon.png")));
			imagenesDigimon.put("tsunomon", ImageIO.read(new File("./tsunomon.png")));
			imagenesDigimon.put("gabumon", ImageIO.read(new File("./gabumon.png")));
			imagenesDigimon.put("garurumon", ImageIO.read(new File("./garurumon.png")));
			imagenesDigimon.put("weregarurumon", ImageIO.read(new File("./weregarurumon.png")));
			imagenesDigimon.put("metalgarurumon", ImageIO.read(new File("./metalgarurumon.png")));
			imagenesDigimon.put("nyaromon", ImageIO.read(new File("./nyaromon.png")));
			imagenesDigimon.put("salamon", ImageIO.read(new File("./salamon.png")));
			imagenesDigimon.put("gatomon", ImageIO.read(new File("./gatomon.png")));
			imagenesDigimon.put("angewomon", ImageIO.read(new File("./angewomon.png")));
			imagenesDigimon.put("ophanimon", ImageIO.read(new File("./ophanimon.png")));

			// imagenesDigimon.get("agumon");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

		setBackground(new Color(15, 37, 120));
		setSize(580, 413);
		setLayout(null);

		JPanel menu = new JPanel();
		menu.setBorder(null);
		menu.setBackground(new Color(255, 153, 51));
		menu.setBounds(10, 10, 560, 43);
		add(menu);
		menu.setLayout(new GridLayout(1, 0, 0, 0));

		JMenuBar menuBar = new JMenuBar();
		menuBar.setOpaque(true);
		menuBar.setBackground(new Color(255, 153, 51));
		menuBar.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		menu.add(menuBar);

		LabelMenu menuAlimentar = new LabelMenu("Alimentar");
		menuBar.setOpaque(true);
		menuBar.setBackground(new Color(255, 153, 51));
		menuAlimentar.setBackground(new Color(255, 153, 51));
		menuBar.add(menuAlimentar);

		LabelMenuItem menuItemGalleta = new LabelMenuItem("Galleta");

		menuItemGalleta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ventana.getMiDigimon().alimentar(1);
				hambre.setText("Hambre");
				hambreNumero.setText(String.valueOf(ventana.getMiDigimon().getHambre()));
				salud.setText("Salud");
				saludNumero.setText(String.valueOf(ventana.getMiDigimon().getSalud()));
				afinidad.setText("Afinidad " + ventana.getMiDigimon().getAfinidad());
				afinidadNumero.setText(String.valueOf(ventana.getMiDigimon().getAfinidad()));
			}
		});

		menuAlimentar.add(menuItemGalleta);

		LabelMenuItem menuItemHelado = new LabelMenuItem("Helado");
		menuItemHelado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.getMiDigimon().alimentar(2);
				hambre.setText("Hambre");
				hambreNumero.setText(String.valueOf(ventana.getMiDigimon().getHambre()));
				salud.setText("Salud");
				saludNumero.setText(String.valueOf(ventana.getMiDigimon().getSalud()));
				afinidad.setText("Afinidad " + ventana.getMiDigimon().getAfinidad());
				afinidadNumero.setText(String.valueOf(ventana.getMiDigimon().getAfinidad()));
			}
		});

		menuAlimentar.add(menuItemHelado);

		LabelMenuItem menuItemPatatas = new LabelMenuItem("Patatas");
		menuItemPatatas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.getMiDigimon().alimentar(3);
				hambre.setText("Hambre");
				hambreNumero.setText(String.valueOf(ventana.getMiDigimon().getHambre()));
				salud.setText("Salud");
				saludNumero.setText(String.valueOf(ventana.getMiDigimon().getSalud()));
				afinidad.setText("Afinidad " + ventana.getMiDigimon().getAfinidad());
				afinidadNumero.setText(String.valueOf(ventana.getMiDigimon().getAfinidad()));
			}
		});

		menuAlimentar.add(menuItemPatatas);

		LabelMenuItem menuItemPlatano = new LabelMenuItem("Pl\u00E1tano");
		menuItemPlatano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.getMiDigimon().alimentar(4);
				hambre.setText("Hambre");
				hambreNumero.setText(String.valueOf(ventana.getMiDigimon().getHambre()));
				salud.setText("Salud");
				saludNumero.setText(String.valueOf(ventana.getMiDigimon().getSalud()));
				afinidad.setText("Afinidad " + ventana.getMiDigimon().getAfinidad());
				afinidadNumero.setText(String.valueOf(ventana.getMiDigimon().getAfinidad()));
			}
		});

		menuAlimentar.add(menuItemPlatano);

		LabelMenuItem menuItemArroz = new LabelMenuItem("Arroz");
		menuItemArroz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.getMiDigimon().alimentar(5);
				hambre.setText("Hambre");
				hambreNumero.setText(String.valueOf(ventana.getMiDigimon().getHambre()));
				salud.setText("Salud");
				saludNumero.setText(String.valueOf(ventana.getMiDigimon().getSalud()));
				afinidad.setText("Afinidad " + ventana.getMiDigimon().getAfinidad());
				afinidadNumero.setText(String.valueOf(ventana.getMiDigimon().getAfinidad()));
			}
		});

		menuAlimentar.add(menuItemArroz);

		LabelMenuItem menuItemPescado = new LabelMenuItem("Pescado");
		menuItemPescado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.getMiDigimon().alimentar(6);
				hambre.setText("Hambre");
				hambreNumero.setText(String.valueOf(ventana.getMiDigimon().getHambre()));
				salud.setText("Salud");
				saludNumero.setText(String.valueOf(ventana.getMiDigimon().getSalud()));
				afinidad.setText("Afinidad " + ventana.getMiDigimon().getAfinidad());
				afinidadNumero.setText(String.valueOf(ventana.getMiDigimon().getAfinidad()));
			}
		});

		menuAlimentar.add(menuItemPescado);

		LabelMenuItem menuItemRamen = new LabelMenuItem("Ramen");
		menuItemRamen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.getMiDigimon().alimentar(7);
				hambre.setText("Hambre");
				hambreNumero.setText(String.valueOf(ventana.getMiDigimon().getHambre()));
				salud.setText("Salud");
				saludNumero.setText(String.valueOf(ventana.getMiDigimon().getSalud()));
				afinidad.setText("Afinidad " + ventana.getMiDigimon().getAfinidad());
				afinidadNumero.setText(String.valueOf(ventana.getMiDigimon().getAfinidad()));
			}
		});

		menuAlimentar.add(menuItemRamen);

		LabelMenuItem mntmFilete = new LabelMenuItem("Filete");
		mntmFilete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.getMiDigimon().alimentar(8);
				hambre.setText("Hambre");
				hambreNumero.setText(String.valueOf(ventana.getMiDigimon().getHambre()));
				salud.setText("Salud");
				saludNumero.setText(String.valueOf(ventana.getMiDigimon().getSalud()));
				afinidad.setText("Afinidad " + ventana.getMiDigimon().getAfinidad());
				afinidadNumero.setText(String.valueOf(ventana.getMiDigimon().getAfinidad()));
			}
		});

		menuAlimentar.add(mntmFilete);

		LabelMenu menuDarMedicina = new LabelMenu("Dar medicina");
		menuBar.add(menuDarMedicina);

		LabelMenuItem menuItemAspirina = new LabelMenuItem("Aspirina");
		menuItemAspirina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.getMiDigimon().curar(3);
				salud.setText("Salud");
				saludNumero.setText(String.valueOf(ventana.getMiDigimon().getSalud()));
				afinidad.setText("Afinidad");
				afinidadNumero.setText(String.valueOf(ventana.getMiDigimon().getAfinidad()));
			}
		});

		menuDarMedicina.add(menuItemAspirina);

		LabelMenuItem menuItemRestituyente = new LabelMenuItem("Restituyente");
		menuItemRestituyente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.getMiDigimon().curar(5);
				salud.setText("Salud");
				saludNumero.setText(String.valueOf(ventana.getMiDigimon().getSalud()));
				afinidad.setText("Afinidad");
				afinidadNumero.setText(String.valueOf(ventana.getMiDigimon().getAfinidad()));
			}
		});

		menuDarMedicina.add(menuItemRestituyente);

		LabelMenu menuLimpiar = new LabelMenu("Limpiar");
		menuBar.add(menuLimpiar);

		LabelMenuItem menuItemRecogerCaca = new LabelMenuItem("Recoger caca");
		menuItemRecogerCaca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.getMiDigimon().limpiar(3);
				tieneCaca = false; // hace que la caca deje de estar activa y dejen de bajar las estadísticas
				higiene.setText("Higiene");
				higieneNumero.setText(String.valueOf(ventana.getMiDigimon().getHigiene()));
				salud.setText("Salud");
				saludNumero.setText(String.valueOf(ventana.getMiDigimon().getSalud()));
				afinidad.setText("Afinidad");
				afinidadNumero.setText(String.valueOf(ventana.getMiDigimon().getAfinidad()));

			}
		});

		menuLimpiar.add(menuItemRecogerCaca);

		LabelMenuItem menuItemBanar = new LabelMenuItem("Ba\u00F1ar");
		menuItemBanar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.getMiDigimon().limpiar(5);
				higiene.setText("Higiene");
				higieneNumero.setText(String.valueOf(ventana.getMiDigimon().getHigiene()));
				salud.setText("Salud");
				saludNumero.setText(String.valueOf(ventana.getMiDigimon().getSalud()));
				afinidad.setText("Afinidad");
				afinidadNumero.setText(String.valueOf(ventana.getMiDigimon().getAfinidad()));
			}
		});

		menuLimpiar.add(menuItemBanar);

		LabelMenu menuJugar = new LabelMenu("Jugar");
		menuBar.add(menuJugar);

		LabelMenuItem menuItemVerLaTele = new LabelMenuItem("Ver la tele");
		menuItemVerLaTele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ventana.getMiDigimon().jugar(3);
					entretenimiento.setText("Diversión");
					diversionNumero.setText(String.valueOf(ventana.getMiDigimon().getEntretenimiento()));
					afinidad.setText("Afinidad");
					afinidadNumero.setText(String.valueOf(ventana.getMiDigimon().getAfinidad()));
					energia.setText("Energia");
					energiaNumero.setText(String.valueOf(ventana.getMiDigimon().getEnergia()));
				} catch (EnergiaException ex) {
					JOptionPane.showMessageDialog(ventana,
							ventana.getMiDigimon().getNombre() + " está demasiado cansado para hacer esto", "¡OH, NO!",
							JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				} catch (SaludException ex) {
					JOptionPane.showMessageDialog(ventana,
							ventana.getMiDigimon().getNombre() + " está demasiado débil para esto", "¡OH, NO!",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		menuJugar.add(menuItemVerLaTele);

		LabelMenuItem menuItemLeerHistoria = new LabelMenuItem("Leer historia");
		menuItemLeerHistoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ventana.getMiDigimon().jugar(2);
					entretenimiento.setText("Diversión");
					diversionNumero.setText(String.valueOf(ventana.getMiDigimon().getEntretenimiento()));
					afinidad.setText("Afinidad");
					afinidadNumero.setText(String.valueOf(ventana.getMiDigimon().getAfinidad()));
					energia.setText("Energia");
					energiaNumero.setText(String.valueOf(ventana.getMiDigimon().getEnergia()));
				} catch (EnergiaException ex) {
					JOptionPane.showMessageDialog(ventana,
							ventana.getMiDigimon().getNombre() + " está demasiado cansado para hacer esto", "¡OH, NO!",
							JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				} catch (SaludException ex) {
					JOptionPane.showMessageDialog(ventana,
							ventana.getMiDigimon().getNombre() + " está demasiado débil para esto", "¡OH, NO!",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		menuJugar.add(menuItemLeerHistoria);

		LabelMenuItem menuItemEscondite = new LabelMenuItem("Escondite");
		menuItemEscondite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ventana.getMiDigimon().jugar(5);
					entretenimiento.setText("Diversión");
					diversionNumero.setText(String.valueOf(ventana.getMiDigimon().getEntretenimiento()));
					afinidad.setText("Afinidad");
					afinidadNumero.setText(String.valueOf(ventana.getMiDigimon().getAfinidad()));
					energia.setText("Energia");
					energiaNumero.setText(String.valueOf(ventana.getMiDigimon().getEnergia()));
				} catch (EnergiaException ex) {
					JOptionPane.showMessageDialog(ventana,
							ventana.getMiDigimon().getNombre() + " está demasiado cansado para hacer esto", "¡OH, NO!",
							JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				} catch (SaludException ex) {
					JOptionPane.showMessageDialog(ventana,
							ventana.getMiDigimon().getNombre() + " está demasiado débil para esto", "¡OH, NO!",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		menuJugar.add(menuItemEscondite);

		LabelMenuItem MenuItemJugarPelota = new LabelMenuItem("Jugar a la pelota");
		MenuItemJugarPelota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ventana.getMiDigimon().jugar(4);
					entretenimiento.setText("Diversión");
					diversionNumero.setText(String.valueOf(ventana.getMiDigimon().getEntretenimiento()));
					afinidad.setText("Afinidad");
					afinidadNumero.setText(String.valueOf(ventana.getMiDigimon().getAfinidad()));
					energia.setText("Energia");
					energiaNumero.setText(String.valueOf(ventana.getMiDigimon().getEnergia()));
				} catch (EnergiaException ex) {
					JOptionPane.showMessageDialog(ventana,
							ventana.getMiDigimon().getNombre() + " está demasiado cansado para hacer esto", "¡OH, NO!",
							JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				} catch (SaludException ex) {
					JOptionPane.showMessageDialog(ventana,
							ventana.getMiDigimon().getNombre() + " está demasiado débil para esto", "¡OH, NO!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		menuJugar.add(MenuItemJugarPelota);

		LabelMenuItem menuItemBailar = new LabelMenuItem("Bailar");
		menuItemBailar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ventana.getMiDigimon().jugar(5);
					entretenimiento.setText("Diversión");
					diversionNumero.setText(String.valueOf(ventana.getMiDigimon().getEntretenimiento()));
					afinidad.setText("Afinidad");
					afinidadNumero.setText(String.valueOf(ventana.getMiDigimon().getAfinidad()));
					energia.setText("Energia");
					energiaNumero.setText(String.valueOf(ventana.getMiDigimon().getEnergia()));
				} catch (EnergiaException ex) {
					JOptionPane.showMessageDialog(ventana,
							ventana.getMiDigimon().getNombre() + " está demasiado cansado para hacer esto", "¡OH, NO!",
							JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				} catch (SaludException ex) {
					JOptionPane.showMessageDialog(ventana,
							ventana.getMiDigimon().getNombre() + " está demasiado débil para esto", "¡OH, NO!",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		menuJugar.add(menuItemBailar);

		LabelMenu menuDormir = new LabelMenu("Dormir");
		menuDormir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ventana.getMiDigimon().dormir(8);
				salud.setText("Salud");
				saludNumero.setText(String.valueOf(ventana.getMiDigimon().getSalud()));
				energia.setText("Energia");
				energiaNumero.setText(String.valueOf(ventana.getMiDigimon().getEnergia()));
			}
		});

		menuBar.add(menuDormir);

		LabelMenu menuEntrenar = new LabelMenu("Entrenar");
		menuBar.add(menuEntrenar);

		LabelMenuItem menuItemSaltarComba = new LabelMenuItem("Saltar a la comba");
		menuItemSaltarComba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					ventana.getMiDigimon().entrenar(10);
					fuerza.setText("Fuerza");
					fuerzaNumero.setText(String.valueOf(ventana.getMiDigimon().getFuerza()));
					hambre.setText("Hambre");
					hambreNumero.setText(String.valueOf(ventana.getMiDigimon().getHambre()));
					energia.setText("Energia");
					energiaNumero.setText(String.valueOf(ventana.getMiDigimon().getEnergia()));
				} catch (EnergiaException ex) {
					JOptionPane.showMessageDialog(ventana,
							ventana.getMiDigimon().getNombre() + " está demasiado cansado para hacer esto", "¡OH, NO!",
							JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				} catch (AfinidadException ex) {
					JOptionPane.showMessageDialog(ventana, "No tienes suficiente afinidad con "
							+ ventana.getMiDigimon().getNombre() + " para hacer esto", "¡OH, NO!",
							JOptionPane.ERROR_MESSAGE);
				} catch (HambreException ex) {
					JOptionPane.showMessageDialog(ventana,
							ventana.getMiDigimon().getNombre() + " tiene demasiada hambre para hacer esto", "¡OH, NO!",
							JOptionPane.ERROR_MESSAGE);
				} catch (SaludException ex) {
					JOptionPane.showMessageDialog(ventana,
							ventana.getMiDigimon().getNombre() + " está demasiado débil para esto", "¡OH, NO!",
							JOptionPane.ERROR_MESSAGE);
				} catch (EntretenimientoException ex) {
					JOptionPane.showMessageDialog(ventana,
							ventana.getMiDigimon().getNombre() + " está aburrido y se niega a hacer esto", "¡OH, NO!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		menuEntrenar.add(menuItemSaltarComba);

		LabelMenuItem menuItemCarreraObstaculos = new LabelMenuItem("Carrera de obst\u00E1culos");
		menuItemCarreraObstaculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ventana.getMiDigimon().entrenar(20);
					fuerza.setText("Fuerza");
					fuerzaNumero.setText(String.valueOf(ventana.getMiDigimon().getFuerza()));
					hambre.setText("Hambre");
					hambreNumero.setText(String.valueOf(ventana.getMiDigimon().getHambre()));
					energia.setText("Energia");
					energiaNumero.setText(String.valueOf(ventana.getMiDigimon().getEnergia()));
				} catch (EnergiaException ex) {
					JOptionPane.showMessageDialog(ventana,
							ventana.getMiDigimon().getNombre() + " está demasiado cansado para hacer esto", "¡OH, NO!",
							JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				} catch (AfinidadException ex) {
					JOptionPane.showMessageDialog(ventana, "No tienes suficiente afinidad con "
							+ ventana.getMiDigimon().getNombre() + " para hacer esto", "¡OH, NO!",
							JOptionPane.ERROR_MESSAGE);
				} catch (HambreException ex) {
					JOptionPane.showMessageDialog(ventana,
							ventana.getMiDigimon().getNombre() + " tiene demasiada hambre para hacer esto", "¡OH, NO!",
							JOptionPane.ERROR_MESSAGE);
				} catch (SaludException ex) {
					JOptionPane.showMessageDialog(ventana,
							ventana.getMiDigimon().getNombre() + " está demasiado débil para esto", "¡OH, NO!",
							JOptionPane.ERROR_MESSAGE);
				} catch (EntretenimientoException ex) {
					JOptionPane.showMessageDialog(ventana,
							ventana.getMiDigimon().getNombre() + " está aburrido y se niega a hacer esto", "¡OH, NO!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		menuEntrenar.add(menuItemCarreraObstaculos);

		LabelMenuItem menuItemNadar = new LabelMenuItem("Nadar");
		menuItemNadar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					ventana.getMiDigimon().entrenar(15);
					fuerza.setText("Fuerza");
					fuerzaNumero.setText(String.valueOf(ventana.getMiDigimon().getFuerza()));
					hambre.setText("Hambre");
					hambreNumero.setText(String.valueOf(ventana.getMiDigimon().getHambre()));
					energia.setText("Energia");
					energiaNumero.setText(String.valueOf(ventana.getMiDigimon().getEnergia()));
				} catch (EnergiaException ex) {
					JOptionPane.showMessageDialog(ventana,
							ventana.getMiDigimon().getNombre() + " está demasiado cansado para hacer esto", "¡OH, NO!",
							JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				} catch (AfinidadException ex) {
					JOptionPane.showMessageDialog(ventana, "No tienes suficiente afinidad con "
							+ ventana.getMiDigimon().getNombre() + " para hacer esto", "¡OH, NO!",
							JOptionPane.ERROR_MESSAGE);
				} catch (HambreException ex) {
					JOptionPane.showMessageDialog(ventana,
							ventana.getMiDigimon().getNombre() + " tiene demasiada hambre para hacer esto", "¡OH, NO!",
							JOptionPane.ERROR_MESSAGE);
				} catch (SaludException ex) {
					JOptionPane.showMessageDialog(ventana,
							ventana.getMiDigimon().getNombre() + " está demasiado débil para esto", "¡OH, NO!",
							JOptionPane.ERROR_MESSAGE);
				} catch (EntretenimientoException ex) {
					JOptionPane.showMessageDialog(ventana,
							ventana.getMiDigimon().getNombre() + " está aburrido y se niega a hacer esto", "¡OH, NO!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		menuEntrenar.add(menuItemNadar);

		LabelMenuItem menuItemEscalada = new LabelMenuItem("Escalada");
		menuItemEscalada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ventana.getMiDigimon().entrenar(20);
					fuerza.setText("Fuerza");
					fuerzaNumero.setText(String.valueOf(ventana.getMiDigimon().getFuerza()));
					hambre.setText("Hambre");
					hambreNumero.setText(String.valueOf(ventana.getMiDigimon().getHambre()));
					energia.setText("Energia");
					energiaNumero.setText(String.valueOf(ventana.getMiDigimon().getEnergia()));
				} catch (EnergiaException ex) {
					JOptionPane.showMessageDialog(ventana,
							ventana.getMiDigimon().getNombre() + " está demasiado cansado para hacer esto", "¡OH, NO!",
							JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				} catch (AfinidadException ex) {
					JOptionPane.showMessageDialog(ventana, "No tienes suficiente afinidad con "
							+ ventana.getMiDigimon().getNombre() + " para hacer esto", "¡OH, NO!",
							JOptionPane.ERROR_MESSAGE);
				} catch (HambreException ex) {
					JOptionPane.showMessageDialog(ventana,
							ventana.getMiDigimon().getNombre() + " tiene demasiada hambre para hacer esto", "¡OH, NO!",
							JOptionPane.ERROR_MESSAGE);
				} catch (SaludException ex) {
					JOptionPane.showMessageDialog(ventana,
							ventana.getMiDigimon().getNombre() + " está demasiado débil para esto", "¡OH, NO!",
							JOptionPane.ERROR_MESSAGE);
				} catch (EntretenimientoException ex) {
					JOptionPane.showMessageDialog(ventana,
							ventana.getMiDigimon().getNombre() + " está aburrido y se niega a hacer esto", "¡OH, NO!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		menuEntrenar.add(menuItemEscalada);

		LabelMenuItem menuItemMoverPiedras = new LabelMenuItem("Mover piedras");
		menuItemMoverPiedras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ventana.getMiDigimon().entrenar(25);
					fuerza.setText("Fuerza");
					fuerzaNumero.setText(String.valueOf(ventana.getMiDigimon().getFuerza()));
					hambre.setText("Hambre");
					hambreNumero.setText(String.valueOf(ventana.getMiDigimon().getHambre()));
					energia.setText("Energia");
					energiaNumero.setText(String.valueOf(ventana.getMiDigimon().getEnergia()));
				} catch (EnergiaException ex) {
					JOptionPane.showMessageDialog(ventana,
							ventana.getMiDigimon().getNombre() + " está demasiado cansado para hacer esto", "¡OH, NO!",
							JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				} catch (AfinidadException ex) {
					JOptionPane.showMessageDialog(ventana, "No tienes suficiente afinidad con "
							+ ventana.getMiDigimon().getNombre() + " para hacer esto", "¡OH, NO!",
							JOptionPane.ERROR_MESSAGE);
				} catch (HambreException ex) {
					JOptionPane.showMessageDialog(ventana,
							ventana.getMiDigimon().getNombre() + " tiene demasiada hambre para hacer esto", "¡OH, NO!",
							JOptionPane.ERROR_MESSAGE);
				} catch (SaludException ex) {
					JOptionPane.showMessageDialog(ventana,
							ventana.getMiDigimon().getNombre() + " está demasiado débil para esto", "¡OH, NO!",
							JOptionPane.ERROR_MESSAGE);
				} catch (EntretenimientoException ex) {
					JOptionPane.showMessageDialog(ventana,
							ventana.getMiDigimon().getNombre() + " está aburrido y se niega a hacer esto", "¡OH, NO!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		menuEntrenar.add(menuItemMoverPiedras);

		LabelMenu mnGuardar = new LabelMenu("Guardar");
		mnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// AQUI GUARDAMOS LAS PARTIDAS

				// Usas connection para sacar statement
				try {
					Connection conexion = (Connection) DriverManager
							.getConnection("jdbc:mysql://127.0.0.1:3306/usuario", "root", "admin");
					Statement smt = (Statement) conexion.createStatement();

					PreparedStatement psmt = conexion.prepareStatement(
							"update partida set id_partida=?,nombre=?,nivel=?,fuerza=?,defensa=?,salud=?,hambre=?,energia=?,higiene=?,afinidad=?,entretenimiento=?");
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

			}
		});
		menuBar.add(mnGuardar);

		final LabelMenu salir = new LabelMenu("Salir");
		salir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int opcionElegida = JOptionPane.showConfirmDialog(salir, "¿Seguro que quieres salir?",
						"Digimon - Virtual Pet", JOptionPane.YES_NO_OPTION);
				if (opcionElegida == 0) {
					System.exit(0);
				}

			}
		});
		menuBar.add(salir);

		JPanel estadisticas = new JPanel();
		estadisticas.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 153, 0)));
		estadisticas.setBackground(new Color(255, 255, 153));
		estadisticas.setBounds(10, 119, 180, 244);
		add(estadisticas);
		estadisticas.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		hambre = new LabelEstadisticas("Hambre");
		hambre.setText("Hambre");
		estadisticas.add(hambre);

		hambreNumero = new LabelEstadisticas("New label");
		hambreNumero.setText(String.valueOf(ventana.getMiDigimon().getHambre()));
		estadisticas.add(hambreNumero);

		salud = new LabelEstadisticas("Salud");
		salud.setText("Salud");
		estadisticas.add(salud);

		saludNumero = new LabelEstadisticas("New label");
		saludNumero.setText(String.valueOf(ventana.getMiDigimon().getSalud()));
		estadisticas.add(saludNumero);

		energia = new LabelEstadisticas("Sue\u00F1o");
		energia.setText("Energ\u00EDa 0");
		energia.setText("Energía");
		estadisticas.add(energia);

		energiaNumero = new LabelEstadisticas("New label");
		energiaNumero.setText(String.valueOf(ventana.getMiDigimon().getEnergia()));
		estadisticas.add(energiaNumero);

		higiene = new LabelEstadisticas("Higiene");
		higiene.setText("Higiene");
		estadisticas.add(higiene);

		higieneNumero = new LabelEstadisticas("New label");
		higieneNumero.setText(String.valueOf(ventana.getMiDigimon().getHigiene()));
		estadisticas.add(higieneNumero);

		entretenimiento = new LabelEstadisticas("Diversión");
		entretenimiento.setText("Diversión");
		estadisticas.add(entretenimiento);

		diversionNumero = new LabelEstadisticas("New label");
		diversionNumero.setText(String.valueOf(ventana.getMiDigimon().getEntretenimiento()));
		estadisticas.add(diversionNumero);

		fuerza = new LabelEstadisticas("Fuerza");
		fuerza.setText("Fuerza");
		estadisticas.add(fuerza);

		fuerzaNumero = new LabelEstadisticas("New label");
		fuerzaNumero.setText(String.valueOf(ventana.getMiDigimon().getFuerza()));
		estadisticas.add(fuerzaNumero);

		defensa = new LabelEstadisticas("Defensa");
		defensa.setText("Defensa");
		estadisticas.add(defensa);

		defensaNumero = new LabelEstadisticas("New label");
		defensaNumero.setText(String.valueOf(ventana.getMiDigimon().getDefensa()));
		estadisticas.add(defensaNumero);

		afinidad = new LabelEstadisticas("Afinidad");
		afinidad.setText("Afinidad");
		estadisticas.add(afinidad);

		afinidadNumero = new LabelEstadisticas("New label");
		afinidadNumero.setText(String.valueOf(ventana.getMiDigimon().getAfinidad()));
		estadisticas.add(afinidadNumero);

		JPanel digivice = new JPanel();
		digivice.setBounds(172, 60, 398, 315);
		add(digivice);
		digivice.setLayout(null);
		digivice.setOpaque(false);

		imagenDigimon = new JLabel("");
		imagenDigimon.setHorizontalAlignment(SwingConstants.CENTER);
		imagenDigimon.setBounds(145, 90, 106, 108);
		digivice.add(imagenDigimon);

		JLabel digiviceIMG = new JLabel("");
		digiviceIMG.setIcon(new ImageIcon("digivice.png"));
		digiviceIMG.setBounds(20, -39, 388, 367);
		digivice.add(digiviceIMG);

		labelNombre = new JLabel("Nombre");
		labelNombre.setHorizontalAlignment(SwingConstants.CENTER);
		labelNombre.setForeground(new Color(255, 102, 0));
		labelNombre.setFont(new Font("Pixel Digivolve", Font.ITALIC, 16));
		labelNombre.setBounds(243, 260, 155, 55);
		labelNombre.setText(ventana.getMiDigimon().getNombre());
		;
		digivice.add(labelNombre);

		JLabel nivel = new JLabel("Nivel:");
		nivel.setHorizontalAlignment(SwingConstants.CENTER);
		nivel.setBounds(10, 56, 180, 30);
		add(nivel);
		nivel.setFont(new Font("Pixel Digivolve", Font.PLAIN, 16));
		nivel.setForeground(Color.WHITE);

		labelNivel = new JLabel(ventana.getMiDigimon().getNivel());
		labelNivel.setHorizontalAlignment(SwingConstants.CENTER);
		labelNivel.setBounds(10, 78, 180, 45);
		add(labelNivel);
		labelNivel.setFont(new Font("Pixel Digivolve", Font.PLAIN, 16));
		labelNivel.setForeground(Color.WHITE);
		labelNivel.setText(ventana.getMiDigimon().getNivel());

		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon("fondo.jpg"));
		fondo.setBounds(0, 0, 580, 402);
		add(fondo);

		this.setVisible(true);

		new Thread(this).start();
	}

	public void run() {
		while (ventana.getMiDigimon().getSalud() > 0 && ventana.getMiDigimon().getHambre() <= 10) {
			Random r = new Random();

			// generar caca de forma aleatoria
			int caca = (int) (Math.random() * 8) + 1;

			// generar eventos aleatorios de batalla
			if (!ventana.getMiDigimon().getNivel().equals("Bebé")) {
				int enemigo = (int) (Math.random() * 3) + 1;
				if (enemigo == 3) {
					Enemigo aviso = new Enemigo(ventana);
					aviso.setVisible(true);
				}
			}
			if (ventana.getMiDigimon().getSalud() <= 3) {
				JOptionPane.showMessageDialog(ventana, ventana.getMiDigimon().getNombre() + " está enfermo", "¡OH, NO!",
						JOptionPane.ERROR_MESSAGE);
			}

			hambre.setText("Hambre");
			hambreNumero.setText(String.valueOf(ventana.getMiDigimon().getHambre() + 1));
			hambre.setVisible(false);
			hambre.setVisible(true);
			hambreNumero.setVisible(false);
			hambreNumero.setVisible(true);

			salud.setText("Salud");
			saludNumero.setText(String.valueOf(ventana.getMiDigimon().getSalud()));
			salud.setVisible(false);
			salud.setVisible(true);
			saludNumero.setVisible(false);
			saludNumero.setVisible(true);

			energia.setText("Energia");
			energiaNumero.setText(String.valueOf(ventana.getMiDigimon().getEnergia() - 1));
			energia.setVisible(false);
			energia.setVisible(true);
			energiaNumero.setVisible(false);
			energiaNumero.setVisible(true);

			higiene.setText("Higiene");
			higieneNumero.setText(String.valueOf(ventana.getMiDigimon().getHigiene() - 1));
			higiene.setVisible(false);
			higiene.setVisible(true);
			higieneNumero.setVisible(false);
			higieneNumero.setVisible(true);

			entretenimiento.setText("Diversión");
			diversionNumero.setText(String.valueOf(ventana.getMiDigimon().getEntretenimiento() - 1));
			entretenimiento.setVisible(false);
			entretenimiento.setVisible(true);
			diversionNumero.setVisible(false);
			diversionNumero.setVisible(true);

			fuerza.setText("Fuerza");
			fuerzaNumero.setText(String.valueOf(ventana.getMiDigimon().getFuerza()));
			fuerza.setVisible(false);
			fuerza.setVisible(true);
			fuerzaNumero.setVisible(false);
			fuerzaNumero.setVisible(true);

			defensa.setText("Defensa");
			defensaNumero.setText(String.valueOf(ventana.getMiDigimon().getDefensa()));
			defensa.setVisible(false);
			defensa.setVisible(true);
			defensaNumero.setVisible(false);
			defensaNumero.setVisible(true);

			afinidad.setText("Afinidad");
			afinidadNumero.setText(String.valueOf(ventana.getMiDigimon().getAfinidad()));
			afinidad.setVisible(false);
			afinidad.setVisible(true);
			afinidadNumero.setVisible(false);
			afinidadNumero.setVisible(true);

			// DIGIEVOLUCIONES
			if (ventana.getMiDigimon().getFuerza() >= 20 && contador == 0) {
				contador++;
				Evolucion ventanaEvolucion = new Evolucion(ventana);
				ventanaEvolucion.setVisible(true);
				ventana.getMiDigimon().setNombre(Digimon.getNombreEvolucion(ventana.getMiDigimon().getNombre()));
				try {
					Connection conexion = (Connection) DriverManager
							.getConnection("jdbc:mysql://127.0.0.1:3306/usuario", "root", "admin");
					Statement smt = (Statement) conexion.createStatement();
					PreparedStatement ps = conexion.prepareStatement("update partida set nombre=?, where id_partida='"
							+ ventana.getUsuario().getUsuario() + "'");
					ps.setString(1, ventana.getMiDigimon().getNombre());
					conexion.close();
				}

				catch (SQLException ex) {
					ex.printStackTrace();
				}

				labelNombre.setText(ventana.getMiDigimon().getNombre());
				ventana.getMiDigimon().setNivel(niveles[0]);
				labelNivel.setText(ventana.getMiDigimon().getNivel());
				ventana.getMiDigimon().setFuerza(ventana.getMiDigimon().getFuerza() + 20);
				fuerzaNumero.setText(String.valueOf(ventana.getMiDigimon().getFuerza()));
				fuerzaNumero.setVisible(false);
				fuerzaNumero.setVisible(true);
				ventana.getMiDigimon().setDefensa(ventana.getMiDigimon().getDefensa() + 20);
				defensaNumero.setText(String.valueOf(ventana.getMiDigimon().getDefensa()));
				defensaNumero.setVisible(false);
				defensaNumero.setVisible(true);

				// IMPRIMIR NUEVAS ESTADÍSTICAS
				BufferedWriter bw = null;

				try {
					File digiEvolucion1 = new File("./ digiEvolucion1.txt");
					FileWriter fw = new FileWriter(digiEvolucion1, true);
					bw = new BufferedWriter(fw);
					bw.write("¡Tu Digimon ha digievolucionado" + "\r\n" + "------------------------------" + "\r\n"
							+ "Nombre: " + ventana.getMiDigimon().getNombre() + "\r\n" + "Nivel: "
							+ ventana.getMiDigimon().getNivel() + "\r\n" + "Fuerza: "
							+ ventana.getMiDigimon().getFuerza() + "\r\n" + "Defensa: "
							+ ventana.getMiDigimon().getDefensa() + "\r\n");

					bw.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			if (ventana.getMiDigimon().getFuerza() >= 80 && contador == 1) {
				contador++;
				Evolucion ventanaEvolucion = new Evolucion(ventana);
				ventanaEvolucion.setVisible(true);
				ventana.getMiDigimon().setNombre(Digimon.getNombreEvolucion(ventana.getMiDigimon().getNombre()));
				try {
					Connection conexion = (Connection) DriverManager
							.getConnection("jdbc:mysql://127.0.0.1:3306/usuario", "root", "admin");
					Statement smt = (Statement) conexion.createStatement();
					PreparedStatement ps = conexion.prepareStatement("update partida set nombre=?, where id_partida='"
							+ ventana.getUsuario().getUsuario() + "'");
					ps.setString(1, ventana.getMiDigimon().getNombre());
					conexion.close();
				}

				catch (SQLException ex) {
					ex.printStackTrace();
				}

				labelNombre.setText(ventana.getMiDigimon().getNombre());
				ventana.getMiDigimon().setNivel(niveles[1]);
				labelNivel.setText(ventana.getMiDigimon().getNivel());
				ventana.getMiDigimon().setFuerza(ventana.getMiDigimon().getFuerza() + 20);
				fuerzaNumero.setText(String.valueOf(ventana.getMiDigimon().getFuerza()));
				fuerzaNumero.setVisible(false);
				fuerzaNumero.setVisible(true);
				ventana.getMiDigimon().setDefensa(ventana.getMiDigimon().getDefensa() + 20);
				defensaNumero.setText(String.valueOf(ventana.getMiDigimon().getDefensa()));
				defensaNumero.setVisible(false);
				defensaNumero.setVisible(true);

				// IMPRIMIR NUEVAS ESTADÍSTICAS
				BufferedWriter bw = null;

				try {
					File digiEvolucion2 = new File("./ digiEvolucion2.txt");
					FileWriter fw = new FileWriter(digiEvolucion2, true);
					bw = new BufferedWriter(fw);
					bw.write("¡Tu Digimon ha digievolucionado" + "\r\n" + "------------------------------" + "\r\n"
							+ "Nombre: " + ventana.getMiDigimon().getNombre() + "\r\n" + "Nivel: "
							+ ventana.getMiDigimon().getNivel() + "\r\n" + "Fuerza: "
							+ ventana.getMiDigimon().getFuerza() + "\r\n" + "Defensa: "
							+ ventana.getMiDigimon().getDefensa() + "\r\n");

					bw.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (ventana.getMiDigimon().getFuerza() >= 150 && contador == 2) {
				contador++;
				Evolucion ventanaEvolucion = new Evolucion(ventana);
				ventanaEvolucion.setVisible(true);
				ventana.getMiDigimon().setNombre(Digimon.getNombreEvolucion(ventana.getMiDigimon().getNombre()));
				try {
					Connection conexion = (Connection) DriverManager
							.getConnection("jdbc:mysql://127.0.0.1:3306/usuario", "root", "admin");
					Statement smt = (Statement) conexion.createStatement();
					PreparedStatement ps = conexion.prepareStatement("update partida set nombre=?, where id_partida='"
							+ ventana.getUsuario().getUsuario() + "'");
					ps.setString(1, ventana.getMiDigimon().getNombre());
					conexion.close();
				}

				catch (SQLException ex) {
					ex.printStackTrace();
				}

				labelNombre.setText(ventana.getMiDigimon().getNombre());
				ventana.getMiDigimon().setNivel(niveles[2]);
				labelNivel.setText(ventana.getMiDigimon().getNivel());
				ventana.getMiDigimon().setFuerza(ventana.getMiDigimon().getFuerza() + 20);
				fuerzaNumero.setText(String.valueOf(ventana.getMiDigimon().getFuerza()));
				fuerzaNumero.setVisible(false);
				fuerzaNumero.setVisible(true);
				ventana.getMiDigimon().setDefensa(ventana.getMiDigimon().getDefensa() + 20);
				defensaNumero.setText(String.valueOf(ventana.getMiDigimon().getDefensa()));
				defensaNumero.setVisible(false);
				defensaNumero.setVisible(true);

				// IMPRIMIR NUEVAS ESTADÍSTICAS
				BufferedWriter bw = null;

				try {
					File digiEvolucion3 = new File("./ digiEvolucion3.txt");
					FileWriter fw = new FileWriter(digiEvolucion3, true);
					bw = new BufferedWriter(fw);
					bw.write("¡Tu Digimon ha digievolucionado" + "\r\n" + "------------------------------" + "\r\n"
							+ "Nombre: " + ventana.getMiDigimon().getNombre() + "\r\n" + "Nivel: "
							+ ventana.getMiDigimon().getNivel() + "\r\n" + "Fuerza: "
							+ ventana.getMiDigimon().getFuerza() + "\r\n" + "Defensa: "
							+ ventana.getMiDigimon().getDefensa() + "\r\n");

					bw.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (ventana.getMiDigimon().getFuerza() >= 200 && contador == 3) {
				contador++;
				Evolucion ventanaEvolucion = new Evolucion(ventana);
				ventanaEvolucion.setVisible(true);
				ventana.getMiDigimon().setNombre(Digimon.getNombreEvolucion(ventana.getMiDigimon().getNombre()));
				try {
					Connection conexion = (Connection) DriverManager
							.getConnection("jdbc:mysql://127.0.0.1:3306/usuario", "root", "admin");
					Statement smt = (Statement) conexion.createStatement();
					PreparedStatement ps = conexion.prepareStatement("update partida set nombre=?, where id_partida='"
							+ ventana.getUsuario().getUsuario() + "'");
					ps.setString(1, ventana.getMiDigimon().getNombre());
					conexion.close();
				}

				catch (SQLException ex) {
					ex.printStackTrace();
				}

				labelNombre.setText(ventana.getMiDigimon().getNombre());
				ventana.getMiDigimon().setNivel(niveles[3]);
				labelNivel.setText(ventana.getMiDigimon().getNivel());
				ventana.getMiDigimon().setFuerza(ventana.getMiDigimon().getFuerza() + 20);
				fuerzaNumero.setText(String.valueOf(ventana.getMiDigimon().getFuerza()));
				fuerzaNumero.setVisible(false);
				fuerzaNumero.setVisible(true);
				ventana.getMiDigimon().setDefensa(ventana.getMiDigimon().getDefensa() + 20);
				defensaNumero.setText(String.valueOf(ventana.getMiDigimon().getDefensa()));
				defensaNumero.setVisible(false);
				defensaNumero.setVisible(true);

				// IMPRIMIR NUEVAS ESTADÍSTICAS
				BufferedWriter bw = null;

				try {
					File digiEvolucion3 = new File("./ digiEvolucion3.txt");
					FileWriter fw = new FileWriter(digiEvolucion3, true);
					bw = new BufferedWriter(fw);
					bw.write("¡Tu Digimon ha digievolucionado" + "\r\n" + "------------------------------" + "\r\n"
							+ "Nombre: " + ventana.getMiDigimon().getNombre() + "\r\n" + "Nivel: "
							+ ventana.getMiDigimon().getNivel() + "\r\n" + "Fuerza: "
							+ ventana.getMiDigimon().getFuerza() + "\r\n" + "Defensa: "
							+ ventana.getMiDigimon().getDefensa() + "\r\n");

					bw.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// IMAGENES DIGIVICE
			if (ventana.getMiDigimon().getNombre().equals("Koromon")) {
				imagenDigimon.setIcon(new ImageIcon(imagenesDigimon.get("koromon")));
			} else if (ventana.getMiDigimon().getNombre().contentEquals("Tsunomon")) {
				imagenDigimon.setIcon(new ImageIcon(imagenesDigimon.get("tsunomon")));
			} else if (ventana.getMiDigimon().getNombre().contentEquals("Nyaromon")) {
				imagenDigimon.setIcon(new ImageIcon(imagenesDigimon.get("nyaromon")));
			}
			if (ventana.getMiDigimon().getNombre().equals("Agumon")) {
				imagenDigimon.setIcon(new ImageIcon(imagenesDigimon.get("agumon")));
			} else if (ventana.getMiDigimon().getNombre().contentEquals("Gabumon")) {
				imagenDigimon.setIcon(new ImageIcon(imagenesDigimon.get("gabumon")));
			} else if (ventana.getMiDigimon().getNombre().contentEquals("Salamon")) {
				imagenDigimon.setIcon(new ImageIcon(imagenesDigimon.get("salamon")));
			}
			if (ventana.getMiDigimon().getNombre().equals("Greymon")) {
				imagenDigimon.setIcon(new ImageIcon(imagenesDigimon.get("greymon")));
			} else if (ventana.getMiDigimon().getNombre().contentEquals("Garurumon")) {
				imagenDigimon.setIcon(new ImageIcon(imagenesDigimon.get("garurumon")));
			} else if (ventana.getMiDigimon().getNombre().contentEquals("Gatomon")) {
				imagenDigimon.setIcon(new ImageIcon(imagenesDigimon.get("gatomon")));
			}
			if (ventana.getMiDigimon().getNombre().equals("MetalGreymon")) {
				imagenDigimon.setIcon(new ImageIcon(imagenesDigimon.get("metalgreymon")));
			} else if (ventana.getMiDigimon().getNombre().contentEquals("WereGarurumon")) {
				imagenDigimon.setIcon(new ImageIcon(imagenesDigimon.get("weregarurumon")));
			} else if (ventana.getMiDigimon().getNombre().contentEquals("Angewomon")) {
				imagenDigimon.setIcon(new ImageIcon(imagenesDigimon.get("angewomon")));
			}
			if (ventana.getMiDigimon().getNombre().equals("WarGreymon")) {
				imagenDigimon.setIcon(new ImageIcon(imagenesDigimon.get("wargreymon")));
			} else if (ventana.getMiDigimon().getNombre().contentEquals("MetalGarurumon")) {
				imagenDigimon.setIcon(new ImageIcon(imagenesDigimon.get("metalgarurumon")));
			} else if (ventana.getMiDigimon().getNombre().contentEquals("Ophanimon")) {
				imagenDigimon.setIcon(new ImageIcon(imagenesDigimon.get("ophanimon")));
			}

			// cuando el número aleatorio sea 3, el digimon se hará caca
			if (caca == 5) {
				tieneCaca = true;
				JOptionPane.showMessageDialog(ventana, ventana.getMiDigimon().getNombre() + " sa cagao", "¡OH, NO!",
						JOptionPane.ERROR_MESSAGE);
			}

			// mientras no se limpie la caca (en el menú limpiar), irán bajando estadísticas
			// relacionadas
			if (tieneCaca) {
				ventana.getMiDigimon().setHigiene(ventana.getMiDigimon().getHigiene() - 2);
				ventana.getMiDigimon().setSalud(ventana.getMiDigimon().getSalud() - 1);
				higiene.setText("Higiene");
				higieneNumero.setText(String.valueOf(ventana.getMiDigimon().getHigiene()));
				salud.setText("Salud");
				saludNumero.setText(String.valueOf(ventana.getMiDigimon().getSalud()));
			}

			try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		Muerte nuevaVentana = new Muerte(ventana);
		nuevaVentana.setVisible(true);
	}
}
