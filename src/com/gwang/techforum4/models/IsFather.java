package com.gwang.techforum4.models;

/**
 * Created with IntelliJ IDEA.
 * User: gwang2
 * Date: 11/1/13
 * Time: 9:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class IsFather {
    private Person f;
    private Person s;

    public IsFather(Person father, Person son) {
        this.f = father;
        this.s = son;
    }

    public Person getF() {
        return f;
    }

    public void setF(Person f) {
        this.f = f;
    }

    public Person getS() {
        return s;
    }

    public void setS(Person s) {
        this.s = s;
    }
}
