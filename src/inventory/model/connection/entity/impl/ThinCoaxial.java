package inventory.model.connection.entity.impl;

import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.impl.AbstractAllToAllConnection;

import java.util.Queue;

public class ThinCoaxial<A extends Device> extends AbstractAllToAllConnection<A>
        implements com.netcracker.edu.inventory.model.connection.entity.ThinCoaxial<A> {
    public ThinCoaxial() {
        super(ConnectorType.TConnector);
    }

    public ThinCoaxial(int maxSize) {
        this();
        setMaxSize(maxSize);
    }

    public void fillAllFields(Queue<Field> fields) {
        super.fillAllFields(fields);
    }

    public Queue<Field> getAllFields() {
        fields = super.getAllFields();
        return fields;
    }
}
