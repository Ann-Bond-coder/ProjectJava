package com.netcracker.edu.inventory.model.device.entity.wrapper;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.device.entity.WifiRouter;

public class WifiRouterWrapper extends RouterWrapper implements WifiRouter {
    public WifiRouterWrapper(AbstractDevicesWrapper abstractDevicesWrapper) {
        super(abstractDevicesWrapper);
    }

    @Override
    public String getTechnologyVersion() {
        return abstractDevicesWrapper.getTechnologyVersion();
    }

    @Override
    public String getSecurityProtocol() {
        return abstractDevicesWrapper.getSecurityProtocol();
    }

    @Override
    public void setSecurityProtocol(String securityProtocol) {
        abstractDevicesWrapper.setSecurityProtocol(securityProtocol);
    }

    @Override
    public Connection getWirelessConnection() {
        return abstractDevicesWrapper.getWirelessConnection();
    }

    @Override
    public void setWirelessConnection(Connection wirelessConnection) {
        abstractDevicesWrapper.setWirelessConnection(wirelessConnection);
    }

    @Override
    public ConnectorType getWirePortType() {
        return abstractDevicesWrapper.getWirePortType();
    }

    @Override
    public Connection getWireConnection() {
        return abstractDevicesWrapper.getWireConnection();
    }

    @Override
    public void setWireConnection(Connection wireConnection) {
        abstractDevicesWrapper.setWireConnection(wireConnection);
    }
}
