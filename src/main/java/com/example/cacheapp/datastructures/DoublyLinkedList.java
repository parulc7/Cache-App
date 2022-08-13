package com.example.cacheapp.datastructures;

import java.util.NoSuchElementException;

public class DoublyLinkedList<E> {
    DoublyLinkedListNode<E> dummyHead;
    DoublyLinkedListNode<E> dummyTail;

    public DoublyLinkedList(){
        // Custom implementation of doubly linked list with first and last pointers
        this.dummyHead = new DoublyLinkedListNode<>(null);
        this.dummyTail = new DoublyLinkedListNode<>(null);

        dummyHead.next = dummyTail;
        dummyTail.previous = dummyHead;
    }

    // dh <-> dt
    // dh <-> node <-> dt
    public void addNodeToLast(DoublyLinkedListNode node){
        DoublyLinkedListNode tailPrevious = dummyTail.previous;
        tailPrevious.next = node;
        node.next = dummyTail;
        dummyTail.previous = node;
        node.previous = tailPrevious;
    }

    public void addNodeToFirst(DoublyLinkedListNode node){
        DoublyLinkedListNode headNext = dummyHead.next;
        dummyHead.next = node;
        node.previous = dummyHead;
        node.next = headNext;
        headNext.previous = node;
    }

    public void removeNode(DoublyLinkedListNode node){
        if(node==null){
            return;
        }
        DoublyLinkedListNode nodeNext = node.next;
        DoublyLinkedListNode nodePrevious = node.previous;
        nodePrevious.next = nodeNext;
        nodeNext.previous = nodePrevious;
        node.next = null;
        node.previous = null;
    }

    public boolean isEmptyList(){
        return (dummyHead.next==dummyTail);
    }

    public DoublyLinkedListNode getFirstNode() throws NoSuchElementException {
        if(isEmptyList()){
            return null;
        }
        return dummyHead.next;
    }

    public DoublyLinkedListNode getLastNode() throws NoSuchElementException{
        if(isEmptyList()){
            return null;
        }
        return dummyTail.previous;
    }
}
