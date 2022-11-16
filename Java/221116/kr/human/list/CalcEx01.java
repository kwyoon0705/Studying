package kr.human.list;

import java.util.Arrays;
import java.util.Stack;

/*
수식 표현에는 3가지 방법이 있다. 
1. 전위 표기법(prefix)
	- 연산자가 피연산자들 앞에 위치한 수식 
2. 중위 표기법(infix)
	- 연산자가 피연산자 사이에 위치한 수식
	- 주로 사람이 계산하는 방법
3. 후위 표기법(postfix)
	- 연산자가 피연산자들 뒤에 위치한 수식
	- 컴파일러가 계산하는 방법
 */
public class CalcEx01 {
	public static void main(String[] args) {
		System.out.println("2*( 3 + 6) = " + postfixToInfix("2*(3+6)"));
		System.out.println("(2*(3+6)) = " + postfixToInfix("(2*(3+6))"));
		System.out.println("2*3+6 = " + postfixToInfix("2*3+6"));
		System.out.println("(2*3+6) = " + postfixToInfix("(2*3+6)"));
		System.out.println();
		System.out.println("(12*3+126) = " + postfixToInfix("(12*3+126)"));
		System.out.println("(22*(43+566)) = " + postfixToInfix("(22*(43+566))"));
		System.out.println(postfixToInfix("(22*(43+566))") + " => " + Arrays.toString(postfixToInfix("(22*(43+566))").split(" ")));
		System.out.println();
		System.out.println("2*(3+6) = " + getCalculator(postfixToInfix("2*(3+6)")));
		System.out.println("2*3+6 = " + getCalculator(postfixToInfix("2*3+6")));
		System.out.println("12*3+126 = " + getCalculator(postfixToInfix("12*3+126")));
		
	}
	// 중위 표현식을 후위 표현식으로 변경하기
	public static String postfixToInfix(String expression) {
        String answer = "";
        Stack<String> stack = new Stack<>();

        for (char c : expression.toCharArray()) {
        	// 연산자라면
            if ("+-*/()".contains(c + "")) {
            	answer += " "; // 숫자가 끝났으니까 공백을 추가
            	// 닫는 괄호라면 
                if (c == ')') { 
                	// 스택이 비어있지 않으면서 여는 괄호가 나올때까지 출력
                    while (!stack.isEmpty() && stack.peek().charAt(0) != '(') {
                        answer += stack.pop().charAt(0) + " ";
                    }
                    // 스택에 출력
                    stack.pop();
                // 여는 괄호라면 스택에 넣는다.    
                } else if(c=='(') {
                	 stack.push(c + "");
            	//  + - * / 라면
                } else { 
                	// 스택이 비어있지 않으면서 현재 값과 스택에 있는 연산자의 우선순위를 비교하여
                	// 스택에 있는 우선 순위가 높다면
                	while (!stack.isEmpty() && opOrder(c)<opOrder(stack.peek().charAt(0))) {
                        answer += stack.pop() + " "; // 스택에서 제거하여 출력
                    }
                    stack.push(c + ""); // 현재 연산자 넣기
                }
            // 숫자라면 : 계속 출력   
            } else if(Character.isDigit(c)){
                answer += c;
            }
        }
        // 스택에 남아있는 연산자를 모두 꺼내서 출력한다.
        answer += " ";
        while (!stack.isEmpty()) {
            answer += stack.pop() + " ";
        }
        // 두개의 공백을 1개의 공백으로 치환하고 앞뒤 공백 제거
        answer = answer.replace("  ", " ").trim();
        return answer;
    }
    
    // 연산 부호 우선순위 정하는 메서드
    public static int opOrder(char op) {
    	int answer = -1;
        switch (op) {
            case '+':
            case '-':
                answer = 1;
                break;
            case '*':
            case '/':
            	answer = 2;
                break;
        }
        return answer;
    }
    // 후위 표현식을 계산하는 메서드
    public static int getCalculator(String expression) {
        Stack<Integer> stack = new Stack<>();

        // 공백을 기준으로 배열로 만들어 반복 
        for (String s : expression.split(" ")) { 
        	// 연산자라면
            if ("+-*/".contains(s)) {
            	// 2개를 꺼낸다.
                int second = stack.pop();
                int first = stack.pop();
                // 연산자에 따른 계산을 한다.
                switch (s) {
                    case "+":
                        stack.push(first + second);
                        break;
                    case "-":
                        stack.push(first - second);
                        break;
                    case "*":
                        stack.push(first * second);
                        break;
                    case "/":
                        stack.push(first / second);
                        break;
                }
            // 숫자라면
            } else {
            	// 숫자로 바꿔 스택에 저장한다.
                stack.push(Integer.parseInt(s));
            }
        }
        // 마지막에 스택에 남아있는 값이 결과이다.
        return stack.pop();
    }
}