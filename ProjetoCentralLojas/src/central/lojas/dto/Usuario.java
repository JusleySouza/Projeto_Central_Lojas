package central.lojas.dto;

public class Usuario {
	
	private int id_usuario;
	private String cargo;
	private String login;
	private String senha;
	
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", cargo=" + cargo + ", login=" + login + ", senha=" + senha + "]";
	}
}
