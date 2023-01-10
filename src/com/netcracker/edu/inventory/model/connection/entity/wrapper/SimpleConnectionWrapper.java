package com.netcracker.edu.inventory.model.connection.entity.wrapper;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.location.Trunk;

import java.util.Queue;

public abstract class SimpleConnectionWrapper <A extends Device, B extends Device> implements Connection <A, B> {
    protected AbstractConnectionWrapper<A> abstractConnectionWrapper;

    public SimpleConnectionWrapper(AbstractConnectionWrapper<A> abstractConnectionWrapper) {
        this.abstractConnectionWrapper = abstractConnectionWrapper;
    }

    public AbstractConnectionWrapper<A> getWrapper() {
        return abstractConnectionWrapper;
    }

    @Override
    public void fillAllFields(Queue<Field> fields) {
        abstractConnectionWrapper.fillAllFields(fields);
    }

    @Override
    public Queue<Field> getAllFields() {
        return abstractConnectionWrapper.getAllFields();
    }

    @Override
    public Trunk getTrunk() {
        return abstractConnectionWrapper.getTrunk();
    }

    @Override
    public void setTrunk(Trunk trunk) {
        abstractConnectionWrapper.setTrunk(trunk);
    }

    @Override
    public int getSerialNumber() {
        return abstractConnectionWrapper.getSerialNumber();
    }

    @Override
    public void setSerialNumber(int serialNumber) {
        abstractConnectionWrapper.setSerialNumber(serialNumber);
    }

    @Override
    public String getStatus() {
        return abstractConnectionWrapper.getStatus();
    }

    @Override
    public void setStatus(String status) {
        abstractConnectionWrapper.setStatus(status);
    }

    @Override
    public int compareTo(Connection o) {
        return abstractConnectionWrapper.compareTo(o);
    }
}
