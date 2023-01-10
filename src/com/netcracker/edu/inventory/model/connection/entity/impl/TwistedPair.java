package com.netcracker.edu.inventory.model.connection.entity.impl;

import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.impl.AbstractDevice;
import com.netcracker.edu.inventory.model.impl.AbstractOneToOneConnection;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.logging.Logger;

public class TwistedPair<A extends Device, B extends Device> extends AbstractOneToOneConnection<A, B>
        implements com.netcracker.edu.inventory.model.connection.entity.TwistedPair<A, B> {
    private static final Logger LOGGER = Logger.getLogger(AbstractDevice.class.getName());
    protected Queue<Field> fields;
    protected int lenght = 0;

    protected Type type = Type.need_init;

    public TwistedPair() {
        super(ConnectorType.RJ45, ConnectorType.RJ45);
    }

    public TwistedPair(Type type, int length) {
        this();
        this.type = type;
        this.lenght = length;
    }

    public int getLength() {
        return lenght;
    }

    public void setLength(int lenght) {
        this.lenght = lenght;
    }

    private void setType(Type type) {
        if (this.type.equals(Type.need_init)) {
            this.type = type;
        }
    }

    public Type getType() {
        return type;
    }

    public void fillAllFields(Queue<Field> fields) {
        super.fillAllFields(fields);
        try {
            setLength((Integer) fields.remove().getValue());
            setType(Type.valueOf((String) fields.remove().getValue()));
        } catch (NoSuchElementException noSuchElementException) {
            LOGGER.severe("The queue is running out of elements." + noSuchElementException);
            throw noSuchElementException;
        }
    }

    public Queue<Field> getAllFields() {
        fields = super.getAllFields();
        fields.add(new Field(Integer.class, getLength()));
        fields.add(new Field(String.class, getType().name()));
        return fields;
    }
}