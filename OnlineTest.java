import java.awt. *;
import java.awt. event.*;
import javax.swing.*;
import java.io.*;
import java.io.FileReader;
import java.io.FileReader.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.io.IOException;

class QuestionSeries{
static String info ="Java Online Test Week  \n \nINSTRUCTIONS:\nThere are 15 questions in this test and 10 minutes to complete them all.\nThe finish button is highlighted in green when you reach the end of the test. \nClicking the finish button will display the results with the correct answers marked in light red.  \n \nThe timecounter  begins when you click on the 'start' button \n \nBest of luck!\n";

static String []question ={"Question 1:\nThe class at the top of exception class hierarchy is....",
"Question 2:\nIn which of the following package Exception class exist?",
"Question 3: \nException generated in try block is caught in ..... block?",
"Question 4:\nWhich keyword is used to explicitly throw an exception?",
"Question 5:\nWhich exception is thrown when divide by zero statement executes?",
"Question 6:\nIn java arrays are .....?",
"Question 7:\nWhich one of the following is a valid statement?",
"Question 8:\nWhen you pass an array to a method, the method receives _______?",
"Question 9:\nWhich will legally declare, construct, and initialize an array?",
"Question 10:\nIn java a thread can be created by _____?",
"Question 11:\nWhich of the following constructor of class Thread is valid one?",
"Question 12:\nWhich of the following are methods of Thread class?",
"Question 13:\ntoString() method is defined in ?",
"Question 14:\nThe String method compareTo() returns?",
"Question 15:\nThe class string belongs to ...... package.",

};


static String [][]answers ={{"ARITHMETIC EXCEPTION\n","THROWABLE\n","OBJECT\n","EXCEPTION\n"},{"java.util\n"," java.file\n","java.io\n"," \njava.lang\n"},{" \ncatch\n","throw\n","throws\n","finally\n"},{" \ntry","throwing\n"," \ncatch\n"," \nthrow\n"},{" \nNumberFormatException\n"," \nArithmeticException\n"," \nNullPointerException\n"," \nNone of these\n"},{" \nobjects\n"," \nobject references\n"," \nprimitive data type\n","None of the above\n"},{" \nchar[] c=new char();\n"," \nchar[] c=new char[5];\n"," \nchar[] c=new char(4);\n"," \nchar[] c=new char[];\n"},{" \nA copy of the array\n"," \nA copy of the first element\n"," \nThe reference of the array\n"," \nThe length of the array\n"},{" \nint[] myList={};\n"," \nint[] myList=(5,8,2);\n"," \nint myList[][]={4,9,7,0};\n"," \nint myList[]={4,3,7};\n"},{" \nExtending the thread class\n"," \nImplementing Runnable interface\n"," \nBoth of the above\n"," \nNone of these\n"},{" \nThread(Runnable threadOb,int priority)\n"," \nThread(int priority)\n"," \nThread(Runnable threadOb,String threadName)\n"," \nNone of these\n"},{" \nyield()\n"," \nslope(long msec)\n"," \nGo()\n"," \nstack()\n"},{" \njava.lang.String\n"," \njava.lang.Object\n"," \njava.lang.util\n"," \nNone of these\n"},{"true\n"," \nfalse\n"," \nan int value\n"," \n1\n"},{" \njava.awt\n"," \njava.long\n"," \njava.app\n"," \njava.string\n"}};

static int []n = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,};
static String []choice= {"2","4","1","4","2","1","2","3","4","3","3","1","2","3","2","1","1","4","3"};
static int tally = choice.length;
static String testtitle="Java Programming Online Test";
static int timeLimit =10;
static int passMark = 33;
}

/* OnlineTest class */

public class OnlineTest extends JFrame{
    static String code ="";
    static int TOTAL=0;
	static String rollno="";
	static int xyz=0;

	static{
	try{
	TOTAL = QuestionSeries.tally;		
	/* 	The input window */
		
	
	int flag=0;
	int x= 0;
	while(x==0)
	{
		BufferedReader reader;
	reader=new BufferedReader(new FileReader("E:\\Project\\List.txt"));
	
	String i=reader.readLine();
	code = JOptionPane.showInputDialog("Enter your code: ");
	while(i!=null)
	{
			if(!code.equals(i))
			{
				
				flag=1;
				
			}
			else
			{flag=0;
			 x=1;
			 break;
			}
		
		
		i=reader.readLine();
	}
	if (flag==1)
	{JOptionPane.showMessageDialog(null,"Enter a valid code ");
	}
	else{ break;
	}
	reader.close();	
	}
	
	}catch(IOException e){
		System.err.	println("Please input valid inputs "+e.getMessage());
	}
	
	}	



    	int seconds, minutes;
    	int quesnum, itemCheck, mark; 
	final String TESTTITLE = QuestionSeries.testtitle;
    	final int TIMELIMIT = QuestionSeries.timeLimit;
    	final int PASS = QuestionSeries.passMark;
    	String []answers = new String[TOTAL];
	JButton []choice_button = new JButton[6];
	JTextArea answerboxes[] = new JTextArea[4];
	JCheckBox []boxes = new JCheckBox[4];
    	JTextPane pane = new JTextPane();
	JLabel student, choose, message, timecounter, testresult;
    	boolean start_test, check_answer, allowRestart, finishtest;
	Northwindow panelNorth = new Northwindow();
	Southwindow panelSouth = new Southwindow();
	Centerwindow panelCenter = new Centerwindow();

/*  OnlineTest Constructor */
	protected OnlineTest(){
        for (int i=0; i<TOTAL; i++) answers[i] ="";
		getContentPane().setLayout(new BorderLayout() );
		getContentPane().add("North", panelNorth);
		getContentPane().add("South", panelSouth);
		getContentPane().add("Center", panelCenter);
		int width = 0, height=0; 
	        if(java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth()<799){width=		640; 		height=460; }
	        else {width=720; height=540; }
		setSize(width,height);
		Dimension dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((dim.width-width)/2, (dim.height-height)/2);
	}

/**
**  Northwindow class
**/

class Northwindow extends JPanel{

/**
**  Northwindow constructor 
**/
    public Northwindow(){
		setLayout(new GridLayout(4,4));
		setBackground(new Color(255, 255, 255));
		student = new JLabel("\t Welcome : "+code+" to the Online Java Test");
		student.setFont(new Font("Malgun Gothic",Font.BOLD,16) );
		message = new JLabel();
		message.setForeground(Color.black);
		add(student);
		add(message);
        setBorder(BorderFactory.createEtchedBorder() );
	}
}

/**
**  Southwindow class
**/
class Southwindow extends JPanel{
	public Southwindow(){
		String []key = {"","start:","next:","finish:","check next:","check previous:"};
			for(int i=0; i<choice_button.length; i++)
                   {
				choice_button[i] = new JButton(key[i]);
				choice_button[i].addActionListener(new ActionHandler() );
				if(i !=0)add(choice_button[i]);
			  }
        setBorder(BorderFactory.createEtchedBorder() );
	}
}

/**
**  Centerwindow class 
**/
class Centerwindow extends JPanel{

	public Centerwindow(){
		setLayout(new GridLayout(1,2) );
		JScrollPane west = new JScrollPane(pane);       
		pane.setForeground(Color.black);	       
   		pane.setFont(new Font ("Malgun Gothic",0,20) );
		pane.setText(QuestionSeries.info);
		pane.setEditable(false);
		JPanel east = new JPanel();
		east.setLayout(new BorderLayout() );	
		JPanel northEast = new JPanel();
		northEast.setBackground(new Color(230, 230, 255) ); 
		east.add("North", northEast);
		JPanel westEast = new JPanel();
		westEast.setLayout(new GridLayout(6,1) );
		east.add("West", westEast);
		JPanel centerEast = new JPanel();
		centerEast.setLayout(new GridLayout(6,1) );
		centerEast.setBackground(new Color(255,255,200));
		east.add("Center", centerEast);       
			timecounter = new JLabel("     There are "+TOTAL+" questions in total");
			timecounter.setFont(new Font ("Monotype Corsiva",Font.BOLD,16) );
			timecounter.setForeground(new Color(0,90,20) );
			northEast.add(timecounter);
			westEast.add(new JLabel(" "));
        String []boxs = {" A ", " B ", " C ", " D "};
			for(int i=0; i<boxes.length; i++) { 
				boxes[i] = new JCheckBox(boxs[i]);
				boxes[i].addItemListener(new ItemHandler() );
				westEast.add(boxes[i]);
			}
        westEast.add(new JLabel() );
		choose = new JLabel("    CHOOSE CORRECT ANSWERS");
		choose.setBorder(BorderFactory.createEtchedBorder() );
		centerEast.add(choose);
        JScrollPane panes[] = new JScrollPane[4];
			for(int i=0; i<answerboxes.length; i++){
				answerboxes[i] = new JTextArea();
			    answerboxes[i].setBorder(BorderFactory.createEtchedBorder() );
				answerboxes[i].setEditable(false);
				answerboxes[i].setBackground(Color.white);
				answerboxes[i].setFont(new Font("Malgun Gothic",0,12) );
	            answerboxes[i].setLineWrap(true);      
                answerboxes[i].setWrapStyleWord(true);
                panes[i] = new JScrollPane(answerboxes[i]);
			    centerEast.add(panes[i]);
			}
		if(TIMELIMIT >0)testresult = new JLabel(code+",   You have only : "+TIMELIMIT+" minutes to complete.");   
		else testresult = new JLabel("     There is no time limit for this test");
		testresult.setBorder(BorderFactory.createEtchedBorder() );
		centerEast.add(testresult);
	add(west);
	add(east);
	}
}

/**
**  ActionHandler class to handle all the action events from the buttons. 
**/

class ActionHandler implements ActionListener{

/* actionPerformed method */
	public void actionPerformed(ActionEvent evt){
	  String source = evt.getActionCommand();
		if(source.equals("start:")){
			choice_button[1].setVisible(false);
			start_test=true;
			allowRestart=true;
            if(TIMELIMIT >0)new Timer(); // inner Timer class 
			panelSouth.remove(choice_button[1]); //start
            displayquestion();            
        }
	if(start_test){
		if(source.equals("previous:"))  {            			
			recordanswer();
			quesnum--;
    		if(quesnum ==  -1) quesnum=TOTAL-1;
			checkteststatus();
            displayquestion(); 
		}
		if(source.equals("next:")) {
			recordanswer();
			quesnum++;            
			if(quesnum ==  TOTAL-1) finishtest=true;
			if(quesnum ==  TOTAL) quesnum=0;
            checkteststatus();
            displayquestion(); 
		}
		if(source.equals("finish:")) {
			if (finishtest){
				recordanswer();
				quesnum = 0;

				choice_button[4].setBackground(Color.lightGray);
				timecounter.setForeground(Color.blue);
				timecounter.setFont(new Font ("Arial",0,14) );
				start_test=false; 
				check_answer=true;
				panelSouth.add(choice_button[0]);
				mark_ques();
				displayquestion();
				checkteststatus();
				calculateResult();
			}
			else  JOptionPane.showMessageDialog(null,"Cycle through all questions before pressing finish",
																 "User Message",JOptionPane.INFORMATION_MESSAGE);
		}
	} 

	if (check_answer){
		if(source.equals("check next:")) {
			quesnum++;
			if(quesnum ==  TOTAL) quesnum=0;
			mark_ques();
			displayquestion();
			checkteststatus();
		}
		if(source.equals("check previous:")) {
			quesnum--;
			if(quesnum ==  -1) quesnum=TOTAL-1;
			mark_ques();
			displayquestion();
			checkteststatus();
		}
	}
	validate();        
	}

/* Timer class */

class Timer extends Thread implements Runnable{
	public Timer(){
		new Thread(this).start();
	}

    public void run() {
		while(start_test){
            try {
               Thread.sleep(1000);
               seconds++;
				if(seconds % 60 == 0 && seconds != 0){
                    seconds -= 60;
                    minutes++;
				}
				timecounter.setText("    Time Counter:  "+minutes+" mins : "+seconds+" secs ");
				if(minutes==TIMELIMIT){
					start_test=false;
					endTest();
                }
		    }
            catch(InterruptedException ex)  { System.out.print(ex); }
		}
    }
}

/* checkteststatus method */

		public void checkteststatus(){
		if((quesnum ==  TOTAL-1)&&(start_test))choice_button[3].setBackground(Color.green);
		else choice_button[4].setBackground(Color.lightGray);
      	  if(answers[quesnum].length() >0){ 
			for(int i=0; i<answers[quesnum].length(); i++)
			boxes[Integer.parseInt(answers[quesnum].substring(i,i+1) )-1].setSelected			(true);
		}
		else for(int i=0; i<boxes.length; i++)boxes[i].setSelected(false);
		}

/* displayquestion method */

	public void displayquestion(){
        int j = quesnum+1;
		pane.setText(QuestionSeries.question[quesnum]);
		if(start_test)message.setText("Question "+j+" out of "+TOTAL);
        for (int i=0; i<4; i++)answerboxes[i].setText(QuestionSeries.answers[quesnum][i]);
		if(start_test){
            String temp="";
			if(QuestionSeries.n[quesnum]==1) temp="<html>&nbsp;&nbsp;&nbsp;Choose only 		<b>ONE</b>  Option</html>";
			else if(QuestionSeries.n[quesnum]==2) temp="<html>&nbsp;&nbsp;Choose <b>TWO		</b> Options</html>";
		else if(QuestionSeries.n[quesnum]==3) temp="<html>&nbsp;&nbsp;Choose <b>THREE</b> 		Options</html>";
            else temp="<html>&nbsp;&nbsp;<b>ALL are true</b> true</html>";
		choose.setText(temp);
		}
		else {
		timecounter.setText("    Your choices are shown in the boxes");
            choose.setText("    Correct answers are marked in light red.");
		}
	}

/* record answer method */

	public void recordanswer(){
		String tmp = "";
		for(int i=0; i<boxes.length; i++) if(boxes[i].isSelected() ) tmp +=i+1;
        answers[quesnum] = tmp;
    }

/* endTest method */ 

	public void endTest(){
		message.setText("TIME OVER: please press 'finish'");
        choice_button[2].setEnabled(false); 
        choice_button[3].setEnabled(false); 
        choice_button[4].setEnabled(true); 
	}

/* mark_ques() method to highlight correct answers */

	public void mark_ques(){
		for(int i=0; i<answerboxes.length; i++) answerboxes[i].setBackground(Color.white);
		for(int i=0; i<QuestionSeries.choice[quesnum].length(); i++)
			answerboxes[Integer.parseInt(QuestionSeries.choice[quesnum].substring(i,i+1))-1].setBackground(Color.red);
		if(QuestionSeries.choice[quesnum].equals(answers[quesnum])) message.setText("Answer correct, well done!");
		else message.setText("Sorry, you got this one wrong.");
	}


	public void calculateResult(){
		mark=0;
		double temp=0.0;
        java.text.DecimalFormat df = new java.text.DecimalFormat("#0.#");
		for(int i=0; i<TOTAL; i++)if(QuestionSeries.choice[i].equals(answers[i]))mark++;
		temp=(double)mark;
		if(temp/TOTAL*100 >=PASS) testresult.setText("  Well done "+code.substring(0,code.indexOf(' ') )+", you passed");
		else testresult.setText("  Better luck next time "+code.substring(0,code.indexOf(' ') ) );
		student.setText(" Final score for "+code+":  "+mark+" out of "+TOTAL+":  "+df.format(temp/TOTAL*100)+"%");
	}
}



/* ItemHandler class */

class ItemHandler implements ItemListener{
	public void itemStateChanged(ItemEvent evt){
	  if(start_test){
		for(int i=0; i<boxes.length; i++) if(boxes[i].isSelected() ) itemCheck++; 
		if(itemCheck > QuestionSeries.n[quesnum]){
			java.awt.Toolkit.getDefaultToolkit().beep();
            if(QuestionSeries.n[quesnum]==1)	JOptionPane.showMessageDialog(null,"<html><font 		size='4' color='00308a'><center>"+
      	"There is only "+QuestionSeries.n[quesnum]+" possible<br> answer to question "+(quesnum+1)+
                    "<html>","User Information Message",JOptionPane.INFORMATION_MESSAGE);
			else JOptionPane.showMessageDialog(null,"<html><font size='4' color='00308a'><center>"+
                    "There are only "+QuestionSeries.n[quesnum]+" possible<br> answers to question "+(quesnum+1)+
                    "<html>","User Information Message",JOptionPane.INFORMATION_MESSAGE);
		}
		itemCheck=0;
	  }	  
	}
}

/*  main method */

	public static void main(String [] args){
		OnlineTest frame = new OnlineTest();
		frame.setTitle("    "+QuestionSeries.testtitle);
		frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
		frame.setVisible(true);
		if (xyz==1)
		{frame.setVisible(false);
		}
    }
}