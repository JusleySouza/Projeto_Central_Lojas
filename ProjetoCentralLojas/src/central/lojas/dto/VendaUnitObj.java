package central.lojas.dto;

import java.util.Date;

public class VendaUnitObj {
	private int idUnitaria;
	private int idVenda;
	private int idMercadoria;
	private int quantidade;
	private double totalPedido;
	
	public int getIdUnitaria() {
		return idUnitaria;
	}
	public void setIdUnitaria(int idUnitaria) {
		this.idUnitaria = idUnitaria;
	}
	public int getIdVenda() {
		return idVenda;
	}
	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}
	public int getIdMercadoria() {
		return idMercadoria;
	}
	public void setIdMercadoria(int idMercadoria) {
		this.idMercadoria = idMercadoria;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getTotalPedido() {
		return totalPedido;
	}
	public void setTotalPedido(double totalPedido) {
		this.totalPedido = totalPedido;
	}
	
}
