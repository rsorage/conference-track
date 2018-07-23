package com.neogrid.conferencetrack.services;

import com.neogrid.conferencetrack.domain.ConferenceTalk;
import com.neogrid.conferencetrack.domain.TalkSession;

import java.util.Collection;
import java.util.List;

public interface TalkSessionService {

    /**
     * Schedule talk sessions according to given available talks.
     *
     * @param availableTalks Available talks.
     * @return Scheduled sessions.
     */
    Collection<TalkSession> schedule(List<ConferenceTalk> availableTalks);

}
