import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class DrawingProgram2 extends JFrame implements MouseMotionListener,MouseListener, ChangeListener, ActionListener{
        Point mousePnt = new Point();
        public static Color penColor = new Color(0,0,0);
        JSlider penSize = new JSlider(JSlider.HORIZONTAL,1,30,4);
        public static int pen = 4;
        JButton ColourButton = new JButton("Change colour");
        JButton rectangle = new JButton("Rectangle");
        Graphics2D g;

        
        public DrawingProgram2(){
            super("Painter");
            JPanel toolbar = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JPanel jp = new JPanel();
            //JButton ColourButton = new JButton("Change colour");
  
            toolbar.add(new Label("Drag mouse to draw"));
            toolbar.add(penSize);
            toolbar.add(ColourButton);
            toolbar.add(rectangle);
            this.add(toolbar,BorderLayout.SOUTH);
            this.add(jp,BorderLayout.CENTER);
            jp.addMouseMotionListener(this);
            jp.addMouseListener(this);
            penSize.addChangeListener(this);
            ColourButton.setBackground(new Color(195, 177, 225));
            ColourButton.addActionListener(this);
            rectangle.addActionListener(this);
            setSize(800,600);
            setVisible(true);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }     
        
        public void actionPerformed(ActionEvent e) {

            JButton buttonSource = (JButton) e.getSource();

            if(buttonSource == ColourButton){
            penColor = JColorChooser.showDialog(this, "Choose line colour", penColor);
            }  

            
            if(buttonSource == rectangle){
                drawRectangles(g);
            } 
        }


        
        public void mouseMoved(MouseEvent me){
        
        }
        
        public void mouseDragged(MouseEvent me){
                mousePnt = me.getPoint();
                repaint();
        }
        
        public void mouseClicked(MouseEvent me){
        
            if(me.getModifiers() == MouseEvent.BUTTON3_MASK){
            
                penColor = JColorChooser.showDialog(null,"Change pen colour",penColor);
                
            }
 
        }
        
        public void mouseEntered(MouseEvent me){}
        public void mouseExited(MouseEvent me){}
        public void mousePressed(MouseEvent me){}
        public void mouseReleased(MouseEvent me){}
        

        
        public void stateChanged(ChangeEvent e){
        
            JSlider source = (JSlider)e.getSource();
            if(!source.getValueIsAdjusting()){
                pen = (int)source.getValue();
 
            }
        }
        
        public void paint(Graphics g){
            super.paint(g);
            g.setColor(penColor);
            g.fillOval(mousePnt.x,mousePnt.y,pen,pen);
                      drawRectangles(g);
        }
        
 
        void drawRectangles(Graphics g) {
               Graphics2D g2d = (Graphics2D) g;
               g2d.drawRect(30, 50, 420, 120);
        }

        public static void main(String[] args) throws Exception{
        
            new DrawingProgram2();
  
        }
} // end of DrawingProgram2 class
