package inventory.model.connection.entity.wrapper;

import com.netcracker.edu.inventory.model.NetworkElement;
import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.location.Trunk;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class PublishConnectionWrapper<D extends Device> extends AbstractConnectionWrapper<D> {
    protected PropertyChangeSupport propertyChangeSupport;

    public <T extends NetworkElement> PublishConnectionWrapper(T original) {
        super((Connection<D, D>) original);
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public PublishConnectionWrapper (Connection original, PropertyChangeListener propertyChangeListener){
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
    public boolean addDevice(D device) {
       // Object valueOld = allToAllConnection.addDevice(device);
        propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this, "devices",
                null, device));
        return allToAllConnection.addDevice(device);
    }

    @Override
    public boolean removeDevice(D device) {
       // Object valueOld = allToAllConnection.removeDevice(device);
        propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this, "devices",
                device, null));
        return super.removeDevice(device);
    }

    @Override
    public void setTrunk(Trunk trunk) {
        Object trunkOld = super.getTrunk();
        Object trunkNew = trunk;
        super.setTrunk(trunk);
        propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this, "trunk",
                trunkOld, trunkNew));
    }

    @Override
    public void setSerialNumber(int serialNumber) {
        Object serialNumberOld = super.getSerialNumber();
        Object serialNumberNew = serialNumber;
        super.setSerialNumber(serialNumber);
        propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this, "serialNumber",
                serialNumberOld, serialNumberNew));
    }

    @Override
    public void setStatus(String status) {
        Object statusOld = super.getStatus();
        Object statusNew = status;
        super.setStatus(status);
        propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this, "status",
                statusOld, statusNew));
    }

    @Override
    public void setAPoint(D device) {
        Object deviceOld = super.getAPoint();
        Object deviceNew = device;
        super.setAPoint(device);
        propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this, "aPoint",
                deviceOld, deviceNew));
    }

    @Override
    public void setBPoint(D device) {
        Object deviceOld = super.getBPoint();
        Object deviceNew = device;
        super.setBPoint(device);
        propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this, "bPoint",
                deviceOld, deviceNew));
    }


    @Override
    public void setBPoints(List<D> devices) {
        Object devicesOld = super.getBPoints();
        Object devicesNew = devices;
        super.setBPoints(devices);
        propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this, "bPoints",
                devicesOld, devicesNew));
    }

    @Override
    public void setBPoint(D device, int deviceNumber) {
        Object deviceOld = super.getBPoint(deviceNumber);
        Object deviceNew = device;
        super.setBPoint(device, deviceNumber);
        propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this, "bPoint",
                deviceOld, deviceNew));
    }

    @Override
    public void setLength(int length) {
        Object lengthOld = super.getLength();
        Object lengthNew = length;
        super.setLength(length);
        propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this, "length",
                lengthOld, lengthNew));
    }

    @Override
    public void setProtocol(String protocol) {
        Object protocolOld = super.getProtocol();
        Object protocolNew = protocol;
        super.setProtocol(protocol);
        propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this, "protocol",
                protocolOld, protocolNew));
    }

    @Override
    public void setVersion(int version) {
        Object versionOld = super.getVersion();
        Object versionNew = version;
        super.setVersion(version);
        propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this, "version",
                versionOld, versionNew));
    }
}
