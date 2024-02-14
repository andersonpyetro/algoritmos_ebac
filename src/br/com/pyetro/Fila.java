package br.com.pyetro;

public class Fila {

	private Node frente;
	private Node tras;

	private class Node {
		int valor;
		Node next;

		Node(int valor) {
			this.valor = valor;
			this.next = null;

		}
	}

	public void enqueue(int valor) {
		Node novoNode = new Node(valor);
		if (tras != null) {
			tras.next = novoNode;
		}
		tras = novoNode;
		if (frente == null) {
			frente = tras;
		}
	}

	public int dequeue() {
		if (isEmpty()) {
			throw new IllegalStateException("Fila vazia");
		}

		int valor = frente.valor;
		frente = frente.next;
		if (frente == null) {
			tras = null;
		}
		return valor;
	}

	private boolean isEmpty() {

		return frente == null;
	}

	private int rear() {
		if (isEmpty()) {
			throw new IllegalStateException("Fila vazia");
		}
		return tras.valor;
	}

	private int front() {
		if (isEmpty()) {
			throw new IllegalStateException("Fila vazia");
		}
		return tras.valor;

	}

	private int size() {
		int tamanho = 0;
		Node atual = frente;
		while (atual != null) {
			tamanho++;
			atual = atual.next;
		}
		return tamanho;
	}
	
	/*
	 * A complexidade de tempo e espaço de enqueue, dequeue, rear, front e isempty é de O(1)
	 * no caso de size, a complexidade de tempo é O(n) e a de espaço é O(1)
	 */

	public static void main(String[] args) {

		Fila fila = new Fila();

		fila.enqueue(1);
		fila.enqueue(2);
		fila.enqueue(3);

		System.out.println(fila.size());

		int valor = fila.dequeue();
		System.out.println(valor);

		System.out.println(fila.front());

		fila.dequeue();
		fila.dequeue();

		System.out.println(fila.isEmpty());

	}

}
