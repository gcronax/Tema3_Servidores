package t3ejercicio4.b;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class serverTCP {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            while (true) {
                Socket clientSocket = serverSocket.accept();

                try {
                    OutputStream outputStream = clientSocket.getOutputStream();
                    PrintWriter out = new PrintWriter(outputStream,
                            true);
                    out.println("Hola, cliente! eres: "+clientSocket.getRemoteSocketAddress());
                } catch (IOException e) {
                    e.printStackTrace();
                }


                InputStream inputStream =
                        clientSocket.getInputStream();
                BufferedReader in = new BufferedReader(new
                        InputStreamReader(inputStream));
                String respuesta = in.readLine();
                System.out.println("Mensaje del cliente: " +
                        respuesta);
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}