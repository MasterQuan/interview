package com.qqmaster.com;

/**
 * 给出两个字符串，写一个函数找到最长公共子串，并返回其长度。
 * 注意事项：
 * 		子串的字符应该连续的出现在原字符串中，这与子序列有所不同。
 * 格式：
 * 		输入行输入两个字符串 A 和 B，最后输出最长公共子串的长度。
 * 样例输入:
 * 		A = “ABCD”
 * 		B = “CBCE”
 * 样例输出:
 * 		2
 * 
 * @author zhaoshiquan 2017年12月12日 下午2:38:39
 *
 */
public class LongestCommonSubString {
	public static void main(String[] args) {
		
	}
	
	//暴力枚举匹配法
	public static int longSubStringLen1(String s1,String s2){
		int subLen = 0;
		
		if(null == s1 || null == s2){
			return subLen;
		}
		String stS = s1.length() < s2.length() ? s1:s2;
		String lS = stS==s1?s2:s1;
		
		
		
		
		return subLen;
	}
	
	//动态规划法（空间换时间）
	public static int longSubStringLen2(String s1,String s2){
		int subString = 0;
		
		if(null == s1 || null == s2){
			return 0;
		}
		
		return subString;
	}
}
