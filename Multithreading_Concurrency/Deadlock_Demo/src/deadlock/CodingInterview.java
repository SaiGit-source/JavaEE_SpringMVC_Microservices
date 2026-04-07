package deadlock;

import java.util.ArrayList;
import java.util.List;

public class CodingInterview {
// reverse the String
	
	public static void main(String[] args) {
		String str = "Abc";
		StringBuilder sb = new StringBuilder();
		List<Character> arrL = new ArrayList<>();
		/*
		for (char c:str.toCharArray()) {
			arrL.add(0, c);
			//sb.append(arrL.get(0));
		}
		*/
		
		for (int i=str.length()-1; i>=0; i--) {
			sb.append(str.charAt(i));
		}

		
		System.out.println(sb.toString());

	}
	
	/*
	 * Author(authorid, firstname, lastname), Book(author_id, bookid, publisherid, title), Publishers(publisher publisherid, publishername)
	 * 
	 * 1.author authorid, firstname, lastname
		2.book author_id, bookid, publisherid, title
		3.publisher publisherid, publishername

all books with its author_name, publisher

select b.firstname, p.publishername
from book b, a author, p publisher 
where b.author_id = a.authorid and b.publisherid = p.publisherid;
 
	 */

}
