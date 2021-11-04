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

public class ConsultaMercadoria extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
			
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaMercadoria frame = new ConsultaMercadoria();
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
	
	Estoque estoque = new Estoque();
	Mercadoria mercadoria = new Mercadoria();

	
	public ConsultaMercadoria() {
		setTitle("Mercadorias");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 531, 464);
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
		btnNewButton_1.setBounds(396, 391, 109, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Mercadoria a Consultar");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 216, 14);
		contentPane.add(lblNewLabel);
		
		nomeConsulta = new JTextField();
		nomeConsulta.setBounds(10, 36, 366, 20);
		contentPane.add(nomeConsulta);
		nomeConsulta.setColumns(10);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				nomeConsulta.getText();
				mercadoria = estoque.consulta(nomeConsulta.getText());
				limpar();
				
				novoNome.setText(mercadoria.getNome());
				novoLote.setText(mercadoria.getLote());
				novaQuantidade.setText(""+mercadoria.getQuantidade());
				novoPreco.setText(""+mercadoria.getPreco());
				novoTamanho.setText(mercadoria.getTamanho());				
			}
		});
		btnProcurar.setFont(new Font("Dialog", Font.BOLD, 13));
		btnProcurar.setBounds(396, 34, 109, 23);
		contentPane.add(btnProcurar);
		
		JLabel lblNewLabel_1 = new JLabel("Novo Nome:");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 87, 84, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Novo lote:");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 143, 84, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nova Quantidade:");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_3.setBounds(10, 203, 134, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Novo Pre\u00E7o:");
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_4.setBounds(10, 259, 84, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Novo Tamanho:");
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_5.setBounds(10, 315, 109, 14);
		contentPane.add(lblNewLabel_5);
		
		novoNome = new JTextField();
		novoNome.setBounds(10, 112, 366, 20);
		contentPane.add(novoNome);
		novoNome.setColumns(10);
		
		novoLote = new JTextField();
		novoLote.setBounds(10, 168, 366, 20);
		contentPane.add(novoLote);
		novoLote.setColumns(10);
		
		novaQuantidade = new JTextField();
		novaQuantidade.setBounds(10, 228, 366, 20);
		contentPane.add(novaQuantidade);
		novaQuantidade.setColumns(10);
		
		novoPreco = new JTextField();
		novoPreco.setBounds(10, 284, 366, 20);
		contentPane.add(novoPreco);
		novoPreco.setColumns(10);
		
		novoTamanho = new JTextField();
		novoTamanho.setBounds(10, 340, 366, 20);
		contentPane.add(novoTamanho);
		novoTamanho.setColumns(10);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mercadoria.setNome(novoNome.getText());
				mercadoria.setLote(novoLote.getText());
				mercadoria.setQuantidade(Integer.valueOf(novaQuantidade.getText()));
				mercadoria.setPreco(Double.valueOf(novoPreco.getText()));
				mercadoria.setTamanho(novoTamanho.getText());
				
				estoque.atualizar(mercadoria);
				limpar();
			}
		});
		btnAlterar.setFont(new Font("Dialog", Font.BOLD, 13));
		btnAlterar.setBounds(10, 391, 109, 23);
		contentPane.add(btnAlterar);
		
		JButton btnNewButton = new JButton("Limpar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 13));
		btnNewButton.setBounds(267, 391, 109, 23);
		contentPane.add(btnNewButton);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfirmacaoExcluirMercadoria confirmacao = new ConfirmacaoExcluirMercadoria(mercadoria.getId(), mercadoria.getNome());
				confirmacao.setVisible(true);
				confirmacao.toFront();
				confirmacao.requestFocus();
				limpar();
			}
		});
		btnExcluir.setFont(new Font("Dialog", Font.BOLD, 13));
		btnExcluir.setBounds(137, 391, 109, 23);
		contentPane.add(btnExcluir);
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
