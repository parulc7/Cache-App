package com.example.cacheapp.datastructures;

import lombok.Getter;

@Getter
public class DoublyLinkedListNode<E> {
    DoublyLinkedListNode next;
    DoublyLinkedListNode previous;
    E element;

    public DoublyLinkedListNode(E element){
        this.next = null;
        this.previous = null;
        this.element = element;
    }
}
