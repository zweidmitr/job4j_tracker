package ru.job4j.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bugs", 4),
                new Job("Reboot server", 1),
                new Job("Impl task", 2),
                new Job("Impl list", 7)

        );
        System.out.println(jobs);
        Collections.sort(jobs);
        System.out.println(jobs);
        Collections.sort(jobs, new SortByNameJob());
        System.out.println(jobs);
        System.out.println();

        Collections.sort(jobs, new JobDeskByName().thenComparing(new JobDeskByPriority()));
        System.out.println(jobs);

        Comparator<Job> comb = new JobDescByNameLn()
                .thenComparing(new JobDeskByName())
                .thenComparing(new JobDeskByPriority());
        Collections.sort(jobs, comb);
        System.out.println(jobs);
    }
}
