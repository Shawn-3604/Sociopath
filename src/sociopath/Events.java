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

/**
 * A:the person that seeking for help
 * B:the person that helping
 * Grade: to show whether P_2 can teach or not
 * answer: to decide whether to help or not
 */
public class Events {
    /**
    * A:the person that seeking for help
    * B:the person that helping
    * Grade: to show whether P_2 can teach or not
    * answer: to decide whether to help or not
    */
    public static void Events1(Person A,Person B,boolean Grade,boolean answer){
        System.out.println("Event 1: ");
        if(A.contain(B)||B.contain(A)){
            System.out.println(A.getName()+" and "+B.getName()
                    +" are not strangers");
        }else{
            System.out.println(A.getName()+" asks "+B.getName()
                    +" to help to teach how to solve the Data Structure course's lab question");
            if(answer){
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
    
    
    public static void Events2(Person A,Person B,Person C,boolean side){
        System.out.println("Event 2: ");
        double rep;
        if(A.contain(B)||B.contain(A)){
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
}
