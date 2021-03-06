import javax.swing.JFrame;
import processing.awt.PSurfaceAWT;

public class Illusion2 {

	public static void main(String args[])
	{
		DrawSurface drawing = new DrawSurface();
		
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame)canvas.getFrame();
		
		window.setSize(500, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		window.setVisible(true);
	}
	
}
