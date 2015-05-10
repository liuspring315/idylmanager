package com.idyl.manager.util.pager;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述：分页类
 * @author pele 2010-12-30 上午11:37:16
 */
public class Pager {
//	protected final Logger logger = Logger.getLogger(Pager.class);

	private int page = 1;
	private int pageSize = 20;
	private int totalNum = 0;
	private int totalPage = 0;
	private List results = new ArrayList();


	public Pager() {}

	/**
	 * 返回所有记录
	 * @return
	 */
	public static Pager getMaxPager() {
		return new Pager(1, Integer.MAX_VALUE, Integer.MAX_VALUE);
	}

	/**
	 * 返回记录只有一条
	 * @return
	 */
	public static Pager getMinPager() {
		return new Pager(1, 1, Integer.MAX_VALUE);
	}

	public Pager(int page, int totalNum) {
		init(page, pageSize, totalNum);
	}

	public Pager(int page, int pageSize, int totalNum) {
		init(page, pageSize, totalNum);
	}

	public void init(int page, int pageSize, int totalNum) {
		this.page = page;
		this.pageSize = pageSize;
		this.totalNum = totalNum;
		calculatePage();
	}

	private void calculatePage() {
		if (totalNum % pageSize == 0)
			this.totalPage = totalNum / pageSize;
		else
			this.totalPage = totalNum / pageSize + 1;
		if (page < 1)
			page = 1;
		if (page > totalPage)
			page = totalPage;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
		calculatePage();
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getFirstRow() {
		if(page<=0){
			return 0;
		}
		return (page - 1) * pageSize;
	}

	public List getResults() {
		return results;
	}

	public void setResults(List results) {
		this.results = results;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + page;
		result = prime * result + pageSize;
		result = prime * result + totalNum;
		result = prime * result + totalPage;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pager other = (Pager) obj;
		if (page != other.page)
			return false;
		if (pageSize != other.pageSize)
			return false;
		if (totalNum != other.totalNum)
			return false;
		if (totalPage != other.totalPage)
			return false;
		return true;
	}

}