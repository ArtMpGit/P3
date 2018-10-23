package br.cesed.unifacisa.si.p3.deque;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class dequeTest {
	
	private Deque deque = new Deque();
	
	@BeforeEach
	void setUp() {
		
		deque.clean();
	}
	
	@Test
	void insertOneItemFirstTest() throws InvalidElementException {
		
		deque.insertFirst("Coelho");
		
		Assert.assertEquals(1, deque.size());
	}
	
	@Test
	void InsertFourElementsFirst() throws InvalidElementException {
		
		deque.insertFirst("Coelho");
		deque.insertFirst("Dragão");
		deque.insertFirst("Tigre");
		deque.insertFirst("Periquito");
		
		Assert.assertEquals(4, deque.size());
	}
	
	@Test
	void insertOneElementOnEmptyListTest() throws InvalidElementException, InvalidIndexException {
		
		deque.insertLast("Coelho");
		
		Assert.assertEquals(1, deque.size());
		Assert.assertEquals("Coelho", deque.get(0));

	}
	
	@Test
	void testRemoveFirstItem() throws InvalidElementException, EmptyDequeException, InvalidIndexException {
		
		deque.insertFirst("Coelho");
		deque.insertFirst("Dragão");
		deque.insertFirst("Periquito");
		
		Assert.assertEquals(3, deque.size());
		Assert.assertEquals("Periquito", deque.get(0));
		
		deque.removeFirst();

		Assert.assertEquals(2, deque.size());
		Assert.assertEquals("Dragão", deque.get(0));
	}
	
	@Test
	void removeFirstOnEmptyDeque() {
		
		Assertions.assertThrows(EmptyDequeException.class, () -> {
			deque.removeFirst();
		});
	}
	
	@Test
	void removeLastElementTest() throws InvalidElementException, EmptyDequeException, InvalidIndexException {
		
		deque.insertFirst("Periquito");
		deque.insertFirst("Dragão");
		deque.insertFirst("Coelho");
		deque.insertFirst("Tigre");
		
		Assert.assertEquals(4, deque.size());
		Assert.assertEquals("Periquito", deque.get(3));
		
		deque.removeLast();
		
		Assert.assertEquals(3, deque.size());
		Assert.assertEquals("Dragão", deque.get(2));
	}
	
	@Test
	void removeLastWithOneElementTest() throws InvalidElementException, EmptyDequeException, InvalidIndexException {
		
		deque.insertFirst("Periquito");
		
		Assert.assertEquals(1, deque.size());
		Assert.assertEquals("Periquito", deque.get(0));

		
		deque.removeLast();
		
		Assert.assertEquals(0, deque.size());
		Assert.assertEquals(null, deque.get(0));
	}
	
	@Test
	void removeLastOnEmptyDeque() {
		
		Assertions.assertThrows(EmptyDequeException.class, () -> {
			deque.removeLast();
		});
	}
	
	@Test
	void removeMiddleElementByValueTest() throws InvalidElementException, InvalidIndexException {
		
		deque.insertFirst("Coelho");
		deque.insertFirst("Periquito");
		deque.insertFirst("Dragão");
		
		Assert.assertEquals(3, deque.size());
		Assert.assertEquals("Periquito", deque.get(1));
		
		deque.removeByValue("Periquito");
		
		Assert.assertEquals(2, deque.size());
		Assert.assertEquals("Coelho", deque.get(1));
	}
	
	@Test
	void removeFirstElementByValueTest() throws InvalidElementException, InvalidIndexException {
		
		deque.insertFirst("Coelho");
		deque.insertFirst("Tigre");
		deque.insertFirst("Dragão");
		deque.insertFirst("Periquito");
		
		Assert.assertEquals(4, deque.size());
		Assert.assertEquals("Periquito", deque.get(0));
		
		deque.removeByValue("Periquito");
		
		Assert.assertEquals(3, deque.size());
		Assert.assertEquals("Dragão", deque.get(0));
	}
	
	@Test
	void removeLastElementByValueTest() throws InvalidElementException, InvalidIndexException {
		
		deque.insertFirst("Periquito");
		deque.insertFirst("Coelho");
		deque.insertFirst("Tigre");
		deque.insertFirst("Dragão");
		
		Assert.assertEquals(4, deque.size());
		Assert.assertEquals("Periquito", deque.get(3));
		
		deque.removeByValue("Periquito");
		
		Assert.assertEquals(3, deque.size());
		Assert.assertEquals("Coelho", deque.get(2));
	}
	
	@Test
	void RemoveFirstElementByIndexTest() throws InvalidElementException, InvalidIndexException {
		
		deque.insertFirst("Dragão");
		deque.insertFirst("Coelho");
		deque.insertFirst("Periquito");
		
		Assert.assertEquals(3, deque.size());
		Assert.assertEquals("Periquito", deque.get(0));
		
		deque.removeByIndex(0);
		
		Assert.assertEquals(2, deque.size());
		Assert.assertEquals("Coelho", deque.get(0));
	}
	
	@Test
	void RemoveMiddleElementByIndexTest() throws InvalidElementException, InvalidIndexException {
		
		deque.insertFirst("Dragão");
		deque.insertFirst("Periquito");
		deque.insertFirst("Coelho");
		
		Assert.assertEquals(3, deque.size());
		Assert.assertEquals("Periquito", deque.get(1));
		
		deque.removeByIndex(1);
		
		Assert.assertEquals(2, deque.size());
		Assert.assertEquals("Dragão", deque.get(1));
	}
	
	@Test
	void RemoveLastElementByIndexTest() throws InvalidElementException, InvalidIndexException {
		
		deque.insertFirst("Periquito");
		deque.insertFirst("Dragão");
		deque.insertFirst("Coelho");
		
		Assert.assertEquals(3, deque.size());
		Assert.assertEquals("Periquito", deque.get(2));
		
		deque.removeByIndex(2);
		
		Assert.assertEquals(2, deque.size());
		Assertions.assertThrows(InvalidIndexException.class, () -> {
			deque.get(2);
		});
	}
}
