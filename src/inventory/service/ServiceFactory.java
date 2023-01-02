package inventory.service;

/**
 * Created by makovetskyi on 24.05.17.
 */
public interface ServiceFactory {

    /**
     * Create DeviceService implementation
     *
     * @return implementation of DeviceService interface
     */
    DeviceService createDeviceServiceImpl();

    /**
     * Create ConnectionService implementation
     *
     * @return implementation of ConnectionService interface
     */
    ConnectionService createConnectionServiceImpl();

    /**
     * Create RackService implementation
     *
     * @return implementation of RackService interface
     */
    RackService createRackServiceImpl();

    ConcurrentService createConcurrentServiceImpl();
}
