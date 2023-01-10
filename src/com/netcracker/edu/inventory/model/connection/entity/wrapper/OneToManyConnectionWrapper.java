package com.netcracker.edu.inventory.model.connection.entity.wrapper;

import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.connection.OneToManyConnection;
import com.netcracker.edu.inventory.model.device.Device;

import java.util.List;

public class OneToManyConnectionWrapper <D extends Device> extends SimpleConnectionWrapper<D, D>
        implements OneToManyConnection<D, D> {
    public OneToManyConnectionWrapper(AbstractConnectionWrapper<D> abstractConnectionWrapper) {
        super(abstractConnectionWrapper);
    }

    @Override
    public ConnectorType getAPointConnectorType() {
        return abstractConnectionWrapper.getAPointConnectorType();
    }

    @Override
    public ConnectorType getBPointConnectorType() {
        return abstractConnectionWrapper.getBPointConnectorType();
    }

    @Override
    public D getAPoint() {
        return abstractConnectionWrapper.getAPoint();
    }

    @Override
    public void setAPoint(D device) {
        abstractConnectionWrapper.setAPoint(device);
    }

    @Override
    public List<D> getBPoints() {
        return abstractConnectionWrapper.getBPoints();
    }

    @Override
    public void setBPoints(List<D> devices) {
        abstractConnectionWrapper.setBPoints(devices);
    }

    @Override
    public int getBCapacity() {
        return abstractConnectionWrapper.getBCapacity();
    }

    @Override
    public D getBPoint(int deviceNumber) {
        return abstractConnectionWrapper.getBPoint(deviceNumber);
    }

    @Override
    public void setBPoint(D device, int deviceNumber) {
        abstractConnectionWrapper.setBPoint(device, deviceNumber);
    }
}
