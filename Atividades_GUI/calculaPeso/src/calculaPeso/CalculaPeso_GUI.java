package calculaPeso;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CalculaPeso_GUI extends JFrame{

	private static final long serialVersionUID = 1L;

	//variaveis
	private JFrame jftela = new JFrame("Calcular Peso em Outro Planeta");
	private JLabel lbtexto = new JLabel("Peso na Terra (kg):");
	private JLabel lbtexto2 = new JLabel("Selecione o Planeta:");
	private JTextField txcampo = new JTextField();
	private JButton btncalcula = new JButton("Calcular Peso");
	private JRadioButton rbmercurio, rbmarte, rbsaturno, rbvenus, rbjupiter, rburano;
	private ButtonGroup btgrupo = new ButtonGroup();
	private double peso;
	private double pesoPlaneta;
	
	public CalculaPeso_GUI() {
		this.jftela.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.jftela.setVisible(true);
		this.jftela.setSize(400, 300);
		this.jftela.getContentPane().setLayout(null);
		this.jftela.setResizable(false);
		this.jftela.setLocationRelativeTo(null);
		this.jftela.add(this.lbtexto);
		this.lbtexto.setVisible(true);
		this.lbtexto.setBounds(50, 10, 110, 50);
		this.jftela.add(lbtexto2);
		this.lbtexto2.setVisible(true);
		this.lbtexto2.setBounds(50, 90, 120, 50);
		this.jftela.add(this.txcampo);
		this.txcampo.setVisible(true);
		this.txcampo.setBounds(50, 60, 110, 30);
		this.jftela.add(this.btncalcula);
		this.btncalcula.setVisible(true);
		this.btncalcula.setBounds(200, 60, 130, 30);
		this.rbmercurio = new JRadioButton("Mércurio", false);
		this.rbmarte = new JRadioButton("Marte", false);
		this.rbsaturno = new JRadioButton("Saturno", false);
		this.rbvenus = new JRadioButton("Vênus", false);
		this.rbjupiter = new JRadioButton("Júpiter", false);
		this.rburano = new JRadioButton("Urano", false);
		this.jftela.add(this.rbmercurio); this.jftela.add(rbmarte); this.jftela.add(this.rbsaturno);
		this.jftela.add(this.rbvenus); this.jftela.add(this.rbjupiter); this.jftela.add(this.rburano);
		this.rbmercurio.setVisible(true); this.rbmarte.setVisible(true); this.rbsaturno.setVisible(true);
		this.rbvenus.setVisible(true); this.rbjupiter.setVisible(true); this.rburano.setVisible(true);
		this.rbmercurio.setBounds(50, 130, 80, 30);
		this.rbmarte.setBounds(160, 130, 80, 30);
		this.rbsaturno.setBounds(250, 130, 80, 30);
		this.rbvenus.setBounds(50, 160, 80, 30);
		this.rbjupiter.setBounds(160, 160, 80, 30);
		this.rburano.setBounds(250, 160, 80, 30);
		this.btgrupo.add(this.rbjupiter); this.btgrupo.add(this.rbmarte); this.btgrupo.add(this.rbmercurio);
		this.btgrupo.add(this.rbsaturno); this.btgrupo.add(this.rburano); this.btgrupo.add(this.rbvenus);
		
		//acao do bota calcular peso
		this.btncalcula.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent calcular) {
				try {
					peso = Double.parseDouble(txcampo.getText());
					
					//DecimalFormat df = new DecimalFormat("0.##");
					
					if(rbmercurio.isSelected()) {
						pesoPlaneta = peso * 0.37;
						JOptionPane.showMessageDialog(null, "O seu peso em Mércurio é: " + pesoPlaneta + " kg");
					}else if(rbmarte.isSelected()) {
						pesoPlaneta = peso * 0.38;
						JOptionPane.showMessageDialog(null, "O seu peso em Marte é: " + pesoPlaneta + " kg");
					}else if(rbsaturno.isSelected()) {
						pesoPlaneta = peso * 1.15;
						JOptionPane.showMessageDialog(null, "O seu peso em Saturno é: " + pesoPlaneta + " kg");
					}else if(rbvenus.isSelected()) {
						pesoPlaneta = peso * 0.88;
						JOptionPane.showMessageDialog(null, "O seu peso em Vênus é: " + pesoPlaneta + " kg");
					}else if(rbjupiter.isSelected()) {
						pesoPlaneta = peso * 2.64;
						JOptionPane.showMessageDialog(null, "O seu peso em Júpiter é: " + pesoPlaneta + " kg");
					}else if(rburano.isSelected()) {
						pesoPlaneta = peso * 1.17;
						JOptionPane.showMessageDialog(null, "O seu peso em Urano é: " + pesoPlaneta + " kg");
					}else {
						JOptionPane.showMessageDialog(null, "<html><body><p width='120px' align='center'>Escolha um Planeta!</p></body></html>");
					}
				}catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "<html><body><p width='130px' align='center'>Informe um valor válido!</p></body></html>");
				}
			}
		});
	}
}
