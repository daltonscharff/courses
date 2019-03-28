
public class RecursionLinkedList
{
	private Node firstNode;
	private int numberOfEntries;
	
	public RecursionLinkedList()
	{
		firstNode = null;
		numberOfEntries = 0;
	}
	
	public void add(int aData)
	{
		if(numberOfEntries == 0)
		{
			firstNode = new Node(aData);
		}
		else
		{
			firstNode = new Node(aData, firstNode);
		}
		
		numberOfEntries++;
	}
	
	/**
	 * boolean contains(int aData)
	 * 
	 * See whether this RecursionLinkedList contains aData
	 * @param aData  a data to be located
	 * @return true if this RecursionLinkedList contains aData,
	 *         or false otherwise.
	 */
	public boolean contains(int aData)
	{
		// TO DO
            return recursiveContains(aData, firstNode);
	}
        
        public boolean recursiveContains(int aData, Node currentNode){
            if(currentNode == null){
                return false;
            }
            if(currentNode.data == aData){
                return true;
            }else{
                return recursiveContains(aData, currentNode.next);
            }
        }
        
	/**
	 * int getFrequencyOf(int aData)
	 * 
	 * Counts the number of times a given data appears in this
	 * RecursionLinkedList.
	 * 
	 * @param aData  the data to be counted
	 * @return the number of times aData appears in this RecursionLinkedList
	 */
	public int getFrequencyOf(int aData)
	{
		// TO DO
            return recursiveGetFrequencyOf(aData, firstNode, 0);            
        }
        
        public int recursiveGetFrequencyOf(int aData, Node currentNode, int count){
            if(currentNode == null){
                return count;
            }
            if(currentNode.data == aData){
                count++;
                return recursiveGetFrequencyOf(aData, currentNode.next, count);
            }else{
                return recursiveGetFrequencyOf(aData, currentNode.next, count);
            }
        }
	
	/**
	 * String toString()
	 * 
	 * Return a string representation of this RecursionLinkedList. For example,
	 * if this RecursionLinkedList contains 1, 2, 3, 5, 2 and 3 from the first
	 * index to the last index, the returned string should be
	 * "[1,2,3,5,2,3]"
	 * @return the string representation of this RecursionLinkedList.
	 */
	public String toString()
	{
		// TO DO
            String temp = "";
            return recursiveToString(firstNode, temp);
	}
        
        public String recursiveToString(Node currentNode, String temp){
            if(currentNode == null){
                temp += "]";
                return temp;
            }
            if(currentNode == firstNode){
                temp += "[";
            }else{
                temp += ",";
            }
            return recursiveToString(currentNode.next, temp += currentNode.data);
        }
	
	/**
	 * int getIndexOf(int aData)
	 * 
	 * Return the index of the first aData where the first index of
	 * the first item in this RecursionLinkedList is 0.
	 * 
	 * @param aData  the data to be located
	 * @return the index of the first aData.
	 */
	public int getIndexOf(int aData)
	{
		// TO DO
            return recursiveGetIndexOf(aData, firstNode, 0);
	}
        
        public int recursiveGetIndexOf(int aData, Node currentNode, int count){
            if(currentNode == null){
                return -1;
            }
            if(currentNode.data == aData){
                return count;
            }
            count++;
            return recursiveGetIndexOf(aData, currentNode.next, count);
	}
		
	private class Node
	{
		private int data;
		private Node next;
		
		private Node(int aData, Node nextNode)
		{
			data = aData;
			next = nextNode;
		}
		
		private Node(int aData)
		{
			this(aData, null);
		}
	}
}
