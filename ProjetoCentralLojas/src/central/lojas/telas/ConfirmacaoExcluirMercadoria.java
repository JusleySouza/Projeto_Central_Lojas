package central.lojas.telas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import central.lojas.banco.Estoque;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ConfirmacaoExcluirMercadoria extends JFrame {

	private JPanel contentPane;

	
	public ConfirmacaoExcluirMercadoria(int Id, String nomeProduto) {
		setTitle("Mercadoria");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 296, 165);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tem certeza que deseja excluir?");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setBounds(23, 11, 231, 33);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Estoque estoque = new Estoque();
				estoque.excluir(Id);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 14));
		btnNewButton.setBounds(156, 81, 98, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 13));
		btnNewButton_1.setBounds(23, 81, 98, 34);
		contentPane.add(btnNewButton_1);
		
		JLabel nome = new JLabel("New label");
		nome.setFont(new Font("Dialog", Font.PLAIN, 14));
		nome.setHorizontalAlignment(SwingConstants.CENTER);
		nome.setBounds(23, 44, 231, 19);
		contentPane.add(nome);
		nome.setText(nomeProduto);
	}

}
