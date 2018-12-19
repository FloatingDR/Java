package Socket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class MyClien extends JFrame {
    private PrintWriter writer;
    Socket socket;
    private JTextArea ta=new JTextArea();
    private JTextField tf=new JTextField();
    Container cc;
    public MyClien(String title){
        super(title);
        cc=this.getContentPane();
        cc.add(ta,"North");
        cc.add(tf,"South");
        tf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                writer.println(tf.getText());
                ta.append(tf.getText()+'\n');
                tf.setText(" ");
            }
        });
    }
    private void connect(){
        ta.append("尝试连接\n");
        try {
            socket=new Socket("127.0.0.1",65484);
            writer=new PrintWriter(socket.getOutputStream(),true);
            ta.append("完成连接\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[]args){
        MyClien clien=new MyClien("向服务器发送数据");
        clien.setBounds(300,260,340,220);
        clien.setVisible(true);
        clien.connect();
    }
}
