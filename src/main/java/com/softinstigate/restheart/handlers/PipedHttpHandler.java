/*
 * Copyright SoftInstigate srl. All Rights Reserved.
 *
 *
 * The copyright to the computer program(s) herein is the property of
 * SoftInstigate srl, Italy. The program(s) may be used and/or copied only
 * with the written permission of SoftInstigate srl or in accordance with the
 * terms and conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied. This copyright notice must not be removed.
 */
package com.softinstigate.restheart.handlers;

import com.softinstigate.restheart.utils.RequestContext;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;

/**
 *
 * @author uji
 */
public abstract class PipedHttpHandler implements HttpHandler
{
    protected final PipedHttpHandler next;

    public PipedHttpHandler(PipedHttpHandler next)
    {
        this.next = next;
    }

    public abstract void handleRequest(HttpServerExchange exchange, RequestContext context) throws Exception;
    
    @Override
    public void handleRequest(HttpServerExchange exchange) throws Exception
    {
        handleRequest(exchange, null);
    }
}