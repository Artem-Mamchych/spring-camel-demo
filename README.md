spring-camel-demo
=================

## What is it?

This demo project illustrates how to use ActiveMQ in multiple-modular project with shared code.
One demo project is ``greeter-web-app`` or just greeter, application, that sends greeting message to 
the listener or ``listener-web-app``.

## How to demo

Download and unpack ActiveMQ 5.9 to any dir.


Ensure activemq started.


Proceed to the ``${activemq}/bin`` folder and run ``./activemq start`` on linux or ``activemq.bat`` on windows.


Build the sources in the source folder of spring-camel-demo project:

```
mvn clean install
```

Then ``cd greeter-web-app`` and launch jetty server there:

```
mvn jetty:run -Pjetty-local -Djetty.port=9091
```

Then ``cd listener-web-app`` and launch jetty server there:

```
mvn jetty:run -Pjetty-local -Djetty.port=9092
```

Verify that jetty successfully started by navigating to ``http://127.0.0.1:9091`` and ``http://127.0.0.1:9092``

Open greeting web app's index.html, type some greeting data and push 'Send'.
You shall see 'Message Sent!' message if all is OK.

Open listener web app's index.html and refresh it.
You shall see the new message received on top of the greetings list.

Activemq admin page located at ``http://localhost:8161/admin/index.jsp``

## What is the most interesting about the code?

Messaging-related:

* Illustration on how to send custom java bean over the JMS by using binary serialization to the StreamMessage.

* Spring JMS module usage. See ``GreeterServiceImpl``

* Apache Camel usage. Consuming messages from the ActiveMQ queue and putting them to the custom bean. 
See ``ListenerRouteBuilder``

Spring-related:
* Loading properties.
* Using mixed configuration: both annotation-driven and xml-driven configs are used in listener-web-app.
* Spring MVC web applications.

## What can be improved?

*Left as an excercise to the reader ;)*

* Listener route can be defined in XML only, i.e. ListenerRouteBuilder can be removed at the price of 
having more XML configuration.

* listener-web-app can use property in the similar fashion as greeter-web-app does.

* greeter-web-app can get rid of jms-context.xml and define the configuration in the annotation-based config to avoid mixing
annotation-driven and xml-driven configurations.
