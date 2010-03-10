package gwtscheduler.client.widgets.view.weekcolumns;

import gwtscheduler.client.widgets.view.columns.CalendarColumn;
import gwtscheduler.common.event.Event;
import org.goda.time.DateTime;

/**
 * @author mlesikov  {mlesikov@gmail.com}
 */
public class DayColumn implements CalendarColumn {

  private DateTime day;

  public DayColumn(DateTime day) {
    this.day = day;
  }

  @Override
  public String getTitle() {
    String title = "";
    if (day != null) {
      String dayOfWeek = day.dayOfWeek().getAsShortText();
      String monthOfYear = day.monthOfYear().getAsShortText();
      String dayOfMonth = day.dayOfMonth().getAsShortText();
      title = dayOfWeek + ", " + monthOfYear + " " + dayOfMonth;
    }
    return title;
  }

  @Override
  public Object getObject() {
    return day;
  }

  @Override
  public void setObject(Object object) {
    day = (DateTime) object;
  }

  @Override
  public boolean isEventForColumn(Event event) {
    //TODO implement this later
    return false;
  }
}
