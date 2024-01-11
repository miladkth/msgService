package kth.milad.controller;

import kth.milad.entity.Others;
import kth.milad.entity.Patient;
import kth.milad.service.IService;
import kth.milad.service.OthersServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class OthersController {

    private IService<Others> othersService;
    private OthersServiceImp othersServiceImp;


    @Autowired
    public OthersController(IService<Others> othersService, OthersServiceImp othersServiceImp) {
        this.othersService = othersService; this.othersServiceImp = othersServiceImp;
    }

    @GetMapping("/others")
    public List<Others> fetchOthersList(){
        System.out.println("get others called");
        List<Others> list = othersService.getAll();
        return list;
    }

    @GetMapping("/others/{id}")
    public Others getOthersById(@PathVariable int id) {
        Others others =  othersService.getById(id);
        return  others;
    }

    @GetMapping("/others/email/{email}")
    public Others getOthersById(@PathVariable String email) {
        return othersServiceImp.getByEmail(email);
    }

    @PostMapping("other")
    @ResponseStatus(HttpStatus.CREATED)
    public void createOther(@RequestBody Others other){
        System.out.println("other = " + other);
        othersService.create(other);
    }
}
