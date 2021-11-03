package central.lojas.telas;
import central.lojas.banco.Estoque;
import central.lojas.dto.Mercadoria;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;

public class ConsultaCliente extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
			
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaCliente frame = new ConsultaCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private JTextField nomeConsultaCliente;
	private JTextField novoNomeCliente;
	private JTextField novoTelefoneCliente;
	private JTextField novoTelSecundarioCliente;
	private JTextField novoCpfCliente;
	private JTextField novoRgCliente;
	private JTextField novoEmailCliente;
	private JTextField novaRuaCliente;
	private JTextField novoNumeroCliente;
	private JTextField novoBairroCliente;
	private JTextField novaCidadeCliente;

	
	public ConsultaCliente() {
		setTitle("Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 869, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Dialog", Font.BOLD, 13));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(DISPOSE_ON_CLOSE);
			}
		});
		btnSair.setBounds(698, 417, 109, 27);
		contentPane.add(btnSair);
		
		JLabel lblNewLabel = new JLabel("Cliente a Consultar");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 216, 14);
		contentPane.add(lblNewLabel);
		
		nomeConsultaCliente = new JTextField();
		nomeConsultaCliente.setBounds(10, 36, 626, 20);
		contentPane.add(nomeConsultaCliente);
		nomeConsultaCliente.setColumns(10);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
							
			}
		});
		btnProcurar.setFont(new Font("Dialog", Font.BOLD, 13));
		btnProcurar.setBounds(698, 32, 121, 27);
		contentPane.add(btnProcurar);
		
		JLabel lblNewLabel_1 = new JLabel("Novo Nome:");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 79, 84, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Novo Telefone:");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 143, 134, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Novo Telefone Secundario:");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_3.setBounds(290, 143, 205, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Novo CPF:");
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_4.setBounds(10, 212, 84, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Novo RG:");
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_5.setBounds(290, 212, 109, 14);
		contentPane.add(lblNewLabel_5);
		
		novoNomeCliente = new JTextField();
		novoNomeCliente.setBounds(10, 96, 625, 20);
		contentPane.add(novoNomeCliente);
		novoNomeCliente.setColumns(10);
		
		novoTelefoneCliente = new JTextField();
		novoTelefoneCliente.setBounds(10, 168, 229, 20);
		contentPane.add(novoTelefoneCliente);
		novoTelefoneCliente.setColumns(10);
		
		novoTelSecundarioCliente = new JTextField();
		novoTelSecundarioCliente.setBounds(290, 168, 229, 20);
		contentPane.add(novoTelSecundarioCliente);
		novoTelSecundarioCliente.setColumns(10);
		
		novoCpfCliente = new JTextField();
		novoCpfCliente.setBounds(10, 237, 229, 20);
		contentPane.add(novoCpfCliente);
		novoCpfCliente.setColumns(10);
		
		novoRgCliente = new JTextField();
		novoRgCliente.setBounds(290, 237, 229, 20);
		contentPane.add(novoRgCliente);
		novoRgCliente.setColumns(10);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				limpar();
			}
		});
		btnAlterar.setFont(new Font("Dialog", Font.BOLD, 13));
		btnAlterar.setBounds(53, 417, 109, 27);
		contentPane.add(btnAlterar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setFont(new Font("Dialog", Font.BOLD, 13));
		btnLimpar.setBounds(490, 417, 109, 27);
		contentPane.add(btnLimpar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfirmacaoExcluirCliente confirmacaoCli = new ConfirmacaoExcluirCliente();
				confirmacaoCli.setVisible(true);
				confirmacaoCli.toFront();
				confirmacaoCli.requestFocus();
				limpar();
			}
		});
		btnExcluir.setFont(new Font("Dialog", Font.BOLD, 13));
		btnExcluir.setBounds(264, 417, 109, 27);
		contentPane.add(btnExcluir);
		
		JLabel lblNewLabel_1_1 = new JLabel("Novo Email:");
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(543, 212, 84, 14);
		contentPane.add(lblNewLabel_1_1);
		
		novoEmailCliente = new JTextField();
		novoEmailCliente.setColumns(10);
		novoEmailCliente.setBounds(543, 237, 291, 20);
		contentPane.add(novoEmailCliente);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nova Rua:");
		lblNewLabel_2_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(10, 286, 84, 14);
		contentPane.add(lblNewLabel_2_1);
		
		novaRuaCliente = new JTextField();
		novaRuaCliente.setColumns(10);
		novaRuaCliente.setBounds(10, 311, 263, 20);
		contentPane.add(novaRuaCliente);
		
		JLabel lblNewLabel_3_1 = new JLabel("Novo Numero:");
		lblNewLabel_3_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_3_1.setBounds(290, 286, 134, 14);
		contentPane.add(lblNewLabel_3_1);
		
		novoNumeroCliente = new JTextField();
		novoNumeroCliente.setColumns(10);
		novoNumeroCliente.setBounds(290, 311, 109, 20);
		contentPane.add(novoNumeroCliente);
		
		JLabel lblNewLabel_4_1 = new JLabel("Novo Bairro:");
		lblNewLabel_4_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_4_1.setBounds(434, 286, 84, 14);
		contentPane.add(lblNewLabel_4_1);
		
		novoBairroCliente = new JTextField();
		novoBairroCliente.setColumns(10);
		novoBairroCliente.setBounds(434, 311, 176, 20);
		contentPane.add(novoBairroCliente);
		
		JLabel lblNewLabel_5_1 = new JLabel("Nova Cidade:");
		lblNewLabel_5_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_5_1.setBounds(641, 286, 109, 14);
		contentPane.add(lblNewLabel_5_1);
		
		novaCidadeCliente = new JTextField();
		novaCidadeCliente.setColumns(10);
		novaCidadeCliente.setBounds(641, 311, 193, 20);
		contentPane.add(novaCidadeCliente);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Novo Sexo:");
		lblNewLabel_5_1_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_5_1_1.setBounds(10, 354, 109, 14);
		contentPane.add(lblNewLabel_5_1_1);
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setFont(new Font("Dialog", Font.BOLD, 13));
		rdbtnMasculino.setBounds(10, 375, 109, 23);
		contentPane.add(rdbtnMasculino);
		
		JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setFont(new Font("Dialog", Font.BOLD, 13));
		rdbtnFeminino.setBounds(117, 375, 109, 23);
		contentPane.add(rdbtnFeminino);
	}
	
	public void limpar() {
		novoNomeCliente.setText("");
		novoTelefoneCliente.setText("");
		novoTelSecundarioCliente.setText("");
		novoCpfCliente.setText("");
		novoRgCliente.setText("");
		nomeConsultaCliente.setText("");
	}
}
