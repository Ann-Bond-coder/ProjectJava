package inventory.service.impl;

import com.netcracker.edu.inventory.model.FillableEntity;
import com.netcracker.edu.inventory.model.NetworkElement;
import com.netcracker.edu.inventory.model.rack.Rack;
import com.netcracker.edu.io.IOService;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConcurrentServiceIOImpl {
    IOService ioService;

    public Future parallelOutputElements(Collection<NetworkElement> elements, OutputStream outputStream){
        ExecutorService service = Executors.newCachedThreadPool();
        Future result = service.submit(() -> {
                  .....
                }
        );
        try {
            Task: ioService.outputFillableEntity((FillableEntity) elements, outputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public Future<Collection<NetworkElement>> parallelInputElements(int number, InputStream inputStream) {
        return null;
    }

    public Future parallelOutputRacks(Collection<Rack> racks, OutputStream outputStream) {
        return null;
    }

    public Future<Collection<Rack>> parallelInputRacks(int number, InputStream inputStream) {
        return null;
    }
}
