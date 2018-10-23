package br.cesed.si.p3.pilha.sequencial.exemplo1;

public class Pilha {

	public static final int ALOCACAO_INICIAL = 3;
	
	private Object[] arrayInterno = new Object[ALOCACAO_INICIAL];
	
	private int inseridos;
	
	/**
	 * Method that inserts a new element on the last available position of the internal array.
	 * 
	 * @param objeto Element that is going to be inserted.
	 * @throws InvalidItemException 
	 */
	public void push(Object objeto) throws InvalidItemException {
		
		if(objeto == null) throw new InvalidItemException();
		
		else {
			
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
	
	/**
	 * 	This methods shows the element at the top of the stack to the user.
	 * 
	 * @return The element at the top of the stack.
	 * 
	 * @throws EmptyStackException Exception to be thrown if the stack
	 * is empty.
	 */
	public Object top() throws EmptyStackException {
		
		if(this.isEmpty()) throw new EmptyStackException();
		
		return arrayInterno[inseridos - 1];
	}
	
	/**
	 * 	This method shows the size of the stack (how many items does it have on it).
	 * 
	 * @return The number of items on the stack.
	 */
	public int tamanho() {
		
		return inseridos;
	}
	
	/**
	 * This method checks if the stack is empty or not.
	 * 
	 * @return It returns true if the stack is empty and false if
	 * it isn't.
	 */
	public boolean isEmpty() {
		
		return inseridos == 0;
	}
}
