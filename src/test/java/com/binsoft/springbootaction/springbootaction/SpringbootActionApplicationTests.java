package com.binsoft.springbootaction.springbootaction;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootActionApplication.class)
class SpringbootActionApplicationTests {

    @Resource(name = "oneJdbcTemplate")
    protected JdbcTemplate jdbcTemplate1;

    @Resource(name = "twoJdbcTemplate")
    protected JdbcTemplate jdbcTemplate2;

    @Test
    void jdbcTest() {
        jdbcTemplate1.update("insert into t_author(id,real_name,nick_name) values (?,?,?)", 4, "不告诉你", "UnKnow");
        jdbcTemplate2.update("insert into t_author(id,real_name,nick_name) values (?,?,?)", 1, "空指针", "NullPointer");
    }

}
