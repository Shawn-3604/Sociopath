/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sociopath;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Events {
    public static Scanner s=new Scanner(System.in);
    
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
                    B.setRep(A, 10);
                    System.out.println(A.getName()+" said that the learning experience with "
                            +B.getName()+" is very pleasant");
                    System.out.println(B.getName()+">>"+A.getName()+",rep: "
                            +B.getRep(A));
                }else{
                    B.setRep(A, 2);
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
     * @param D:The graph that had been initialize
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
    
    public static void Events4(){
        int round=0;
        LinkedList<Integer> bookList=new LinkedList<>();
        System.out.println("Events 4:");
        System.out.println("Enter Number of book: ");
        int num=s.nextInt();
        s.nextLine();
        System.out.println("Enter all the books height: ");
        String list=s.nextLine();
        String[] bookHeights=list.split(" ");
        for(int i=0;i<bookHeights.length;i++){
            bookList.push(Integer.parseInt(bookHeights[bookHeights.length-i-1]));
        }
        
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
}
