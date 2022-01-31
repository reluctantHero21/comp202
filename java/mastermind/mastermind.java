//A3Q1

import java.util.*;

public class Question1
{
	//MASTERMIND GAME
	public static void main(String[] args)
	{
		//Mastermind generates a random number and greets user
	    int[] answer = generateRandomValidNumber();
	    	    
	    System.out.println("Welcome to Mastermind.");
	    System.out.println("I have a 4 digit number in mind. Can you guess it?"+"\n");
		
		//Ask user to input a string and convert it into an array of integers; keep asking until game is over
	    boolean guessed = false;
	    while(!guessed)
	    {
	    	int[] userAttempt = AskUser();
	    	
	    	//Print back the user's entry 
	    	System.out.print	(
								""+
								userAttempt[0]+
								userAttempt[1]+
								userAttempt[2]+
								userAttempt[3]+
								"\t"+
								"<-------- user input"+
								"\n\n"
	    						);
	    	
	    	//determine the number of perfect matches and off matches
	    	int perfectmatches = perfectMatches(userAttempt, answer);
	    	int offmatches = offPlaceMatches(userAttempt, answer);
	    	
	    	System.out.println("perfect matches: " + perfectmatches + "\t" + "off place: " + offmatches + "\n\n");
	    	
	    	if (perfectmatches == 4)
	    	{
	    		guessed = true;
	    	}
	    }
	    
	    //User found the right answer. Game over.
	    System.out.println("Yes! You guessed my number correctly. Well done.");
	}
	
    //Method that asks user to input his/her guess; check that the entry is valid
    public static int[] AskUser()
    {
    	System.out.println("What is your guess?");
		Scanner input = new Scanner(System.in);
		String userString = input.next();
	    
	    //convert the user input (string) into an array of integers
		int[] userinput = new int[userString.length()];
	    for (int i = 0; i<userString.length(); i++)
	    {
	    	userinput[i] = Integer.parseInt(String.valueOf(userString.charAt(i)));
	    }
	    
	    //verify that the user input is valid; otherwise repeat the above
	    boolean isUserInputValid = isValidNumber(userinput);    
	    
	    int[] validatedInput = userinput;
	    while (!isUserInputValid)
	    {
	    	System.out.println("This is not a valid input."+"\n");
	    	validatedInput = AskUser();
	    	if (isUserInputValid = true)
	    	{
	    		break;
	    	}
	    }
	    
	    //after validation, the user's array is returned
	    return validatedInput;
    }

	//method that checks the number of perfect matches between the user's input and the generated number
	public static int perfectMatches (int[] userattempt, int[] answer)
	{
		int perfectMatches = 0;
		
		//check each digit of of the user's attempt against each digit of the answer
		for (int i=0; i<4; i++)
		{
			if (userattempt[i] == answer[i])
			{
				perfectMatches++;
			}
		}
		
		return perfectMatches;
	}
	
	//method that checks the number of OFF places between the user's input and the generated number
		public static int offPlaceMatches (int[] userattempt, int[] answer)
		{
			int offPlaceMatches = 0;
			
			//check each digit of of the user's attempt against each digit of the answer
			for (int i=0; i<4; i++)
			{
				for (int j=0; j<4; j++)
				{
					//check for off-matches; exclude same position
					if (i != j && userattempt[i] == answer[j]) 
					{
						offPlaceMatches++;
					}
				}
			}
			
			return offPlaceMatches;
		}
	
	//Random number generator
	public static int[] generateRandomValidNumber()
	{
		//create an array of length 4 and assign a random integer for each value
		int[] randomArray = new int[4];
		for (int i=0; i<4; i++)
		{
			randomArray[i] = (int) (10*Math.random());
		}
		
        //check if the array generated is valid, otherwise restart the current method
		if(isValidNumber(randomArray)==true)
		{
			return randomArray;
		}
		else
		{
			return generateRandomValidNumber();
		}
	}
	
	//method that checks whether an array is valid
	public static boolean isValidNumber (int[] a)
	{
		//array must be length 4
		if(a.length != 4)
		{
			return false;
		}
		
		//array must contain no repeating element
		else if(
			a[0] != a[1] &&
			a[0] != a[2] &&
			a[0] != a[3] &&

			a[1] != a[2] &&
			a[1] != a[3] &&
			
			a[2] != a[3]
			)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
}