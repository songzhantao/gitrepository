package org.lanqiao.base;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.lanqiao.dao.ActivityTest;
import org.lanqiao.dao.OrderDaoImplTest;
import org.lanqiao.dao.UserDaoImplTest;

@RunWith(Suite.class)  
@SuiteClasses( {ActivityTest.class})  
public class DaoAllTests {

}
