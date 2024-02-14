package br.com.pyetro;

public class HashMap {

	private final int TAMANHO = 10;
	private Node[] tabela;

	private class Node {
		int chave;
		int valor;
		Node next;

		Node(int chave, int valor) {
			this.chave = chave;
			this.valor = valor;
			this.next = null;
		}

	}

	public HashMap() {
		tabela = new Node[TAMANHO];
	}
	/*
	 * Escolhi implementar a função hash através da divisão simples. ela pega a chave e divide pelo tamanho da tabela
	 * retornando o resultado. é fácil de implementar e é eficiente para um mapa hash com tamanho fixo, como é o caso 
	 * do desafio
	 */

	private int hash(int chave) {
		return chave % TAMANHO;
	}
	
	public void put(int chave, int valor) {
		int indice = hash(chave);
		Node novoNode = new Node(chave, valor);
		
		if(tabela[indice] == null) {
			tabela[indice] = novoNode;
		} else {
			Node atual = tabela[indice];
			while(atual != null) {
				if(atual.chave == chave) {
					atual.valor = valor;
					return;
				}
				atual = atual.next;
			}
			atual.next = novoNode;
			
		}
	}
	
	public int get(int chave) {
		int indice = hash(chave);
		Node atual = tabela[indice];
		
		while(atual != null) {
			if(atual.chave == chave) {
				return atual.valor;
			}
			atual = atual.next;
		}
		return -1;
	}
	
	public void delete (int chave) {
		int indice = hash(chave);
		Node anterior = null;
		Node atual = tabela[indice];
		
		while (atual != null ) {
			if(atual.chave == chave) {
				tabela[indice] = atual.next;
			} else {
				anterior.next = atual.next;
			}
			return;
			
		}
		anterior = atual;
		atual = atual.next;
	}
	
	public void clear() {
		for(int i = 0; i < TAMANHO; i++) {
			tabela[i] = null;
		}
	}
	
	public static void main(String[] args) {
		
        HashMap mapa = new HashMap();

        mapa.put(1, 2);
        mapa.put(2, 3);
        mapa.put(3, 4);

        System.out.println(mapa.get(1));

        mapa.delete(2);

        System.out.println(mapa.get(2)); 

        mapa.clear();

        System.out.println(mapa.get(1)); 
    }

}
