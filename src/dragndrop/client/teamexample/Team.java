package dragndrop.client.teamexample;

import com.google.gwt.event.dom.client.HasMouseDownHandlers;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import dragndrop.client.core.DragZone;
import dragndrop.client.core.Draggable;
import dragndrop.client.core.DropEvent;
import dragndrop.client.core.DropHandler;
import dragndrop.client.core.DropZone;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lazo Apostolovski (lazo.apostolovski@gmail.com) 
 */
public class Team implements Draggable{
  public interface Display extends DropZone {
    HasText getTeamName();

    void addCarName(String carName);

    void addTrackName(String carName);
  }

  private Display display;
  private List<Car> cars = new ArrayList<Car>();
  private List<Truck> trucks = new ArrayList<Truck>();

  public Team(Display display, String teamName) {
    this.display = display;
    display.getTeamName().setText(teamName);

    display.addDropHandler(new DropHandler(){
      @Override
      public void onDrop(DropEvent event) {
        Object o = event.getDroppedObject();
        if(o instanceof Car){
          Car car = (Car)o;
          addCar(car);
          event.getSourceWidget().removeFromParent();
        } else if(o instanceof Truck){
          Truck truck = (Truck)o;
          addTruck(truck);
          event.getSourceWidget().removeFromParent();
        }
      }
    });
  }

  public String getTeamName(){
    return display.getTeamName().getText();
  }

  public void addCar(Car car){
    cars.add(car);
    display.addCarName(car.getName());
  }

  public void addTruck(Truck truck){
    trucks.add(truck);
    display.addTrackName(truck.getName());
  }

  public List<Car> getCars(){
    return cars;
  }

  public List<Truck> getTrucks(){
    return trucks;
  }

  @Override
  public HasMouseDownHandlers getHasMouseDownHandler() {
    return (HasMouseDownHandlers)display;
  }

  @Override
  public Object getDropObject() {
    return this;
  }

  @Override
  public int getWidth() {
    return 50;
  }

  @Override
  public int getHeight() {
    return 50;
  }

  @Override
  public Widget getSourceWidget() {
    return (Widget)display;
  }

  public void go(HasWidgets teamPanel) {
    teamPanel.add((Widget)display);
  }
}
