package br.cesed.si.p3.fila.exemplo1;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestFila {

	private Fila fila;
	
	@BeforeEach
	void setUp() {
		
		fila = new Fila();
	}
	
	@Test
	void insertOneElement() throws ElementoInvalidoException {
		
		fila.enqueue("Coelho");
		
		Assert.assertEquals(1, fila.tamanho());
	}
	
	@Test
	void insertFourElements() throws ElementoInvalidoException {
		
		fila.enqueue("Coelho");
		fila.enqueue("Dragão");
		fila.enqueue("Tigre");
		fila.enqueue("Periquito");
		
		Assert.assertEquals(4, fila.tamanho());
	}
	
	@Test
	void insertInvalidElement() {
		
		Assertions.assertThrows(ElementoInvalidoException.class, () -> {
			fila.enqueue(null);
		});
	}
	
	@Test
	void dequeueElement() throws DequeueInvalidoException, ElementoInvalidoException {
		
		fila.enqueue("Periquito");
		fila.enqueue("Coelho");
		fila.enqueue("Dragão");
		
		Assert.assertEquals(3, fila.tamanho());
		Assert.assertEquals("Periquito", fila.dequeue());
		Assert.assertEquals(2, fila.tamanho());
		Assert.assertEquals("Coelho", fila.front());
	}
	
	@Test
	void dequeueOnEmptyList() {
		
		Assertions.assertThrows(DequeueInvalidoException.class, () -> {
			fila.dequeue();
		});
	}
	
	@Test
	void testFrontWithTwoElements() throws ElementoInvalidoException {
		
		fila.enqueue("Coelho");
		fila.enqueue("Dragão");
		
		Assert.assertEquals("Coelho", fila.front());
	}
	
	@Test
	void testFrontWithRemovedFirstElement() throws ElementoInvalidoException, DequeueInvalidoException {
		
		fila.enqueue("Periquito");
		fila.enqueue("Coelho");
		fila.enqueue("Dragão");
		
		fila.dequeue();
		
		Assert.assertEquals("Coelho", fila.front());
	}
	
	@Test
	void testSizeWithDequeuedElements() throws ElementoInvalidoException, DequeueInvalidoException {
		
		fila.enqueue("Periquito");
		fila.enqueue("Coelho");
		fila.enqueue("Dragão");		
		
		fila.dequeue();
		
		Assert.assertEquals(2, fila.tamanho());
	}
}
