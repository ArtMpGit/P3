package br.cesed.si.p3.pilha.sequencial.exemplo1;

import org.junit.Assert; 
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
	public void testeTamanhoAdicionarUmElementoPilha() {
		pilha.push("Elemento 1");
		Assert.assertEquals(1, pilha.tamanho());
	}

	@Test
	public void testeTamanhoAdicionarQuatroElementosPilha() {
		pilha.push("Elemento 1");
		pilha.push("Elemento 2");
		pilha.push("Elemento 3");
		pilha.push("Elemento 4");
		Assert.assertEquals(4, pilha.tamanho());
	}

	@Test
	public void testePopAdicionarUmElementoPilha() throws EmptyStackException {
		pilha.push("Elemento 1");
		Assert.assertEquals("Elemento 1", pilha.pop());
	}

	@Test
	public void testePopAdicionarQuatroElementosPilha() throws EmptyStackException {
		pilha.push("Elemento 1");
		pilha.push("Elemento 2");
		pilha.push("Elemento 3");
		pilha.push("Elemento 4");
		Assert.assertEquals("Elemento 4", pilha.pop());
	}
	
	@Test
	public void testePopRetornoElemento() {
		
		pilha.push("Elemento 1");
		
	}
	
}
