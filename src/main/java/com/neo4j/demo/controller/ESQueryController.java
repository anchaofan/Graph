package com.neo4j.demo.controller;

import com.neo4j.demo.service.ElasticSearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

//知道Dao是数据访问 Service是业务处理 Controller是界面处理就可以了。
@RestController
@Api(value = "搜索controller", tags = "搜索框接口")
public class ESQueryController {
    @Resource
    private ElasticSearchService searchService;

    /**
     * 索引常量
     */
    private static final String SCENCENAME_INDEX = "scencename_idx";//景点名字索引索引
    private static final String ADDRESS_INDEX = "address_idx";//景点地点索引


    /**
     * 导入所有旅游的数据
     * @throws IOException 找不到service
     */

//    @ApiOperation
//    使用于在方法上，表示一个http请求的操作
//    value用于方法描述
//    notes用于提示内容
//    tags可以重新分组（视情况而用）
//    在Spring MVC 中使用 @RequestMapping 来映射请求，也就是通过它来指定控制器可以处理哪些URL请求，相当于Servlet中在web.xml中配置
    //@ApiParam
    //使用在方法上或者参数上，字段说明；表示对参数的添加元数据（说明或是否必填等）
    //name–参数名
    //value–参数说明
    //required–是否必填
    @ApiOperation(value = "搜索候选词")
    @RequestMapping(value = "/search/{index}/{keyword}/{pageNo}/{pageSize}", method = RequestMethod.GET)
    public ArrayList<Map<String, Object>> searchScenceByName(@ApiParam(name = "index", value = "查询的库：scencename_idx")
                                                              @PathVariable String index,
                                                              @ApiParam(name = "keyword", value = "查询的关键字")
                                                              @PathVariable String keyword,
                                                              @ApiParam(name = "pageNo", value = "返回的库的页码，默认填1")
                                                              @PathVariable int pageNo,
                                                              @ApiParam(name = "pageSize", value = "联想的候选条数，越大提示内容越多")
                                                              @PathVariable int pageSize) throws IOException {
        return searchService.search(index, keyword, pageNo, pageSize);

    }



}
