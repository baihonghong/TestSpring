package jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:TODO
 * @author:baihhw
 * @date:2024/12/15 14:43
 */
@State(Scope.Thread)
public class Benckmark {
    @Param({"1","10000"})
    private int nStrings;

    private static ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();

    @Benchmark
    public void testOne(Blackhole bh) {
        for(int i = 0;i<nStrings;i++){
            String s = new String("String to intern " + i);
            String intern = map.putIfAbsent(s,s);
            bh.consume(intern);
        }
    }

    @Benchmark
    public void testTwo(Blackhole bh) {
        for(int i = 0;i<10000;i++){
            String s = new String("String to intern " + i);
            String intern = s.intern();
            bh.consume(intern);
        }
    }
}
