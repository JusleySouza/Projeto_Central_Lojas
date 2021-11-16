package central.lojas.telas;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import central.lojas.banco.Relatorios;
import central.lojas.dto.Cliente;
import central.lojas.dto.Usuario;


public class RelatorioCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tabela;
	DefaultTableModel modelo;
	private ArrayList<Cliente> relatorioClientes = new ArrayList<>();
	private Relatorios relatorios = new Relatorios();


	public RelatorioCliente(Usuario usuarioObj) {
		
		
		setTitle("Relatorio Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 631, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		modelo = new DefaultTableModel(); 
		modelo.addColumn("Nome");
		modelo.addColumn("Telefone");
		modelo.addColumn("Email");
		
		tabela = new JTable(modelo);
		JScrollPane scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(10, 10, 595, 450);
		contentPane.add(scrollPane);
		
		relatorioClientes = relatorios.relatorioClientes();
		for(Cliente cliente : relatorioClientes) {	
			modelo.addRow(new Object[] {cliente.getNome(),cliente.getTelefone(), cliente.getEmail()});
		}
	}
}
