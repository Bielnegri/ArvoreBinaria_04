package controller;

import model.No;
import java.util.Stack;

public class ArvoreController {
	private No raiz;
	
	
	public ArvoreController() {
		super();
	}
	
	public void inserirNo(No novoNo){
		raiz = inserir(raiz, novoNo);
	}
	
	private No inserir(No atual, No novoNo){
		if (atual == null) {
			return novoNo;
		}
		else if (novoNo.getValor() < atual.getValor()) {
			atual.setEsq(inserir(atual.getEsq(), novoNo));
		}
		else {
			atual.setDir(inserir(atual.getDir(), novoNo));
		}
		return atual;
	}
	
	public void exibir() {
		System.out.println("Exibindo elementos da árvore");
		exibirArvore(raiz);
	}
	
	private void exibirArvore(No atual) {
		if(atual != null){
			exibirArvore(atual.getEsq());
			System.out.println(atual.getValor());
			exibirArvore(atual.getDir());
		}
	}
	
	public void excluirNo(int item) {
		try {
			No atual = raiz;
			No pai = null, filho = null, temp = null;
	
			while(atual != null && atual.getValor() != item){
				pai = atual;
				if (item < atual.getValor()) {
					atual = atual.getEsq();
				}
				else {
					atual = atual.getDir();
				}
			}
			 
			if (atual == null) {
				System.out.println("Elemento n�o localizado");
				if (pai == null) {
					if (atual.getDir() == null) {
						raiz = atual.getEsq();
					}
					else if (atual.getEsq() == null) {
						 raiz = atual.getDir();
					}
					else{
						for (temp=atual, filho=atual.getEsq(); filho.getDir() !=null; temp=filho, filho=filho.getDir());
			
						if (filho != atual.getEsq()){
							temp.setDir(filho.getEsq());
							filho.setEsq(raiz.getEsq());
						 }
						 filho.setDir(raiz.getDir());
						 raiz = filho;
					}
				}
			 }
			else if(atual.getDir() == null){
				 if(pai.getEsq() == atual) {
					 pai.setEsq(atual.getEsq());
				 }
				
				 else {
					 pai.setDir( atual.getEsq());
				 }
				 
				 }
			else if (atual.getEsq() == null) {
				 if(pai.getEsq() == atual) {
					 pai.setEsq(atual.getDir());
				 }
					 
				 else {
					 pai.setDir(atual.getDir());
				}
			}
			else{
				 for (temp=atual, filho=atual.getEsq(); filho.getDir() !=null; temp=filho, filho=filho.getDir());

				 if(filho != atual.getEsq()){
					 temp.setDir(filho.getEsq());
					 filho.setEsq(atual.getEsq());
				 }
				 filho.setDir(atual.getDir());
				 if (pai.getEsq() == atual)
					 pai.setEsq(filho);
				 else
					 pai.setDir(filho);
				 }
		}
		catch (NullPointerException erro) {
			 erro.getMessage();
		}
	}
	
	public void buscarNo(int valor) {
		No atual = raiz;
		Stack<No> antecessores = buscar(atual, valor);
		
		System.out.println("Antecessores do nó encontrado: " + "(" + valor + ")");
		while(!antecessores.isEmpty()) {
			No no = antecessores.pop();
			System.out.println(no.getValor());
		}
	}
	
	private Stack<No> buscar(No atual, int valor) { 
		Stack<No> antecessores = new Stack<No>();
		
		if(atual != null && atual.getValor() != valor ){
			antecessores = buscar(atual.getEsq(), valor);  
			antecessores = buscar(atual.getDir(), valor);
			antecessores.add(atual);
		}
		return antecessores;
	}
}
