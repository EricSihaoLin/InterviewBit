import java.util.*;

/**

	Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.

	NOTE A solution will always exist. read Goldbach’s conjecture

	Example:


	Input : 4
	Output: 2 + 2 = 4

	If there are more than one solutions possible, return the lexicographically smaller solution.

	If [a, b] is one solution with a <= b,
	and [c,d] is another solution with c <= d, then

	[a, b] < [c, d] 

	If a < c OR a==c AND b<d. 

**/
class Primesum {
	public static void main(String[] args)
	{
		int targetSum = 10;
		
		Primesum s = new Primesum();
		for (Integer i : s.primesum(targetSum)) {
			System.out.print(i + " ");
		}
	}
	
	public ArrayList<Integer> primesum(int a)
	{
		ArrayList<Integer> primes = new ArrayList<Integer>();
		ArrayList<Integer> solution = new ArrayList<Integer>();
		
		//Generate primes up to int a
		//Anything more is pointless
		for(int i = 2; i <= a; i++)
		{
			if(isPrime(i))
			{
				primes.add(i);
			}
		}
		
		//Check if any of the two primes adds up to the target sum
		for(int i = 0; i < primes.size(); i++)
		{
			for(int j = 0; j < primes.size(); j++)
			{
				if(primes.get(i) + primes.get(j) == a)
				{
					//If it does, return the two integers as ArrayList
					solution.add(primes.get(i));
					solution.add(primes.get(j));
					return solution;
				}
			}
		}
		//If not, return null
		return null;
	}
	
	//Helper method to determine if a given integer is prime
	private boolean isPrime(int a)
	{
		//If is even integer greater than 2, return false
		if(a > 2 && a % 2 == 0)
			return false;
		//We should only try up to the square root of the given number
		//Anything more, we would just be looping backwards, which is useless
		int sqrt = (int)Math.sqrt(a) + 1;
		for(int i = 3; i < sqrt; i+=2)
			if(a % i == 0)
				return false;
		//After passing the for loop, it's safe to assume the number is prime
		return true;
	}
}