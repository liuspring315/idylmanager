package com.idyl.manager.dao;


import com.idyl.manager.dao.model.Criteria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 非常简单的查询，可以无视
 * @author Administrator
 *
 */
public class SearchCriteria {

	List<Criteria> andCondition;
	List<Criteria> orCondition;
	List<Criteria> condition;
	String table;
	Class<?> clazz;
	List<String> groupBy;

	public SearchCriteria(Class<?> clazz) {
		this.table = ReflectUtil.getTable(clazz);
		this.clazz = clazz;
		andCondition = new ArrayList<Criteria>();
		orCondition = new ArrayList<Criteria>();
		condition = new ArrayList<Criteria>();
		groupBy=new ArrayList<String>();
	}

	public void addAndCondition(Criteria c) {
		andCondition.add(c);
	}

	public void addOrCondition(Criteria c) {
		orCondition.add(c);
	}

	public void addCondition(Criteria c) {
		condition.add(c);
	}

	public void addOrCriteria() {
		condition.add(new Criteria("", Criteria.Op.OR, ""));
	}

	public void addAndCriteria() {
		condition.add(new Criteria("", Criteria.Op.AND, ""));
	}

	public void addGroupByColumn(String column){
		groupBy.add(column);
	}

	public String generateWhereClause() {
		StringBuilder sb = new StringBuilder(" where ");
		if (condition.size() != 0) {
			for (Criteria c : condition) {
				if (c.getOperator() != Criteria.Op.AND && c.getOperator() != Criteria.Op.OR)
					sb.append(generateSub(c));
				else
					sb.append(c.getOperator().toString());
			}
		} else if (orCondition.size() != 0 && andCondition.size() != 0) {
			sb.append(generateAnd());
			sb.append(" AND (");
			sb.append(generateOr());
			sb.append(")");
		} else if (andCondition.size() == 0) {
			sb.append(generateOr());
		} else if (orCondition.size() == 0) {
			sb.append(generateAnd());
		} else {
			return "";
		}

		return sb.toString();
	}

	public String generateGroupByClause(){
		StringBuilder sb=new StringBuilder();
		sb.append(Arrays.toString(groupBy.toArray()));
		sb.subSequence(1, sb.length()-2);
		return sb.toString();
	}

	private String generateAnd() {
		StringBuilder sb = new StringBuilder();
		if (andCondition.size() == 1) {
			sb.append(generateSub(andCondition.get(0)));
		} else {
			for (int i = 0; i < andCondition.size(); i++) {
				if (i == andCondition.size() - 1) {
					sb.append(generateSub(andCondition.get(i)));
				} else {
					sb.append(generateSub(andCondition.get(i)) + " AND ");
				}
			}
		}
		return sb.toString();
	}

	private String generateOr() {
		StringBuilder sb = new StringBuilder();
		if (orCondition.size() == 1) {
			sb.append(generateSub(orCondition.get(0)));
		} else {
			for (int i = 0; i < orCondition.size(); i++) {
				if (i == orCondition.size() - 1) {
					sb.append(generateSub(orCondition.get(i)));
				} else {
					sb.append(generateSub(orCondition.get(i)) + " OR ");
				}
			}
		}
		return sb.toString();
	}

	private String generateSub(Criteria c) {
		return c.getColumn() + c.getOperator().toString();
	}

	public Object[] generateParams() {
		List<Object> params = new ArrayList<Object>();
		for (Criteria c : andCondition) {
			params.add(c.getValue());
		}
		for (Criteria c : orCondition) {
			params.add(c.getValue());
		}
		for (Criteria c : condition) {
			if (c.getOperator() == Criteria.Op.AND && c.getOperator() == Criteria.Op.OR)
				continue;
			if (c.getColumn() == null || c.getColumn().isEmpty())
				continue;
			params.add(c.getValue());
		}
		return params.toArray();
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

}