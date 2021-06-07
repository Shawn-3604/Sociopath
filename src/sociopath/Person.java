/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sociopath;

import java.util.LinkedList;
import java.util.Random;
/**
 *
 * @Aizat User
 */
public class Person {
    Random r=new Random();
    
    private String name;
    private double dive;
    private int[] lunchStart;
    private int[] lunchPeriod;
    LinkedList<Friends> friends=new LinkedList<>();
    LinkedList<Reputation> rep=new LinkedList<>();

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, double dive, int[] lunchStart, int[] lunchPeriod) {
        this.name = name;
        this.dive = dive;
        this.lunchStart = lunchStart;
        this.lunchPeriod = lunchPeriod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDive() {
        return dive;
    }

    public void setDive(double dive) {
        this.dive = dive;
    }
    
    public void addFriends(Person p){
        Friends f=new Friends(p);
        friends.add(f);
    }
    
    public void addRep(Person p,double r){
        Reputation newr=new Reputation(p,r);
        rep.add(newr);
    }
    
    public boolean contain(Person p){
        if(!friends.isEmpty()){
            for(int i=0;i<friends.size();i++){
                if(friends.get(i).getP().equals(p))
                    return true;
            }
        }
        return false;
    }

    public double getRep(Person p) {
        for(int i=0;i<rep.size();i++){
            if(rep.get(i).getP().equals(p)){
                return rep.get(i).getRep();
            }
        }
        return 0;
    }

    public void setRep(Person p,double r) {
        for(int i=0;i<rep.size();i++){
            if(rep.get(i).getP().equals(p)){
                rep.get(i).setRep(r);
            }
        }
    }
    
    public int aveLunchHour(){
        int average,sum=0;
        for(int i=0;i<lunchStart.length;i++){
            sum+=lunchStart[i];
        }
        average=sum/lunchStart.length;
        return average;
    }
    
    public int aveLunchTime(){
        int average,sum=0;
        for(int i=0;i<lunchPeriod.length;i++){
            sum+=lunchPeriod[i];
        }
        average=sum/lunchPeriod.length;
        return average;
    }
}
