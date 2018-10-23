package br.cesed.unifacisa.si.p3.deque;

public class Deque {
	
	private static final int INITIAL_SIZE = 3;
	private Object[] array = new Object[INITIAL_SIZE];
	private int inseridos;
	
	/**
	 * Inserts an element (method parameter) on the first position of the internal array
	 * @param e Element to be inserted
	 * @throws InvalidElementException Exception to be thrown if the element 'e' is invalid
	 */
	public void insertFirst(Object e) throws InvalidElementException {
		
		if(e == null) throw new InvalidElementException();
		
		else {
			
			if(!this.isEmpty()) {
				
				if(array.length == inseridos) {
					
					this.increaseArray();
				}
				
				for (int i = inseridos; i > 0; i--) {
					
					array[i] = array[i - 1];
				}
				
				array[0] = e;
				inseridos++;
			}
			
			else {
				
				array[0] = e;
				inseridos++;
			}
		}
	}
	
	/**
	 * Inserts an element at the end of the array
	 * @param e Element to be inserted on the array
	 * @throws InvalidElementException Exception to be throw if the element 'e' is invalid
	 */
	public void insertLast(Object e) throws InvalidElementException {
		
		if(e == null) throw new InvalidElementException();
		
		else {
			
			if(array.length == inseridos) {
				this.increaseArray();
			}
			
			array[inseridos] = e;
			inseridos++;
		}
	}
	
	/**
	 * This method removes the element on the first position of the internal array
	 * @throws EmptyDequeException Exception to be thrown if the user tries to remove an element and the internal array is empty
	 */
	public void removeFirst() throws EmptyDequeException {
		
		if(this.isEmpty()) throw new EmptyDequeException();
		
		else {
			
			for (int i = 0; i < (inseridos - 1); i++) {
				array[i] = array[i + 1];
			}
			
			array[inseridos - 1] = null;
			inseridos--;
		}
	}
	
	/**
	 * This method removes the last element of the internal array
	 * @throws EmptyDequeException Exception to be thrown if the user tries to remove an element and the internal array is empty
	 */
	public void removeLast() throws EmptyDequeException {
		
		if(this.isEmpty()) throw new EmptyDequeException();
		
		else {
			
			array[inseridos - 1] = null;
			inseridos--;
		}
	}
	
	/**
	 * This method removes an specific element, witch is passed as a parameter, of the internal array;
	 * @param e Specific element that the user wants to remove  
	 * @throws InvalidElementException Exception to be throw if the parameter is invalid 
	 * @throws InvalidIndexException 
	 */
	public void removeByValue(Object e) throws InvalidElementException, InvalidIndexException {
		
		if(e == null) throw new InvalidElementException();
		
		else {
			
			int pos = 0;
			for (int i = 0; i < array.length; i++) {
				if(array[i].equals(e)) {
					
					pos = i;
					break;
				}
			}
			
			this.removeByIndex(pos);
		}
	}
	
	/**
	 * This method removes an specific element by passing its position as a parameter
	 * @param pos Position of the element that the user wants to remove
	 * @throws InvalidIndexException Exception to be thrown if the parameter is invalid  
	 */
	public void removeByIndex(int pos) throws InvalidIndexException {
		
		if(pos < 0 || ( inseridos > 0 && pos >= inseridos)) throw new InvalidIndexException();
		
		else {
			
			for (int i = pos; i < (inseridos - 1); i++) {
				
				array[i] = array[i + 1]; 
			}
			inseridos--;
			array[inseridos] = null;
		}
	}
	
	/**
	 * This method returns the number of inserted items inside the internal array
	 * @return
	 */
	public int size() {
		
		return inseridos;
	}
	
	/**
	 * This method checks if the internal array is empty
	 * @return
	 */
	public boolean isEmpty() {
		
		return inseridos == 0;
	}
	
	/**
	 * This method returns an element on an specific position, witch is passes as a parameter
	 * @param index The position of the element that the user wants to return
	 * @return Returns the desired element from the array 
	 * @throws InvalidIndexException 
	 */
	public Object get(int index) throws InvalidIndexException {
		
		if(index < 0 || (inseridos > 0 && index >= inseridos)) throw new InvalidIndexException(); 
		
		else return this.array[index];
	}
	
	/**
	 * Auxiliary method that increases the size of the internal array when it reaches its maximum capacity.
	 * It is used to avoid code repetition.
	 */
	private void increaseArray() {
		
		Object[] copy = new Object[array.length * 2];
		
		for (int i = 0; i < array.length; i++) {
			copy[i] = array[i];
		}
		
		array = copy;
	}
	
	/**
	 * Auxiliary method that resets the array.
	 */
	public void clean() {
		
		this.array = new Object[INITIAL_SIZE];
	}


}
