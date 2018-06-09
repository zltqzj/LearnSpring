package com.imooc.demo.controller;


import com.imooc.demo.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;



//    @Value("${cupSize}")
//    private  String cupSize;
//
//    @Value("${age}")
//    private  Integer age;
//
//    @Value("${content}")
//    private  String content;




   // @RequestMapping(value = "/say",method = RequestMethod.GET)
    @GetMapping(value = "/say")
    public  String say3(@RequestParam("id") Integer myId){
        return "id:" + myId;
        //   return  girlProperties.getCupSize();
    }

    @RequestMapping(value = "/say2/{id}",method = RequestMethod.GET)
    public  String say2(@PathVariable("id") Integer id){
        return "id:" + id;
     //   return  girlProperties.getCupSize();
    }

    @RequestMapping(value = "/say1",method = RequestMethod.GET)
    public  String say1(){
        return  girlProperties.getCupSize();
    }



}
