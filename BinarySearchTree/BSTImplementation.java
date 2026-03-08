import java.util.NoSuchElementException;

public class BSTImplementation {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        BST bst = new BST();
        bst.insert(5);
        bst.insert(2);
        bst.insert(6);
        bst.insert(0);
        bst.insert(1);
        bst.insert(3);
        bst.insert(8);
        // bst.insert(10);
        bst.insert(7);
        // bst.insert(9);
        // bst.printBST();
        // try{
        //     bst.delete(9);
        // } catch (Exception nse){
        //     System.out.println(nse.getMessage());
        // }
        System.out.println(bst.height());
        System.out.println();
        bst.printBST();
    }
}
