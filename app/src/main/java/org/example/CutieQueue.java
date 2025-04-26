package org.example;

public class CutieQueue {
    private final Cutie[] queueArray;
    private int front;
    private int rear;
    private int currentSize;
    private final int maxSize;

    public CutieQueue(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Queue size must be positive");
        }
        this.maxSize = size;
        this.queueArray = new Cutie[maxSize];
        this.front = 0;
        this.rear = -1;
        this.currentSize = 0;
    }

    public void enqueue(Cutie cutie) {
        if (cutie == null) {
            throw new IllegalArgumentException("Cannot enqueue null Cutie");
        }
        if (isFull()) {
            throw new IllegalStateException(
                String.format("Queue is full (capacity: %d). Cannot enqueue '%s'", 
                maxSize, cutie.description())
            );
        }
        
        rear = (rear + 1) % maxSize;
        queueArray[rear] = cutie;
        currentSize++;
    }

    public boolean tryEnqueue(Cutie cutie) {
        if (cutie == null || isFull()) {
            return false;
        }
        enqueue(cutie);
        return true;
    }

    public Cutie dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty. Cannot dequeue.");
        }
        
        Cutie removedCutie = queueArray[front];
        queueArray[front] = null;
        front = (front + 1) % maxSize;
        currentSize--;
        return removedCutie;
    }

    public int size() {
        return currentSize;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize == maxSize;
    }

    public int capacity() {
        return maxSize;
    }
}
