package com.netcracker.edu.inventory.model.device.entity.impl;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.impl.AbstractDevice;

import java.util.*;
import java.util.logging.Logger;

public class Switch extends Router implements com.netcracker.edu.inventory.model.device.entity.Switch {
    private static final Logger LOGGER = Logger.getLogger(AbstractDevice.class.getName());
    protected int numberOfPorts = 0;
    private Queue<Field> fields;
    protected ConnectorType portsType = ConnectorType.need_init;
    List<Connection> portsConnections = new ArrayList<>();

    public Switch() {
    }

    public Switch(ConnectorType portsType) {
        this(portsType, 0);
    }

    public Switch(ConnectorType portsType, int numberOfPorts) {
        this.portsType = portsType;
        this.numberOfPorts = numberOfPorts;
        this.portsConnections = new ArrayList<>(numberOfPorts);
    }

    private void setPortsConnections(List portsConnections) {
        this.portsConnections = new ArrayList<>(Collections.nCopies(numberOfPorts, null));
        Collections.copy(this.portsConnections, portsConnections);
    }

    public List<Connection> getAllPortConnections() {
        return this.portsConnections;
    }


    public Connection getPortConnection(int portNumber) {
        if (indexOutOfBoundsExceptionControl(portNumber)) {
            return this.portsConnections.get(portNumber);
        }
        return null;
    }

    public void setPortConnection(Connection portsConnections, int portNumber) {
        if (indexOutOfBoundsExceptionControl(portNumber)) {
            this.portsConnections.set(portNumber, portsConnections);
        }
    }

    private void setPortsType(ConnectorType portsType) {
        if (this.portsType == ConnectorType.need_init) {
            this.portsType = portsType;
        }
    }

    public ConnectorType getPortsType() {
        return portsType;
    }

    public int getNumberOfPorts() {
        return numberOfPorts;
    }

    public void setNumberOfPorts(int numberOfPorts) {
        this.numberOfPorts = numberOfPorts;
        this.portsConnections = new ArrayList<>(Collections.nCopies(numberOfPorts, null));
    }

    private boolean indexOutOfBoundsExceptionControl(int index) {
        if ((index < 0) || (index >= numberOfPorts)) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
            String loggerMessage = "The index " + index + " is out of bounds. " +
                    "\n The correct range is from 0 to " + (numberOfPorts - 1);
            LOGGER.severe(loggerMessage + indexOutOfBoundsException);
            throw indexOutOfBoundsException;
        }
        return true;
    }

    @Override
    public void fillAllFields(Queue<Field> fields) {
        super.fillAllFields(fields);
        try {
            setNumberOfPorts((Integer) fields.remove().getValue());
            setPortsType(ConnectorType.valueOf((String) fields.remove().getValue()));
            setPortsConnections((List) fields.remove().getValue());
        } catch (NoSuchElementException noSuchElementException) {
            LOGGER.severe("The queue is running out of elements" + noSuchElementException);
            throw noSuchElementException;
        }
    }

    @Override
    public Queue<Field> getAllFields() {
        fields = super.getAllFields();
        fields.add(new Field(Integer.class, getNumberOfPorts()));
        fields.add(new Field(String.class, getPortsType().name()));
        fields.add(new Field(List.class, getAllPortConnections()));
        return fields;
    }
}