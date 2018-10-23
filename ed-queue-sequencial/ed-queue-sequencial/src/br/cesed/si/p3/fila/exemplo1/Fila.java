package br.cesed.si.p3.fila.exemplo1;

public class Fila {

	private int inseridos;

	private static final int ALOCACAO_INICIAL = 3;

	private Object[] arrayInterno = new Object[ALOCACAO_INICIAL];
	
	/**
	 * This method inserts an element at the end of the queue.
	 * 
	 * @param item The item that is going to be inserted on the queue.
	 * 
	 * @throws ElementoInvalidoException Exception to be thrown if the user
	 * passes an invalid element as a parameter.
	 */
	public void enqueue(Object item) throws ElementoInvalidoException {
		
		if(item == null) throw new ElementoInvalidoException();
		
		else {
			
			if (inseridos == arrayInterno.length) {
				
				Object[] novo = new Object[arrayInterno.length * 2];
				
				for (int i = 0; i < arrayInterno.length; i++) {
					novo[i] = arrayInterno[i];
				}
				
				arrayInterno = novo;
			}
			
			arrayInterno[inseridos] = item;
			inseridos++;
		}
	}
	
	/**
	 * This method removes the first element of the queue (the element on the first position
	 * of the internal array).
	 * 
	 * @return Te method return the remove element of the queue.
	 * 
	 * @throws DequeueInvalidoException Exception to be throw if the user tries to dequeue
	 * an empty queue.
	 */
	public Object dequeue() throws DequeueInvalidoException {
		
		if(this.isEmpty()) throw new DequeueInvalidoException();
		
		else {
			
			Object retorno = arrayInterno[0];
			
			if (inseridos > 0) {
				
				for (int i = 0; i < inseridos - 1; i++) {
					arrayInterno[i] = arrayInterno[i + 1];
				}
				
				inseridos--;
				arrayInterno[inseridos] = null;
			}
			
			return retorno;
		}
	}
	
	/**
	 * Method that returns the first element of the queue without removing it.
	 * 
	 * @return The first element of the queue.
	 */
	public Object front() {
		return arrayInterno[0];
	}
	
	/**
	 * Method that shows how many elements are inside the queue.
	 * 
	 * @return The number of elements on the queue.
	 */
	public int tamanho() {
		return inseridos;
	}
	
	/**
	 * Method that checks if the queue is empty or not.
	 * 
	 * @return It return true if the queue is empty and false if it isn't.
	 */
	public boolean isEmpty() {
		return inseridos == 0;
	}

}
