package edu.hw2.task3.connections;

import edu.hw2.task3.workers.Worker;

public class StableConnection implements Connection {
    private final Worker worker;

    public StableConnection(Worker worker) {
        this.worker = worker;
    }

    @Override
    public void execute(String command) {
        worker.work();
    }

    @Override
    public void close() throws Exception {
    }
}
