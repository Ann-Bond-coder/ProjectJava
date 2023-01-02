package inventory.model.rack.impl;

import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.rack.Rack;
import com.netcracker.edu.location.Location;

public class AbstractRackArray<D extends Device> implements Rack<D> {
    protected Rack rack;
    public <D extends Device> AbstractRackArray(Rack<D> rack) {
        this.rack = rack;
    }

    @Override
    public Location getLocation() {
        return rack.getLocation();
    }

    @Override
    public void setLocation(Location location) {
        rack.setLocation(location);
    }

    @Override
    public int getSize() {
        return rack.getSize();
    }

    @Override
    public int getFreeSize() {
        return rack.getFreeSize();
    }

    @Override
    public Class getTypeOfDevices() {
        return rack.getTypeOfDevices();
    }

    @Override
    public D getDevAtSlot(int index) {
        return (D) rack.getDevAtSlot(index);
    }

    @Override
    public boolean insertDevToSlot(D device, int index) {
        return rack.insertDevToSlot(device, index);
    }

    @Override
    public D removeDevFromSlot(int index) {
        return (D) rack.removeDevFromSlot(index);
    }

    @Override
    public D getDevByIN(int in) {
        return (D) rack.getDevByIN(in);
    }

    @Override
    public D[] getAllDeviceAsArray() {
        return (D[]) rack.getAllDeviceAsArray();
    }
}
