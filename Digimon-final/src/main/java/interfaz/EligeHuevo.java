package interfaz;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import componentes.BotonHuevo;
import digimon.Digimon;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EligeHuevo extends JPanel{
	
		private Ventana ventana;
		
	public EligeHuevo (Ventana v) {
		super();
		setSize(new Dimension(580, 400));
		this.ventana=v;
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
				ventana.setMiDigimon(new Digimon ("Koromon","Bebé",10,3,0,0,0,5,0,5));
				
				ventana.irAPet();
			}
		});
		huevo1.setLocation(211, 161);
		huevo1.setIcon(new ImageIcon("huevo1.png"));
		huevo1.setFont(new Font("Pixel Digivolve", Font.PLAIN, 16));
		add(huevo1);
		
		JLabel texto1 = new JLabel("+ Fuerza");
		texto1.setFont(new Font("Pixel Digivolve", Font.BOLD | Font.ITALIC, 16));
		texto1.setForeground(Color.WHITE);
		texto1.setBounds(240, 116, 98, 34);
		add(texto1);
		
		BotonHuevo huevo2 = new BotonHuevo("");
		huevo2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.setMiDigimon(new Digimon ("Tsunomon","Bebé",10,0,0,0,0,5,0,5));
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
				ventana.setMiDigimon(new Digimon ("Nyaromon","Bebé",10,0,3,0,0,5,0,5));
				ventana.irAPet();
			}
		});
		huevo3.setLocation(393, 161);
		huevo3.setIcon(new ImageIcon("huevo3.png"));
		add(huevo3);
		
		JLabel texto2 = new JLabel("+ XP");
		texto2.setForeground(Color.WHITE);
		texto2.setFont(new Font("Pixel Digivolve", Font.BOLD | Font.ITALIC, 16));
		texto2.setBounds(78, 116, 57, 34);
		add(texto2);
		
		JLabel texto3 = new JLabel("+ Defensa");
		texto3.setForeground(Color.WHITE);
		texto3.setFont(new Font("Pixel Digivolve", Font.BOLD | Font.ITALIC, 16));
		texto3.setBounds(418, 116, 98, 34);
		add(texto3);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon("fondo.jpg"));
		fondo.setBounds(-13, -26, 619, 450);
		add(fondo);
		
		
		
		
		setVisible(true);
	}
}

