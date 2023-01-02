package inventory.model.connection.entity.wrapper;

import com.netcracker.edu.inventory.model.connection.*;
import com.netcracker.edu.inventory.model.connection.entity.*;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.impl.AbstractAllToAllConnection;
import com.netcracker.edu.inventory.model.impl.AbstractConnection;
import com.netcracker.edu.inventory.model.impl.AbstractOneToOneConnection;
import com.netcracker.edu.location.Trunk;

import java.util.List;
import java.util.Queue;
import java.util.Set;

public class AbstractConnectionWrapper<D extends Device> implements AllConections<D> {

    protected AbstractConnection<D, D> abstractConnection;
    protected AbstractAllToAllConnection<D> allToAllConnection;
    protected AbstractOneToOneConnection<D, D> oneToOneConnection;
    protected Connection connection;
    protected Connection.OneAPoint oneAPoint;
    protected Connection.OneBPoint oneBPoint;
    protected Connection.HaveAPoint haveAPoint;
    protected Connection.HaveBPoint haveBPoint;
    protected Connection.MultipleBPoint multipleBPoint;
    protected ThinCoaxial thinCoaxial;
    protected TwistedPair twistedPair;
    protected OpticFiber opticFiber;

    protected Wireless wireless;


    public AbstractConnectionWrapper(Connection<D, D> connection) {
        this.abstractConnection = (AbstractConnection<D, D>) connection;
        if (connection instanceof AbstractAllToAllConnection) {
            this.allToAllConnection = (AbstractAllToAllConnection<D>) connection;
            if (connection instanceof ThinCoaxial) {
                this.thinCoaxial = (ThinCoaxial) connection;
            }
        }
        if (connection instanceof Connection.HaveAPoint) {
            this.haveAPoint = (Connection.HaveAPoint) connection;
            if (connection instanceof Connection.OneAPoint) {
                this.oneAPoint = (Connection.OneAPoint) connection;
                if (connection instanceof Connection.HaveBPoint) {
                    this.haveBPoint = (Connection.HaveBPoint) connection;
                    if (connection instanceof Connection.OneBPoint) {
                        this.oneBPoint = (Connection.OneBPoint) connection;
                        if (connection instanceof OpticFiber) {
                            this.opticFiber = (OpticFiber) connection;
                        }
                        if (connection instanceof TwistedPair) {
                            this.twistedPair = (TwistedPair) connection;
                        }
                    }
                }
            }
        }
        if (connection instanceof Connection.MultipleBPoint) {
            this.multipleBPoint = (MultipleBPoint) connection;
            if (connection instanceof Wireless) {
                this.wireless = (Wireless) connection;
            }
        }
    }

    @Override
    public void fillAllFields(Queue<Field> fields) {
        abstractConnection.fillAllFields(fields);
    }

    @Override
    public Queue<Field> getAllFields() {
        return abstractConnection.getAllFields();
    }

    @Override
    public ConnectorType getConnectorType() {
        return allToAllConnection.getConnectorType();
    }

    @Override
    public boolean addDevice(D device) {
        return allToAllConnection.addDevice(device);
    }

    @Override
    public boolean removeDevice(D device) {
        return allToAllConnection.removeDevice(device);
    }

    @Override
    public boolean containDevice(D device) {
        return allToAllConnection.containDevice(device);
    }

    @Override
    public Set<D> getAllDevices() {
        if (allToAllConnection == null){
            throw new ClassCastException();
        }
        else {
            return allToAllConnection.getAllDevices();
        }
    }

    @Override
    public int getCurSize() {
        return allToAllConnection.getCurSize();
    }

    @Override
    public int getMaxSize() {
        return allToAllConnection.getMaxSize();
    }

    @Override
    public Trunk getTrunk() {
        return abstractConnection.getTrunk();
    }

    @Override
    public void setTrunk(Trunk trunk) {
        abstractConnection.setTrunk(trunk);
    }

    @Override
    public int getSerialNumber() {
        return abstractConnection.getSerialNumber();
    }

    @Override
    public void setSerialNumber(int serialNumber) {
        abstractConnection.setSerialNumber(serialNumber);
    }

    @Override
    public String getStatus() {
        return abstractConnection.getStatus();
    }

    @Override
    public void setStatus(String status) {
        abstractConnection.setStatus(status);
    }

    @Override
    public ConnectorType getAPointConnectorType() {
        return haveAPoint.getAPointConnectorType();
    }

    @Override
    public ConnectorType getBPointConnectorType() {
        return haveBPoint.getBPointConnectorType();
    }

    @Override
    public D getAPoint() {
        return (D) oneAPoint.getAPoint();
    }

    @Override
    public void setAPoint(D device) {
        oneAPoint.setAPoint(device);
    }

    @Override
    public D getBPoint() {
        return (D) oneBPoint.getBPoint();
    }

    @Override
    public void setBPoint(D device) {
        oneBPoint.setBPoint(device);
    }

    @Override
    public List<D> getBPoints() {
        return multipleBPoint.getBPoints();
    }

    @Override
    public void setBPoints(List<D> devices) {
        multipleBPoint.setBPoints(devices);
    }

    @Override
    public int getBCapacity() {
        return multipleBPoint.getBCapacity();
    }

    @Override
    public D getBPoint(int deviceNumber) {
        return (D) multipleBPoint.getBPoint(deviceNumber);
    }

    @Override
    public void setBPoint(D device, int deviceNumber) {
        multipleBPoint.setBPoint(device, deviceNumber);
    }

    @Override
    public int compareTo(Connection o) {
        return oneToOneConnection.compareTo(o);
    }

    @Override
    public Mode getMode() {
        return opticFiber.getMode();
    }

    @Override
    public Type getType() {
        return twistedPair.getType();
    }

    @Override
    public int getLength() {
        if (opticFiber != null) {
            return opticFiber.getLength();
        } else {
            return twistedPair.getLength();
        }
    }

    @Override
    public void setLength(int length) {
        if (opticFiber != null) {
            opticFiber.setLength(length);
        } else {
            twistedPair.setLength(length);
        }
    }

    @Override
    public String getTechnology() {
        return wireless.getTechnology();
    }

    @Override
    public String getProtocol() {
        return wireless.getProtocol();
    }

    @Override
    public void setProtocol(String protocol) {
        wireless.setProtocol(protocol);
    }

    @Override
    public int getVersion() {
        return wireless.getVersion();
    }

    @Override
    public void setVersion(int version) {
        wireless.setVersion(version);
    }
}
