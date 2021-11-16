package central.lojas.telas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import central.lojas.banco.Vendas;
import central.lojas.dto.Usuario;
import central.lojas.dto.VendasObj;

public class FinalizarVenda extends JFrame {

	private JPanel contentPane;
	private JTextField pagamento;
	private JTextField ValorRecebido;
	Vendas vendasfin = new Vendas();

	
	public FinalizarVenda(Usuario usuarioObj, VendasObj vendaobj) {
		setTitle("Finalizar Venda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 351, 263);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Total a pagar:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 11, 335, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("aqui");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 39, 335, 38);
		contentPane.add(lblNewLabel_1);
		
		if(vendaobj.getTotal() > 100.00 && vendaobj.getTotal()<= 500.00) {
			vendaobj.setTotal(vendaobj.getTotal() - (vendaobj.getTotal() * 0.05));
		}
		else if(vendaobj.getTotal() > 500.00) {
			vendaobj.setTotal(vendaobj.getTotal() - (vendaobj.getTotal() * 0.10));
		}
		
		lblNewLabel_1.setText(""+new DecimalFormat("0.##").format(vendaobj.getTotal()));
		
		JLabel lblNewLabel_2 = new JLabel("Forma de pagamento:");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 99, 210, 18);
		contentPane.add(lblNewLabel_2);
		
		pagamento = new JTextField();
		pagamento.setBounds(10, 128, 143, 20);
		contentPane.add(pagamento);
		pagamento.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Valor recebido:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_3.setBounds(10, 159, 135, 18);
		contentPane.add(lblNewLabel_3);
		
		ValorRecebido = new JTextField();
		ValorRecebido.setBounds(10, 188, 143, 20);
		contentPane.add(ValorRecebido);
		ValorRecebido.setColumns(10);
		
		JButton btnFinalizar = new JButton("Finalizar Venda");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				String troco = new DecimalFormat("0.##").format(Double.valueOf(ValorRecebido.getText()) - vendaobj.getTotal()).toString();
				vendasfin.uptade(pagamento.getText(), vendaobj.getTotal(), vendaobj.getId());
				JOptionPane.showMessageDialog(null,"Troco: " + troco,"Venda Finalizada",JOptionPane.INFORMATION_MESSAGE);
				dispose();
				
			}
		});
		btnFinalizar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnFinalizar.setBounds(204, 170, 121, 38);
		contentPane.add(btnFinalizar);
	}
}
