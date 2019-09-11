package jokenpo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Jokenpo_GUI extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JFrame jftela = new JFrame("JOKENPÔ");
	private ImageIcon iconTela = new ImageIcon(getClass().getResource("tela-inicial.png"));
	private ImageIcon iconPedraE = new ImageIcon(getClass().getResource("pedraE.png"));
	private ImageIcon iconPedraD = new ImageIcon(getClass().getResource("pedraD.png"));
	private ImageIcon iconPapelE = new ImageIcon(getClass().getResource("papelE.png"));
	private ImageIcon iconPapelD = new ImageIcon(getClass().getResource("papelD.png"));
	private ImageIcon iconTesouraE = new ImageIcon(getClass().getResource("tesouraE.png"));
	private ImageIcon iconTesouraD = new ImageIcon(getClass().getResource("tesouraD.png"));
	private JLabel lbjogadorE = new JLabel(iconPedraE);
	private JLabel lbjogadorD = new JLabel(iconPedraD);
	private JLabel lbtelainicial = new JLabel(iconTela);
	private JButton btniniciar = new JButton("Iniciar");
	private JButton btnsair = new JButton("Sair");
	private JButton btnescolha = new JButton("Escolher");
	private JRadioButton rbpedra, rbpapel, rbtesoura;
	private ButtonGroup btgrupo = new ButtonGroup();
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	
	private int jogador, computador;

	//construtor
	public Jokenpo_GUI(){
		this.jftela.setLayout(null);
		this.jftela.setVisible(true);
		this.jftela.setSize(600, 480);
		this.jftela.setResizable(false);
		this.jftela.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.jftela.setLocationRelativeTo(null);
		this.jftela.add(this.panel1);
		
		this.panel1.setSize(600, 480);
		this.panel1.setLayout(null);
		this.panel1.add(this.lbtelainicial);
		this.lbtelainicial.setVisible(true);
		this.lbtelainicial.setSize(600, 480);
		
		this.panel1.add(this.btniniciar); this.panel1.add(this.btnsair);
		this.btniniciar.setFont(new Font("Jokerman", 1, 18));
		this.btniniciar.setVisible(true);
		this.btniniciar.setBounds(100,320,150,50);
		this.btnsair.setVisible(true);
		this.btnsair.setFont(new Font("Jokerman", 1, 18));
		this.btnsair.setBounds(330,320,150,50);
		
		this.panel2.setLayout(null);
		this.panel2.setBackground(Color.CYAN);
		this.panel2.add(this.btnescolha);
		this.btnescolha.setFont(new Font("Jokerman", 1, 18));
		this.btnescolha.setBounds(200, 100, 200, 40);
		this.panel2.add(this.lbjogadorE); this.panel2.add(this.lbjogadorD);
		this.lbjogadorE.setBounds(0,220,205,210);
		this.lbjogadorD.setBounds(380,220,205,210);
		this.rbpapel = new JRadioButton("Papel", false);
		this.rbpedra = new JRadioButton("Pedra", false);
		this.rbtesoura = new JRadioButton("Tesoura", false);
		this.panel2.add(this.rbpapel); this.panel2.add(this.rbpedra); this.panel2.add(this.rbtesoura);
		this.rbpapel.setBounds(160, 50, 100, 40); this.rbpedra.setBounds(260, 50, 100, 40);
		this.rbtesoura.setBounds(360, 50, 80, 40);
		this.rbpapel.setBackground(Color.WHITE); this.rbpedra.setBackground(Color.WHITE);
		this.rbtesoura.setBackground(Color.WHITE);
		this.btgrupo.add(this.rbpapel);this.btgrupo.add(this.rbpedra);this.btgrupo.add(this.rbtesoura);
		
		//acao do botao inicar
		this.btniniciar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent iniciar){
				jftela.remove(panel1);
				jftela.add(panel2);
				
				panel2.setSize(600, 480);
				panel2.setLayout(null);
			}
		});
		//acao do botao sair
		this.btnsair.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent sair){
				System.exit(0);
			}
		});
		//acao do botao escolha
		this.btnescolha.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent escolher) {
				//code
				if(rbpapel.isSelected()) {
					lbjogadorE.setIcon(iconPapelE);
					lbjogadorE.setBounds(0,200,290,210);
					jogador = 1;
					jogo(sorteio());
				}else if(rbpedra.isSelected()) {
					lbjogadorE.setIcon(iconPedraE);
					lbjogadorE.setBounds(0,220,205,210);
					jogador = 2;
					jogo(sorteio());
				}else if(rbtesoura.isSelected()) {
					lbjogadorE.setIcon(iconTesouraE);
					lbjogadorE.setBounds(0,220,270,210);
					jogador = 3;
					jogo(sorteio());
				}
			}
		});
	}
	
	public int sorteio() {
		double num = Math.random();
		num = (int)(1 + num * (4 - 1));
		int retorno = (int)num;
		
		return retorno;
	}
	
	public void jogo(int num) {
		if(num == 1) {
			this.lbjogadorD.setIcon(this.iconPapelD);
			this.lbjogadorD.setBounds(295,200,290,210);
			computador = 1;
		}else if(num == 2) {
			this.lbjogadorD.setIcon(this.iconPedraD);
			this.lbjogadorD.setBounds(380,220,205,210);
			computador = 2;
		}else if(num == 3) {
			this.lbjogadorD.setIcon(this.iconTesouraD);
			this.lbjogadorD.setBounds(315,220,270,210);
			computador = 3;
		}
		
		if(jogador == 1 && computador == 2) {
			//papel x pedra
			JOptionPane.showMessageDialog(null, "<html><body><p width='120px' align='center'>VOCÊ GANHOU!</p></body></html>");
		}else if(jogador == 2 && computador == 3) {
			//pedra x tesoura
			JOptionPane.showMessageDialog(null, "<html><body><p width='120px' align='center'>VOCÊ GANHOU!</p></body></html>");
		}else if(jogador == 3 && computador == 1) {
			//tesoura x papel
			JOptionPane.showMessageDialog(null, "<html><body><p width='120px' align='center'>VOCÊ GANHOU!</p></body></html>");
		}else if(jogador == 1 && computador == 1) {
			//papel x papel
			JOptionPane.showMessageDialog(null, "<html><body><p width='120px' align='center'>EMPATE!</p></body></html>");
		}else if(jogador == 2 && computador == 2) {
			//pedra x pedra
			JOptionPane.showMessageDialog(null, "<html><body><p width='120px' align='center'>EMPATE!</p></body></html>");
		}else if(jogador == 3 && computador == 3) {
			//tesoura x tesoura
			JOptionPane.showMessageDialog(null, "<html><body><p width='120px' align='center'>EMPATE!</p></body></html>");
		}else if(jogador == 1 && computador == 3) {
			//papel x tesoura
			JOptionPane.showMessageDialog(null, "<html><body><p width='120px' align='center'>VOCÊ PERDEU!</p></body></html>");
		}else if(jogador == 2 && computador == 1) {
			//pedra x papel
			JOptionPane.showMessageDialog(null, "<html><body><p width='120px' align='center'>VOCÊ PERDEU!</p></body></html>");
		}else{
			//tesoura x pedra
			JOptionPane.showMessageDialog(null, "<html><body><p width='120px' align='center'>VOCÊ PERDEU!</p></body></html>");
		}
	}
}