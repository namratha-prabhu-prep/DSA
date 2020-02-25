package LinkedList;

import java.util.HashSet;

// TC: O(N) and SC: O(1)
public class RemoveDuplicates {
    HashSet<Integer> set = new HashSet<Integer>();
    // Using Hashset i.e, using a buffer
    public void removeDups(SinglyLinkedList.Node node){
        SinglyLinkedList.Node prev = null;
        while(node != null){
            if(set.contains(node.data)){
                prev.next = node.next;
            } else {
                set.add(node.data);
                prev = node;
            }
            node = node.next;
        }
    }

    // Without using buffer
    public void removeDupsNoBuffer(SinglyLinkedList.Node node){
        SinglyLinkedList.Node current = node;
        // Keep current node as reference of compare it with the rest of the nodes
        // The rest of the nodes would be runner
        while(current != null){
            SinglyLinkedList.Node runner = current;
            while(runner.next != null){
                // If current data and runner.next data is equal, then remove the runner.next node
                // Therefore, to remove, runner.next = runner.next.next
                if(runner.next.data == current.data){
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    public static void main(String[] args){
//        RemoveDuplicates remDups = new RemoveDuplicates();
//        SinglyLinkedList list = CreateList.createListWithIntData();
//        System.out.println("Removing duplicates");
//        remDups.removeDups(list.head);
//        SinglyLinkedList.printLinkedList(list);
//        System.out.println("Removing duplicates without using buffer");
//        remDups.removeDupsNoBuffer(list.head);
//        SinglyLinkedList.printLinkedList(list);
    }
}
