package central.lojas.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;
import static javax.swing.JOptionPane.showMessageDialog;

public class mercadoriaadd extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mercadoriaadd frame = new mercadoriaadd();
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
	public String qnt;
	public String prc;
	public String tmh;
	
	public mercadoriaadd() {
		
		
		
		setTitle("Adicionar Item");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 436, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
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
		
		textField = new JTextField();
		textField.setBounds(90, 34, 169, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
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
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(90, 80, 169, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(186, 126, 73, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(90, 167, 86, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(90, 209, 86, 20);
		contentPane.add(textField_4);
		
		JButton btnNewButton_1_1 = new JButton("Adicionar Item");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				nome = textField.getText();
				lote = textField_1.getText();
				qnt = textField_2.getText();
				prc = textField_3.getText();
				tmh = textField_4.getText();
				
				showMessageDialog(null, "Item Adicionado!");
				
			}
		});
		btnNewButton_1_1.setBounds(298, 33, 101, 23);
		contentPane.add(btnNewButton_1_1);
	}
}
