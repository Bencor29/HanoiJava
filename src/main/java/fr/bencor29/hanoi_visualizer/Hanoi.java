package fr.bencor29.hanoi_visualizer;

public class Hanoi {
	
	private static int count = 0;
	
	public static void run(Slot d, Slot a, Slot i)
	{
		count = 0;
		internal(d.getDisks().size(), d, a, i);
		System.out.println(count);
	}
	
	private static void internal(int n, Slot d, Slot a, Slot i)
	{
		if (n != 0) {
			internal(n - 1, d, i, a);
			move(d, a);
			internal(n - 1, i, a, d);
		}
	}
	
	private static boolean move(Slot d, Slot a)
	{
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Disk disk = d.remove();
		if(disk != null) {
			count++;
			a.add(disk);
		}
		
		return false;
	}

}
