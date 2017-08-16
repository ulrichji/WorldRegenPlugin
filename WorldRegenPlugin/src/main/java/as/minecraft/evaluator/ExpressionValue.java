package as.minecraft.evaluator;

public class ExpressionValue
{
	
	private final String value;
	private final ExpressionType type;
	
	public ExpressionValue(String value)
	{
		String tempValue = value;
		if(isDouble(value))
		{
			if(isLong(value))
				this.type = ExpressionType.LONG;
			else
				this.type = ExpressionType.DOUBLE;
		}
		else if(isBoolean(value))
			this.type = ExpressionType.BOOLEAN;
		else
		{
			if(value.startsWith("'") && value.endsWith("'"))
				tempValue = value.substring(1,value.length()-1);
			this.type = ExpressionType.STRING;
		}
		
		debug("t: "+tempValue);
		this.value = tempValue;
	}
	
	public ExpressionValue(String value, ExpressionType type)
	{
		this.value = value;
		this.type = type;
	}
	
	public ExpressionValue(ExpressionValue other)
	{
		this.value = other.value;
		this.type = other.type;
	}

	private boolean isBoolean(String s)
	{
		if(s.equals("false") || s.equals("true"))
			return true;
		return false;
	}

	private boolean isLong(String s)
	{
		return s.matches("-?\\d+");  //match a number with optional '-' and decimal.
	}

	private boolean isDouble(String s)
	{
		return s.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
	}

	public static ExpressionValue castBoolean(ExpressionValue a)
	{
		if(a.getType() == ExpressionType.STRING || a.getType() == ExpressionType.LONG)
		{
			if(a.getValue().equals("true") || a.getValue().equals("t") || !a.getValue().equals("0"))
				return new ExpressionValue(Boolean.toString(true), ExpressionType.BOOLEAN);
			else
				return new ExpressionValue(Boolean.toString(false), ExpressionType.BOOLEAN);
		}
		else if(a.getType() == ExpressionType.DOUBLE)
		{
			if(Double.parseDouble(a.getValue()) == 0)
				return new ExpressionValue(Boolean.toString(false), ExpressionType.BOOLEAN);
			else
				return new ExpressionValue(Boolean.toString(true), ExpressionType.BOOLEAN);
		}
		
		return new ExpressionValue(a);
	}
	
	public static ExpressionValue castLong(ExpressionValue a)
	{
		if(a.getType() == ExpressionType.STRING)
			return new ExpressionValue(Long.toString(Long.parseLong(a.getValue())), ExpressionType.LONG);
		else if(a.getType() == ExpressionType.BOOLEAN)
		{
			if(Boolean.parseBoolean(a.getValue()) == true)
				return new ExpressionValue(Long.toString(1), ExpressionType.LONG);
			else
				return new ExpressionValue(Long.toString(0), ExpressionType.LONG);
		}
		else if(a.getType() == ExpressionType.DOUBLE)
			return new ExpressionValue(Long.toString((long)Double.parseDouble(a.getValue())), ExpressionType.LONG);
		else
			return new ExpressionValue(a);
	}
	
	public static ExpressionValue castDouble(ExpressionValue a)
	{
		if(a.getType() == ExpressionType.STRING)
			return new ExpressionValue(Double.toString(Double.parseDouble(a.getValue())), ExpressionType.DOUBLE);
		else if(a.getType() == ExpressionType.BOOLEAN)
		{
			if(Boolean.parseBoolean(a.getValue()) == true)
				return new ExpressionValue(Double.toString(1), ExpressionType.DOUBLE);
			else
				return new ExpressionValue(Double.toString(0), ExpressionType.DOUBLE);
		}
		else if(a.getType() == ExpressionType.LONG)
			return new ExpressionValue(Double.toString((double)Long.parseLong(a.getValue())), ExpressionType.DOUBLE);
		else
			return new ExpressionValue(a);
	}
	
	public static ExpressionValue castString(ExpressionValue a)
	{
		//All values already have a string representation
		return new ExpressionValue(a.getValue(), ExpressionType.STRING);
	}
	
	public static ExpressionValue logicalNot(ExpressionValue a)
	{
		debug("!"+a);
		return new ExpressionValue(Boolean.toString(! Boolean.parseBoolean(a.getValue())), ExpressionType.BOOLEAN);
	}
	
	public static ExpressionValue bitwiseNot(ExpressionValue a)
	{
		debug("~"+a);
		return new ExpressionValue(Long.toString(~ Long.parseLong(a.getValue())), ExpressionType.LONG);
	}

	public static ExpressionValue multiply(ExpressionValue a, ExpressionValue b)
	{
		debug(a+"*"+b);
		if(a.getType() == ExpressionType.DOUBLE || b.getType() == ExpressionType.DOUBLE)
		{
			return new ExpressionValue(Double.toString(Double.parseDouble(a.getValue()) * Double.parseDouble(b.getValue())), ExpressionType.DOUBLE);
		}
		else
		{
			return new ExpressionValue(Long.toString(Long.parseLong(a.getValue()) * Long.parseLong(b.getValue())), ExpressionType.LONG);
		}
	}
	
	public static ExpressionValue divide(ExpressionValue a, ExpressionValue b)
	{
		debug(a+"/"+b);
		if(a.getType() == ExpressionType.DOUBLE || b.getType() == ExpressionType.DOUBLE)
		{
			return new ExpressionValue(Double.toString(Double.parseDouble(a.getValue()) / Double.parseDouble(b.getValue())), ExpressionType.DOUBLE);
		}
		else
		{
			return new ExpressionValue(Long.toString(Long.parseLong(a.getValue()) / Long.parseLong(b.getValue())), ExpressionType.LONG);
		}
	}
	
	public static ExpressionValue modulo(ExpressionValue a, ExpressionValue b)
	{
		debug(a+"%"+b);
		if(a.getType() == ExpressionType.DOUBLE || b.getType() == ExpressionType.DOUBLE)
		{
			return new ExpressionValue(Double.toString(Double.parseDouble(a.getValue()) % Double.parseDouble(b.getValue())), ExpressionType.DOUBLE);
		}
		//Now both should be integers. Let the parse handle the potential conversion errors.
		else
		{
			return new ExpressionValue(Long.toString(Long.parseLong(a.getValue()) % Long.parseLong(b.getValue())), ExpressionType.LONG);
		}
	}
	
	public static ExpressionValue add(ExpressionValue a, ExpressionValue b)
	{
		debug(a+"+"+b);
		
		//String "+" means concatenation
		if(a.getType() == ExpressionType.STRING || b.getType() == ExpressionType.STRING)
			return new ExpressionValue(a.getValue() + b.getValue(), ExpressionType.STRING);
		//We now know that the operators are numbers. If one is double, convert result to double. Let the parsing handle type errors.
		else if(a.getType() == ExpressionType.DOUBLE || b.getType() == ExpressionType.DOUBLE)
			//Longs can also be converted to doubles.
			return new ExpressionValue(Double.toString(Double.parseDouble(a.getValue()) + Double.parseDouble(b.getValue())), ExpressionType.DOUBLE);
		//They are both long values. Let the parsing handle type errors.
		else
			return new ExpressionValue(Long.toString(Long.parseLong(a.getValue()) + Long.parseLong(b.getValue())), ExpressionType.LONG);
	}
	
	public static ExpressionValue subtract(ExpressionValue a, ExpressionValue b)
	{
		debug(a+"-"+b);
		if(a.getType() == ExpressionType.DOUBLE || b.getType() == ExpressionType.DOUBLE)
		{
			return new ExpressionValue(Double.toString(Double.parseDouble(a.getValue()) - Double.parseDouble(b.getValue())), ExpressionType.DOUBLE);
		}
		//Both should be longs now. Let the parsing handle the type errors.
		else
		{
			return new ExpressionValue(Long.toString(Long.parseLong(a.getValue()) - Long.parseLong(b.getValue())), ExpressionType.LONG);
		}
	}
	
	public static ExpressionValue leftShift(ExpressionValue a, ExpressionValue b)
	{
		debug(a+"<<"+b);
		//Let the parsing handle the errors.
		return new ExpressionValue(Long.toString(Long.parseLong(a.getValue()) << Long.parseLong(b.getValue())), ExpressionType.LONG);
	}
	
	public static ExpressionValue rightShift(ExpressionValue a, ExpressionValue b)
	{
		debug(a+">>"+b);
		//Let the parsing handle the errors.
		return new ExpressionValue(Long.toString(Long.parseLong(a.getValue()) >> Long.parseLong(b.getValue())), ExpressionType.LONG);
	}
	
	public static ExpressionValue doubleRightShift(ExpressionValue a, ExpressionValue b)
	{
		debug(a+">>>"+b);
		//Let the parsing handle the errors.
		return new ExpressionValue(Long.toString(Long.parseLong(a.getValue()) >>> Long.parseLong(b.getValue())), ExpressionType.LONG);
	}
	
	public static ExpressionValue smaller(ExpressionValue a, ExpressionValue b)
	{
		debug(a+"<"+b);
		
		if(a.getType() == ExpressionType.STRING || b.getType() == ExpressionType.STRING)
			return new ExpressionValue(Boolean.toString(a.getValue().compareTo(b.getValue()) < 0), ExpressionType.BOOLEAN);
		//Let the parser handle invald values
		else if(a.getType() == ExpressionType.DOUBLE || b.getType() == ExpressionType.DOUBLE)
			return new ExpressionValue(Boolean.toString(Double.parseDouble(a.getValue()) < Double.parseDouble(b.getValue())), ExpressionType.BOOLEAN);
		else
			return new ExpressionValue(Boolean.toString(Long.parseLong(a.getValue()) < Long.parseLong(b.getValue())), ExpressionType.BOOLEAN);
	}
	
	public static ExpressionValue greater(ExpressionValue a, ExpressionValue b)
	{
		debug(a+">"+b);
		
		if(a.getType() == ExpressionType.STRING || b.getType() == ExpressionType.STRING)
			return new ExpressionValue(Boolean.toString(a.getValue().compareTo(b.getValue()) > 0), ExpressionType.BOOLEAN);
		//Let the parser handle invald values
		else if(a.getType() == ExpressionType.DOUBLE || b.getType() == ExpressionType.DOUBLE)
			return new ExpressionValue(Boolean.toString(Double.parseDouble(a.getValue()) > Double.parseDouble(b.getValue())), ExpressionType.BOOLEAN);
		else
			return new ExpressionValue(Boolean.toString(Long.parseLong(a.getValue()) > Long.parseLong(b.getValue())), ExpressionType.BOOLEAN);
	}
	
	public static ExpressionValue smallerEqual(ExpressionValue a, ExpressionValue b)
	{
		debug(a+"<="+b);
		
		if(a.getType() == ExpressionType.STRING || b.getType() == ExpressionType.STRING)
			return new ExpressionValue(Boolean.toString(a.getValue().compareTo(b.getValue()) <= 0), ExpressionType.BOOLEAN);
		//Let the parser handle invald values
		else if(a.getType() == ExpressionType.DOUBLE || b.getType() == ExpressionType.DOUBLE)
			return new ExpressionValue(Boolean.toString(Double.parseDouble(a.getValue()) <= Double.parseDouble(b.getValue())), ExpressionType.BOOLEAN);
		else
			return new ExpressionValue(Boolean.toString(Long.parseLong(a.getValue()) <= Long.parseLong(b.getValue())), ExpressionType.BOOLEAN);
	}
	
	public static ExpressionValue greaterEqual(ExpressionValue a, ExpressionValue b)
	{
		debug(a+">="+b);
		
		if(a.getType() == ExpressionType.STRING || b.getType() == ExpressionType.STRING)
			return new ExpressionValue(Boolean.toString(a.getValue().compareTo(b.getValue()) >= 0), ExpressionType.BOOLEAN);
		//Let the parser handle invald values
		else if(a.getType() == ExpressionType.DOUBLE || b.getType() == ExpressionType.DOUBLE)
			return new ExpressionValue(Boolean.toString(Double.parseDouble(a.getValue()) >= Double.parseDouble(b.getValue())), ExpressionType.BOOLEAN);
		else
			return new ExpressionValue(Boolean.toString(Long.parseLong(a.getValue()) >= Long.parseLong(b.getValue())), ExpressionType.BOOLEAN);
	}
	
	public static ExpressionValue equal(ExpressionValue a, ExpressionValue b)
	{
		debug(a+"=="+b);
		
		//If both is not double, compare the strings. Only double might have different string litreals for "same" value
		if(a.getType() != ExpressionType.DOUBLE || b.getType() != ExpressionType.DOUBLE)
			return new ExpressionValue(Boolean.toString(a.getValue().compareTo(b.getValue()) == 0), ExpressionType.BOOLEAN);
		//Only double values might have different "strings" for equality
		else
			return new ExpressionValue(Boolean.toString(Double.parseDouble(a.getValue()) == Double.parseDouble(b.getValue())), ExpressionType.BOOLEAN);
	}
	
	public static ExpressionValue notEqual(ExpressionValue a, ExpressionValue b)
	{
		debug(a+"!="+b);
		
		if(a.getType() == ExpressionType.STRING || b.getType() == ExpressionType.STRING)
			return new ExpressionValue(Boolean.toString(a.getValue().compareTo(b.getValue()) != 0), ExpressionType.BOOLEAN);
		//Only double values might have different "strings" for equality
		else
			return new ExpressionValue(Boolean.toString(Double.parseDouble(a.getValue()) != Double.parseDouble(b.getValue())), ExpressionType.BOOLEAN);
	}
	
	public static ExpressionValue bitwiseAnd(ExpressionValue a, ExpressionValue b)
	{
		debug(a+"&"+b);
		if(a.getType() == ExpressionType.BOOLEAN && b.getType() == ExpressionType.BOOLEAN)
			return new ExpressionValue(Boolean.toString(Boolean.parseBoolean(a.getValue()) & Boolean.parseBoolean(b.getValue())), ExpressionType.BOOLEAN);
		else
			//Value type errors are handled by parser.
			return new ExpressionValue(Long.toString(Long.parseLong(a.getValue()) & Long.parseLong(b.getValue())), ExpressionType.LONG);
	}
	
	public static ExpressionValue bitwiseXor(ExpressionValue a, ExpressionValue b)
	{
		debug(a+"^"+b);
		if(a.getType() == ExpressionType.BOOLEAN && b.getType() == ExpressionType.BOOLEAN)
			return new ExpressionValue(Boolean.toString(Boolean.parseBoolean(a.getValue()) ^ Boolean.parseBoolean(b.getValue())), ExpressionType.BOOLEAN);
		else
			//Value type errors are handled by parser.
			return new ExpressionValue(Long.toString(Long.parseLong(a.getValue()) ^ Long.parseLong(b.getValue())), ExpressionType.LONG);
	}
	
	public static ExpressionValue bitwiseOr(ExpressionValue a, ExpressionValue b)
	{
		debug(a+"|"+b);
		if(a.getType() == ExpressionType.BOOLEAN && b.getType() == ExpressionType.BOOLEAN)
			return new ExpressionValue(Boolean.toString(Boolean.parseBoolean(a.getValue()) | Boolean.parseBoolean(b.getValue())), ExpressionType.BOOLEAN);
		else
			//Value type errors are handled by parser.
			return new ExpressionValue(Long.toString(Long.parseLong(a.getValue()) | Long.parseLong(b.getValue())), ExpressionType.LONG);
	}
	
	public static ExpressionValue logicalAnd(ExpressionValue a, ExpressionValue b)
	{
		debug(a+"&&"+b);
		//Only possible to do with boolean expressions.
		return new ExpressionValue(Boolean.toString(Boolean.parseBoolean(a.getValue()) && Boolean.parseBoolean(b.getValue())), ExpressionType.BOOLEAN);
	}
	
	public static ExpressionValue logicalOr(ExpressionValue a, ExpressionValue b)
	{
		debug(a+"||"+b);
		//Only possible to do with boolean expressions.
		return new ExpressionValue(Boolean.toString(Boolean.parseBoolean(a.getValue()) || Boolean.parseBoolean(b.getValue())), ExpressionType.BOOLEAN);
	}
	
	public ExpressionType getType()
	{
		return type;
	}
	
	public String getValue()
	{
		return value;
	}
	
	public String toString()
	{
		return value;
	}
	
	private static void debug(String s)
	{
		//System.out.println(s);
	}
}

