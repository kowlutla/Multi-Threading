package parellelSum;

import java.util.Random;

public class ParellSumDemo {

	public static void main(String[] args) {
		
		Random r=new Random();
		int array[]=new int[10000000];
		for(int i=0;i<10000000;i++)
		{
			array[i]=r.nextInt(100);
		}
		
		long start=System.currentTimeMillis();
		ParallelSum parallelsum1=new ParallelSum(11);
		int sum=parallelsum1.sum(array);
		System.out.println(sum);
		long end=System.currentTimeMillis();
		System.out.println("Parellel1: "+(end-start));
		
		System.out.println("---------------------------------------------------");
		start=System.currentTimeMillis();
		ParallelSum parallelsum2=new ParallelSum(5);
		sum=parallelsum2.sum(array);
		System.out.println(sum);
		end=System.currentTimeMillis();
		System.out.println("Parellel2: "+(end-start));
		
		System.out.println("---------------------------------------------------");
		start=System.currentTimeMillis();
		ParallelSum parallelsum3=new ParallelSum(10);
		sum=parallelsum3.sum(array);
		System.out.println(sum);
		end=System.currentTimeMillis();
		System.out.println("Parellel3: "+(end-start));
	}

}
