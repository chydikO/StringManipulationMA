package com.company;

import com.company.model.ConnectionInfo;
import com.company.service.ConnectionInfoService;
import com.company.util.Randomazer;

import java.util.Queue;
import java.util.logging.Logger;

public class AppRunner {
    private static Logger logger = Logger.getLogger(AppRunner.class.getName());

    public static void main(String[] args) {
        logger.info("Random string is " + Randomazer.getRandomString(Randomazer.getRandomNumber(8,16)));

        Queue<ConnectionInfo> connections = ConnectionInfoService.generateConnectionInfoQueue(6);
        logger.info("My system generated " + connections.size() + "connections") ;

        for (ConnectionInfo connectionInfo: connections   ) {
            logger.info(connectionInfo.toString());
        }

        String connectionsAsText = ConnectionInfoService.getConnectionsAsText(connections);
        logger.info("\n" + connectionsAsText);

    }
}
