package central.lojas.telas;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import central.lojas.banco.Profissionais;
import central.lojas.dto.Funcionario;

public class ConsultaFuncionario extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel novoCpf;
			
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaFuncionario frame = new ConsultaFuncionario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private JTextField nomeConsultaFuncionario;
	private JTextField novoNomeFuncionario;
	private JTextField novoTelefoneFuncionario;
	private JTextField novoTelSecundarioFuncionario;
	private JTextField novoCpfFuncionario;
	private JTextField novoRgFuncionario;
	private JTextField novoEmailFuncionario;
	private JTextField novaRuaFuncionario;
	private JTextField novoNumeroFuncionario;
	private JTextField novoBairroFuncionario;
	private JTextField novaCidadeFuncionario;
	private JTextField novoCargo;
	
	Profissionais profissionais = new Profissionais();
	Funcionario funcionario = new Funcionario();

	
	public ConsultaFuncionario() {
		setTitle("Funcionarios");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 869, 494);
		novoCpf = new JPanel();
		novoCpf.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(novoCpf);
		novoCpf.setLayout(null);
		
		ButtonGroup escolha = new ButtonGroup();
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setFont(new Font("Dialog", Font.BOLD, 13));
		rdbtnMasculino.setBounds(10, 363, 109, 23);
		novoCpf.add(rdbtnMasculino);
		
		JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setFont(new Font("Dialog", Font.BOLD, 13));
		rdbtnFeminino.setBounds(117, 363, 109, 23);
		novoCpf.add(rdbtnFeminino);
		
		escolha.add(rdbtnMasculino);
		escolha.add(rdbtnFeminino);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Dialog", Font.BOLD, 13));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(DISPOSE_ON_CLOSE);
			}
		});
		btnSair.setBounds(711, 417, 109, 27);
		novoCpf.add(btnSair);
		
		JLabel lblNewLabel = new JLabel("Funcionario a Consultar:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 216, 14);
		novoCpf.add(lblNewLabel);
		
		nomeConsultaFuncionario = new JTextField();
		nomeConsultaFuncionario.setBounds(10, 36, 625, 20);
		novoCpf.add(nomeConsultaFuncionario);
		nomeConsultaFuncionario.setColumns(10);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nomeConsultaFuncionario.getText();
				funcionario = profissionais.consulta(nomeConsultaFuncionario.getText());
				limpar();
				
				novoNomeFuncionario.setText(funcionario.getNome());
				novoTelefoneFuncionario.setText(funcionario.getTelefone());
				novoTelSecundarioFuncionario.setText(funcionario.getTelefoneSecundario());
				novoCpfFuncionario.setText(funcionario.getCpf());
				novoRgFuncionario.setText(funcionario.getRg());	
				novoEmailFuncionario.setText(funcionario.getEmail());
				novaRuaFuncionario.setText(funcionario.getRua());
				novoNumeroFuncionario.setText(""+funcionario.getNumero());
				novoBairroFuncionario.setText(funcionario.getBairro());
				novoCargo.setText(funcionario.getCargo());
				novaCidadeFuncionario.setText(funcionario.getCidade());	
				
				if(funcionario.getSexo().equals("F")) {
					rdbtnFeminino.setSelected(true);;
				}
				else if(funcionario.getSexo().equals("M")) {
					rdbtnMasculino.setSelected(true);;
				}
				
							
			}
		});
		btnProcurar.setFont(new Font("Dialog", Font.BOLD, 13));
		btnProcurar.setBounds(734, 34, 109, 23);
		novoCpf.add(btnProcurar);
		
		JLabel lblNewLabel_1 = new JLabel("Novo Nome:");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 78, 84, 14);
		novoCpf.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Novo Telefone:");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 143, 154, 14);
		novoCpf.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Novo Telefone Secundario:");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_3.setBounds(284, 143, 236, 14);
		novoCpf.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Novo CPF:");
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_4.setBounds(10, 205, 84, 14);
		novoCpf.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Novo RG:");
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_5.setBounds(284, 205, 109, 14);
		novoCpf.add(lblNewLabel_5);
		
		novoNomeFuncionario = new JTextField();
		novoNomeFuncionario.setBounds(10, 96, 625, 20);
		novoCpf.add(novoNomeFuncionario);
		novoNomeFuncionario.setColumns(10);
		
		novoTelefoneFuncionario = new JTextField();
		novoTelefoneFuncionario.setBounds(10, 168, 190, 20);
		novoCpf.add(novoTelefoneFuncionario);
		novoTelefoneFuncionario.setColumns(10);
		
		novoTelSecundarioFuncionario = new JTextField();
		novoTelSecundarioFuncionario.setBounds(284, 168, 190, 20);
		novoCpf.add(novoTelSecundarioFuncionario);
		novoTelSecundarioFuncionario.setColumns(10);
		
		novoCpfFuncionario = new JTextField();
		novoCpfFuncionario.setBounds(10, 230, 190, 20);
		novoCpf.add(novoCpfFuncionario);
		novoCpfFuncionario.setColumns(10);
		
		novoRgFuncionario = new JTextField();
		novoRgFuncionario.setBounds(284, 230, 190, 20);
		novoCpf.add(novoRgFuncionario);
		novoRgFuncionario.setColumns(10);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				funcionario.setNome(novoNomeFuncionario.getText());
				funcionario.setTelefone(novoTelefoneFuncionario.getText());
				funcionario.setTelefoneSecundario(novoTelSecundarioFuncionario.getText());
				funcionario.setCpf(novoCpfFuncionario.getText());
				funcionario.setRg(novoRgFuncionario.getText());
				funcionario.setEmail(novoEmailFuncionario.getText());
				funcionario.setRua(novaRuaFuncionario.getText());
				funcionario.setNumero(Integer.valueOf(novoNumeroFuncionario.getText()));
				funcionario.setBairro(novoBairroFuncionario.getText());
				funcionario.setCidade(novaCidadeFuncionario.getText());
				funcionario.setCargo(novoCargo.getText());
				
				if(rdbtnFeminino.isSelected()) {
					funcionario.setSexo("F");
				}
				else if(rdbtnMasculino.isSelected()) {
					funcionario.setSexo("M");
				}
				else {
					funcionario.setSexo("");;
				}
				
				
				profissionais.atualizar(funcionario);	
				
				
				limpar();
			}
		});
		btnAlterar.setFont(new Font("Dialog", Font.BOLD, 13));
		btnAlterar.setBounds(77, 417, 109, 27);
		novoCpf.add(btnAlterar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setFont(new Font("Dialog", Font.BOLD, 13));
		btnLimpar.setBounds(504, 417, 109, 27);
		novoCpf.add(btnLimpar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ConfirmacaoExcluirFuncionario confirmacaofunc = new ConfirmacaoExcluirFuncionario(funcionario.getNome());
				confirmacaofunc.setVisible(true);
				confirmacaofunc.toFront();
				confirmacaofunc.requestFocus();
				limpar();
			}
		});
		btnExcluir.setFont(new Font("Dialog", Font.BOLD, 13));
		btnExcluir.setBounds(284, 417, 109, 27);
		novoCpf.add(btnExcluir);
		
		JLabel lblNewLabel_1_1 = new JLabel("Novo Email:");
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(543, 205, 84, 14);
		novoCpf.add(lblNewLabel_1_1);
		
		novoEmailFuncionario = new JTextField();
		novoEmailFuncionario.setColumns(10);
		novoEmailFuncionario.setBounds(543, 230, 300, 20);
		novoCpf.add(novoEmailFuncionario);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nova Rua:");
		lblNewLabel_2_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(10, 274, 84, 14);
		novoCpf.add(lblNewLabel_2_1);
		
		novaRuaFuncionario = new JTextField();
		novaRuaFuncionario.setColumns(10);
		novaRuaFuncionario.setBounds(10, 299, 259, 20);
		novoCpf.add(novaRuaFuncionario);
		
		JLabel lblNewLabel_3_1 = new JLabel("Novo Numero:");
		lblNewLabel_3_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_3_1.setBounds(284, 274, 134, 14);
		novoCpf.add(lblNewLabel_3_1);
		
		novoNumeroFuncionario = new JTextField();
		novoNumeroFuncionario.setColumns(10);
		novoNumeroFuncionario.setBounds(284, 299, 109, 20);
		novoCpf.add(novoNumeroFuncionario);
		
		JLabel lblNewLabel_4_1 = new JLabel("Novo Bairro: ");
		lblNewLabel_4_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_4_1.setBounds(428, 274, 84, 14);
		novoCpf.add(lblNewLabel_4_1);
		
		novoBairroFuncionario = new JTextField();
		novoBairroFuncionario.setColumns(10);
		novoBairroFuncionario.setBounds(426, 299, 209, 20);
		novoCpf.add(novoBairroFuncionario);
		
		JLabel lblNewLabel_5_1 = new JLabel("Nova Cidade:");
		lblNewLabel_5_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_5_1.setBounds(671, 274, 109, 14);
		novoCpf.add(lblNewLabel_5_1);
		
		novaCidadeFuncionario = new JTextField();
		novaCidadeFuncionario.setColumns(10);
		novaCidadeFuncionario.setBounds(671, 299, 172, 20);
		novoCpf.add(novaCidadeFuncionario);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Novo Cargo:");
		lblNewLabel_5_1_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_5_1_1.setBounds(428, 333, 109, 23);
		novoCpf.add(lblNewLabel_5_1_1);
		
		novoCargo = new JTextField();
		novoCargo.setColumns(10);
		novoCargo.setBounds(426, 367, 354, 20);
		novoCpf.add(novoCargo);
		
		JLabel lblNewLabel_6 = new JLabel("Novo sexo: ");
		lblNewLabel_6.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_6.setBounds(10, 342, 84, 14);
		novoCpf.add(lblNewLabel_6);
		
		
	}
	
	public void limpar() {
		nomeConsultaFuncionario.setText("");
		novoNomeFuncionario.setText("");
		novoTelefoneFuncionario.setText("");
		novoTelSecundarioFuncionario.setText("");
		novoCpfFuncionario.setText("");
		novoRgFuncionario.setText("");
		novoEmailFuncionario.setText("");
		novaRuaFuncionario.setText("");
		novoNumeroFuncionario.setText("");
		novoBairroFuncionario.setText("");
		novaCidadeFuncionario.setText("");
		novoCargo.setText("");
	}
}
