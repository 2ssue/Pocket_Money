package com.Pocket_Money;

public class MoneyTransaction {
	private int nMoney;
	private String sUseDate;
	private String sUsePlace;
	private String sCategory;
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
	public String getCategory() {
		return sCategory;
	}
	public boolean getFixed() {
		return bFixedCost;
	}
	public MoneyTransaction(int money, String useDate, String usePlace, int category, boolean fixedCost) {
		this.nMoney = money;
		this.sUseDate = useDate;
		this.sUsePlace = usePlace;
		
		Categories categories = Categories.getInstance();
		
		this.sCategory = categories.getCategory(category - 1);
		this.bFixedCost = fixedCost;
	}
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append(this.sUseDate);
		sb.append(" ");
		sb.append(this.nMoney);
		sb.append(" ");
		sb.append(this.sCategory);
		sb.append(" ");
		sb.append(this.sUsePlace);
		sb.append(" ");
		if(this.bFixedCost)
			sb.append("y");
		else sb.append("n");
		
		return sb.toString();
	}
}
