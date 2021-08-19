package com.shbh.article.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shbh.article.entity.ArticleVote;
import com.shbh.article.mapper.ArticleVoteMapper;
import com.shbh.article.service.IArticleVoteService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 投票 服务实现类
 * </p>
 *
 * @author MaZhuli
 * @since 2021-08-18
 */
@Service
public class ArticleVoteServiceImpl extends ServiceImpl<ArticleVoteMapper, ArticleVote> implements IArticleVoteService {

}
