package inventory.service.impl;

import com.netcracker.edu.inventory.model.NetworkElement;
import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.entity.OpticFiber;
import com.netcracker.edu.inventory.model.connection.entity.ThinCoaxial;
import com.netcracker.edu.inventory.model.connection.entity.TwistedPair;
import com.netcracker.edu.inventory.model.connection.entity.Wireless;
import com.netcracker.edu.inventory.model.connection.entity.wrapper.*;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.device.entity.Battery;
import com.netcracker.edu.inventory.model.device.entity.Router;
import com.netcracker.edu.inventory.model.device.entity.Switch;
import com.netcracker.edu.inventory.model.device.entity.WifiRouter;
import com.netcracker.edu.inventory.model.device.entity.wrapper.*;
import com.netcracker.edu.inventory.model.rack.Rack;
import com.netcracker.edu.inventory.model.rack.impl.RackArrayImpl;
import com.netcracker.edu.inventory.model.rack.wrapper.ImmutableRackWrapper;
import com.netcracker.edu.inventory.model.rack.wrapper.PublishRackWrapper;
import com.netcracker.edu.inventory.model.rack.wrapper.SynchronizedRackWrapper;
import com.netcracker.edu.inventory.service.EntityFactory;

import java.beans.PropertyChangeListener;
import java.util.logging.Logger;

public class EntityFactoryImpl implements EntityFactory {
    private static final Logger LOGGER = Logger.getLogger(EntityFactoryImpl.class.getName());
    NetworkElementInstanceImpl networkElementInstance = new NetworkElementInstanceImpl();
    IllegalArgumentException illegalArgumentException = new IllegalArgumentException();

    @Override
    public NetworkElement createEmptyNetworkElementImpl(String className) throws IllegalArgumentException {
        if (className == null) {
            throwException("EntityFactoryImpl.createEmptyNetworkElementImpl", "The name can`t be null.");
        }
        Class clas;
        try {
            clas = Class.forName(className);
        } catch (ClassNotFoundException classNotFoundException) {
            LOGGER.severe(illegalArgumentException + "EntityFactoryImpl.createEmptyNetworkElementImpl. " +
                    "\nThe name is not valid. ");
            throw illegalArgumentException;
        }
        return createEmptyNetworkElementImpl(clas);
    }

    @Override
    public <T extends NetworkElement> T createEmptyNetworkElementImpl(Class<T> clazz) throws IllegalArgumentException {
        if (clazz == null) {
            throwException("EntityFactoryImpl.createEmptyNetworkElementImpl", "The name can`t be null.");
        }
        return networkElementInstance.createNEInstance(clazz);
    }

    @Override
    public <T extends Device> Rack<T> createEmptyRackImpl(String name, int size, Class<T> limitation) throws IllegalArgumentException {
        if (name == null) {
            LOGGER.severe(illegalArgumentException + "EntityFactoryImpl.createEmptyRackImpl. " +
                    "\nThe name can`t be null. ");
            throw illegalArgumentException;
        }
        if (name.equals("RackArrayImpl")) {
            return new RackArrayImpl<>(size, limitation);
        }
        LOGGER.severe(illegalArgumentException + "EntityFactoryImpl.createEmptyRackImpl. " +
                "\nThe name is not valid. ");
        throw illegalArgumentException;
    }

    @Override
    public <T extends NetworkElement> T getImmutableNetworkElement(T original) throws IllegalArgumentException {
        if (original == null) {
            LOGGER.severe(illegalArgumentException + "EntityFactoryImpl.getImmutableNetworkElement. " +
                    "\nThe name can`t be null. ");
            throw illegalArgumentException;
        }
        if (original instanceof Device) {
            ImmutableDeviceWrapper immutableDeviceWrapper = new ImmutableDeviceWrapper(original);
            if (original instanceof Router) {
                if (original instanceof Switch) {
                    return (T) new SwitchWrapper(immutableDeviceWrapper);
                }
                if (original instanceof WifiRouter) {
                    return (T) new WifiRouterWrapper(immutableDeviceWrapper);
                }
                return (T) new RouterWrapper(immutableDeviceWrapper);
            }
            if (original instanceof Battery) {
                return (T) new BatteryWrapper(immutableDeviceWrapper);
            }
        }
        if (original instanceof Connection) {
            ImmutableConnectionWrapper immutableConnectionWrapper = new ImmutableConnectionWrapper<>(original);
            if (original instanceof OpticFiber) {
                return (T) new OpticFiberWrapper(immutableConnectionWrapper);
            }
            if (original instanceof ThinCoaxial) {
                return (T) new ThinCoaxialWrapper(immutableConnectionWrapper);
            }
            if (original instanceof TwistedPair) {
                return (T) new TwistedPairWrapper(immutableConnectionWrapper);
            }
            if (original instanceof Wireless) {
                return (T) new WirelessWrapper(immutableConnectionWrapper);
            }
        }
        throwException("EntityFactoryImpl.getImmutableNetworkElement", "The name is not valid.");
        return null;
    }


    @Override
    public <D extends Device> Rack<D> getImmutableRack(Rack<D> original) throws IllegalArgumentException {
        if (original == null) {
            LOGGER.severe(illegalArgumentException + "EntityFactoryImpl.getImmutableRack. " +
                    "\nThe name can`t be null. ");
            throw illegalArgumentException;
        } else {
            ImmutableRackWrapper immutableRackWrapper = new ImmutableRackWrapper(original);
            return immutableRackWrapper;
        }
    }

    @Override
    public <T extends NetworkElement> T getSynchronizedNetworkElement(T original) throws IllegalArgumentException {
        if (original == null) {
            LOGGER.severe(illegalArgumentException + "EntityFactoryImpl.getSynchronizedNetworkElement. " +
                    "\nThe name can`t be null. ");
            throw illegalArgumentException;
        }
        if (original instanceof Device) {
            SynchronizedDeviceWrapper synchronizedDeviceWrapper = new SynchronizedDeviceWrapper((Device) original);
            if (original instanceof Router) {
                if (original instanceof Switch) {
                    return (T) new SwitchWrapper(synchronizedDeviceWrapper);
                }
                if (original instanceof WifiRouter) {
                    return (T) new WifiRouterWrapper(synchronizedDeviceWrapper);
                }
                return (T) new RouterWrapper(synchronizedDeviceWrapper);
            }
            if (original instanceof Battery) {
                return (T) new BatteryWrapper(synchronizedDeviceWrapper);
            }
        }
        if (original instanceof Connection) {
            SynchronizedConnectionWrapper synchronizedConnectionWrapper = new SynchronizedConnectionWrapper<>(original);
            if (original instanceof OpticFiber) {
                return (T) new OpticFiberWrapper(synchronizedConnectionWrapper);
            }
            if (original instanceof ThinCoaxial) {
                return (T) new ThinCoaxialWrapper(synchronizedConnectionWrapper);
            }
            if (original instanceof TwistedPair) {
                return (T) new TwistedPairWrapper(synchronizedConnectionWrapper);
            }
            if (original instanceof Wireless) {
                return (T) new WirelessWrapper(synchronizedConnectionWrapper);
            }
        }
        throwException("EntityFactoryImpl.getSynchronizedNetworkElement", "The name is not valid.");
        return null;
    }

    @Override
    public <D extends Device> Rack<D> getSynchronizedRack(Rack<D> original) throws IllegalArgumentException {
        if (original == null) {
            LOGGER.severe(illegalArgumentException + "EntityFactoryImpl.getSynchronizedRack. " +
                    "\nThe name can`t be null. ");
            throw illegalArgumentException;
        } else {
            SynchronizedRackWrapper synchronizedRackWrapper = new SynchronizedRackWrapper(original);
            return synchronizedRackWrapper;
        }
    }

    @Override
    public <T extends NetworkElement> T subscribeTo(T original, PropertyChangeListener listener) throws
            IllegalArgumentException {
        if ((original == null) || (listener == null)) {
            throwException("EntityFactoryImpl.subscribeToNetworkElement", "The element or listener can`t be null.");
        }
        if (original instanceof SimpleDeviceWrapper) {
            SimpleDeviceWrapper wrapper = (SimpleDeviceWrapper) original;
            if (wrapper.getWrapper() instanceof PublishDeviceWrapper) {
                PublishDeviceWrapper publishDeviceWrapper = (PublishDeviceWrapper) wrapper.getWrapper();
                publishDeviceWrapper.addListener(listener);
                return original;
            }
        }
        if (original instanceof Device) {
            AbstractDevicesWrapper publishDeviceWrapper = new PublishDeviceWrapper<>((Device) original, listener);
            if (original instanceof Battery) {
                return (T) new BatteryWrapper(publishDeviceWrapper);
            }
            if (original instanceof Router) {
                if (original instanceof Switch) {
                    return (T) new SwitchWrapper(publishDeviceWrapper);
                }
                if (original instanceof WifiRouter) {
                    return (T) new WifiRouterWrapper(publishDeviceWrapper);
                }
                return (T) new RouterWrapper(publishDeviceWrapper);
            }
            return null;
        }
        if (original instanceof SimpleConnectionWrapper) {
            SimpleConnectionWrapper wrapper = (SimpleConnectionWrapper) original;
            if (wrapper.getWrapper() instanceof PublishConnectionWrapper) {
                PublishConnectionWrapper publishConnectionWrapper = (PublishConnectionWrapper) wrapper.getWrapper();
                publishConnectionWrapper.addListener(listener);
                return original;
            }
        }
        if (original instanceof Connection) {
            AbstractConnectionWrapper publishConnectionWrapper =
                    new PublishConnectionWrapper((Connection) original, listener);
            if (original instanceof OpticFiber) {
                return (T) new OpticFiberWrapper(publishConnectionWrapper);
            }
            if (original instanceof ThinCoaxial) {
                return (T) new ThinCoaxialWrapper(publishConnectionWrapper);
            }
            if (original instanceof TwistedPair) {
                return (T) new TwistedPairWrapper(publishConnectionWrapper);
            }
            if (original instanceof Wireless) {
                return (T) new WirelessWrapper(publishConnectionWrapper);
            }
            return null;
        }
        throwException("EntityFactoryImpl.subscribeToNetworkElement", "The name is not valid.");
        return null;
    }

    @Override
    public <D extends Device> Rack<D> subscribeTo(Rack<D> original, PropertyChangeListener listener) throws
            IllegalArgumentException {
        if ((original == null) || (listener == null)) {
            throwException("EntityFactoryImpl.subscribeToRack", "The rack or listener can`t be null.");
        }
        if (original instanceof PublishRackWrapper) {
            ((PublishRackWrapper) original).addListener(listener);
            return original;
        }
        PublishRackWrapper publishRackWrapper = new PublishRackWrapper<>(original);
        publishRackWrapper.addListener(listener);
        return publishRackWrapper;
    }

    @Override
    public boolean unsubscribeFrom(NetworkElement publisher, PropertyChangeListener listener) throws
            IllegalArgumentException {
        if ((publisher == null) || (listener == null)) {
            throwException("EntityFactoryImpl.unsubscribeFromNetworkElement", "The element or listener can`t be null.");
        }
        if (publisher instanceof SimpleDeviceWrapper) {
            SimpleDeviceWrapper wrapper = (SimpleDeviceWrapper) publisher;
            if (wrapper.getWrapper() instanceof PublishDeviceWrapper) {
                PublishDeviceWrapper publishDeviceWrapper = (PublishDeviceWrapper) wrapper.getWrapper();
                publishDeviceWrapper.removeListener(listener);
                return true;
            }
        }
        if (publisher instanceof Device) {
            if (publisher instanceof PublishDeviceWrapper) {
                ((PublishDeviceWrapper) publisher).removeListener(listener);
                return true;
            }
            return false;
        }
        if (publisher instanceof SimpleConnectionWrapper) {
            SimpleConnectionWrapper wrapper = (SimpleConnectionWrapper) publisher;
            if (wrapper.getWrapper() instanceof PublishConnectionWrapper) {
                PublishConnectionWrapper publishConnectionWrapper = (PublishConnectionWrapper) wrapper.getWrapper();
                publishConnectionWrapper.removeListener(listener);
                return true;
            }
        }
        if (publisher instanceof Connection) {
            if (publisher instanceof PublishConnectionWrapper) {
                ((PublishConnectionWrapper) publisher).removeListener(listener);
                return true;
            }
            return false;
        }
        throwException("EntityFactoryImpl.subscribeToNetworkElement", "The name is not valid.");
        return false;
    }

    @Override
    public boolean unsubscribeFrom(Rack publisher, PropertyChangeListener listener) throws IllegalArgumentException {
        if ((publisher == null) || (listener == null)) {
            throwException("EntityFactoryImpl.unsubscribeFromRack", "The rack or listener can`t be null.");
        }
        if (publisher instanceof PublishRackWrapper) {
            ((PublishRackWrapper) publisher).removeListener(listener);
            return true;
        }
        return false;
    }

    public void throwException(String methodOfClass, String message) {
        LOGGER.severe(illegalArgumentException + methodOfClass + message);
        throw illegalArgumentException;
    }
}
