package br.com.bg.biblioteca.enums;

public enum Periodo {

	P1(1),
	P2(2),
	P3(3),
	P4(4),
	P5(5),
	P6(6),
	P7(7),
	P8(8);
	
	private int codigo;

	private Periodo(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
}
