package edu.hw2.task3.connections;

import edu.hw2.task3.exceptions.ConnectionException;
import edu.hw2.task3.workers.Worker;
import java.util.Random;

public class FaultyConnection implements Connection {
    private final Worker worker;
    private final double faultProbability;
    private final Random random;

    public FaultyConnection(Worker worker, double faultProbability) {
        if (faultProbability < 0 || faultProbability > 1) {
            throw new IllegalStateException();
        }
        random = new Random();
        this.worker = worker;
        this.faultProbability = faultProbability;
    }

    @Override
    public void execute(String command) {
        double rnd = random.nextDouble();
        if (rnd <= faultProbability) {
            throw new ConnectionException();
        }
        worker.work();
    }

    @Override
    public void close() throws Exception {

    }
}
