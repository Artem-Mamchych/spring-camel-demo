package com.alexshabanov.cameldemo.domain;

/**
 * Greeting demo domain object
 *
 * @author Alexander Shabanov
 */
public final class Greeting {
    private String message;
    private int count;

    public Greeting() {
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
