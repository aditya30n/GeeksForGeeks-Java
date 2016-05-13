/*  This function traverses tree in post order to 
     to delete each and every node of the tree */
    void deleteTree(Node node) {
        if (node == null) {
            return;
        }
 
        /* first delete both subtrees */
        deleteTree(node.left);
        deleteTree(node.right);
 
        /* then delete the node */
        System.out.println("The deleted node is " + node.data);
        node = null;
    }
