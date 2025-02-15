package jmh;

import org.junit.Test;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * @description:TODO
 * @author:baihhw
 * @date:2024/12/15 15:25
 */
public class TestClass {
    @Test
    public void testMyBenchmark() throws Exception {
        Options options = new OptionsBuilder()
                .include(Benckmark.class.getSimpleName())
                .forks(1)
                .threads(1)
                .warmupIterations(5)
                .measurementIterations(5)
                .mode(Mode.AverageTime)
                .build();

        new Runner(options).run();
    }

}
