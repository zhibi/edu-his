package edu.his.mapper;

import edu.his.vo.Orders;
import tk.mybatis.mapper.common.Mapper;
import zhibi.frame.mybatis.example.Example;

import java.util.List;

public interface OrdersMapper extends Mapper<Orders> {
    List<Orders> selectPoByExample(Example example);
}
