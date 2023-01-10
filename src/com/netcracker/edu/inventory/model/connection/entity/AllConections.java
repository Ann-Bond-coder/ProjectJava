package com.netcracker.edu.inventory.model.connection.entity;

import com.netcracker.edu.inventory.model.connection.AllToAllConnection;
import com.netcracker.edu.inventory.model.connection.OneToManyConnection;
import com.netcracker.edu.inventory.model.connection.OneToOneConnection;
import com.netcracker.edu.inventory.model.device.Device;

public interface AllConections<D extends Device> extends AllToAllConnection<D>, OneToManyConnection<D, D>,
        OneToOneConnection<D, D>, OpticFiber<D, D>, ThinCoaxial<D>, TwistedPair<D, D>, Wireless<D,D> {
}
