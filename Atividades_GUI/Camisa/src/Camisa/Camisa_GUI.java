package Camisa;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Camisa_GUI {
	
	private JFrame jftela = new JFrame();
	private JLabel lbmatricula = new JLabel("Matrícula");
	private JLabel lbtamanho = new JLabel("Tamanho da Camisa");
	private JLabel lbcor = new JLabel("Selecione a cor da camisa:");
	//private JLabel lbbranca = new JLabel();
	//private JLabel lbazul = new JLabel();
	//private JLabel lbvermelha = new JLabel();
	//private JLabel lbverde = new JLabel();
	//private JLabel lbamarela = new JLabel();
	private JTextField txtmatricula = new JTextField();
	
	private JPanel panel1 = new JPanel();
	private JComboBox<String> combo = new JComboBox<String>();
	
	public Camisa_GUI(){
		this.inicializar();
	}
	
	public void inicializar(){
		this.jftela.setLayout(null);
		this.jftela.setVisible(true);
		this.jftela.setSize(600, 480);
		this.jftela.setResizable(false);
		this.jftela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.jftela.setLocationRelativeTo(null);
		this.jftela.add(this.panel1);
		
		this.panel1.setSize(600, 480);
		this.panel1.setLayout(null);
		this.panel1.setBackground(Color.DARK_GRAY);
		this.panel1.add(this.lbmatricula); this.panel1.add(this.txtmatricula);
		this.panel1.add(combo); this.panel1.add(this.lbtamanho);
		this.panel1.add(this.lbcor);
		
		this.lbmatricula.setVisible(true);
		this.lbmatricula.setBounds(50,90,150,50);
		this.lbmatricula.setFont(new Font("Verdana", 1, 12));
		this.lbmatricula.setForeground(Color.WHITE);
		
		this.lbtamanho.setBounds(300,100,250,30);
		this.lbtamanho.setFont(new Font("Verdana", 1, 12));
		this.lbtamanho.setForeground(Color.WHITE);
	
		this.lbcor.setBounds(50,180,250,30);
		this.lbcor.setFont(new Font("Verdana", 1, 12));
		this.lbcor.setForeground(Color.WHITE);
		
		this.txtmatricula.setBounds(120,100,80,30);
		
		this.combo.setBounds(450,100,50,30);
		this.combo.addItem(null);
		this.combo.addItem("P");
		this.combo.addItem("M");
		this.combo.addItem("G");
	}
	
	public void paint(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(60,250,50,50);
	}
	
	public static void main(String[] args) {
		new Camisa_GUI();
	}

}
