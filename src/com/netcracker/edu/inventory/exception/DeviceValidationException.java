package com.netcracker.edu.inventory.exception;

import com.netcracker.edu.inventory.model.device.Device;

public class DeviceValidationException extends RuntimeException {
    private Device device;
    public static final String DEF_ERR_MESSAGE = "Device is not valid for operation";

    public Device getDevice() {
        return device;
    }

    public DeviceValidationException() {
        super();
    }

    public DeviceValidationException(String operation) {
        super(DEF_ERR_MESSAGE + ((operation != null) ? " " + operation : ""));
    }

    public DeviceValidationException(String operation, Device device) {
        this(operation);
        this.device = device;
    }
}
