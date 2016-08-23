/**
 * TLS-Attacker - A Modular Penetration Testing Framework for TLS
 *
 * Copyright 2014-2016 Ruhr University Bochum / Hackmanit GmbH
 *
 * Licensed under Apache License 2.0 http://www.apache.org/licenses/LICENSE-2.0
 */
package Executor;

import Config.EvolutionaryFuzzerConfig;
import Executor.ExecutorThreadPool;
import Mutator.Certificate.FixedCertificateMutator;
import Mutator.SimpleMutator;
import de.rub.nds.tlsattacker.tls.workflow.TlsContext;
import de.rub.nds.tlsattacker.util.FileHelper;
import java.io.File;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 
 * @author Robert Merget - robert.merget@rub.de
 */
public class ExecutorThreadPoolTest {

    public ExecutorThreadPoolTest() {
    }

    @Test
    public void testConstructor() {
	EvolutionaryFuzzerConfig config = new EvolutionaryFuzzerConfig();
        config.setOutputFolder("unit_test_output/");
	config.setConfigFolder("unit_test_config/");
	ExecutorThreadPool pool = new ExecutorThreadPool(5, new SimpleMutator(config, new FixedCertificateMutator()),
		config);
	assertTrue("Failure: Pool is not stopped on creation", pool.isStopped());
    }
     public void tearDown() {
	FileHelper.deleteFolder(new File("unit_test_output"));
	FileHelper.deleteFolder(new File("unit_test_config"));
    }

}
