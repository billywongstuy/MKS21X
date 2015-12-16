import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TempConversionWindow extends JFrame implements ActionListener{
    private Container pane;
    
    private JTextField tField;
    private JLabel cLabel;
    private JButton cButton;
    private JLabel fLabel;
    private JButton fButton;
    private JTextField display;
    

    public TempConversionWindow() {
	this.setTitle("Temperature Converter");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);


	pane = this.getContentPane(); //where to attach stuff
	//pane.setLayout(new BoxLayout(pane,BoxLayout.Y_AXIS));
	pane.setLayout(new GridBagLayout());
	GridBagConstraints c = new GridBagConstraints();

	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 0;
	c.gridy = 0;

	//cLabel = new JLabel("Convert C to F",null,JLabel.CENTER);
	//fLabel = new JLabel("Convert F to C",null,JLabel.CENTER);
	
	tField = new JTextField(4);
	
	cButton = new JButton("C to F");
	cButton.setActionCommand("CtoF");
	cButton.addActionListener(this);	
	
	fButton = new JButton("F to C");
	fButton.setActionCommand("FtoC");
	fButton.addActionListener(this);	

	display = new JTextField("Converted temperature appears here.");
	display.setEditable(false);

	c.gridwidth = 3;
	pane.add(tField,c);

	c.gridwidth = 1;
	c.gridy += 2;
	pane.add(cButton,c);
	
	c.gridx += 2;
	pane.add(fButton,c);

        c.fill = GridBagConstraints.VERTICAL;
	c.gridx -= 1;
	c.gridy += 2;
	pane.add(display,c);
	
    }


    public static double CtoF (double t) {
	return (9*t)/5+32;
    }

    public static double FtoC (double t) {
	return (5*(t-32.0))/9;
    }

    public void actionPerformed(ActionEvent e) {
	String action = e.getActionCommand();
	try {
	if (action.equals("CtoF")) {
	    double t = Integer.parseInt(tField.getText());
	    System.out.println(CtoF(t));
	    display.setText(""+CtoF(t));
	}
	else if (action.equals("FtoC")) {
	    double t = Integer.parseInt(tField.getText());
	    System.out.println(FtoC(t));
	    display.setText(""+FtoC(t));
	}
	}
	catch (NumberFormatException d) {
	    JOptionPane.showMessageDialog(null,"Please enter the number in a correct format.");
	}
    }

}
