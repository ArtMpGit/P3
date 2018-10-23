package br.cesed.si.p3.ed.encadeada.lista;

public class ListaEncadeada {

	private Conta primeiroElemento; //cabeça
	
	private int inseridos;
	
	/**
	 * This method adds a new account at the end of the linked list.
	 * 
	 * @param c Thats the new account that the user wants to add.
	 * 
	 * @throws ContaInvalidaException An exception to be throws if the user try to add an invalid account.
	 */
	public void adicionar(Conta c) throws ContaInvalidaException {
		
		if(c == null) throw new ContaInvalidaException();
	
		else {
			
			if(primeiroElemento == null) {
				primeiroElemento = c;
			} else {
				
				Conta temp = primeiroElemento;
				
				while(temp.getProximo() != null) {
					temp = temp.getProximo();
				}
				
				//chegou até o fim da lista
				temp.setProximo(c);
			}
			
			inseridos++;
		}
	}
	
	/**
	 * This method runs through the linked list until it reaches the element on the desired
	 * position, witch is passed as a parameter.
	 * 
	 * @param posicao The position of the element that the user wants to get.
	 * 
	 * @return The desired element of the linked list.
	 * 
	 * @throws PosicaoInvalidaException Exception to be thrown if the user passes an
	 * invalid position as a parameter.
	 */
	public Conta get(int posicao) throws PosicaoInvalidaException {
		
		if(posicao < 0 || posicao >= inseridos) throw new PosicaoInvalidaException();
		
		else {
			
			Conta temp = primeiroElemento;
			for (int i = 0; i < posicao; i++) {
				
				if(i != posicao) {
					
					temp = temp.getProximo();
				}
			}
			
			return temp;
		}
	}
	
	/**
	 * This method removes an specific element from the linked list. The desired element
	 * is passes as a parameter.
	 * 
	 * @param c The element that the user wants to remove.
	 * 
	 * @throws ContaInvalidaException An exception to be thrown if the user passes
	 * an invalid element as a parameter.
	 */
	public void remover(Conta c) throws ContaInvalidaException {
		
		if(c == null || !this.accountExists(c) || inseridos == 0) {
			throw new ContaInvalidaException();
		}
		
		else {
			
			if(c.equals(primeiroElemento)) {
				
				primeiroElemento = primeiroElemento.getProximo();
				inseridos--;
			} 
			
			else {
				
				Conta temp = primeiroElemento;
				while(temp.getProximo() != c) {
					temp = temp.getProximo();
				}
				
				temp.setProximo(c.getProximo());
				inseridos--;
			}
		}
		
	}
	
	/**
	 * This method also removes an specific element from the linked list. The method receives
	 * the position of the element that needs to be removed as its parameter. 
	 * 
	 * @param pos The position of the element that needs to be removed from the linked list.
	 * 
	 * @throws PosicaoInvalidaException Exception to be thrown if the user passes an invalid
	 * position as the method parameter.
	 * 
	 * @throws ContaInvalidaException Exception to be thrown on another method that is called
	 * inside this one. It checks if the desired element that is going to be removed is valid.
	 */
	public void remover(int pos) throws PosicaoInvalidaException, ContaInvalidaException {
		
		if(pos < 0 || pos >= inseridos) {
			
			throw new PosicaoInvalidaException();
		}
		
		else {
			
			if(pos == 0) {
				
				primeiroElemento = primeiroElemento.getProximo();
				inseridos--;
			}
			
			else {
				
				if(pos == (inseridos - 1)) {
					
					Conta temp = this.get(pos);
					temp = null;
					inseridos--;
				}
				
				else {
					
					Conta temp = primeiroElemento;
					for (int i = 0; i < (pos - 1); i++) {
						temp = temp.getProximo();
					}
					
					this.remover(temp);
				}				
			}
		}

	}
	
	/**
	 * This method returns the number of items inside the linked list.
	 * 
	 * @return The number of items inside the linked list.
	 */
	public int tamanho() {
		return inseridos;
	}
	
	/**
	 * Auxiliary method that checks if an element is actually present in the linked list.
	 * 
	 * @param c The element that the method is going to search for.
	 * 
	 * @return It return true if the element is on the list and false if it isn't.
	 * 
	 */
	public boolean accountExists(Conta c) {
		
		boolean exist = false;
		
		if(c.equals(primeiroElemento)) {
			exist = true;
		}
		
		else {
			
			Conta temp = primeiroElemento;
			while(temp.getProximo() != null) {
				if(c.equals(temp.getProximo())) {
					exist = true;
					break;
				}
				
				temp = temp.getProximo();
			}
		}
		
		return exist;
	}
	
	/**
	 * Method that checks if the linked list is empty
	 * 
	 * @return It return true if the list is empty and false if it isn't.
	 */
	public boolean isEmpty() {
		return inseridos == 0;
	}
}
