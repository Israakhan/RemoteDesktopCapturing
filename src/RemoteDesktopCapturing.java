import java.awt.*;
import java.io.*;
import java.awt.image.*;
import java.net.Socket;
import javax.imageio.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.image.BufferedImage;
import java.util.Hashtable;

public class RemoteDesktopCapturing extends javax.swing.JFrame implements java.io.Serializable {

   
    public RemoteDesktopCapturing() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        IpTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        DesktopButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Remote Desktop Capturing");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(182, 11, 243, 22);
        getContentPane().add(IpTextField);
        IpTextField.setBounds(10, 90, 150, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Ip Address");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 46, 76, 53);

        DesktopButton.setText("Capture");
        DesktopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DesktopButtonActionPerformed(evt);
            }
        });
        getContentPane().add(DesktopButton);
        DesktopButton.setBounds(170, 90, 90, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DesktopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DesktopButtonActionPerformed
    String ip=IpTextField.getText();  
        try{    
        Socket socket=new Socket(ip,9090);
        do{
        ObjectInputStream in=new ObjectInputStream(socket.getInputStream());
         ImageIcon icon=(ImageIcon)in.readObject();
         JLabel lab=new JLabel(icon);
         JScrollPane pane=new JScrollPane(lab);
         JOptionPane.showMessageDialog(null,pane);
        } while(true);
               
        }catch(Exception e){e.printStackTrace();}
        
        
        
        
        
        
         
    }//GEN-LAST:event_DesktopButtonActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RemoteDesktopCapturing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RemoteDesktopCapturing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RemoteDesktopCapturing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RemoteDesktopCapturing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RemoteDesktopCapturing().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DesktopButton;
    private javax.swing.JTextField IpTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
