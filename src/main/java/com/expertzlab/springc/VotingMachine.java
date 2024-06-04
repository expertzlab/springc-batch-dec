package com.expertzlab.springc;

import java.util.HashMap;

import org.springframework.stereotype.Component;

@Component
public class VotingMachine {

    HashMap map = new HashMap<Candidate, Integer>();

    public void record(Candidate candidate){
        if( map.get(candidate) != null){
            int vote = (int) map.get(candidate);
            map.put(candidate, vote + 1);
        } else {
            map.put(candidate, 1);
        }
        
    }

    public int getVotes(Candidate candidate){
        if( map.get(candidate) == null){
            return 0;
        } else {
            return (int) map.get(candidate);
        }
    }

}
