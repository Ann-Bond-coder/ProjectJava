package com.netcracker.edu.inventory.model.connection.entity.wrapper;

import com.netcracker.edu.inventory.model.connection.entity.ThinCoaxial;
import com.netcracker.edu.inventory.model.device.Device;

public class ThinCoaxialWrapper<D extends Device> extends AllToAllConnectionWrapper<D>
        implements ThinCoaxial<D> {
    public ThinCoaxialWrapper(AbstractConnectionWrapper<D> abstractConnectionWrapper) {
        super(abstractConnectionWrapper);
    }
}
