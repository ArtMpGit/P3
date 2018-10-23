package br.cesed.si.p3.ed.encadeada.lista;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ListaEncadeadaTest {
	
	private ListaEncadeada listaEncadeada;
	private Conta conta1 = new Conta(1, 1, "Coelho");
	private Conta conta2 = new Conta(2, 2, "Dragão");
	private Conta conta3 = new Conta(3, 3, "Periquito");
	
	@BeforeEach
	void setUp() {	
		listaEncadeada = new ListaEncadeada();
	}
	
	@Test
	void testAddItems() throws ContaInvalidaException {
		
		listaEncadeada.adicionar(conta1);
		listaEncadeada.adicionar(conta2);
		listaEncadeada.adicionar(conta3);
		
		Assert.assertEquals(3, listaEncadeada.tamanho());
	}
	
	
	@Test
	void addInvalidItem() {
		
		Assertions.assertThrows(ContaInvalidaException.class, () -> {
			listaEncadeada.adicionar(null);
		});
	}
	
	@Test
	void testGetItem() throws PosicaoInvalidaException, ContaInvalidaException {
		
		listaEncadeada.adicionar(conta1);
		listaEncadeada.adicionar(conta2);
		listaEncadeada.adicionar(conta3);
		
		Assert.assertEquals(conta1, listaEncadeada.get(0));
		Assert.assertEquals(conta3, listaEncadeada.get(2));
		Assert.assertEquals(conta2, listaEncadeada.get(1));
	}
	
	@Test
	void testGetPosicaoInvalida() throws ContaInvalidaException {
		
		Assertions.assertThrows(PosicaoInvalidaException.class, () -> {
			listaEncadeada.get(-1);
		});
		
		listaEncadeada.adicionar(new Conta(1, 1, "Coelho"));
		listaEncadeada.adicionar(new Conta(2, 2, "Dragão"));
		
		Assertions.assertThrows(PosicaoInvalidaException.class, () -> {
			listaEncadeada.get(2);
		});
	}
	
	@Test
	void testRemoveFirstElement() throws ContaInvalidaException, PosicaoInvalidaException {
		
		listaEncadeada.adicionar(conta1);
		listaEncadeada.adicionar(conta2);
		
		listaEncadeada.remover(conta1);
		Assert.assertEquals(conta2, listaEncadeada.get(0));
	}
	
	@Test
	void removeMiddleElement() throws ContaInvalidaException, PosicaoInvalidaException {
		
		listaEncadeada.adicionar(conta1);
		listaEncadeada.adicionar(conta2);
		listaEncadeada.adicionar(conta3);

		Assert.assertEquals(conta2, listaEncadeada.get(1));

		listaEncadeada.remover(conta2);
		
		Assert.assertEquals(conta3, listaEncadeada.get(1));
	}
	
	@Test
	void removeLastElement() throws PosicaoInvalidaException, ContaInvalidaException {
		
		listaEncadeada.adicionar(conta1);
		listaEncadeada.adicionar(conta2);
		listaEncadeada.adicionar(conta3);
		
		Assert.assertEquals(conta3, listaEncadeada.get(listaEncadeada.tamanho() - 1));
		
		listaEncadeada.remover(conta3);
		
		Assertions.assertThrows(PosicaoInvalidaException.class, () -> {
			listaEncadeada.get(2);
		});
		
		Assert.assertEquals(conta2, listaEncadeada.get(listaEncadeada.tamanho() - 1));
	}
	
	@Test 
	void removeUnexistingItem() throws ContaInvalidaException {
		
		listaEncadeada.adicionar(new Conta(1, 1, "Coelho"));
		
		Assertions.assertThrows(ContaInvalidaException.class, () -> {
			listaEncadeada.remover(new Conta(2, 2, "Dragão"));
		});
	}
	
	@Test
	void removeFirstElementByPosition() throws ContaInvalidaException, PosicaoInvalidaException {
		
		listaEncadeada.adicionar(conta1);
		listaEncadeada.adicionar(conta2);
		
		Assert.assertEquals(conta1, listaEncadeada.get(0));
		
		listaEncadeada.remover(0);
		
		Assert.assertEquals(conta2, listaEncadeada.get(0));
	}
	
	@Test
	void removeMiddleElementByPosition() throws ContaInvalidaException, PosicaoInvalidaException {
		
		listaEncadeada.adicionar(conta1);
		listaEncadeada.adicionar(conta3);
		listaEncadeada.adicionar(conta2);
		
		Assert.assertEquals(conta3, listaEncadeada.get(1));
		
		listaEncadeada.remover(1);
		
		Assert.assertEquals(conta2, listaEncadeada.get(1));
	}
	
	@Test
	void removeLastElementByPosition() throws ContaInvalidaException, PosicaoInvalidaException {
		
		listaEncadeada.adicionar(conta1);
		listaEncadeada.adicionar(conta2);
		listaEncadeada.adicionar(conta3);
		
		Assert.assertEquals(conta3, listaEncadeada.get(listaEncadeada.tamanho() - 1));
		
		listaEncadeada.remover(listaEncadeada.tamanho() - 1);
		
		Assert.assertEquals(conta2, listaEncadeada.get(listaEncadeada.tamanho() - 1));
	}
}
