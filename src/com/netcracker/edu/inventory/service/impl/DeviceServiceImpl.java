package com.netcracker.edu.inventory.service.impl;

import com.netcracker.edu.inventory.exception.DeviceValidationException;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.NetworkElement;
import com.netcracker.edu.inventory.service.DeviceService;
import com.netcracker.edu.io.impl.IOServiceImpl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;

public class DeviceServiceImpl implements DeviceService {
    private static final Logger LOGGER = Logger.getLogger(DeviceServiceImpl.class.getName());
    DeviceSortingImpl deviceSorting = new DeviceSortingImpl();
    DeviceFiltrateImpl deviceFiltrate = new DeviceFiltrateImpl();
    NetworkElementInstanceImpl networkElementInstance = new NetworkElementInstanceImpl();
    private static final IOServiceImpl ioService = new IOServiceImpl();

    public <T extends NetworkElement> T createNEInstance(Class<T> clazz) {
        return networkElementInstance.createNEInstance(clazz);
    }

    @Override
    public void sortByIN(Device[] devices) {
        deviceSorting.sortByIN(devices);
    }

    @Override
    public void sortByProductionDate(Device[] devices) {
        deviceSorting.sortByProductionDate(devices);
    }

    @Override
    public void filtrateByType(Device[] devices, String type) {
        deviceFiltrate.filtrateByType(devices, type);
    }

    @Override
    public void filtrateByManufacturer(Device[] devices, String manufacturer) {
        deviceFiltrate.filtrateByManufacturer(devices, manufacturer);
    }

    @Override
    public void filtrateByModel(Device[] devices, String model) {
        deviceFiltrate.filtrateByModel(devices, model);
    }

    @Override
    public boolean isValidDeviceForInsertToRack(Device device) {
        return (device != null) && (device.getIn() > 0);
    }

    @Override
    public boolean isValidDeviceForOutputToStream(Device device) {
        return ioService.isValidEntityForOutputToStream(device);
    }

    @Override
    public void outputDevice(Device device, OutputStream outputStream) throws IOException {
        if (isValidDeviceForOutputToStream(device)) {
            ioService.outputFillableEntity(device, outputStream);
        } else {
            DeviceValidationException deviceValidationException = new DeviceValidationException();
            LOGGER.severe("DeviceServiceImpl.outputDevice. \nThe device is not valid. "
                    + deviceValidationException);
            throw deviceValidationException;
        }
    }

    @Override
    public Device inputDevice(InputStream inputStream) throws IOException, ClassNotFoundException {
        return (Device) ioService.inputFillableEntity(inputStream);
    }
}