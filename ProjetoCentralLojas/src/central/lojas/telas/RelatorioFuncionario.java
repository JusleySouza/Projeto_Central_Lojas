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
import central.lojas.dto.Funcionario;
import central.lojas.dto.Usuario;

public class RelatorioFuncionario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel modelo;
	private ArrayList<Funcionario> relatorioFuncionarios = new ArrayList<>();
	private Relatorios relatorios = new Relatorios();

	
	public RelatorioFuncionario(Usuario usuarioObj) {
		setTitle("Relatorio Funcionarios");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 631, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		modelo = new DefaultTableModel(); 
		modelo.addColumn("Nome");
		modelo.addColumn("Cargo");
		modelo.addColumn("Telefone");
			
		table = new JTable(modelo);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 10, 595, 445);
		contentPane.add(scrollPane);
			
		relatorioFuncionarios = relatorios.relatorioFuncionarios();
		for(Funcionario funcionario : relatorioFuncionarios) {	
			modelo.addRow(new Object[] {funcionario.getNome(),funcionario.getCargo(),funcionario.getTelefone()});
		}
	}
}
