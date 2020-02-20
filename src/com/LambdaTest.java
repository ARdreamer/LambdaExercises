package com;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: baojx
 * @Date: 2020/2/20 20:34
 * @Desc: LambdaTest
 */
public class LambdaTest {

    @Test
    public void test31() {
        List<Artist> artistList = new ArrayList<>();
        int count = 0;
        //3-1
        for (Artist artist : artistList) {
            if (artist.isFrom("London")) {
                count++;
            }
        }
        //3-2
        Iterator<Artist> iterator = artistList.iterator();
        while (iterator.hasNext()) {
            Artist artist = iterator.next();
            if (artist.isFrom("London")) {
                count++;
            }
        }
        //3-3
        long count1 = artistList.stream().
                filter(artist -> artist.isFrom("London")).
                count();
    }

    @Test
    public void test32() {
        List<Artist> artistList = new ArrayList<>();
        artistList.add(new Artist());
        //3-5惰性求值
        artistList.stream().
                filter(artist -> {
                    System.out.println("我不会输出");
                    return artist.isFrom("London");
                });
        //3-6 出现count（及早求值方法）
        artistList.stream().
                filter(artist -> {
                    System.out.println("我会输出");
                    return artist.isFrom("London");
                }).count();
        //
    }

    @Test
    public void test33() {
        //3.3.1 collect
        List<String> collected1 = Stream.of("a", "b", "c").
                collect(Collectors.toList());
        System.out.println(collected1);
        //3.3.2 map
        List<String> collected2 = new ArrayList<>();
        for (String s : Arrays.asList("a", "b", "c")) {
            String s1 = s.toUpperCase();
            collected2.add(s1);
        }
        System.out.println(collected2);
        //3.3.2 map to Up
        List<String> collected3 = Stream.of("a", "b", "c").
                map(s -> s.toUpperCase()).
                collect(Collectors.toList());
        System.out.println(collected3);
        List<String> collected4 = Stream.of("a", "b", "c").
                map(String::toUpperCase).
                collect(Collectors.toList());
        System.out.println(collected4);
        //3.3.3 filter
        List<String> beginningWithNumbers = new ArrayList<>();
        for (String s : Arrays.asList("a", "1abc", "abc1")) {
            if (isDigit(s.charAt(0))) {
                beginningWithNumbers.add(s);
            }
        }
        System.out.println(beginningWithNumbers);
        List<String> beginningWithNumber = Stream.of("a", "1abc", "abc1").
                filter(s -> isDigit(s.charAt(0))).
                collect(Collectors.toList());
        System.out.println(beginningWithNumber);
    }

    public boolean isDigit(char c) {
        char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for (char c1 : chars) {
            if (c == c1) {
                return true;
            }
        }
        return false;
    }
}
