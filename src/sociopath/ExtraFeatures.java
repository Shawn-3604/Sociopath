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
public class ExtraFeatures {
    /**
     * Parallel Farming
     * @param A:The person that want others
     * @param D:The graph that had been initialize
     */
    public static void AdditionalChallenge4(Person A,Data D){
        
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
            //To check whether other person is available during the time
            if(endLunch>otherEndLunch){
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
        }
        System.out.println(A.getName()+" max reputation obtain is "+totalrep);
    }
}
