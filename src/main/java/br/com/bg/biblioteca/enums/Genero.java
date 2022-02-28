package br.com.bg.biblioteca.enums;

public enum Genero {
	
	MASCULINO(1),
	FEMININO(2);
	
	private int codigo;

	private Genero(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
}
