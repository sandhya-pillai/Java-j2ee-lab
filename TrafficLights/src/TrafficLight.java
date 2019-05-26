import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JLabel;

public class TrafficLight extends JFrame implements ActionListener {

private static final long serialVersionUID = 1L;

private JRadioButton java;
private JRadioButton c;
private JRadioButton net;

private ButtonGroup buttonGroup;
private JLabel textl;
public TrafficLight() {
this.getContentPane().setLayout(new FlowLayout());
this.getContentPane().setBackground(Color.black);
java = new JRadioButton("RED");
java.setActionCommand("RED");
textl=new JLabel("Select button");
c = new JRadioButton("YELLOW");
c.setActionCommand("YELLOW");

net = new JRadioButton("GREEN");

net.setActionCommand("GREEN");

java.addActionListener(this);
net.addActionListener(this);
c.addActionListener(this);





buttonGroup = new ButtonGroup();
buttonGroup.add(java);
buttonGroup.add(c);
buttonGroup.add(net);

add(java);
add(c);
add(net);

add(textl);
}

@Override
public void actionPerformed(ActionEvent e) {
if(e.getSource()==java)
{
    textl.setText("\n"+buttonGroup.getSelection().getActionCommand() +"Selected");textl.setForeground(Color.red);
}
if(e.getSource()==net)
{
    textl.setText("\n"+buttonGroup.getSelection().getActionCommand() +"Selected");textl.setForeground(Color.green);
}
if(e.getSource()==c)
{
    textl.setText("\n"+buttonGroup.getSelection().getActionCommand() +"Selected");textl.setForeground(Color.yellow);
}
}

private static void createAndShowGUI() {
JFrame frame = new TrafficLight();
frame.setSize(400,400);
frame.pack();
frame.setVisible(true);
frame.setBackground(Color.black);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public static void main(String[] args) {
javax.swing.SwingUtilities.invokeLater(new Runnable() {

public void run() {
createAndShowGUI();
}
});
}

}
