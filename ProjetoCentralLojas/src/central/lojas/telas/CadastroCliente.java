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

import central.lojas.banco.ClientesBanco;
import central.lojas.dto.Usuario;

import java.awt.Color;

public class CadastroCliente extends JFrame {

	private JPanel contentPane;
	private JTextField nome;
	private JTextField rua;
	private JTextField numeroC;
	private JTextField bairro;
	private JTextField cidade;
	private JTextField telefone;
	private JTextField telsecund;
	private JTextField cpf;
	private JTextField RG;
	private JTextField email;
	
	private String nomeCliente, telefonePrincipal, telsecundario, cpfCliente,
	RGCliente, emailCliente, bairroCliente, cidadeCliente, ruaCliente,sexo;
	private int numero;
	
	public CadastroCliente(Usuario usuarioObj) {
		setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		setTitle("Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 717, 556);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome Completo");
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 61, 136, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CADASTRAMENTO DE CLIENTES");
		lblNewLabel_1.setFont(new Font("Serif", Font.BOLD, 19));
		lblNewLabel_1.setBounds(176, 11, 347, 23);
		contentPane.add(lblNewLabel_1);
		
		nome = new JTextField();
		nome.setBounds(134, 60, 539, 23);
		contentPane.add(nome);
		nome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Endere\u00E7o");
		lblNewLabel_2.setFont(new Font("Serif", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 269, 81, 14);
		contentPane.add(lblNewLabel_2);
		
		rua = new JTextField();
		rua.setBounds(70, 266, 231, 23);
		contentPane.add(rua);
		rua.setColumns(10);
		
		numeroC = new JTextField();
		numeroC.setBounds(311, 266, 103, 23);
		contentPane.add(numeroC);
		numeroC.setColumns(10);
		
		bairro = new JTextField();
		bairro.setBounds(424, 266, 115, 23);
		contentPane.add(bairro);
		bairro.setColumns(10);
		
		cidade = new JTextField();
		cidade.setBounds(561, 266, 113, 23);
		contentPane.add(cidade);
		cidade.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Rua ");
		lblNewLabel_3.setFont(new Font("Serif", Font.BOLD, 14));
		lblNewLabel_3.setBounds(70, 244, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Numero");
		lblNewLabel_3_1.setFont(new Font("Serif", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(310, 241, 54, 14);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Bairro");
		lblNewLabel_3_1_1.setFont(new Font("Serif", Font.BOLD, 14));
		lblNewLabel_3_1_1.setBounds(424, 241, 46, 14);
		contentPane.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Cidade");
		lblNewLabel_3_1_2.setFont(new Font("Serif", Font.BOLD, 14));
		lblNewLabel_3_1_2.setBounds(561, 241, 46, 14);
		contentPane.add(lblNewLabel_3_1_2);
		
		JLabel lblNewLabel_4 = new JLabel("Telefone");
		lblNewLabel_4.setFont(new Font("Serif", Font.BOLD, 13));
		lblNewLabel_4.setBounds(10, 117, 62, 14);
		contentPane.add(lblNewLabel_4);
		
		telefone = new JTextField();
		telefone.setBounds(82, 114, 182, 23);
		contentPane.add(telefone);
		telefone.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Telefone secundario");
		lblNewLabel_5.setFont(new Font("Serif", Font.BOLD, 14));
		lblNewLabel_5.setBounds(284, 117, 140, 14);
		contentPane.add(lblNewLabel_5);
		
		telsecund = new JTextField();
		telsecund.setBounds(424, 114, 183, 23);
		contentPane.add(telsecund);
		telsecund.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("CPF");
		lblNewLabel_6.setFont(new Font("Serif", Font.BOLD, 14));
		lblNewLabel_6.setBounds(10, 180, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		cpf = new JTextField();
		cpf.setBounds(42, 178, 174, 23);
		contentPane.add(cpf);
		cpf.setColumns(10);
		
		JLabel rg = new JLabel("RG");
		rg.setFont(new Font("Serif", Font.BOLD, 14));
		rg.setBounds(239, 180, 46, 14);
		contentPane.add(rg);
		
		RG = new JTextField();
		RG.setBounds(266, 177, 127, 24);
		contentPane.add(RG);
		RG.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Email");
		lblNewLabel_8.setFont(new Font("Serif", Font.BOLD, 14));
		lblNewLabel_8.setBounds(413, 180, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		email = new JTextField();
		email.setBounds(460, 177, 214, 24);
		contentPane.add(email);
		email.setColumns(10);
		
		ButtonGroup grupo1 = new ButtonGroup();
		 
		JRadioButton sexoM = new JRadioButton("Masculino");
		sexoM.setFont(new Font("Serif", Font.BOLD, 14));
		sexoM.setBounds(7, 344, 109, 23);
		contentPane.add(sexoM);
		
		JRadioButton sexoF = new JRadioButton("Feminino");
		sexoF.setFont(new Font("Serif", Font.BOLD, 14));
		sexoF.setBounds(134, 344, 109, 23);
		contentPane.add(sexoF);
		
		grupo1.add(sexoM);
		grupo1.add(sexoF);
		
		JLabel lblNewLabel_9 = new JLabel("Sexo");
		lblNewLabel_9.setFont(new Font("Serif", Font.BOLD, 14));
		lblNewLabel_9.setBounds(10, 323, 46, 14);
		contentPane.add(lblNewLabel_9);
		
		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nomeCliente = nome.getText();
				telefonePrincipal = telefone.getText();
				telsecundario = telsecund.getText();
				cpfCliente = cpf.getText();
				RGCliente = RG.getText();
				emailCliente = email.getText();
				ruaCliente = rua.getText();
				numero = Integer.valueOf(numeroC.getText());
				bairroCliente = bairro.getText();
				cidadeCliente = cidade.getText();
				
				if(sexoF.isSelected()) {
					sexo="F";
				}
				else if(sexoM.isSelected()) {
					sexo="M";
				}
				else {
					sexo="";
				}
				
				ClientesBanco cliente = new ClientesBanco();
				int cadastro = cliente.cadastrar(nomeCliente, telefonePrincipal,
						telsecundario, cpfCliente, RGCliente, emailCliente, 
						ruaCliente, numero, bairroCliente, cidadeCliente, sexo);
			
				if(cadastro!=0)
					{
						JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso!!!","Sucesso",JOptionPane.INFORMATION_MESSAGE);
						nome.setText("");
						telefone.setText("");
						telsecund.setText("");
						cpf.setText("");
						RG.setText("");
						email.setText("");
						rua.setText("");
						numeroC.setText("");
						bairro.setText("");
						cidade.setText("");
						grupo1.clearSelection();
						
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Erro para realizar o cadastro!!!","Erro",JOptionPane.ERROR_MESSAGE);
					}
				}
				
				
			{
				
			}
		});
		cadastrar.setFont(new Font("Serif", Font.BOLD, 14));
		cadastrar.setBounds(22, 451, 155, 35);
		contentPane.add(cadastrar);
		
		JButton limpar = new JButton("Limpar");
		limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nome.setText("");
				telefone.setText("");
				rua.setText("");
				telsecund.setText("");
				cidade.setText("");
				RG.setText("");
				cpf.setText("");
				email.setText("");
				bairro.setText("");
				numeroC.setText("");
				grupo1.clearSelection();
			
			}
		});
		limpar.setFont(new Font("Serif", Font.BOLD, 14));
		limpar.setBounds(269, 451, 155, 35);
		contentPane.add(limpar);
		
		JButton sair = new JButton("Sair");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		sair.setFont(new Font("Serif", Font.BOLD, 14));
		sair.setBounds(518, 451, 155, 35);
		contentPane.add(sair);
	}
}
