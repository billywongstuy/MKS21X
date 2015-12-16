import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TempConversionWindow extends JFrame implements ActionListener{
    private Container pane;
    
    /*private JButton b;
      private JLabel l;
      private JTextField t;
      private JCheckBox c;*/


    private JTextField tField;

    private JLabel cLabel;
    private JButton cButton;

    private JLabel fLabel;
    private JButton fButton;

    private JTextField test;
    

    public TempConversionWindow() {
	this.setTitle("Temperature Converter");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);


	pane = this.getContentPane(); //where to attach stuff
	pane.setLayout(new BoxLayout(pane,BoxLayout.Y_AXIS));

	
	/*t = new JTextField(12);

	  b = new JButton("Do Nothing");
	  l = new JLabel("This is AWESOME! (lies)",null,JLabel.CENTER);
	
	  c = new JCheckBox("Overclock!!!");

	  pane.add(l);
	  pane.add(b);
	  pane.add(t);
	  pane.add(c);*/

	cLabel = new JLabel("Convert C to F",null,JLabel.CENTER);
	tField = new JTextField(4);
	cButton = new JButton("C to F");

	pane.add(cLabel);
	pane.add(tField);
	pane.add(cButton);
	
	cButton.setActionCommand("CtoF");
	cButton.addActionListener(this);

        //pane.add(new JSeparator(SwingConstants.VERTICAL));
	
	fLabel = new JLabel("Convert F to C",null,JLabel.CENTER);
	fButton = new JButton("F to C");

	pane.add(fLabel);
	pane.add(fButton);
	
	fButton.setActionCommand("FtoC");
	fButton.addActionListener(this);	

	test = new JTextField(4);
	test.setEditable(false);
	pane.add(test);

	//test.setText("9");
	
    }


    public static double CtoF (double t) {
	return (9*t)/5+32;
    }

    public static double FtoC (double t) {
	return (5*(t-32.0))/9;
    }

    public void actionPerformed(ActionEvent e) {
	String action = e.getActionCommand();
	if (action.equals("CtoF")) {
	    double t = Integer.parseInt(tField.getText());
	    System.out.println(CtoF(t));
	    test.setText(""+CtoF(t));
	}
	else if (action.equals("FtoC")) {
	    double t = Integer.parseInt(tField.getText());
	    System.out.println(FtoC(t));
	    test.setText(""+CtoF(t));
	}
    }

}
