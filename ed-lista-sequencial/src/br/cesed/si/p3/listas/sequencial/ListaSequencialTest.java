package br.cesed.si.p3.listas.sequencial;

import org.junit.Assert; 
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListaSequencialTest {

	private ListaSequencial listaSequencial = new ListaSequencial();
	
	@BeforeEach
	void setUp() throws Exception {
		listaSequencial.limpar();
	}

	@Test
	void testAddQuatroItems() throws EstadoInvalidoException {

		listaSequencial.adicionar("Item 1");
		listaSequencial.adicionar("Item 2");
		listaSequencial.adicionar("Item 3");
		listaSequencial.adicionar("Item 4");

		Assert.assertEquals("Item 1", listaSequencial.obter(0));
		Assert.assertEquals("Item 2", listaSequencial.obter(1));
		Assert.assertEquals("Item 3", listaSequencial.obter(2));
		Assert.assertEquals("Item 4", listaSequencial.obter(3));
		Assert.assertEquals(4, listaSequencial.tamanho());
	}

	@Test
	void testAddValorInvalido() {

		Assertions.assertThrows(EstadoInvalidoException.class, () -> {
			listaSequencial.adicionar(null);
		});
	}

	@Test
	void testAddPosicao() throws EstadoInvalidoException {

		listaSequencial.adicionar("Item 1",0);
		listaSequencial.adicionar("Item 2",1);

		Assert.assertEquals("Item 1", listaSequencial.obter(0));
		Assert.assertEquals("Item 2", listaSequencial.obter(1));
		Assert.assertEquals(2, listaSequencial.tamanho());
	}
	
	@Test
	void testAddPosicaoValorInvalido() {

		Assertions.assertThrows(EstadoInvalidoException.class, () -> {
			listaSequencial.adicionar(null,0);
		});
	}

	@Test
	void testAddPosicaoInvalida() {

		Assertions.assertThrows(EstadoInvalidoException.class, () -> {
			listaSequencial.adicionar("Item 1",-1);
		});
	}

	@Test
	void testTamanhoListaVazia() {
		
		Assert.assertEquals(0, listaSequencial.tamanho());
	}
	
	@Test
	void testObter() throws EstadoInvalidoException {
		listaSequencial.adicionar("item1");
		
		Assert.assertEquals("item1", listaSequencial.obter(0));
	}
	
	@Test
	void testObterInvalido() throws EstadoInvalidoException {
		
		Assertions.assertThrows(EstadoInvalidoException.class, () -> {
			listaSequencial.obter(-1);
		});
		
		Assertions.assertThrows(EstadoInvalidoException.class, () -> {
			listaSequencial.obter(0);
		});
		
		listaSequencial.adicionar("Coelho");
		
		Assertions.assertThrows(EstadoInvalidoException.class, () -> {
			listaSequencial.obter(1);
		});
	}
	@Test
	void testRemoverPorItem() throws EstadoInvalidoException {
		
		listaSequencial.adicionar("item1");
		listaSequencial.adicionar("item2");
		listaSequencial.adicionar("item3");
		listaSequencial.adicionar("item4");
		
		Assert.assertEquals("item1", listaSequencial.obter(0));
		Assert.assertEquals("item2", listaSequencial.obter(1));
		Assert.assertEquals("item3", listaSequencial.obter(2));
		Assert.assertEquals("item4", listaSequencial.obter(3));
		Assert.assertEquals(4, listaSequencial.tamanho());
		
		listaSequencial.remover("item1");
		listaSequencial.remover("item3");
		
		Assert.assertEquals(2, listaSequencial.tamanho());
		Assert.assertEquals("item2", listaSequencial.obter(0));
	}
	
	@Test
	void testRemoverPorItemInvalido() throws EstadoInvalidoException{
		Assertions.assertThrows(EstadoInvalidoException.class,() -> {
			listaSequencial.remover(null);
		});
	}
	
	@Test
	void testRemoverPorPosicao() throws EstadoInvalidoException {
		
		listaSequencial.adicionar("item1");
		listaSequencial.adicionar("item2");

		
		Assert.assertEquals("item1", listaSequencial.obter(0));
		Assert.assertEquals("item2", listaSequencial.obter(1));
		Assert.assertEquals(2, listaSequencial.tamanho());
		
		listaSequencial.remover(1);
		
		Assert.assertEquals("item1", listaSequencial.obter(0));
		
		Assertions.assertThrows(EstadoInvalidoException.class, () -> {
			listaSequencial.obter(1);
		});
		
		Assert.assertEquals(1, listaSequencial.tamanho());
	}
	
	@Test
	void removerPrimeiraPosicao() throws EstadoInvalidoException {
		
		listaSequencial.adicionar("item1");
		listaSequencial.adicionar("item2");
		
		Assert.assertEquals(2, listaSequencial.tamanho());
		
		listaSequencial.remover(0);
		
		Assert.assertEquals("item2", listaSequencial.obter(0));
		Assert.assertEquals(1, listaSequencial.tamanho());
	}
	
	@Test
	void testRemoverPorPosicaoInvalida() throws EstadoInvalidoException{
		
		Assertions.assertThrows(EstadoInvalidoException.class,() -> {
			listaSequencial.remover(-1);
		});
		
		Assertions.assertThrows(EstadoInvalidoException.class,() -> {
			listaSequencial.remover(4);
		});
	}
	
	@Test
	void testLimpar() throws EstadoInvalidoException {
		
		listaSequencial.adicionar("item1");
		
		Assert.assertEquals("item1", listaSequencial.obter(0));
		Assert.assertEquals(1, listaSequencial.tamanho());
		
		listaSequencial.limpar();
		
		Assertions.assertThrows(EstadoInvalidoException.class, () -> {
			Assert.assertEquals(null, listaSequencial.obter(0));
		});
		
		Assert.assertEquals(true, listaSequencial.isEmpty());
	}
	
	@Test
	void testTamanho() throws EstadoInvalidoException {
		
		listaSequencial.adicionar("item1");
		listaSequencial.adicionar("item2");
		listaSequencial.adicionar("item3");
		
		Assert.assertEquals("item1", listaSequencial.obter(0));
		Assert.assertEquals("item2", listaSequencial.obter(1));
		Assert.assertEquals("item3", listaSequencial.obter(2));
		Assert.assertEquals(3, listaSequencial.tamanho());
	}
	
	@Test
	void testIsEmpty(){
		Assert.assertEquals(true, listaSequencial.isEmpty());
	}
	
	@Test
	void removerItemInexistente() throws EstadoInvalidoException {
		
		listaSequencial.adicionar("Coelho");
		listaSequencial.adicionar("Dragão");
		
		Assertions.assertThrows(EstadoInvalidoException.class, () -> {
			listaSequencial.remover("Periquito");
		});
	}

}
