package com.tensquare.base.controller;

import com.tensquare.base.pojo.City;
import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/12/24
 * @Description:
 */
@RestController
@CrossOrigin //该注解实现跨域访问，不同微服务之间进行访问
@RequestMapping("/lable")
public class LableController {

    @Autowired
    private LabelService labelService;

    /**
     * 添加标签
     * @param label
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Label label){
        labelService.add(label);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /**
     * 查询所有标签
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        List<Label> all = labelService.findAll();
        return new Result(true,StatusCode.OK,"查询成功",all);
    }

    /**
     * 根据ID查询标签
     * @param labelId
     * @return
     */
    @RequestMapping(value ="/{labelId}",method = RequestMethod.GET)
    public Result findById(@PathVariable("labelId") String labelId){
//        int i=1/0;
        return new Result(true,StatusCode.OK,"查询成功",labelService.findById(labelId));
    }

    /**
     * 修改标签
     * @param label
     * @return
     */
    @RequestMapping(value ="/{labelId}",method = RequestMethod.PUT)
    public Result update(@PathVariable String labelId, @RequestBody Label label){
        label.setId(labelId);
        labelService.update(label);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /**
     * 删除标签
     * @param labelId
     * @return
     */
    @RequestMapping(value ="/{labelId}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable String labelId){

        labelService.deleteById(labelId);
        return new Result(true,StatusCode.OK,"删除成功");
    }
    @RequestMapping(value="/search",method=RequestMethod.POST)
    public Result findSearch(@RequestBody Label label){
        System.out.println(label.getLabelname());
        System.out.println(label.getState());
        List<Label> list = labelService.findSearch(label);
        System.out.println(list);
        return new Result(true,StatusCode.OK,"查询成功",list);
    }

    @RequestMapping(value="/search/{page}/{size}",method=RequestMethod.POST)
    public Result pageFind(@RequestBody Label label,@PathVariable int page,@PathVariable int size){

        Page<Label> list = labelService.findSearch(label,page,size);

        return new Result(true,StatusCode.OK,"查询成功",new PageResult<Label>(list.getTotalElements(),list.getContent()));
    }
}
