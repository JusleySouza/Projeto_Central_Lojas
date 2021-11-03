package central.lojas.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class ConfirmacaoExcluirFuncionario extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmacaoExcluirFuncionario frame = new ConfirmacaoExcluirFuncionario();
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
	public ConfirmacaoExcluirFuncionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 323, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tem certeza que deseja excluir?");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 354, 34);
		contentPane.add(lblNewLabel);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Dialog", Font.BOLD, 13));
		btnCancelar.setBounds(22, 112, 89, 34);
		contentPane.add(btnCancelar);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setFont(new Font("Dialog", Font.BOLD, 13));
		btnOk.setBounds(174, 112, 89, 34);
		contentPane.add(btnOk);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 44, 255, 34);
		contentPane.add(lblNewLabel_1);
	}
}
