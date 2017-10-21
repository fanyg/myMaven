package com.pactera.util;

public class VerifyIdCard {
	// wi =2(n-1)(mod 11)
	final int[] wi = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1 };
	// verify digit
	final int[] vi = { 1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2 };
	private int[] ai = new int[18];

	public VerifyIdCard() {
	}

	/**
	 * 身份证较验
	 * 
	 * @param idcard
	 * @return 成功：true 失败:false
	 * @author pengwzh
	 * @since 2010-3-21
	 */
	public boolean Verify(String idcard) {
		if (idcard.length() == 15) {
			idcard = uptoeighteen(idcard);
		}
		if (idcard.length() != 18) {
			return false;
		}
		String verify = idcard.substring(17, 18);
		if (verify.equals(getVerify(idcard))) {
			return true;
		}
		return false;
	}

	/**
	 * 得到身份证号码最后一位
	 * 
	 * @param eightcardid
	 * @return 身份证号码最后一位值
	 * @author pengwzh
	 * @since 2010-3-21
	 */
	public String getVerify(String eightcardid) {
		int remaining = 0;
		if (eightcardid.length() == 18) {
			eightcardid = eightcardid.substring(0, 17);
		}
		if (eightcardid.length() == 17) {
			int sum = 0;
			for (int i = 0; i < 17; i++) {
				String k = eightcardid.substring(i, i + 1);
				ai[i] = Integer.parseInt(k);
			}
			for (int i = 0; i < 17; i++) {
				sum = sum + wi[i] * ai[i];
			}
			remaining = sum % 11;
		}
		return remaining == 2 ? "X" : String.valueOf(vi[remaining]);
	}

	/**
	 * 身份证15位转18位
	 * 
	 * @param fifteencardid
	 * @return
	 * @author pengwzh
	 * @since 2010-3-21
	 */
	public String uptoeighteen(String fifteencardid) {
		String eightcardid = fifteencardid.substring(0, 6);
		eightcardid = eightcardid + "19";
		eightcardid = eightcardid + fifteencardid.substring(6, 15);
		eightcardid = eightcardid + getVerify(eightcardid);
		return eightcardid;
	}
	
	public static void main(String[] args) {
		String id="110105710923582";
		VerifyIdCard qwe=new VerifyIdCard();
		 boolean flag = qwe.Verify(id);
		 System.out.println(flag);
	}

}
