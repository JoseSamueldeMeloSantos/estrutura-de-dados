package br.com.samuel.pilha;

import java.util.EmptyStackException;

public class ArrayStack<E> implements Stack<E> {


    private int top = -1;
    private final int INIT_SIZE = 1;
    private E[] array;

    public ArrayStack() {
        array = (E[]) new Object[INIT_SIZE];
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public boolean isEmpty() {
        return top < 0;
    }

    @Override
    public void push(E element) {
        if (array.length == this.size()) rezise(array.length * 2);
        array[++top] = element;
    }

    @Override
    public E pop() {
        if (this.size() == 0) throw new EmptyStackException();
        if (this.size() <= array.length / 2) rezise(array.length / 2);
        E e = array[top--];
        return e;
    }

    @Override
    public E top() {
        if (this.size() == 0) throw new EmptyStackException();
        return array[top];
    }

    @Override
    public void rezise(int newSize) {
        E[] newArray = (E[]) new Object[newSize];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }

        array = newArray;
    }

    public static void main(String[] args) {
        ArrayStack<Integer> nums =  new ArrayStack<>();

        nums.push(1);

        System.out.println(nums.top());
        System.out.println(nums.pop());
        //System.out.println(nums.pop());
        System.out.println(nums.isEmpty());
    }
}
