package com.neogrid.conferencetrack;

import com.neogrid.conferencetrack.domain.ConferenceTalk;
import com.neogrid.conferencetrack.domain.TalkSession;
import com.neogrid.conferencetrack.services.ConferenceTalkFileService;
import com.neogrid.conferencetrack.services.TalkSessionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    private ConferenceTalkFileService conferenceTalkService;
    private TalkSessionService talkSessionService;

    public Runner(ConferenceTalkFileService conferenceTalkService, TalkSessionService talkSessionService) throws IOException {
        this.conferenceTalkService = conferenceTalkService;
        this.talkSessionService = talkSessionService;

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        this.conferenceTalkService.loadFile(classLoader.getResource("input.txt").getFile());
    }

    @Override
    public void run(String... args) throws Exception {
        List<ConferenceTalk> talks = conferenceTalkService.retrieveAvailableTalks();

        Collection<TalkSession> sessions = talkSessionService.schedule(talks);
        sessions.forEach(System.out::println);
    }

}

