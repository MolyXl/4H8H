package com.shbh.article.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shbh.article.entity.ArticleAnonymous;
import com.shbh.article.mapper.ArticleAnonymousMapper;
import com.shbh.article.service.IArticleAnonymousService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 匿名文章 服务实现类
 * </p>
 *
 * @author MaZhuli
 * @since 2021-08-18
 */
@Service
public class ArticleAnonymousServiceImpl extends ServiceImpl<ArticleAnonymousMapper, ArticleAnonymous> implements IArticleAnonymousService {

}
