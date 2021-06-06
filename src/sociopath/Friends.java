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
public class Friends {
    private Person p;
    private int num;
    
    public Friends(Person p,int num){
        this.p=p;
        this.num=num;
    }
    
    public Person getP(){
        return p;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return p.getName() + "num= " + num ;
    }
}
