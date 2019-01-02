//package com.xzm.modules.test.jpa;
//
//import com.querydsl.core.types.OrderSpecifier;
//import com.querydsl.core.types.Predicate;
//import com.querydsl.core.types.dsl.BooleanExpression;
//import com.querydsl.core.types.dsl.EntityPathBase;
//import com.querydsl.jpa.impl.JPAQuery;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import com.spark.bitrade.pagination.PageResult;
//import org.apache.poi.ss.formula.functions.T;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
///**
// * @author rongyu
// * @description
// * @date 2018/1/18 10:29
// */
//@Component
//public class BaseService<T> {
//
//    //JPA查询工厂
//    @Autowired
//    protected JPAQueryFactory queryFactory;
//
//    @Autowired
//    protected JPAQueryFactory jpaQueryFactory;
//
//    /**
//     * 查询列表
//     *
//     * @param pageNo             分页参数
//     * @param pageSize           分页大小
//     * @param predicateList      查询条件
//     * @param entityPathBase     查询表
//     * @param orderSpecifierList 排序条件
//     * @return
//     */
//    @Transactional(readOnly = true)
//    public PageResult<T> queryDsl(Integer pageNo, Integer pageSize, List<Predicate> predicateList, EntityPathBase<T> entityPathBase, List<OrderSpecifier> orderSpecifierList) {
//        List<T> list;
//        //查询表
//        JPAQuery<T> jpaQuery = jpaQueryFactory.selectFrom(entityPathBase);
//        //查询条件
//        if (predicateList != null && predicateList.size() > 0)
//            jpaQuery.where(predicateList.toArray(new Predicate[predicateList.size()]));
//        //排序方式
//        if (orderSpecifierList != null && orderSpecifierList.size() > 0)
//            jpaQuery.orderBy(orderSpecifierList.toArray(new OrderSpecifier[orderSpecifierList.size()]));
//        //分页查询
//        if (pageNo != null && pageSize != null) {
//            list = jpaQuery.offset((pageNo - 1) * pageSize).limit(pageSize).fetch();
//        } else {
//            list = jpaQuery.fetch();
//        }
//        return new PageResult<>(list, pageNo, pageSize, jpaQuery.fetchCount());
//     }
//
//    /**
//     * 查询单个
//     *
//     * @param predicate      查询条件
//     * @param entityPathBase 查询表
//     * @return
//     */
//    @Transactional(readOnly = true)
//    public T queryOneDsl(Predicate predicate, EntityPathBase<T> entityPathBase) {
//        return jpaQueryFactory.selectFrom(entityPathBase).where(predicate).fetchFirst();
//    }
//
//}
