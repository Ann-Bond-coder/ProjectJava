package com.netcracker.edu.inventory.model.device.entity.wrapper;

import com.netcracker.edu.inventory.model.device.entity.Battery;

public class BatteryWrapper extends SimpleDeviceWrapper implements Battery {
    public BatteryWrapper(AbstractDevicesWrapper abstractDevicesWrapper) {
        super(abstractDevicesWrapper);
    }

    @Override
    public int getChargeVolume() {
        return abstractDevicesWrapper.getChargeVolume();
    }

    @Override
    public void setChargeVolume(int chargeVolume) {
        abstractDevicesWrapper.setChargeVolume(chargeVolume);
    }
}
