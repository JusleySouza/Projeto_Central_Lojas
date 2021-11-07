package central.lojas.dto;

import java.util.Date;

public class VendasObj {
	
	private int id;
	private String idProfissional;
	private String idCliente;
	private Date data;
	private String pagamento ;
	private double total;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIdProfissional() {
		return idProfissional;
	}
	public void setIdProfissional(String idProfissional) {
		this.idProfissional = idProfissional;
	}
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getPagamento() {
		return pagamento;
	}
	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}


}
