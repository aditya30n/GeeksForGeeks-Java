
/*
Write a GetNth() function that takes a linked list and an integer index and returns the data value stored in the node at that index position.

Example:

Input:  1->10->30->14,  index = 2
Output: 30  
The node at index 2 is 30
*/

/*  Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class GfG
{

// Should return data of node at given index. The function may
//  assume that there are at least index+1 nodes in linked list
public int GetNth(LinkedList l, int index)
{
   // Your code here
   LinkedList temp = l;
   for(int i =0; i< index; i++){
        if(temp == null)
            return -1;
        temp = temp.next;   
   }
    return temp.data;
}  
}
