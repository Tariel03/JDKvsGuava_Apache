package org.example.overview.benchmark_vergleich;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class JMHRunner {
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(TrieVergleich.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}