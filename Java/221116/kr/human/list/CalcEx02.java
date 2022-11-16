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
public class CalcEx02 {
	public static void main(String[] args) {
		System.out.println("2*( 3 + 6) = " + I2P("2*(3+6)"));
		System.out.println("(2*(3+6)) = " + I2P("(2*(3+6))"));
		System.out.println("2*3+6 = " + I2P("2*3+6"));
		System.out.println("(2*3+6) = " + I2P("(2*3+6)"));
		System.out.println();
		System.out.println("(12*3+126) = " + I2P("(12*3+126)"));
		System.out.println("(22*(43+566)) = " + I2P("(22*(43+566))"));
		System.out.println(I2P("(22*(43+566))") + " => " + Arrays.toString(I2P("(22*(43+566))").split(" ")));
		System.out.println();
	}

	// 중위 표현식을 후위 표현식으로 변경하기
	public static String I2P(String expression) {
		String answer = "";
		Stack<String> stack = new Stack<>();

		for (char c : expression.toCharArray()) {
			// c가 연산자라면
			if ("+-*/()".contains(c + "")) {
				answer += " "; // 숫자가 끝났으므로 출력값에 공백을 더해준다.
				// c가 연산자 중 닫는 괄호라면
				if (c == ')') {
					// 스택이 비어있지 않으면서 여는 괄호가 나올때까지 출력
					while (!stack.isEmpty() && stack.peek().charAt(0) != '(') {
						answer += stack.pop().charAt(0) + " ";
					}
					// 스택에 출력
					stack.pop();
					// 여는 괄호라면 스택에 넣는다.
				} else if (c == '(') {
					stack.push(c + "");
					// + - * / 라면
				} else {
					// 스택이 비어있지 않으면서 현재 값과 스택에 있는 연산자의 우선순위를 비교하여
					// 스택에 있는 우선 순위가 높다면
					while (!stack.isEmpty() && opOrder(c) < opOrder(stack.peek().charAt(0))) {
						answer += stack.pop() + " "; // 스택에서 제거하여 출력
					}
					stack.push(c + ""); // 현재 연산자 넣기
				}
				// 숫자라면 : 계속 출력
			} else if (Character.isDigit(c)) {
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
}