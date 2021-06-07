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
public class Sociopath {
    public static void main(String[] args) {
        Graph g=new Graph();
        initialize(g);
        
        System.out.println(g.getPerson("P7").getRep(g.getPerson("P1")));
    }
    
    public static void initialize(Graph g){
        g.addPerson("P1", 0.3, new int[] {1130,1145,1130,1200,1230,1130,1130}, new int[] {15,30,15,45,30,45,45});
        g.addPerson("P2", 0.4, new int[] {1130,1130,1200,1200,1130,1300,1300}, new int[] {30,30,30,45,45,15,15});
        g.addPerson("P3", 0.4, new int[] {1300,1300,1230,1300,1130,1200,1200}, new int[] {45,45,30,15,15,30,45});
        g.addPerson("P4", 0.2, new int[] {1200,1130,1200,1300,1300,1230,1200}, new int[] {15,30,45,45,30,15,15});
        g.addPerson("P5", 0.25, new int[] {1130,1100,1130,1200,1200,1300,1100}, new int[] {30,15,15,45,30,30,45});
        g.addPerson("P6", 0.2, new int[] {1200,1230,1230,1300,1130,1300,1130}, new int[] {45,30,30,15,15,15,30});
        g.addPerson("P7", 0.25, new int[] {1300,1300,1200,1230,1230,1130,1130}, new int[] {45,30,45,45,15,30,15});
        g.addPerson("P8", 0.4, new int[] {1100,1130,1300,1300,1200,1230,1230}, new int[] {15,15,30,45,45,30,30});
        g.addPerson("P9", 0.5, new int[] {1300,1100,1300,1130,1200,1200,1230}, new int[] {45,45,30,30,15,30,15});
        g.addPerson("P10", 0.35, new int[] {1230,1230,1130,1200,1200,1300,1300}, new int[] {30,30,30,15,15,45,45});
        
        g.getPerson("P1").setRep(g.getPerson("P2"), 5);
        g.getPerson("P1").setRep(g.getPerson("P7"), 4);
        g.getPerson("P2").setRep(g.getPerson("P1"), 8);
        g.getPerson("P2").setRep(g.getPerson("P3"), 5);
        g.getPerson("P2").setRep(g.getPerson("P5"), 6);
        g.getPerson("P2").setRep(g.getPerson("P6"), 9);
        g.getPerson("P3").setRep(g.getPerson("P2"), 4);
        g.getPerson("P4").setRep(g.getPerson("P8"), 7);
        g.getPerson("P4").setRep(g.getPerson("P10"), 7);
        g.getPerson("P5").setRep(g.getPerson("P2"), 2);
        g.getPerson("P6").setRep(g.getPerson("P2"), 7);
        g.getPerson("P7").setRep(g.getPerson("P1"), 3);
        g.getPerson("P8").setRep(g.getPerson("P4"), 10);
        g.getPerson("P9").setRep(g.getPerson("P10"), 5);
        g.getPerson("P10").setRep(g.getPerson("P4"), 7);
        g.getPerson("P10").setRep(g.getPerson("P9"), 6);
        
        g.addFriends(g.getPerson("P1"),g.getPerson("P2"));
        g.addFriends(g.getPerson("P1"),g.getPerson("P7"));
        g.addFriends(g.getPerson("P2"),g.getPerson("P3"));
        g.addFriends(g.getPerson("P2"),g.getPerson("P5"));
        g.addFriends(g.getPerson("P2"),g.getPerson("P6"));
        g.addFriends(g.getPerson("P4"),g.getPerson("P8"));
        g.addFriends(g.getPerson("P4"),g.getPerson("P10"));
        g.addFriends(g.getPerson("P9"),g.getPerson("P10"));
    }
}
