
/**
	Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

	Example,
	Given:

	s1 = "aabcc",
	s2 = "dbbca",
	When s3 = "aadbbcbcac", return true.
	When s3 = "aadbbbaccc", return false.

	Return 0 / 1 ( 0 for false, 1 for true ) for this problem
**/
class Interleave {
	
	public static void main(String[] args) {
		
		//Input public testing variables here
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		
		Interleave s = new Interleave();
		System.out.println(s.isInterleave(s1, s2, s3));
	}
	
	public int isInterleave(String a, String b, String c) 
	{
		//Initialize testing variables
		int indexA = 0;
		int indexB = 0;
		int offset = 0;
		int lenA = a.length();
		int lenB = b.length();
		
		//Check for the length of String c
		for(int i = 0; i < c.length(); i++)
		{
			//If current index we are checking matches both String a's current position
			//and String b's current position, then include offset so we can backtrack
			if(indexA < lenA && indexB < lenB && b.charAt(indexB) == a.charAt(indexA))
				offset = 1;

			//If current position in String c matches with current position in String a
			//Increment String a index
			if(indexA < lenA && (c.charAt(i) == a.charAt(indexA)))
				indexA++;
			//If current position in String c matches with current position in String b
			//Increment String a index
			else if(indexB < lenB && (c.charAt(i) == b.charAt(indexB)))
				indexB++;
			//If current position in String c matches with current position in String a
			//given the offset, then we know we need to go back and correct our index
			//Remove offset.
			else if(indexA + offset < lenA && c.charAt(i) == a.charAt(indexA + offset))
			{
				indexA+=2;
				indexB--;
				offset = 0;
			}
			//If current position in String c matches with current position in String b
			//given the offset, then we know we need to go back and correct our index
			//Remove offset.
			else if(indexB + offset < lenB && c.charAt(i) == b.charAt(indexB + offset))
			{
				indexB+=2;
				indexA--;
				offset = 0;
			}
			//String does not match, return 0
			else return 0;
		}
		//After passing all the checks, this solution is correct, so return 1
		return 1;
	}
}