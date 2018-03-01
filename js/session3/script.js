/* Method to bind events to the selectors */
window.js = function(selector) {
	
	var selectors = document.querySelectorAll (selector);
	
	/* method to add events to each selector*/
	function onEvent (event, func) {
		selectors.forEach ( function (selector) {
			selector.addEventListener (event, func);
		});
	};
	
    /* Return our own api that uses the onEvent function to act on our selected list.*/
    return {
		on: function (event, func) {
			onEvent (event, func);
		}
	}
};
