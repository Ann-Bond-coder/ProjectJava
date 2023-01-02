package inventory.service.impl;

import com.netcracker.edu.inventory.model.device.Device;

import java.util.Objects;
import java.util.logging.Logger;

public class DeviceFiltrateImpl {
    private static final Logger LOGGER = Logger.getLogger(DeviceFiltrateImpl.class.getName());

    public boolean controlArrayForNull(Device[] devices) {
        if (devices == null) {
            NullPointerException nullPointerException = new NullPointerException();
            LOGGER.severe("The array can't be null. Your array: " + devices + ". " + nullPointerException);
            throw nullPointerException;
        }
        return true;
    }

    public void filtrateByType(Device[] devices, String type) {
        if (controlArrayForNull(devices)) {
            for (int i = 0; i < devices.length; i++) {
                if (devices[i] != null) {
                    if ((devices[i].getType() != null) && (!Objects.equals(devices[i].getType(),
                            type))) {
                        devices[i] = null;
                    } else if ((devices[i].getType() == null) && (type != null)) {
                        devices[i] = null;
                    }
                }
            }
        }
    }

    public void filtrateByManufacturer(Device[] devices, String manufacturer) {
        if (controlArrayForNull(devices)) {
            for (int i = 0; i < devices.length; i++) {
                if (devices[i] != null) {
                    if ((devices[i].getManufacturer() != null) && (!Objects.equals(devices[i].getManufacturer(),
                            manufacturer))) {
                        devices[i] = null;
                    } else if ((devices[i].getModel() == null) && (manufacturer != null)) {
                        devices[i] = null;
                    }
                }
            }
        }
    }

    public void filtrateByModel(Device[] devices, String model) {
        if (controlArrayForNull(devices)) {
            for (int i = 0; i < devices.length; i++) {
                if (devices[i] != null) {
                    if ((devices[i].getModel() != null) && (!Objects.equals(devices[i].getModel(), model))) {
                        devices[i] = null;
                    } else if ((devices[i].getModel() == null) && (model != null)) {
                        devices[i] = null;
                    }
                }
            }
        }
    }
}
