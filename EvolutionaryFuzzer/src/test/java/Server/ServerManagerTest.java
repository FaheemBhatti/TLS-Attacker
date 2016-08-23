package Server;

import Config.EvolutionaryFuzzerConfig;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import Server.ServerManager;
import Server.TLSServer;
import static org.junit.Assert.assertNull;

/**
 * 
 * @author ic0ns
 */
public class ServerManagerTest {
    private static final Logger LOG = Logger.getLogger(ServerManagerTest.class.getName());

    ServerManager manager = null;

    /**
     *
     */
    public ServerManagerTest() {
    }

    /**
     *
     */
    @Before
    public void setUp() {
        Config.ConfigManager.getInstance().setConfig(new EvolutionaryFuzzerConfig());
	manager = ServerManager.getInstance();
	manager.addServer(new TLSServer("127.0.0.1", 1, "command1", "ACCEPT"));
	manager.addServer(new TLSServer("127.0.0.2", 2, "command2", "ACCEPT"));
	manager.addServer(new TLSServer("127.0.0.3", 3, "command3", "ACCEPT"));
	manager.addServer(new TLSServer("127.0.0.4", 4, "command4", "ACCEPT"));
	manager.addServer(new TLSServer("127.0.0.5", 5, "command5", "ACCEPT"));

    }

    /**
     *
     */
    @After
    public void tearDown() {
	Config.ConfigManager.getInstance().setConfig(new EvolutionaryFuzzerConfig());
	manager.clear();
    }

    @Test(expected = RuntimeException.class)
    public void TestOccupyAllServers() {
	Config.ConfigManager.getInstance().getConfig().setTimeout(10);
	while (true) {
	    manager.getFreeServer();
	}
    }

    /**
     *
     */
    @Test
    public void TestGetServer() {

	TLSServer server = manager.getFreeServer();
	assertNotNull("Failure: Could not get a free Server", server);
    }

    public void TestEmptyServer() {
	Config.ConfigManager.getInstance().getConfig().setTimeout(10);
	manager.clear();
	TLSServer server = manager.getFreeServer();
	assertNull("Failure: Manager returned a Server although he should not know any Servers", server);
    }
}
