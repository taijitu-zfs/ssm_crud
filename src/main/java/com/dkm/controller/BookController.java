package com.dkm.controller;

import com.dkm.book.BookDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {

    /**
     * 添加图书
     * @return
     */
    @RequestMapping(value="/book",method = RequestMethod.POST)
    public String addBook(){
        System.out.println(1+"好");
        return "success";
    }
    /**
     * 删除图书
     * @return
     */
    @RequestMapping(value = "/book/{bid}",method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable("bid")Integer id){
        System.out.println(id+"好好"+3);
        return "success";
    }
    /**
     * 更新图书
     * @return
     */
    @RequestMapping(value = "/book/{bid}",method = RequestMethod.PUT)
    public String updateBook(@PathVariable("bid")Integer id){
        System.out.println(id+"嘻嘻"+4);
        return "success";
    }
    /**
     * 查询图书
     * @return
     */
    @RequestMapping(value = "/book/{bid}",method = RequestMethod.GET)
    public String getBook(@PathVariable("bid")Integer id){
        System.out.println(id+"浏览"+2);
        return "success";
    }

    @RequestMapping("/bookshops")
    public String bookFrom(BookDao bookDao){
        System.out.println("sgsfdxfcgv");
        System.out.println(bookDao);
        return "success";
    }
}
