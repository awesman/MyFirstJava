package by.mantur.information.interpreter;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.mantur.information.composite.Symbol;
import by.mantur.information.composite.IPart;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Interpreter {
	
	private static Logger logger = LogManager.getLogger(Interpreter.class);

    public IPart executeInterpretation(List<String> rpnParts, Context context) {
        List<Operation> operations = receiveOperations(rpnParts);
        for (Operation o : operations) {
            o.interpret(context);
        }
        String result = context.popValue();
        return new Symbol(result);
    }

    private List<Operation> receiveOperations(List<String> rpnParts) {
        List<Operation> operations = new ArrayList<>();
        for (String lexeme : rpnParts) {
            char temp = lexeme.charAt(0);
            switch (temp) {
                case 'i':
                    operations.add((Context context) -> {
                        context.pushValue("i");
                    });
                    break;
                case 'j':
                    operations.add((Context context) -> {
                        context.pushValue("j");
                    });
                    break;
                case '+':
                    operations.add((Context context) -> {
                        double firstAddendum = receiveDouble(context);
                        double secondAddendum = receiveDouble(context);
                        context.pushValue(String.valueOf(firstAddendum + secondAddendum));
                    });
                    break;
                case '-':
                    if (lexeme.length() == 1) {
                        operations.add((Context context) -> {
                            double subtrahend = receiveDouble(context);
                            double minuend = receiveDouble(context);
                            context.pushValue(String.valueOf(minuend - subtrahend));
                        });
                    } else {
                        Scanner scan = new Scanner(lexeme);
                        if (scan.hasNextDouble()) {
                            operations.add((Context context) -> {
                                context.pushValue(String.valueOf(scan.nextDouble()));
                            });
                        }
                        scan.close();
                    }
                    break;
                case '*':
                    operations.add((Context context) -> {
                        context.pushValue(String.valueOf(receiveDouble(context) * receiveDouble(context)));
                    });
                    break;
                case '/':
                    operations.add((Context context) -> {
                        double divider = receiveDouble(context);
                        double dividend = receiveDouble(context);
                        context.pushValue(String.valueOf(dividend / divider));
                    });
                    break;
                case '#':
                    operations.add((Context context) -> {
                        String contextTop = context.popValue();
                        if (contextTop.equals("i")) {
                            context.pushValue(String.valueOf(context.getAndAddI()));
                        } else if (contextTop.equals("j")) {
                            context.pushValue(String.valueOf(context.getAndAddJ()));
                        } else {
                            logger.log(Level.WARN, "Incrementation operation for digit has no sense");
                            context.pushValue(String.valueOf(Double.parseDouble(contextTop)));
                        }
                    });
                    break;
                case '@':
                    operations.add((Context context) -> {
                        String contextTop = context.popValue();
                        if (contextTop.equals("i")) {
                            context.pushValue(String.valueOf(context.addAndGetI()));
                        } else if (contextTop.equals("j")) {
                            context.pushValue(String.valueOf(context.addAndGetJ()));
                        } else {
                            logger.log(Level.WARN, "Incrementation operation for digit has no sense");
                            context.pushValue(String.valueOf(Double.parseDouble(contextTop)));
                        }
                    });
                    break;
                case '$':
                    operations.add((Context context) -> {
                        String contextTop = context.popValue();
                        if (contextTop.equals("i")) {
                            context.pushValue(String.valueOf(context.calculateAndGetI()));
                        } else if (contextTop.equals("j")) {
                            context.pushValue(String.valueOf(context.calculateAndGetJ()));
                        } else {
                            logger.log(Level.WARN, "Decrement operation for digit has no sense");
                            context.pushValue(String.valueOf(Double.parseDouble(contextTop)));
                        }
                    });
                    break;
                case '&':
                    operations.add((Context context) -> {
                        String contextTop = context.popValue();
                        if (contextTop.equals("i")) {
                            context.pushValue(String.valueOf(context.getAndCalculateI()));
                        } else if (contextTop.equals("j")) {
                            context.pushValue(String.valueOf(context.getAndCalculateJ()));
                        } else {
                            logger.log(Level.WARN, "Decrement operation for digit has no sense");
                            context.pushValue(String.valueOf(Double.parseDouble(contextTop)));
                        }
                    });
                    break;
                default:
                    Scanner scan = new Scanner(lexeme);
                    if (scan.hasNextDouble()) {
                        operations.add((Context context) -> {
                            context.pushValue(String.valueOf(scan.nextDouble()));
                        });
                    }
            }
            
        }
        return operations;
        
    }

    private double receiveDouble(Context c) {
        String contextTop = c.popValue();
        double result;
        if (contextTop.equals("i")) {
            result = c.getI();
        } else if (contextTop.equals("j")) {
            result = c.getJ();
        } else {
            result = Double.parseDouble(contextTop);
        }
        return result;
    }
    	
}
