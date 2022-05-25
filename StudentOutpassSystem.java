import java.io.*;
public class StudentOutpassSystem 
{
	public static void main(String args[]) throws Exception
	{
		StudentLeave studentleave;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter no of students :");
		int n=Integer.parseInt(br.readLine());
		for(int i=1;i<=n;i++)
		{
			System.out.println("- - - Details of student "+i+" - - -");
			System.out.print("Name: ");
			String name=br.readLine();
			System.out.print("ID: ");
			String id=br.readLine();
			System.out.print("No of days: ");
			int no_of_days=Integer.parseInt(br.readLine());
			System.out.print("Reason: ");
			String reason=br.readLine();
			studentleave=new StudentLeave(name,id,no_of_days,reason);
			Outpass outpass=new Outpass(studentleave);
			outpass.Aswo(studentleave);
			outpass.Hod(studentleave);
		}
	}
}


class StudentLeave
{
	String name;
	String id;
	int no_of_days;
	String reason;
	public StudentLeave(String name,String id,int no_of_days,String reason)
	{
		this.name=name;
		this.id=id;
		this.no_of_days=no_of_days;
		this.reason=reason;
	}
	public int getNoOfDays()
	{
		return no_of_days;
	}
	public String toString()
	{
		return "Name: "+name+"\tID: "+id+"\tNo of days: "+no_of_days;
	}
}

class Outpass
{
	StudentLeave studentleave;
	boolean isProcessing=false;
	public Outpass(StudentLeave studentleave)
	{
		this.studentleave=studentleave;
	}
	public StudentLeave getStudentLeaveDetails()
	{
		return studentleave;
	}
	public synchronized void Aswo(StudentLeave studentleave)
	{
		this.studentleave=studentleave;
		while(isProcessing)
		{
			try {wait();}catch(Exception e) {}
		}
		if(studentleave.getNoOfDays()>5)
		{
			System.out.println("Not allowd to grant leave");
			//isProcessing=true;
			//notify();
		}
		else
		{
			System.out.println("- - - Processed to HOD - - -");
			try {Thread.sleep(3000);}catch(Exception e) {}
			isProcessing=true;
			notify();
			//try {Thread.sleep(3000);}catch(Exception e) {}
		}
		
	}
	public synchronized void Hod(StudentLeave studentleave) throws Exception
	{
		while(!isProcessing)
		{
			try {wait();}catch(Exception e) {}
		}
		File file=new File("outpassdetails.txt");
		FileWriter fw=new FileWriter(file.getAbsoluteFile(),true);
		BufferedWriter bw=new BufferedWriter(fw);
		fw.write(studentleave+"\n");
		System.out.println("- - - OutPass Greanted by HOD - - - ");
		isProcessing=false;
		notify();
		bw.close();
		fw.close();
	}
}
class ASWO implements Runnable
{
	Outpass outpass;
	public ASWO(Outpass outpass)
	{
		this.outpass=outpass;
		Thread t=new Thread(this,"ASWO");
		t.start();
	}
	public void run()
	{
		while(true)
		{
			outpass.Aswo(outpass.getStudentLeaveDetails());
		}
	}
}
class HOD implements Runnable
{
	Outpass outpass;
	public HOD(Outpass outpass)
	{
		this.outpass=outpass;
		Thread t=new Thread(this,"HOD");
		t.start();
	}
	public void run()
	{
		while(true)
		{
			try {
				outpass.Hod(outpass.getStudentLeaveDetails());
			} catch (Exception e) {}
		}
	}
}





