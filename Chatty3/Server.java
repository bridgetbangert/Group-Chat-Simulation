import java.util.*;
import java.awt.event.*;

public class Server {

    private String serverName;
    List<IUser> users = new ArrayList<IUser>();

    public Server(String sn) {
        serverName = sn;
    }

    public void AddUser(IUser u) {
        users.add(u);
    }

    public String GetName() {
        return serverName;
    }

    public void Send(String text, ActionEvent e) {
        for (IUser u : users) {
            u.DisplayMessage(text);
        }
    }
}