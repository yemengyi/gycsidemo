package com.gycsi.repository;

import com.gycsi.domain.Rzxx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by qian-pc on 8/14/16.
 */
public interface RzxxRepository extends JpaRepository<Rzxx,Long>{
    @Query("select p from Rzxx p where p.nd=?1 and p.sfzh=?2 and p.cjsj = (select max(c.cjsj) from Rzxx c where c.nd=?1 and c.sfzh=?2)")
    Rzxx findLastRzxx(String nd,String sfzh);
}
