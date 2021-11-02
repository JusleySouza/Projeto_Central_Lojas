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

import BancoDeDados.Profissionais;

public class ConsultaFuncionario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6242013657469154455L;
	private JPanel contentPane;
	
	
	private String nomeProfissional, telefonePrincipal, telsecundario, cpfProfissional,
	RGProfissional, emailProfissional, bairroProfissional, cidadeProfissional, ruaProfissional,sexo, cargo;
	private int numero;

	
	public ConsultaFuncionario() {
		setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		setTitle("Funcionarios");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 729, 584);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("CONSULTA DE FUNCIONARIOS");
		lblNewLabel_1.setFont(new Font("Serif", Font.BOLD, 19));
		lblNewLabel_1.setBounds(226, 11, 297, 23);
		contentPane.add(lblNewLabel_1);
		
		ButtonGroup escolha = new ButtonGroup();
		
		JButton sair = new JButton("Sair");
		sair.setFont(new Font("Serif", Font.BOLD, 14));
		sair.setBounds(285, 486, 155, 48);
		contentPane.add(sair);
	}
}
