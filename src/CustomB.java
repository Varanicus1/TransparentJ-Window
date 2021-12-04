import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CustomB extends JFrame{

    //Variablen
    Container c;
    JButton e;
    JToggleButton tb;
    BackgroundPanel back;


    //Kontstruktor
   public CustomB(){
       //Container 
       c = getContentPane();
       setUndecorated(true); //entfernt normale jar darstellung
       setBackground(new Color(0,0,0,0));
       setSize(512,512);
       setLocation(650,350);

       //panel(Gui)
       back= new BackgroundPanel(new ImageIcon("images/blue.jpg"));
       back.setBackground(new Color(0,0,0,0));
       back.setLayout(new GridLayout(4,1));



       //toggleButton
       tb= new JToggleButton(new ImageIcon("images/off.png"));
       tb.setContentAreaFilled(false); //entfernt umrandungen etc.
       tb.setBorderPainted(false);
       tb.setFocusPainted(false);

       //exit button
       e = new JButton(new ImageIcon("images/exit.png"));
       e.setContentAreaFilled(false);
       e.setBorderPainted(false);
       e.setFocusPainted(false);
       e.setVisible(true);

       //add listener
       tb.addItemListener(new TBListener());
       e.addActionListener(new BListener());

       //add
       back.add(e);
       back.add(tb);
       c.add(back);
   }

   //Klasse für Toggle
   class TBListener implements ItemListener{
       public void itemStateChanged(ItemEvent ev){
           if(ev.getStateChange() == ItemEvent.SELECTED){
              
               tb.setIcon(new ImageIcon("images/on.png"));
               back.setIcon(new ImageIcon("images/green.jpg"));
               back.repaint();
               
           }else if ( ev.getStateChange() == ItemEvent.DESELECTED){
               
               tb.setIcon(new ImageIcon("images/off.png"));
               back.setIcon(new ImageIcon("images/blue.jpg"));
               back.repaint();
           }
       }
   }

   //Actionlistener für Exit
   class BListener implements ActionListener {
       public void actionPerformed(ActionEvent ee){
           System.exit(0);
       }
   }

   //Klasse für die Bilder initialiserung und Zeichnung
   class BackgroundPanel extends JPanel{
       ImageIcon icon;

       public BackgroundPanel(ImageIcon icon){
           this.icon = icon;
       }

       public void setIcon(ImageIcon icon){
           this.icon = icon;
       }

       protected void paintComponent(Graphics g){
           super.paintComponent(g);
           if(this.icon != null){
               g.drawImage(icon.getImage(), 0, 0, this);
           }
       }

   }

   //Main Methode erstellt das JFrame
    public static void main(String[] args) {
       CustomB frame= new CustomB();
       frame.setVisible(true);
    }
}
