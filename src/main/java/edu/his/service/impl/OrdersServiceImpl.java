package edu.his.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.his.extra.base.BaseServiceImpl;
import edu.his.mapper.OrdersMapper;
import edu.his.service.OrdersService;
import edu.his.vo.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zhibi.frame.domain.Page;
import zhibi.frame.mybatis.example.Example;


@Service
@Transactional
public class OrdersServiceImpl extends BaseServiceImpl<Orders> implements OrdersService {

    @Autowired
    public OrdersServiceImpl(OrdersMapper mapper) {
        super(mapper);
    }

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public PageInfo<Orders> selectByExample(Example example, Page page) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        return new PageInfo<Orders>(ordersMapper.selectPoByExample(example),5);
    }
}
