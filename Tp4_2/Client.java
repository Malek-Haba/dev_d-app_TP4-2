package Tp4_2;

import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
    public static void main(String[] args) {
        try {
            // Résout l'adresse IP du serveur (dans ce cas, localhost, c'est-à-dire la machine locale).
            InetAddress serverAddress = InetAddress.getByName("localhost");

            // Crée une instance de DatagramSocket pour envoyer des données.
            DatagramSocket socket = new DatagramSocket();

            // Obtient la date actuelle.
            Date currentDate = new Date();

            // Crée un formateur de date pour formater la date actuelle au format "yyyy-MM-dd".
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            // Formate la date actuelle en une chaîne de caractères.
            String dateStr = dateFormat.format(currentDate);

            // Convertit la chaîne de caractères en tableau de bytes.
            byte[] sendData = dateStr.getBytes();

            // Crée un DatagramPacket pour les données à envoyer, en spécifiant l'adresse du serveur (localhost) et le port (1235).
            DatagramPacket packetOut = new DatagramPacket(sendData, sendData.length, serverAddress, 1235);

            // Envoie le paquet UDP au serveur.
            socket.send(packetOut);

        } catch (Exception e) {
            e.printStackTrace(); // Affiche toutes les exceptions qui se produisent.
        }
    }
}