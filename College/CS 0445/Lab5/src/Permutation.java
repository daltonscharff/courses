import java.util.ArrayList;


public class Permutation
{

	public static ArrayList<ArrayList<Integer>> permutation(final ArrayList<Integer> list)
	{
		// TO DO
            return permute(list);
            
	}
        
        public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> list){
                // TO DO
            ArrayList<ArrayList<Integer>> result = new ArrayList();
            permute(list, 0, result);
            return result;          
        }
        
        public static void permute(ArrayList<Integer> list, int first, ArrayList<ArrayList<Integer>> result){
            if(first >= list.size()){
                ArrayList<Integer> temp = arrayToList(list);
                result.add(temp);
            }
            
            for(int count = first; count < list.size(); count++){
                swap(list, first, count);
                permute(list, first + 1, result);
                swap(list, first, count);
            }
        }
        
        private static ArrayList<Integer> arrayToList(ArrayList<Integer> list){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int count = 0; count < list.size(); count++){
                temp.add(list.get(count));
            }
            return temp;
        }
        
        public static void swap(ArrayList<Integer> a, int b, int c){
            int temp = a.get(b);
            a.set(b, a.get(c));
            a.set(c, temp);
        }

}
