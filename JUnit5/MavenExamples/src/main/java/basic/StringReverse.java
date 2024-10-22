package basic;

public class StringReverse {
	
	public String reversedString(String str) {
		char[] charArr = str.toCharArray();
		int left = 0;
		int right = str.length()-1;
		
		while (left<right) {
			char temp = charArr[left];
			charArr[left] = charArr[right];
			charArr[right] = temp;
			
			left++;
			right--;
			
		}
		return new String(charArr);
	}

}
