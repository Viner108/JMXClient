package org.example.client;

import javax.management.*;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException, MalformedObjectNameException, InstanceNotFoundException {
        String host = "192.168.1.105";
        int port = 9999;
        String path = "/jndi/rmi://" + host + ":" + port + "/jmxrmi";
        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi://" + path);
        JMXConnector jmxc = JMXConnectorFactory.connect(url, null);
        MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();


        ObjectName objectName = new ObjectName("org.example.client:type=Hello");
        HelloMBean mbeanProxy = JMX.newMXBeanProxy(mbsc, objectName, HelloMBean.class, true);

//        jmxc.addConnectionNotificationListener(objectName, new ClientListener(), null, null);
//
//        System.out.println(mbeanProxy.addIntegers(1, 2));
//        mbeanProxy.sayHello();
//        mbeanProxy.setName("Hello");
//        System.out.println(mbeanProxy.getName());
//        System.out.println(mbeanProxy.returnPerson().getName());

        jmxc.close();
    }
}