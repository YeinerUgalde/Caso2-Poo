package YateGui;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Yate.Constantes;
import YateControllers.YateMainFrameController;
import Yate.Clima;

public class YateMainFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private JLabel lblBattery1;
	private JLabel lblBattery2;
	private JLabel lblBattery3;
	private JLabel lbsCronometro;
	private JLabel lblVelocidad;
	private JLabel lbsClima;
	private JLabel lbsCapacidadPanel;
	
	private YateMainFrameController controller;
	
	public YateMainFrame(String pTitle, YateMainFrameController pController) {
		super(pTitle);
		controller = pController;
		controller.setWindow(this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setBounds(0,0,600,300);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setBackground(Color.white);
		this.initComponents();
		this.setVisible(true);
		
	}
	public void setBatterylevel(float pEnergy, int val) {
		if (val==1) {
			lblBattery1.setText("bateria 1: "+pEnergy);
		}
		if (val==2) {
			lblBattery2.setText("bateria 2: "+pEnergy);
		}
		if (val==3) {
			lblBattery3.setText("bateria 3: "+pEnergy);
		}
			
	
	}
	
	public void setVelocidad(float pVelocidad) {
		lblVelocidad.setText("Velocidad: "+pVelocidad);
	}
	
	public void setCronometro(int pTiempo) {
		lbsCronometro.setText("Tiempo: "+ pTiempo);
	}
	
	public void setClima(String pTiempo) {
		lbsClima.setText("Clima: "+ pTiempo);
	}
	
	public void setCapacidadPaneles(float valorClima) {
		lbsCapacidadPanel.setText("Capacidad de paneles: "+ valorClima + "%");
	}
	
	private void initComponents() {
		lblVelocidad = new JLabel("Velocidad del yate");
		lblVelocidad.setBounds(10,20,160,20);
		this.add(lblVelocidad);
		
		//JTextField txtAmount = new JTextField();
		//txtAmount.setBounds(230,20,160,20);
		//this.add(txtAmount);
		 
		lblBattery1 = new JLabel ("Bateria 1");
		lblBattery1.setBounds(10,50,160,20);
		this.add(lblBattery1);
		
		lblBattery2 = new JLabel ("Bateria 2");
		lblBattery2.setBounds(10,70,160,20);
		this.add(lblBattery2);
		
		lblBattery3 = new JLabel ("Bateria 3");
		lblBattery3.setBounds(10,90,160,20);
		this.add(lblBattery3);
		
		lbsCronometro = new JLabel ("Tiempo: ");
		lbsCronometro.setBounds(10,110,160,20);
		this.add(lbsCronometro);
		
		lbsClima = new JLabel ("Clima: ");
		lbsClima.setBounds(10,130,160,20);
		this.add(lbsClima);
		
		lbsCapacidadPanel = new JLabel ("Capacidad de paneles: ");
		lbsCapacidadPanel.setBounds(10,150,160,20);
		this.add(lbsCapacidadPanel);
		
		
		JButton btnUpVel = new JButton ("Aumentar velocidad");
		btnUpVel.setBounds(280,72,150,20);
		btnUpVel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				controller.acelerar();
				System.out.println(Constantes.getVelocidadConstante());
			}
		});
		this.add(btnUpVel);
		
		JButton btnDecreaseVel = new JButton ("Disminuir velocidad");
		btnDecreaseVel.setBounds(280,92,150,20);
		btnDecreaseVel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				controller.desacelerar();
				System.out.println(Constantes.getVelocidadConstante());
			}
		});
		this.add(btnDecreaseVel);
		
		
		
		
		
	}
}
