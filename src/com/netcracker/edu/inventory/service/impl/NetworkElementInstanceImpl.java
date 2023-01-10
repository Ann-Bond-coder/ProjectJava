package com.netcracker.edu.inventory.service.impl;

import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.NetworkElement;
import com.netcracker.edu.inventory.model.connection.Connection;

import java.util.logging.Logger;

public class NetworkElementInstanceImpl {
    private static final Logger LOGGER = Logger.getLogger(DeviceInstanceImpl.class.getName());
    IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
    ConnectionInstanceImpl connectionInstance = new ConnectionInstanceImpl();
    DeviceInstanceImpl deviceInstance = new DeviceInstanceImpl();
    public <T extends NetworkElement> T createNEInstance(Class<T> clazz) {
        if (clazz == null) {
            LOGGER.severe("The class can't be null. " + illegalArgumentException);
            throw illegalArgumentException;
        }
        if (Connection.class.isAssignableFrom(clazz)) {
            return connectionInstance.createInstance(clazz);
        } else if (Device.class.isAssignableFrom(clazz)) {
            return deviceInstance.createDeviceInstance(clazz);
        } else {
            LOGGER.severe("The class is not valid. " + illegalArgumentException);
            throw illegalArgumentException;
        }
    }
}
