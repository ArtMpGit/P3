package br.cesed.si.p3.pilha.sequencial.exemplo1;

public class Pilha {

	public static final int ALOCACAO_INICIAL = 3;
	
	private Object[] arrayInterno = new Object[ALOCACAO_INICIAL];
	
	private int inseridos;
	
	/**
	 * Method that inserts a new element on the last available position of the internal array.
	 * 
	 * @param objeto Element that is going to be inserted.
	 */
	public void push(Object objeto) {

		if(inseridos == arrayInterno.length) {
			
			Object[] novoArray = new Object[arrayInterno.length * 2];
			
			for (int i = 0; i < arrayInterno.length; i++) {
				novoArray[i] = arrayInterno[i];
			}
			
			arrayInterno = novoArray;
		}
		
		arrayInterno[inseridos] = objeto;
		inseridos++;
	}
	
	/**
	 * Method that removes and return the last inserted element of the stack
	 * internal array.
	 * 
	 * @return The last element of the stack internal array.
	 * 
	 * @throws EmptyStackException Exception to bw throw if the stack is empty.
	 */
	public Object pop() throws EmptyStackException {
		
		if(this.isEmpty()) throw new EmptyStackException();
		
		Object retorno = arrayInterno[inseridos - 1];
		arrayInterno[inseridos - 1] = null;
		inseridos--;
		
		return retorno;
	}
	
	public Object top() throws EmptyStackException {
		
		if(this.isEmpty()) throw new EmptyStackException();
		
		return arrayInterno[inseridos - 1];
	}
	
	public int tamanho() {
		
		return inseridos;
	}
	
	public boolean isEmpty() {
		
		return inseridos == 0;
	}
	
}
