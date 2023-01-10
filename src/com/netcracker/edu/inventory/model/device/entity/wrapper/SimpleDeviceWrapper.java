package com.netcracker.edu.inventory.model.device.entity.wrapper;

import com.netcracker.edu.inventory.model.device.Device;

import java.util.Date;
import java.util.Queue;

public class SimpleDeviceWrapper implements Device {
    protected AbstractDevicesWrapper abstractDevicesWrapper;

    public SimpleDeviceWrapper(AbstractDevicesWrapper abstractDevicesWrapper) {
        this.abstractDevicesWrapper = abstractDevicesWrapper;
    }

    @Override
    public void fillAllFields(Queue<Field> fields) {
        abstractDevicesWrapper.fillAllFields(fields);
    }

    @Override
    public Queue<Field> getAllFields() {
        return abstractDevicesWrapper.getAllFields();
    }

    @Override
    public int getIn() {
        return abstractDevicesWrapper.getIn();
    }

    @Override
    public void setIn(int in) {
        abstractDevicesWrapper.setIn(in);
    }

    @Override
    public String getType() {
        return abstractDevicesWrapper.getType();
    }

    @Override
    public void setType(String type) {
        abstractDevicesWrapper.setType(type);
    }

    @Override
    public String getManufacturer() {
        return abstractDevicesWrapper.getManufacturer();
    }

    @Override
    public void setManufacturer(String manufacturer) {
        abstractDevicesWrapper.setManufacturer(manufacturer);
    }

    @Override
    public String getModel() {
        return abstractDevicesWrapper.getModel();
    }

    @Override
    public void setModel(String model) {
        abstractDevicesWrapper.setModel(model);
    }

    @Override
    public Date getProductionDate() {
        return abstractDevicesWrapper.getProductionDate();
    }

    @Override
    public void setProductionDate(Date productionDate) {
        abstractDevicesWrapper.setProductionDate(productionDate);
    }

    @Override
    public int compareTo(Device o) {
        return abstractDevicesWrapper.compareTo(o);
    }

    /**
     * Для методов врап в других классах
     */
    public AbstractDevicesWrapper getWrapper() {
        return abstractDevicesWrapper;
    }
}
