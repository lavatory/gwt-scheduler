package gwtscheduler.common.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * @author mlesikov  {mlesikov@gmail.com}
 */
public interface CalendarEventDeleteEventHandler extends EventHandler {

  void onEventDelete(CalendarEventDeleteEvent event);
}