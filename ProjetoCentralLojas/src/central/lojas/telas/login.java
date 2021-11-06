package central.lojas.telas;
import java.awt.BorderLayout;
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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
	
	public class login {
	
		public JFrame interFace;
	private Caixa cax;
	private JTextField textField;
	private JPasswordField passwordField;


	public login() throws IOException {
		cax = new Caixa();
		initialize();
	}


	private void initialize() throws IOException {
		interFace = new JFrame();
		interFace.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		interFace.setTitle("Login Funcionario");
		interFace.setBounds(100, 100, 521, 369);
		interFace.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		interFace.getContentPane().setLayout(new BorderLayout(0, 0));
		
		URL url = getClass().getResource("./imagens/CentralLoja.jpg");
		Image img = ImageIO.read(url);
		
		JPanel panel_1 = new JPanel();
		interFace.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel log1 = new JLabel("Usuario");
		log1.setForeground(UIManager.getColor("text"));
		log1.setBounds(231, 123, 172, 20);
		panel_1.add(log1);
		log1.setFont(new Font("Century Schoolbook", Font.BOLD, 13));
		
		JLabel senha1 = new JLabel("Senha");
		senha1.setForeground(UIManager.getColor("text"));
		senha1.setBounds(231, 185, 86, 20);
		panel_1.add(senha1);
		senha1.setFont(new Font("Century Schoolbook", Font.BOLD, 13));
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.setForeground(UIManager.getColor("textText"));
		btnNewButton.setBackground(UIManager.getColor("textText"));
		btnNewButton.setBounds(217, 270, 87, 30);
		panel_1.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(164, 154, 196, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(164, 216, 196, 20);
		panel_1.add(passwordField);
		passwordField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(0, -25, 505, 391);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(img));
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
	}
}