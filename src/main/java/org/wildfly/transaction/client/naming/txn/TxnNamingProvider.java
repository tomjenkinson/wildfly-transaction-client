/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2015 Red Hat, Inc., and individual contributors
 * as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wildfly.transaction.client.naming.txn;

import java.net.URI;
import java.util.concurrent.ConcurrentMap;

import javax.naming.Context;

import org.wildfly.naming.client.NamingProviderFactory;
import org.wildfly.naming.client.util.FastHashtable;

/**
 * @author <a href="mailto:david.lloyd@redhat.com">David M. Lloyd</a>
 */
class TxnNamingProvider implements NamingProviderFactory {
    public boolean supportsUriScheme(final String providerScheme, final String nameScheme) {
        return nameScheme != null && nameScheme.equals("txn");
    }

    public Context createRootContext(final String nameScheme, final URI providerUri, final FastHashtable<String, Object> env, final ConcurrentMap<String, Object> sharedEnv) {
        return new TxnNamingContext(providerUri);
    }
}
