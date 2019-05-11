package com.Pocket_Money;

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
		
		return sc.nextInt();
	}
	public Account createAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�뵷 ���� ���α׷� �Դϴ�. ���¸� �����ϱ� ���� �̸��� �Է��� �ּ���");
		String accountName = sc.nextLine();
		System.out.println("������ �ʱ� �ܾ��� �������ּ���");
		int accountBalance = sc.nextInt();
		
		Account new_account = new Account(accountName, accountBalance);
		
		return new_account;
	}
	public void showCategory() {
		Categories categories = Categories.getInstance();
		Iterator<String> categoryList = categories.iteratorCategories();
		int cnt = 1;
		while(categoryList.hasNext()) {
			System.out.println(Integer.toString(cnt) + ". " + categoryList.next());
			cnt++;
		}
	}
	public MoneyTransaction addTransaction() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("��� ���ڸ� �Է��ϼ���");
		String useDate = sc.nextLine();
		
		System.out.println("��� ī�װ��� �����ϼ���");
		this.showCategory();
		int category = Integer.parseInt(sc.nextLine());
		
		System.out.println("��� ��Ҹ� �Է��ϼ���");
		String usePlace = sc.nextLine();
		
		System.out.println("��� �ݾ��� �Է��ϼ��� (����:+/����:-)");
		int money = Integer.parseInt(sc.nextLine());
		
		System.out.println("���� ����/���� ���θ� �Է��ϼ���(y/n)");
		boolean fixed = false;
		
		if(sc.nextLine().equals("y"))
			fixed = true;
		
		MoneyTransaction transcation = new MoneyTransaction(money, useDate, usePlace, category, fixed);
		
		return transcation;
	}
	public int inputLimit() {
		Scanner sc = new Scanner(System.in);
		System.out.println("��� �˶��� ������ �ݾ��� �Է��ϼ���");
		return sc.nextInt();
	}
	public int deleteCategory() {
		Scanner sc = new Scanner(System.in);
		System.out.println("������ ī�װ��� ��ȣ�� �����ϼ���");
		return sc.nextInt();
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
