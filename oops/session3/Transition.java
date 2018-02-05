package session3;

/**
 * 
 * @author Anshul Agarwal
 * This class depicts the transition that took place due to the event that occurred
 */
public class Transition {

	//variable storing the initial and final state of that particular transition
	State initialState, finalState;
	
	//object of event class to maintain the track of event that caused the transition
	Event event;

	/**
	 * method to get the initial state
	 * @return initialState returns initial state
	 */
	public State getInitialState() {
		return initialState;
	}
	
	/**
	 * method to get the final state
	 * @return finalState returns final state
	 */
	public State getFinalState() {
		return finalState;
	}
	
	
	/**
	 * method to get the event
	 * @return event object
	 */
	public Event getEvent() {
		return event;
	}
	
	/**
	 * constructor to initialize initialState,finalState and event
	 * @param initialState state object depicting initial state 
	 * @param finalState state object depicting final state
	 * @param event event object depicting occurred event
	 */
	public Transition(State initialState, State finalState, Event event) {
		
		this.initialState = initialState;
		this.finalState = finalState;
		this.event = event;
		
	}

	
}
