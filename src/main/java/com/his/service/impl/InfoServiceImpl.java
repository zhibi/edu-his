package com.his.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.his.extra.base.BaseServiceImpl;
import com.his.mapper.InfoMapper;
import com.his.service.InfoService;
import com.his.vo.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zhibi.frame.domain.Page;
import zhibi.frame.mybatis.example.Example;


@Service
@Transactional
public class InfoServiceImpl extends BaseServiceImpl<Info> implements InfoService {

    @Autowired
    public InfoServiceImpl(InfoMapper mapper) {
        super(mapper);
    }

    @Autowired
    private InfoMapper infoMapper;

    @Override
    public PageInfo<Info> selectByExample(Example example, Page page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        return new PageInfo<Info>(infoMapper.selectPoByExample(example),5);
    }
}
