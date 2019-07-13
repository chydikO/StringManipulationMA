package com.company.service;

import com.company.AppRunner;
import com.company.model.ConnectionInfo;
import com.company.model.User;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionInfoServiceTest {
    private static Logger logger = Logger.getLogger(ConnectionInfoServiceTest.class.getName());

    @Test
    void testGenerateConnectionInfoQueue() {
        Queue<ConnectionInfo> connections= ConnectionInfoService.generateConnectionInfoQueue(10);
        assertNotNull(connections);
        assertEquals( 10, connections.size());
    }

    @Test
    void testGetConnectionsAsTextWithTrueCollection() {
        Queue<ConnectionInfo> connections = new PriorityQueue<>();
        User user = new User(17788, "OvUOnjlYoM", "fqM3gCba0ESS");

        ConnectionInfo connectionInfo = new ConnectionInfo( 9021654,
                "142.174.109",  1562843320435L, user);
        connections.add(connectionInfo);

        String expectedText = "1562843320435 9021654 142.174.109 OvUOnjlYoM fqM3gCba0ESS 17788\n";
        String resultText = ConnectionInfoService.getConnectionsAsText(connections);
        assertEquals(expectedText, resultText);
        logger.info("123");
    }

    @Test
    void testGetConnectionsAsTextWithEmptyCollection() {
        Queue<ConnectionInfo> connections = new PriorityQueue<>();
        assertEquals("",ConnectionInfoService.getConnectionsAsText(connections));
    }


    @Test
    void testGetConnectionsFromText() {
        Queue<ConnectionInfo> expectedConnections = new PriorityQueue<>();
        User user = new User(17788, "OvUOnjlYoM", "fqM3gCba0ESS");
        ConnectionInfo connectionInfo = new ConnectionInfo( 9021654,
                "142.174.109",  1562843320435L, user);
        expectedConnections.add(connectionInfo);

        String inputText = "1562843320435 9021654 142.174.109 OvUOnjlYoM fqM3gCba0ESS 17788\n";
        Queue<ConnectionInfo> resultConnections = ConnectionInfoService.getConnectionsFromText(inputText);
        assertTrue(expectedConnections.equals(resultConnections));
    }


    @Test
    void testFilterConnectionsByTime() {
    }
}