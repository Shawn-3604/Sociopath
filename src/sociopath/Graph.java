/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sociopath;

import java.util.LinkedList;

/**
 *
 * @author User
 */
public class Graph {
    LinkedList<Person> person=new LinkedList<>();
    
    public Graph(){
    }
    
    public int getsize(){
        return person.size();
    }
    
    public void addPerson(String name){
        Person p=new Person(name);
        person.addFirst(p);
    }
    
    public void addPerson(String name,double dive, int[] lunchStart, int[] lunchPeriod){
        Person p=new Person(name,dive,lunchStart,lunchPeriod);
        person.addFirst(p);
    }
    
    public void addFriends(Person p1,Person p2){
        p1.addFriends(p2);
        p2.addFriends(p1);
    }
    
    public Person getPerson(String name){
        for(int i=0;i<person.size();i++){
            if(person.get(i).getName().equals(name)){
                return person.get(i);
            }
        }
        return null;
    }
    
    public boolean contain(String name){
        Person p=new Person(name);
        for(int i=0;i<person.size();i++){
            if(person.get(i).contain(p))
                return true;
        }
        return false;
    }
    
    public Person[] toArray(){
        Person[] p=new Person[person.size()];
        for(int i=0;i<person.size();i++){
            p[i]=person.get(i);
        }
        return p;
    }
    
    public LinkedList<Person> toVertex(){
        return person;
    }
    
    public String toGraph(){
        String f="Friendship: ";
        for(int i=0;i<person.size();i++){
            for(int j=0;j<person.get(i).friends.size();j++){
                f+=("\n"+person.get(i).getName()+"----->"+person.get(i).friends.get(j).getP().getName());
            }
        }
        f+="\nReputation: ";
        for(int i=0;i<person.size();i++){
            for(int j=0;j<person.get(i).rep.size();j++){
                f+=("\n"+person.get(i).getName()+">>"+person.get(i).rep.get(j).toString());
            }
        }
        return f;
    }
}
