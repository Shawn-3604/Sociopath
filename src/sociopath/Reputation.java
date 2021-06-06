/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sociopath;

/**
 *
 * @author User
 */
public class Reputation {
    private Person p;
    private int rep;

    public Reputation(Person p, int rep) {
        this.p = p;
        this.rep = rep;
    }

    @Override
    public String toString() {
        return p.getName() + "rep= " + rep ;
    }

    public Person getP() {
        return p;
    }

    public int getRep() {
        return rep;
    }

    public void setRep(int rep) {
        this.rep = rep;
    }
}
