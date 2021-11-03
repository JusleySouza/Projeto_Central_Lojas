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

public class ConsultaFuncionario extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
			
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
	
	private JTextField nomeConsulta;
	private JTextField novoNome;
	private JTextField novoLote;
	private JTextField novaQuantidade;
	private JTextField novoPreco;
	private JTextField novoTamanho;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	
	public ConsultaFuncionario() {
		setTitle("Funcion\u00E1rios");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 869, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Sair");
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(DISPOSE_ON_CLOSE);
			}
		});
		btnNewButton_1.setBounds(711, 421, 109, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Funcion\u00E1rio a Consultar:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 216, 14);
		contentPane.add(lblNewLabel);
		
		nomeConsulta = new JTextField();
		nomeConsulta.setBounds(10, 36, 625, 20);
		contentPane.add(nomeConsulta);
		nomeConsulta.setColumns(10);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
							
			}
		});
		btnProcurar.setFont(new Font("Dialog", Font.BOLD, 13));
		btnProcurar.setBounds(734, 34, 109, 23);
		contentPane.add(btnProcurar);
		
		JLabel lblNewLabel_1 = new JLabel("Novo Nome:");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 98, 84, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Novo Telefone:");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 143, 154, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Novo Telefone Secund\u00E1rio:");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_3.setBounds(284, 143, 236, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Novo CPF:");
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_4.setBounds(10, 205, 84, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Novo RG:");
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_5.setBounds(284, 205, 109, 14);
		contentPane.add(lblNewLabel_5);
		
		novoNome = new JTextField();
		novoNome.setBounds(104, 96, 531, 20);
		contentPane.add(novoNome);
		novoNome.setColumns(10);
		
		novoLote = new JTextField();
		novoLote.setBounds(10, 168, 190, 20);
		contentPane.add(novoLote);
		novoLote.setColumns(10);
		
		novaQuantidade = new JTextField();
		novaQuantidade.setBounds(284, 168, 190, 20);
		contentPane.add(novaQuantidade);
		novaQuantidade.setColumns(10);
		
		novoPreco = new JTextField();
		novoPreco.setBounds(10, 230, 190, 20);
		contentPane.add(novoPreco);
		novoPreco.setColumns(10);
		
		novoTamanho = new JTextField();
		novoTamanho.setBounds(284, 230, 190, 20);
		contentPane.add(novoTamanho);
		novoTamanho.setColumns(10);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				limpar();
			}
		});
		btnAlterar.setFont(new Font("Dialog", Font.BOLD, 13));
		btnAlterar.setBounds(77, 421, 109, 23);
		contentPane.add(btnAlterar);
		
		JButton btnNewButton = new JButton("Limpar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 13));
		btnNewButton.setBounds(504, 421, 109, 23);
		contentPane.add(btnNewButton);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ConfirmacaoExcluirFuncionario confirmacaofunc = new ConfirmacaoExcluirFuncionario();
				confirmacaofunc.setVisible(true);
				confirmacaofunc.toFront();
				confirmacaofunc.requestFocus();
				limpar();
			}
		});
		btnExcluir.setFont(new Font("Dialog", Font.BOLD, 13));
		btnExcluir.setBounds(284, 421, 109, 23);
		contentPane.add(btnExcluir);
		
		JLabel lblNewLabel_1_1 = new JLabel("Novo Email:");
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(543, 205, 84, 14);
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(543, 230, 300, 20);
		contentPane.add(textField);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nova Rua:");
		lblNewLabel_2_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(10, 274, 84, 14);
		contentPane.add(lblNewLabel_2_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 299, 259, 20);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Novo N\u00FAmero:");
		lblNewLabel_3_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_3_1.setBounds(284, 274, 134, 14);
		contentPane.add(lblNewLabel_3_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(284, 299, 109, 20);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_4_1 = new JLabel("Novo Bairro: ");
		lblNewLabel_4_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_4_1.setBounds(428, 274, 84, 14);
		contentPane.add(lblNewLabel_4_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(426, 299, 209, 20);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_5_1 = new JLabel("Nova Cidade:");
		lblNewLabel_5_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_5_1.setBounds(671, 274, 109, 14);
		contentPane.add(lblNewLabel_5_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(671, 299, 172, 20);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Novo Cargo:");
		lblNewLabel_5_1_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_5_1_1.setBounds(428, 342, 109, 14);
		contentPane.add(lblNewLabel_5_1_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(426, 367, 354, 20);
		contentPane.add(textField_5);
		
		JLabel lblNewLabel_6 = new JLabel("Novo sexo: ");
		lblNewLabel_6.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_6.setBounds(10, 342, 84, 14);
		contentPane.add(lblNewLabel_6);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Masculino");
		rdbtnNewRadioButton.setBounds(10, 363, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Feminino");
		rdbtnNewRadioButton_1.setBounds(117, 363, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);
	}
	
	public void limpar() {
		novoNome.setText("");
		novoLote.setText("");
		novaQuantidade.setText("");
		novoPreco.setText("");
		novoTamanho.setText("");
		nomeConsulta.setText("");
	}
}
