package com.netcracker.edu.inventory.model.rack.wrapper;

import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.rack.Rack;
import com.netcracker.edu.inventory.model.rack.impl.AbstractRackArray;
import com.netcracker.edu.location.Location;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ImmutableRackWrapper<D extends Device> extends AbstractRackArray<D> {
    private static final Logger LOGGER = Logger.getLogger(ImmutableRackWrapper.class.getName());

    public ImmutableRackWrapper(Rack<D> rack) {
        super(rack);
    }

    @Override
    public void setLocation(Location location) {
        LOGGER.log(Level.WARNING, "The class RackArray is immutable. You can't change it.");
    }

    @Override
    public boolean insertDevToSlot(D device, int index) {
        LOGGER.log(Level.WARNING, "The class RackArray is immutable. You can't change it.");
        return false;
    }

    @Override
    public D removeDevFromSlot(int index) {
        LOGGER.log(Level.WARNING, "The class RackArray is immutable. You can't change it.");
        return null;
    }
}

