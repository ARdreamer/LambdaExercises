package com;

import lombok.Data;

/**
 * @Author: baojx
 * @Date: 2020/2/20 19:37
 * @Desc: Artist
 */
@Data
public class Artist {

    private String name;

    private String members;

    private String origin;

    private Track track;

    public boolean isFrom(String city){
        return false;
    }
}
