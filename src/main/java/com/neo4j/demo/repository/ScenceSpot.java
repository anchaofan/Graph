package com.neo4j.demo.repository;

import com.neo4j.demo.entity.ScenceName;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
//注解接口
@Repository
public interface ScenceSpot extends Neo4jRepository<ScenceName,String> {

    //查找5个最新的景点
    @Query("MATCH (p : 景点) RETURN p LIMIT 5;")
    List<ScenceName> findScenceSpot();

    //查找5个最新的景点
    @Query("CREATE (aa: 李俊哲 {bb:'李俊哲'});")
    List<ScenceName> findAll();

    //查找n个最新的景点
    @Query("MATCH (p : 景点) RETURN p LIMIT {limit};")
    List<ScenceName> findLimitScenceSpots(@Param("limit") int limit);



    //查找有关景点
    @Query("MATCH (p1 : 景点)-[]-(p2: 景点) WHERE p1.省份=$省份 RETURN p1,p2;")
    List<ScenceName> findRelatedScenceSpotsById(@Param("省份") String province);


    //查找name景点
    @Query("MATCH(p : 景点) WHERE p.name=$名称 RETURN p;")
    List<ScenceName> findScenceSpotByName(@Param("名称") String name);

    //创建描述
    @Transactional
    @Query("MATCH (p : 景点) WHERE 省份(p)=$省份 SET p.简介=$简介 RETURN p;")
    ScenceName saveScenceDescription(@Param("省份") String province, @Param("简介") String description);
}
