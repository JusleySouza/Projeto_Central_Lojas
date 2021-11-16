package central.lojas.telas;

import java.awt.Button;
import java.awt.Dialog.ModalExclusionType;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import central.lojas.banco.ClientesBanco;
import central.lojas.banco.Estoque;
import central.lojas.banco.Profissionais;
import central.lojas.banco.VendaUnitaria;
import central.lojas.banco.Vendas;
import central.lojas.dto.Cliente;
import central.lojas.dto.Funcionario;
import central.lojas.dto.Mercadoria;
import central.lojas.dto.Usuario;
import central.lojas.dto.VendaUnitObj;
import central.lojas.dto.VendasObj;

public class Caixa extends JFrame {

	static final long serialVersionUID = 5965163484927016912L;
	
	
	private JPanel contentPane;
	private JTextField nomeConsulta;
	private JTextField nome;
	private JTextField totalFinal;
	private JTextField preco;
	private JTextField quantidade;
	private CadastroCliente cad;
	private mercadoria additm;
	private CadastroFuncionario cadx;
	private ConsultaMercadoria editarExcluir;
	private ConsultaFuncionario consultafunc;
	private ConsultaCliente consultacli;
	private JTable tabela;
	private DefaultTableModel modelo;
	private Double totalVenda = 0.00;
	private FinalizarVenda finaliza;
	private RelatorioCliente relatorioCliente;
	private RelatorioFuncionario relatorioFuncionario;
	private RelatorioMercadoria relatorioMercadoria;
	private RelatorioVendas relatorioVenda;
	
	Estoque estoque = new Estoque();
	Mercadoria mercadoria = new Mercadoria();
	private JTextField nomeCliente;
	
	ClientesBanco clientebanco = new ClientesBanco();
	Cliente cliente = new Cliente();
	private JTextField nomeFuncionario;
	
	Profissionais profissionais = new Profissionais();
	Funcionario funcionario = new Funcionario();

	VendaUnitaria vendaUni = new VendaUnitaria();
	VendaUnitObj vendaUnOb = new VendaUnitObj();
	
	VendasObj vendaobj = new VendasObj();
	Vendas vendasfin = new Vendas();
	
	public Caixa(Usuario usuarioObj) throws IOException {
		cad = new CadastroCliente(usuarioObj);
		cadx = new CadastroFuncionario(usuarioObj);
		additm = new mercadoria(usuarioObj);
		editarExcluir = new ConsultaMercadoria(usuarioObj);
		consultafunc = new ConsultaFuncionario(usuarioObj);
		consultacli = new ConsultaCliente(usuarioObj);
		relatorioCliente = new RelatorioCliente(usuarioObj);
		relatorioFuncionario = new RelatorioFuncionario(usuarioObj);
		relatorioMercadoria = new RelatorioMercadoria(usuarioObj);
		relatorioVenda = new RelatorioVendas(usuarioObj);
	
		
		setAutoRequestFocus(false);
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		setTitle("Caixa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 723, 565);
		
		URL url = getClass().getResource("./imagens/Central1.png");
		Image img = ImageIO.read(url);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCliente = new JMenu("Clientes");
		menuBar.add(mnCliente);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Cadastramento Cliente");
		mntmNewMenuItem.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				cad.setVisible(true);
			}
		});
		mnCliente.add(mntmNewMenuItem);
		
		JMenuItem mntmEditarExcluirCliente = new JMenuItem("Editar/Excluir Item (Cliente)");
		mntmEditarExcluirCliente.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				consultacli.setVisible(true);
			}
		});
		mnCliente.add(mntmEditarExcluirCliente);
		JMenuItem mntmvendas = new JMenuItem("Vendas");
		
		JMenu mnFuncionario = new JMenu("Funcionarios");
		menuBar.add(mnFuncionario);
		if(!usuarioObj.getCargo().equals("gerente")) {
			mnFuncionario.setEnabled(false);
			mntmvendas.setEnabled(false);
		}
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Cadastramento Funcionario");
		mntmNewMenuItem_2.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				cadx.setVisible(true);
			}
		});
		mnFuncionario.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Editar/Excluir Funcionario");
		mntmNewMenuItem_3.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				consultafunc.setVisible(true);
			}
		});
		mnFuncionario.add(mntmNewMenuItem_3);
		
		
		
		JMenu mnMercadoria = new JMenu("Mercadorias");
		menuBar.add(mnMercadoria);
		
		JMenuItem mntmNewMenuItem2 = new JMenuItem("Adicionar Item");
		mntmNewMenuItem2.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				additm.setVisible(true);
			}
		});
		mnMercadoria.add(mntmNewMenuItem2);
		
		JMenuItem editarExcluirItem = new JMenuItem("Alterar/Excluir Item");
		editarExcluirItem.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				editarExcluir.setVisible(true);
			}
		});

		mnMercadoria.add(editarExcluirItem);
		
		JMenu mnNewMenu_2 = new JMenu("Relatorios");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				relatorioCliente.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmClientes);
		
		JMenuItem mntmFuncionarios = new JMenuItem("Funcionarios");
		mntmFuncionarios.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				relatorioFuncionario.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmFuncionarios);
		
		JMenuItem mntmMercadorias = new JMenuItem("Mercadorias");
		mntmMercadorias.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				relatorioMercadoria.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmMercadorias);
		
	
		mntmvendas.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				relatorioVenda.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmvendas);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel telaVendas = new JPanel();
		telaVendas.setBounds(0, 0, 707, 504);
		contentPane.add(telaVendas);
		telaVendas.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Buscar Mercadoria:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel.setBounds(21, 100, 140, 20);
		telaVendas.add(lblNewLabel);
		
		nomeConsulta = new JTextField();
		nomeConsulta.setEnabled(false);
		nomeConsulta.setHorizontalAlignment(SwingConstants.LEFT);
		nomeConsulta.setBounds(21, 131, 130, 20);
		telaVendas.add(nomeConsulta);
		nomeConsulta.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome do Item:");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_1.setBounds(21, 185, 130, 22);
		telaVendas.add(lblNewLabel_1);
		
		nome = new JTextField();
		nome.setEnabled(false);
		nome.setEditable(false);
		nome.setBounds(21, 218, 130, 20);
		telaVendas.add(nome);
		nome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Total a Pagar:");
		lblNewLabel_2.setFont(new Font("Serif", Font.BOLD, 14));
		lblNewLabel_2.setBounds(240, 401, 103, 20);
		telaVendas.add(lblNewLabel_2);
		
		totalFinal = new JTextField();
		totalFinal.setEditable(false);
		totalFinal.setBounds(353, 403, 329, 20);
		telaVendas.add(totalFinal);
		
		JButton AdicionarItem = new JButton("Adicionar Item");
		AdicionarItem.setEnabled(false);
		AdicionarItem.setFont(new Font("Serif", Font.BOLD, 14));
		AdicionarItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String quantidadeItem;
				double totalItem;
				quantidadeItem = quantidade.getText();
				totalItem = mercadoria.getPreco() * Double.parseDouble(quantidadeItem);
				modelo.addRow(new Object[] {mercadoria.getNome(),quantidadeItem, mercadoria.getPreco(),
						new DecimalFormat("0.##").format(totalItem)});
				
				vendaUnOb.setQuantidade(Integer.valueOf(quantidadeItem));
				vendaUnOb.setIdVenda(vendaobj.getId());
				vendaUnOb.setIdMercadoria(mercadoria.getId());
				vendaUnOb.setTotalPedido(totalItem);
				vendaUni.cadastrar(vendaUnOb);
				mercadoria.setQuantidade(mercadoria.getQuantidade() - Integer.valueOf(quantidadeItem));
				estoque.subtrairMercadoria(mercadoria);
				
				vendaobj.setTotal(vendaobj.getTotal() + totalItem);
				
				totalVenda += totalItem;

				
				totalFinal.setText(""+new DecimalFormat("0.##").format(totalVenda));
				
				
				limpar();
			}
		});
		AdicionarItem.setBounds(21, 445, 130, 35);
		telaVendas.add(AdicionarItem);
		
		JButton limpar = new JButton("Limpar");
		limpar.setEnabled(false);
		limpar.setFont(new Font("Serif", Font.BOLD, 14));
		limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nome.setText("");
				nomeConsulta.setText("");
				preco.setText("");
				quantidade.setText("");
			}
		});
		limpar.setBounds(240, 445, 120, 35);
		telaVendas.add(limpar);
		
		Button buscarMercadoria = new Button("Buscar");
		buscarMercadoria.setEnabled(false);
		buscarMercadoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nomeConsulta.getText();
				mercadoria = estoque.consulta(nomeConsulta.getText());
				limpar();
				
				nome.setText(mercadoria.getNome());
				preco.setText(""+mercadoria.getPreco());
				
				nomeConsulta.setText("");
			}
		});
		
		Button validarFuncionario = new Button("Validar");
		
		JButton fecharVenda = new JButton("Fechar venda");
		fecharVenda.setEnabled(false);
		fecharVenda.setFont(new Font("Serif", Font.BOLD, 14));
		fecharVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finaliza = new FinalizarVenda(usuarioObj, vendaobj);
				finaliza.setVisible(true);
				totalVenda=0.00;
				
				limpar();
				
				nomeCliente.setText("");
				nomeFuncionario.setText("");
				nomeFuncionario.setEnabled(false);
				validarFuncionario.setEnabled(false);
				nomeConsulta.setEnabled(false);
				buscarMercadoria.setEnabled(false);
				nome.setEnabled(false);
				preco.setEnabled(false);
				quantidade.setEnabled(false);
				totalFinal.setEnabled(false);
				AdicionarItem.setEnabled(false);
				limpar.setEnabled(false);
				fecharVenda.setEnabled(false);
				totalFinal.setText("");
				int numRows = modelo.getRowCount();
				for(int i = 0; i < numRows; i++) {
					modelo.removeRow(0);
				}
			}
		});
		fecharVenda.setBounds(411, 445, 120, 35);
		telaVendas.add(fecharVenda);
		
		JLabel lblNewLabel_3 = new JLabel("Pre\u00E7o:");
		lblNewLabel_3.setFont(new Font("Serif", Font.BOLD, 14));
		lblNewLabel_3.setBounds(21, 249, 151, 20);
		telaVendas.add(lblNewLabel_3);
		
		preco = new JTextField();
		preco.setEnabled(false);
		preco.setEditable(false);
		preco.setBounds(21, 280, 130, 20);
		telaVendas.add(preco);
		preco.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("Quantidade:");
		lblNewLabel_3_1.setFont(new Font("Serif", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(21, 311, 151, 20);
		telaVendas.add(lblNewLabel_3_1);
		
		quantidade = new JTextField();
		quantidade.setEnabled(false);
		quantidade.setBounds(21, 342, 130, 20);
		telaVendas.add(quantidade);
		
		JButton btnCancelarVenda = new JButton("Cancelar");
		btnCancelarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
				
				nomeCliente.setText("");
				nomeFuncionario.setText("");
				nomeFuncionario.setEnabled(false);
				validarFuncionario.setEnabled(false);
				nomeConsulta.setEnabled(false);
				buscarMercadoria.setEnabled(false);
				nome.setEnabled(false);
				preco.setEnabled(false);
				quantidade.setEnabled(false);
				totalFinal.setEnabled(false);
				AdicionarItem.setEnabled(false);
				limpar.setEnabled(false);
				fecharVenda.setEnabled(false);
				totalFinal.setText("");
				int numRows = modelo.getRowCount();
				for(int i = 0; i < numRows; i++) {
					modelo.removeRow(0);
				}
				vendaUni.deletarTodasVendasUnitarias(vendaobj.getId());
				vendasfin.deletar(vendaobj.getId());
			}
		});
		btnCancelarVenda.setFont(new Font("Dialog", Font.BOLD, 13));
		btnCancelarVenda.setBounds(572, 445, 110, 35);
		telaVendas.add(btnCancelarVenda);
		
		modelo = new DefaultTableModel(); 
		modelo.addColumn("Nome");
		modelo.addColumn("Quantidade");
		modelo.addColumn("Preco Unitario");
		modelo.addColumn("Subtotal");
		
		tabela = new JTable(modelo);
		tabela.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				
				int posicao = tabela.getSelectedRow();
				int quantidadeTabela = Integer.valueOf((String) modelo.getValueAt(posicao,1));
				String nomeTabela = String.valueOf(modelo.getValueAt(posicao,0));
				Double subTotal = Double.valueOf(modelo.getValueAt(posicao,3).toString().replaceAll(",", "."));
				
				mercadoria = estoque.consulta(nomeTabela);
				mercadoria.setQuantidade(mercadoria.getQuantidade() + quantidadeTabela);
				estoque.subtrairMercadoria(mercadoria);
				
				vendaobj.setTotal(vendaobj.getTotal() - subTotal);
				totalVenda -= subTotal;				
				totalFinal.setText(""+new DecimalFormat("0.##").format(totalVenda));
				
				limpar();
				
				modelo.removeRow(posicao);
				
				nome.setText(mercadoria.getNome());
				preco.setText(""+mercadoria.getPreco());
				quantidade.setText(""+quantidadeTabela);
				vendaUni.deletar(vendaobj.getId(), mercadoria.getId(), quantidadeTabela);
			}
		});
		JScrollPane scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(240, 93, 446, 285);
		telaVendas.add(scrollPane);
		
		
		buscarMercadoria.setBounds(170, 131, 49, 22);
		telaVendas.add(buscarMercadoria);
		
		
		validarFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				funcionario = profissionais.consulta(nomeFuncionario.getText());
				if ((nomeFuncionario.getText().equals(funcionario.getNome()))) {
					
					JOptionPane.showMessageDialog(null,"Funcionario encontrado!!!","Sucesso",JOptionPane.INFORMATION_MESSAGE);
					nomeConsulta.setEnabled(true);
					buscarMercadoria.setEnabled(true);
					nome.setEnabled(true);
					preco.setEnabled(true);
					quantidade.setEnabled(true);
					totalFinal.setEnabled(true);
					AdicionarItem.setEnabled(true);
					limpar.setEnabled(true);
					fecharVenda.setEnabled(true);
					
					vendaobj = vendasfin.cadastrar(funcionario.getCpf(), cliente.getCpf());
					
					
				}
				else {
					JOptionPane.showMessageDialog(null,"Funcionario Inexistente!!!","Erro",JOptionPane.INFORMATION_MESSAGE);
					nomeConsulta.setEnabled(false);
					buscarMercadoria.setEnabled(false);
					nome.setEnabled(false);
					preco.setEnabled(false);
					quantidade.setEnabled(false);
					totalFinal.setEnabled(false);
					AdicionarItem.setEnabled(false);
					limpar.setEnabled(false);
					fecharVenda.setEnabled(false);
				}
				
			}
		});
		validarFuncionario.setEnabled(false);
		validarFuncionario.setBounds(606, 54, 76, 22);
		telaVendas.add(validarFuncionario);
		
		
		
		Button validarCliente = new Button("Validar");
		validarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cliente = clientebanco.consulta(nomeCliente.getText());
				if ((nomeCliente.getText().equals(cliente.getNome()))) {
					
					JOptionPane.showMessageDialog(null,"Cliente encontrado!!!","Sucesso",JOptionPane.INFORMATION_MESSAGE);
					nomeFuncionario.setEnabled(true);
					validarFuncionario.setEnabled(true);	
				}
				else {
					JOptionPane.showMessageDialog(null,"Cliente Inexistente!!!","Erro",JOptionPane.INFORMATION_MESSAGE);
					nomeFuncionario.setEnabled(false);
					validarFuncionario.setEnabled(false);
					nomeConsulta.setEnabled(false);
					buscarMercadoria.setEnabled(false);
					nome.setEnabled(false);
					preco.setEnabled(false);
					quantidade.setEnabled(false);
					totalFinal.setEnabled(false);
					AdicionarItem.setEnabled(false);
					limpar.setEnabled(false);
					fecharVenda.setEnabled(false);
				}
				
			}
		});
		validarCliente.setBounds(610, 10, 76, 22);
		telaVendas.add(validarCliente);
		
		JLabel lblNewLabel_4 = new JLabel("Cliente:");
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_4.setBounds(240, 8, 68, 22);
		telaVendas.add(lblNewLabel_4);
		
		nomeCliente = new JTextField();
		nomeCliente.setBounds(336, 11, 241, 20);
		telaVendas.add(nomeCliente);
		nomeCliente.setColumns(10);
		
		
		JLabel lblNewLabel_6 = new JLabel("Funcionario:");
		lblNewLabel_6.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_6.setBounds(240, 54, 90, 14);
		telaVendas.add(lblNewLabel_6);
		
		nomeFuncionario = new JTextField();
		nomeFuncionario.setEnabled(false);
		nomeFuncionario.setBounds(336, 54, 241, 20);
		telaVendas.add(nomeFuncionario);
		nomeFuncionario.setColumns(10);
		
		JLabel logo = new JLabel("New label");
		logo.setHorizontalAlignment(SwingConstants.LEFT);
		logo.setBounds(10, 5, 209, 84);
		telaVendas.add(logo);
		logo.setIcon(new ImageIcon(img));

	}
	
	public void limpar() {
		nomeConsulta.setText("");
		nome.setText("");
		preco.setText("");
		quantidade.setText("");
		
	}
}
