package com.alexshabanov.cameldemo.domain;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Greeting demo domain object
 *
 * @author Alexander Shabanov
 */
//@XmlRootElement
//@XmlType
public final class Greeting {
    private String message;
    private int count;

    public Greeting() {
    }
    public Greeting(String message) {
        this();
        setMessage(message);
        setCount(0);
    }

    public Greeting(String message, int count) {
        this();
        setMessage(message);
        setCount(count);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "message='" + getMessage() + '\'' +
                ", count=" + getCount() +
                '}';
    }
}
