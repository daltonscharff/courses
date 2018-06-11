
public class FrequencyBag<T>{
    private class Node{
        private T data;
        private int amount;
        private Node next;
        
        private Node(T aData, int aAmount, Node nextNode){
            data = aData;
            amount = aAmount;
            next = nextNode;
        }
        

        private Node(T aData, int aAmount){
            this(aData,aAmount,null);
        }
    }
	// TO DO: Instance Variables
	private Node firstNode;
        private int numberOfEntries;
    
	/**
	 * Constructor
	 * Constructs an empty frequency bag.
	 */
	public FrequencyBag()
	{
		// TO DO
            firstNode = new Node(null, 0);
            numberOfEntries = 0;
	}
	
	/**
	 * Adds new entry into this frequency bag.
	 * @param aData the data to be added into this frequency bag.
	 */
	public void add(T aData)
	{
		// TO DO
            boolean hasNode = false;
            Node currentNode = firstNode;
            while(currentNode.next != null){
                if(currentNode.data.equals(aData)){
                    currentNode.amount += 1;
                    numberOfEntries++;
                    hasNode = true;
                }
                currentNode = currentNode.next;
            }
            if(hasNode == false){
                Node temp = firstNode;
		firstNode = new Node(aData, 1, temp);
		numberOfEntries ++;
            }
            
	}
	
	/**
	 * Gets the number of occurrences of aData in this frequency bag.
	 * @param aData the data to be checked for its number of occurrences.
	 * @return the number of occurrences of aData in this frequency bag.
	 */
	public int getFrequencyOf(T aData)
	{
		// TO DO
            Node currentNode = firstNode;
            while(currentNode.next != null){
		if(currentNode.data.equals(aData)){
                    return currentNode.amount;
		}
                currentNode = currentNode.next;
            }
            return 0;
	}

	/**
	 * Gets the maximum number of occurrences in this frequency bag.
	 * @return the maximum number of occurrences of an entry in this
	 * frequency bag.
	 */
	public int getMaxFrequency()
	{
		// TO DO
            int highestFreq = 0;
            Node currentNode = firstNode;
            while(currentNode != null){
		if(currentNode.amount > highestFreq){
                    highestFreq = currentNode.amount;
		}
                currentNode = currentNode.next;
            }
            return highestFreq;
	}
	
	/**
	 * Gets the probability of aData
	 * @param aData the specific data to get its probability.
	 * @return the probability of aData
	 */
	public double getProbabilityOf(T aData)
	{
		// TO DO
            return (this.getFrequencyOf(aData)/(double)numberOfEntries);
	}

	/**
	 * Empty this bag.
	 */
	public void clear()
	{
		// TO DO
            firstNode = new Node(null,0);
            numberOfEntries = 0;
	}
	
	/**
	 * Gets the number of entries in this bag.
	 * @return the number of entries in this bag.
	 */
	public int size()
	{
		// TO DO
            return numberOfEntries;
	}
}
