package com.javastream;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello");

        MyLinkList l = new MyLinkList();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        System.out.println("Link list is: ");
        l.printLinkList();
        System.out.println("Reverse order: ");
        l.reverse();
        l.printLinkList();
        System.out.println("Stream reverse: ");
        l.reverseStream();


    }

    public static class MyLinkList {

        Node head;


        public void add(int data) {
            Node temp = new Node(data);
            temp.next = head;
            head = temp;
        }

        public void printLinkList() {
            Node temp = head;

            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }

        public void reverse() {
            Node current = head;
            Node prev = null;
            Node next = null;

            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }

            head = prev;
        }

        public void reverseStream() {
            LinkedList<Node> streamList = new LinkedList();
            Node temp = head;


            while (temp != null) {
                streamList.add(temp);

                temp = temp.next;
            }

            streamList.stream()
                .collect(Collectors.toCollection(ArrayDeque::new))
                .descendingIterator()
                .forEachRemaining(System.out::println);
        }

        public static class Node implements Comparable {

            private int data;
            private Node next;


            public Node() {
                this.next = null;
            }

            public Node(int data) {
                this.data = data;
                this.next = null;
            }


            public Node(int data, Node next) {
                this.data = data;
                this.next = next;
            }

            public int getData() {
                return data;
            }

            public void setData(int data) {
                this.data = data;
            }

            public Node getNext() {
                return next;
            }

            public void setNext(Node next) {
                this.next = next;
            }

            @Override
            public int compareTo(Object o1) {
                if (o1 == this.next) {
                    return 1;
                } else {
                    return 0;
                }
            }

            @Override
            public String toString() {
                return String.valueOf(data);
            }
        }
    }
}

