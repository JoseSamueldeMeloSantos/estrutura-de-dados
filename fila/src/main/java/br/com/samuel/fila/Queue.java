package br.com.samuel.fila;

public interface Queue<E> {

    int size();

    boolean isEmpty();

    E front() throws EmptyQueueException;

    void enqueue(E element);

    E dequeue() throws EmptyQueueException;

    void resize(int newSize);
}
