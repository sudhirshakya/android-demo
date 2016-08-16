package io.sorus.temples;

/**
 * Created by sudhir on 8/14/16.
 */
public class Temple {

    protected String name;

    protected String address;

    protected String summary;

    public Temple() {
    }

    public Temple(String name, String address, String summary) {
        this.name = name;
        this.address = address;
        this.summary = summary;
    }
}
