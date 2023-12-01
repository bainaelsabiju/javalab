package aleena;

public class Trycatch {
	public static void main(String[] args ) {
		System.out.println("program to perform division");
		Scanner sc = new scanner(System.in);
				char ch = 'y';
		do {
			System.out.println("enter 1st number;");
			int num1 = sc.nextInt();
			System.out.println("enter 2nd number;");
			int num2 = sc.nextInt();
			try {
				int res = num1/num2);
				System.out.println("result="+res);
				
			}
			catch(Exception e) {
				System.out.println("division by zero");
				
			}
			finally {
				System.out.println("and of operation");
				
			}
			System.out.println("do you want to continue ? (y/n)");
			ch = sc.next()charA + (0);
		}
		while(ch=='y');
	}


