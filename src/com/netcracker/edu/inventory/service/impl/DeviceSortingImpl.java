package com.netcracker.edu.inventory.service.impl;

import com.netcracker.edu.inventory.model.device.Device;

import java.util.Arrays;
import java.util.Comparator;
import java.util.logging.Logger;

class DeviceSortingImpl {
    private static final Logger LOGGER = Logger.getLogger(DeviceSortingImpl.class.getName());

    public boolean controlArrayForNull(Device[] devices) {
        if (devices == null) {
            NullPointerException nullPointerException = new NullPointerException();
            LOGGER.severe("The array can't be null. Your array: " + devices + ". " + nullPointerException);
            throw nullPointerException;
        }
        return true;
    }

    public void sortByProductionDate(Device[] devices) {
        if (controlArrayForNull(devices)) {
            Comparator<Device> comparator = (device1, device2) -> {
                if (device1 == null) {
                    return 1;
                } else if (device2 == null) {
                    return -1;
                } else if (device1.getProductionDate() == null) {
                    return 1;
                } else if (device2.getProductionDate() == null) {
                    return -1;
                }
                return device1.getProductionDate().compareTo(device2.getProductionDate());
            };
            Arrays.sort(devices, comparator);
        }
    }

    public void sortByIN(Device[] devices) {
        if (controlArrayForNull(devices)) {
            Comparator<Device> comparator = (device1, device2) -> {
                if (device1 == null) {
                    return 1;
                } else if (device2 == null) {
                    return -1;
                } else if (device1.getIn() == 0) {
                    return 1;
                } else if (device2.getIn() == 0) {
                    return -1;
                }
                return Integer.compare(device1.getIn(), device2.getIn());
            };
            Arrays.sort(devices, comparator);
        }
    }
}
