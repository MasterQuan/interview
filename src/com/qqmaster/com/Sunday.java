package com.qqmaster.com;

import java.util.ArrayList;
import java.util.List;

public class Sunday {
	
	public static void main(String[] args) {
//		System.out.println(isPattern(0, "abced","abced"));
//		System.out.println(isPattern(0, "abced","abca"));
//		System.out.println(isPattern(0, "abce","abced"));
//		System.out.println(isPattern(3, "aaabced","abced"));
//		System.out.println(isPattern(2, "aaabced","abcede"));
		
//		System.out.println("aaabcd".lastIndexOf('c'));
//		System.out.println("aaabcd".lastIndexOf('e'));
		
		
		System.out.println(Sunday("abcabcdabaabcdeabcabcdabaabcdeabcabcdabaabcdeabcabcdabaabcdeabcabcdabaabcdeabcabcdabaabcdeabcabcdabaabcdeabcabcdabaabcdeabcabcdabaabcdeabcabcdabaabcdeabcabcdabaabcdeabcabcdabaabcdeabcabcdabaabcdeabcabcdabaabcdeabcabcdabaabcdeabcabcdabaabcdeabcabcdabaabcdeabcabcdabaabcdeabcabcdabaabcdeabcabcdabaabcdeabcabcdabaabcdeabcabcdabaabcdeabcabcdabaabcdeabcabcdabaabcdeabcabcdabaabcdeabcabcdabaabcdeabcabcdabaabcdeabsssssscabcdabaabcdeabcabcdabaabcdeabcabcdabaabcdeabcabcdabaabcdeabcabcdabaabcdeabcabcdabaabcdeabcabcdabaabcdeabcabcdabaabcdeabcabcdabaabcde", "bcdeabsssssscabcdab"));
//		System.out.println(Sunday("abcabcdabaabcde", "abcdd"));
		
		
	}
	
	
	public static List<Integer> Sunday(String txt, String part){
		List<Integer> locs = new ArrayList<Integer>();
		final int tlen = txt.length();
 		final int plen = part.length();
 		
 		for(int start = 0, newS = 0; start + plen <= tlen; ){
 			if(isPattern(start, txt, part)){
 				locs.add(start);
 				start += plen;
 			}else{
 				newS = start + plen;
 				if(newS >= tlen)
 					break;
 				int lIndex = part.lastIndexOf(txt.charAt(newS));
 				if(lIndex == -1){
 					start = newS ++;
 				}else{
 					start += plen - lIndex;
 				}
 			}
 		}
		return locs;
	}
	
	private static boolean isPattern(int start, String txt, String part){
		boolean isPattern = true;
		
		//异常数据排除
		if(null == txt || null == part || start >= txt.length() || start + part.length() > txt.length()){
			isPattern =  false;
		}
		
		//判断字符串是否匹配
		for(int i = 0; isPattern && i < part.length(); i++){
			if(txt.charAt(i + start) != part.charAt(i)){
				isPattern = false;
				break;
			}
		}
		return isPattern;
	}
	
}
