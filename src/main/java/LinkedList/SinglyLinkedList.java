package LinkedList;

//public class SinglyLinkedList {
//    Node head;
//    int length = 0;
//
//    static class Node {
//        public int data;
//        public Node next;
//
//        Node(int d){
//            data = d;
//            next = null;
//        }
//    }
//
//    // Insert at beginning of the LinkedList
//    public static SinglyLinkedList insertAtHead(SinglyLinkedList list, int data){
//        Node new_node = new Node(data);
//        new_node.next = null;
//        // If the list is empty
//        if(list.head == null){
//            list.head = new_node;
//        } else {
//            new_node.next = list.head;
//            list.head = new_node;
//        }
//        list.length++;
//        return list;
//    }
//
//    // Insert at the given position
//    public static SinglyLinkedList insertAtGivenPosition(SinglyLinkedList list, int data, int position){
//        Node new_node = new Node(data);
//        new_node.next = null;
//        Node temp = list.head;
//
//        if (position < 0){
//            position = 0;
//        }
//        if (position > list.length){
//            position = list.length;
//        }
//        if (position == 0){
//            insertAtHead(list, data);
//        }
//        if (position > 0 && position < list.length){
//            for (int i = 1; i < position; i++){
//                temp = temp.next;
//            }
//            new_node.next = temp.next;
//            temp.next = new_node;
//        }
//        list.length++;
//        return list;
//    }
//
//    // Insert at the end of the list
//    public static SinglyLinkedList insertAtEnd(SinglyLinkedList list, int data){
//        // Create a new node with the given data
//        Node new_node = new Node(data);
//        new_node.next = null;
//
//        // if the linkedlist is empty, make new_node the head
//        if(list.head == null){
//            list.head = new_node;
//        }
//        // If linkedlist is not empty, traverse the list until the node points to null and
//        // insert the node there
//        else {
//            Node current_node = list.head;
//            while (current_node.next != null){
//                current_node = current_node.next;
//            }
//            current_node.next = new_node;
//            new_node.next = null;
//        }
//        list.length++;
//        return list;
//    }
//
//    // Delete a node at the head
//    public static SinglyLinkedList deleteAtHead(SinglyLinkedList list){
//        Node temp = list.head;
//        if(list.head == null){
//            System.out.println("Nothing to delete");
//        }
//        else {
//            list.head = temp.next;
//            temp.next = null;
//        }
//        list.length--;
//        return list;
//    }
//
//    public static SinglyLinkedList deleteAtGivenPosition(SinglyLinkedList list, int position){
//        Node temp = list.head;// temp = 1
//        Node toDelete = temp.next; // toDelete = 11
//        System.out.println("list length " + list.length);
//        if(position < 0){
//            position = 0;
//        }
//        if(position == 0){
//            deleteAtHead(list);
//        }
//        if(position > list.length){
//            position = list.length;
//        }
//        if(position > 0 && position < list.length){
//            for(int i = 1; i < position; i++){
//                temp = temp.next;
//                toDelete = toDelete.next;
//            }
//            temp.next = toDelete.next;
//            toDelete.next = null;
//        }
//        list.length--;
//        return list;
//    }
//
//    public static SinglyLinkedList deleteAtEnd(SinglyLinkedList list){
//        Node temp = list.head;
//        Node toDelete = temp.next;
//        if(list.head == null){
//            System.out.println("Nothing to delete");
//        } else {
//            while(toDelete.next != null){
//                toDelete = toDelete.next;
//                temp = temp.next;
//            }
//            temp.next = null;
//            toDelete.next = null;
//        }
//        list.length--;
//        return list;
//    }
//
//    public static SinglyLinkedList deleteGivenKey(SinglyLinkedList list, int key){
//        Node temp = list.head;
//
//        if(list.head.data == key){
//            list.head = list.head.next;
//        }
//
//        while(temp.next != null){
//            if (temp.next.data == key){
//                temp.next = temp.next.next;
//                return list;
//            }
//            temp = temp.next;
//        }
//
////        if(temp.data == key){
////            deleteAtHead(list);
////        }
////        for(int i = 1; i < list.length; i++){
////            if(toDelete.data == key){
////                temp.next = toDelete.next;
////                toDelete.next = null;
////                list.length--;
////                return list;
////            }
////        }
//        System.out.println("Given key not found in the list");
//        return list;
//    }
//
//    public boolean isEmpty(){
//        return head == null;
//    }
//
//    // Method to print the linkedlist
//    public static void printLinkedList(SinglyLinkedList list){
//        Node current_node = list.head;
//        while (current_node != null){
//          System.out.print(current_node.data);
//          current_node = current_node.next;
//        }
//    }
//
//    public static void main(String[] args){
//        SinglyLinkedList list = new SinglyLinkedList();
//        System.out.println("Insert at end");
//        SinglyLinkedList.insertAtEnd(list, 1);
//        SinglyLinkedList.insertAtEnd(list, 3);
//        SinglyLinkedList.insertAtEnd(list, 5);
//        SinglyLinkedList.insertAtEnd(list, 7);
//        SinglyLinkedList.printLinkedList(list);
//        System.out.println("Insert at Head");
//        SinglyLinkedList.insertAtHead(list, 9);
//        SinglyLinkedList.printLinkedList(list);
//        System.out.println("Insert at given position");
//        SinglyLinkedList.insertAtGivenPosition(list, 11, 2);
//        SinglyLinkedList.printLinkedList(list);
//        System.out.println("Delete at the head");
//        SinglyLinkedList.deleteAtHead(list);
//        SinglyLinkedList.printLinkedList(list);
//        System.out.println("Delete at given position");
//        SinglyLinkedList.deleteAtGivenPosition(list, 2);
//        SinglyLinkedList.printLinkedList(list);
//        System.out.println("Delete at end");
//        SinglyLinkedList.deleteAtEnd(list);
//        SinglyLinkedList.printLinkedList(list);
//        System.out.println("Delete a given key");
//        SinglyLinkedList.deleteGivenKey(list, 11);
//        SinglyLinkedList.printLinkedList(list);
//    }
//}


public class SinglyLinkedList {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    // Insert at head
    public void insertAtHead(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    // Insert at end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if(isEmpty()) {
            head = newNode;
        } else {
            Node temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Insert at the given position
    public void insertAtGivenPosition(int data, int pos) {
        Node newNode = new Node(data);
        if(isEmpty()) {
            head = newNode;
        } else {
            Node temp = head;
            for(int i = 1; i < pos; i++){
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    // print the singly linked list
    public void printList(Node head) {
        if(!isEmpty()){
            Node temp = head;
            while(temp != null){
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }

    public void deleteAtHead() {
        if(!isEmpty()) {
            Node temp = head;
            head = temp.next;
            temp.next = null;
        }
    }

    public void deleteAtTail() {
        if(!isEmpty()){
            Node temp = head;
            while(temp.next.next != null){
                temp = temp.next;
            }
            temp.next = null;
        }
    }

    public boolean isEmpty(){
        if(head == null){
            return true;
        } else {
            System.out.println("Linked list empty");
            return false;
        }
    }

    public Node reverseList(Node head) {
        if(head == null || head.next == null) {
            return null;
        }
        Node current = head;
        Node p = reverseList(current);
        return p;
    }

    public static void main(String args[]) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.printList(list.head);
        System.out.println("Insert at head");
        list.insertAtHead(4);
        list.insertAtHead(2);
        list.insertAtHead(1);
        list.printList(list.head);
        System.out.println("Insert at tail");
        list.insertAtEnd(5);
        list.printList(list.head);
        System.out.println("Insert at given position");
        list.insertAtGivenPosition(3, 2);
        list.printList(list.head);
        System.out.println("Delete at head");
        list.deleteAtHead();
        list.printList(list.head);
        System.out.println("Delete at tail");
        list.deleteAtTail();
        list.printList(list.head);
    }
}
