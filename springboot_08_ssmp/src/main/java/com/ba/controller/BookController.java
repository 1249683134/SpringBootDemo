package com.ba.controller;

import com.ba.controller.utils.R;
import com.ba.domain.Book;
import com.ba.service.IBookService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

//表现层

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public R getAll() {
        return new R(true, bookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book) throws IOException {
        if (book.getName().equals("123")) throw new IOException(); //骗过编译器(抛出异常后，后面的语句不执行了编译报错，这里添加一个if语句骗过编译器)，抛出一个异常
//        if (true) throw new IOException(); //骗过编译器(抛出异常后，后面的语句不执行了编译报错，这里添加一个if语句骗过编译器)，抛出一个异常

        boolean flag = bookService.save(book);

        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
//        return new R(bookService.save(book));
    }

    @PutMapping
    public R update(@RequestBody Book book) {
        return new R(bookService.modify(book));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id) {
        return new R(bookService.delete(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id) {
        return new R(true, bookService.getById(id));
    }

    //所有查询都用get请求
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize, Book book) {
        IPage<Book> page = bookService.getPage(currentPage, pageSize, book);
        //如果当前页码值大于总页码值，那么会重新执行查询操作，使用最大页码值作为当前页的页码值
        if (currentPage > page.getPages()) {
            page = bookService.getPage((int) page.getPages(), pageSize, book);
        }

        return new R(true, page);
//        return new R(true, bookService.getPage(currentPage, pageSize));
    }

//    @GetMapping("{currentPage}/{pageSize}")
//    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize) {
//        IPage<Book> page = bookService.getPage(currentPage, pageSize);
//        //如果当前页码值大于总页码值，那么会重新执行查询操作，使用最大页码值作为当前页的页码值
//        if (currentPage > page.getPages()) {
//            page = bookService.getPage((int) page.getPages(), pageSize);
//        }
//
//        return new R(true, page);
////        return new R(true, bookService.getPage(currentPage, pageSize));
//    }


}
