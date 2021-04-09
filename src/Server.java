//import java.awt.image.BufferedImage;
import java.net.*;
//import java.io.*;
//import javax.imageio.ImageIO;

import java.awt.*;
import java.io.*;
import java.awt.image.*;
//import java.net.Socket;
import javax.imageio.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.image.BufferedImage;

public class Server {      
   public static void main(String arg[])throws Exception{ 
   ServerSocket server=new ServerSocket(9090);
   do{
        Socket socket=server.accept();
        System.out.println("Accepted");
        ObjectOutputStream out=new ObjectOutputStream(socket.getOutputStream());

        Rectangle rec=new Rectangle(0,0,500,500);
        Robot r=new Robot();
        BufferedImage img=r.createScreenCapture(rec);

        
        ImageIcon icon=new ImageIcon(img);
        
        out.writeObject(icon); 
out.close();
socket.close();

   }while(true);   
     
   }
    
}
