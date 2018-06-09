package com.imooc.demo.service;


import com.imooc.demo.repository.GirlRepository;
import com.imooc.demo.domain.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public  void insertTwo(){
        Girl girlA = new Girl();
        girlA.setCupSize( "a" );
        girlA.setAge( 18 );
        girlRepository.save( girlA );

        Girl girlB = new Girl();
        girlB.setCupSize( "bbbbb" );
        girlB.setAge( 10 );
        girlRepository.save( girlB );



    }
}
