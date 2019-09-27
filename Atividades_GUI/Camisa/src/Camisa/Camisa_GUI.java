package Camisa;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

public class Camisa_GUI {
	
	private JFrame jftela = new JFrame();
	private JLabel lbmatricula = new JLabel("Matrícula");
	private JLabel lbtamanho = new JLabel("Tamanho da Camisa");
	private JLabel lbcor = new JLabel("Selecione a cor da camisa:");
	private JLabel lbcorSelecionada = new JLabel();
	private JLabel lbquantidade = new JLabel("Quantidade de camisas");
	private ImageIcon iconBranca = new ImageIcon(getClass().getResource("white.png"));
	private ImageIcon iconAzul = new ImageIcon(getClass().getResource("blue.png"));
	private ImageIcon iconAmarela = new ImageIcon(getClass().getResource("yellow.png"));
	private ImageIcon iconVerde = new ImageIcon(getClass().getResource("green.png"));
	private ImageIcon iconVermelha = new ImageIcon(getClass().getResource("red.png"));
	private JLabel lbbranca = new JLabel(iconBranca);
	private JLabel lbazul = new JLabel(iconAzul);
	private JLabel lbvermelha = new JLabel(iconVermelha);
	private JLabel lbverde = new JLabel(iconVerde);
	private JLabel lbamarela = new JLabel(iconAmarela);
	private JTextField txtmatricula = new JTextField();
	private JTextField txtquantidade = new JTextField();
	private JButton btnsolicitar = new JButton("Solicitar");
	
	private String corCamisa;
	private int matricula, quantidade;
	private String tamanho;
	
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
		this.panel1.setBackground(Color.GRAY);
		this.panel1.add(this.lbmatricula); this.panel1.add(this.txtmatricula);
		this.panel1.add(combo); this.panel1.add(this.lbtamanho);
		this.panel1.add(this.lbcor); this.panel1.add(lbbranca);
		this.panel1.add(lbazul); this.panel1.add(lbvermelha);
		this.panel1.add(lbverde); this.panel1.add(lbamarela);
		this.panel1.add(this.lbquantidade); this.panel1.add(this.txtquantidade);
		this.panel1.add(this.btnsolicitar);
		
		this.lbbranca.setBounds(465,230,60,30);
		this.lbazul.setBounds(365,230,60,30);
		this.lbverde.setBounds(265,230,60,30);
		this.lbamarela.setBounds(165,230,60,30);
		this.lbvermelha.setBounds(65,230,60,30);
		
		this.clique(lbbranca); this.clique(lbazul);
		this.clique(lbvermelha); this.clique(lbverde);
		this.clique(lbamarela);
		
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
		
		this.lbquantidade.setBounds(50,290,200,50);
		this.lbquantidade.setForeground(Color.WHITE);
		this.lbquantidade.setFont(new Font("Verdana", 1, 12));
		
		this.txtmatricula.setBounds(120,100,80,30);
		//this.txtmatricula.MaxLength = 10;
		this.txtquantidade.setBounds(230,300,40,30);
		
		this.btnsolicitar.setBounds(200,370,200,40);
		this.btnsolicitar.setFont(new Font("Verdana", 1, 18));
		
		this.combo.setBounds(450,100,50,30);
		this.combo.addItem(null);
		this.combo.addItem("P");
		this.combo.addItem("M");
		this.combo.addItem("G");
		
		this.btnsolicitar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent solicitar){
				//System.out.println(matricula +":"+combo.getSelectedItem()+":"+corCamisa);
				try {
					matricula = Integer.parseInt(txtmatricula.getText());
					quantidade = Integer.parseInt(txtquantidade.getText());
					
					if(corCamisa == null || combo.getSelectedItem() == null) {
						JOptionPane.showMessageDialog(null, "Prencha todos os campos!");
					}else{
						if(combo.getSelectedItem() != null) {
							tamanho = (String) combo.getSelectedItem();
						}
					}
				}catch(NumberFormatException ex) {
					if(txtmatricula.getText() == null){
						txtmatricula.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));
					}
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
				}
				
				//JOptionPane.showMessageDialog(null, "Solicitação feita com sucesso!");
				System.out.println(matricula +":"+tamanho+":"+corCamisa);
			}
		});
		
	}
	
	//manipulacao das labels das cores
	public void clique(JLabel label){
		label.addMouseListener(new MouseAdapter(){
			
			//quando passar o mouse sobre a label
			@Override
            public void mouseEntered(MouseEvent e) {
                JLabel label = (JLabel) e.getSource();
                if(label != lbcorSelecionada){
                	label.setBorder(new MatteBorder(1, 1, 3, 3, Color.BLACK));
                }
            }
			
			//quando o mouse sair de cima da label
			@Override
            public void mouseExited(MouseEvent e) {
                JLabel label = (JLabel) e.getSource();
                if(label != lbcorSelecionada){
                	label.setBorder(null);
                }
            }
			
			//quando clicar numa label
			@Override
			public void mouseClicked(MouseEvent e){
				if(label.equals(lbbranca)){
					lbbranca.setBorder(new MatteBorder(3, 3, 3, 3, Color.GREEN));
					corCamisa = "0000";
					lbcorSelecionada = lbbranca;
					controleLabel();
				}else if(label.equals(lbazul)){
					lbazul.setBorder(new MatteBorder(3, 3, 3, 3, Color.GREEN));
					corCamisa = "1100";
					lbcorSelecionada = lbazul;
					controleLabel();
				}else if(label.equals(lbvermelha)){
					lbvermelha.setBorder(new MatteBorder(3, 3, 3, 3, Color.GREEN));
					corCamisa = "0110";
					lbcorSelecionada = lbvermelha;
					controleLabel();
				}else if(label.equals(lbverde)){
					lbverde.setBorder(new MatteBorder(3, 3, 3, 3, Color.GREEN));
					corCamisa = "1010";
					lbcorSelecionada = lbverde;
					controleLabel();
				}else if(label.equals(lbamarela)){
					lbamarela.setBorder(new MatteBorder(3, 3, 3, 3, Color.GREEN));
					corCamisa = "0010";
					lbcorSelecionada = lbamarela;
					controleLabel();
				}
			}
		});
	}
	
	//deixa as labels nao selecionadas sem bordas
	public void controleLabel(){
		if(lbamarela != lbcorSelecionada){
			lbamarela.setBorder(null);
		}
		if(lbazul != lbcorSelecionada){
			lbazul.setBorder(null);
		}
		if(lbbranca != lbcorSelecionada){
			lbbranca.setBorder(null);
		}
		if(lbverde != lbcorSelecionada){
			lbverde.setBorder(null);
		}
		if(lbvermelha != lbcorSelecionada){
			lbvermelha.setBorder(null);
		}
	}
	
	public static void main(String[] args) {
		new Camisa_GUI();
	}

}
