package com;

import lombok.Data;

import java.util.List;

/**
 * @Author: baojx
 * @Date: 2020/2/20 19:38
 * @Desc: Album
 */
@Data
public class Album {

    private String name;

    private List<Track> tracks;

    private List<Artist> musicians;
}
