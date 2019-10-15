package fr.bencor29.hanoi_visualizer;

import java.util.ArrayList;

public class Slot  {
	
	private int pos;
	private ArrayList<Disk> disks;
	
	public Slot(int pos)
	{
		this.pos = pos;
		disks = new ArrayList<Disk>();
	}
	
	public boolean add(Disk disk)
	{
		if (disks.size() > 0) {
			Disk last = disks.get(disks.size() - 1);
			if (last.getSize() < disk.getSize()) {
				return false;
			}
		}
		disks.add(disk);
		return true;
	}
	
	public Disk remove()
	{
		if (disks.size() > 0) {
			Disk disk = disks.get(disks.size() - 1);
			disks.remove(disk);
			return disk;
		}
		return null;
	}
	
	public int getPos()
	{
		return pos;
	}
	
	public ArrayList<Disk> getDisks()
	{
		return disks;
	}

}
