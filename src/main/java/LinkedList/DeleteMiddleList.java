package LinkedList;

public class DeleteMiddleList {
    public static boolean deleteMiddleNode(SinglyLinkedList.Node node){
        if(node == null || node.next == null) {
            return false;
        }
        // As we don't know the prev node, we have to copy the node.next node's value to the node position, so that we don't have
        // to deal with node's previous position
        SinglyLinkedList.Node n = node.next;
        node.data = n.data;
        node.next = n.next;
        return true;
    }
}
