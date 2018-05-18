package com.his.mapper;

import com.his.vo.Info;
import tk.mybatis.mapper.common.Mapper;
import zhibi.frame.mybatis.example.Example;

import java.util.List;

public interface InfoMapper extends Mapper<Info> {
    List<Info> selectPoByExample(Example example);
}
