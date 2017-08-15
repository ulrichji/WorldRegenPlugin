package as.minecraft.evaluator;

import java.util.Iterator;

import com.fathzer.soft.javaluator.AbstractEvaluator;
import com.fathzer.soft.javaluator.BracketPair;
import com.fathzer.soft.javaluator.Operator;
import com.fathzer.soft.javaluator.Parameters;
import com.fathzer.soft.javaluator.StaticVariableSet;

import as.minecraft.util.BlockTypeEnumerate;
import as.minecraft.world.RegenBlock;
import as.minecraft.world.RegenBlockType;

public class BlockEvaluator extends AbstractEvaluator<ExpressionValue>
{
	public final static Operator CAST_BOOLEAN = new Operator("(boolean)", 1, Operator.Associativity.RIGHT, 12);
	public final static Operator CAST_LONG = new Operator("(long)", 1, Operator.Associativity.RIGHT, 12);
	public final static Operator CAST_DOUBLE = new Operator("(double)", 1, Operator.Associativity.RIGHT, 12);
	public final static Operator CAST_STRING = new Operator("(string)", 1, Operator.Associativity.RIGHT, 12);
	public final static Operator MULTIPLY = new Operator("*", 2, Operator.Associativity.LEFT, 10);
	public final static Operator DIVIDE = new Operator("/", 2, Operator.Associativity.LEFT, 10);
	public final static Operator MODULO = new Operator("%", 2, Operator.Associativity.LEFT, 10);
	public final static Operator ADD = new Operator("+", 2, Operator.Associativity.LEFT, 9);
	public final static Operator SUBTRACT = new Operator("-", 2, Operator.Associativity.LEFT, 9);
	public final static Operator LEFTSHIFT = new Operator("<<", 2, Operator.Associativity.LEFT, 8);
	public final static Operator RIGHTSHIFT = new Operator(">>", 2, Operator.Associativity.LEFT, 8);
	public final static Operator DOUBLE_RIGHTSHIFT = new Operator(">>>", 2, Operator.Associativity.LEFT, 8);
	public final static Operator SMALLER = new Operator("<", 2, Operator.Associativity.LEFT, 7);
	public final static Operator GREATER = new Operator(">", 2, Operator.Associativity.LEFT, 7);
	public final static Operator SMALLER_EQUAL = new Operator("<=", 2, Operator.Associativity.LEFT, 7);
	public final static Operator GREATER_EQUAL = new Operator(">=", 2, Operator.Associativity.LEFT, 7);
	public final static Operator EQUAL = new Operator("==", 2, Operator.Associativity.LEFT, 6);
	public final static Operator EQUAL2 = new Operator("=", 2, Operator.Associativity.LEFT, 6);
	public final static Operator NOT_EQUAL = new Operator("!=", 2, Operator.Associativity.LEFT, 6);
	public final static Operator BIT_AND = new Operator("&", 2, Operator.Associativity.LEFT, 5);
	public final static Operator BIT_XOR = new Operator("^", 2, Operator.Associativity.LEFT, 4);
	public final static Operator BIT_OR = new Operator("|", 2, Operator.Associativity.LEFT, 3);
	public final static Operator BIT_NOT = new Operator("~", 1, Operator.Associativity.RIGHT, 11);
	public final static Operator LOG_AND = new Operator("&&", 2, Operator.Associativity.LEFT, 2);
	public final static Operator LOG_OR = new Operator("||", 2, Operator.Associativity.LEFT, 1);
	public final static Operator LOG_NOT = new Operator("!", 1, Operator.Associativity.RIGHT, 11);
	
	//IF and THEN Currently unused as they are unsupported by javaluator
	public final static Operator IF = new Operator("?", 1, Operator.Associativity.LEFT, 1);
	public final static Operator THEN = new Operator(":", 1, Operator.Associativity.LEFT, 1);
	
	public final static Parameters PARAMETERS;
	
	private String expression = "";
	
	static
	{
		PARAMETERS = new Parameters();
		
		PARAMETERS.add(CAST_BOOLEAN);
		PARAMETERS.add(CAST_LONG);
		PARAMETERS.add(CAST_DOUBLE);
		PARAMETERS.add(CAST_STRING);
		PARAMETERS.add(MULTIPLY);
		PARAMETERS.add(DIVIDE);
		PARAMETERS.add(MODULO);
		PARAMETERS.add(ADD);
		PARAMETERS.add(SUBTRACT);
		PARAMETERS.add(LEFTSHIFT);
		PARAMETERS.add(RIGHTSHIFT);
		PARAMETERS.add(DOUBLE_RIGHTSHIFT);
		PARAMETERS.add(SMALLER);
		PARAMETERS.add(GREATER);
		PARAMETERS.add(SMALLER_EQUAL);
		PARAMETERS.add(GREATER_EQUAL);
		PARAMETERS.add(EQUAL);
		PARAMETERS.add(EQUAL2);
		PARAMETERS.add(NOT_EQUAL);
		PARAMETERS.add(BIT_AND);
		PARAMETERS.add(BIT_XOR);
		PARAMETERS.add(BIT_OR);
		PARAMETERS.add(BIT_NOT);
		PARAMETERS.add(LOG_AND);
		PARAMETERS.add(LOG_OR);
		PARAMETERS.add(LOG_NOT);
		
		PARAMETERS.addExpressionBracket(BracketPair.PARENTHESES);
	}
	
	protected BlockEvaluator()
	{
		super(PARAMETERS);
	}

	@Override
	protected ExpressionValue toValue(String literal, Object evaluationContext)
	{
		return new ExpressionValue(literal);
	}
	
	@Override
	protected ExpressionValue evaluate(Operator operator, Iterator<ExpressionValue> operands, Object evaluationContext)
	{
		if(operator == CAST_BOOLEAN)
			return ExpressionValue.castBoolean(operands.next());
		else if(operator == CAST_LONG)
			return ExpressionValue.castLong(operands.next());
		else if(operator == CAST_DOUBLE)
			return ExpressionValue.castDouble(operands.next());
		else if(operator == CAST_STRING)
			return ExpressionValue.castString(operands.next());
		else if(operator == BIT_NOT)
			return ExpressionValue.bitwiseNot(operands.next());
		else if(operator == LOG_NOT)
			return ExpressionValue.logicalNot(operands.next());
		else if(operator == MULTIPLY)
			return ExpressionValue.multiply(operands.next(), operands.next());
		else if(operator == DIVIDE)
			return ExpressionValue.divide(operands.next(), operands.next());
		else if(operator == MODULO)
			return ExpressionValue.modulo(operands.next(), operands.next());
		else if(operator == ADD)
			return ExpressionValue.add(operands.next(), operands.next());
		else if(operator == SUBTRACT)
			return ExpressionValue.subtract(operands.next(), operands.next());
		else if(operator == LEFTSHIFT)
			return ExpressionValue.leftShift(operands.next(), operands.next());
		else if(operator == RIGHTSHIFT)
			return ExpressionValue.rightShift(operands.next(), operands.next());
		else if(operator == DOUBLE_RIGHTSHIFT)
			return ExpressionValue.doubleRightShift(operands.next(), operands.next());
		else if(operator == SMALLER)
			return ExpressionValue.smaller(operands.next(), operands.next());
		else if(operator == GREATER)
			return ExpressionValue.greater(operands.next(), operands.next());
		else if(operator == SMALLER_EQUAL)
			return ExpressionValue.smallerEqual(operands.next(), operands.next());
		else if(operator == GREATER_EQUAL)
			return ExpressionValue.greaterEqual(operands.next(), operands.next());
		else if(operator == EQUAL)
			return ExpressionValue.equal(operands.next(), operands.next());
		else if(operator == EQUAL2)
			return ExpressionValue.equal(operands.next(), operands.next());
		else if(operator == NOT_EQUAL)
			return ExpressionValue.notEqual(operands.next(), operands.next());
		else if(operator == BIT_AND)
			return ExpressionValue.bitwiseAnd(operands.next(), operands.next());
		else if(operator == BIT_XOR)
			return ExpressionValue.bitwiseXor(operands.next(), operands.next());
		else if(operator == BIT_OR)
			return ExpressionValue.bitwiseOr(operands.next(), operands.next());
		else if(operator == LOG_AND)
			return ExpressionValue.logicalAnd(operands.next(), operands.next());
		else if(operator== LOG_OR)
			return ExpressionValue.logicalOr(operands.next(), operands.next());
		else
			return super.evaluate(operator, operands, evaluationContext);
	}
	
	public void setExpression(String expression)
	{
		this.expression = expression;
	}
	
	public boolean evaluateBlock(RegenBlock block)
	{
		final StaticVariableSet<ExpressionValue> variables = new StaticVariableSet<ExpressionValue>();
		variables.set("block_id", new ExpressionValue(BlockTypeEnumerate.getBlockTextIdFromId(block.getBlockId()), ExpressionType.STRING));
		variables.set("block_data", new ExpressionValue(Long.toString(block.getBlockData()), ExpressionType.LONG));
		variables.set("block_id_num", new ExpressionValue(Long.toString(block.getBlockId()), ExpressionType.LONG));
		
		ExpressionValue result = this.evaluate(expression, variables);
		result = ExpressionValue.castBoolean(result);
		
		return Boolean.parseBoolean(result.getValue());
	}
	
	public static void main(String[] argv)
	{
		BlockEvaluator evaluator = new BlockEvaluator();
		String expression = "block_id == \"minecraft\" + \":\" + \"grass\" && (boolean)block_data == (boolean)0";
		evaluator.setExpression(expression);
		RegenBlock block = new RegenBlock(RegenBlockType.BLOCK, 2, 0, 0, 0);
		System.out.println("Result is: "+evaluator.evaluateBlock(block));
	}
}
