package com.neogrid.conferencetrack.services;

import com.neogrid.conferencetrack.domain.ConferenceTalk;
import com.neogrid.conferencetrack.domain.TalkSession;
import com.neogrid.conferencetrack.util.Time;
import org.springframework.stereotype.Service;

import java.util.*;

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
        List<TalkSession> sessions = new LinkedList<>();
        Time startSessionTime = new Time(SESSION_START);

        for(ConferenceTalk talk: availableTalks) {
            Time nextSessionTime = startSessionTime.plusMinutes(talk.getDuration());

            if(!nextSessionTime.before(SESSION_END))
                break;

            if(!nextSessionTime.before(BREAK_START) && nextSessionTime.before(BREAK_END))
                nextSessionTime = new Time(BREAK_END);

            TalkSession newSession = new TalkSession(talk, startSessionTime, nextSessionTime);
            sessions.add(newSession);

            startSessionTime = nextSessionTime;
        }

        ConferenceTalk networkingTalk = new ConferenceTalk("Networking Event", 0);
        TalkSession networkingSession = new TalkSession(networkingTalk, startSessionTime, 0);
        sessions.add(networkingSession);

        return sessions;
    }
}
