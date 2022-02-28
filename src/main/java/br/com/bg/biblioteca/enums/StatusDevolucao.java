package br.com.bg.biblioteca.enums;

public enum StatusDevolucao {

	EM_DIA(0),
	ATRASADO(1);
	
	private int codigo;

	private StatusDevolucao(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
}
