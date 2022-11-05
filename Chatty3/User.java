import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class User extends JFrame implements IUser {

    private String name;
    private Server server;

    private JPanel jp;
    private JLabel jlb;
    private JTextField jtf;
    private JButton jb;
    private JTextArea textArea;
    private JScrollPane scroll;

    public User(String n, Server s) {
        super("Group with " + s.GetName());

        this.name = n;
        this.server = s;

        setSize(450, 450);
        setLayout(new BorderLayout());

        jp = new JPanel();
        jlb = new JLabel("Enter your message");
        jtf = new JTextField(15);
        jb = new JButton("Send");

        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (GetTextToSend().equals("")) {
                    return;
                }
                server.Send(name + ": " + GetTextToSend() + "\n", e);
                jtf.setText("");
            }
        });

        jp.add(jlb);
        jp.add(jtf);
        jp.add(jb, BorderLayout.EAST);

        add(jp, BorderLayout.SOUTH);

        textArea = new JTextArea("Welcome, " + name + "\n");

        textArea.setEditable(false);
        textArea.setLineWrap(true);

        scroll = new JScrollPane(textArea);
        add(scroll);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public String GetName() {
        return name;
    }

    public void DisplayMessage(String text) {
        textArea.append(text);
    }

    public String GetTextToSend() {
        return jtf.getText();
    }
}