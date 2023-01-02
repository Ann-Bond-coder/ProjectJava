package inventory.model.impl;

import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.connection.OneToOneConnection;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.logging.Logger;

public abstract class AbstractOneToOneConnection<A extends Device, B extends Device> extends AbstractConnection<A, B>
        implements OneToOneConnection<A, B> {
    private static final Logger LOGGER = Logger.getLogger(AbstractDevice.class.getName());
    protected A pointA;
    protected B pointB;

    protected Queue<Field> fields;

    public AbstractOneToOneConnection(ConnectorType pointAConnectorType, ConnectorType pointBConnectorType) {
        this.pointAConnectorType = pointAConnectorType;
        this.pointBConnectorType = pointBConnectorType;
    }

    public ConnectorType getAPointConnectorType() {
        return pointAConnectorType;
    }

    public ConnectorType getBPointConnectorType() {
        return pointBConnectorType;
    }

    @Override
    public A getAPoint() {
        return pointA;
    }

    public void setAPoint(A device) {
        this.pointA = device;
    }

    @Override
    public B getBPoint() {
        return pointB;
    }

    public void setBPoint(B device) {
        this.pointB = device;
    }

    @Override
    public void fillAllFields(Queue<Field> fields) {
        super.fillAllFields(fields);
        try {
            setAPoint((A) fields.remove().getValue());
            setBPoint((B) fields.remove().getValue());
        } catch (NoSuchElementException noSuchElementException) {
            LOGGER.severe("The queue is running out of elements." + noSuchElementException);
            throw noSuchElementException;
        }
    }

    @Override
    public Queue<Field> getAllFields() {
        fields = super.getAllFields();
        fields.add(new Field(Device.class, getAPoint()));
        fields.add(new Field(Device.class, getBPoint()));
        return fields;
    }
}
