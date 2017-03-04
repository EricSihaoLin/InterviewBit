import java.util.*;
import java.net.*;

/**
	There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

	You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i
	to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

	Return the minimum starting gas station’s index if you can travel around the circuit once,
	otherwise return -1.

	You can only travel in one direction. i to i+1, i+2, ... n-1, 0, 1, 2..
	Completing the circuit means starting at i and ending up at i again.

**/
class Gas {
	public static void main(String[] args) {
		Gas s = new Gas();
		List<Integer> gas = new ArrayList<Integer>();
		List<Integer> cost = new ArrayList<Integer>();
		
		//Paste the input string for arg1 in gasString
		String gasString = "39 959 329 987 951 942 410 282 376 581 507 546 299 564 114 474 163 953 481 337 395 679 21 335 846 878 961 663 413 610 937 32 831 239 899 659 718 738 7 209";
		//Paste the input string for arg2 in costString
		String costString = "39 862 783 134 441 177 416 329 43 997 920 289 117 573 672 574 797 512 887 571 657 420 686 411 817 185 326 891 122 496 905 910 810 226 462 759 637 517 237 884";
		
		Scanner gasScan = new Scanner(gasString);
		Scanner costScan = new Scanner(costString);
		
		while (gasScan.hasNextInt() && costScan.hasNextInt()) {
			gas.add(gasScan.nextInt());
			cost.add(costScan.nextInt());
		}
		
		System.out.println(s.canCompleteCircuit(gas, cost));
	}
	
	public int canCompleteCircuit(final List<Integer> gas, final List<Integer> cost) {
		//Check for all gas stations as starting point
		for(int i = 0; i < gas.size(); i++)
		{
			//Set up initial environment
			int currentGas = 0;
		    int startPos = i;
		    int currentPos = i;
		    do
		    {
				//Get gas currently alloted
				currentGas += gas.get(currentPos);
				//Check if it can make it to the next station
				if(cost.get(currentPos) > currentGas)
				{
					//If it can't, break this loop
					break;
				}
				//If it can make it to the next station, then keep going, deduct gas
				currentGas -= cost.get(currentPos);
				currentPos++;
				//Check if it is out of bounds
				if(currentPos == cost.size())
				{
					currentPos = 0;
				}
				if(startPos == currentPos)
				{
					return startPos;
				}
			}
			//Keep going until it returns to the start again
			while(startPos != currentPos);
		}
		return -1;
	}
}