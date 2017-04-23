import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SwingTut {
	
	public static void main(String... args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				JFrame frame = new MainFrame("My new Swing UI");
				frame.setSize(500, 400);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}