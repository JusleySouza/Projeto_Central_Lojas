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

import central.lojas.banco.Profissionais;

public class CadastroFuncionario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6242013657469154455L;
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
	private JTextField cargoProfissional;
	
	
	private String nomeProfissional, telefonePrincipal, telsecundario, cpfProfissional,
	RGProfissional, emailProfissional, bairroProfissional, cidadeProfissional, ruaProfissional,sexo, cargo;
	private int numero;

	
	public CadastroFuncionario() {
		setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		setTitle("Funcionarios");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 713, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome Completo"); 
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 61, 136, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CADASTRAMENTO DE FUNCIONARIOS");
		lblNewLabel_1.setFont(new Font("Serif", Font.BOLD, 19));
		lblNewLabel_1.setBounds(156, 11, 382, 23);
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
		
		ButtonGroup escolha = new ButtonGroup();
		
		JRadioButton sexoM = new JRadioButton("Masculino");
		sexoM.setFont(new Font("Serif", Font.BOLD, 14));
		sexoM.setBounds(7, 344, 109, 23);
		contentPane.add(sexoM);
		
		JRadioButton sexoF = new JRadioButton("Feminino");
		sexoF.setFont(new Font("Serif", Font.BOLD, 14));
		sexoF.setBounds(134, 344, 109, 23);
		contentPane.add(sexoF);
		
		escolha.add(sexoM);
		escolha.add(sexoF);
		
		JLabel lblNewLabel_9 = new JLabel("Sexo");
		lblNewLabel_9.setFont(new Font("Serif", Font.BOLD, 14));
		lblNewLabel_9.setBounds(10, 323, 46, 14);
		contentPane.add(lblNewLabel_9);
		
		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				nomeProfissional = nome.getText();
				telefonePrincipal = telefone.getText();
				telsecundario = telsecund.getText();
				cpfProfissional = cpf.getText();
				RGProfissional = RG.getText();
				emailProfissional = email.getText();
				ruaProfissional = rua.getText();
				numero = Integer.valueOf(numeroC.getText());
				bairroProfissional = bairro.getText();
				cidadeProfissional = cidade.getText();
				cargo = cargoProfissional.getText();
		
				if(sexoF.isSelected()) {
					sexo="F";
				}
				else if(sexoM.isSelected()) {
					sexo="M";
				}
				else {
					sexo="";
				}
				
				Profissionais profissionais = new Profissionais();
				int cadastro = profissionais.cadastrar(nomeProfissional, telefonePrincipal,
						telsecundario, cpfProfissional, RGProfissional, emailProfissional, 
						ruaProfissional, numero, bairroProfissional, cidadeProfissional, sexo, cargo);
			
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
						sexoF.setSelected(false);
						sexoM.setSelected(false);
						cargoProfissional.setText("");
						
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
		cadastrar.setBounds(31, 443, 155, 39);
		contentPane.add(cadastrar);
		
		JButton limpar = new JButton("Limpar");
		limpar.setFont(new Font("Serif", Font.BOLD, 14));
		limpar.setBounds(269, 443, 155, 39);
		contentPane.add(limpar);
		
		JButton sair = new JButton("Sair");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		sair.setFont(new Font("Serif", Font.BOLD, 14));
		sair.setBounds(505, 443, 155, 39);
		contentPane.add(sair);
		
		JLabel lblNewLabel_9_1 = new JLabel("Cargo:");
		lblNewLabel_9_1.setFont(new Font("Serif", Font.BOLD, 14));
		lblNewLabel_9_1.setBounds(347, 323, 46, 23);
		contentPane.add(lblNewLabel_9_1);
		
		cargoProfissional = new JTextField();
		cargoProfissional.setBounds(330, 347, 343, 24);
		contentPane.add(cargoProfissional);
		cargoProfissional.setColumns(10);
	}
}
