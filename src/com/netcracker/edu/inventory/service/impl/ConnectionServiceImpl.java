package com.netcracker.edu.inventory.service.impl;

import com.netcracker.edu.inventory.exception.ConnectionValidationException;
import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.service.ConnectionService;
import com.netcracker.edu.io.impl.IOServiceImpl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;

class ConnectionServiceImpl implements ConnectionService {
    private static final Logger LOGGER = Logger.getLogger(ConnectionServiceImpl.class.getName());
    private static final IOServiceImpl ioService = new IOServiceImpl();

    @Override
    public boolean isValidConnectionForOutputToStream(Connection connection) {
        return ioService.isValidEntityForOutputToStream(connection);
    }

    @Override
    public void outputConnection(Connection connection, OutputStream outputStream) throws IOException {
        if (isValidConnectionForOutputToStream(connection)) {
            ioService.outputFillableEntity(connection, outputStream);
        } else {
            ConnectionValidationException connectionValidationException =
                    new ConnectionValidationException("ConnectionServiceImpl.outputConnection.");
            LOGGER.severe(connectionValidationException + "ConnectionServiceImpl.outputConnection. \nThe connection is not valid. ");
            throw connectionValidationException;
        }
    }

    @Override
    public Connection inputConnection(InputStream inputStream) throws IOException, ClassNotFoundException {
        return (Connection) new IOServiceImpl().inputFillableEntity(inputStream);
    }
}
