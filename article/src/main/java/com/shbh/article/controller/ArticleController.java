package com.shbh.article.controller;


import com.shbh.article.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 文章 前端控制器
 * </p>
 *
 * @author MaZhuli
 * @since 2021-08-18
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    private IArticleService articleService;

    @Autowired
    public void setArticleService(IArticleService articleService) {
        this.articleService = articleService;
    }
}

