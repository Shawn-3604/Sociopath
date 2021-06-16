/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sociopath;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Events {
    private static Scanner s=new Scanner(System.in);
    
    /**
     * Teaching a stranger to solve lab question
     * @param A: the stranger
     * @param B: the teacher
     * @param Grade: whether the teacher is good or not at programming
     * @param answer: whether the teacher want to teach or not
     */
    public static void Events1(Person A,Person B,boolean Grade,boolean answer){
        System.out.println("Event 1: ");
        //To check whether A and B stranger or not
        if(A.contain(B)||B.contain(A)){
            System.out.println(A.getName()+" and "+B.getName()
                    +" are not strangers");
        }else{
            System.out.println(A.getName()+" asks "+B.getName()
                    +" to help to teach how to solve the Data Structure course's lab question");
            //To check whether B want to teach or not
            if(answer){
                //To check whether B good or not at programming
                if(Grade){
                    B.addRep(A, 10);
                    System.out.println(A.getName()+" said that the learning experience with "
                            +B.getName()+" is very pleasant");
                    System.out.println(B.getName()+">>"+A.getName()+",rep: "
                            +B.getRep(A));
                }else{
                    B.addRep(A, 2);
                    System.out.println(A.getName()+" said that the learning experience with "
                            +B.getName()+" is not very pleasant");
                    System.out.println(B.getName()+">>"+A.getName()+",rep: "
                            +B.getRep(A));
                }
            }else{
                System.out.println(A.getName()+" refuse to help "+B.getName());
            }
        }
    }
    
    /**
     * Chit-chat
     * @param A: the person that been talked about
     * @param B: the person that tell C about A
     * @param C: the listener
     * @param side: whether B talked good or bad about A
     */
    public static void Events2(Person A,Person B,Person C,boolean side){
        System.out.println("Event 2: ");
        double rep;
        //To check whether A and B friends or not
        if(A.contain(B)||B.contain(A)){
            //To check whether B tell about good or bad side of A
            if(side){
                rep=A.getRep(B)*0.5;
                C.addRep(A,rep);
                System.out.println(B.getName()+" speak about "
                            +A.getName()+"'s good side with "+C.getName());
                    System.out.println(C.getName()+">>"+A.getName()+",rep: "
                            +C.getRep(A));
            }else{
                rep=A.getRep(B)*(-1);
                C.addRep(A, rep);
                System.out.println(B.getName()+" speak about "
                            +A.getName()+"'s bad side with "+C.getName());
                    System.out.println(C.getName()+">>"+A.getName()+",rep: "
                            +C.getRep(A));
            }
        }else{
            System.out.println(A.getName()+" and "+B.getName()
                    +" are strangers");
        }
    }
    
    /**
     * Your road to glory
     * @param A:The person that want others
     * @param D:The data that had been initialize
     */
    public static void Events3(Person A,Data D){
        System.out.println("Event 3: ");
        System.out.println(A.getName()+" want to eat lunch with others to increase reputation");
        int startLunch=A.aveLunchHour();
        int lunchTime=A.aveLunchTime();
        int endLunch=startLunch+lunchTime;
        int totalrep=0;
        //To ensure time is in correct form
        if(endLunch%100>=60){
            endLunch+=40;
        }
        int otherStartLunch,otherLunchTime,otherEndLunch;
        for(int i=0;i<D.person.size();i++){
            //To check for the same person
            if(A.equals(D.person.get(i))){
                continue;
            }
            otherStartLunch=D.person.get(i).aveLunchHour();
            otherLunchTime=D.person.get(i).aveLunchTime();
            otherEndLunch=otherStartLunch+otherLunchTime;
            //To ensure time is in correct form
            if(otherEndLunch%100>=60){
                otherEndLunch+=40;
            }
            //To check whether still have time to lunch with others
            if(lunchTime>0){
                //To check whether other person is available during the time
                if(endLunch>otherEndLunch){
                    lunchTime=lunchTime-(otherEndLunch-startLunch);
                    //To check whether A is friends with that person or not
                    if(A.contain(D.person.get(i))){
                        A.setRep(D.person.get(i), A.getRep(D.person.get(i))+1);
                        totalrep+=1;
                    }else{
                        A.addRep(D.person.get(i), 1);
                        totalrep+=1;
                    }
                System.out.println(A.getName()+" eats lunch with "+D.person.get(i).getName());
                }
            }else{
                break;
            }
        }
        System.out.println(A.getName()+" max reputation obtain is "+totalrep);
    }
    
    /**
     * Arranging books
     */
    public static void Events4(){
        int round=0;
        LinkedList<Integer> bookList=new LinkedList<>();
        System.out.println("Events 4:");
        System.out.print("Enter Number of book: ");
        int num=s.nextInt();
        s.nextLine();
        System.out.print("Enter all the books height: ");
        String list=s.nextLine();
        String[] bookHeights=list.split(" ");
        //To move the data from bookHeights to bookList
        for(int i=0;i<bookHeights.length;i++){
            bookList.push(Integer.parseInt(bookHeights[bookHeights.length-i-1]));
        }
        //To arrange the books
        for(int i=0;i<bookList.size();i++){
            System.out.print("Books height: ");
            for(int j=0;j<bookList.size();j++){
                if(j==bookList.size()-1){
                    System.out.print(bookList.get(j));
                    break;
                }else if(bookList.get(j)<=bookList.get(j+1)){
                    bookList.remove(j+1);
                }
                System.out.print(bookList.get(j)+" ");
            }
            round=i;
            System.out.println();
        }
        round+=1;
        System.out.println("Total number of rounds: "+round);
    }
    
    
    public static ArrayList<ArrayList<Person>> rumor=new ArrayList<>();
    /**
     * Meet your crush
     * @param A: The starter of the rumor
     * @param B : The crush
     */
    public static void Events5(Person A,Person B){
        rumor.clear();
        System.out.println("Events 5: ");
        System.out.println("The rumor start: "+A.getName());
        System.out.println("The crush: "+B.getName());
        PossiblePath(A,B,new ArrayList<Person>());
        //To check whether there is a path between the person and crush
        if(rumor.isEmpty()){
            System.out.println("There is no way the rumor will spread.");
            return;
        }else{
            for(int i=0;i<rumor.size();i++){
                //To get the possible path of rumor
                for(int j=0;j<rumor.get(i).size();j++){
                    //To check for crush friends
                    if(rumor.get(i).get(j).contain(B)){
                        //To check whether the crush is the person's friend
                        if(rumor.get(i).get(j).equals(A)){
                            System.out.println("Rumor can be spread to crush!!");
                            return;
                        }else{
                            System.out.println(rumor.get(i).get(j).getName());
                            return;
                        }
                    }else{
                        System.out.print(rumor.get(i).get(j).getName()+"-->");
                    }
                }
                System.out.println("");
            }
        }
    }
    
    /**
     * Path for the rumor to travel
     * @param A: The starter of the rumor
     * @param B: A friend
     * @param arr: The list of person
     */
    public static void PossiblePath(Person A,Person B,ArrayList<Person> arr){
        arr.add(A);
        for(int i=0;i<A.friends.size();i++){
            //To check whether A friend list at certain person is equal at B
            if(A.friends.get(i).getP().equals(B)){
                ArrayList<Person> arr2=new ArrayList<>();
                for(int j=0;j<arr.size();j++){
                    arr2.add(arr.get(j));
                }
                arr2.add(B);
                rumor.add(arr2);
            }else{
                if(!arr.contains(A.friends.get(i).getP())){
                    ArrayList<Person> arr2=new ArrayList<>();
                    for(int j=0;j<arr.size();j++){
                        arr2.add(arr.get(j));
                    }
                    //Recursion
                    PossiblePath(A.friends.get(i).getP(),B,arr2);
                }
            }
        }
    }
    
    public static Data d=new Data();
    /**
     * Friendship
     */
    public static void Events6(){
        System.out.println("Events 6: ");
        System.out.print("Enter number of friends: ");
        int num=s.nextInt();
        String[] str1=new String[num];
        System.out.println("Enter the existing friendships between two people: ");
        s.nextLine();
        //Input for the existing friendships
        for(int i=0;i<num;i++){
            String s1=s.next();
            String s2=s.next();
            //To check for the same person
            if(!d.contain(s1)){
                d.addPerson(s1);
            }
            //To check for the same person
            if(!d.contain(s2)){
                d.addPerson(s2);
            }
            d.addFriends(d.getPerson(s1), d.getPerson(s2));
        }
        //To get the list of friendships
        for(int i=0;i<d.person.size();i++){
            for(int j=i+1;j<d.person.size();j++){
                friendsPath(d.person.get(d.person.size()-1-i),d.person.get(d.person.size()-1-j),new ArrayList<>());
            }
        }
    }
    
    /**
     * To get the friendships
     * @param A: The first person
     * @param B: A friends
     * @param arr: The list of friends
     */
    public static void friendsPath(Person A,Person B,ArrayList<Person> arr){
        arr.add(A);
        for(int i=0;i<A.friends.size();i++){
            //check for the same person
            if(A.friends.get(i).getP().equals(B)){
                ArrayList<Person> arr2=new ArrayList<>();
                for(int j=0;j<arr.size();j++){
                    arr2.add(arr.get(j));
                }
                arr2.add(B);
                display(arr2);
            }else{
                if(!arr.contains(A.friends.get(i).getP())){
                    ArrayList<Person> arr2=new ArrayList<>();
                    for(int j=0;j<arr.size();j++){
                        arr2.add(arr.get(j));
                    }
                    //Recursion
                    friendsPath(A.friends.get(i).getP(),B,arr2);
                }
            }
        }
    }
    
    /**
     * To print out the friendship list
     * @param arr: List of person
     */
    public static void display(ArrayList<Person> arr){
        System.out.print("[");
        for(int i=0;i<arr.size();i++){
            //To check for the last friend in the list
            if(i==arr.size()-1){
                System.out.print(arr.get(i).getName());
            }else{
                System.out.print(arr.get(i).getName()+",");
            }
        }
        System.out.println("]");
    }
}
