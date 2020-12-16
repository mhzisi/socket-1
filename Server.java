import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    static final int port = 1200;

    public static void main(String[] args) throws Exception {


        ServerSocket s = new ServerSocket(port);
        System.out.println("En attente de connexion");
        Socket socClient = s.accept();
        System.out.println("Connexion etablie avec succees!");


        BufferedReader inServer = new BufferedReader(new InputStreamReader(socClient.getInputStream()));
        PrintWriter outServer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socClient.getOutputStream())), true);
        String str = inServer.readLine();
        
        //verification du type de l'entier saisie
        int n=0;
        
        try
        {
        	n=Integer.parseInt(str);
        }
        catch (Exception e)
        {
        	System.out.println("L'entrée du clavier n'est pas un entier");
        }
        
        //verifier que c'est un entier positif
        if (n<=0)
        {
        	System.out.println("Ce n'est pas un entier positif");
        }
        
        //calcul des entier premiers     
        for(int x=2;x<=n;x++)
        {
            boolean res=true;
            int i=2;
        	while(i<=x && res==true)
        	{
        		if (x%i == 0)
        			res = false;
        		i++;
        	}
        	if (i>=x)
        		System.out.print(x+ " ");
        }
        
        inServer.close();
        outServer.close();
        socClient.close();
    }
}

