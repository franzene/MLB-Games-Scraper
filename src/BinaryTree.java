

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Binary Tree using an ArrayList
 */
public class BinaryTree<Game extends Comparable<Game>> implements Iterable<Game> 
 {
  private ArrayList<Game> elements;
	
  public BinaryTree() 
   {
	   elements = new ArrayList<Game>();
   }
  public int left(int index) 
   {
	return 2 * index + 1;
   }
  public int right(int index) 
   {
	return 2 * index + 2;
   }
  public int parent(int index) 
   {
    return (index - 1) / 2;
   }
  public Game get(int index) 
   {
	   try 
	    {
	     return elements.get(index);
	    } 
	   catch (Exception e) 
	    {
	     return null;
	    }
   }
  public void set(int index, Game element) 
   {
	elements.set(index, element);
   }
  public int add(Game element)
   {
	   elements.add(element);
   	return elements.size() - 1;
   }
  public int search(Game element) 
   {
	   // linear search
   	return elements.lastIndexOf(element);
   }
  public int getElementSize()
   {
    return elements.size();
   }	
  public void removeLast()
   {
   	if(elements.size() != 0)
   	 {
   	  elements.remove(elements.size() - 1);	
     }
   }
  @Override
  public Iterator<Game> iterator() 
   {
	// delegation, ftw
	return elements.iterator();
   }
}
