import java.util.Scanner;
public class Main {
	/**
	*n->number of subjects		
	*m-> counter to see how many classes to attend
	*min -> Minimum %age required
	*/

	int m,n=10,min;	

	//Array to store number of classes attended for each subject
	int[] attended;
	//Array to store total conducted classes for each subject
	int[] totClasses;
	//Classes to be attended here on
	int[] toAttend;
	//Storing names of subjects
	String[] subjectName;

	public Main()
	{
		int i;
		Scanner w=new Scanner(System.in);
		System.out.print("[*] Enter the number of subjects:\t");
		n=w.nextInt();

		attended = new int[n];
		totClasses = new int[n];
		toAttend = new int[n];
		subjectName = new String[n];

		System.out.print("[*] Enter the minimum required percentage:\t");
		min=w.nextInt();
		System.out.println("\n[+]Please enter details for each subject:");
		for(i=0;i<n;i++)
		{
			System.out.println("\n");
			System.out.print("[*] Subject "+(i+1)+" name:\t");
			subjectName[i]=w.next();
			System.out.print("[*] Enter classes attended:\t");
			attended[i]=w.nextInt();
			System.out.print("[*] Enter classes conducted:\t");
			totClasses[i]=w.nextInt();
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main obj=new Main();
		Scanner sc = new Scanner(System.in);
		System.out.println("\n[+] Enter 1 if you know how many more classes will be held for each subject");
		System.out.println("[+] Enter any other number if you aren't sure and would like to know after attending how many classes your attendance will be above minimum");
		System.out.print("[*]: ");
		int x;
		try
		{
			x = sc.nextInt();
		}
		catch (NumberFormatException n)
		{
			System.out.println ("[-] Illegal number encountered: Assuming you do not know number of classes that'll be held");
			x = 0;
		}
		if (x == 1)
		{
			obj.computeFuture();
		}
		else
		{
			obj.compute();
			obj.output();
		}
	}
	
	void computeFuture()
	{
		/**
		*Asks user to input expected number of classes to be held in the future.
		*Enables more accurate prediction on bunkable classes
		*Addresses TODO in compute()
		*/
		Scanner sc = new Scanner(System.in);
		int i = 0;
		int[] moreClasses = new int[n];
		System.out.println ("\n[+] Enter number of classes that'll further be held for:");
		for (; i < n; i++)
		{
			System.out.print ("[*] " + subjectName[i] + ": ");
			moreClasses[i] = sc.nextInt();
			totClasses[i] += moreClasses[i];
		}
		for (i = 0; i < n; i++)
		{
			m = 0;
			while (((float) attended[i]+m)/(totClasses[i])*100 < min)
			{
				m++;
			}
			if (m > moreClasses[i])
			{
				System.out.println ("\n[-] You CANNOT make up for this subject: " + subjectName[i]);
				continue;
			}
			System.out.print ("\n[+] For " + subjectName[i] + " you will need to attend: ");
			System.out.print(m + "\n");
		}
	}
	void compute()
	{
		//TODO maybe get a count of how many more classes will be conducted [so that one can predict how much to bunk?] 

		for(int i=0;i<n;i++)	// For each subject computation takes place
		{
			m=0;
			while(true)
			{
				if(min<=(100*((float) attended[i]+m)/(totClasses[i]+m)))
					break;
				else
					++m;
			}
			toAttend[i]=m;
		}
	}
	
	void output()
	{
		for(int i=0;i<n;i++)
		{
			System.out.println("\n[+] "+ subjectName[i]+ " : Attending "+toAttend[i]+" classes more will keep you safe");
		}
	}
}