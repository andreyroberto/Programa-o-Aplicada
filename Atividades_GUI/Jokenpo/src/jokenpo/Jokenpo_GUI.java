package jokenpo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Jokenpo_GUI extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JFrame jftela = new JFrame("JOKENPÔ");
	private JFrame jftelaJogo = new JFrame("JOKENPÔ");
	private ImageIcon iconTela = new ImageIcon(getClass().getResource("tela-inicial.png"));
	private JLabel lbtelainicial = new JLabel(iconTela);
	private JButton btniniciar = new JButton("Iniciar");
	private JButton btnsair = new JButton("Sair");

	//construtor
	public Jokenpo_GUI(){
		this.jftela.setLayout(null);
		this.jftela.setVisible(true);
		this.jftela.setSize(600, 480);
		this.jftela.setResizable(false);
		this.jftela.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.jftela.setLocationRelativeTo(null);
		
		this.jftela.add(this.btniniciar); this.jftela.add(this.btnsair);
		this.btniniciar.setFont(new Font("Jokerman", 1, 18));
		this.btniniciar.setVisible(true);
		this.btniniciar.setBounds(100,320,100,50);
		this.btnsair.setVisible(true);
		this.btnsair.setFont(new Font("Jokerman", 1, 18));
		this.btnsair.setBounds(400,320,100,50);
		
		this.jftela.add(this.lbtelainicial);
		this.lbtelainicial.setVisible(true);
		this.lbtelainicial.setSize(600, 480);
		
		//acao do botao inicar
		this.btniniciar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent iniciar){
				telaJogo();
			}
		});
		//acao do botao sair
		this.btnsair.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent sair){
				System.exit(0);
			}
		});
	}
	
	public void telaJogo(){
		this.jftela.setVisible(false);
		this.jftelaJogo.setLayout(null);
		this.jftelaJogo.setVisible(true);
		this.jftelaJogo.setSize(600, 480);
		this.jftelaJogo.setResizable(false);
		this.jftelaJogo.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.jftelaJogo.setLocationRelativeTo(null);
		this.jftelaJogo.getContentPane().setBackground(Color.WHITE);
	}
}
