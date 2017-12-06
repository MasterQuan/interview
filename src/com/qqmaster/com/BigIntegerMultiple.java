package com.qqmaster.com;

public class BigIntegerMultiple {

	public static void main(String[] args) {
		System.out.println(mulBigInteger("66666666666666","99999999999999999999999999999"));
		System.out.println(mulBigInteger("999","888"));
		System.out.println(mulBigInteger("999","77"));
		System.out.println(mulBigInteger("77","999"));
	}

	/*
	 *
	 * 计算两个大正整数（字符串或数组表示）的乘积。
	 * 输入：两个大整数 s1,s2
	 * 输出：乘积    s
	 * 
	 */
	private static String mulBigInteger(String s1, String s2){
		//判断非法字符串
		if(null == s1 || null == s2){
			return null;
		}

		int l1 = s1.length();
		int l2 = s2.length();
		int res_start = 0;
		char zero = '0';
		StringBuilder sb = new StringBuilder();

		for(int i = l1 - 1; i >= 0; i--){
			int pre = 0;

			int re_index = res_start;
			for(int j = l2 - 1; j >= 0; j--){
				int sum = pre 
						+ (s1.charAt(i) - zero)*(s2.charAt(j) - zero) 
						+ (sb.length() <= re_index? 0 : sb.charAt(re_index) - zero);
				pre = sum / 10;
				sum %= 10;
				if(sb.length() <= re_index){
					sb.append(sum);
				}else{
					sb.setCharAt(re_index, (char)(sum + zero));
				}
				re_index++;
			}
			if(pre > 0)
				sb.append(pre);
			res_start++;
		}

		return sb.reverse().toString();
	}
}


