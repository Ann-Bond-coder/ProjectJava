package inventory.service.impl;

import com.netcracker.edu.inventory.model.NetworkElement;
import com.netcracker.edu.inventory.model.device.entity.impl.Battery;
import com.netcracker.edu.inventory.model.device.entity.impl.Router;
import com.netcracker.edu.inventory.model.device.entity.impl.Switch;
import com.netcracker.edu.inventory.model.device.entity.impl.WifiRouter;

import java.util.logging.Logger;

public class DeviceInstanceImpl {
    private static final Logger LOGGER = Logger.getLogger(DeviceInstanceImpl.class.getName());
    IllegalArgumentException illegalArgumentException = new IllegalArgumentException();

    public <T extends NetworkElement> T createDeviceInstance(Class<T> clazz) {
        if (com.netcracker.edu.inventory.model.device.entity.Battery.class.isAssignableFrom(clazz)) {
            return (T) new Battery();
        } else if (com.netcracker.edu.inventory.model.device.entity.Router.class.isAssignableFrom(clazz)) {
            if (com.netcracker.edu.inventory.model.device.entity.Switch.class.isAssignableFrom(clazz)) {
                return (T) new Switch();
            } else if (com.netcracker.edu.inventory.model.device.entity.WifiRouter.class.isAssignableFrom(clazz)) {
                return (T) new WifiRouter();
            }
            return (T) new Router();
        } else {
            LOGGER.severe("The class can't be null. " + illegalArgumentException);
            throw illegalArgumentException;
        }
    }
}
