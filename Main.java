import java.util.Scanner;
public class Main {
	/**
	*n->number of subjects		
	*m-> counter to see how many classes to attend
	*min -> Minimum %age required
	*/

	int m,n=10,min;	
	//Indexing subjects in an array 
	int[] subjects=new int[n];
	//Array to store number of classes attended for each subject
	int[] attended=new int[n];
	//Array to store total conducted classes for each subject
	int[] totClasses=new int[n];
	//Classes to be attended here on
	int[] toAttend=new int[n];
	//Storing names of subjects
	String[] subjectName=new String[n];
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main obj=new Main();
		obj.input();
		obj.compute();
		obj.output();
	}

	void input()
	{
		int i;
		Scanner w=new Scanner(System.in);
		System.out.println("Enter the number of subjects:\t");
		n=w.nextInt();
		System.out.println("Enter the minimum required percentage:\t");
		min=w.nextInt();
		System.out.println("\n\nPlease enter details for each subject:\t");
		for(i=0;i<n;i++)
		{
			System.out.println("\n");
			System.out.print("Subject "+(i+1)+" name:\t");
			subjectName[i]=w.next();
			System.out.println("Enter classes attended:\t");
			attended[i]=w.nextInt();
			System.out.println("Enter classes conducted:\t");
			totClasses[i]=w.nextInt();
		}
		w.close();
	}
	
	void compute()
	{
		//TODO maybe get a count of how many more classes will be conducted [so that one can predict how much to bunk?] 

		for(int i=0;i<n;i++)	// For each subject computation takes place
		{
			m=0;
			while(true)
			{
				if(min<=(100*(attended[i]+m)/(totClasses[i]+m)))
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
			System.out.println(subjectName[i]+" :"+toAttend[i]+" classes more");
		}
	}
}
