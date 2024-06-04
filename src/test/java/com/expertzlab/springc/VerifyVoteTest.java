package com.expertzlab.springc;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(com.expertzlab.springc.VerifyVoteTest.TestConfig.class)
public class VerifyVoteTest {

    @Autowired
    VotingMachine vm;

    @Test
    public void mustIncrementByOne(){
        assertTrue(vm != null, "vm can not be Null");
        Candidate c = new Candidate();
        c.setName("Kannan");
        c.setSymbol("Axe");
        int votes = vm.getVotes(c);
        vm.record(c);
        assertTrue((votes + 1) == vm.getVotes(c), "Votes are not recorded correctly" );
    }

    @Configuration
    static class TestConfig {

        @Bean
        VotingMachine getVotingMachine(){
            return new VotingMachine();
        }
    }

}
