
package projects;

import java.net.*;
import java.io.*;
import java.util.Vector;
import java.sql.*;

public class Server implements Runnable{
    
    Socket socket;
    static int port;
    public static Vector client = new Vector();
    
    public Server(int port)
    {
        this.port = port;
        main(null);
    }
    
    public Server(Socket socket)
    {
        try{
            this.socket = socket;
        }
        catch(Exception e){}
    }
    
    public void run()
    {
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            
            client.add(writer);
            
            while(true)
            {
                String data = reader.readLine().trim();
                String sender = data.substring(0, data.indexOf(':'));
                String msg = data.substring(data.indexOf(':')+1,data.length());
                
                for(int i=0 ; i<client.size() ; i++)
                {
                    try{
                        BufferedWriter bw = (BufferedWriter) client.get(i);
                        bw.write(data);
                        bw.write("\r\n");
                        bw.flush();
                    }catch(Exception e){}
                }
            }
        }
        catch(Exception e){}
    }
    
    public static void main(String[] args){
        try{
            int port = 8081;
        ServerSocket ss = new ServerSocket(port);
        while(true)
        {
            Socket socket = ss.accept();
            Server server = new Server(socket);
            Thread thread = new Thread(server);
            thread.start();
        }
        }catch(Exception e){
            System.out.println(e);}
    }
}