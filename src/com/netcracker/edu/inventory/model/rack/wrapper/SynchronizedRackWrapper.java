package com.netcracker.edu.inventory.model.rack.wrapper;

import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.rack.Rack;
import com.netcracker.edu.inventory.model.rack.impl.AbstractRackArray;
import com.netcracker.edu.location.Location;

public class SynchronizedRackWrapper <D extends Device> extends AbstractRackArray<D>{
    public <D1 extends Device> SynchronizedRackWrapper(Rack<D1> rack) {
        super(rack);
    }

    @Override
    public synchronized Location getLocation() {
        return super.getLocation();
    }

    @Override
    public synchronized void setLocation(Location location) {
        super.setLocation(location);
    }

    @Override
    public synchronized int getSize() {
        return super.getSize();
    }

    @Override
    public synchronized int getFreeSize() {
        return super.getFreeSize();
    }

    @Override
    public synchronized Class getTypeOfDevices() {
        return super.getTypeOfDevices();
    }

    @Override
    public synchronized D getDevAtSlot(int index) {
        return super.getDevAtSlot(index);
    }

    @Override
    public synchronized boolean insertDevToSlot(D device, int index) {
        return super.insertDevToSlot(device, index);
    }

    @Override
    public synchronized D removeDevFromSlot(int index) {
        return super.removeDevFromSlot(index);
    }

    @Override
    public synchronized D getDevByIN(int in) {
        return super.getDevByIN(in);
    }

    @Override
    public synchronized D[] getAllDeviceAsArray() {
        return super.getAllDeviceAsArray();
    }

    @Override
    public synchronized int hashCode() {
        return super.hashCode();
    }

    @Override
    public synchronized boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected synchronized Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public synchronized String toString() {
        return super.toString();
    }

    @Override
    protected synchronized void finalize() throws Throwable {
        super.finalize();
    }
}
