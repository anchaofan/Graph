package com.neo4j.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//builder 有了setter方法
@Builder
public class Link {
    private Long from;
    private Long to;
    private String text;//线上的文字，关系
    private final boolean directionless = false;
    private LinkStyle style;
}
