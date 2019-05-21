package com.Pocket_Money;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class AccountUI {
	public int accountMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�޴��� �����ϼ���");
		System.out.println("1. �ŷ� ���� �߰��ϱ�");
		System.out.println("2. �ŷ� ���� ����");
		System.out.println("3. ��� �˶� �Ѱ� �����ϱ�");
		System.out.println("4. ���� �ܾ� ����");
		System.out.println("5. ��� ī�װ� �߰��ϱ�");
		System.out.println("6. ��� ī�װ� �����ϱ�");
		System.out.println("7. ���� �ʱ�ȭ�ϱ�");
		System.out.println("8. �����ϱ�");
		
		try{
			return sc.nextInt();
		}catch (InputMismatchException e) {
			System.out.println("�޴��� ���ڸ� �Է����ּ���");
			return 0;
		}
	}
	public Account createAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�뵷 ���� ���α׷� �Դϴ�. ���¸� �����ϱ� ���� �̸��� �Է��� �ּ���");
		String accountName = sc.nextLine();
		
		int accountBalance = 0;
		boolean numCheck = true;
		
		while(numCheck) {
			System.out.println("������ �ʱ� �ܾ��� �������ּ���");
			try{
				accountBalance= Integer.parseInt(sc.nextLine());
				numCheck = false;
			}catch (NumberFormatException e) {
				System.out.println("****���ڸ� �Է��ϼ���****");
			}
		}
		
		Account new_account = new Account(accountName, accountBalance);
		
		return new_account;
	}
	public int showCategory() {
		Categories categories = Categories.getInstance();
		Iterator<String> categoryList = categories.iteratorCategories();
		int cnt = 1;
		while(categoryList.hasNext()) {
			System.out.println(Integer.toString(cnt) + ". " + categoryList.next());
			cnt++;
		}
		return cnt - 1;
	}
	public MoneyTransaction addTransaction() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("��� ���ڸ� �Է��ϼ���");
		String useDate = sc.nextLine();
		
		int categoryNum = 0;
		int category = 0;
		boolean categoryCheck = true;
		
		while(categoryCheck) {
			System.out.println("��� ī�װ��� �����ϼ���");
			categoryNum = this.showCategory();
			try {
				category = Integer.parseInt(sc.nextLine());
				if(category > categoryNum || category <= 0) {
					System.out.println("****������ ���� ī�װ��Դϴ�.****");
				}else categoryCheck = false;
			}catch (NumberFormatException e) {
				System.out.println("****���ڸ� �Է��ϼ���****");
			}
			
		}
		
		System.out.println("��� ��Ҹ� �Է��ϼ���");
		String usePlace = sc.nextLine();
		
		int money = 0;
		boolean numCheck = true;
		while(numCheck) {
			System.out.println("��� �ݾ��� �Է��ϼ��� (����:+/����:-)");
			
			try{
				money = Integer.parseInt(sc.nextLine());
				numCheck = false;
			}catch(NumberFormatException e) {
				System.out.println("****���ڸ� �Է��ϼ���****");
			}
		}
		
		System.out.println("���� ����/���� ���θ� �Է��ϼ���(y/n)");
		boolean fixed = false;
		
		if(sc.nextLine().equals("y"))
			fixed = true;
		
		MoneyTransaction transcation = new MoneyTransaction(money, useDate, usePlace, category, fixed);
		
		return transcation;
	}
	public int inputLimit() {
		Scanner sc = new Scanner(System.in);
		boolean numCheck = true;
		int inputNum = 0;
		
		while(numCheck) {
			System.out.println("��� �˶��� ������ �ݾ��� �Է��ϼ���");
			try {
				inputNum = Integer.parseInt(sc.nextLine());
				numCheck = false;
			}catch (NumberFormatException e) {
				System.out.println("****���ڸ� �Է��ϼ���****");
			}
		}
		return inputNum;
	}
	public int deleteCategory() {
		Scanner sc = new Scanner(System.in);
		
		boolean numCheck = true;
		int inputNum = 0;
		
		while(numCheck) {
			System.out.println("������ ī�װ��� ��ȣ�� �����ϼ���");
			try {
				inputNum = Integer.parseInt(sc.nextLine());
				numCheck = false;
			}catch (NumberFormatException e) {
				System.out.println("****���ڸ� �Է��ϼ���****");
			}
		}
		
		return inputNum;
	}
	public String addCategory() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�߰��� ī�װ��� �Է��ϼ���");
		return sc.nextLine();
	}
	public String inputContinue() {
		Scanner sc = new Scanner(System.in);
		System.out.println("��� �Է��Ͻðڽ��ϱ�? (y/n)");
		return sc.nextLine();
	}
	public void showMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�޴��� ���ư����� �ƹ� Ű�� ��������");
		sc.nextLine();
	}
}