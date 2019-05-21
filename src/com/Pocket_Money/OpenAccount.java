package com.Pocket_Money;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class OpenAccount {
	public static void main(String[] args) {
		AccountUI accountUI = new AccountUI();
		Account account = null;
		
		File accountFolder = new File(".\\Account");
		if(accountFolder.exists()) {
			File[] accountList = accountFolder.listFiles();
			for(File file: accountList) {
				if(file.isFile()) {
					int nBalance = 0;
					try {
						FileReader fileReader = new FileReader(file);
						BufferedReader bufferReader = new BufferedReader(fileReader);
						try {
							nBalance = Integer.parseInt(bufferReader.readLine());
						} catch (NumberFormatException e) {
							nBalance = 0;
							System.out.println("계좌에 저장된 총액의 상태를 확인하십시오");
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String fileName = file.getName();
					fileName = fileName.substring(0,fileName.indexOf(".txt"));
					account = new Account(fileName, nBalance);
					break;
				}
			}
			if(account == null)
				account = accountUI.createAccount();
		}
		else{
			accountFolder.mkdirs();
			account = accountUI.createAccount();
		}
		
		Categories categories = Categories.getInstance();
		
		while(true) {
			String sContinue = "y";
			switch(accountUI.accountMenu()) {
			case 1:
				while(sContinue.equals("y")) {
					account.addTransaction(accountUI.addTransaction());
					sContinue = accountUI.inputContinue();
				}
				break;
			case 2:
				Iterator<MoneyTransaction> transaction = account.iteratorTransaction();
				while(transaction.hasNext()) {
					System.out.println(transaction.next().toString());
				}
				break;
			case 3:
				account.setLimit(accountUI.inputLimit());
				break;
			case 4:
				System.out.print("현재 잔액: ");
				System.out.println(account.getBalance());
				break;
			case 5:
				categories.addCategory(accountUI.addCategory());				
				break;
			case 6:
				accountUI.showCategory();
				categories.deleteCategory(accountUI.deleteCategory());
				break;
			case 7:
				account.deleteAllTransaction();
				account.setBalance(0);
				System.out.print("계좌가 초기화 되었습니다. 현재 잔액: ");
				System.out.println(account.getBalance());
				break;
			case 8:
				categories.saveCategory();
				account.saveAccount();
				return;
			}
			accountUI.showMenu();
		}
	}
}
