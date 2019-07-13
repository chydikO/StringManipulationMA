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
        ConnectionInfo connectionInfoFromResultConnections = resultConnections.remove();
        ConnectionInfo connectionInfoExpected = expectedConnections.remove();

        assertTrue(connectionInfoExpected.getUser().equals(connectionInfoFromResultConnections.getUser()));
        assertTrue(connectionInfoExpected.getTime().equals(connectionInfoFromResultConnections.getTime()));
        assertTrue(connectionInfoExpected.getSessionID().equals(connectionInfoFromResultConnections.getSessionID()));
        assertTrue(connectionInfoExpected.getUserIP().equals(connectionInfoFromResultConnections.getUserIP()));


    }


    @Test
    void testFilterConnectionsByTime() {
        Queue<ConnectionInfo> expectedConnections = new PriorityQueue<>();
        User user = new User(17788, "OvUOnjlYoM", "fqM3gCba0ESS");
        ConnectionInfo connectionInfo = new ConnectionInfo( 9021654,
                "142.174.109",  1562843320435L, user);
        expectedConnections.add(connectionInfo);

        user = new User(99958, "ImaCFkc4Hm", "HA7g58dLlIdG");
        connectionInfo = new ConnectionInfo( 5288721, "169.238.191",1562947877212L, user);
        expectedConnections.add(connectionInfo);

        logger.info("   xsxs ");
        /* 1562970915882 2744936 225.156.219 hvdk6g0wzn T2bTynqq1ohq 72426
        1562986205111 8012199 197.122.209 XcktVVNJ3a q1lmjE36MLyv 64864
        1562988460568 6754895 252.228.199 Mop8cOJTGT IaJNQAt2061H 79592
        1562989684349 5760522 141.233.139 adv8mq4QWM eawrQY1CZ28E 61724
        1563002157365 5733387 106.244.245 TD2OYK88Em f5R4oPBQJa4e 34695
        */
    }
}