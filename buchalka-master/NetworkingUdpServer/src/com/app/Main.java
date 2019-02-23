package com.app;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Main {

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(5000);

            while (true) {
                byte[] inputBuffer = new byte[50];
                DatagramPacket packet = new DatagramPacket(inputBuffer, inputBuffer.length);
                socket.receive(packet);
                System.out.println("Text received is: " + new String(inputBuffer, 0, packet.getLength()));

                String returnString = "echo: " + new String(inputBuffer, 0, packet.getLength());

                byte[] outputBuffer = returnString.getBytes();
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                packet = new DatagramPacket(outputBuffer, outputBuffer.length, address, port);
                socket.send(packet);
            }

        } catch (SocketException e) {
            System.out.println("SocketException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
