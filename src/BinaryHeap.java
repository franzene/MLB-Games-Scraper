import java.util.*;
public class BinaryHeap<Game extends Comparable<Game>> 
 {
  BinaryTree<Game> tree = new BinaryTree<Game>();
  
  public void insert (Game item) 
   {
   	tree.add(item);

   	int index = tree.getElementSize() - 1;
   	
   	while(tree.get(index).compareTo(tree.get(tree.parent(index)))== 1)
   	 {
   	  tree.set(index, tree.get(tree.parent(index))); //swap parent to child location
   	  tree.set(tree.parent(index), item); //put child to parent's position
   	  
   	  index = tree.parent(index);
   	 }
   }
  
  public Game remove (Game item) 
   {
   	int index = tree.search(item); //find the location of the item that needs to be removed
   	if(index != -1) //make sure the item actually exists
   	 {
   	  tree.set(index, tree.get(tree.getElementSize() - 1));
   	  tree.removeLast(); //remove the element that replaced the other
	  
	  //fix the heap
	  while(true == true) //loop until break
	   {
	   	//========================================
	   	Game left = tree.get(tree.left(index));
	   	int leftIndex = tree.left(index);
	   	
	   	Game right = tree.get(tree.right(index));
	   	int rightIndex = tree.right(index);
	   	
	   	Game parent = tree.get(index);
	   	//========================================
	   	if(left != null && right != null)//there is a node on either side
	   	 {
	   	  if(left.compareTo(right) == 1)//left is bigger
	   	   {
	   	   	if(parent.compareTo(left) != 1)//parent is not greater
	   	   	 {
	   	   	  tree.set(leftIndex, parent);//swap parent into child
	   	   	  tree.set(index, left);//swap child into parent
	   	   	  
	   	   	  index = leftIndex; //update index
	   	   	 }
	   	   	else// cannot go any lower
	   	   	 {
	   	   	  break;
	   	   	 }
	   	   }
	   	  else//right is bigger
	   	   {
	   	   	if(parent.compareTo(right) != 1)//parent is not greater
	   	   	 {
	   	   	  tree.set(rightIndex, parent);//swap parent into child
	   	   	  tree.set(index, right);//swap child into parent
	   	   	  
	   	   	  index = rightIndex;//update index
	   	   	 }
	   	   	else// cannot go any lower
	   	   	 {
	   	   	  break;
	   	   	 }
	   	   }
	   	 }
	   	else if(left != null)//there is a node on the left but not the right
	   	 {
	   	  if(parent.compareTo(left) != 1)//parent is not greater
	   	   {
	   	   	tree.set(leftIndex, parent);//swap parent into child
	   	   	tree.set(index, left);//swap child into parent
	   	   	  
	   	   	index = leftIndex;//update index
	   	   }
	   	  else// cannot go any lower
	   	   {
	   	   	break;
	   	   }
	   	 }
	   	else if(right != null)//there is a value to the right but not to the left
	   	 {
	   	  if(parent.compareTo(left) != 1)//parent is not greater
	   	   {
	   	   	tree.set(leftIndex, parent);//swap parent into child
	   	   	tree.set(index, left);//swap child into parent
	   	   	 
	   	   	index = leftIndex;//update index
	   	   }
	   	  else// cannot go any lower
	   	   {
	   	   	break;
	   	   }
	   	 }
	   	else//stop looping
	   	 {
	   	  break;
	   	 }
	   }	
   	 }
	
   	return null;
   }
  
  public boolean contains (Game item) 
   {
   	if(tree.search(item) != -1) // the item is in the tree
   	 {
   	  return true;
   	 }
   	else
   	 {
   	 return false;
   	 }
   }
   
  public ArrayList getOutput()
   { 
    ArrayList<Game> x = new ArrayList();
    for(int i = 0; i < tree.getElementSize(); i++)
     {
      x.add(tree.get(i));
     }
    return x;
   }
 }
