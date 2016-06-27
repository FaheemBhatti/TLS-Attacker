/**
 * TLS-Attacker - A Modular Penetration Testing Framework for TLS
 *
 * Copyright 2014-2016 Ruhr University Bochum / Hackmanit GmbH
 *
 * Licensed under Apache License 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package GlobalBranchTreeTests;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import tls.rub.evolutionaryfuzzer.ServerManager;
import tls.rub.evolutionaryfuzzer.TLSServer;


public class ServerManagerTest
{

    /**
     *
     */
    @BeforeClass
    public static void setUpClass()
    {
    }

    /**
     *
     */
    @AfterClass
    public static void tearDownClass()
    {
    }

    ServerManager manager = null;

    /**
     *
     */
    public ServerManagerTest()
    {
    }

    /**
     *
     */
    @Before
    public void setUp()
    {
        manager = ServerManager.getInstance();
        manager.addServer(new TLSServer("127.0.0.1", 1, "command1","ACCEPT","./"));
        manager.addServer(new TLSServer("127.0.0.2", 2, "command2","ACCEPT","./"));
        manager.addServer(new TLSServer("127.0.0.3", 3, "command3","ACCEPT","./"));
        manager.addServer(new TLSServer("127.0.0.4", 4, "command4","ACCEPT","./"));
        manager.addServer(new TLSServer("127.0.0.5", 5, "command5","ACCEPT","./"));

    }

    /**
     *
     */
    @After
    public void tearDown()
    {
        manager.clear();
    }

    /**
     *
     */
    @Test(expected = RuntimeException.class, timeout= 120000)
    public void TestOccupyAllServers()
    {
        while (true)
        {
            manager.getFreeServer();
        }
    }

    /**
     *
     */
    @Test
    public void TestGetServer()
    {

        TLSServer server = manager.getFreeServer();
        assertNotNull("Failure: Could not get a free Server",server);
    }

    /**
     *
     */
    @Test
    public void TestEmptyServer()
    {
        manager.clear();
        TLSServer server = manager.getFreeServer();
        assertNull("Failure: Manager returned a Server although he should not know any Servers",server);
    }

}
