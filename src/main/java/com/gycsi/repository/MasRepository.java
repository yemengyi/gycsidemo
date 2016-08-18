package com.gycsi.repository;

import com.gycsi.domain.C_Mas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by qian-pc on 8/8/16.
 */
public interface MasRepository extends JpaRepository<C_Mas,String>{

    @Query("select u.yzm from C_Mas u where u.sjhm=?1  and u.fssj = (select max(p.fssj) from C_Mas p where p.sjhm=?1)")
    String findCurrentYzm(String sjhm);
}
