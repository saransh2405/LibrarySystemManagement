import java.util.*;

int x = 0;

class xyz implements Runnable
{
	public void run()
	{
		for(int i=0;i<20;i++)
		{
			x = x + i;
			System.out.println("Thread 1 "+x);
		}
	}
}

class abc implements Runnable
{
	public void run()
	{
		for(int i=0;i<20;i++)
		{
			x=x+i;
			System.out.println("Thread 2 "+x);
		}
	}
}


public class javatest
{
	public static void main(String args[])
	{
		(new Thread(new xyz())).start();
		(new Thread(new abc())).start();
	}
}