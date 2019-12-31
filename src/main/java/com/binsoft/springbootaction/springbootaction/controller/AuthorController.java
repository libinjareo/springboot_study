package com.binsoft.springbootaction.springbootaction.controller;

import com.alibaba.fastjson.JSONObject;
import com.binsoft.springbootaction.springbootaction.domain.Author;
import com.binsoft.springbootaction.springbootaction.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/data/jdbc/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @RequestMapping(method = RequestMethod.GET)
    public Map<String, Object> getAuthorList(HttpServletRequest request) {
        List<Author> authorList = this.authorService.findAuthorList();
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("total", authorList.size());
        param.put("rows", authorList);
        return param;
    }

    //http://localhost:8080/data/jdbc/author/1
    @RequestMapping(value = "/{userId:\\d+}", method = RequestMethod.GET)
    public Author getAuthor(@PathVariable Long userId, HttpServletRequest request) {
        Author author = this.authorService.findAuthor(userId);
        if (author == null) {
            throw new RuntimeException("查询错误");
        }
        return author;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody JSONObject jsonObject) {
        String userId = jsonObject.getString("user_id");
        String realName = jsonObject.getString("real_name");
        String nickName = jsonObject.getString("nick_name");


        Author author = new Author();

        author.setId(Long.valueOf(userId));
        author.setRealName(realName);
        author.setNickName(nickName);

        try {
            this.authorService.add(author);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("新增错误");
        }

    }

    @RequestMapping(value = "/{userId:\\d+}", method = RequestMethod.PUT)
    public void update(@PathVariable Long userId, @RequestBody JSONObject jsonObject) {
        Author author = this.authorService.findAuthor(userId);
        String realName = jsonObject.getString("real_name");
        String nickName = jsonObject.getString("nick_name");

        author.setRealName(realName);
        author.setNickName(nickName);

        try {
            this.authorService.update(author);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("更新错误");
        }

    }
}
