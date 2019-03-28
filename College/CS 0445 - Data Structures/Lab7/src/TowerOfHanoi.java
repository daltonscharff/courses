
public class TowerOfHanoi
{
	// TO DO: Instance Variables
    int numberOfDiscs;
    int[] tower0 = new int[0];
    int[] tower1 = new int[0];
    int[] tower2 = new int[0];
    boolean returnValue;

	/* Construct the Towers of Hanoi (3 towers) with aNumDisc
	 * on the first tower. Each tower can be identified by an
	 * integer number (0 for the first tower, 1 for the second
	 * tower, and 2 for the third tower). Each disc can be identified
	 * by an integer number starting from 0 (for the smallest disc)
	 * and (aNumDisc - 1) for the largest disc.
	 */
	public TowerOfHanoi(int aNumDiscs)
	{
		// TO DO: Constructor
            numberOfDiscs = aNumDiscs;
            tower0 = new int[numberOfDiscs];
            for(int count = 0; count < numberOfDiscs; count++){
                tower0[count] = numberOfDiscs - 1 - count;
            }
	}
	
	/* Returns an array of integer representing the order of
	 * discs on the tower (from bottom up). The bottom disc should
	 * be the first element in the array and the top disc should be
	 * the last element of the array. The size of the array MUST
	 * be the number of discs on the tower. For example, suppose
	 * the tower 0 contains the following discs 0,1,4,6,7,8 (from top
	 * to bottom). This method should return the array [8,7,6,4,1,0]
	 * (from first to last). 
	 * @param tower the integer identify the tower number.
	 * @return an array of integer representing the order of discs.
	 */
	public int[] getArrayOfDiscs(int tower)
	{
		// TO DO
            if(tower == 0){
                return tower0;
            }else if(tower == 1){
                return tower1;
            }else{
                return tower2;
            }
	}
	
	/* Gets the total number of discs in this Towers of Hanoi
	 * @return the total number of discs in this Towers of Hanoi
	 */
	public int getNumberOfDiscs()
	{
		// TO DO
            return numberOfDiscs;
	}
	
	/* Gets the number of discs on a tower.
	 * @param tower the tower identifier (0, 1, or 2)
	 * @return the number of discs on the tower.
	 */
	public int getNumberOfDiscs(int tower)
	{
		// TO DO
            if(tower == 0){
                return tower0.length;
            }else if(tower == 1){
                return tower1.length;
            }else{
                return tower2.length;
            }
	}
	
	/* Moves the top disc from fromTower to toTower. Note that
	 * this operation has to follow the rule of the Tower of Hanoi
	 * puzzle. First fromTower must have at least one disc and second
	 * the top disc of toTower must not be smaller than the top disc
	 * of the fromTower.
	 * @param fromTower the source tower
	 * @param toTower the destination tower
	 * @return ture if successfully move the top disc from
	 *         fromTower to toTower.
	 */
	public boolean moveTopDisc(int fromTower, int toTower)
	{
		// TO DO
            int[] fromPole = new int[0], toPole = new int[0], tempTower = new int[0];
            int otherTower = 3 - fromTower - toTower;
            boolean toReturn = true;
            
            if(fromTower == 0){
                fromPole = tower0;
            }else if(fromTower == 1){
                fromPole = tower1;
            }else if(fromTower == 2){
                fromPole = tower2;
            }else{
                System.out.println("Error!");
            }
            
            if(toTower == 0){
                toPole = tower0;
            }else if(toTower == 1){
                toPole = tower1;
            }else if(toTower == 2){
                toPole = tower2;
            }else{
                System.out.println("Error!");
            }

            
            if(fromPole.length == 0){
                return false;
//                toReturn = false;
            }else if(fromTower == toTower){
                return false;
//                toReturn = false;
            }else if(fromPole.length > 0 && toPole.length > 0){
                if(fromPole[fromPole.length-1] > toPole[toPole.length-1]){
                    return false;
//                    toReturn = false;
                }
            }
            //else{
                tempTower = new int[toPole.length+1];
                for(int count = 0; count < toPole.length; count ++){
                    tempTower[count] = toPole[count];
                }
                tempTower[tempTower.length-1] = fromPole[fromPole.length-1];
                toPole = tempTower;
                
                
                tempTower = new int[fromPole.length-1];
                for(int count = 0; count < tempTower.length; count ++){
                    tempTower[count] = fromPole[count];
                }
                fromPole = tempTower;
            //}
            
            if(fromTower == 0){
                tower0 = fromPole;
            }else if(fromTower == 1){
                tower1 = fromPole;
            }else if(fromTower == 2){
                tower2 = fromPole;
            }else{
                System.out.println("Error!");
            }
            
            if(toTower == 0){
                tower0 = toPole;
            }else if(toTower == 1){
                tower1 = toPole;
            }else if(toTower == 2){
                tower2 = toPole;
            }else{
                System.out.println("Error!");
            }

            return toReturn;

        }
        
        public void printArray(int[] current){
            for(int count = 0; count < current.length; count ++){
                System.out.println(current[count]);
            }
        }
}
