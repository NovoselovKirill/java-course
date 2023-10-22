package edu.hw2.task3.connectionManager;

import edu.hw2.task3.connections.Connection;
import edu.hw2.task3.connections.FaultyConnection;
import edu.hw2.task3.connections.StableConnection;
import edu.hw2.task3.workers.Worker;
import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {
    private final Worker worker;
    private final double faultProbability;
    private final double returnFaultyConnectionProbability;
    private final Random random;

    public DefaultConnectionManager(Worker worker, double faultProbability, double returnFaultyConnectionProbability) {
        if (returnFaultyConnectionProbability < 0 || returnFaultyConnectionProbability > 1) {
            throw new IllegalStateException();
        }

        random = new Random();
        this.worker = worker;
        this.faultProbability = faultProbability;
        this.returnFaultyConnectionProbability = returnFaultyConnectionProbability;
    }

    @Override
    public Connection getConnection() {
        double rnd = random.nextDouble();
        if (rnd <= returnFaultyConnectionProbability) {
            return new FaultyConnection(worker, faultProbability);
        }
        return new StableConnection(worker);
    }
}
