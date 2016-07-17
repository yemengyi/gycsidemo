package com.gycsi.dao;

import com.gycsi.domain.Gary;

import java.util.List;

/**
 * Created by qian-pc on 7/16/16.
 */
public interface GaryDao {
   List<Gary> getGarys(String sfzh);
   void getImageBySFZH(String sfzh,String fileName);
}
