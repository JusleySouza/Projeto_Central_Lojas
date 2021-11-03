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

	
	public String nome;
	public String lote;
	public int quantidade;
	public double preco;
	public String tamanho;
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
	private JTextField textField_6;

	
	public ConsultaFuncionario() {
		setTitle("Mercadorias");
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
		btnNewButton_1.setBounds(396, 421, 109, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Funcionario a Consultar");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 216, 14);
		contentPane.add(lblNewLabel);
		
		nomeConsulta = new JTextField();
		nomeConsulta.setBounds(10, 36, 300, 20);
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
		
		JLabel lblNewLabel_1 = new JLabel("Novo A:");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 87, 84, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Novo B:");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 143, 84, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nova C:");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_3.setBounds(10, 203, 134, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Novo D:");
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_4.setBounds(10, 259, 84, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Novo E:");
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_5.setBounds(10, 315, 109, 14);
		contentPane.add(lblNewLabel_5);
		
		novoNome = new JTextField();
		novoNome.setBounds(10, 112, 300, 20);
		contentPane.add(novoNome);
		novoNome.setColumns(10);
		
		novoLote = new JTextField();
		novoLote.setBounds(10, 168, 300, 20);
		contentPane.add(novoLote);
		novoLote.setColumns(10);
		
		novaQuantidade = new JTextField();
		novaQuantidade.setBounds(10, 228, 300, 20);
		contentPane.add(novaQuantidade);
		novaQuantidade.setColumns(10);
		
		novoPreco = new JTextField();
		novoPreco.setBounds(10, 284, 300, 20);
		contentPane.add(novoPreco);
		novoPreco.setColumns(10);
		
		novoTamanho = new JTextField();
		novoTamanho.setBounds(10, 340, 300, 20);
		contentPane.add(novoTamanho);
		novoTamanho.setColumns(10);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				limpar();
			}
		});
		btnAlterar.setFont(new Font("Dialog", Font.BOLD, 13));
		btnAlterar.setBounds(10, 421, 109, 23);
		contentPane.add(btnAlterar);
		
		JButton btnNewButton = new JButton("Limpar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 13));
		btnNewButton.setBounds(267, 421, 109, 23);
		contentPane.add(btnNewButton);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfirmacaoExcluir confirmacao = new ConfirmacaoExcluir(mercadoria.getId(), mercadoria.getNome());
				confirmacao.setVisible(true);
				confirmacao.toFront();
				confirmacao.requestFocus();
				limpar();
			}
		});
		btnExcluir.setFont(new Font("Dialog", Font.BOLD, 13));
		btnExcluir.setBounds(137, 421, 109, 23);
		contentPane.add(btnExcluir);
		
		JLabel lblNewLabel_1_1 = new JLabel("Novo F:");
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(355, 11, 84, 14);
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(355, 36, 300, 20);
		contentPane.add(textField);
		
		JLabel lblNewLabel_2_1 = new JLabel("Novo G:");
		lblNewLabel_2_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(355, 67, 84, 14);
		contentPane.add(lblNewLabel_2_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(355, 92, 300, 20);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Nova H:");
		lblNewLabel_3_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_3_1.setBounds(355, 127, 134, 14);
		contentPane.add(lblNewLabel_3_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(355, 152, 300, 20);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_4_1 = new JLabel("Novo I:");
		lblNewLabel_4_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_4_1.setBounds(355, 183, 84, 14);
		contentPane.add(lblNewLabel_4_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(355, 208, 300, 20);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_5_1 = new JLabel("Novo J:");
		lblNewLabel_5_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_5_1.setBounds(355, 239, 109, 14);
		contentPane.add(lblNewLabel_5_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(355, 264, 300, 20);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Novo K:");
		lblNewLabel_5_1_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_5_1_1.setBounds(355, 297, 109, 14);
		contentPane.add(lblNewLabel_5_1_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(355, 322, 300, 20);
		contentPane.add(textField_5);
		
		JLabel lblNewLabel_5_1_2 = new JLabel("Novo L:");
		lblNewLabel_5_1_2.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_5_1_2.setBounds(355, 353, 109, 14);
		contentPane.add(lblNewLabel_5_1_2);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(355, 378, 300, 20);
		contentPane.add(textField_6);
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
