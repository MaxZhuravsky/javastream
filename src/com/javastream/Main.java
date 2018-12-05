package com.javastream;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World");

        LinkList l = new LinkList();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.printLinkList();

    }

    public static class LinkList {

        Node head;


        public void add(int data) {
            Node temp = new Node(data);
            temp.next = head;
            head = temp;
        }
        public void printLinkList() {
            Node temp = head;

           while(temp != null) {
               System.out.println(temp.data);
               temp = temp.next;
           }
        }

        public static class Node {

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
        }
    }
}

