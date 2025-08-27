package apps;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**Calculator GUI.
 * 
 * @author Jesus Sisniega-Serrano
 * @version 6/25/25
 */
public class Calculator 
{
    private static final int X_LOC = 100; //pos where calc will appear
    private static final int Y_LOC = 100;
    private static final int WIDTH = 400; //size of calc
    private static final int HEIGHT = 400;
    private static final String NAME = "Calculator"; //title of program for GUI
    private static final String RESULT_PREAMBLE = "Result = "; //default msg
    private static final String ERROR_MESSAGE = "Error";

    private JFrame frame;
    private JTextField leftOpField;
    private JTextField rightOpField;
    private JLabel resultLabel;

    /**Constructor class.
     * 
     */
    public Calculator()
    {
        createFrame();
        initializeComponents();
        displayFrame();
    }

    /**Returns private frame field.
     * All other GUI components stored within this frame.
     * 
     * @return JFrame.
     */
    public JFrame getFrame()
    {
        return this.frame;
    }

    /**Initializes frame field.
     * Creates GUI frame components.
     */
    private void createFrame()
    {
        frame = new JFrame();
        frame.setLocation(X_LOC, Y_LOC);
        frame.setSize(WIDTH, HEIGHT);
        frame.setTitle(NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**Initializes input fields.
     * Initializes resultLabel field.
     * Initializes GUI Buttons and ActionListeners.
     */
    private void initializeComponents()
    {
        initializeInputs();
        initializeResults();
        initializeButtons();
    }

    /**Makes frame component visible.
     */
    private void displayFrame()
    {
        frame.pack();
        frame.setVisible(true);
    }

    /**Initializes input fields.
     */
    private void initializeInputs()
    {
        JPanel panel = new JPanel();
        this.leftOpField = new JTextField(5);
        leftOpField.setName("leftOperand");
        leftOpField.setText("leftOperand");
        this.rightOpField = new JTextField(5);
        rightOpField.setName("rightOperand");
        rightOpField.setText("rightOperand");
        panel.add(this.leftOpField);
        panel.add(this.rightOpField);
        frame.add(panel, BorderLayout.PAGE_START);
    }

    /**Initializes resultLabel field.
     */
    private void initializeResults()
    {
        JPanel panel = new JPanel();
        this.resultLabel = new JLabel();
        resultLabel.setName("resultLabel");
        resultLabel.setText(RESULT_PREAMBLE);
        panel.add(this.resultLabel);
        frame.add(panel, BorderLayout.LINE_START);
    }

    /**Constructs GUI Buttons.
     * Contains anonymous ActionListeners.
     */
    private void initializeButtons()
    {
        JPanel panel = new JPanel();
        JButton addButton = new JButton("ADD");
        addButton.setName("addButton");
        addButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                double total = getLeftNum() + getRightNum();
                updateResult(total);
            }
        });
        JButton subButton = new JButton("SUB");
        subButton.setName("subButton");
        subButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                double total = getLeftNum() - getRightNum();
                updateResult(total);
            }
        });
        JButton multButton = new JButton("MULT");
        multButton.setName("multButton");
        multButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                double total = getLeftNum() * getRightNum();
                updateResult(total);
            }
        });
        JButton divButton = new JButton("DIV");
        divButton.setName("divButton");
        divButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                if (getRightNum() == 0)
                {
                    updateResult(Double.NaN);
                }
                else
                {
                    double total = getLeftNum() / getRightNum();
                    updateResult(total);
                }
            }
        });
        panel.add(addButton);
        panel.add(subButton);
        panel.add(multButton);
        panel.add(divButton);
        frame.add(panel,BorderLayout.PAGE_END);
    }

    /**Gets the left number entered by user.
     * 
     * @return leftNum.
     */
    private double getLeftNum()
    {
        double num;
        try{
            num = Double.parseDouble(leftOpField.getText());
        }
        catch(NullPointerException e){
            throw new RuntimeException("No text was entered.");
        }
        return num;
    }

    /**Gets the right number entered by user.
     * 
     * @return rightNum.
     */
    private double getRightNum()
    {
        double num = Double.NaN;
        try{
            num = Double.parseDouble(rightOpField.getText());
        }
        catch(NullPointerException e){
            throw new RuntimeException("No text was entered.");
        }
        return num;
    }

    /**Updates result label based on given result.
     * 
     * @param result given result.
     */
    private void updateResult(double result)
    {
        if (result == Double.NaN){
            resultLabel.setText(ERROR_MESSAGE);
        }
        else{
            resultLabel.setText(RESULT_PREAMBLE + result);
        }
    }
}
