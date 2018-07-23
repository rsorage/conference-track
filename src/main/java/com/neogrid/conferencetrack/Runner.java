package com.neogrid.conferencetrack;

import com.neogrid.conferencetrack.domain.ConferenceTalk;
import com.neogrid.conferencetrack.services.ConferenceTalkFileService;
import com.neogrid.conferencetrack.util.TalkDurationComparator;
import com.neogrid.conferencetrack.util.Time;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    private ConferenceTalkFileService service;

    public Runner(ConferenceTalkFileService service) throws IOException {
        this.service = service;

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        this.service.loadFile(classLoader.getResource("input.txt").getFile());
    }

    @Override
    public void run(String... args) throws Exception {
//        List<ConferenceTalk> talks = service.retrieveAvailableTalks();
//        Collections.sort(talks, new TalkDurationComparator());
//
//        talks.forEach(System.out::println);

        Time t1 = new Time(13, 5);
        Time t2 = new Time(23, 5);
        Time t3 = new Time(1, 5);
        Time t4 = new Time(11, 5);
        Time t5 = new Time(12, 5);
        Time t6 = new Time(0, 5);

        Arrays.asList(t1, t2, t3, t4, t5, t6).forEach(System.out::println);
    }

}

