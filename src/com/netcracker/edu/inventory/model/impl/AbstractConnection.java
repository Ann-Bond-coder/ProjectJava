package com.netcracker.edu.inventory.model.impl;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.location.Trunk;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.logging.Logger;

public abstract class AbstractConnection<A extends Device, B extends Device> implements Connection<A, B> {
    private static final Logger LOGGER = Logger.getLogger(AbstractDevice.class.getName());
    protected ConnectorType pointAConnectorType = ConnectorType.need_init;
    protected ConnectorType pointBConnectorType = ConnectorType.need_init;
    protected String status = Connection.PLANED;
    protected int serialNumber = 0;
    protected Queue<Field> fields;
    protected Trunk trunk;

    @Override
    public Trunk getTrunk() {
        return trunk;
    }

    @Override
    public void setTrunk(Trunk trunk) {
        this.trunk = trunk;
    }

    @Override
    public int getSerialNumber() {
        return serialNumber;
    }

    @Override
    public void setSerialNumber(int serialNumber) {
        if (serialNumber < 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            LOGGER.severe("IN can not be negative" + illegalArgumentException);
            throw illegalArgumentException;
        } else if (this.serialNumber > 0) {
            LOGGER.warning("Inventory number can not be reset");
        } else {
            this.serialNumber = serialNumber;
        }
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int compareTo(Connection connection) {
        return Integer.compare(serialNumber, connection.getSerialNumber());
    }

    public void fillAllFields(Queue<Field> fields) {
        try {
            setTrunk((Trunk) fields.remove().getValue());
            setSerialNumber((Integer) fields.remove().getValue());
            setStatus((String) fields.remove().getValue());
        } catch (NoSuchElementException noSuchElementException) {
            LOGGER.severe("The queue is running out of elements." + noSuchElementException);
            throw noSuchElementException;
        }
    }

    @Override
    public Queue<Field> getAllFields() {
        fields = new ArrayDeque<>();
        fields.add(new Field(Trunk.class, getTrunk()));
        fields.add(new Field(Integer.class, getSerialNumber()));
        fields.add(new Field(String.class, getStatus()));
        return fields;
    }
}
