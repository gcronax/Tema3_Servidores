package t3ejercicio4;

import java.io.*;
import java.net.Socket;

public class ClienteHandler implements Runnable{
    private Socket clientSocket;

    public ClienteHandler(Socket socket){
        this.clientSocket=socket;
    }

    @Override
    public void run() {
        try{
            InputStream inputStream = clientSocket.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            String respuesta = in.readLine();
            System.out.println("Mensaje del cliente: " + respuesta);

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("Hola, cliente!");


            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
