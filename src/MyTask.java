import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MyTask {

//-------------- task 1 ----------------------------------------------------------------------
	public String[] getMissedWords(String s, String t){
		String output = "";
		HashMap<Integer,String> map = new HashMap<Integer,String>();
		
		String[] S = s.split(" ");
		String[] T = t.split(" ");
		String pattern = "^[a-zA-Z ]*$"; 
		
		if(!s.matches(pattern) || !t.matches(pattern)){
			System.out.println("Only English alphabetic letters and spaces");
			return null;
		} 
		
		if(s.length() < 1 || s.length() > 106 || t.length() < 1 || t.length() > s.length()){
			System.out.println("1 <= lenght of t <= lenght of s <= 106 ");
			return null;	
		}
		
		for(int i = 0; i < T.length; i++){
			if(T[i].length() > 15){
				System.out.println("Lenght on any word should be less that 15");
				return null;
			}
			map.put(i,T[i]);
		}
		
		for(int i = 0; i < S.length; i++){
			if(S[i].length() > 15){
				System.out.println("Lenght on any word should be less that 15");
				return null;
			}
			if(!(map.containsValue(S[i]))) 
				output += S[i] + " ";
			else 
				map.remove(getKeyByValue(map,S[i]));
		}
	
		return output.split(" ");
	}
	
	
	private Integer getKeyByValue(HashMap<Integer,String> map,String val){
		for(Integer key : map.keySet()){
			if(map.get(key).equals(val))
				return key;
		}
		return null;
	}



//-------------- task 6 ----------------------------------------------------------------------	
	public String getWordsFromNumber(int number){
		String[] till_twenty = {"","one","two","three","four","five","six","seven","eight","nine",
				"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
		String[] till_hundred = {"","","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
		
		if(number < 0 ){
			return "minus " + getWordsFromNumber(Math.abs(number));
		}
		else if(number < 20){
			return till_twenty[number];
			
		}else if(number < 100 ){
			return till_hundred[number / 10] + ((number % 10 != 0) ? " " : "") + till_twenty[number % 10];
			
		}if (number < 1000) {
            return till_twenty[number / 100] + " hundred" + ((number % 100 != 0) ? " " : "") + getWordsFromNumber(number % 100);
        }

        if (number < 1000000) {
            return getWordsFromNumber(number / 1000) + " thousand" + ((number % 1000 != 0) ? " " : "") + getWordsFromNumber(number % 1000);
        }

        if (number < 1000000000) {
            return getWordsFromNumber(number / 1000000) + " million" + ((number % 1000000 != 0) ? " " : "") + getWordsFromNumber(number % 1000000);
        }

        return getWordsFromNumber(number / 1000000000) + " billion"  + ((number % 1000000000 != 0) ? " " : "") + getWordsFromNumber(number % 1000000000);
		
	}

		

//-------------- task 3 ----------------------------------------------------------------------
	public String firstRepeatedWord(String s){
		String[] S = s.split("[\\. ,:;-]+");
		
		if(s.length() == 0 || s.length() > 1024){
			System.out.println("Sentence length should be more than 0 and less that 1024");
			return "";
		}
		
		Set<String> set = new HashSet<String>();
		
		for(int i = 0; i < S.length; i++){
			if(set.contains(S[i]))
				return S[i];
			else
				set.add(S[i]);
		}
		
		return "";
	}
		
		
//-------------- task 2 ----------------------------------------------------------------------
	private String extractPalindrome(String str,int position,int startStep,int endStep){
		boolean flag = true;
		String result = "";
		while(position - startStep >= 0 && position + endStep < str.length() 
				&& str.charAt(position - startStep) == str.charAt(position + endStep) ){

				result = str.substring(position - startStep, position + endStep + 1);
				startStep++;
				endStep++;
		}
		
		return result;
	}
	
	public int getPalindromesNumber(String str){
		ArrayList<String> out = new ArrayList<String>();
		int counter = 0;
		
		str = str.replaceAll("\\s+", "");
		
		for(int i = 0; i < str.length(); i++){
			// with pivot
			if(i - 1 >= 0 && i + 1 < str.length()){ 
				if(str.charAt(i - 1) == str.charAt(i + 1)){
					String res = extractPalindrome(str,i,1,1);
					if(res.length() > 2)
						out.add(res) ;
				}	
				
				//without pivot
				if(str.charAt(i) == str.charAt(i + 1)){
					String res = extractPalindrome(str,i,1,2);
					if(res.length() > 2)
						out.add(res) ;
				}
			}
		}
	    
	    return out.size();
	}
		
	
//-------------- task 4 ----------------------------------------------------------------------
	public int simpleCalculator(String str){
		int res = 0;
		String regex = "^[0-9+-]*$";
		String numbersRegex = "[0-9]+";
		String operationsRegex = "[+-]+";
		
		if( str.length() < 3
				||!(str.matches(regex)) 
				|| str.substring(str.length() - 1).matches(operationsRegex)
				|| str.contains("+-")
				|| str.contains("-+")
				|| str.contains("++")
				|| str.contains("--")){
			System.out.println("Incorrect input !");
			return 0;
		}
		
		
		String[] digits = str.split(operationsRegex);
		String[] operations = str.split(numbersRegex);
		
	//			digits = getClearedArray(digits);
		
		if(str.charAt(0) == '-' || str.charAt(0) == '+'){
			str = "0" + str; 
			
			digits = str.split(operationsRegex);
			operations = str.split(numbersRegex);
		}
				
		res = Integer.parseInt(digits[0]);
		
		for(int i = 1;  i < digits.length; i++){
			 if(operations[i].equals("+"))
		           res += Integer.parseInt(digits[i]);
		     else if(operations[i].equals("-")) 
		           res -= Integer.parseInt(digits[i]);
		}
		
		return res;
	}
}
