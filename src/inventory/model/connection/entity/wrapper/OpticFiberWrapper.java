package inventory.model.connection.entity.wrapper;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.connection.entity.OpticFiber;
import com.netcracker.edu.inventory.model.device.Device;

public class OpticFiberWrapper<D extends Device> extends OneToOneConnectionWrapper<D>
        implements OpticFiber<D, D> {
    public OpticFiberWrapper(AbstractConnectionWrapper<D> abstractConnectionWrapper) {
        super(abstractConnectionWrapper);
    }
    @Override
    public Mode getMode() {
        return abstractConnectionWrapper.opticFiber.getMode();
    }

    @Override
    public int getLength() {
        return abstractConnectionWrapper.getLength();
    }

    @Override
    public void setLength(int length) {
        abstractConnectionWrapper.setLength(length);
    }
}
