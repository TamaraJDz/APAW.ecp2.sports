package es.upm.miw.sports.wrappers;

import java.util.ArrayList;
import java.util.List;

public class NickListWrapper {
    private List<String> userNickList;

    public NickListWrapper() {
        userNickList = new ArrayList<>();
    }

    public void addNick(String nick) {
        userNickList.add(nick);
    }

    @Override
    public String toString() {
        String result = "{\"userList\":[";
        for (String nick : userNickList) {
            result += nick + ",";
        }
        return result.substring(0, result.length() - 1) + "]}";
    }
}
