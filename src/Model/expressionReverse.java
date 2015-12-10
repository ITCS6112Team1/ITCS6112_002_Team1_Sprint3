package Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class expressionReverse {
	
	static List operationList;
	static Set paraSet;
	public static String reverse(String str){
		for(int i=0; i<str.length(); i++){
			if(str.charAt(i)=='^'){
				int num = Integer.valueOf(String.valueOf(str.charAt(i+1)));
				String append="";
				while(num>1){
					append = append+"*"+str.charAt(i-1);
					num--;
				}
				str = str.replace("^"+String.valueOf(str.charAt(i+1)), append);
			}
		}
	return str;
	}
	
//	public static void main(String[] args){
//		System.out.println(reverse("a^2+b^3"));
//	}
}
