package br.com.samuel.fila;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class TestArrayQueue {

    ArrayQueue<Integer> fila;

    @BeforeEach
    void instanciarQueue() {
        fila = new ArrayQueue<>();
    }


    @Test
    void testeEnqueue() {
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




    }
}
