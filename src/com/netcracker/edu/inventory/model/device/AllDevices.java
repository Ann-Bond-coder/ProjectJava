package com.netcracker.edu.inventory.model.device;

import com.netcracker.edu.inventory.model.device.entity.Battery;
import com.netcracker.edu.inventory.model.device.entity.Router;
import com.netcracker.edu.inventory.model.device.entity.Switch;
import com.netcracker.edu.inventory.model.device.entity.WifiRouter;

public interface AllDevices extends Battery, Router, Switch, WifiRouter, Device {
}
