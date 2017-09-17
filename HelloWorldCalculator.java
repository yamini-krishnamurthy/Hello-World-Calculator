import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;

public class HelloWorldCalculator extends JFrame implements ActionListener {
  JPanel[] row = new JPanel[6];
  JButton[] button = new JButton[35];
  String[] buttonString = {"π", "sin", "+/-", "^", "√", "AC",
                     "e", "cos", "7", "8", "9", "+",
                     "ln", "tan", "4", "5", "6", "-",
                     "log", "cosec", "1", "2", "3", "x",
                     "sec", "cot", "0", ".", "=", "÷"};
  
  Dimension displayDimension = new Dimension(300, 35);
  Dimension regularDimension = new Dimension(45, 40);
 // Dimension rColumnDimension = new Dimension(100, 40);
  
  boolean[] function = new boolean[5];
  double[] temporary = {0,0};

  JTextArea display = new JTextArea(1,20);
  Font font = new Font("Calibri", Font.BOLD, 14);

  HelloWorldCalculator() {
    
    super("Calculator"); //title of window
    setDesign(); 
    setSize(380, 250); //size of the window
    setResizable(false); //can't change the size of window
    setDefaultCloseOperation(EXIT_ON_CLOSE); //if 'X' button is hit, window closes
    
    //sets layout of buttons
    GridLayout grid = new GridLayout(6,6);
    setLayout(grid);
    
    //initializing boolean values for operations with false
    for(int i = 0; i < 5; i++) 
      function[i] = false;

    //centering the display and adding gaps between buttons
    FlowLayout f1 = new FlowLayout(FlowLayout.CENTER);
    FlowLayout f2 = new FlowLayout(FlowLayout.CENTER,1,1);

    for(int i = 0; i < 6; i++) 
      row[i] = new JPanel();
    
    row[0].setLayout(f1);
    
    for(int i = 1; i < 6; i++)
      row[i].setLayout(f2);

    //button stuff
    for(int i = 0; i < 30; i++) {
      button[i] = new JButton();
      button[i].setText(buttonString[i]);
      button[i].setFont(font);
      button[i].addActionListener(this);
    }
  
    //setting the display with the right font, making things unenterable by keyboard
    display.setFont(font);
    display.setEditable(false);
    display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    display.setPreferredSize(displayDimension);

    //setting this size of each button
    for(int i = 0; i < 30; i++) 
      button[i].setPreferredSize(regularDimension);

    //adding components to the panel
    row[0].add(display);
    add(row[0]);
   
    for(int i = 0; i < 6;i++)
      row[1].add(button[i]);
    add(row[1]);
    
    for(int i = 6; i < 12; i++) 
      row[2].add(button[i]);
    add(row[2]);

    for(int i = 12; i < 18; i++)
      row[3].add(button[i]);
    add(row[3]);

    for(int i = 18; i < 24; i++)
      row[4].add(button[i]);
    add(row[4]);

    for(int i = 24; i < 30; i++)
      row[5].add(button[i]);
    add(row[5]);

    setVisible(true);
  }
  
  public final void setDesign() {
    try {
      UIManager.setLookAndFeel("com.sun.java.swing.plaf.NimbusLookAndFeel");    } catch(Exception e) {
    }
  }

  public void actionPerformed(ActionEvent ae) {
    //if(ae.getSource() == button[0])
    if(ae.getSource() == button[1]) {
      temporary[0] = Double.parseDouble(display.getText());
      function[6] = true;
      display.setText("");
    }
    if(ae.getSource() == button[2]) 
      getPosNeg();
    if(ae.getSource() == button[3]) {
      temporary[0] = Double.parseDouble(display.getText());
      function[4] = true;
      display.setText("");
    }
     if(ae.getSource() == button[4]) 
       getSqrt();
     if(ae.getSource() == button[5])
       clear();
     if(ae.getSource() == button[6]) 
      getE();
     if(ae.getSource() == button[7]) 
       getCos();
     if(ae.getSource() == button[8])
       display.append("7");
     if(ae.getSource() == button[9]) 
       display.append("8");
     if(ae.getSource() == button[10])
       display.append("9");
     if(ae.getSource() == button[11]) {
       temporary[0] = Double.parseDouble(display.getText());
       function[0] = true;
       display.setText("");
     }
     if(ae.getSource() == button[12]) 
       getLn();
     if(ae.getSource() == button[13]) 
       getTan();
     if(ae.getSource() == button[14])
       display.append("4");
     if(ae.getSource() == button[15])
       display.append("5");
     if(ae.getSource() == button[16]) 
       display.append("6");
     if(ae.getSource() == button[17]) {
       temporary[0] = Double.parseDouble(display.getText());
       function[1] = true;
       display.setText("");
     }
     if(ae.getSource() == button[18]) 
       getLog();
     if(ae.getSource() == button[19]) 
       getCosec();
     if(ae.getSource() == button[20]) 
       display.append("1");
     if(ae.getSource() == button[21]) 
       display.append("2");
     if(ae.getSource() == button[22]) 
       display.append("3");
     if(ae.getSource() == button[23]) {
       temporary[0] = Double.parseDouble(display.getText());
       function[2] = true;
       display.setText("");
     }
     if(ae.getSource() == button[24]) 
       getSec();
     if(ae.getSource() == button[25]) 
       getCot();
     if(ae.getSource() == button[26]) 
       display.append("0");
     if(ae.getSource() == button[27])
       display.append(".");
    if(ae.getSource() == button[28])
      getResult();
    if(ae.getSource() == button[29]) {
      temporary[0] = Double.parseDouble(display.getText());
      function[3] = true;
      display.setText("");
    }

    }
    
  public void getSin() {
    try {
      double value = Math.sin(Double.parseDouble(display.getText()));
      display.setText(Double.toString(value));
    } catch(NumberFormatException e) {
    }
  }

  public void getSec() {
    try {
      double value = 1/(Math.cos(Double.parseDouble(display.getText())));
      display.setText(Double.toString(value));
    } catch(NumberFormatException e) {
    }
  }

  public void getCot() {
    try {
      double value = 1/(Math.tan(Double.parseDouble(display.getText())));
      display.setText(Double.toString(value));
    } catch(NumberFormatException e) {
    }
  }

  public void getSqrt() {
     try {
      double value = Math.sqrt(Double.parseDouble(display.getText()));
      display.setText(Double.toString(value));
     } catch(NumberFormatException e) {
     }
  }

  public void getCos() {
    try {
      double value = Math.cos(Double.parseDouble(display.getText()));
   display.setText(Double.toString(value));
    } catch(NumberFormatException e) {
    }
  }

  public void getTan() {
    try {
      double value = Math.tan(Double.parseDouble(display.getText()));
   display.setText(Double.toString(value));
    } catch(NumberFormatException e) {
    }
  }

  public void getCosec() {
    try {
      double value = 1/(Math.sin(Double.parseDouble(display.getText())));
   display.setText(Double.toString(value));
    } catch(NumberFormatException e) {
    }
  }

  public void getLog() {
    try {
      double value = Math.log10(Double.parseDouble(display.getText()));
   display.setText(Double.toString(value));
    } catch(NumberFormatException e) {
    }
  }

  public void getLn() {
    try {
      double value = Math.log(Double.parseDouble(display.getText()));
   display.setText(Double.toString(value));
    } catch(NumberFormatException e) {
    }
  }
 
  public void getE() {
    try {
      double value = Math.exp(Double.parseDouble(display.getText()));
   display.setText(Double.toString(value));
    } catch(NumberFormatException e) {
    }
  }
  
  public void clear() {
    try {
      display.setText("");
      for(int i = 0; i < 5; i++) 
        function[i] = false;
      for(int i = 0; i < 2; i++)
        temporary[i] = 0;
    } catch(NullPointerException e) {
    }
  }

  public void getPosNeg() {
    try {
      double value = Double.parseDouble(display.getText());
      if(value != 0) {
        value *= (-1);
        display.setText(Double.toString(value));
      }
      else {
      }
    } catch(NumberFormatException e) {
    }
  }
  
  public void getResult() {
    double result = 0;
    temporary[1] = Double.parseDouble(display.getText());
    String temp0 = Double.toString(temporary[0]);
    String temp1 = Double.toString(temporary[1]);
    try {
      if(temp0.contains("-")) {
        String[] temp00 = temp0.split("-", 2);
        temporary[0] = (Double.parseDouble(temp00[1]) * -1);
      }
      if(temp1.contains("-")) {
        String[] temp11 = temp1.split("-", 2);
        temporary[1] = (Double.parseDouble(temp11[1]) * -1);
      }
    } catch(ArrayIndexOutOfBoundsException e) {
    } 
    try {
      if(function[2] == true)
        result = temporary[0] * temporary[1];
      else if(function[3] == true)
        result = temporary[0] / temporary[1];
      else if(function[0] == true)
        result = temporary[0] + temporary[1];
      else if(function[1] == true)
        result = temporary[0] - temporary[1];
      else if(function[4] == true)
        result = Math.pow(temporary[0], temporary[1]);
      display.setText(Double.toString(result));
      for(int i = 0; i < 5; i++)
        function[i] = false;
    } catch(NumberFormatException e) {
    }
  }

  public static void main(String[] args) {
    HelloWorldCalculator c = new HelloWorldCalculator();
  }

}





