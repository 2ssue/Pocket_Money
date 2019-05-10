import java.util.Scanner;

public class AccountUI {
	public int accountMenu() {
		Scanner sc = new Scanner(System.in);
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
	public MoneyTransaction addTransaction() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("��� ���ڸ� �Է��ϼ���");
		String useDate = sc.nextLine();
		
		System.out.println("��� ī�װ��� �����ϼ���");
		int category = Integer.parseInt(sc.nextLine());
		
		System.out.println("��� ��Ҹ� �Է��ϼ���");
		String usePlace = sc.nextLine();
		
		System.out.println("��� �ݾ��� �Է��ϼ���");
		int money = Integer.parseInt(sc.nextLine());
		
		System.out.println("���� ���� ���θ� �Է��ϼ���(y/n)");
		boolean fixed = false;
		
		if(sc.nextLine().equals("y"))
			fixed = true;
		
		MoneyTransaction transcation = new MoneyTransaction(money, useDate, usePlace, category, fixed);
		
		return transcation;
	}
	public String inputContinue() {
		Scanner sc = new Scanner(System.in);
		System.out.println("��� �Է��Ͻðڽ��ϱ�? (y/n)");
		
		return sc.nextLine();
	}
}
