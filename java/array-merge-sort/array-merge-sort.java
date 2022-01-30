import java.util.*;

class array-merge-sort
{
    public static void main(String[] args)
    {
        // static arrays of strings provided by assignment instructions
        String[] section1 = {"Curie, Marie", "Feynman, Richard", "Germain, Sophie",
                             "Turing, Alan"};
        String[] section2 = {"Bolt, Usain", "Hamm, Mia", "Graf, Steffi"};
        String[] section3 = {"Bach, Johann Sebastian", "Beethoven, Ludwig van", 
                             "Mozart, Wolfgang Amadeus", "Schumann, Clara"};
        
	// merge the first two section		
        String[] merged = mergeSortedArrays(section1, section2);
		
        // merge the third section
		merged = mergeSortedArrays(merged, section3);
        
	// sort the merged array
        merged = bubbleSort(merged);
        
        // display confirmation of merge & sort
        int entries = merged.length;
        System.out.println(entries+" entries successfully merged and sorted." + "\n");
        
	// print the merged & sorted array
        for (int i = 0; i<entries; i++)
        {
        	System.out.println(merged[i]);
        }                
    }
    
    // This method merges two arrays of Strings
    public static String[] mergeSortedArrays(String[] a1, String[] a2)
    {
        String [] merged = new String[a1.length + a2.length];
        
        for (int i = 0; i<a1.length; i++)
        {
        	merged[i] = a1[i];
        }
        
        for (int i = 0; i<a2.length; i++)
        {
        	merged [i + a1.length] = a2[i];
        }        
        return merged;        
    }
    
    // Method that alphabetically bubble sorts elements inside an array of strings
    public static String[] bubbleSort(String [] array)
    {
    	int BubbleEnd = array.length-1;
    	boolean swapped = true;
    	
    	while (swapped == true)
    	{
    		swapped = false;
    		for (int i = 0; i<BubbleEnd; i++)
        	{
        		if (IsBigger(array[i], array[i+1]))
        		{
        			Swap(array, i, i+1);
        			swapped = true;
        		}
        	}
    		BubbleEnd --;
    	}    	
    	return array;    	
    }
    
    // Method that compares two strings and returns TRUE if the first string is alphabetically bigger than the second
    public static boolean IsBigger(String left, String right)
    {
    	boolean leftIsBigger;
    	
    	//determine the length of the smaller String (to avoid going out of bounds)
    	int smallestLength;
    	if (left.length() < right.length())
    	{
    		smallestLength = left.length();
    		leftIsBigger = false;				//catch value in case left is wholly contained by right
    	}
    	else
    	{
    		smallestLength = right.length();
    		leftIsBigger = true;				//catch value in case right is wholly contained by left
    	}
 
    	for (int i = 0; i < smallestLength-1; i++)
    	{
    		if ((int)left.charAt(i) > (int)right.charAt(i))
    		{
    			leftIsBigger = true;
    			break;
    		}
    		if ((int)left.charAt(i) < (int)right.charAt(i))
    		{
    			leftIsBigger = false;
    			break;
    		}
    	}
    	return leftIsBigger;
    }
    
    // Method that swaps position a and b in an array of Strings
    public static void Swap(String[] array, int a, int b)
    {
    	String temp = array[a];
    	array[a] = array[b];
    	array[b] = temp;
    }
}
