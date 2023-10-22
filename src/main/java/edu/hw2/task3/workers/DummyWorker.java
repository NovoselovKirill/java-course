package edu.hw2.task3.workers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DummyWorker implements Worker {
    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public void work() {
        LOGGER.info("Doing work...");
    }
}
