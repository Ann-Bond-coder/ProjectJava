package com.netcracker.edu.inventory.model.device.entity.impl;

import com.netcracker.edu.inventory.model.impl.AbstractDevice;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.logging.Logger;

public class Router extends AbstractDevice implements com.netcracker.edu.inventory.model.device.entity.Router {
    private static final Logger LOGGER = Logger.getLogger(AbstractDevice.class.getName());
    protected int dataRate;
    private Queue<Field> fields;

    public int getDataRate() {
        return dataRate;
    }

    public void setDataRate(int dataRate) {
        this.dataRate = dataRate;
    }

    @Override
    public void fillAllFields(Queue<Field> fields) {
        super.fillAllFields(fields);
        try {
            setDataRate((Integer) fields.remove().getValue());
        } catch (NoSuchElementException noSuchElementException) {
            LOGGER.severe("The queue is running out of elements" + noSuchElementException);
            throw noSuchElementException;
        }
    }

    @Override
    public Queue<Field> getAllFields() {
        fields = super.getAllFields();
        fields.add(new Field(Integer.class, getDataRate()));
        return fields;
    }
}
