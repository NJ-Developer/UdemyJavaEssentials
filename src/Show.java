import javax.swing.JFrame;

public class Show {

	public static void main(String[] args)
	{
		JFrame frame = new JFrame("hi");
		frame.add(new StoryTeller());
		 frame.setSize(400,400);    
       //  frame.setLayout(null);  
         frame.setVisible(true);
	}
}
