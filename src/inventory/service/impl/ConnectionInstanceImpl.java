package inventory.service.impl;

import com.netcracker.edu.inventory.model.NetworkElement;
import com.netcracker.edu.inventory.model.connection.entity.impl.OpticFiber;
import com.netcracker.edu.inventory.model.connection.entity.impl.ThinCoaxial;
import com.netcracker.edu.inventory.model.connection.entity.impl.TwistedPair;
import com.netcracker.edu.inventory.model.connection.entity.impl.Wireless;

import java.util.logging.Logger;

public class ConnectionInstanceImpl {
    private static final Logger LOGGER = Logger.getLogger(ConnectionInstanceImpl.class.getName());
    IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
    public <T extends NetworkElement> T createInstance(Class<T> clazz) {
        if (com.netcracker.edu.inventory.model.connection.entity.OpticFiber.class.isAssignableFrom(clazz)) {
            return (T) new OpticFiber<>();
        } else if (com.netcracker.edu.inventory.model.connection.entity.TwistedPair.class.isAssignableFrom(clazz)) {
            return (T) new TwistedPair<>();
        } else if (com.netcracker.edu.inventory.model.connection.entity.ThinCoaxial.class.isAssignableFrom(clazz)) {
            return (T) new ThinCoaxial<>();
        } else if (com.netcracker.edu.inventory.model.connection.entity.Wireless.class.isAssignableFrom(clazz)) {
            return (T) new Wireless<>();
        } else {
            LOGGER.severe("The class can't be null. " + illegalArgumentException);
            throw illegalArgumentException;
        }
    }
}
