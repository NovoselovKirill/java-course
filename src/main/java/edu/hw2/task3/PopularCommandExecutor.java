package edu.hw2.task3;

import edu.hw2.task3.connectionManager.ConnectionManager;
import edu.hw2.task3.connections.Connection;
import edu.hw2.task3.exceptions.ConnectionException;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void tryExecute(String command) throws Exception {
        ConnectionException cause = null;
        for (int i = 0; i < maxAttempts; i++) {
            cause = tryExecuteOnce(command);
            if (cause != null) {
                return;
            }
        }
        throw new ConnectionException(cause);
    }

    private ConnectionException tryExecuteOnce(String command) throws Exception {
        try (Connection connection = manager.getConnection()) {
            connection.execute(command);
            return null;
        } catch (ConnectionException e) {
            return e;
        }
    }
}
