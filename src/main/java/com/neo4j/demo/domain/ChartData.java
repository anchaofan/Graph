package com.neo4j.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//整合包，只要加了 @Data 这个注解，等于同时加了以下注解
//
//@Getter/@Setter
//@ToString
//@EqualsAndHashCode
//@RequiredArgsConstructor
@Data
//所有声明的构造
@AllArgsConstructor
//无参构造
@NoArgsConstructor
@Builder
public class ChartData {
    private List<Node> nodes;
    private List<Link> links;
}
