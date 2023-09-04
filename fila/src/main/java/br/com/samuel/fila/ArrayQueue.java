package br.com.samuel.fila;

public class ArrayQueue<E> implements Queue<E> {

    private int f = 0;
    private int r = 0;
    private int INIT_SIZE = 1_000;
    private E[] array;

    public ArrayQueue() {
        array = (E[]) new Object[INIT_SIZE];
    }

    @Override
    public int size() {
        return (array.length - f + r) % array.length;
    }

    @Override
    public boolean isEmpty() {
        return r == f;
    }

    @Override
    public E front() throws EmptyQueueException {
        if (isEmpty()) throw new EmptyQueueException();
        return array[f];
    }

    @Override
    public void enqueue(E element) {
        if (this.size() == array.length - 1)
            resize(array.length * 2);//para redimensionar

        array[r] = element;
        r = (r + 1) % array.length;
    }

    @Override
    public E dequeue() throws EmptyQueueException {
        if (isEmpty()) throw new EmptyQueueException();
        if (size() == array.length / 4) resize(array.length / 2);
        E temp = array[f];
        array[f] = null;
        f = (f + 1) % array.length;
        return temp;
    }

    @Override
    public void resize(int newSize) {
        assert newSize >= this.size();
        E[] newArray = (E[]) new Object[newSize];
        for (int i = 0; i < array.length; i++){
            newArray[i] = array[(f + i) % array.length];
        }

        f = 0;
        r = this.size();
        array = newArray;
    }

    public int getArraySize() {return array.length;}

    public E last() {
        return array[--r];
    }


    public static void main(String[] args) {
        ArrayQueue<Integer> fila = new ArrayQueue<>();

        fila.enqueue(1);
        fila.enqueue(2);
        fila.enqueue(3);
        fila.enqueue(4);
        fila.enqueue(5);
        fila.enqueue(6);
        fila.enqueue(7);
        fila.enqueue(8);
        fila.enqueue(9);
        fila.enqueue(10);

        System.out.println(fila.size());
        System.out.println(fila.front());
        System.out.println(fila.isEmpty());
        System.out.println(fila.getArraySize());
        fila.dequeue();
        System.out.println(fila.front());
        System.out.println(fila.last());
        //System.out.println(fila);
    }

}
