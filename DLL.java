public class DLL {
    static Node head; 
 
    /* Doubly Linked list Node*/
    class Node {
        int data;
        Node prev;
        Node next;
 
        // Constructor to create a new node
      
        Node(int d) { data = d; }
    }
 
    // Adding a node at the head
    public void push(int new_data)
    {
       //allocating node 
        Node new_Node = new Node(new_data);
 
       
        new_Node.next = head;
        new_Node.prev = null;
 
       
        if (head != null)
            head.prev = new_Node;
 
       
        head = new_Node;
    }
 
   
   
 
    // Add a node at the tail
    void append(int new_data)
    {
      
        Node new_node = new Node(new_data);
 
        Node last = head; 
 
        // when new node is last node set as null
        new_node.next = null;
 
        //check if list is empty
        if (head == null) {
            new_node.prev = null;
            head = new_node;
            return;
        }
 
        //else traverse to end
        while (last.next != null)
        last = last.next;
 
        
        last.next = new_node;
 
        new_node.prev = last;
    }
 
    //print list
    public void printlist(Node node)
    {
        Node last = null;
        System.out.println("Travering in forward Direction");
        while (node != null) {
            System.out.print(node.data + " ");
            last = node;
            node = node.next;
        }
        System.out.println();
        System.out.println("Traversing in reverse direction");
        while (last != null) {
            System.out.print(last.data + " ");
            last = last.prev;
        }
    }
    
    //size of list
    static int findSize(Node node) 
    { 
        int res = 0; 
        while (node != null)  
        { 
                res++; 
                node = node.next; 
        } 
  
        return res; 
    } 
    
    
    
    /* Driver program to test above functions*/
    public static void main(String[] args)
    {
        /* Start with the empty list */
        DLL dll = new DLL();
 
        // Insert 6. So linked list becomes 6->NULL
        dll.append(6);
 
        dll.push(7);
        dll.push(1);

        dll.append(4);

        System.out.println("Created DLL is: ");
        dll.printlist(dll.head);
        
         
        System.out.println(findSize(head)); 
    }
}