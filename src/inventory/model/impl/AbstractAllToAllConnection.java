package inventory.model.impl;

import com.netcracker.edu.inventory.model.connection.AllToAllConnection;
import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.device.Device;

import java.util.*;
import java.util.logging.Logger;

public abstract class AbstractAllToAllConnection<A extends Device> extends AbstractConnection<A, A>
        implements AllToAllConnection<A> {
    private static final Logger LOGGER = Logger.getLogger(AbstractDevice.class.getName());
    protected ConnectorType connectorType;
    protected int maxSize = 0;
    protected int curSize = 0;
    protected Set<A> connections = new HashSet<>();

    public AbstractAllToAllConnection(ConnectorType connectorType) {
        this.connectorType = connectorType;
    }

    public void setConnectorType(ConnectorType connectorType) {
        this.connectorType = connectorType;
    }

    public void setConnections(Set<A> connections) {
        this.connections = connections;
    }

    @Override
    public ConnectorType getConnectorType() {
        return this.connectorType;
    }

    @Override
    public boolean addDevice(A device) {
        return this.connections.add(device);
    }

    @Override
    public boolean removeDevice(A device) {
        return connections.remove(device);
    }

    @Override
    public boolean containDevice(A device) {
        return connections.contains(device);
    }

    @Override
    public Set<A> getAllDevices() {
        return new HashSet<A>((Collection<? extends A>) connections);
    }

    @Override
    public int getCurSize() {
        return curSize;
    }

    @Override
    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public void fillAllFields(Queue<Field> fields) {
        super.fillAllFields(fields);
        try {
            setMaxSize((Integer) fields.remove().getValue());
            setConnections((HashSet<A>) fields.remove().getValue());
            setConnectorType(ConnectorType.valueOf((String) fields.remove().getValue()));
        } catch (NoSuchElementException noSuchElementException) {
            LOGGER.severe("The queue is running out of elements." + noSuchElementException);
            throw noSuchElementException;
        }
    }

    public Queue<Field> getAllFields() {
        fields = super.getAllFields();
        fields.add(new Field(Integer.class, getMaxSize()));
        fields.add(new Field(HashSet.class, getAllDevices()));
        fields.add(new Field(String.class, getConnectorType().toString()));
        return fields;
    }
}