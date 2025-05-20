package model;

public class No {
	private int valor;
	private No esq;
	private No dir;
	
	public No(int valor){
		this.setValor(valor); 
		setEsq(setDir(null));
	}
	
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}

	public No getEsq() {
		return esq;
	}

	public void setEsq(No esq) {
		this.esq = esq;
	}

	public No getDir() {
		return dir;
	}

	public No setDir(No dir) {
		this.dir = dir;
		return dir;
	}
}
