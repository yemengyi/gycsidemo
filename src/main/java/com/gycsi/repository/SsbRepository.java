package com.gycsi.repository;

import com.gycsi.domain.Ssb;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by qian-pc on 8/17/16.
 */
public interface SsbRepository extends JpaRepository<Ssb,String> {
    Ssb findBySsbh(String ssbh);
}
