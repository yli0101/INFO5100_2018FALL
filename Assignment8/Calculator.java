package Calculator;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

enum Operation {
	ADD, SUBTRACT, MULTIPLY, DIVIDE
}

public class Calculator extends JFrame {

	private JTextField resultTextField;
	private JButton add, subtract, multiply, divide, compute, clear;

	private JButton numbers[];
	private Font font, font2;

	int num = 0;
	Stack<Integer> stack = new Stack<>();
	Operation operator = Operation.ADD;
	
	public void addNum() {
		if(operator == Operation.ADD) 
			stack.add(num);
		else if(operator == Operation.SUBTRACT) 
			stack.add(-num);
		else if(operator == Operation.MULTIPLY) 
			stack.add(stack.pop() * num);			
		else if(operator == Operation.DIVIDE) 
			stack.add(stack.pop() / num);
	}
	class OperandListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			for(int i = 0; i < 10; i++) {
				if (arg0.getSource() == numbers[i]) {
					num = num * 10 + i;
					resultTextField.setText(num + "");
					break;
				}
			}										
		}		
	}
	
	
	
	class OperationListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			num = Integer.parseInt(resultTextField.getText());
			addNum();			
			
			if(e.getSource() == add) 
				operator = Operation.ADD;			
			if(e.getSource() == subtract) 
				operator = Operation.SUBTRACT;			
			if(e.getSource() == multiply) 
				operator = Operation.MULTIPLY;			
			if(e.getSource() == divide) 
				operator = Operation.DIVIDE;	
			
			num = 0;
		}
	}	
	
	class ComputeListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			addNum();
			int result = 0;
	        while(!stack.isEmpty())
	        	result += stack.pop();
	        num = 0;
			operator = Operation.ADD;
	        resultTextField.setText(String.valueOf(result));
		}

	}

	public Calculator() {
		createComponents();
		setLayout();
		addComponents();
		addBehaviors();
		display();
	}

	private void addBehaviors() {		
		OperandListener odl = new OperandListener();
		for(int i = 0; i < 10; i++) 
			numbers[i].addActionListener(odl);
		
		OperationListener ol = new OperationListener();
		add.addActionListener(ol);
		subtract.addActionListener(ol);
		multiply.addActionListener(ol);
		divide.addActionListener(ol);
				
		ComputeListener cl = new ComputeListener();
		compute.addActionListener(cl);
	}

    private void display() {
        setSize(600, 600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void addComponents() {
        Container c = getContentPane();
        c.add(resultTextField);

        JPanel panel = new JPanel();
        panel = new JPanel();
        panel.add(numbers[7]);
        panel.add(numbers[8]);
        panel.add(numbers[9]);
        panel.add(add);
        c.add(panel);
        panel = new JPanel();
        panel.add(numbers[4]);
        panel.add(numbers[5]);
        panel.add(numbers[6]);
        panel.add(subtract);
        c.add(panel);
        panel = new JPanel();
        panel.add(numbers[1]);
        panel.add(numbers[2]);
        panel.add(numbers[3]);
        panel.add(multiply);
        c.add(panel);
        panel = new JPanel();
        panel.add(compute);
        panel.add(numbers[0]);
        panel.add(clear);
        panel.add(divide);
        c.add(panel);
    }

    private void setLayout() {
        GridLayout gl = new GridLayout(6, 1);
        Container c = this.getContentPane();
        c.setLayout(gl);

    }

    private void createComponents() {
        font = new Font("TimesRoman", Font.PLAIN, 32);
        resultTextField = new JTextField(10);
        resultTextField.setFont(font);

        clear = new JButton("C");
        clear.setFont(font);
        clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				num = 0;
				stack.clear();
				operator = Operation.ADD;
				resultTextField.setText("");
			}
		});

        add = new JButton("+");
        add.setFont(font);
        
        subtract = new JButton("-");
        subtract.setFont(font);

        multiply = new JButton("x");
        multiply.setFont(font);
        
        divide = new JButton("/");
        divide.setFont(font);
        
        compute = new JButton("=");
        compute.setFont(font);

        numbers = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numbers[i] = new JButton(i + "");
            numbers[i].setFont(font);
            
        }

    }

    public static void main(String[] args) {
        Calculator c = new Calculator();

    }
}

