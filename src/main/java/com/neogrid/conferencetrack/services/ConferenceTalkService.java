package com.neogrid.conferencetrack.services;

import com.neogrid.conferencetrack.domain.ConferenceTalk;

import java.util.Collection;

public interface ConferenceTalkService {

    Collection<ConferenceTalk> retrieveAvailableTalks();

}
