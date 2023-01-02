package inventory.model.connection.entity.impl;

import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.impl.AbstractDevice;
import com.netcracker.edu.inventory.model.impl.AbstractOneToManyConnection;

import java.util.*;
import java.util.logging.Logger;

public class Wireless<A extends Device, B extends Device> extends AbstractOneToManyConnection<A, B>
        implements com.netcracker.edu.inventory.model.connection.entity.Wireless<A, B> {
    private static final Logger LOGGER = Logger.getLogger(AbstractDevice.class.getName());
    protected String technology = null;
    protected String protocol = null;
    protected int version = 0;

    public Wireless() {
        super(ConnectorType.Wireless, ConnectorType.Wireless);
    }

    public Wireless(int capacityB, String s) {
        this();
        this.capacityB = capacityB;
        this.technology = s;
    }

    public String getTechnology() {
        return technology;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    private void setTechnology(String technology) {
        this.technology = technology;
    }

    public void fillAllFields(Queue<Field> fields) {
        super.fillAllFields(fields);
        try {
            setProtocol((String) fields.remove().getValue());
            setVersion((Integer) fields.remove().getValue());
            setTechnology((String) fields.remove().getValue());
        } catch (NoSuchElementException noSuchElementException) {
            LOGGER.severe("The queue is running out of elements." + noSuchElementException);
            throw noSuchElementException;
        }
    }

    public Queue<Field> getAllFields() {
        fields = super.getAllFields();
        fields.add(new Field(String.class, getProtocol()));
        fields.add(new Field(Integer.class, getVersion()));
        fields.add(new Field(String.class, getTechnology()));
        return fields;
    }
}
