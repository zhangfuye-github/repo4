package com.tensquare.base.service;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/12/23
 * @Description:在这个类中，我们实现基本的增删改查功能
 */
@Service
public class LabelService {
    @Autowired
    private LabelDao labelDao;
    @Autowired
    private IdWorker idWorker;

    /**
     * 查询全部标签
     *
     * @return
     */
    public List<Label> findAll() {
        return labelDao.findAll();
    }

    /**
     * 根据ID查询标签
     *
     * @return
     */
    public Label findById(String id) {
        return labelDao.findById(id).get();
    }

    /**
     * 增加标签
     *
     * @param label
     */
    public void add(Label label) {
        label.setId(idWorker.nextId() + "");//设置ID
        labelDao.save(label);
    }

    /**
     * 修改标签
     *
     * @param label
     */
    public void update(Label label) {
        labelDao.save(label);
    }

    /**
     * 删除标签
     *
     * @param id
     */
    public void deleteById(String id) {
        labelDao.deleteById(id);
    }

    /**
     * 根据条件进行查询
     * @param label
     * @return
     */
    public List<Label> findSearch(Label label) {
        return labelDao.findAll(new Specification<Label>() {
            /**
             *
             * @param root //表示要查询的数据库中的字段
             * @param criteriaQuery //查询的条件
             * @param criteriaBuilder //返回的结果
             * @return
             */
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList=new ArrayList<Predicate>();
                if(label.getLabelname()!=null && !"".equals(label.getLabelname())){
                    predicateList.add(criteriaBuilder.like(root.get("labelname").as(String.class),"%"+label.getLabelname()+"%"));
//                    System.out.println("labelname:"+root.get("labelname").as(String.class));
                }
                if(label.getState()!=null && !"".equals(label.getState())){
                    predicateList.add(criteriaBuilder.like(root.get("state").as(String.class),"%"+label.getState()+"%"));
//                    System.out.println("state:"+root.get("state").as(String.class));
                }
                if(label.getId()!=null && !"".equals(label.getId())){
                    predicateList.add(criteriaBuilder.like(root.get("id").as(String.class),"%"+label.getId()+"%"));
//                    System.out.println("id:"+root.get("id").as(String.class));
                }
                if(label.getRecommend()!=null && !"".equals(label.getRecommend())){
                    predicateList.add(criteriaBuilder.like(root.get("recommend").as(String.class),"%"+label.getRecommend()+"%"));
//                    System.out.println("recommend:"+root.get("recommend").as(String.class));
                }
                if(label.getCount()!=null && !"".equals(label.getCount())){
                    predicateList.add(criteriaBuilder.equal(root.get("count").as(Long.class),label.getCount()));
//                    System.out.println("count:"+root.get("count").as(Long.class));
                }
                Predicate[] arr=new Predicate[predicateList.size()];
                arr= predicateList.toArray(arr);
                Predicate predicate = criteriaBuilder.and(arr);
                return predicate;
            }
        });
    }

    public Page<Label> findSearch(Label label, int page, int size) {
        return labelDao.findAll(new Specification<Label>() {
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicateList = new ArrayList<Predicate>();
                if (label.getLabelname() != null && !"".equals(label.getLabelname())) {
                    predicateList.add(criteriaBuilder.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%"));
//                    System.out.println("labelname:"+root.get("labelname").as(String.class));
                }
                if (label.getState() != null && !"".equals(label.getState())) {
                    predicateList.add(criteriaBuilder.like(root.get("state").as(String.class), "%" + label.getState() + "%"));
//                    System.out.println("state:"+root.get("state").as(String.class));
                }
                if (label.getId() != null && !"".equals(label.getId())) {
                    predicateList.add(criteriaBuilder.like(root.get("id").as(String.class), "%" + label.getId() + "%"));
//                    System.out.println("id:"+root.get("id").as(String.class));
                }
                if (label.getRecommend() != null && !"".equals(label.getRecommend())) {
                    predicateList.add(criteriaBuilder.like(root.get("recommend").as(String.class), "%" + label.getRecommend() + "%"));
//                    System.out.println("recommend:"+root.get("recommend").as(String.class));
                }
                if (label.getCount() != null && !"".equals(label.getCount())) {
                    predicateList.add(criteriaBuilder.equal(root.get("count").as(Long.class), label.getCount()));
//                    System.out.println("count:"+root.get("count").as(Long.class));
                }
                Predicate[] arr = new Predicate[predicateList.size()];
                arr = predicateList.toArray(arr);
                Predicate predicate = criteriaBuilder.and(arr);
                return predicate;
            }
        },new PageRequest(page-1,size));
    }
}
