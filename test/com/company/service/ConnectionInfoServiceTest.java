package com.company.service;

import com.company.model.ConnectionInfo;
import org.junit.jupiter.api.Test;

import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionInfoServiceTest {

    @Test
    void testGenerateConnectionInfoQueue() {
        Queue<ConnectionInfo> connections= ConnectionInfoService.generateConnectionInfoQueue(10);
        assertNotNull(connections);
        assertEquals( 10, connections.size());
    }

    @Test
    void testGetConnectionsAsText() {
    }
}