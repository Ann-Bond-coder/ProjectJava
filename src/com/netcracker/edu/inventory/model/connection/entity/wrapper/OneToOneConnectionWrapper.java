package com.netcracker.edu.inventory.model.connection.entity.wrapper;

import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.connection.OneToOneConnection;
import com.netcracker.edu.inventory.model.device.Device;

public class OneToOneConnectionWrapper<D extends Device> extends SimpleConnectionWrapper<D, D>
        implements OneToOneConnection<D, D> {
    public OneToOneConnectionWrapper(AbstractConnectionWrapper<D> abstractConnectionWrapper) {
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
    public D getBPoint() {
        return abstractConnectionWrapper.getBPoint();
    }

    @Override
    public void setBPoint(D device) {
        abstractConnectionWrapper.setBPoint(device);
    }
}
