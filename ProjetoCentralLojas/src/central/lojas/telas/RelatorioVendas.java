package central.lojas.telas;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import central.lojas.dto.RelatorioVendasObj;
import central.lojas.dto.Usuario;
import central.lojas.banco.Relatorios;

public class RelatorioVendas extends JFrame {

	private JPanel contentPane;
	private JTable tabela;
	private DefaultTableModel modelo;
	private Relatorios relatorios;
	
	public RelatorioVendas(Usuario usuarioObj) {
		setTitle("Relatorio Vendas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 631, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		modelo = new DefaultTableModel(); 
		modelo.addColumn("Funcionario");
		modelo.addColumn("Quantidade de Pecas");
		modelo.addColumn("Valor Total");
		modelo.addColumn("Comissao");
		
		tabela = new JTable(modelo);
		JScrollPane scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(10, 10, 595, 450);
		contentPane.add(scrollPane);
		
		ArrayList<RelatorioVendasObj> relatorioVendas  = new ArrayList<>();
		relatorios = new Relatorios();				
		relatorioVendas = relatorios.relatorioVendas();
		
		for(RelatorioVendasObj relatorioVendasObj : relatorioVendas) {
			if(relatorioVendasObj.getTotalVenda() > 0) {
				modelo.addRow(new Object[] {
						relatorioVendasObj.getNomeFuncionario(),
						relatorioVendasObj.getQuantidadePecas(), 
						new DecimalFormat("0.##").format(relatorioVendasObj.getTotalVenda()),
						new DecimalFormat("0.##").format(relatorioVendasObj.getComissao())});
			}
		}
	}
}
