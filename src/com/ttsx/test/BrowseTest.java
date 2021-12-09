package com.ttsx.test;

import com.ttsx.dao.BrowseDao;
import com.ttsx.daoImpl.BrowseDaoImpl;
import com.ttsx.entiy.Browse;
import org.junit.Test;

import java.util.List;

public class BrowseTest {
    private BrowseDao browseDao = new BrowseDaoImpl();
    @Test
    public void browse(){
        Browse browse = new Browse();
        browse.setUserId("edf4c6d8-5672-11ec-ba80-00e04c680a6b");
        List<Browse> browseInfo = browseDao.getBrowseInfo(browse.getUserId());
        browseInfo.forEach(k->{
            System.out.println(k.toString());
        });
    }
}
