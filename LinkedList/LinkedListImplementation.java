public class LinkedListImplementation {

    public static void main(String args[]) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        LinkedList list = new LinkedList();
        // list.insertAtBeginning(4);
        // list.insertAtEnd(2);
        // list.insertAtBeginning(3);
        // list.insertAfterValue(3, 1);
        // list.insertAtEnd(7);
        list.insertAtBeginning(5);
        list.printLinkedList();
        System.out.println(list.findMiddleValue());
    }
}