package fr.bencor29.hanoi_visualizer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class HanoiPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3416100330493293097L;
	
	
	private Slot a, b, c;
	
	public HanoiPanel(final Slot a, final Slot b, final Slot c) {
		this.a = a;
		this.b = b;
		this.c = c;
		
		final JButton btn = new JButton("Démarrer");
		
		btn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				a.getDisks().clear();
				b.getDisks().clear();
				c.getDisks().clear();
				Main.initStart(a);
				HanoiPanel.this.remove(btn);
				Thread t = new Thread(new Runnable() {
					
					public void run() {
						Hanoi.run(a, c, b);
						HanoiPanel.this.add(btn);
					}
				});
				
				t.start();
			}
		});
		
		this.add(btn);
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		g.setColor(new Color(139, 69, 19));
		g.fillRect(100, 100, 50, 200);
		g.fillRect(300, 100, 50, 200);
		g.fillRect(500, 100, 50, 200);

		drawSlot(g, a);
		drawSlot(g, b);
		drawSlot(g, c);
		
	}
	
	
	private void drawSlot(Graphics g, Slot slot)
	{
		ArrayList<Disk> disks = slot.getDisks();
		for (int i = 0; i < disks.size(); i++) {
			Disk d = disks.get(i);
			
			g.setColor(d.getColor());
			int x = 100 + 200 * slot.getPos();
			x -= 10 * d.getSize();
			
			int y = 300;
			y -= 30 * (i + 1);
			g.fillRect(x, y, 50 + d.getSize() * 20, 30);
		}
	}
	

}
