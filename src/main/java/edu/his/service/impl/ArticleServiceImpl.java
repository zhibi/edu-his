package edu.his.service.impl;

import edu.his.extra.base.BaseServiceImpl;
import edu.his.mapper.ArticleMapper;
import edu.his.service.ArticleService;
import edu.his.vo.Article;
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
