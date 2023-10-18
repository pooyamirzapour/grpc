package com.example.grpc;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.ResponseEntity.noContent;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contracts")
public class Controller {

    @Autowired
    MyService myService;
    @GetMapping("{index}")
    public ResponseEntity<TestResponse> getContract(@PathVariable long index)
    {
        TestResponse response= new TestResponse();
        response.setContractList(myService.get(index).stream().map(this::getDto).collect(Collectors.toList()));
        return ResponseEntity.ok()
                .header(CONTENT_TYPE, "application/json")
                .body(response);
    }

    private ContractDTO getDto(Contract contract)
    {
        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setId(contract.getId());
        contractDTO.setName(contract.getName());
        contractDTO.setName2(contract.getName());
        contractDTO.setName3(contract.getName());
        contractDTO.setName4(contract.getName());
        contractDTO.setName5(contract.getName());
        contractDTO.setName6(contract.getName());
        contractDTO.setName7(contract.getName());
        contractDTO.setName8(contract.getName());
        contractDTO.setName9(contract.getName());
        contractDTO.setName10(contract.getName());

        return contractDTO;
    }
}
