package t3ejercicio4.b;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class serverUDP {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(12345);
            System.out.println("Servidor UDP escuchando...");

            while (true) {
                byte[] buffer = new byte[1024];
                DatagramPacket paquete =
                        new DatagramPacket(buffer, buffer.length);

                socket.receive(paquete);

                String mensaje = new String(
                        paquete.getData(),
                        0,
                        paquete.getLength()
                );

                System.out.println("Mensaje del cliente: " + mensaje);

                String respuesta = "Hola, cliente! eres: "
                        + paquete.getAddress() + ":" + paquete.getPort();

                byte[] bufferRespuesta = respuesta.getBytes();

                DatagramPacket paqueteRespuesta =
                        new DatagramPacket(
                                bufferRespuesta,
                                bufferRespuesta.length,
                                paquete.getAddress(),
                                paquete.getPort()
                        );

                socket.send(paqueteRespuesta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
