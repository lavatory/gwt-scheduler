package gwtscheduler.client;

import com.google.gwt.event.logical.shared.BeforeSelectionEvent;
import com.google.gwt.event.logical.shared.BeforeSelectionHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.Widget;
import gwtscheduler.client.dragndrop.DragInHandler;
import gwtscheduler.client.dragndrop.DragOutHandler;
import gwtscheduler.client.dragndrop.DropEvent;
import gwtscheduler.client.dragndrop.DropHandler;
import gwtscheduler.client.dragndrop.DropZone;
import gwtscheduler.client.modules.views.MainView;
import gwtscheduler.client.resources.Resources;
import gwtscheduler.client.resources.css.DayWeekCssResource;
import gwtscheduler.client.widgets.common.CalendarPresenter;
import gwtscheduler.client.widgets.common.navigation.TabPanelContainer;

/**
 * @author mlesikov  {mlesikov@gmail.com}
 */
public class GwtSchedulerWidget extends Composite implements GwtScheduler.Display {
  /**
   * static ref to css
   */
  protected static final DayWeekCssResource CSS = Resources.dayWeekCss();

  /**
   * widget delegate
   */
  private DecoratedTabPanel impl;

  public GwtSchedulerWidget() {
    impl = new DecoratedTabPanel();
    initWidget(impl);
  }


  @Override
  public void selectTab(int i) {
    impl.selectTab(i);
  }

  @Override
  public void add(CalendarPresenter.Display display, String title) {
    TabPanelContainer container = new TabPanelContainer();
    container.add((Widget) display);

    impl.add(container, title);
  }

  @Override
  public void addBeforeSelectionHandler(BeforeSelectionHandler<Integer> handler) {
    impl.addBeforeSelectionHandler(handler);
  }

//  @Override
//  public HandlerRegistration addDropHandler(DropHandler handler) {
//    return addHandler(handler, DropEvent.TYPE);
//  }
//
//  @Override
//  public HandlerRegistration addDragOverHandler(DragInHandler handler) {
//    return null;
//  }
//
//  @Override
//  public HandlerRegistration addDragOutHandler(DragOutHandler handler) {
//    return null;
//  }
}