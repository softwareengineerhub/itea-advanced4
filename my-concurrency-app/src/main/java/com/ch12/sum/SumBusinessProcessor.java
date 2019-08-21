package com.ch12.sum;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SumBusinessProcessor {
    private int step = 1;
    private ExecutorService executorService;

    public SumBusinessProcessor() {
        executorService = Executors.newFixedThreadPool(11);
    }

    public int sum(int[] data) {
        List<SumAggregationTask> tasks = createTasks(data);
        List<Future<Integer>> futures = submitTasks(tasks);
        int sum = 0;
        for (Future<Integer> future : futures) {
            try {
                int partOfSum = future.get();
                sum += partOfSum;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return sum;
    }

    private List<Future<Integer>> submitTasks(List<SumAggregationTask> taskList) {
        List<Future<Integer>> futures = new ArrayList<Future<Integer>>();
        for (SumAggregationTask task : taskList) {
            Future<Integer> future = executorService.submit(task);
            futures.add(future);
        }
        return futures;
    }

    private List<SumAggregationTask> createTasks(int[] data) {
        List<SumAggregationTask> taskList = new ArrayList<SumAggregationTask>();
        int n = data.length / step;
        for (int i = 0; i < n; i++) {
            SumAggregationTask task = new SumAggregationTask(data, i * step, i * (step) + step);
            taskList.add(task);
        }
        return taskList;
    }
}
