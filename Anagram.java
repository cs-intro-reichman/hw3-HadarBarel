/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.

		
		 
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
		


	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		
		boolean isAnagram = false;
		String newstr1 = preProcess(str1);
		String newstr2 = preProcess(str2);
		boolean [] usedarr = new boolean[newstr1.length()];

		if (newstr1.length() == newstr2.length()){
			for (int i = 0; i < newstr1.length(); i ++){
				for (int j=0; j <newstr2.length(); j ++){
					if (newstr1.charAt(i)== newstr2.charAt(j)){

						usedarr [j] = true;
					}
				}
			}

			boolean alltrue = true;
			for (int k = 0; k < usedarr.length; k ++){
				if (usedarr[k] != true){
				alltrue = false;
				}
			}
			if (alltrue == true){
			isAnagram = true;
			}
		}
		
		return isAnagram;
	}
	   

	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		
		String lowerstr = str.toLowerCase();
		String newstr = "";
		for (int i = 0; i < str.length(); i ++){
			if (lowerstr.charAt(i) >= 'a' && lowerstr.charAt(i) <= 'z'){
				newstr += lowerstr.charAt(i);
			}
		}
		return newstr;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		
		String result = "";
		char [] strarr = new char[str.length()];
		for (int i = 0; i < strarr.length; i ++){
			strarr[i]=str.charAt(i);
		}

		while (result.length() < str.length()){

			int rand = (int) ((Math.random()*str.length()));
			if (strarr[rand] != 0){
				result += strarr[rand];
				strarr[rand] = 0;
			}
			
		}
		return result;
	}
}
