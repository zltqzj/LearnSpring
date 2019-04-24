package com.imooc.demo.controller;


import com.imooc.demo.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;


    @GetMapping(value = "/hello1")
    public  String hello(){
        return "hello";
        //   http://123.57.248.43:9999/hello/hello1
    }
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
