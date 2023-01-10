package com.netcracker.edu.inventory.model.connection.entity.wrapper;

import com.netcracker.edu.inventory.model.connection.entity.Wireless;
import com.netcracker.edu.inventory.model.device.Device;

public class WirelessWrapper <D extends Device> extends OneToManyConnectionWrapper<D>
        implements Wireless<D, D> {
    public WirelessWrapper(AbstractConnectionWrapper<D> abstractConnectionWrapper) {
        super(abstractConnectionWrapper);
    }

    @Override
    public String getTechnology() {
        return abstractConnectionWrapper.getTechnology();
    }

    @Override
    public String getProtocol() {
        return abstractConnectionWrapper.getProtocol();
    }

    @Override
    public void setProtocol(String protocol) {
        abstractConnectionWrapper.setProtocol(protocol);
    }

    @Override
    public int getVersion() {
        return abstractConnectionWrapper.getVersion();
    }

    @Override
    public void setVersion(int version) {
        abstractConnectionWrapper.setVersion(version);
    }
}
