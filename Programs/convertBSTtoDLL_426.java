import java.util.ArrayList;
import java.util.List;

/*
Convert a BST to a sorted circular doubly-linked list in-place. 
Think of the left and right pointers as synonymous to the previous and next pointers in a doubly-linked list.
/* */

class convertBSTtoDLL_426 {
  public static void main(String[] args) {
    convertBSTtoDLL_426 cbd = new convertBSTtoDLL_426();

    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    root.right = new TreeNode(5);

    System.out.println("BST: ");
    cbd.display(root);

    DoubleLinkedList dll = new DoubleLinkedList(-1);
    cbd.convert(root, dll);
    System.out.println();
    System.out.println("DLL: ");
    cbd.displayDll(dll.next);
  } 
  
  public void convert(TreeNode root, DoubleLinkedList dll) {
    if(root == null)
      return;
    
      List<Integer> al = new ArrayList<Integer>();
      Inorder(root, al);
      DoubleLinkedList temp = dll, prev = dll;
      for(int i: al) {
        temp.next = new DoubleLinkedList(i);
        temp = temp.next;
        temp.previous = prev;
        prev = temp;
      }
      temp.next = dll.next;
      dll.next.previous = temp;
  }

  public void Inorder(TreeNode root, List<Integer> al) {
    if(root == null)
      return;

      Inorder(root.left, al);
      al.add(root.val);
      Inorder(root.right, al);
  }
  public void displayDll(DoubleLinkedList dll) {
    int index = 6;
    while(index-- > 0) {
      System.out.print(dll.val+" ");
      dll = dll.next;
    }
  }
  public void display(TreeNode root) {
    if(root == null)
    return;

    display(root.left);
    System.out.print(root.val+" ");
    display(root.right);
  }
}
