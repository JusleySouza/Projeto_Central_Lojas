package central.lojas.telas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BancoDeDados.Clientes;

public class ConsultaCliente extends JFrame {

	private JPanel contentPane;
	
	private String nomeCliente, telefonePrincipal, telsecundario, cpfCliente,
	RGCliente, emailCliente, bairroCliente, cidadeCliente, ruaCliente,sexo;
	private int numero;
	
	public ConsultaCliente() {
		
		
		
		setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		setTitle("Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 729, 584);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("CONSULTA DE CLIENTES");
		lblNewLabel_1.setFont(new Font("Serif", Font.BOLD, 19));
		lblNewLabel_1.setBounds(234, 11, 245, 23);
		contentPane.add(lblNewLabel_1);
		
		ButtonGroup grupo1 = new ButtonGroup();
		
		JButton sair = new JButton("Sair");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(DISPOSE_ON_CLOSE);
			}
		});
		sair.setFont(new Font("Serif", Font.BOLD, 14));
		sair.setBounds(277, 486, 155, 48);
		contentPane.add(sair);
	}
}
