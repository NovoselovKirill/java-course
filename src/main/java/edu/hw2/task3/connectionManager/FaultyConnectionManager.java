package edu.hw2.task3.connectionManager;

import edu.hw2.task3.connections.Connection;
import edu.hw2.task3.connections.FaultyConnection;
import edu.hw2.task3.workers.Worker;

public class FaultyConnectionManager implements ConnectionManager {
    private final Worker worker;
    private final double faultProbability;

    public FaultyConnectionManager(Worker worker, double faultProbability) {
        this.worker = worker;
        this.faultProbability = faultProbability;
    }

    @Override
    public Connection getConnection() {
        return new FaultyConnection(worker, faultProbability);
    }
}
