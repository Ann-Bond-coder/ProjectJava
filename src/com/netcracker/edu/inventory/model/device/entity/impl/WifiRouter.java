package com.netcracker.edu.inventory.model.device.entity.impl;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.impl.AbstractDevice;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.logging.Logger;

public class WifiRouter extends Router implements com.netcracker.edu.inventory.model.device.entity.WifiRouter {
    private static final Logger LOGGER = Logger.getLogger(AbstractDevice.class.getName());
    protected String securityProtocol;
    private Queue<Field> fields;
    protected String technologyVersion = null;
    protected Connection wirelessConnection;
    protected Connection wireConnection;
    protected ConnectorType wirePortType = ConnectorType.need_init;

    public Connection getWireConnection() {
        return wireConnection;
    }

    public void setWireConnection(Connection wireConnection) {
        this.wireConnection = wireConnection;
    }

    public Connection getWirelessConnection() {
        return wirelessConnection;
    }

    public void setWirelessConnection(Connection wirelessConnection) {
        this.wirelessConnection = wirelessConnection;
    }

    public String getTechnologyVersion() {
        return technologyVersion;
    }

    private void setTechnologyVersion(String technologyVersion) {
        if (this.technologyVersion == null) {
            this.technologyVersion = technologyVersion;
        }
    }

    public ConnectorType getWirePortType() {
        return wirePortType;
    }

    private void setWirePortType(ConnectorType wirePortType) {
        if (this.wirePortType == ConnectorType.need_init) {
            this.wirePortType = wirePortType;
        }
    }

    public String getSecurityProtocol() {
        return securityProtocol;
    }

    public void setSecurityProtocol(String securityProtocol) {
        this.securityProtocol = securityProtocol;
    }

    public WifiRouter() {
    }

    public WifiRouter(String technologyVersion, ConnectorType wirePortType) {
        setTechnologyVersion(technologyVersion);
        setWirePortType(wirePortType);
    }

    @Override
    public void fillAllFields(Queue<Field> fields) {
        super.fillAllFields(fields);
        try {
            setSecurityProtocol((String) fields.remove().getValue());
            setTechnologyVersion((String) fields.remove().getValue());
            setWirePortType(ConnectorType.valueOf((String) fields.remove().getValue()));
            setWireConnection((Connection) fields.remove().getValue());
            setWirelessConnection((Connection) fields.remove().getValue());
        } catch (NoSuchElementException noSuchElementException) {
            LOGGER.severe("The queue is running out of elements" + noSuchElementException);
            throw noSuchElementException;
        }
    }

    @Override
    public Queue<Field> getAllFields() {
        fields = super.getAllFields();
        fields.add(new Field(String.class, getSecurityProtocol()));
        fields.add(new Field(String.class, getTechnologyVersion()));
        fields.add(new Field(String.class, getWirePortType().name()));
        fields.add(new Field(Connection.class, getWireConnection()));
        fields.add(new Field(Connection.class, getWirelessConnection()));
        return fields;
    }
}