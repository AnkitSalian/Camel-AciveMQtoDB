package com.learncamel.routes.jms;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class JmsReadRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){
        return new JmsReadRoute();
    }

    @Test
    public void readMessageFromActiveMQ(){
        String expected ="123";
        String response = consumer.receiveBody("direct:readQueue",String.class);
        System.out.println("Response is ===>"+response);
        assertEquals(expected,response);
    }
}
