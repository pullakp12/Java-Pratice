import java.io.*;
//Binary tree created for Binary tree Implementation
class Binary{
	int data;
	public Binary left,right;
	public 	Binary(int data){
		this.data = data;
		left=right=null;
	}
	
}
class UniqueRows{
	int m,n;
	private int a[][];
	Binary root;
	public void input()throws IOException{
		
		System.out.println("Enter the no of row and column");
		
		//Declaring reader object to read the input
		InputStreamReader rdr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(rdr);
		
		String str=br.readLine();
		
		//splitting the input on the basis of spaces on a single line
		String strarray[]= str.split("\\s+");
		
		//extracting the values of m and n
		m= Integer.parseInt(strarray[0]);
		n= Integer.parseInt(strarray[1]);
		
		//declaring the 2d array
		a=new int[m][n];
		
		//Reading the 2d array
		System.out.println("====Please Enter the Values of the array====\n");
		for(int i=0;i<m;i++)
		{
			System.out.println("Please Enter the Values for row "+(i+1));
			str=br.readLine();
			//\\s+ escape all whitespace till we get a non-space character
			strarray= str.split("\\s+");
			//checking if entered values are equal to n 
			if(strarray.length>n)
			{
				System.out.println("supplied values are more than "+ n);
				i--;
			}
			else if(strarray.length<n){
				System.out.println("supplied values are less than "+ n);
				i--;
			}
			else
			{
				//if input string == n , then store it in the array
				for(int j=0;j<n;j++)
					a[i][j]=Integer.parseInt(strarray[j]);
			}
		}
		
	}
	public void printUnique(){
		//Initialise the root to be any value
		root= new Binary(2);
		
		for(int i=0;i<m;i++)
		{
			//each for each row if it is unique and set flag to be flase(1) initially and set it as 0 if evaluate to true
			Binary temp=root;
			int flag=1;
			for(int j=0;j<n;j++)
			{
				if(a[i][j]==0){
					//if the node is not present it means its a new unique row
					if(temp.left ==null)
					{
						temp.left=new Binary(0);
						temp=temp.left;
						flag=0;
					}
					else
					{
						temp=temp.left;
					}
				}
				else
				{
					if(temp.right ==null)
					{
						temp.right=new Binary(1);
						temp=temp.right;
						flag=0;
					}
					else
						temp=temp.right;
				}
			}
			//if flag is 0 it means unique row found print it
			if(flag==0)
				print(i);
		}
				
	}
	//Display only those rows which are found to be unique by printUnique() Function
	public void print(int i){
		System.out.print('{');
		for(int j=0;j<n;j++)
		{
			System.out.print(a[i][j]+",");
		}
		System.out.println("}");
	}
	public static void main(String []args)throws IOException{
		
		Unique tree = new Unique();
		tree.input();
		tree.printUnique();
		
		
	}
}