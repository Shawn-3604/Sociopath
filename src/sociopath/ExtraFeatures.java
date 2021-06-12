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
public class ExtraFeatures {
    private static Scanner s=new Scanner(System.in);
    /**
     * Parallel Farming
     * @param A:The person that want others
     * @param D:The data that had been initialize
     */
    public static void AdditionalChallenge4(Person A,Data D){
        System.out.println("Additional Challenge 4: ");
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
    
    private static LinkedList<Person> vaccinated=new LinkedList<>();
    private static ArrayList<ArrayList<Person>> cluster=new ArrayList<>();
    private static ArrayList<Person> visited=new ArrayList<>();
    /**
     * Herd Immunity
     * @param d: The data that had been initialize
     */
    public static void AdditionalChallenge6(Data d){
        System.out.println("Additional Challenge 6: ");
        System.out.print("Total vaccine number: ");
        int vaccine=s.nextInt();
        //To check whether the vaccine is enough for all or not
        if(vaccine>=d.getsize()){
            System.out.println("Everyone is vaccinated since the number of vaccine is enough.");
        }else{
            while(vaccine!=0){
                cluster.clear();
                visited.clear();
                //
                for(int i=0;i<vaccinated.size();i++){
                    visited.add(vaccinated.get(i));
                }
                vaccine--;
                for(int i=0;i<d.person.size();i++){
                    if(!visited.contains(d.person.get(i))){
                        ArrayList<Person> p=new ArrayList<>();
                        bestfriends(d.person.get(i),p);
                        cluster.add(p);
                    }
                }
                int maxClusterSize=0;
                int maxCluster=-1;
                for(int i=0;i<cluster.size();i++){
                    if(cluster.get(i).size()>maxClusterSize){
                        maxClusterSize=cluster.get(i).size();
                        maxCluster=i;
                    }
                }
                for(int i=0;i<cluster.size();i++){
                    System.out.print("cluster "+(i+1)+": ");
                    for(int j=0;j<cluster.get(i).size();j++){
                        if(j==cluster.get(i).size()-1){
                            System.out.print(cluster.get(i).get(j).getName());
                        }else{
                            System.out.print(cluster.get(i).get(j).getName()+", ");
                        }
                    }
                    System.out.println("");
                }
                int maxOutDeg = 0;
                int maxOutDegIndex = -1;
                for (int i = 0; i < cluster.get(maxCluster).size(); i++) {
                    LinkedList<Friends> f = cluster.get(maxCluster).get(i).friends;
                    int count = 0;
                    for (int j = 0; j < f.size(); j++) {
                        if(vaccinated.contains(f.get(j).getP())){
                            count++;
                        }
                    }
                    int outdeg = f.size() - count;
                    if(outdeg>maxOutDeg){
                        maxOutDeg = outdeg;
                        maxOutDegIndex = i;
                    }
                }
                System.out.println("People vaccinated : "+cluster.get(maxCluster).get(maxOutDegIndex).getName());
                vaccinated.add(cluster.get(maxCluster).get(maxOutDegIndex));
            }
        }
    }
    /**
     * To check for friends connection
     * @param A: The main person
     * @param p: A list of person
     */
    public static void bestfriends(Person A,ArrayList<Person> p){
        visited.add(A);
        p.add(A);
        for(int i=0;i<A.friends.size();i++){
            if(!visited.contains(A.friends.get(i).getP())){
                bestfriends(A.friends.get(i).getP(),p);
            }
        }
    }
}
