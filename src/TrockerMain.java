import javax.swing.JFrame;
import javax.swing.JPanel;

public class TrockerMain{

	public static void main (String[] args){
		JFrame frame = new JFrame("Trocker");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new StartUpPanel();
		frame.getContentPane().add(panel);
		frame.setLocationRelativeTo(null);

		frame.pack();
		frame.setVisible(true);
	}
}
