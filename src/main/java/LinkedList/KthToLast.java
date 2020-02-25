package LinkedList;

// Find the kth to last element of a SLL
public class KthToLast {
    // Solution 1: Recursive approach where we return the index of the Kth to last element
    public static int getKthElement(SinglyLinkedList.Node head, int k){
        if(head == null) {
            return 0;
        }
        int index = getKthElement(head.next, k) + 1;
        if(index == k){
            System.out.println("Index is " + k + " and element is " + head.data);
        }
        return index;
    }

    // Solution 2: Recursive approach where we return both the node and the index
    // SC: O(n), because of the recursive calls
    static class Index{
        int value = 0;
    }

    public static SinglyLinkedList.Node getKthElementAndIndex(SinglyLinkedList.Node head, int k){
       Index idx = new Index();
       return getKthElementAndIndex(head, k, idx);
    }
     public static SinglyLinkedList.Node getKthElementAndIndex(SinglyLinkedList.Node head, int k, Index idx){
        if(head == null){
            return null;
        }
        SinglyLinkedList.Node node = getKthElementAndIndex(head.next, k, idx);
        idx.value = idx.value + 1;
        if(idx.value == k){
            return head;
        }
        return node;
     }

     // Solution 3: Iterative approach
    // Take two nodes p1 and p2. Set p1 to the kth node and p2 at the head. Then traverse the list until p1 hits the end of the list
    // Then, it means that, p1 has traversed (k - length) number of nodes, because length = k + remaining
    // Therefore when p1 reached the end of the list, it means that p2 is at the kth node.
    public static SinglyLinkedList.Node getKthElementIteratice(SinglyLinkedList.Node head, int k){
        SinglyLinkedList.Node p1 = head;
        SinglyLinkedList.Node p2 = head;

        if(head == null){
            return null;
        }
        for(int i = 1; i <= k; i++){
            if(p1 == null){ return null;}
            p1 = p1.next;
        }
        // here we do p1 != null instead of p1.next != null, because We have to go past the last element, as last element is considered as
        // the 1st element from last (i.e., k = 1)
        while(p1 != null){
            p2 = p2.next;
            p1 = p1.next;
        }
        return p2;
    }

    public static void main(String[] args){
        System.out.println("Recursive approach which returns the index");
        SinglyLinkedList list = CreateList.createListWithIntData();
        getKthElement(list.head, 5);

        System.out.println("Recursive approach which return the kth node");
        SinglyLinkedList.Node node = getKthElementAndIndex(list.head, 5);
        System.out.println(node.data);

        System.out.println("Iterative approach");
        System.out.println(getKthElementIteratice(list.head, 5).data);
    }
}
