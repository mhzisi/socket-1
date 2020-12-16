import java.io.*;
import java.net.Socket;

public class Client {

    static final int port = 1200;

    public static void main(String[] args) throws Exception {

        System.out.println("Demande de connexion en cours");


        Socket socket = new Socket("127.0.0.1", port);
        System.out.println("Connexion etablie");
        

        BufferedReader inClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter outClient = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        BufferedReader val =new BufferedReader(new InputStreamReader(System.in)); 
        
        //lecture de l'entier
        System.out.println("Veuillez saisir un entier positif");
        String str = val.readLine(); 
        outClient.println(str);
        

        inClient.close();
        outClient.close();
        socket.close();
    }
}