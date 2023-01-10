package com.netcracker.edu.inventory.model.rack.wrapper;

import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.rack.Rack;
import com.netcracker.edu.inventory.model.rack.impl.AbstractRackArray;
import com.netcracker.edu.location.Location;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PublishRackWrapper<D extends Device> extends AbstractRackArray<D> {
    protected PropertyChangeSupport propertyChangeSupport;

    public PublishRackWrapper(Rack<D> rack) {
        super(rack);
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public void addListener(PropertyChangeListener listener) {
         propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removeListener(PropertyChangeListener listener) {
         propertyChangeSupport.removePropertyChangeListener(listener);
    }

    @Override
    public boolean insertDevToSlot(D device, int index) {
        Object valueOld = rack.getDevAtSlot(index);
        propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this, "devices",
                valueOld, device));
        return rack.insertDevToSlot(device, index);
    }

    @Override
    public D removeDevFromSlot(int index) {
        D valueOld = (D) rack.getDevAtSlot(index);
        propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this, "devices",
                valueOld, null));
        return super.removeDevFromSlot(index);
    }

    @Override
    public void setLocation(Location location) {
        Object locationOld = super.getLocation();
        Object locationNew = location;
        propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this, "location",
                locationOld, locationNew));
    }
}
