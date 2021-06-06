/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sociopath;

import java.util.ArrayList;
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
    ArrayList<Friends> friends=new ArrayList<>();
    ArrayList<Reputation> rep=new ArrayList<>();

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
    
    public void addFriends(Person p,int num){
        Friends f=new Friends(p,num);
        friends.add(f);
    }
    
    public void addRep(Person p,int r){
        Reputation newr=new Reputation(p,r);
        rep.add(newr);
    }
    
    public boolean contain(Person p){
        return friends.contains(p);
    }

    public int getRep(Person p) {
        if(contain(p)){
            for(int i=0;i<rep.size();i++){
                if(p.equals(rep.get(i).getP())){
                    return rep.get(i).getRep();
                }
            }
        }
        return 0;
    }

    public void setRep(Person p,int r) {
        if(contain(p)){
            for(int i=0;i<rep.size();i++){
                if(p.equals(rep.get(i).getP())){
                    rep.get(i).setRep(r);
                }
            }
        }
    }
    
    public int aveLunchHour(){
        int average,sum=0;
        for(int i=0;i<lunchStart.length;i++){
            sum+=lunchStart[i];
        }
        return average=sum/lunchStart.length;
    }
    
    public int aveLunchTime(){
        int average,sum=0;
        for(int i=0;i<lunchPeriod.length;i++){
            sum+=lunchPeriod[i];
        }
        return average=sum/lunchPeriod.length;
    }
}
