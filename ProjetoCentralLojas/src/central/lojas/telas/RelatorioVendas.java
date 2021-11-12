package central.lojas.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class RelatorioVendas extends JFrame {

	private JPanel contentPane;
	private JTable tabela;
	DefaultTableModel modelo;

	
	public RelatorioVendas() {
		setTitle("Relatorio Vendas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 631, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		modelo = new DefaultTableModel(); 
		modelo.addColumn("Data");
		modelo.addColumn("Funcionario");
		modelo.addColumn("Quantidade de Pecas");
		modelo.addColumn("Valor Total");
		
		tabela = new JTable(modelo);
		JScrollPane scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(10, 10, 595, 450);
		contentPane.add(scrollPane);
		
	}

}
