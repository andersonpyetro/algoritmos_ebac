package br.com.pyetro;

public class Pilha {

	private Node topo;

	private class Node {
		int valor;
		Node next;

		Node(int valor) {
			this.valor = valor;
			this.next = null;
		}
	}

	public void push(int valor) {
		Node novoNode = new Node(valor);
		novoNode.next = topo;
		topo = novoNode;

	}

	public int pop() {
		if (isEmpty()) {
			throw new IllegalStateException("Pilha vazia");
		}
		int valor = topo.valor;
		topo = topo.next;
		return valor;
	}

	private boolean isEmpty() {
		return topo == null;
	}

	public int top() {
		if (isEmpty()) {
			throw new IllegalStateException("Pilha vazia");
		}
		return topo.valor;
	}

	public int size() {
		int tamanho = 0;
		Node atual = topo;
		while (atual != null) {
			tamanho++;
			atual = atual.next;
		}
		return tamanho;
	}

	/*
	 * A complexidade de tempo das operações push(), pop() e top() é O(1)
	 * A complexidade de tempo da operação isEmpty() é O(1)
	 * A complexidade de tempo  da operação size() é O(n)
	 * a complexidade de espaço de push, pop, top é O(1)
	 * ja em size é o(n) por conta do loop while
	 */

	public static void main(String[] args) {
		Pilha pilha = new Pilha();
		pilha.push(1);
		pilha.push(2);
		pilha.push(3);
		pilha.push(4);

		System.out.println(pilha.size());

		int valor = pilha.pop();
		System.out.println(valor);

		pilha.pop();

		System.out.println(pilha.isEmpty());
	}

}
