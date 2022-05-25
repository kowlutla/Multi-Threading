package parellelSum;

public class ParallelSum {
	
	private ParallelWorker[] sums;
	private int numOfThreads;
	
	public ParallelSum(int numOfThreads)
	{
		this.numOfThreads=numOfThreads;
		this.sums=new ParallelWorker[numOfThreads];
	}
	
	public int sum(int nums[])
	{
		int steps=(int)Math.ceil(nums.length*1.0/numOfThreads);
		for(int i=0;i<numOfThreads;i++)
		{
			sums[i]=new ParallelWorker(nums, i*steps,Math.min((i+1)*steps, nums.length));
			sums[i].start();
		}
		try {
			for(ParallelWorker worker:sums)
			{
				worker.join();
			}
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		int total=0;
		for(ParallelWorker worker:sums)
		{
			total+=worker.getPartialSum();
		}
		return total;
		
		
	}

}
