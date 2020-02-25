import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

class Queen extends JFrame{
    static int width ;
    static int height;
    
    static JPanel squares[][] = new JPanel[8][8];
    static JLabel lab;
    static Image image;
    
    
    Queen(){
        
        setTitle("N Queen Problem");
        setSize(600,600);
        setLayout(new GridLayout(8, 8));
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        height = (this.getHeight() / 12 );
        width = (this.getWidth() / 12);
        
        System.out.println("Height and width" + height + "\t" + width);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {                
                squares[i][j] = new JPanel(new BorderLayout());
                if ((i + j) % 2 == 0) {                    
                    squares[i][j].setBackground(Color.black);
                } else {
                    squares[i][j].setBackground(Color.white);
                }   
                add(squares[i][j]);
            }
        }
        
        try{
            image = ImageIO.read(new File("F:\\CS4200\\N_Queen\\src\\Queen.png"));
            image = image.getScaledInstance(width, height, Image.SCALE_DEFAULT);
            
        } catch(IOException e){
            System.out.println("Pic not found");
        }
        DrawQueen();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    static void DrawQueen(){
        squares[0][0].add(new JLabel(new ImageIcon(image)));
        squares[1][2].add(new JLabel(new ImageIcon(image)));
        squares[2][5].add(new JLabel(new ImageIcon(image)));
        squares[3][7].add(new JLabel(new ImageIcon(image)));
    }
    
    
    public static void main(String[] args) throws IOException{
        
       SwingUtilities.invokeLater(new Runnable(){
               public void run(){
                    new Queen();
               }
          });      
    }
        
    
}
