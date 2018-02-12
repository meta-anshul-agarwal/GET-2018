package session3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * 
 * @author Anshul Agarwal
 * This class represents the various methods required to make the workflow 
 * for a candidate
 */
public class Workflow {
	
	//state object denoting current state
	State currentState;
	
	//counter to fetch state from linked list of state objects
	int stateCounter = 0;
	
	//variable to store workflow name
	String workflow_name;
	
	//list of event type objects
	List<Event> event_list = new ArrayList<>();
	
	//list of transition type objects
	List<Transition> transition_list = new ArrayList<>();
	
	//linked list of state objects
	LinkedList<State> state_list = new LinkedList<>();
	
	/**
	 * method to return the transition list
	 * @return transition_list contains all the transition 
	 */
	public List<Transition> getTransition_list() {
		return transition_list;
	}

    /**
     * constructor to initialize the workflow name	
     * @param workflow_name string has the name of the workflow
     */
	Workflow(String workflow_name){
		this.workflow_name = workflow_name;
	}
	
	/**
	 * method that adds the event in event list and manages the next move
	 * @param event the current event that occurred
	 */
	void transition_step(Event event)throws NullPointerException {
		
		if(event.eventName == " " || event.eventName == ""){
			throw new NullPointerException();
		}
		//to add event to the list
		event_list.add(event);
		
		//method called to check the type of event that occurred
		check_event(event , event.eventName);
		
	}
	
	/**
	 * method to set start state
	 */
	void setStartState() {
		currentState = state_list.get(stateCounter);
	}
	
	/**
	 * method that returns the state list
	 * @return state_list contains the list of objects
	 */
	public LinkedList<State> getState_list() {
		return state_list;
	}

	/**
	 * method that returns the event list
	 * @return event_list contains the list of event objects
	 */
	public List<Event> getEvent_list() {
		return event_list;
	}

	/**
	 * method that checks if the event has reject or ok keyword in it
	 * @param event object of event class in which variable ok or reject have to 
	 * be changed
	 * @param eventStatus name of the event to be checked
	 * @return string status of candidate
	 */
	public String check_event(Event event , String eventStatus){
		
		//string variable that stores the status of candidate
		String status = null;
		
		//method called to change the status of variable
		event.changeStatus(eventStatus);
			
		//to check if the current event depicts rejection
		if(event.isReject()) {
			
			//status changed to rejected
			status = "Rejected";
			
			//new object of transition 
			Transition transition = new Transition(currentState, currentState, event);
			
			//add new transition to the transition list
			transition_list.add(transition);
		
		}
		
		//to check if the current event depicts positive transition
		if(event.isOk()) {
			
			//initializes current state to the next state of the state linked list
			currentState = state_list.get(++stateCounter);
			
			//to check if the offer state has been reached
			if(currentState.stateName == "offer") {
				status = "Selected";
			}
			
			//new object of transition 
			Transition transition = new Transition(state_list.get(stateCounter - 1), currentState, event);
			
			//add new transition to the transition list
			transition_list.add(transition);
		}
		
		//returning the status of the candidate
		return status;
	}
	
	/**
	 * method to add state to the list
	 * @param state - new state
	 */
	void addState(State state) {
		state_list.add(state);
	}
	
	/**
	 * verify if passed state and current state is equal
	 * @param state - passed state
	 * @return - boolean type
	 */
	boolean verify(State state) {
		return currentState == state ? true : false;
	}
}
