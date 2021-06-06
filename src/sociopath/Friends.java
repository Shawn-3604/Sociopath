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
public class Friends {
    private Person p;
    
    public Friends(Person p){
        this.p=p;
    }
    
    public Person getP(){
        return p;
    }
    
    @Override
    public String toString() {
        return p.getName();
    }
}
