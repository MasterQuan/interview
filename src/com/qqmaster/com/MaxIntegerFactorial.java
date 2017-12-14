package com.qqmaster.com;

public class MaxIntegerFactorial {
	
	public static void main(String[] args) {
		System.out.println(maxIntegerFactorial(1));
		System.out.println(maxIntegerFactorial(3));
		System.out.println(maxIntegerFactorial(5));
		System.out.println(maxIntegerFactorial(10));
		System.out.println(maxIntegerFactorial(5000));
	}
	
	public static String maxIntegerFactorial(int num){
		StringBuilder sb = new StringBuilder("1");
		//异常处理，默认返回结果为1
		if(num <=1){
			return sb.toString();
		}
		
		//用字符串表示结果
		for(int i = 2, carry = 0; i <= num; i++){
			StringBuilder sbm = new StringBuilder();
			
			for(int j = 0; j < sb.length(); j++){
				int res = (sb.charAt(j)-'0') * i + carry;
				carry = res / 10;
				sbm.append(res % 10);
			}
			while(carry != 0){
				sbm.append(carry % 10);
				carry = carry / 10;
			}
			sb = sbm;
		}
		sb.reverse();
		return sb.toString();
	}

}
