package com.netcracker.edu.inventory.service;

import com.netcracker.edu.inventory.model.device.Device;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * The interface DeviceService describe list of services of Inventory component, witch working with Device
 */
public interface DeviceService {

    /**
     * Sort array of Device-s by identification number.
     *
     * @param devices - array of Device-s, that need to be sorted
     */
    void sortByIN(Device[] devices);

    /**
     * Sort array of Device-s by production date.
     *
     * @param devices - array of Device-s, that need to be sorted
     */
    void sortByProductionDate(Device[] devices);

    /**
     * Filtrate array of Device-s by type
     *
     * @param devices - array of Device-s, that need to be filtrated
     * @param type    - type of Devices, that will remain in the array after filtering
     */
    void filtrateByType(Device[] devices, String type);

    /**
     * Filtrate array of Device-s by manufacturer
     *
     * @param devices      - array of Device-s, that need to be filtrated
     * @param manufacturer - manufacturer of Devices, that will remain in the array after filtering
     */
    void filtrateByManufacturer(Device[] devices, String manufacturer);

    /**
     * Filtrate array of Device-s by model
     *
     * @param devices - array of Device-s, that need to be filtrated
     * @param model   - model of Devices, that will remain in the array after filtering
     */
    void filtrateByModel(Device[] devices, String model);

    /**
     * Method check validity of device for insert to rack
     *
     * @param device - validated device
     * @return true - if device is valid
     * false - if device is not valid
     */
    boolean isValidDeviceForInsertToRack(Device device);

    /**
     * Method check validity of device for output to byte output stream
     *
     * @param device - validated device
     * @return true - if device is valid
     * false - if device is not valid
     */
    boolean isValidDeviceForOutputToStream(Device device);

    /**
     * Write Device instance in to binary stream
     *
     * @param device       - source Device
     * @param outputStream - targeted binary stream
     */
    void outputDevice(Device device, OutputStream outputStream) throws IOException;

    /**
     * Read Device instance from binary stream
     *
     * @param inputStream - source binary stream
     * @return - received Device instance
     */
    Device inputDevice(InputStream inputStream) throws IOException, ClassNotFoundException;

}