package triangulo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Triangulo_gui extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	//variaveis
	private JFrame jftela = new JFrame();
	private JLabel lblado1 = new JLabel("LADO 1: ");
	private JLabel lblado2 = new JLabel("LADO 2: ");
	private JLabel lblado3 = new JLabel("LADO 3: ");
	private JTextField txtlado1 = new JTextField();
	private JTextField txtlado2 = new JTextField();
	private JTextField txtlado3 = new JTextField();
	private JButton btnverifica = new JButton("Verificar Tipo");

	private int lado1;
	private int lado2;
	private int lado3;
	private JLabel lbtipo = new JLabel();
	//construtor
	public Triangulo_gui() {
		this.jftela.setSize(600, 300);
		this.jftela.setVisible(true);
		this.jftela.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.jftela.getContentPane().setLayout(null);
		this.jftela.setResizable(false);
		this.jftela.setLocationRelativeTo(null);
		
		this.jftela.add(lblado1);
		this.lblado1.setVisible(true);
		this.lblado1.setBounds(50, 50, 60, 20);
		this.jftela.add(lblado2);
		this.lblado2.setVisible(true);
		this.lblado2.setBounds(50, 100, 60, 20);
		this.jftela.add(lblado3);
		this.lblado3.setVisible(true);
		this.lblado3.setBounds(50, 150, 60, 20);
		this.jftela.add(txtlado1);
		this.txtlado1.setVisible(true);
		this.txtlado1.setBounds(120, 50, 100, 20);
		this.jftela.add(txtlado2);
		this.txtlado2.setVisible(true);
		this.txtlado2.setBounds(120, 100, 100, 20);
		this.jftela.add(txtlado3);
		this.txtlado3.setVisible(true);
		this.txtlado3.setBounds(120, 150, 100, 20);
		this.btnverifica.setVisible(true);
		this.btnverifica.setBounds(50, 200, 170, 20);
		this.jftela.add(btnverifica);
		
		this.jftela.add(this.lbtipo);
		this.lbtipo.setVisible(false);
		this.lbtipo.setBounds(350, 150, 150, 20);
		
		//acao do bota verificar
		this.btnverifica.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent verificar) {
				try {
					lado1 = Integer.parseInt(txtlado1.getText());
					lado2 = Integer.parseInt(txtlado2.getText());
					lado3 = Integer.parseInt(txtlado3.getText());
					
					verifica();
				}catch(NumberFormatException ex) {
					lbtipo.setText("Digite Números inteiros!");
					lbtipo.setVisible(true);
				}
			}
		});
	}
	
	//metodo para verificar o tipo do triangulo
	public void verifica() {
		if(this.lado1 == this.lado2 && this.lado1 == this.lado3 && this.lado2 == this.lado3) {
			this.lbtipo.setText("Triângulo Equilátero");
		}else if(this.lado1 == this.lado2 || this.lado1 == this.lado3 || this.lado2 == this.lado3) {
			this.lbtipo.setText("Triângulo Isóceles");
		}else {
			this.lbtipo.setText("Triângulo Escaleno");
		}
		this.lbtipo.setVisible(true);
	}
}
