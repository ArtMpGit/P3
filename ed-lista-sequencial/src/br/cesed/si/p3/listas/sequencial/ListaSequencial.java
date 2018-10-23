package br.cesed.si.p3.listas.sequencial;

public class ListaSequencial {

	private static final int ALOCACAO_INICIAL = 3;
	
	private Object[] arrayInterno = new Object[ALOCACAO_INICIAL];
	
	private int inseridos;
	
	/**
	 * 	This method adds an element os the first available position inside the internal array.
	 * If the array is full, the private method increseArray() is called, wich doubles the size of 
	 * the internal array.
	 * 
	 * @param item The element that the use wants to add on the array.
	 *
	 * @throws EstadoInvalidoException Exception to be thrown if the user passes an
	 * invalid element as a parameter.
	 */
	public void adicionar(Object item) throws EstadoInvalidoException {
		
		if(item == null) throw new EstadoInvalidoException();
		
		else {
			
			if(inseridos == arrayInterno.length) this.increaseArray();
			
			arrayInterno[inseridos] = item;
			inseridos++;
		}
	}
	
	/**
	 * This method adds an element on the position specified by the user. If the position
	 * is free, it just adds the desired element on it, and if the position is already with something,
	 * it moves all of the items to insert the desired element on the desired position.
	 * 
	 * @param item The element that the user wants to add on the list.
	 * 
	 * @param posicao The position where the user wants to add the new element
	 * 
	 * @throws EstadoInvalidoException Exception to be thrown if the user passes an invalid element or position as 
	 * a parameter
	 */
	public void adicionar(Object item, int posicao) throws EstadoInvalidoException {
		
		if(item == null || posicao < 0 || posicao > arrayInterno.length - 1) throw new EstadoInvalidoException();
			
		else {
			
			if(arrayInterno[posicao] == null) {
				
				arrayInterno[posicao] = item;
				inseridos++;
			}
			
			else {
				
				if(arrayInterno[arrayInterno.length - 1] != null) this.increaseArray();
				
				for (int i = (arrayInterno.length - 1); i > posicao; i--) {
					
					arrayInterno[i] = arrayInterno[i - 1];
				}
				
				arrayInterno[posicao] = item;
				inseridos++;
			}
		}
	}
	
	/**
	 * This method returns the element on an specific position inside the internal array.
	 * 
	 * @param indice The position of the element the user wants to retrieve.
	 * 
	 * @return The element that the user wnats to retrieve.
	 * 
	 * @throws EstadoInvalidoException Exception to be thrown if the user passes
	 * an invalid position as parameter or if the internal array is empty.
	 */
	public Object obter(int indice) throws EstadoInvalidoException {
		
		if(this.isEmpty() || indice < 0 || (inseridos > 0 && indice >= inseridos )) throw new EstadoInvalidoException();
		
		else return arrayInterno[indice];
	}

	/**
	 * This method removes an specific element, witch is
	 *  passed as a parameter, from the internal array.
	 * 
	 * @param item The element that is going to be removed.
	 * 
	 * @throws EstadoInvalidoException Exception to be thrown if the element to be removed
	 * is invalid, if the internal array is empty or if the element does not exist inside the 
	 * internal array.
	 */
	public void remover(Object item) throws EstadoInvalidoException {
		
		if(!this.checarExistencia(item) || this.isEmpty() || item == null) throw new EstadoInvalidoException();
		
		else {
			
			int pos = 0;
			for (int i = 0; i < arrayInterno.length; i++) {
				
				if(item.equals(arrayInterno[i])) {
					
					pos = i;
					break;
				}
			}
			
			this.remover(pos);
		}
	}
		
	/**
	 * 	This method removes the element on the specified position, witch is passed
	 * as a parameter.
	 * 
	 * @param posicao The position of the element that is going to be removed.
	 * 
	 * @throws EstadoInvalidoException Exception to be thrown if an invalid position 
	 * is passed as a parameter, or if the internal array is empty.
	 */
	public void remover(int posicao) throws EstadoInvalidoException {

		if (posicao < 0 || this.isEmpty() || (inseridos > 0 && posicao >= inseridos)) throw new EstadoInvalidoException();
		
		else {
			
			for (int i = posicao; i < inseridos - 1; i++) {
				
				arrayInterno[i] = arrayInterno[i + 1];
			}
			
			arrayInterno[inseridos - 1] = null;
			inseridos--; 
		}
	}
	
	/**
	 * 	This method checks if the internal array is empty or not.
	 * 
	 * @return It returns true if the internal array is empty or false
	 * if it isn't.
	 */
	public boolean isEmpty() {
		return inseridos == 0;
	}
	
	/**
	 * This method restarts the internal array.
	 */
	public void limpar() {
		arrayInterno = new Object[ALOCACAO_INICIAL];
		inseridos = 0;
	}
	
	/**
	 * This method shows how many items are inside the internal array.
	 * 
	 * @return The number of items inside the array.
	 */
	public int tamanho() {
		return inseridos;
	}
	
	/**
	 * This auxiliary method checks if an item is inside the array or not.
	 * 
	 * @param item The item that the method is going to look for.
	 * 
	 * @return It return true if the specified item is inside the array, and false
	 * if it isn't.
	 */
	private boolean checarExistencia(Object item) {
		for (Object object : arrayInterno) {
			if(item == object) return true;
		}
		return false;
	}
	
	public int tamanhoTotal() {
		return arrayInterno.length;
	}
	
	private void increaseArray() {
		
		Object[] novo = new Object[arrayInterno.length * 2];
		
		for (int i = 0; i < arrayInterno.length; i++) {
			novo[i] = arrayInterno[i];
		}
		
		arrayInterno = novo;
	}
}