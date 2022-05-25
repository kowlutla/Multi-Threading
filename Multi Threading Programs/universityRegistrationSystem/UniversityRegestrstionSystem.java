package universityRegistrationSystem;
import java.io.*;
import java.util.Scanner;

public class UniversityRegestrstionSystem {

//	static final BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("No of Student: ");
		int n=sc.nextInt();
		University u=new University(n);
		new RegistrarClass(u);
		new ValidatorClass(u);
	}

}
class University
{
	Student student;
	int n;
	boolean isRegister=false;
	public University(int n)
	{
		this.n=n;
	}
	
	public synchronized void Registrar(Student student)
	{
		while(isRegister)
		{
			try{wait();}catch(Exception e) {}
		}
		System.out.println("Student details are send to validator......");
		//try {Thread.sleep(2000);}catch(Exception e) {}
		this.student=student;
		isRegister=true;
		notify();
	}
	
	
	
	public synchronized void validator() throws IOException,AgeException
	{
		File file=new File("studentdetails.txt");
		FileWriter fw=new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw=new BufferedWriter(fw);
		while(!isRegister)
		{
			try {wait();}catch(Exception e) {}
		}
		try 
		{
			if(student.age<35 && student.age>23)
			{
				throw new AgeException(student.name+" not accepted");
			}
			else
			{
				System.out.println("- - - Student is Accepted- - - ");
				bw.write(student+"\n");
				//System.out.println("- - - Student is accepted - - - ");
			}
			try{Thread.sleep(2000);}catch(Exception e) {}
		//	bw.close();
		//	fw.close();
		}
		catch(AgeException e)
		{
			System.out.println(e);
		}
		isRegister=false;
		notify();
		
	}
	//bw.close();
	//	fw.close();
}


class RegistrarClass implements Runnable
{
	University university;
	Student s;
	Scanner sc=new Scanner(System.in);
	public RegistrarClass(University university)
	{
		this.university=university;
		Thread t=new Thread(this,"Registrar Class");
		t.start();
	}
	
	public void run()
	{
		int i=1;
		while(i<=university.n)
		{
				try {Thread.sleep(500);}catch(Exception e) {}
				System.out.print("Name: ");
				String name=sc.next();
				System.out.print("Age: ");
				int age=sc.nextInt();
				s=new Student(name,age);
				university.Registrar(s);
				
			
			i++;
		}
	}
	
}

class ValidatorClass implements Runnable
{
	University university;
	public ValidatorClass(University university)
	{
		this.university=university;
		Thread t=new Thread(this,"Validator Class");
		t.start();
	}
	
	public void run()
	{
		int i=1;
		while(i<=university.n)
		{
			try {
				university.validator();
			} catch (Exception e) {
			}
			i++;
		}
	}
}





//student class
class Student
{
	String name;
	int age;
	public Student(String name,int age)
	{
		this.name=name;
		this.age=age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
}


class AgeException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AgeException(String msg)
	{
		super(msg);
	}
}

