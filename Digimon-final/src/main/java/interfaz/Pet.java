package interfaz;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Pet extends JPanel{
	
	private Ventana ventana;
	
	public Pet(Ventana v) {
		super();
		this.ventana=v;
		
		setBackground(Color.WHITE);
		setSize(580,400);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(172, 145, 398, 232);
		add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 91, 560, 43);
		add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton botonAlimentar = new JButton("Alimentar");
		botonAlimentar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		panel_1.add(botonAlimentar);
		
		JButton botonjJugar = new JButton("Jugar");
		botonjJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_1.add(botonjJugar);
		
		JButton botonLavar = new JButton("Lavar");
		panel_1.add(botonLavar);
		
		JButton botonDormir = new JButton("Dormir");
		panel_1.add(botonDormir);
		
		JButton botonEntrenar = new JButton("Entrenar");
		panel_1.add(botonEntrenar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 145, 152, 232);
		add(panel_2);
		
		JLabel hambre = new JLabel("Hambre");
		
		JLabel afinidad = new JLabel("Afinidad");
		
		JLabel salud = new JLabel("Salud");
		
		JLabel sueño = new JLabel("Sue\u00F1o");
		
		JLabel fuerza = new JLabel("Fuerza");
		
		JLabel entretenimiento = new JLabel("Entretenimiento");
		
		JLabel higiene = new JLabel("Higiene");
		
		JLabel defensa = new JLabel("Defensa");
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		panel_2.add(hambre);
		panel_2.add(afinidad);
		panel_2.add(salud);
		panel_2.add(sueño);
		panel_2.add(fuerza);
		panel_2.add(entretenimiento);
		panel_2.add(higiene);
		panel_2.add(defensa);
		
	}
}
