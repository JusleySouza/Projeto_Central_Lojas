package central.lojas.telas;

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

import central.lojas.banco.Estoque;

public class mercadoria extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_nome;
	private JTextField textField_lote;
	private JTextField textField_quantidade;
	private JTextField textField_preco;
	private JTextField textField_tamanho;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mercadoria frame = new mercadoria();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public String nome;
	public String lote;
	public int quantidade;
	public double preco;
	public String tamanho;
	
	public mercadoria() {
		
		
		
		setTitle("Adicionar Item");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 436, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(298, 79, 101, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(22, 36, 59, 14);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Century Schoolbook", Font.BOLD, 13));
		
		JLabel lblNewLabel_1 = new JLabel("Lote");
		lblNewLabel_1.setBounds(22, 82, 46, 14);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Century Schoolbook", Font.BOLD, 13));
		
		textField_nome = new JTextField();
		textField_nome.setBounds(90, 34, 169, 20);
		contentPane.add(textField_nome);
		textField_nome.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Quantidade Disponivel");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_3.setBounds(22, 128, 154, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Pre\u00E7o");
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_4.setBounds(22, 169, 59, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Tamanho");
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_5.setBounds(22, 211, 70, 14);
		contentPane.add(lblNewLabel_5);
		
		textField_lote = new JTextField();
		textField_lote.setColumns(10);
		textField_lote.setBounds(90, 80, 169, 20);
		contentPane.add(textField_lote);
		
		textField_quantidade = new JTextField();
		textField_quantidade.setColumns(10);
		textField_quantidade.setBounds(186, 126, 73, 20);
		contentPane.add(textField_quantidade);
		
		textField_preco = new JTextField();
		textField_preco.setColumns(10);
		textField_preco.setBounds(90, 167, 86, 20);
		contentPane.add(textField_preco);
		
		textField_tamanho = new JTextField();
		textField_tamanho.setColumns(10);
		textField_tamanho.setBounds(90, 209, 86, 20);
		contentPane.add(textField_tamanho);
		
		JButton btnNewButton_1_1 = new JButton("Adicionar Item");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				nome = textField_nome.getText();
				lote = textField_lote.getText();
				quantidade = Integer.valueOf(textField_quantidade.getText());
				preco = Double.valueOf(textField_preco.getText());
				tamanho = textField_tamanho.getText();
				

				Estoque estoque = new Estoque();
				int cadastro = estoque.cadastrar(nome, lote,
						quantidade, preco, tamanho);
			
				if(cadastro!=0)
					{
						JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso!!!","Sucesso",JOptionPane.INFORMATION_MESSAGE);
						textField_nome.setText("");
						textField_lote.setText("");
						textField_quantidade.setText("");
						textField_preco.setText("");
						textField_tamanho.setText("");
						
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Erro para realizar o cadastro!!!","Erro",JOptionPane.ERROR_MESSAGE);
					}
				}
				
				
			{
				
			}
		});
				
		btnNewButton_1_1.setBounds(298, 33, 101, 23);
		contentPane.add(btnNewButton_1_1);
	}
}
