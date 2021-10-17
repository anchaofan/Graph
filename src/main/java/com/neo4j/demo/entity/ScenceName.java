package com.neo4j.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.stereotype.Component;

import java.util.*;

//交给spring管理
@Component
//实体类
@NodeEntity(label = "景点")// Applied at the class level to indicate this class is a candidate for mapping to the database.
//@Document(indexName = "scence_idx")//indexName 索引库名
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScenceName {
//    @Id//在字段级别应用以标记用于标识字段的目的。
//    @GeneratedValue//在外地一级应用，并指定应如何生成唯一标识符
    @Property(name = "name")//在字段级别应用以将映射从属性修改为属性。neo4j的节点属性值，支持8种基本类型外加String
//    @Field(analyzer = "ik_max_word")
    private String name;//名字

    private String province;//省份

    private Long city;//地址

    private String level;//等级

    public String address;//地址

    private String description;//简介

    private String phone;

    private String money;

    private String image;//图像

    private String urls;

//    @Relationship(type = "SAME_ERA", direction = Relationship.OUTGOING)
//    private List<Painter> sameEraPainters;

    @Override
    public String toString() {
        return "ScenceName{" +
                "name='" + name + '\'' +
                ", province='" + province + '\'' +
                ", city=" + city +
                ", level='" + level + '\'' +
                ", description='" + description + '\'' +
                ", phone='" + phone + '\'' +
                ", image='" + image + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScenceName travel = (ScenceName) o;
        return Objects.equals(province, travel.province) &&
                Objects.equals(level, travel.level) &&
                Objects.equals(name, travel.name) &&
                Objects.equals(city, travel.city) &&
                Objects.equals(phone, travel.phone) &&
                Objects.equals(description, travel.description) &&
                Objects.equals(image, travel.image) &&
                Objects.equals(address, travel.address)&&
                Objects.equals(money, travel.money)&&
                Objects.equals(urls, travel.urls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, province,city, address, level, description, phone,image, urls);
    }

//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getProvince() {
//        return province;
//    }
//
//    public void setProvince(String province) {
//        this.province = province;
//    }
//
//    public Long getCity() {
//        return city;
//    }
//
//    public void setCity(Long city) {
//        this.city = city;
//    }
//
//    public int getLevel() {
//        return level;
//    }
//
//    public void setLevel(int level) {
//        this.level = level;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }
//
//    public ScenceName() {
//    }
//
//    public ScenceName(Long id, String name, String province, int birth, int death, String description, String image) {
//        this.name = name;
//        this.province = province;
//        this.city = city;
//        this.level = level;
//        this.description = description;
//        this.phone = phone;
//        this.image = image;
//    }
}
