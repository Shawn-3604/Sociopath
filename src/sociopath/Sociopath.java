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
public class Sociopath {
    public static void main(String[] args) {
        Data D=new Data();
        //Initialization of the variable
        initialize(D);
        
        /**Events*/
        //System.out.println(D.toData());
        //Events.Events1(D.getPerson("P1"),D.getPerson("P2"),true,true);
        //Events.Events2(D.getPerson("P1"), D.getPerson("P2"), D.getPerson("P3"), false);
        //Events.Events3(D.getPerson("P7"),D);
        //Events.Events4();
        //Events.Events5(D.getPerson("P7"), D.getPerson("P3"));
        Events.Events6();
        
        /**Additional Challenges*/
        //ExtraFeatures.AdditionalChallenge4(D.getPerson("P7"), D);
    }
    
    
    public static void initialize(Data D){
        //Initialization of a person
        D.addPerson("P1", 0.3, new int[] {1130,1145,1130,1200,1230,1130,1130}, new int[] {15,30,15,45,30,45,45});
        D.addPerson("P2", 0.4, new int[] {1130,1130,1200,1200,1130,1300,1300}, new int[] {30,30,30,45,45,15,15});
        D.addPerson("P3", 0.4, new int[] {1300,1300,1230,1300,1130,1200,1200}, new int[] {45,45,30,15,15,30,45});
        D.addPerson("P4", 0.2, new int[] {1200,1130,1200,1300,1300,1230,1200}, new int[] {15,30,45,45,30,15,15});
        D.addPerson("P5", 0.25, new int[] {1130,1100,1130,1200,1200,1300,1100}, new int[] {30,15,15,45,30,30,45});
        D.addPerson("P6", 0.2, new int[] {1200,1230,1230,1300,1130,1300,1130}, new int[] {45,30,30,15,15,15,30});
        D.addPerson("P7", 0.25, new int[] {1300,1300,1200,1230,1230,1130,1130}, new int[] {45,30,45,45,15,30,15});
        D.addPerson("P8", 0.4, new int[] {1100,1130,1300,1300,1200,1230,1230}, new int[] {15,15,30,45,45,30,30});
        D.addPerson("P9", 0.5, new int[] {1300,1100,1300,1130,1200,1200,1230}, new int[] {45,45,30,30,15,30,15});
        D.addPerson("P10", 0.35, new int[] {1230,1230,1130,1200,1200,1300,1300}, new int[] {30,30,30,15,15,45,45});
        
        //Initialization of a person reputation towards another person
        D.getPerson("P1").addRep(D.getPerson("P2"), 5);
        D.getPerson("P1").addRep(D.getPerson("P7"), 4);
        D.getPerson("P2").addRep(D.getPerson("P1"), 8);
        D.getPerson("P2").addRep(D.getPerson("P3"), 5);
        D.getPerson("P2").addRep(D.getPerson("P5"), 6);
        D.getPerson("P2").addRep(D.getPerson("P6"), 9);
        D.getPerson("P3").addRep(D.getPerson("P2"), 4);
        D.getPerson("P4").addRep(D.getPerson("P8"), 7);
        D.getPerson("P4").addRep(D.getPerson("P10"), 7);
        D.getPerson("P5").addRep(D.getPerson("P2"), 2);
        D.getPerson("P6").addRep(D.getPerson("P2"), 7);
        D.getPerson("P7").addRep(D.getPerson("P1"), 3);
        D.getPerson("P8").addRep(D.getPerson("P4"), 10);
        D.getPerson("P9").addRep(D.getPerson("P10"), 5);
        D.getPerson("P10").addRep(D.getPerson("P4"), 7);
        D.getPerson("P10").addRep(D.getPerson("P9"), 6);
        
        //Initialization of friends between two person
        D.addFriends(D.getPerson("P1"),D.getPerson("P2"));
        D.addFriends(D.getPerson("P1"),D.getPerson("P7"));
        D.addFriends(D.getPerson("P2"),D.getPerson("P3"));
        D.addFriends(D.getPerson("P2"),D.getPerson("P5"));
        D.addFriends(D.getPerson("P2"),D.getPerson("P6"));
        D.addFriends(D.getPerson("P4"),D.getPerson("P8"));
        D.addFriends(D.getPerson("P4"),D.getPerson("P10"));
        D.addFriends(D.getPerson("P9"),D.getPerson("P10"));
    }
}
