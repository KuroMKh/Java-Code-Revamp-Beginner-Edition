import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;

public class Car extends JFrame implements ActionListener {

   private JLabel lblHours, lblTID, lblTotal, lblName, lblPlateNo, lblamount, 
   lblCustDet, lblCustDet2;
   private JTextField txtHours, txtTID, txtName, txtPlateNo, txtamount;
   private JButton btnProceed, btnExt, btnCal;
   private JRadioButton rb1, rb2, rb3, rb4;
   private ButtonGroup radioGroup;
   private Container cont;
   private GridLayout layout;
   
   //set up GUI
   public Car() {
      super("Parking System");
      setVisible(false);
      
      //grid layout
      //layout = new GridLayout(6,2);

      //get content pane and set its layout
      cont = getContentPane();
      cont.setLayout(new GridLayout(10,2));
      
      //set up Label
      lblName = new JLabel("Enter Name" );
      lblPlateNo = new JLabel("Enter Plate Number" );
      lblHours = new JLabel("Enter Duration (Hours)");
      lblTID = new JLabel("Enter Ticket ID");
      lblamount = new JLabel("Enter Amount RM");
      lblCustDet = new JLabel("CUSTOMER DETAILS");
      lblCustDet2 = new JLabel("-             ");
      
      //set up textfield
      txtName = new JTextField(7);
      txtPlateNo = new JTextField(7);
      txtHours = new JTextField(7);
      txtTID = new JTextField(7);
      txtamount= new JTextField(7);
      
      //add to container
      cont.add(lblCustDet);
      cont.add(lblCustDet2);
      cont.add(lblName);
      cont.add(txtName);
      cont.add(lblPlateNo);
      cont.add(txtPlateNo);
      cont.add(lblamount);
      cont.add(txtamount);
      cont.add(lblHours);
      cont.add(txtHours);
      cont.add(lblTID);
      cont.add(txtTID);
      
      //set radiobutton
      rb1 = new JRadioButton("Car");
      rb2 = new JRadioButton("Motorcycle");
      radioGroup = new ButtonGroup();
      radioGroup.add(rb1);
      radioGroup.add(rb2);
      
      rb3 = new JRadioButton("Member");
      rb4 = new JRadioButton("Non-member");
      radioGroup = new ButtonGroup();
      radioGroup.add(rb3);
      radioGroup.add(rb4);
      
      //set up button
      btnProceed = new JButton("Proceed");
      btnExt = new JButton("EXIT");
      btnCal = new JButton("Calculate");
      
      //add to container
      cont.add(rb1);
      cont.add(rb2);
      cont.add(rb3);
      cont.add(rb4);
      cont.add(btnProceed);
      cont.add(btnExt);
      cont.add(btnCal);

      
      //register listener
      btnProceed.addActionListener(this);
      btnExt.addActionListener(this);
      btnCal.addActionListener(this);

      setSize(700,350);
      setVisible(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
   }//end car
      
   public void actionPerformed(ActionEvent e)
   {
      double price = 0;
      double discount = 1;
      String member = "";
      String type = "";
      double amount = 0;
      int hours = 0;
      
      if(rb1.isSelected()){   
         price = 3.00;
         type = "Car";            
      } 
         
      if(rb2.isSelected()){    
         price = 2.00;
         type = "Motorcycle"; 
         //JOptionPane.showMessageDialog(this,"You chose motorcycle");    
      }
      
      if(rb3.isSelected()){   
         discount = 0.9;
         member = "Member";  
      } 
      
      if(rb4.isSelected()){   
         member = "Non-member";           
      } 
      
      //exit
      if (e.getSource() == btnExt) 
         System.exit(0);
        
      //check if all fields are filled  
      if(txtName.getText().isEmpty() || txtPlateNo.getText().isEmpty() || txtamount.getText().isEmpty() || txtHours.getText().isEmpty() || txtTID.getText().isEmpty()) {
         JOptionPane.showMessageDialog(null,"Please enter all fields");
      } else {
         amount = Double.parseDouble(txtamount.getText());
         hours = Integer.parseInt(txtHours.getText());
         
         if(e.getSource() == btnProceed || e.getSource() == btnCal) 
         {
            //calculate total
            double total = hours * price * discount;

            //calculate balance
            double balance = amount - total;

            JOptionPane.showMessageDialog(null, "Name: " + txtName.getText()+ "\nPlate Number: " + txtPlateNo.getText()+"\nDuration of Parking: "
            +txtHours.getText()+" Hours" + "\nTicket ID: " + txtTID.getText() +"\nType: "+ type + "\nMembership: "+ member + "\nAmount Entered: RM " + amount + "\nTotal Price: RM " + total + "\nBalance: RM " + balance); 
         }//end if btnProceed
      }
   }
   
   public static void main(String[] args) {
      Car car = new Car();
   }
   
}