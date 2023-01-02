package inventory.service.impl;

import com.netcracker.edu.inventory.model.NetworkElement;
import com.netcracker.edu.inventory.model.rack.Rack;
import com.netcracker.edu.inventory.service.ConcurrentService;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.concurrent.Future;

public class ConcurrentServiceImpl implements ConcurrentService {
    ConcurrentServiceIOImpl concurrentServiceIO = new ConcurrentServiceIOImpl();
    @Override
    public Future parallelOutputElements(Collection<NetworkElement> elements, OutputStream outputStream) {
        return null;
    }

    @Override
    public Future<Collection<NetworkElement>> parallelInputElements(int number, InputStream inputStream) {
        return null;
    }

    @Override
    public Future parallelOutputRacks(Collection<Rack> racks, OutputStream outputStream) {
        return null;
    }

    @Override
    public Future<Collection<Rack>> parallelInputRacks(int number, InputStream inputStream) {
        return null;
    }
}
