package br.com.bg.biblioteca.enums;

public enum AreaLivro {

	HUMANAS(1),
	EXATAS(2);
	
	private int codigo;

	private AreaLivro(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public static Enum<?> toEnum(Integer codigo) {
		for (AreaLivro e : AreaLivro.values()) {
			if(codigo.equals(e.getCodigo())) {
				return e;
			}
		}
		return null;
	}
}
