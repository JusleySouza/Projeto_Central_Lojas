package central.lojas.dto;

public class RelatorioVendasObj {
	
	private String nomeFuncionario;
	private int quantidadePecas;
	private double totalVenda =  0;
	private double comissao;
	
	
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}
	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}
	public int getQuantidadePecas() {
		return quantidadePecas;
	}
	public void setQuantidadePecas(int quantidadePecas) {
		this.quantidadePecas = quantidadePecas;
	}
	public double getTotalVenda() {
		return totalVenda;
	}
	public void setTotalVenda(double totalVenda) {
		this.totalVenda = totalVenda;
	}
	public double getComissao() {
		return comissao;
	}
	public void setComissao(double TotalVenda) {
		this.comissao = TotalVenda * 0.05;
	}
	
	
}
