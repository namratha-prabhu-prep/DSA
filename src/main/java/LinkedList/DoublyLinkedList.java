package LinkedList;

public class DoublyLinkedList {
     class Node {
        public int data;
        public Node next;
        public Node prev;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public int length = 0;
    public Node head;

    // Insert at the head
    public void insertAtTheHead(int data){
        Node new_node = new Node(data);
        if(head == null){
            head = new_node;
            length++;
        }
        else {
            new_node.next = head;
            head.prev = new_node;
            new_node.prev = null;
            head = new_node;
            length++;
        }
    }

    // Insert at the end
    public void insertAtTheEnd(int data){
        Node new_node = new Node(data);
        if(head == null){
            head = new_node;
            length++;
        }
        else {
            // Traverse the list to the end and then insert
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            new_node.prev = temp;
            temp.next = new_node;
            new_node.next = null;
            length++;
        }
    }

    // Print the linked list
    public void printLL(DoublyLinkedList list){
        Node current = head;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    // Insert at the given position
    public void insertAtTheGivenPosition(int data, int position){
        Node new_node = new Node(data);
        Node current = head;
        for (int i = 0; i < position; i++){
            // Traverse the list until the current node's next points to null
            if(current.next != null){
                current = current.next;
            }
            // break if current.next == null; This means adding new_node at the end of the list
            else {
                break;
            }
        }
        // Adding new_node at the end of the list
        if(current.next == null){
            System.out.println("my next data is null");
            new_node.next = null;
            new_node.prev = current;
            current.next = new_node;
            length++;
        } else {
            new_node.next = current;
            new_node.prev = current.prev;
            current.prev.next = new_node;
            current.prev = new_node;
            length++;
        }
    }

    public static void main(String[] args){
        DoublyLinkedList list = new DoublyLinkedList();
        System.out.println("Insert at the head of a Doubly Linked List");
        list.insertAtTheHead(5);
        list.insertAtTheHead(7);
        list.insertAtTheHead(9);
        list.insertAtTheHead(11);
        list.printLL(list);
        System.out.println("Insert at the end of a Doubly Linked List");
        list.insertAtTheEnd(1);
        list.printLL(list);
        System.out.println("Insert at the end of a Doubly Linked List");
        list.insertAtTheGivenPosition(3, 5);
        list.insertAtTheGivenPosition(15, 2);
        list.printLL(list);
    }
}
