package com.qqmaster.com.meituan;

/**
 * 现在有一个数组，其值为从1到10000的连续增长的数字。
 * 出于某次偶然操作，导致这个数组中丢失了某三个元素，
 * 同时顺序被打乱，现在需要你用最快的方法找出丢失的这三个元素，
 * 并且将这三个元素根据从小到大重新拼接为一个新数字，计算其除以7的余数。 
 * 例：
 * 	丢失的元素为336，10，8435，得到的新数字为103368435，除以七的余数为2。
 * 
 * @author zhaoshiquan 2017年12月27日 下午5:28:57
 *
 */
public class LostThreeNums {
	public static void main(String[] args) {
		long num = 9998999910000l;
		System.out.println(Long.parseLong("9998999910000")%7);
	}
	public static int findLostThreeNums(int[] nums){
		return (int) (Long.parseLong(lostThreeNums(nums)) % 7);
	}

	private static String lostThreeNums(int[] nums){
		int[] index = new int[10001];
		for(int num : nums){
			index[num] = 1;
		}
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for(int i = 1; i < index.length; i++){
			if(index[i] == 0){
				count++;
				sb.append(index[i]);
			}
			if(count == 3)
				break;
		}
		return sb.toString();
	}

	private static int RemainderOf7(String num){
		return (int) (Long.parseLong(num) % 7);
	}
}
