package central.lojas.telas;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login {

	private JFrame interFace;
	private JPasswordField passwordField;
	private JTextField textField;
	private Cadastro cad;
	private Caixa cax;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.interFace.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		cad = new Cadastro();
		cax = new Caixa();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		interFace = new JFrame();
		interFace.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		interFace.setTitle("Login Funcionário");
		interFace.setBounds(100, 100, 450, 228);
		interFace.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		interFace.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setBackground(Color.ORANGE);
		interFace.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Informe seu usu\u00E1rio e senha para entrar");
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		interFace.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(52, 5, 172, 40);
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(2, 0, 1, 0));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel log1 = new JLabel("Usu\u00E1rio");
		log1.setFont(new Font("Century Schoolbook", Font.BOLD, 13));
		panel_4.add(log1);
		
		textField = new JTextField();
		textField.setColumns(10);
		panel_4.add(textField);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel senha1 = new JLabel("Senha");
		senha1.setFont(new Font("Century Schoolbook", Font.BOLD, 13));
		panel_5.add(senha1);
		
		passwordField = new JPasswordField();
		panel_5.add(passwordField);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(229, 8, 153, 33);
		panel_1.add(panel_2);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String test = new String("foo");
				String x = textField.getText();
				String password = String.valueOf(passwordField.getPassword());
				if(x.equals("teste")) {
				if(password.equals("teste")) {
				cax.setVisible(true);
				cax.toFront();
				cax.requestFocus();
				interFace.setVisible(false);
				}}}
			});
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		panel_2.add(btnNewButton_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(239, 52, 143, 33);
		panel_1.add(panel_6);
		
		JButton btnNewButton_2 = new JButton("Cadastrar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cad.setVisible(true);
			}
		});
		panel_6.add(btnNewButton_2);
	}
}