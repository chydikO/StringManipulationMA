package com.company.service;

import com.company.model.ConnectionInfo;
import com.company.model.User;
import com.company.util.Randomazer;

import java.util.Collection;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.Queue;

public class ConnectionInfoService {
    public static Queue<ConnectionInfo> generateConnectionInfoQueue(int amount) {
        Queue<ConnectionInfo> connections = new PriorityQueue<>();
        for (int i = 0; i < amount; i++) {
            Integer sessionID = Randomazer.getRandomNumber(1_000_000, 9_999_999);
            String userID = Randomazer.getRandomNumber(100, 255) + "." +
                    Randomazer.getRandomNumber(100, 255) + "." +
                    Randomazer.getRandomNumber(100, 255);

            long time = new Date().getTime() - Randomazer.getRandomNumber(0, 1000 * 60 * 60 * 24);

            User user = new User(Randomazer.getRandomNumber(10000, 99999),
                    Randomazer.getRandomString(10),
                    Randomazer.getRandomString(12));

            ConnectionInfo connectionInfo = new ConnectionInfo(sessionID, userID, time, user);
            connections.add(connectionInfo);
        }
        return connections;
    }

    public static String getConnectionsAsText(Collection<ConnectionInfo> collection) {
        String result = "";
        for (ConnectionInfo connectionInfo : collection) {
            result += connectionInfo.toString() + "\n";
        }
        return result;
    }

    public static Queue<ConnectionInfo> getConnectionsFromText(String text) {
        Queue<ConnectionInfo> connections = new PriorityQueue<>();
        String[] lines = text.split("\n");
        for (String line : lines) {
            String[] words = line.split(" ");
            User user = new User(Integer.valueOf(words[5]), words[3], words[4]);

            ConnectionInfo connectionInfo = new ConnectionInfo(
                    Integer.valueOf(words[1]),
                    words[2],
                    Long.valueOf(words[0]), user);
            connections.add(connectionInfo);
        }
        return connections;
    }

    public static Queue<ConnectionInfo> filterConnectionsByTime(Collection<ConnectionInfo> allConnections, long from, long to) {
        Queue<ConnectionInfo> connections = new PriorityQueue<>();
        for (ConnectionInfo connectionInfo : allConnections) {
            if (connectionInfo.getTime() >= from && connectionInfo.getTime() <= to) {
                connections.add(connectionInfo);
            }
        }
        return connections;
    }
}
