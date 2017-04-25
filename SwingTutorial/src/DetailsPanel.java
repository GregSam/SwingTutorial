import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.EventListenerList;

public class DetailsPanel extends JPanel {
	private static final long serialVersionID = 654987321654L;
	
	private EventListenerList listenerList = new EventListenerList();
	
	public DetailsPanel(){
		Dimension size = getPreferredSize();
		size.width = 250;
		setPreferredSize(size);
		
		setBorder(BorderFactory.createTitledBorder("Personal Border"));
		
		JLabel nameLabel = new JLabel("Name: ");
		JLabel occupationLabel = new JLabel("Occupation: ");
		
		JTextField nameField = new JTextField(10);
		JTextField occupationField = new JTextField(10);
		
		JButton addBtn = new JButton("Add");
		
		addBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String  occupation = occupationField.getText();
				
				String fieldsText = name +", "+occupation+"\n";
				
				fireDetailEvent(new DetailEvent(this, fieldsText));
			}
		});
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		// first column
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		
		gc.gridx = 0;
		gc.gridy = 0;
		
		add(nameLabel, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		add(occupationLabel, gc);
		
		//second column
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.anchor = GridBagConstraints.LINE_START;
		
		gc.gridx = 1;
		gc.gridy = 0;
		
		add(nameField, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		
		add(occupationField, gc);
		
		//button row
		gc.weighty = 10;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.gridx = 1;
		gc.gridy = 2;
		
		add(addBtn,gc);
	}
	
	public void fireDetailEvent(DetailEvent event){
		Object[] listeners = listenerList.getListenerList();
		
		for(int i=0; i< listeners.length; i+=2){
			if(listeners[i]==DetailListener.class){
				((DetailListener)listeners[i+1]).detailEventOccured(event);
			}
		}
	}
	
	public void addDetailListener(DetailListener listener){
		listenerList.add(DetailListener.class, listener);
	}
	public void removeDetailListener(DetailListener listener){
		listenerList.remove(DetailListener.class, listener);
	}

}
