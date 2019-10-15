package fr.bencor29.hanoi_visualizer;

import java.awt.Color;

import javax.swing.JFrame;

public class Main {
	
	public static final Color[] colors = {
			Color.RED,
			Color.GREEN,
			Color.BLUE,
			Color.ORANGE,
			Color.YELLOW,
			Color.CYAN,
			Color.BLACK
	};

	public static void main(String[] args) throws Exception
	{
		Slot a = new Slot(0);
		Slot b = new Slot(1);
		Slot c = new Slot(2);
		
		initStart(a);
		
		final JFrame frame = new JFrame();
		final HanoiPanel panel = new HanoiPanel(a, b, c);
		frame.setContentPane(panel);
		frame.setSize(720, 339);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Thread t = new Thread(new Runnable() {
			
			long last = -1;
			
			public void run() {
				while(frame.isVisible()) {
					if (last + (50.0 / 3.0) <= System.currentTimeMillis()) {
						panel.repaint();
						panel.revalidate();
						last = System.currentTimeMillis();
					} else {
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		});
		
		while (!frame.isVisible()) {}
		
		t.start();
		
	}
	
	public static void initStart(Slot a)
	{
		for (int i = 0; i < colors.length; i++) {
			a.add(new Disk(colors.length - i, colors[i]));
		}
	}
	
}
