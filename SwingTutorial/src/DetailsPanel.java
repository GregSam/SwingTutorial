import java.awt.Dimension;

import javax.swing.JPanel;

public class DetailsPanel extends JPanel {
	public DetailsPanel(){
		Dimension size = getPreferredSize();
		size.width = 250;
		setPreferredSize(size);
	}
}
