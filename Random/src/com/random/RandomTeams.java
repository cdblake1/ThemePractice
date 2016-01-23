package com.random;

import java.util.ArrayList;


public class RandomTeams
{
    public static void main (String[] args) throws java.lang.Exception
    {
        ArrayList<String> teamOne = new ArrayList<String>();
        ArrayList<String> teamTwo = new ArrayList<String>();
        String players[] = {"MiniCasterMinion", "D2Gambit", "Bonchwater", 
        "Proteje", "ChadJones", "R4wrB4by", "GEquinox", "sparkee", "Raelan",
        "Blinding2"};
     
        
        for(int i = 0; i < 5; i++){
            int rand = (int)(Math.random() * 10);
            while(teamOne.contains(players[rand]))
                rand = (int)(Math.random() * 10);
            teamOne.add(players[rand]);
        }
        for(int i = 0; i < 10; i++){
            if(!teamOne.contains(players[i])){
                teamTwo.add(players[i]);
            }
        }
        System.out.println(teamOne);
        System.out.println(teamTwo);
            

    }
}