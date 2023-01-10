package com.netcracker.edu.inventory.model.impl;

import com.netcracker.edu.inventory.model.device.Device;

import java.util.*;
import java.util.logging.Logger;

public abstract class AbstractDevice implements Device {
    private static final Logger LOGGER = Logger.getLogger(AbstractDevice.class.getName());
    IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
    protected String manufacturer;
    protected Date productionDate;
    protected Queue<Field> fields;
    protected int in = 0;
    protected String type;
    protected String model;

    @Override
    public int getIn() {
        return in;
    }

    @Override
    public void setIn(int in) {
        if (in < 0) {
            LOGGER.severe("IN can not be negative" + illegalArgumentException);
            throw illegalArgumentException;
        } else if (this.in > 0) {
            LOGGER.warning("Inventory number can not be reset");
        } else {
            this.in = in;
        }
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public Date getProductionDate() {
        return productionDate;
    }

    @Override
    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    @Override
    public void fillAllFields(Queue<Field> fields) {
        try {
            setIn((Integer) fields.remove().getValue());
            setType((String) fields.remove().getValue());
            setManufacturer((String) fields.remove().getValue());
            setModel((String) fields.remove().getValue());
            setProductionDate((Date) fields.remove().getValue());
        } catch (NoSuchElementException noSuchElementException) {
            LOGGER.severe("The queue is running out of elements" + noSuchElementException);
            throw noSuchElementException;
        }
    }

    @Override
    public Queue<Field> getAllFields() {
        fields = new ArrayDeque<>();
        fields.add(new Field(Integer.class, getIn()));
        fields.add(new Field(String.class, getType()));
        fields.add(new Field(String.class, getManufacturer()));
        fields.add(new Field(String.class, getModel()));
        fields.add(new Field(Date.class, getProductionDate()));
        return fields;
    }

    @Override
    public int compareTo(Device o) {
        return Integer.compare(in, o.getIn());
    }
}
