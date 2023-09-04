package br.com.samuel.pilha;

public interface Stack<E> {

    int size();

    boolean isEmpty();

    void push(E element);

    E pop();

    E top();

    void rezise(int newSize);
}
