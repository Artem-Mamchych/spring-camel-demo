spring-camel-demo
=================

## What is it?

This demo project illustrates how to use ActiveMQ in multiple project with shared code.
One demo project is ``greeter-web-app`` or just greeter, application, that sends greeting message to the listener or ``listener-web-app``.

## How to demo

Ensure activemq started. Proceed to the ``${activemq}/bin`` folder and run ``./activemq start``.


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


