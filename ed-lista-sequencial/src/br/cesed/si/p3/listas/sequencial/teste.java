package br.cesed.si.p3.listas.sequencial;

public class teste {

	public static void main(String[] args) throws EstadoInvalidoException {

		ListaSequencial listaSequencial = new ListaSequencial();
		
		listaSequencial.adicionar("item1");
		listaSequencial.adicionar("item2");
		listaSequencial.adicionar("item3");
		listaSequencial.adicionar("item4");
		
		listaSequencial.remover("item1");
		listaSequencial.remover("item3");
		
		System.out.println(listaSequencial.tamanho());
		
		
		
	}

}
