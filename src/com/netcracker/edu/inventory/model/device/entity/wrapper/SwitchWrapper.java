package com.netcracker.edu.inventory.model.device.entity.wrapper;

import com.netcracker.edu.inventory.model.device.entity.Switch;
import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.ConnectorType;

import java.util.List;

public class SwitchWrapper extends RouterWrapper implements Switch {
    public SwitchWrapper(AbstractDevicesWrapper abstractDevicesWrapper) {
        super(abstractDevicesWrapper);
    }

    @Override
    public int getNumberOfPorts() {
        return abstractDevicesWrapper.getNumberOfPorts();
    }

    @Override
    public void setNumberOfPorts(int numberOfPorts) {
        abstractDevicesWrapper.setNumberOfPorts(numberOfPorts);
    }

    @Override
    public ConnectorType getPortsType() {
        return abstractDevicesWrapper.getPortsType();
    }

    @Override
    public Connection getPortConnection(int portNumber) {
        return abstractDevicesWrapper.getPortConnection(portNumber);
    }

    @Override
    public void setPortConnection(Connection connection, int portNumber) {
        abstractDevicesWrapper.setPortConnection(connection, portNumber);
    }

    @Override
    public List<Connection> getAllPortConnections() {
        return abstractDevicesWrapper.getAllPortConnections();
    }
}
