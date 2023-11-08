package Tp4_2;

import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server {
    public static void main(String[] args) {
        try {
            // Crée une instance de DatagramSocket qui écoute sur le port 1235.
            DatagramSocket serverSocket = new DatagramSocket(1235);

            // Crée un tableau de bytes pour stocker les données reçues.
            byte[] receiveData = new byte[1024];

            while (true) {
                // Crée un DatagramPacket pour stocker les données reçues.
                DatagramPacket packetIn = new DatagramPacket(receiveData, receiveData.length);

                // Attend de recevoir un paquet UDP.
                serverSocket.receive(packetIn);

                // Convertit les données reçues en une chaîne de caractères (la date au format "yyyy-MM-d").
                String dateStr = new String(receiveData, 0, packetIn.getLength());

                // Crée un formateur de date pour analyser la date reçue.
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-d");

                // Analyse la date en tant qu'objet Date.
                Date receivedDate = dateFormat.parse(dateStr);

                // Affiche la date reçue à l'écran.
                System.out.println("Bonjour " + receivedDate);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}