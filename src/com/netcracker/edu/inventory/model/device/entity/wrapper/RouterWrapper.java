package com.netcracker.edu.inventory.model.device.entity.wrapper;

import com.netcracker.edu.inventory.model.device.entity.Router;

public class RouterWrapper extends SimpleDeviceWrapper implements Router {
    public RouterWrapper(AbstractDevicesWrapper abstractDevicesWrapper) {
        super(abstractDevicesWrapper);
    }

    @Override
    public int getDataRate() {
        return abstractDevicesWrapper.getDataRate();
    }

    @Override
    public void setDataRate(int dataRate) {
        abstractDevicesWrapper.setDataRate(dataRate);
    }
}
