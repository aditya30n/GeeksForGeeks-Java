/*
Write a recursive function treeToList(Node root) that takes an ordered binary tree and rearranges the internal pointers to make 
a circular doubly linked list out of the tree nodes. The”previous” pointers should be stored in the “small” field and the “next” 
pointers should be stored in the “large” field. The list should be arranged so that the nodes are in increasing order. 
Return the head pointer to the new list.
*/

class TreeList {
    /*
     helper function -- given two list nodes, join them
     together so the second immediately follow the first.
     Sets the .next of the first and the .previous of the second.
    */
    public static void join(Node a, Node b) {
        a.large = b;
        b.small = a;
    }

    
    /*
     helper function -- given two circular doubly linked
     lists, append them and return the new list.
    */
    public static Node append(Node a, Node b) {
        // if either is null, return the other
        if (a==null) return(b);
        if (b==null) return(a);
        
        // find the last node in each using the .previous pointer
        Node aLast = a.small;
        Node bLast = b.small;
        
        // join the two together to make it connected and circular
        join(aLast, b);
        join(bLast, a);
        
        return(a);
    }

    
    /*
     --Recursion--
     Given an ordered binary tree, recursively change it into
     a circular doubly linked list which is returned.
    */
    public static Node treeToList(Node root) {
        // base case: empty tree -> empty list
        if (root==null) return(null);
        
        // Recursively do the subtrees (leap of faith!)
        Node aList = treeToList(root.small);
        Node bList = treeToList(root.large);
        
        // Make the single root node into a list length-1
        // in preparation for the appending
        root.small = root;
        root.large = root;
        
        // At this point we have three lists, and it's
        // just a matter of appending them together
        // in the right order (aList, root, bList)
        aList = append(aList, root);
        aList = append(aList, bList);
        
        return(aList);
    }


    /*
     Given a non-empty tree, insert a new node in the proper
     place. The tree must be non-empty because Java's lack
     of reference variables makes that case and this
     method messier than they should be.
    */
    public static void treeInsert(Node root, int newData) {
        if (newData<=root.data) {
            if (root.small!=null) treeInsert(root.small, newData);
            else root.small = new Node(newData);
        }
        else {
            if (root.large!=null) treeInsert(root.large, newData);
            else root.large = new Node(newData);
        }
    }
