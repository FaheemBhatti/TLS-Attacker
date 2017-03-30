/**
 * TLS-Attacker - A Modular Penetration Testing Framework for TLS
 *
 * Copyright 2014-2016 Ruhr University Bochum / Hackmanit GmbH
 *
 * Licensed under Apache License 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package de.rub.nds.tlsattacker.tls.record.parser;

import de.rub.nds.tlsattacker.tls.protocol.parser.Parser;
import de.rub.nds.tlsattacker.tls.record.Record;

/**
 *
 * @author Robert Merget <robert.merget@rub.de>
 */
public class RecordParser extends Parser<Record>{

    public RecordParser(int startposition, byte[] array) {
        super(startposition, array);
    }

    @Override
    public Record parse() {
        
    }
    
}
