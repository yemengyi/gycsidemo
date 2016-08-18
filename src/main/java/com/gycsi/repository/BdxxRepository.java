package com.gycsi.repository;

import com.gycsi.domain.Bdxx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by qian-pc on 8/9/16.
 */
public interface BdxxRepository extends JpaRepository<Bdxx,Long> {

    Bdxx findByOpenidAndYxbz(String openid,String yxbz);

    @Modifying
    @Transactional
    @Query("update Bdxx p set p.yxbz='0',p.jbsj=?2 where p.openid=?1 and p.yxbz='1'" )
    int resetBdxx(String openid, Date date);
}
