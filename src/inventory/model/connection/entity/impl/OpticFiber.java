package inventory.model.connection.entity.impl;

import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.impl.AbstractDevice;
import com.netcracker.edu.inventory.model.impl.AbstractOneToOneConnection;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.logging.Logger;

public class OpticFiber<A extends Device, B extends Device> extends AbstractOneToOneConnection<A, B>
        implements com.netcracker.edu.inventory.model.connection.entity.OpticFiber<A, B> {
    private static final Logger LOGGER = Logger.getLogger(AbstractDevice.class.getName());
    protected Queue<Field> fields;
    protected int length = 0;
    protected Mode mode = Mode.need_init;

    public OpticFiber() {
        super(ConnectorType.FiberConnector_FC, ConnectorType.FiberConnector_FC);
    }

    public OpticFiber(Mode mode, int length) {
        this();
        this.mode = mode;
        setLength(length);
    }

    public int getLength() {
        return length;
    }

    public void setLength(int lenght) {
        this.length = lenght;
    }

    public Mode getMode() {
        return mode;
    }

    private void setMode(Mode mode) {
        this.mode = mode;
    }

    public void fillAllFields(Queue<Field> fields) {
        super.fillAllFields(fields);
        try {
            setLength((Integer) fields.remove().getValue());
            setMode((Mode.valueOf((String) fields.remove().getValue())));
        } catch (NoSuchElementException noSuchElementException) {
            LOGGER.severe("The queue is running out of elements." + noSuchElementException);
            throw noSuchElementException;
        }
    }

    public Queue<Field> getAllFields() {
        fields = super.getAllFields();
        fields.add(new Field(Integer.class, getLength()));
        fields.add(new Field(String.class, getMode().name()));
        return fields;
    }
}
