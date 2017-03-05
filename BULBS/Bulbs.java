import java.util.*;

/**

	N light bulbs are connected by a wire. Each bulb has a switch associated with it, however due to faulty wiring, a switch also changes the state of all the bulbs to the right of current bulb. Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs. You can press the same switch multiple times.

	Note : 0 represents the bulb is off and 1 represents the bulb is on.

	Example:

	Input : [0 1 0 1]
	Return : 4

	Explanation :
		press switch 0 : [1 0 1 0]
		press switch 1 : [1 1 0 1]
		press switch 2 : [1 1 1 0]
		press switch 3 : [1 1 1 1]

**/

class Bulbs {
	public static void main(String[] args) 
	{
		//Input String, can contain spaces and brackets
		String input = "[0 1 0 1]";
		input = input.replace('[', ' ');
		input = input.replace(']', ' ');
		Scanner inputScan = new Scanner(input);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		while(inputScan.hasNextInt())
		{
			list.add(inputScan.nextInt());
		}
		
		Bulbs s = new Bulbs();
		
		System.out.println(s.bulbs(list));
	}
	
	public int bulbs(ArrayList<Integer> a) 
	{
		//We start out checking for the first 0, by setting state to 0
		int flips = 0;
		int state = 0;
		
		//Loop through the entire array
		for(int i = 0; i < a.size(); i++)
		{
			//If we see our first state 0, we add 1 to flips, and we switch the state
			//we are looking for, since it means the NEW state 0. (Flips affect all outcome
			//to the right of the current position)
			if(state == a.get(i))
			{
				state = 1 - state;
				flips++;
			}
		}
		//Return the number of flips needed.
		return flips;
	}
	
}