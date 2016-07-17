package com.gycsi.repository;

import com.gycsi.domain.Gary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by qian-pc on 7/12/16.
 */
@Repository
public interface GaryRepository extends CrudRepository<Gary,String>{
}
