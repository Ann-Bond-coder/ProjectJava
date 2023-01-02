package inventory.model.connection.entity.wrapper;

import com.netcracker.edu.inventory.model.connection.AllToAllConnection;
import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.device.Device;

import java.util.Set;

public class AllToAllConnectionWrapper<D extends Device> extends SimpleConnectionWrapper<D, D>
        implements AllToAllConnection<D> {

    public AllToAllConnectionWrapper(AbstractConnectionWrapper<D> abstractConnectionWrapper) {
        super(abstractConnectionWrapper);
    }

    @Override
    public boolean addDevice(Device device) {
        return abstractConnectionWrapper.addDevice((D) device);
    }

    @Override
    public ConnectorType getConnectorType() {
        return abstractConnectionWrapper.getConnectorType();
    }

    @Override
    public boolean removeDevice(D device) {
        return abstractConnectionWrapper.removeDevice(device);
    }

    @Override
    public boolean containDevice(D device) {
        return abstractConnectionWrapper.containDevice(device);
    }

    @Override
    public Set<D> getAllDevices() {
        return abstractConnectionWrapper.getAllDevices();
    }

    @Override
    public int getCurSize() {
        return abstractConnectionWrapper.getCurSize();
    }

    @Override
    public int getMaxSize() {
        return abstractConnectionWrapper.getMaxSize();
    }

    @Override
    public int compareTo(Connection o) {
        return abstractConnectionWrapper.compareTo(o);
    }
}
