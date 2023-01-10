package com.netcracker.edu.inventory.model.device.entity.wrapper;

import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.NetworkElement;
import com.netcracker.edu.inventory.model.connection.Connection;

import java.util.Date;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImmutableDeviceWrapper<D extends Device> extends AbstractDevicesWrapper {
    private static final Logger LOGGER = Logger.getLogger(ImmutableDeviceWrapper.class.getName());

    public <T extends NetworkElement> ImmutableDeviceWrapper(T original) {
        super((Device) original);
    }

    public void printLogImmutableMessage() {
        LOGGER.log(Level.WARNING, "The class is immutable. You can't change it.");
    }

    @Override
    public void fillAllFields(Queue<Field> fields) {
        printLogImmutableMessage();
    }

    @Override
    public void setIn(int in) {
        printLogImmutableMessage();
    }

    @Override
    public void setType(String type) {
        printLogImmutableMessage();
    }

    @Override
    public void setManufacturer(String manufacturer) {
        printLogImmutableMessage();
    }

    @Override
    public void setModel(String model) {
        printLogImmutableMessage();
    }

    @Override
    public void setProductionDate(Date productionDate) {
        printLogImmutableMessage();
    }

    @Override
    public void setChargeVolume(int chargeVolume) {
        printLogImmutableMessage();
    }

    @Override
    public void setDataRate(int dataRate) {
        printLogImmutableMessage();
    }

    @Override
    public void setNumberOfPorts(int numberOfPorts) {
        printLogImmutableMessage();
    }

    @Override
    public void setPortConnection(Connection connection, int portNumber) {
        printLogImmutableMessage();
    }

    @Override
    public void setSecurityProtocol(String securityProtocol) {
        printLogImmutableMessage();
    }

    @Override
    public void setWirelessConnection(Connection wirelessConnection) {
        printLogImmutableMessage();
    }

    @Override
    public void setWireConnection(Connection wireConnection) {
        printLogImmutableMessage();
    }
}

