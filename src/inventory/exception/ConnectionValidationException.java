package inventory.exception;

import com.netcracker.edu.inventory.model.connection.Connection;

public class ConnectionValidationException extends RuntimeException {
    private Connection connection;
    public static final String DEF_ERR_MESSAGE = "Connection is not valid for operation";

    public ConnectionValidationException() {
    }

    public ConnectionValidationException(String operation) {
        super(DEF_ERR_MESSAGE + ((operation != null) ? " " + operation : ""));
    }

    public ConnectionValidationException(String operation, Connection connection) {
        this(operation);
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }
}
