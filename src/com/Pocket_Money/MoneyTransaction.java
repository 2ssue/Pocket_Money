package com.Pocket_Money;

public class MoneyTransaction {
	private int nMoney;
	private String sUseDate;
	private String sUsePlace;
	private int nCategory;
	private boolean bFixedCost;
	
	public int getMoney() {
		return nMoney;
	}
	public String getDate() {
		return sUseDate;
	}
	public String getPlace() {
		return sUsePlace;
	}
	public int getCategory() {
		return nCategory;
	}
	public boolean getFixed() {
		return bFixedCost;
	}
	public MoneyTransaction(int money, String useDate, String usePlace, int category, boolean fixedCost) {
		this.nMoney = money;
		this.sUseDate = useDate;
		this.sUsePlace = usePlace;
		this.nCategory = category;
		this.bFixedCost = fixedCost;
	}
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append(this.sUseDate);
		sb.append(" ");
		sb.append(this.nMoney);
		sb.append(" ");
		sb.append(this.nCategory);
		sb.append(" ");
		sb.append(this.sUsePlace);
		sb.append(" ");
		if(this.bFixedCost)
			sb.append("y");
		else sb.append("n");
		
		return sb.toString();
	}
}
