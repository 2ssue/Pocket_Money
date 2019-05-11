package com.Pocket_Money;

import java.util.Iterator;
import java.util.Scanner;

public class AccountUI {
	public int accountMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴를 선택하세요");
		System.out.println("1. 거래 내역 추가하기");
		System.out.println("2. 거래 내역 보기");
		System.out.println("3. 경고 알람 한계 설정하기");
		System.out.println("4. 현재 잔액 보기");
		System.out.println("5. 사용 카테고리 추가하기");
		System.out.println("6. 사용 카테고리 삭제하기");
		System.out.println("7. 계좌 초기화하기");
		System.out.println("8. 종료하기");
		
		return sc.nextInt();
	}
	public Account createAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("용돈 관리 프로그램 입니다. 계좌를 생성하기 위해 이름을 입력해 주세요");
		String accountName = sc.nextLine();
		System.out.println("계좌의 초기 잔액을 설정해주세요");
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
		
		System.out.println("사용 일자를 입력하세요");
		String useDate = sc.nextLine();
		
		System.out.println("사용 카테고리를 선택하세요");
		this.showCategory();
		int category = Integer.parseInt(sc.nextLine());
		
		System.out.println("사용 장소를 입력하세요");
		String usePlace = sc.nextLine();
		
		System.out.println("사용 금액을 입력하세요 (지출:+/수입:-)");
		int money = Integer.parseInt(sc.nextLine());
		
		System.out.println("고정 지출/수입 여부를 입력하세요(y/n)");
		boolean fixed = false;
		
		if(sc.nextLine().equals("y"))
			fixed = true;
		
		MoneyTransaction transcation = new MoneyTransaction(money, useDate, usePlace, category, fixed);
		
		return transcation;
	}
	public int inputLimit() {
		Scanner sc = new Scanner(System.in);
		System.out.println("경고 알람을 설정할 금액을 입력하세요");
		return sc.nextInt();
	}
	public int deleteCategory() {
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 카테고리의 번호를 선택하세요");
		return sc.nextInt();
	}
	public String addCategory() {
		Scanner sc = new Scanner(System.in);
		System.out.println("추가할 카테고리를 입력하세요");
		return sc.nextLine();
	}
	public String inputContinue() {
		Scanner sc = new Scanner(System.in);
		System.out.println("계속 입력하시겠습니까? (y/n)");
		return sc.nextLine();
	}
	public void showMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴로 돌아가려면 아무 키나 누르세요");
		sc.nextLine();
	}
}
