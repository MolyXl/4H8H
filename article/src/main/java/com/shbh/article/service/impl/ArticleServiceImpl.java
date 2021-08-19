package com.shbh.article.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shbh.article.entity.Article;
import com.shbh.article.mapper.ArticleMapper;
import com.shbh.article.service.IArticleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章 服务实现类
 * </p>
 *
 * @author MaZhuli
 * @since 2021-08-18
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

}
