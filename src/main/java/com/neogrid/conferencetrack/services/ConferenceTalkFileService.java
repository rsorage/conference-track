package com.neogrid.conferencetrack.services;

import com.neogrid.conferencetrack.domain.ConferenceTalk;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ConferenceTalkFileService implements ConferenceTalkService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConferenceTalkFileService.class);

    private Stream<String> lines;

    public void loadFile(String filename) throws IOException {
        lines = Files.lines(Paths.get(filename));
    }

    @Override
    public List<ConferenceTalk> retrieveAvailableTalks() {
        return this.lines
                .map(this::parseLine)
                .filter(talk -> talk != null)
                .collect(Collectors.toList());
    }

    private ConferenceTalk parseLine(String line) {
        line = line.trim();

        try {
            String title = parseTitle(line);
            int duration = parseDuration(line);

            return new ConferenceTalk(title, duration);
        }
        catch(ParseException e) {
            LOGGER.error(e.getMessage());
            return null;
        }
    }

    private String parseTitle(String line) {
        return line.substring(0, line.lastIndexOf(" "));
    }

    private int parseDuration(String line) throws ParseException {
        String durationStr = line.substring(line.lastIndexOf(" ") + 1);

        if(durationStr.endsWith("min")) {
            durationStr = durationStr.replace("min", "");
            return Integer.parseInt(durationStr);
        }

        if(durationStr.equals("lightning")) {
            return 5;
        }

        throw new ParseException(String.format("Cannot parse line '{%s}'.", line), line.lastIndexOf(" "));
    }

}
