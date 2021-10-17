package com.neo4j.demo.controller;

import com.neo4j.demo.entity.ScenceName;
import com.neo4j.demo.service.ScenceSpotService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * @author yuanyue
 */
//直接使用@RestController注解来处理http请求
@RestController
//增删改查
@Api(value = "对知识图谱的crud", tags = "查询景点")
//跨域请求的注解
@CrossOrigin
public class TravelController {

//    @Resource
    @Autowired
    private ScenceSpotService scenceSpotService;

    /**
     * 返回最近的5个Node
     * @return 5个Node
     */
    //使用于在方法上，表示一个http请求的操作
    //value用于方法描述
    //notes用于提示内容
    @ApiOperation(value = "返回最近的5个Node")
    @RequestMapping(value = "/travel-node",method = RequestMethod.GET)
    public List recentNode(
//            @ApiParam字段说明；表示对参数的添加元数据（说明或是否必填等）
//            name–参数名
//            value–参数说明
//            required–是否必填
            //是获取请求头中的数据，通过指定参数 value 的值来获取请求头中指定的参数值。其他参数用法和
    ) {
        return scenceSpotService.findScenceSpot();
    }

    /**
     * 返回最近的limit个Node
     * @param limit 限制的条数
     * @return limit个Node
     */
    @ApiOperation(value = "返回最近的limit个Node")
    @RequestMapping(value = "/travel-limit", method = RequestMethod.GET)
    public List recentLimitedNode(
            @ApiParam(name = "limit", value = "限制的条数")
            @RequestHeader("limit") int limit) {
        return scenceSpotService.findScenceSpot(limit);
    }


    @CrossOrigin
    @RequestMapping(value = "/travel-name", method = RequestMethod.GET)
    public List<ScenceName> findByName(
            @RequestParam("name") String name) {
        System.out.println(name);
        List<ScenceName> list = scenceSpotService.findScenceSpotByName(name);
        String subString = list.get(0).getDescription();
        String[] splitAddress=subString.split("\', \'");
        System.out.println("这是IE好的字符串"+splitAddress[0]);

        System.out.println("list"+list);

        return list;
    }

    /**
     * 通过省份查找节点及其相关的所有节点
     * @return 节点集合的json
     */
    @ApiOperation(value = "通过省份查找节点及其相关的所有节点")
    @RequestMapping(value = "/sf-graph", method = RequestMethod.GET)
    public List<ScenceName> findGraphById(@RequestParam("province") String province) {
        return scenceSpotService.findRelatedScenceSpots(province);
    }


    @RequestMapping(value = "/add-travel-des", method = RequestMethod.POST)
    public ScenceName addPaintingDescription(@RequestParam("province") String province,
                                           @RequestParam("description") String description) {
        return scenceSpotService.saveScenceDescription(province, description);
    }

    @RequestMapping(value = "/made-list", method = RequestMethod.GET)
    public List<ScenceName> getMadeList(@RequestParam("province") String province) {
        return scenceSpotService.findRelatedScenceSpots(province);
    }

}

