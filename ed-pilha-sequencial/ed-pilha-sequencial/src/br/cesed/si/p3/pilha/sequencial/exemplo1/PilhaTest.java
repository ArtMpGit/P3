package br.cesed.si.p3.pilha.sequencial.exemplo1;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PilhaTest {

	private Pilha pilha;

	@BeforeEach
	void setUp() throws Exception {
		pilha = new Pilha();
	}

	@Test
	public void testeTamanhoPilhaVazia() {
		Assert.assertEquals(0, pilha.tamanho());
	}

	@Test
	public void testeTamanhoAdicionarUmElementoPilha() throws InvalidItemException {
		pilha.push("Elemento 1");
		Assert.assertEquals(1, pilha.tamanho());
	}

	@Test
	public void testeTamanhoAdicionarQuatroElementosPilha() throws InvalidItemException {
		pilha.push("Elemento 1");
		pilha.push("Elemento 2");
		pilha.push("Elemento 3");
		pilha.push("Elemento 4");
		Assert.assertEquals(4, pilha.tamanho());
	}
	
	@Test
	public void testeAdicionarElementoInvalido() {
		
		Assertions.assertThrows(InvalidItemException.class, () -> {
			pilha.push(null);
		});
	}

	@Test
	public void testePopAdicionarUmElementoPilha() throws EmptyStackException, InvalidItemException {
		pilha.push("Elemento 1");
		
		Assert.assertEquals(1, pilha.tamanho());
		Assert.assertEquals("Elemento 1", pilha.pop());
		Assert.assertEquals(0, pilha.tamanho());
	}

	@Test
	public void testePopAdicionarQuatroElementosPilha() throws EmptyStackException, InvalidItemException {
		
		pilha.push("Elemento 1");
		pilha.push("Elemento 2");
		pilha.push("Elemento 3");
		pilha.push("Elemento 4");
		
		Assert.assertEquals(4, pilha.tamanho());
		Assert.assertEquals("Elemento 4", pilha.pop());		
		Assert.assertEquals(3, pilha.tamanho());
	}
	
	@Test
	public void testePopComPilhaVazia() {
		
		Assertions.assertThrows(EmptyStackException.class, () -> {
			pilha.pop();
		});
	}
	
	@Test
	public void testeTopRetorno() throws InvalidItemException, EmptyStackException {
		
		pilha.push("Coelho");
		pilha.push("Dragão");
		
		Assert.assertEquals(2, pilha.tamanho());
		Assert.assertEquals("Dragão", pilha.top());
		Assert.assertEquals(2, pilha.tamanho());
	}
	
	@Test
	public void testeTopPilhaVazia() {
		
		Assertions.assertThrows(EmptyStackException.class, () -> {
			pilha.top();
		});
	}
}
