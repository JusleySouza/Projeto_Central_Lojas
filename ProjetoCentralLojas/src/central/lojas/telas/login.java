package central.lojas.telas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import central.lojas.banco.Usuarios;
import central.lojas.dto.Usuario;
	
	public class login {
	
	public JFrame interFace;
	private Caixa cax;
	private JTextField txtTeste;
	private JPasswordField passwordField;
	private Usuario usuarioObj;
	private Usuarios usuarios;
	public login() throws IOException {
		initialize();
	}


	private void initialize() throws IOException {
		interFace = new JFrame();
		interFace.setBackground(Color.BLACK);
		interFace.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		interFace.setTitle("Login Funcionario");
		interFace.setBounds(100, 100, 521, 369);
		interFace.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		interFace.getContentPane().setLayout(new BorderLayout(0, 0));
		
		URL url = getClass().getResource("./imagens/CentralBranca.png");
		Image img = ImageIO.read(url);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		interFace.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 11, 505, 125);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(img));
		
		JLabel log1 = new JLabel("Usuario");
		log1.setHorizontalAlignment(SwingConstants.CENTER);
		log1.setForeground(UIManager.getColor("text"));
		log1.setBounds(0, 132, 505, 23);
		panel_1.add(log1);
		log1.setFont(new Font("Century Schoolbook", Font.BOLD, 13));
		
		txtTeste = new JTextField();
		txtTeste.setBounds(152, 166, 196, 20);
		panel_1.add(txtTeste);
		
		JLabel senha1 = new JLabel("Senha");
		senha1.setHorizontalAlignment(SwingConstants.CENTER);
		senha1.setForeground(UIManager.getColor("text"));
		senha1.setBounds(0, 197, 505, 20);
		panel_1.add(senha1);
		senha1.setFont(new Font("Century Schoolbook", Font.BOLD, 13));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(152, 230, 196, 20);
		panel_1.add(passwordField);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.setForeground(UIManager.getColor("textText"));
		btnNewButton.setBackground(UIManager.getColor("textText"));
		btnNewButton.setBounds(209, 275, 87, 30);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = txtTeste.getText();
				String senha = String.valueOf(passwordField.getPassword());
				
				usuarioObj = new Usuario();
				usuarios = new Usuarios();
				usuarioObj = usuarios.consulta(login);
				if(usuarioObj.getLogin().equals("") || usuarioObj.getLogin().equals(null) || !usuarioObj.getSenha().equals(senha)) {
					JOptionPane.showMessageDialog(null,"Login ou senha invalidos","Erro",JOptionPane.ERROR_MESSAGE);
				}
				else {
					try {
						cax = new Caixa(usuarioObj);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					cax.setVisible(true);
					cax.toFront();
					cax.requestFocus();
					interFace.setVisible(false);
				}
			}
		});
	}
}