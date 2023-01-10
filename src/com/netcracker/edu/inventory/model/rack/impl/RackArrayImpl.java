package com.netcracker.edu.inventory.model.rack.impl;

import com.netcracker.edu.inventory.exception.DeviceValidationException;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.rack.Rack;
import com.netcracker.edu.inventory.service.impl.DeviceServiceImpl;
import com.netcracker.edu.location.Location;

import java.util.*;
import java.util.logging.Logger;

public class RackArrayImpl<D extends Device> implements Rack<D> {
    private static final Logger LOGGER = Logger.getLogger(RackArrayImpl.class.getName());
    protected int size;
    protected D[] devicesResult;
    protected D[] devices;
    protected final Class classSaveType;
    protected Location location;

    public RackArrayImpl(int size) {
        this(size, Device.class);
    }

    public RackArrayImpl(int size, Class clazz) {
        classSaveType = clazz;
        if ((classSaveType != null) && (Device.class.isAssignableFrom(classSaveType))) {
            if (size <= 0) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
                LOGGER.severe("Size of rack can not be 0 or less" + illegalArgumentException);
                throw illegalArgumentException;
            } else {
                this.size = size;
                devices = (D[]) new Device[size];
            }
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            LOGGER.severe("The type can't be null or not Device." + illegalArgumentException);
            throw illegalArgumentException;
        }
    }

    private boolean indexOutOfBoundsExceptionControl(int index) {
        if ((index < 0) || (index >= size)) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
            String loggerMessage = "The index " + index + " is out of bounds. " +
                    "\n The correct range is from 0 to " + (devices.length - 1);
            LOGGER.severe(loggerMessage + indexOutOfBoundsException);
            throw indexOutOfBoundsException;
        }
        return true;
    }

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getFreeSize() {
        int freeSize = size;
        for (D device : devices) {
            if (device != null) {
                freeSize--;
            }
        }
        return freeSize;
    }

    @Override
    public Class getTypeOfDevices() {
        return classSaveType;
    }

    @Override
    public D getDevAtSlot(int index) {
        if (indexOutOfBoundsExceptionControl(index)) {
            try {
                if ((devices[index] == null) || (devices[index].getIn() == 0)) {
                    return null;
                } else {
                    return devices[index];
                }
            } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                LOGGER.severe("The array index is out of bounds." + arrayIndexOutOfBoundsException);
                throw arrayIndexOutOfBoundsException;
            }
        }
        return null;
    }

    @Override
    public boolean insertDevToSlot(D device, int index) {
        DeviceServiceImpl deviceService = new DeviceServiceImpl();
        if (indexOutOfBoundsExceptionControl(index)) {
            if (!deviceService.isValidDeviceForInsertToRack(device)) {
                DeviceValidationException deviceValidationException = new DeviceValidationException
                        ("RackArrayImpl.isValidDeviceForInsertToRack");
                LOGGER.severe("The device is not valid for insert to rack." + deviceValidationException);
                throw deviceValidationException;
            } else if (!classSaveType.isInstance(device)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
                LOGGER.severe("The type of device is not correct." + illegalArgumentException);
                throw illegalArgumentException;
            } else {
                if (devices[index] == null) {
                    devices[index] = device;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public D removeDevFromSlot(int index) {
        if (indexOutOfBoundsExceptionControl(index)) {
            if (devices[index] == null) {
                LOGGER.warning("Can not remove from empty slot " + index);
                return null;
            } else {
                D result = devices[index];
                devices[index] = null;
                return result;
            }
        }
        return null;
    }

    @Override
    public D getDevByIN(int in) {
        if (in < 0) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
            LOGGER.severe("The identification number " + in + " isn't correct." + indexOutOfBoundsException);
            throw indexOutOfBoundsException;
        } else {
            for (D device : devices) {
                if ((device != null) && (device.getIn() == in)) {
                    return device;
                }
            }
            return null;
        }
    }

    @Override
    public D[] getAllDeviceAsArray() {
        List<D> listDevices = new ArrayList<>();
        for (D device : devices) {
            if (device != null) {
                listDevices.add(device);
            }
        }
        devicesResult = (D[]) new Device[listDevices.size()];
        for (int i = 0; i < listDevices.size(); i++) {
            devicesResult[i] = listDevices.get(i);
        }
        return devicesResult;
    }
}
