
public class LInfiniteInteger implements InfiniteIntegerInterface
{
	private Node firstNode;
	private Node lastNode;
	private int numberOfDigits;
	private boolean isNegative;
	
	/**
	 * Constructor: Constructs this infinite integer from a string
	 * representing an integer.
	 * @param s  a string represents an integer
	 */
	public LInfiniteInteger(String s)
	{
		// TO DO
            if (!s.isEmpty() && s.substring(0,1).equals("-")){
                isNegative = true;
                s = s.substring(1);
            }else{
                isNegative = false;
            }
            
            while (!s.isEmpty() && s.substring(0,1).equals("0") && s.length() > 1){
                s = s.substring(1);
            }
            
            if(s.contains("_")){
                s = s.replaceAll("_", "0");
            }
                        
            Node currentNode = new Node(0);
            numberOfDigits = s.length();
                        
            for (int count = 0; count < s.length(); count++){
                if(firstNode == null)
		{
			firstNode = new Node(null, Integer.parseInt(s.substring(count, count+1)), null);
			lastNode = firstNode;
		}
		else
		{
			Node newNode = new Node(lastNode, Integer.parseInt(s.substring(count, count+1)), null);
			lastNode.next = newNode;
			lastNode = newNode;
		}
            }
	}


	/**
	 * Constructor: Constructs this infinite integer from an integer.
	 * @param anInteger  an integer
	 */
	public LInfiniteInteger(int anInteger)
	{
		// TO DO
            String s = "" + anInteger;
            if (s.substring(0,1).equals("-")){
                isNegative = true;
                s = s.substring(1);
            }else{
                isNegative = false;
            }
            
            while (s.substring(0,1).equals("0") && s.length() > 1){
                s = s.substring(1);
            }
                        
            Node currentNode = new Node(0);
            numberOfDigits = s.length();
                        
            for (int count = 0; count < s.length(); count++){
                if(firstNode == null)
		{
			firstNode = new Node(null, Integer.parseInt(s.substring(count, count+1)), null);
			lastNode = firstNode;
		}
		else
		{
			Node newNode = new Node(lastNode, Integer.parseInt(s.substring(count, count+1)), null);
			lastNode.next = newNode;
			lastNode = newNode;
		}
            }
	}

	/**
	 * Gets the number of digits of this infinite integer.
	 * @return an integer representing the number of digits
	 * of this infinite integer.
	 */
	public int getNumberOfDigits()
	{
		// TO DO
            return numberOfDigits;
	}

	/**
	 * Checks whether this infinite integer is a negative number.
	 * @return true if this infinite integer is a negative number.
	 * Otherwise, return false.
	 */
	public boolean isNegative()
	{
		// TO DO
            return isNegative;
	}
        

	/**
	 * Calculates the result of this infinite integer plus anInfiniteInteger
	 * @param anInfiniteInteger the infinite integer to be added to this
	 * infinite integer.
	 * @return a NEW infinite integer representing the result of this
	 * infinite integer plus anInfiniteInteger
	 */
	public InfiniteIntegerInterface plus(final InfiniteIntegerInterface anInfiniteInteger)
	{		
		// TO DO
            LInfiniteInteger posSum = new LInfiniteInteger(0);
            LInfiniteInteger negSum = new LInfiniteInteger(0);
            LInfiniteInteger posDif = new LInfiniteInteger(0);
            LInfiniteInteger negDif = new LInfiniteInteger(0);
            LInfiniteInteger temp = new LInfiniteInteger(0);
            LInfiniteInteger topNum = new LInfiniteInteger(0);
            LInfiniteInteger bottomNum = new LInfiniteInteger(0);
            
            LInfiniteInteger result = new LInfiniteInteger(0);
            LInfiniteInteger findZero = new LInfiniteInteger(0);
            
            if(this.numberOfDigits >= anInfiniteInteger.getNumberOfDigits()){
                topNum = new LInfiniteInteger(this.toString());
                bottomNum = new LInfiniteInteger(anInfiniteInteger.toString());
            }else{
                topNum = new LInfiniteInteger(anInfiniteInteger.toString());
                bottomNum = new LInfiniteInteger(this.toString());
            }
                               
                    
            if(topNum.isNegative() == false && bottomNum.isNegative() == false){
                result = sum(topNum, bottomNum);
                result.isNegative = false;
            }
            if(topNum.isNegative() == true && bottomNum.isNegative() == true){
                result = sum(topNum, bottomNum);
                result.isNegative = true;
            }
            if(topNum.isNegative() == true && bottomNum.isNegative() == false){
                topNum.isNegative = false;
                result = difference(topNum, bottomNum);
                if(topNum.compareTo(bottomNum) == 1){
                    result.isNegative = true;
                }else{
                    result.isNegative = false;
                }
            }
            if(topNum.isNegative() == false && bottomNum.isNegative() == true){
                bottomNum.isNegative = false;
                result = difference(topNum, bottomNum);
                if(bottomNum.compareTo(topNum) == 1){
                    result.isNegative = true;
                }else{
                    result.isNegative = false;
                }
            }
            
            findZero = new LInfiniteInteger(result.toString());
            findZero.isNegative = false;
            if(findZero.equals("0") || findZero.equals("-0")){
                result.isNegative = false;
            }
            
            return result; 
	}

	/**
	 * Calculates the result of this infinite integer subtracted by anInfiniteInteger
	 * @param anInfiniteInteger the infinite integer to subtract.
	 * @return a NEW infinite integer representing the result of this
	 * infinite integer subtracted by anInfiniteInteger
	 */
	public InfiniteIntegerInterface minus(final InfiniteIntegerInterface anInfiniteInteger)
	{
		// TO DO
            int situation = -1;
            LInfiniteInteger result = new LInfiniteInteger(0);
            LInfiniteInteger tempTop = new LInfiniteInteger(this.toString());
            LInfiniteInteger tempBottom = new LInfiniteInteger(anInfiniteInteger.toString());
            LInfiniteInteger findZero = new LInfiniteInteger(0);
            
            if(tempTop.compareTo(tempBottom) == 0){
                return findZero;
            }
            
            if(tempBottom.isNegative() == false){
                tempBottom.isNegative = true;
            }else{
                tempBottom.isNegative = false;
            }
            
            result = new LInfiniteInteger(tempTop.plus(tempBottom).toString());
            
            return result; 
	}
        
        private LInfiniteInteger sum(LInfiniteInteger topNum, LInfiniteInteger bottomNum){
            int top, bottom, carried = 0, total = 0;
            Node topN = new Node(topNum.lastNode.previous, topNum.lastNode.data, topNum.lastNode.next);
            Node bottomN = new Node(bottomNum.lastNode.previous, bottomNum.lastNode.data, bottomNum.lastNode.next);
            LInfiniteInteger result = new LInfiniteInteger(0);
            
            if(topNum.toString().equals("0")){
                return bottomNum;
            }
            if(bottomNum.toString().equals("0")){
                return topNum;
            }
            int temp1 = topNum.numberOfDigits, temp2 = bottomNum.numberOfDigits, limit=0;
            if(temp1 >= temp2){
                limit = temp1;
            }else{
                limit = temp2;
            }
            
            
            for(int count = 0; count < limit; count++){
                if(count >= topNum.numberOfDigits){
                    top = 0;
                }else{
                    top = topN.data;
                }
                if(count >= bottomNum.numberOfDigits){
                    bottom = 0;
                }else{
                    bottom = bottomN.data;
                }
                
                total = top + bottom + carried;
                //System.out.println(total);
                if(total < 10){
                    result = addNode(result, total);
                    carried = 0;
                }else if(total >= 10){
                    result = addNode(result, total - 10);
                    carried = 1;
                }
                if(count < topNum.numberOfDigits){
                    topN = topN.previous;
                }
                if(count < bottomNum.numberOfDigits){
                    bottomN = bottomN.previous;
                }                
            }
            if(carried > 0){
                result.addNode(result, carried);
            }
            Node resultN = result.firstNode;
            int counter = 0;
            while(resultN.next != null){
                if(counter == 0){
                    result = new LInfiniteInteger(resultN.data);
                }else{
                    result = new LInfiniteInteger(result.toString() + resultN.data);
                }
                resultN = resultN.next;
                counter++;
            }
            return result;
        }
        
        private LInfiniteInteger difference(LInfiniteInteger topNum, LInfiniteInteger bottomNum){
            int top, bottom, carried = 0, total = 0;
            LInfiniteInteger result = new LInfiniteInteger(0);
            LInfiniteInteger temp;
            
            if(topNum.equals("0")){
                return bottomNum;
            }
            if(bottomNum.equals("0")){
                return topNum;
            }
            
            if(topNum.compareTo(bottomNum) < 0){
                temp = new LInfiniteInteger(topNum.toString());
                topNum = new LInfiniteInteger(bottomNum.toString());
                bottomNum = new LInfiniteInteger(temp.toString());
            }
            
            Node topN = new Node(topNum.lastNode.previous, topNum.lastNode.data, topNum.lastNode.next);
            Node bottomN = new Node(bottomNum.lastNode.previous, bottomNum.lastNode.data, bottomNum.lastNode.next);
            
            for(int count = 0; count < topNum.numberOfDigits; count++){
                top = topN.data + carried;
                if(count >= bottomNum.numberOfDigits){
                    bottom = 0;
                }else{
                    bottom = bottomN.data;
                }
                
                if(top < bottom){
                    top = top + 10;
                    carried = -1;
                }else{
                    carried = 0;
                }
                
                total = top - bottom;
                result = addNode(result, total);
                topN = topN.previous;
                if(count < bottomNum.numberOfDigits){
                    bottomN = bottomN.previous;
                }                
            }
            if(carried > 0){
                result.addNode(result, carried);
            }
            Node resultN = result.firstNode;
            int counter = 0;
            while(resultN.next != null){
                if(counter == 0){
                    result = new LInfiniteInteger(resultN.data);
                }else{
                    result = new LInfiniteInteger(result.toString() + resultN.data);
                }
                resultN = resultN.next;
                counter++;
            }
            return result;
        }
	
	/**
	 * Generates a string representing this infinite integer. If this infinite integer
	 * is a negative number a minus symbol should be in the front of numbers. For example,
	 * "-12345678901234567890". But if the infinite integer is a positive number, no symbol
	 * should be in the front of the numbers (e.g., "12345678901234567890").
	 * @return a string representing this infinite integer number.
	 */
	public String toString()
	{
		// TO DO
            String toBeReturned = "";
            if (isNegative){
                toBeReturned = "-";
            }
            Node currentNode = firstNode;
            while (currentNode.next != null){
                toBeReturned += "" + currentNode.data;
                currentNode = currentNode.next;
            }
            toBeReturned += "" + lastNode.data;
            return toBeReturned;
	}
	
	/**
	 * Compares this infinite integer with anInfiniteInteger
	 * @return either -1, 0, or 1 as follows:
	 * If this infinite integer is less than anInfiniteInteger, return -1.
	 * If this infinite integer is equal to anInfiniteInteger, return 0.
	 * If this infinite integer is greater than anInfiniteInteger, return 1.
	 */
	public int compareTo(InfiniteIntegerInterface anInfiniteInteger)
	{
		// TO DO
            int top, bottom;
            Node tempN, thisN;
            
            if(anInfiniteInteger.isNegative() == true && this.isNegative() == false){
                return 1;
            }
            if(anInfiniteInteger.isNegative() == false && this.isNegative() == true){
                return -1;
            }
            LInfiniteInteger temp;
            temp = (LInfiniteInteger) anInfiniteInteger;
            tempN = new Node(temp.firstNode.previous, temp.firstNode.data, temp.firstNode.next);
            thisN = new Node(this.firstNode.previous, this.firstNode.data, this.firstNode.next);
            
            if(anInfiniteInteger.isNegative() == true && this.isNegative() == true){
                if(temp.getNumberOfDigits() > this.numberOfDigits){
                    return 1;
                }
                if(temp.numberOfDigits < this.numberOfDigits){
                    return -1;
                }
                for(int count = 0; count < this.numberOfDigits; count++){
                    top = tempN.data;
                    bottom = thisN.data;
                    if(bottom < top){
                        return 1;
                    }
                    if(bottom > top){
                        return -1;
                    }
                    tempN = tempN.next;
                    thisN = thisN.next;
                }
            }
            
            if(anInfiniteInteger.isNegative() == false && this.isNegative() == false){
                if(temp.numberOfDigits > this.numberOfDigits){
                    return -1;
                }
                if(temp.numberOfDigits < this.numberOfDigits){
                    return 1;
                }
                for(int count = 0; count < this.numberOfDigits; count++){
                    top = tempN.data;
                    bottom = thisN.data;
                    if(bottom < top){
                        return -1;
                    }
                    if(bottom > top){
                        return 1;
                    }
                    tempN = tempN.next;
                    thisN = thisN.next;
                }
            }
            return 0;
	}

	/**
	 * Calculates the result of this infinite integer multiplied by anInfiniteInteger
	 * @param anInfiniteInteger the multiplier.
	 * @return a NEW infinite integer representing the result of this
	 * infinite integer multiplied by anInfiniteInteger.
	 */
	public InfiniteIntegerInterface multiply(final InfiniteIntegerInterface anInfiniteInteger)
	{
		// TO DO
            LInfiniteInteger result = new LInfiniteInteger(0);
            LInfiniteInteger findZero = new LInfiniteInteger(0);
            LInfiniteInteger intLimit = new LInfiniteInteger(2147483647);
            LInfiniteInteger nIntLimit = new LInfiniteInteger(-2147483648);

            LInfiniteInteger topNum = new LInfiniteInteger(0);
            LInfiniteInteger bottomNum = new LInfiniteInteger(0);
            LInfiniteInteger temp = new LInfiniteInteger(0);
                            
            if(this.numberOfDigits >= anInfiniteInteger.getNumberOfDigits()){
                topNum = new LInfiniteInteger(this.toString()); 
                bottomNum = new LInfiniteInteger(anInfiniteInteger.toString()); 
            }else{
                topNum = new LInfiniteInteger(anInfiniteInteger.toString()); 
                bottomNum = new LInfiniteInteger(this.toString()); 
            }
            
            topNum.isNegative = false;
            bottomNum.isNegative = false;
            
            if(topNum.numberOfDigits == bottomNum.numberOfDigits){
                boolean found = false;
                int zeros = 0;
                Node t = new Node(topNum.lastNode.previous, topNum.lastNode.data, topNum.lastNode.next);
                Node b = new Node(bottomNum.lastNode.previous, bottomNum.lastNode.data, bottomNum.lastNode.next);
                for(int count = 0; count < topNum.numberOfDigits; count ++){
                    int top = t.data;
                    int bottom = b.data;
                    
                    if(top == 0 && bottom != 0){
                        temp = new LInfiniteInteger(topNum.toString());
                        topNum = new LInfiniteInteger(bottomNum.toString());
                        bottomNum = new LInfiniteInteger(temp.toString());
                        found = true;
                        break;
                    }
                    
                    t = t.previous;
                    b = b.previous;
                }
            }

            
            result = multiply(topNum, bottomNum);
            

            
            if(this.isNegative() == true && anInfiniteInteger.isNegative() == true){
                result.isNegative = false;
            }
            if(this.isNegative() == false && anInfiniteInteger.isNegative() == false){
                result.isNegative = false;
            }
            if(this.isNegative() == true && anInfiniteInteger.isNegative() == false){
                result.isNegative = true;
            }
            if(this.isNegative() == false && anInfiniteInteger.isNegative() == true){
                result.isNegative = true;
            }
            
            if(result.compareTo(intLimit) < 1 && result.compareTo(nIntLimit) > -1){
                if(Integer.parseInt(result.toString()) == 0){
                    result.isNegative = false;
                }
            }
            
            
            
            return result;
	}
        
        private LInfiniteInteger multiply(LInfiniteInteger topNum, LInfiniteInteger bottomNum){
            LInfiniteInteger result = new LInfiniteInteger(0);
            LInfiniteInteger runningTotal = new LInfiniteInteger(0);
            LInfiniteInteger thisLayer = new LInfiniteInteger(0);
            int currTotal, top, bottom, carried = 0;
            
            if(topNum.equals("0") || bottomNum.equals("0")){
                return result;
            }
            
            Node topN = new Node(topNum.lastNode.previous, topNum.lastNode.data, topNum.lastNode.next);
            Node bottomN = new Node(bottomNum.lastNode.previous, bottomNum.lastNode.data, bottomNum.lastNode.next);
            
            for(int y = 0; y < bottomNum.numberOfDigits; y++){
                bottom = bottomN.data;
                thisLayer = new LInfiniteInteger(0);
                
                
                
                
                for(int x = 0; x < topNum.numberOfDigits; x++){
                    top = topN.data;
                    currTotal = (top * bottom) + carried;
                    carried = 0;
                    //System.out.println("top " + top + " bottom: " + bottom + " currTotal:" + currTotal);

                    while(currTotal >= 10){
                        currTotal = currTotal - 10;
                        carried += 1;
                    }

                    thisLayer.addNode(thisLayer, currTotal);

                    //System.out.println("thisLayer: " + thisLayer);
                    topN = topN.previous;
                }
                
                for(int z = 0; z < y; z++){
                    thisLayer.addNodeEnd(thisLayer, 0);
                }

                if(carried != 0){
                    thisLayer = addNode(thisLayer, carried);
                    carried = 0;
                }
                topN = new Node(topNum.lastNode.previous, topNum.lastNode.data, topNum.lastNode.next);
                bottomN = bottomN.previous;
                runningTotal = (LInfiniteInteger) runningTotal.plus(thisLayer);
            }
            if(carried != 0){
                runningTotal = addNode(runningTotal, carried);
                carried = 0;
            }
            
            result = runningTotal;
            
            Node resultN = result.firstNode;
            int counter = 0;
            while(resultN.next != null){
                if(counter == 0){
                    result = new LInfiniteInteger(resultN.data);
                }else{
                    result = new LInfiniteInteger(result.toString() + resultN.data);
                }
                resultN = resultN.next;
                counter++;
            }      
           
            
            
            return result;
        }
        
        private LInfiniteInteger addNode(LInfiniteInteger a, int newEntry)
	{
		if(a.firstNode == null){
			a.firstNode = new Node(null, newEntry, null);
			a.lastNode = a.firstNode;
		}else{
			Node newNode = new Node(null, newEntry, a.firstNode);
			a.firstNode.previous = newNode;
			a.firstNode = newNode;
		}
                return a;
	}
        
        private LInfiniteInteger addNodeEnd(LInfiniteInteger a, int newEntry)
	{
		if(a.lastNode == null){
			a.lastNode = new Node(null, newEntry, null);
			a.firstNode = a.lastNode;
		}else{
			Node newNode = new Node(a.lastNode, newEntry, null);
			a.lastNode.next = newNode;
			a.lastNode = newNode;
		}
                return a;
	}
	
	private class Node
	{
		private int data;
		private Node next;
		private Node previous;
		
		private Node(Node previousNode, int aData, Node nextNode)
		{
			previous = previousNode;
			data = aData;
			next = nextNode;
		}
		
		private Node(int aData)
		{
			this(null, aData, null);
		}
	}
}
