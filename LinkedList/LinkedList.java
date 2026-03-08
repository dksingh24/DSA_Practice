public class LinkedList {
    
    private static class Node {
        private int data;
        private Node next;

        public Node(){}

        public Node(int val){
            this.data = val;
            this.next = null;
        }


    }

    private Node head;

    public void insertAtEnd(int val) {
        if (isEmpty()){
            this.head = new Node(val);
            return;
        }

        Node temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(val);
    }

    public void insertAtBeginning(int val){
        Node newNode = new Node(val);
        newNode.next = this.head;
        this.head = newNode;        
    }

    public boolean insertAfterValue(int target, int val){
        Node temp = this.head;
        while(temp != null && temp.data != target){
            temp = temp.next;
        }
        if(temp == null){
            return false;
        }

        Node newNode = new Node(val);
        newNode.next = temp.next;
        temp.next = newNode;
        return true;
    }

    public boolean deleteByValue(int target){
        if(isEmpty()){
            return false;
        }
        if(this.head.data == target){
            this.head = this.head.next;
            return true;
        }

        Node temp = this.head;
        while(temp.next != null && temp.next.data != target)
            temp = temp.next;
        if(temp.next == null)
            return false;
        
        temp.next = temp.next.next;
        return true;
    }

    public boolean deleteFromBeginning(){
        if(isEmpty())
            return false;

        this.head = this.head.next;
        return true;
    }

    public boolean deleteFromEnd(){
        if(isEmpty())
            return false;
        if(this.head.next == null){
            this.head = this.head.next;
            return true;
        }

        Node temp = this.head;
        while(temp.next.next != null)
            temp = temp.next;

        temp.next = null;           // temp.next = temp.next.next;
        return true;
    }

    public boolean deleteAtPosition(int index){
        if(isEmpty() || index < 0)
            return false;
        if(index == 0){
            this.head = this.head.next;
            return true;
        }

        Node temp = this.head;
        while(temp.next != null && index-- > 1)
            temp = temp.next;
        if(temp.next == null)        // index was greater than the size of list.
            return false;
                
        temp.next = temp.next.next;
        return true;
    }

    private Node findMiddle(){
        if(isEmpty())
            return this.head;

        Node slow = this.head;
        Node fast = this.head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Integer findMiddleValue(){
        Node midNode = findMiddle();
        return midNode != null ? midNode.data : null;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void printLinkedList() {
        if (isEmpty()){
            System.out.println("Linked List is EMPTY!.");
            return;
        }

        System.out.println("Linked List Status : ");
        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
