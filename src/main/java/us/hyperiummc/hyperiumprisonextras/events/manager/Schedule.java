package us.hyperiummc.hyperiumprisonextras.events.manager;

import us.hyperiummc.hyperiumprisonextras.HyperiumPrisonExtras;
import us.hyperiummc.hyperiumprisonextras.utils.Broadcast;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class Schedule implements Runnable {

    boolean lagAnnounce = true;
    boolean lagStart = true;
    boolean lagResetLags = true;

    @Override
    public void run() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/New_York"));
//        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        int sec = calendar.get(Calendar.SECOND);

        if(min == 55 && (sec == 0 || lagAnnounce)) {
            lagResetLags = true;
            lagAnnounce = false;

            if(EventManager.isEventRunning) {
                EventManager.lastEventFailed = true;

                List<String> rawMessages = HyperiumPrisonExtras.getInstance().messagesConfig.getStringList("messages.not-enough-mined");
                for(int i = 0; i < rawMessages.size(); i++) {
                    Broadcast.broadcast(rawMessages.get(i));
                }

                EventManager.stopCurrentEvent();
                return;
            }

            List<String> rawMessages = HyperiumPrisonExtras.getInstance().messagesConfig.getStringList("messages.starting-soon");
            for(int i = 0; i < rawMessages.size(); i++) {
                Broadcast.broadcast(rawMessages.get(i));
            }

        }

        if(min == 0 && (sec == 0 || lagStart)) {
            lagStart = false;

            if(EventManager.lastEventFailed) {
                EventManager.lastEventFailed = false;
                return;
            }

            List<String> rawMessages = HyperiumPrisonExtras.getInstance().messagesConfig.getStringList("messages.started");
            for(int i = 0; i < rawMessages.size(); i++) {
                String message = rawMessages.get(i).replace("%blocks%", Integer.toString(HyperiumPrisonExtras.getInstance().getConfig().getInt("events.blocks-mined.required")));
                Broadcast.broadcast(message);
            }
            EventManager.setCurrentEvent("Mine");
        }

        if(min == 5 && (sec == 0 || lagResetLags)) {
            lagResetLags = false;
            lagAnnounce = true;
            lagStart = true;
        }
    }

}
