package central.lojas.telas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import central.lojas.banco.Profissionais;
import central.lojas.dto.Usuario;

public class ConfirmacaoExcluirFuncionario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public ConfirmacaoExcluirFuncionario(Usuario usuarioObj, String nome) {
		setTitle("Funcionario");
		
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
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 44, 255, 34);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setText(nome);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Dialog", Font.BOLD, 13));
		btnCancelar.setBounds(22, 112, 102, 34);
		contentPane.add(btnCancelar);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profissionais profissionais = new Profissionais();
				profissionais.excluir(nome);
				dispose();
			}
		});
		btnOk.setFont(new Font("Dialog", Font.BOLD, 13));
		btnOk.setBounds(166, 112, 97, 34);
		contentPane.add(btnOk);
		
	
	}

	}

