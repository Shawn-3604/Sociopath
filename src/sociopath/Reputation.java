/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sociopath;

/**
 *
 * @Aizat User
 */
public class Reputation {
    private Person p;
    private double rep;

    public Reputation(Person p, double rep) {
        this.p = p;
        this.rep = rep;
    }

    @Override
    public String toString() {
        return p.getName() + ",rep: " + rep ;
    }

    public Person getP() {
        return p;
    }

    public double getRep() {
        return rep;
    }

    public void setRep(double rep) {
        this.rep = rep;
    }
}
