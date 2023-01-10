package com.netcracker.edu.inventory.model.device.entity.wrapper;

import com.netcracker.edu.inventory.model.NetworkElement;
import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.device.Device;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;

public class PublishDeviceWrapper<D extends Device> extends AbstractDevicesWrapper {
    protected PropertyChangeSupport propertyChangeSupport;

    public <T extends NetworkElement> PublishDeviceWrapper(T original) {
        super((D) original);
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public PublishDeviceWrapper (Device original, PropertyChangeListener propertyChangeListener){
        this(original);
        addListener(propertyChangeListener);
    }

    public void addListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    @Override
    public void setIn(int in) {
        Object inOld = super.getIn();
        Object inNew = in;
        propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this, "in",
                inOld, inNew));
    }

    @Override
    public void setType(String type) {
        Object typeOld = super.getType();
        Object typeNew = type;
        propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this, "type",
                typeOld, typeNew));
    }

    @Override
    public void setManufacturer(String manufacturer) {
        Object manufacturerOld = super.getManufacturer();
        Object manufacturerNew = manufacturer;
        propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this, "manufacturer",
                manufacturerOld, manufacturerNew));
    }

    @Override
    public void setModel(String model) {
        Object modelOld = super.getModel();
        Object modelNew = model;
        propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this, "model",
                modelOld, modelNew));
    }

    @Override
    public void setProductionDate(Date productionDate) {
        Object productionDateOld = super.getProductionDate();
        Object productionDateNew = productionDate;
        propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this, "productionDate",
                productionDateOld, productionDateNew));
    }

    @Override
    public void setChargeVolume(int chargeVolume) {
        Object chargeVolumeOld = super.getChargeVolume();
        Object chargeVolumeNew = chargeVolume;
        propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this, "chargeVolume",
                chargeVolumeOld, chargeVolumeNew));
    }

    @Override
    public void setDataRate(int dataRate) {
        Object dataRateOld = super.getDataRate();
        Object dataRateNew = dataRate;
        propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this, "dataRate",
                dataRateOld, dataRateNew));
    }

    @Override
    public void setNumberOfPorts(int numberOfPorts) {
        Object numberOfPortsOld = super.getNumberOfPorts();
        Object numberOfPortsNew = numberOfPorts;
        propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this, "numberOfPorts",
                numberOfPortsOld, numberOfPortsNew));
    }

    @Override
    public void setPortConnection(Connection connection, int portNumber) {
        Object connectionOld = super.getPortConnection(portNumber);
        Object connectionNew = connection;
        propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this, "portConnection",
                connectionOld, connectionNew));
    }

    @Override
    public void setSecurityProtocol(String securityProtocol) {
        Object securityProtocolOld = super.getSecurityProtocol();
        Object securityProtocolNew = securityProtocol;
        propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this, "securityProtocol",
                securityProtocolOld, securityProtocolNew));
    }

    @Override
    public void setWirelessConnection(Connection wirelessConnection) {
        Object wirelessConnectionOld = super.getWirelessConnection();
        Object wirelessConnectionNew = wirelessConnection;
        propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this, "wirelessConnection",
                wirelessConnectionOld, wirelessConnectionNew));
    }

    @Override
    public void setWireConnection(Connection wireConnection) {
        Object wireConnectionOld = super.getWireConnection();
        Object wireConnectionNew = wireConnection;
        propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this, "wireConnection",
                wireConnectionOld, wireConnectionNew));
    }
}
