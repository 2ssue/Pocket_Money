package com.Pocket_Money;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Account {
	private List<MoneyTransaction> account;
	private int nBalance;
	private int nLimit;
	private String sAccountName;
	
	public Account(String accountName, int balance) {
		this.setBalance(balance);
		this.sAccountName = accountName;
		this.account = new ArrayList<>();
		
		File accountFile = new File(".\\Account\\" + this.sAccountName+".txt");
		try {
			FileReader fileReader = new FileReader(accountFile);
			BufferedReader bufferReader = new BufferedReader(fileReader);
			
			String sLine = "";
			try {
				bufferReader.readLine();
				bufferReader.readLine();
				while((sLine = bufferReader.readLine()) != null){
					String[] transaction = this.parsingAccountFile(sLine);
					int money = Integer.parseInt(transaction[1]);
					int category = Integer.parseInt(transaction[2]);
					boolean fixedCost;
					if(transaction.equals("y")) fixedCost = true;
					else fixedCost = false;
					
					this.account.add(new MoneyTransaction(money, transaction[0], transaction[3], category, fixedCost));
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private String[] parsingAccountFile(String s) {
		return s.split(" ");
	}
	
	public String getAccountName() {
		return sAccountName;
	}
	public void addTransaction(MoneyTransaction transaction) {
		this.account.add(transaction);
		this.nBalance += transaction.getMoney();
		System.out.println(sAccountName +"의 현재 잔액은 " + nBalance + "입니다.");
		if(this.nBalance <= this.nLimit) System.out.println("잔액이 부족합니다");
	}
	public void deleteAllTransaction() {
		account.removeAll(account);
	}
	public Iterator<MoneyTransaction> iteratorTransaction(){
		return account.iterator();
	}
	public int getBalance() {
		return nBalance;
	}
	public void setBalance(int balance) {
		this.nBalance = balance;
	}
	public int getLimit() {
		return nLimit;
	}
	public void setLimit(int limit) {
		this.nLimit = limit;
	}
	public void saveAccount() {
		File accountFile = new File(".\\Account\\" + this.sAccountName+".txt");
		try {
			BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(accountFile));
			
			if(accountFile.isFile() && accountFile.canWrite()) {
				Iterator<MoneyTransaction> transaction = this.iteratorTransaction();
				bufferWriter.write(Integer.toString(this.nBalance));
				bufferWriter.newLine();
				bufferWriter.newLine();
				while(transaction.hasNext()) {
					bufferWriter.write(transaction.next().toString());
					bufferWriter.newLine();
				}
				bufferWriter.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
