package com.netcracker.edu.inventory.service.impl;

import com.netcracker.edu.inventory.AssertUtilities;
import com.netcracker.edu.inventory.CreateUtilities;
import com.netcracker.edu.inventory.LoggerInitializer;
import com.netcracker.edu.inventory.exception.ConnectionValidationException;
import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.entity.OpticFiber;
import com.netcracker.edu.inventory.model.connection.entity.ThinCoaxial;
import com.netcracker.edu.inventory.model.connection.entity.TwistedPair;
import com.netcracker.edu.inventory.model.connection.entity.Wireless;
import com.netcracker.edu.inventory.service.ConnectionService;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import static org.junit.Assert.*;

/**
 * Created by makovetskyi on 13.11.16.
 */
public class ConnectionServiceImplTest {

    private static final int PIPED_BUFER_SIZE = 1024*4;
    private static final String FILE_NAME = "testOutConnection.bin";

    ConnectionService connectionService;

    @BeforeClass
    public static void initEnvironment() {
        LoggerInitializer.initLogger();
    }

    @Before
    public void setUp() throws Exception {
        connectionService = new ConnectionServiceImpl();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void isValidConnectionForOutputToStream() throws Exception {
        Wireless wireless = CreateUtilities.createWireless();

        boolean result = connectionService.isValidConnectionForOutputToStream(wireless);

        assertTrue(result);
    }

    @Test
    public void isValidConnectionForOutputToStream_ConnectionNull() throws Exception {
        boolean result = connectionService.isValidConnectionForOutputToStream(null);

        assertFalse(result);
    }

    @Test
    public void isValidConnectionForOutputToStream_ConnectionAttributeInvalid() throws Exception {
        Wireless wireless = CreateUtilities.createWireless();
        wireless.setStatus("Active\n");
        wireless.setProtocol("none");

        boolean result = connectionService.isValidConnectionForOutputToStream(wireless);

        assertFalse(result);
    }

    @Test
    public void isValidConnectionForOutputToStream_ChildAttributeInvalid() throws Exception {
        Wireless wireless = CreateUtilities.createWireless();
        wireless.setStatus("Active");
        wireless.setProtocol("no\nne");

        boolean result = connectionService.isValidConnectionForOutputToStream(wireless);

        assertFalse(result);
    }

    @Test
    public void outputInputConnection() throws Exception {
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream, PIPED_BUFER_SIZE);
        TwistedPair twistedPair = CreateUtilities.createTwistedPair();
        OpticFiber opticFiber = CreateUtilities.createOpticFiber();
        Wireless wireless = CreateUtilities.createWireless();
        ThinCoaxial thinCoaxial = CreateUtilities.createThinCoaxial();

        connectionService.outputConnection(twistedPair, pipedOutputStream);
        connectionService.outputConnection(opticFiber, pipedOutputStream);
        connectionService.outputConnection(wireless, pipedOutputStream);
        connectionService.outputConnection(thinCoaxial, pipedOutputStream);
        pipedOutputStream.close();

        Connection result1 = connectionService.inputConnection(pipedInputStream);
        Connection result2 = connectionService.inputConnection(pipedInputStream);
        Connection result3 = connectionService.inputConnection(pipedInputStream);
        Connection result4 = connectionService.inputConnection(pipedInputStream);
        pipedInputStream.close();

        assertEquals(com.netcracker.edu.inventory.model.connection.entity.impl.TwistedPair.class, result1.getClass());
        AssertUtilities.assertTwistedPair(twistedPair, (TwistedPair) result1);
        assertEquals(com.netcracker.edu.inventory.model.connection.entity.impl.OpticFiber.class, result2.getClass());
        AssertUtilities.assertOpticFiber(opticFiber, (OpticFiber) result2);
        assertEquals(com.netcracker.edu.inventory.model.connection.entity.impl.Wireless.class, result3.getClass());
        AssertUtilities.assertWireless(wireless, (Wireless) result3);
        assertEquals(com.netcracker.edu.inventory.model.connection.entity.impl.ThinCoaxial.class, result4.getClass());
        AssertUtilities.assertThinCoaxial(thinCoaxial, (ThinCoaxial) result4);
    }

    @Test(expected = ConnectionValidationException.class)
    public void outputConnectionNull() throws Exception {
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        new PipedInputStream(pipedOutputStream);

        connectionService.outputConnection(null, pipedOutputStream);
    }

    @Test(expected = IllegalArgumentException.class)
    public void outputConnectionStreamNull() throws Exception {
        connectionService.outputConnection(CreateUtilities.createTwistedPair(), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void inputConnectionStreamNull() throws Exception {
        connectionService.inputConnection(null);
    }

    @Test
    public void outputToFile() throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
        TwistedPair twistedPair = CreateUtilities.createTwistedPair();
        OpticFiber opticFiber = CreateUtilities.createOpticFiber();
        Wireless wireless = CreateUtilities.createWireless();
        ThinCoaxial thinCoaxial = CreateUtilities.createThinCoaxial();

        connectionService.outputConnection(twistedPair, fileOutputStream);
        connectionService.outputConnection(opticFiber, fileOutputStream);
        connectionService.outputConnection(wireless, fileOutputStream);
        connectionService.outputConnection(thinCoaxial, fileOutputStream);
        fileOutputStream.close();
    }

}