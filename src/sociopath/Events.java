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
 * P_1:the person that seeking for help
 * P_2:the person that helping
 * Grade: to show whether P_2 can teach or not
 * answer: to decide whether to help or not
 */
public class Events {
    public static void Events1(Person P_1,Person P_2,boolean Grade,boolean answer){
        System.out.println("Event 1: ");
        if(P_1.contain(P_2)||P_2.contain(P_1)){
            System.out.println(P_1.getName()+" and "+P_2.getName()
                    +" are not strangers");
        }else{
            System.out.println(P_1.getName()+" asks "+P_2.getName()
                    +" to help to teach how to solve the Data Structure course's lab question");
            if(answer){
                if(Grade){
                    P_2.setRep(P_1, 10);
                    System.out.println(P_1.getName()+" said that the learning experience with "
                            +P_2.getName()+" is very pleasant");
                    System.out.println(P_2.getName()+">>"+P_1.getName()+",rep: "
                            +P_2.getRep(P_1));
                }else{
                    P_2.setRep(P_1, 2);
                    System.out.println(P_1.getName()+" said that the learning experience with "
                            +P_2.getName()+" is not very pleasant");
                    System.out.println(P_2.getName()+">>"+P_1.getName()+",rep: "
                            +P_2.getRep(P_1));
                }
            }else{
                System.out.println(P_1.getName()+" refuse to help "+P_2.getName());
            }
        }
    }
        
}
