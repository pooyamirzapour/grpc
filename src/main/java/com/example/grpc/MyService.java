package com.example.grpc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    public List<Contract> get(long index)
    {
        List<Contract> contracts= new ArrayList<>();
        for (long i = 0; i <index ; i++) {
            Contract contract= new Contract();
            contract.setId(i);
            contract.setName("Sara");
            contract.setName1("Sara");
            contract.setName2("Sara");
            contract.setName3("Sara");
            contract.setName4("Sara");
            contract.setName5("Sara");
            contract.setName6("Sara");
            contract.setName7("Sara");
            contract.setName8("Sara");
            contract.setName9("Sara");
            contract.setName10("Sara");

            contracts.add(contract);
        }
        return contracts;
    }
}
