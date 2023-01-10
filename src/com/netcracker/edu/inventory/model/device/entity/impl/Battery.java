package com.netcracker.edu.inventory.model.device.entity.impl;

import com.netcracker.edu.inventory.model.impl.AbstractDevice;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.logging.Logger;

public class Battery extends AbstractDevice implements com.netcracker.edu.inventory.model.device.entity.Battery {
    private static final Logger LOGGER = Logger.getLogger(AbstractDevice.class.getName());
    protected int chargeVolume;
    private Queue<Field> fields;

    public int getChargeVolume() {
        return chargeVolume;
    }

    public void setChargeVolume(int chargeVolume) {
        this.chargeVolume = chargeVolume;
    }

    @Override
    public void fillAllFields(Queue<Field> fields) {
        super.fillAllFields(fields);
        try {
            setChargeVolume((Integer) fields.remove().getValue());
        } catch (NoSuchElementException noSuchElementException) {
            LOGGER.severe("The queue is running out of elements" + noSuchElementException);
            throw noSuchElementException;
        }
    }

    @Override
    public Queue<Field> getAllFields() {
        fields = super.getAllFields();
        fields.add(new Field(Integer.class, getChargeVolume()));
        return fields;
    }
}
