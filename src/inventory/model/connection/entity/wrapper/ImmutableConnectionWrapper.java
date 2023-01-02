package inventory.model.connection.entity.wrapper;

import com.netcracker.edu.inventory.model.NetworkElement;
import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.device.entity.wrapper.ImmutableDeviceWrapper;
import com.netcracker.edu.location.Trunk;

import java.util.List;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImmutableConnectionWrapper<D extends Device> extends AbstractConnectionWrapper<D> {
    private static final Logger LOGGER = Logger.getLogger(ImmutableDeviceWrapper.class.getName());

    public <T extends NetworkElement> ImmutableConnectionWrapper(T original) {
        super((Connection<D, D>) original);
    }

    public void printLogImmutableMessage() {
        LOGGER.log(Level.WARNING, "The class is immutable. You can't change it.");
    }

    @Override
    public void fillAllFields(Queue<Field> fields) {
        printLogImmutableMessage();
    }

    @Override
    public boolean addDevice(D device) {
        printLogImmutableMessage();
        return false;
    }

    @Override
    public boolean removeDevice(D device) {
        printLogImmutableMessage();
        return false;
    }

    @Override
    public void setTrunk(Trunk trunk) {
        printLogImmutableMessage();
    }

    @Override
    public void setSerialNumber(int serialNumber) {
        printLogImmutableMessage();
    }

    @Override
    public void setStatus(String status) {
        printLogImmutableMessage();
    }

    @Override
    public void setAPoint(D device) {
        printLogImmutableMessage();
    }

    @Override
    public void setBPoint(D device) {
        printLogImmutableMessage();
    }

    @Override
    public void setBPoints(List<D> devices) {
        printLogImmutableMessage();
    }

    @Override
    public void setBPoint(D device, int deviceNumber) {
        printLogImmutableMessage();
    }

    @Override
    public void setVersion(int version) {
        printLogImmutableMessage();
    }

    @Override
    public void setProtocol(String protocol) {
        printLogImmutableMessage();
    }

    @Override
    public void setLength(int length) {
        printLogImmutableMessage();
    }
}
