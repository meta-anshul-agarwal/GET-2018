package assignment1;


/**
 * this class is used to convert infix to postfix expression 
 * @author Anshul Agarwal
 */

public class InfixToPostfix {

/**
 * this function is used to convert infix to post fix
 * @param infixExp - the infix expression to be changed
 * @return 
 */
String infixToPostfix(String infixExp) {

//object of stack
Stack stack = new Stack();
//string to store postfix expression
String postfixExp = new String();

//main loop to be called 
for(int i = 0; i < infixExp.length(); i++) {

	char c = infixExp.charAt(i);
	if(c == ' ') {
		continue;
	}

	//to check whether the inserted value is a character or a digit 
	if(Character.isLetterOrDigit(c)) {
		postfixExp += c;
	} else if(c == '(') {
		stack.push(c);
	} else if(c == ')') {

	//used to pop all digits out until '(' is encountered
	while(stack.top != null && stack.top.data != '(') {
		postfixExp += stack.pop();
	}
	stack.pop();
	} else {

		//check the precedence to pop out
		while (stack.top != null && precedence(c) <= precedence(stack.top.data)) {
    postfixExp += stack.pop();
		}
stack.push(c);
	}
}

	//pop out all remaining elements if the input string is empty
while (stack.top != null) {
    postfixExp += stack.pop();
}

return postfixExp;
}

/**
 * this function is used to return the precedence of each operator
 * @param c - operator
 * @return
 */
private int precedence(char c) {

switch(c) {
	case '+':
	case '-':
		return 1;

	case '*':
	case '/':
		return 2;

	case '^':
		return 3;

	default:
		return -1;
	}
}
}

