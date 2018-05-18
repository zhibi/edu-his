package com.his.service.impl;

import com.his.extra.base.BaseServiceImpl;
import com.his.mapper.ArticleMapper;
import com.his.service.ArticleService;
import com.his.vo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ArticleServiceImpl extends BaseServiceImpl<Article> implements ArticleService {

    @Autowired
    public ArticleServiceImpl(ArticleMapper mapper) {
        super(mapper);
    }

}
