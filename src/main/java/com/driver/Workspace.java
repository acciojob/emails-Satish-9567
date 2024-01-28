package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        // The inboxCapacity is equal to the maximum value an integer can store.

    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar

    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am
        Collections.sort(calendar, Comparator.comparing(Meeting::getEndTime).thenComparing(Meeting::getStartTime));

    int maxMeetings = 0;
    LocalTime lastEndTime = LocalTime.MIN;

    for (Meeting meeting : calendar) {
        // If the meeting starts after or exactly at the last meeting's end time, attend it
        if (meeting.getStartTime().isAfter(lastEndTime) || meeting.getStartTime().equals(lastEndTime)) {
            lastEndTime = meeting.getEndTime();
            maxMeetings++;
        }
    }

    return maxMeetings;
    }
}
