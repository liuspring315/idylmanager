package com.idyl.manager.dao.model;

public class Criteria {

	public enum Op {
		GT(" > ? ", 1), GTEQ(" >= ? ", 1), LT(" < ? ", 1), LTEQ(" <= ? ", 1), EQ(
				" = ? ", 1), NEQ(" != ? ", 1), BETWEEN(" BETWEEN ? AND ? ", 2), NBETWEEN(
				" NOT BETWEEN ? AND ? ", 2), IN(" IN () ", -1), NOTIN(
				" NOT IN () ", -1), LIKE(" LIKE ? ", 1), NLIKE(" NOT LIKE ? ",
				1), NIN(" NOT IN () ", -1), NULL(" IS NULL ", 0), NNULL(
				" IS NOT NULL ", 0), SC(" () ", 1), TEXT("  () ", 1), RP("", 0), AND(
				" AND ", 0), OR(" OR ", 0), NOT(" NOT ", 0);

		private final String op;
		int params;

		Op(String op, int params) {
			this.op = op;
			this.params = params;
		}

		@Override
		public String toString() {
			return op;
		}

		public int getParams() {
			return params;
		}
	}
	
	public enum Func {
        NATIVE("@", 1),
        MAX("MAX(@)", 1),
        MIN("MIN(@)", 1),
        FIRST("FIRST(@)", 1),
        LAST("LAST(@)", 1),
        SUM("SUM(@)", 1),
        COUNT("COUNT(@)", 1),
        DISTINCT("DISTINCT(@)", 1);
        
        private String func;
        private int count;
        
        Func(String func, int params) {
            this.func = func;
            this.count = params;
        }
        
        @Override
        public String toString() {
            return func;
        }
        
        public int getCount() {
            return count;
        }
    }
	

	String column;
	// String table;
	Object value;
	Op operator;
    Func function;
	public Criteria(String column, Op operator, Object value) {
		this.column = column;
		if (operator == Op.LIKE||operator== Op.NLIKE)
			this.value = "%" + value + "%";
		else 
			this.value = value;
		this.operator = operator;
	}
	
	public Criteria(String column, Func function){
		this.column=column;
		this.function=function;
	}

	public Op getOperator() {
		return operator;
	}

	public void setOperator(Op operator) {
		this.operator = operator;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

}
