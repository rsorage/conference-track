package com.neogrid.conferencetrack.services;

import com.neogrid.conferencetrack.domain.ConferenceTalk;
import com.neogrid.conferencetrack.domain.TalkSession;
import com.neogrid.conferencetrack.util.Time;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TalkSessionServiceImpl implements TalkSessionService {

    private static final Time SESSION_START = new Time(9);
    private static final Time BREAK_START = new Time(12);
    private static final Time BREAK_END = new Time(13);
    private static final Time SESSION_END = new Time(17);

    private ConferenceTalkService conferenceTalkService;

    public TalkSessionServiceImpl(ConferenceTalkService conferenceTalkService) {
        this.conferenceTalkService = conferenceTalkService;
    }

    @Override
    public Collection<TalkSession> schedule(List<ConferenceTalk> availableTalks) {
        Map<Integer, List<ConferenceTalk>> talksByDuration = availableTalks.stream()
                .collect(Collectors.groupingBy(ConferenceTalk::getDuration, LinkedHashMap::new, Collectors.toList()));

        Time nextSessionTime = new Time(SESSION_START);
        Set<Integer> durations = talksByDuration.keySet();

//        while(nextSessionTime)


        return null;
    }
}
