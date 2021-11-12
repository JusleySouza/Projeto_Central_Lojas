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
import central.lojas.dto.Mercadoria;

public class RelatorioMercadoria extends JFrame {

	private JPanel contentPane;
	private JTable tabela;
	DefaultTableModel modelo;
	private ArrayList<Mercadoria> relatorioMercadorias = new ArrayList<>();
	private Relatorios relatorios = new Relatorios();


	public RelatorioMercadoria() {
		setTitle("Relatorio Mercadorias");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 631, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		modelo = new DefaultTableModel(); 
		modelo.addColumn("Nome");
		modelo.addColumn("Quantidade Disponivel");
		modelo.addColumn("Preco");
		modelo.addColumn("Tamanho");
		
		tabela = new JTable(modelo);
		JScrollPane scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(10, 10, 595, 450);
		contentPane.add(scrollPane);
		
		relatorioMercadorias = relatorios.relatorioMercadorias();
		for(Mercadoria mercadoria : relatorioMercadorias) {	
			modelo.addRow(new Object[] {mercadoria.getNome(),mercadoria.getQuantidade(), mercadoria.getPreco(), mercadoria.getTamanho()});
		}
	}
}
