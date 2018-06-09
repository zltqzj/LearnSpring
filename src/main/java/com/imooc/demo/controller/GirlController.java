package com.imooc.demo.controller;

import com.imooc.demo.domain.Girl;
import com.imooc.demo.repository.GirlRepository;
import com.imooc.demo.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    @PostMapping(value = "/girls/two")
    public void girlTwo(){
        girlService.insertTwo();
    }

    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id, @RequestParam("cupSize") String cupSize, @RequestParam("age") Integer age){
       Girl girl  = new Girl();
       girl.setId( id );
       girl.setCupSize( cupSize );
       girl.setAge( age );
      return girlRepository.save( girl );
    }



    @PostMapping(value="/girls1")
    public Girl girlAdd1(@RequestParam("cupSize") String cupSize,@RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    @PostMapping(value="/girls")
    public Girl girlAdd(@Valid Girl girl, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            System.out.println(  bindingResult.getFieldError().getDefaultMessage());
            return  null;
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        return girlRepository.save(girl);
    }

    @GetMapping(value="/girls")
    public List<Girl> girlList(){
        return girlRepository.findAll();
    }

    @DeleteMapping(value = "/girls/{id}")
    public  void girlDelete(@PathVariable("id") Integer id){
        girlRepository.deleteById(id);
    }

    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
       // return girlRepository.findById(id).get();
        return  null;
    }


    // 通过年龄查询列表
    @GetMapping(value = "/girls/age/{age}")
    public  List<Girl> girlListByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge( age );

    }
}
