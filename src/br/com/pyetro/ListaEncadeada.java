package br.com.pyetro;

public class ListaEncadeada<T> {

	private Node head;

	private class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	/*
	 * a complexidade de espaço é o mesmo porque apenas um nó é criado, então o(1)
	 * complexidade de tempo é o(1) se a lista estiver vazia e o(n) se precisar percorrer até o último nó
	 * 
	 */
	public void push(int valor) {
		Node novoNode = new Node(valor);
		if (head == null) {
			head = novoNode;
		} else {
			Node nodeAtual = head;
			while (nodeAtual.next != null) {
				nodeAtual = nodeAtual.next;
			}

			nodeAtual.next = novoNode;
		}
	}

	/*
	 * se o primeiro nó for vazio, é lançada uma exception de lista vazia, portanto
	 * não é possível remover o nó. se o próximo nó após a head for igual a nulo, é
	 * armazenada na variável o valor da head, depois a head recebe nulo e
	 * retornamos o seu valor. por último, é feita a verificação dos dois nos
	 * adiante, para garantir que pegue o penúltimo e o último nó. a complexidade de tempo é o(1) se tiver apenas um nó
	 * e o(n) quando é preciso percorrer até o penultimo nó. a complexidade de espaço é sempre o(1) porque apenas um é removido.
	 */

	public int pop() {
		if (head == null) {
			throw new IllegalStateException("Lista vazia.");
		}
		if (head.next == null) {
			int data = head.data;
			head = null;
			return data;
		}
		Node atual = head;
		while (atual.next.next != null) {
			atual = atual.next;
		}
		int data = atual.next.data;
		atual.next = null;
		return data;
	}

	/*
	 * joga uma exception caso o índice seja menor que zero ou maior que o tamanho
	 * da lista encadeada. aqui a complexidade de tempo é o(1) depois ele verifica se a
	 * posição do índice é igual a zero, se for, ele acrescenta o inteiro no índice
	 * zero, a complexidade também é O(1) caso o índice 0 já esteja preenchido, ele
	 * percorre a lista para adicionar o próximo inteiro, como o for vai percorrer a
	 * lista até index - 1, a complexidade de tempo, a depender do tamanho da lista é
	 * O(index), se o iíndice for próximo ao final da lista, a complexidade tempo é o(n)
	 * a complexidade de espaço é sempre o(1) porque apenas um nó é criado
	 */

	public void insert(int index, int valor) {
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException("Índice inválido");
		}
		if (index == 0) {
			Node novoNode = new Node(valor);
			novoNode.next = head;
			head = novoNode;
		} else {
			Node atual = head;
			for (int i = 0; i < index - 1; i++) {
				atual = atual.next;
			}
			Node novoNode = new Node(valor);
			novoNode.next = atual.next;
			atual.next = novoNode;
		}
	}

	/*
	 * metodo para saber o tamanho da lista encadeada, com complexidade de tempo O(n)
	 * e a complexidade de espaço é o(1) porque apenas uma variável de contagem é utilizada
	 */

	private int size() {
		int count = 0;
		Node atual = head;
		while (atual != null) {
			count++;
			atual = atual.next;
		}
		return count;
	}
	
	/*
	 * joga uma exception caso o índice seja menor que zero ou maior que o tamanho
	 * da lista encadeada. aqui a complexidade de tempo é o(1) depois ele verifica se a
	 * posição do índice é igual a zero, se for, ele apaga o inteiro que está no indice zero e coloca o próximo como head,
	 * nesse caso, a complexidade de tempo é o(1) porque não precisa percorrer a lista para fazer a verificação.
	 * no for, a complexidade é o(n).
	 *  a complexidade de espaço é o(1)
	 */

	public void remove(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("Índice inválido");
		}

		if (index == 0) {
			head = head.next;
		} else {
			Node atual = head;
			for (int i = 0; i < index - 1; i++) {
				atual = atual.next;
			}
			atual.next = atual.next.next;
		}
	}
	
	/*
	 * se o indice indicado for o 0, a complexidade de tempo o(1), caso contrário, é para  o(n) 
	 * a complexidade de espaço é o(1)
	 */

	public int elementAt(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("Índice inválido");
		}
		Node atual = head;
		for (int i = 0; i < index; i++) {
			atual = atual.next;
		}
		return atual.data;
	}/*
	 * complexidade de tempo é o(n) e a complexidade de espaço é o(1) porque apenas uma variável para o nó é utilizada
	 */

	public void printList() {
		Node atual = head;
		while (atual != null) {
			System.out.print(atual.data + " ");
			atual = atual.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ListaEncadeada lista = new ListaEncadeada();

		lista.push(1);
		lista.push(2);
		lista.push(3);
		lista.push(4);
		lista.push(5);
		lista.push(6);

		lista.printList();

	}

}
