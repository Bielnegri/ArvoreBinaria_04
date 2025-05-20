package view;

import model.No;
import controller.ArvoreController;

public class Principal {

	public static void main(String[] args) {
		ArvoreController cont = new ArvoreController();
		
		cont.inserirNo(new No(2));
		cont.inserirNo(new No(1));
		cont.inserirNo(new No(3));
		cont.inserirNo(new No(4));
		cont.inserirNo(new No(5));
		
		cont.exibir();
		
		cont.buscarNo(5);
	}

}
