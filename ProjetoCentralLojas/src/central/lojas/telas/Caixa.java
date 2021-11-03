package central.lojas.telas;

import java.awt.Dialog.ModalExclusionType;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Caixa extends JFrame {
/**
	 * 
	 */
	private static final long serialVersionUID = 5965163484927016912L;
	
	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField valorR;
	private JTextField quantidade;
	private JTextField todP;
	private JTextField dinC;
	private JTextField troco;
	private CadastroCliente cad;
	private logincliente logcli;
	private mercadoria additm;
	private Cadastro cadx;
	private ConsultaMercadoria editarExcluir;
	private ConsultaFuncionario consultafunc;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Caixa frame = new Caixa();
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
	public Caixa() {
		logcli = new logincliente();
		cad = new CadastroCliente();
		cadx = new Cadastro();
		additm = new mercadoria();
		editarExcluir = new ConsultaMercadoria();
		consultafunc = new ConsultaFuncionario();
		setAutoRequestFocus(false);
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		setTitle("Caixa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 526);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Op\u00E7\u00F5es");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Cadastramento Cliente");
		mntmNewMenuItem.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				cad.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem1 = new JMenuItem("Login Cliente");
		mntmNewMenuItem1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				logcli.setVisible(true);
			}
		});
		
		JMenuItem mntmNewMenuItem3 = new JMenuItem("Cadastramento Funcionario");
		mntmNewMenuItem3.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				cadx.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem3);
		mnNewMenu.add(mntmNewMenuItem1);
		
		
		
		JMenu mnNewMenu1 = new JMenu("Mercadorias");
		menuBar.add(mnNewMenu1);
		
		JMenuItem mntmNewMenuItem2 = new JMenuItem("Adicionar Item");
		mntmNewMenuItem2.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				additm.setVisible(true);
			}
		});
		mnNewMenu1.add(mntmNewMenuItem2);
		
		JMenuItem editarExcluirItem = new JMenuItem("Alterar/Excluir Item");
		editarExcluirItem.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				editarExcluir.setVisible(true);
			}
		});
		mnNewMenu1.add(editarExcluirItem);
		
		JMenuItem mtnmNewMenuItem4 = new JMenuItem("Alterar/Excluir Item");
		editarExcluirItem.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				consultafunc.setVisible(true);
			}
		});
		mnNewMenu1.add(mtnmNewMenuItem4);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 750, 454);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Codigo da Roupa");
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 14));
		lblNewLabel.setBounds(26, 30, 140, 20);
		panel.add(lblNewLabel);
		
		valorR = new JTextField();
		valorR.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (valorR.getText().equals("0"));
				{
					valorR.setText("");
				}
			}
		});
		valorR.setHorizontalAlignment(SwingConstants.LEFT);
		valorR.setText("0");
		valorR.setBounds(26, 52, 140, 20);
		panel.add(valorR);
		valorR.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Quantidade de pe\u00E7as");
		lblNewLabel_1.setFont(new Font("Serif", Font.BOLD, 14));
		lblNewLabel_1.setBounds(26, 94, 151, 20);
		panel.add(lblNewLabel_1);
		
		quantidade = new JTextField();
		quantidade.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (quantidade.getText().equals("0"));
				{
					quantidade.setText("");
				}
			}
		});
		quantidade.setText("0");
		quantidade.setBounds(26, 119, 140, 20);
		panel.add(quantidade);
		quantidade.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Total a Pagar");
		lblNewLabel_2.setFont(new Font("Serif", Font.BOLD, 14));
		lblNewLabel_2.setBounds(373, 29, 140, 20);
		panel.add(lblNewLabel_2);
		
		todP = new JTextField();
		todP.setText("0");
		todP.setEditable(false);
		todP.setBounds(373, 52, 140, 20);
		panel.add(todP);
		todP.setColumns(10);
		
		JButton Calcular = new JButton("Adicionar Item");
		Calcular.setFont(new Font("Serif", Font.BOLD, 14));
		Calcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String preco, quant, val;
				double soma, multiplicacao;
				
				preco = valorR.getText();
				quant = quantidade.getText();
				val = todP.getText();
			
				
				multiplicacao = Double.parseDouble(preco) * Double.parseDouble(quant);
				todP.setText(String.valueOf(multiplicacao));
				
				soma = Double.parseDouble(val) + multiplicacao;
				todP.setText(String.valueOf(soma));
				
				quantidade.setText("");
				valorR.setText("");
				
			}
		});
		Calcular.setBounds(26, 172, 144, 52);
		panel.add(Calcular);
		
		JButton limpar = new JButton("Limpar");
		limpar.setFont(new Font("Serif", Font.BOLD, 14));
		limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quantidade.setText("");
				valorR.setText("");
			}
		});
		limpar.setBounds(26, 357, 144, 52);
		panel.add(limpar);
		
		JButton limparT = new JButton("Fechar venda");
		limparT.setFont(new Font("Serif", Font.BOLD, 14));
		limparT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				troco.setText("0");
				todP.setText("0");
				quantidade.setText("0");
				valorR.setText("0");
				dinC.setText("0");
				
			}
		});
		limparT.setBounds(197, 357, 140, 52);
		panel.add(limparT);
		
		JLabel lblNewLabel_3 = new JLabel("Valor Recebido");
		lblNewLabel_3.setFont(new Font("Serif", Font.BOLD, 14));
		lblNewLabel_3.setBounds(373, 94, 151, 14);
		panel.add(lblNewLabel_3);
		
		dinC = new JTextField();
		dinC.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (dinC.getText().equals("0"));
				{
					dinC.setText("");
				}
			}
		});
		dinC.setText("0");
		dinC.setBounds(373, 119, 140, 20);
		panel.add(dinC);
		dinC.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("Troco");
		lblNewLabel_3_1.setFont(new Font("Serif", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(373, 172, 151, 14);
		panel.add(lblNewLabel_3_1);
		
		troco = new JTextField();
		troco.setText("0");
		troco.setEditable(false);
		troco.setColumns(10);
		troco.setBounds(373, 198, 140, 20);
		panel.add(troco);
		
		JButton btnNewButton = new JButton("Calcular Troco");
		btnNewButton.setFont(new Font("Serif", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String  troc;
				double subtracao, soma;
				
				troc = dinC.getText();
				soma = Double.parseDouble(todP.getText());
				
				
				subtracao = soma - Double.parseDouble(troc);
				troco.setText(String.valueOf(subtracao));
			}
		});
		btnNewButton.setBounds(373, 247, 140, 23);
		panel.add(btnNewButton);
	}
}
