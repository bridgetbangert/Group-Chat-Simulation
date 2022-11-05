public class Main {
    static Server homies = new Server("Homies");

    public static void main(String[] args) {

        homies.AddUser(new User("Jim", homies));
        homies.AddUser(new User("Pam", homies));

    }
}
