package com.gwang.techforum4.models;

/**
 * Created with IntelliJ IDEA.
 * User: gwang2
 * Date: 11/1/13
 * Time: 9:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class IsGrandpa {
    private Person gf;
    private Person gs;

    public IsGrandpa(Person gf, Person gs) {
        this.gf = gf;
        this.gs = gs;
    }

    public Person getGf() {
        return gf;
    }

    public void setGf(Person gf) {
        this.gf = gf;
    }

    public Person getGs() {
        return gs;
    }

    public void setGs(Person gs) {
        this.gs = gs;
    }
}
