package inventory.model.connection.entity.wrapper;

import com.netcracker.edu.inventory.model.connection.entity.TwistedPair;
import com.netcracker.edu.inventory.model.device.Device;

public class TwistedPairWrapper<D extends Device> extends OneToOneConnectionWrapper<D>
        implements TwistedPair<D, D> {
    public TwistedPairWrapper(AbstractConnectionWrapper<D> abstractConnectionWrapper) {
        super(abstractConnectionWrapper);
    }

    @Override
    public Type getType() {
        return abstractConnectionWrapper.getType();
    }

    @Override
    public int getLength() {
        return abstractConnectionWrapper.getLength();
    }

    @Override
    public void setLength(int length) {
        abstractConnectionWrapper.setLength(length);
    }
}
