package com.netcracker.edu.inventory.model.impl;

import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.connection.OneToManyConnection;

import java.util.*;
import java.util.logging.Logger;

public abstract class AbstractOneToManyConnection<A extends Device, B extends Device> extends AbstractConnection<A, B>
        implements OneToManyConnection<A, B> {
    private static final Logger LOGGER = Logger.getLogger(AbstractDevice.class.getName());
    protected List<B> pointsB = new ArrayList<>();
    protected A pointA;
    protected int capacityB;
    protected Queue<Field> fields;

    public AbstractOneToManyConnection(ConnectorType pointAConnectorType, ConnectorType pointBConnectorType) {
        this.pointAConnectorType = pointAConnectorType;
        this.pointBConnectorType = pointBConnectorType;
    }

    private void setCapacityB(int capacityB) {
        this.capacityB = capacityB;
    }

    public ConnectorType getAPointConnectorType() {
        return pointAConnectorType;
    }

    public ConnectorType getBPointConnectorType() {
        return pointBConnectorType;
    }

    protected void setAPointConnectorType(ConnectorType pointAConnectorType) {
        if (this.pointAConnectorType == ConnectorType.need_init) {
            this.pointAConnectorType = pointAConnectorType;
        }
    }

    protected void setBPointConnectorType(ConnectorType pointBConnectorType) {
        if (this.pointBConnectorType == ConnectorType.need_init) {
            this.pointBConnectorType = pointBConnectorType;
        }
    }

    @Override
    public A getAPoint() {
        return (A) pointA;
    }

    @Override
    public void setAPoint(A device) {
        this.pointA = device;
    }

    @Override
    public List<B> getBPoints() {
        return pointsB;
    }

    @Override
    public void setBPoints(List<B> devices) {
        if (this.capacityB == devices.size()) {
            Collections.copy(this.pointsB, devices);
        } else {
            this.pointsB = new ArrayList<>(Collections.nCopies(devices.size(), null));
            Collections.copy(this.pointsB, devices);
        }
    }

    @Override
    public int getBCapacity() {
        return capacityB;
    }

    @Override
    public B getBPoint(int deviceNumber) {
        indexOutOfBoundsTest(deviceNumber);
        return pointsB.get(deviceNumber);
    }

    @Override
    public void setBPoint(B device, int deviceNumber) {
        this.pointsB = new ArrayList<>(Collections.nCopies(capacityB, null));
        indexOutOfBoundsTest(deviceNumber);
        this.pointsB.set(deviceNumber, device);
    }

    private void indexOutOfBoundsTest(int deviceNumber) {
        if (deviceNumber < 0) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
            LOGGER.severe("The number can`t be negative." + indexOutOfBoundsException);
            throw indexOutOfBoundsException;
        }
    }

    @Override
    public void fillAllFields(Queue<Field> fields) {
        super.fillAllFields(fields);
        try {
            setAPointConnectorType(ConnectorType.valueOf(String.valueOf(fields.remove().getValue())));
            setBPointConnectorType(ConnectorType.valueOf(String.valueOf(fields.remove().getValue())));
            setAPoint((A) fields.remove().getValue());
            setBPoints((List<B>) fields.remove().getValue());
            setCapacityB((Integer) fields.remove().getValue());
        } catch (NoSuchElementException noSuchElementException) {
            LOGGER.severe("The queue is running out of elements." + noSuchElementException);
            throw noSuchElementException;
        }
    }

    @Override
    public Queue<Field> getAllFields() {
        fields = super.getAllFields();
        fields.add(new Field(ConnectorType.class, getAPointConnectorType()));
        fields.add(new Field(ConnectorType.class, getBPointConnectorType()));
        fields.add(new Field(Device.class, getAPoint()));
        fields.add(new Field(Device.class, getBPoints()));
        fields.add(new Field(Integer.class, getBCapacity()));
        return fields;
    }
}
