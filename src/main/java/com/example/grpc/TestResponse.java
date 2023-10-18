package com.example.grpc;

import java.util.ArrayList;
import java.util.List;

public class TestResponse {
    List<ContractDTO> contractList=new ArrayList<>();

    public List<ContractDTO> getContractList() {
        return contractList;
    }

    public void setContractList(List<ContractDTO> contractList) {
        this.contractList = contractList;
    }
}
