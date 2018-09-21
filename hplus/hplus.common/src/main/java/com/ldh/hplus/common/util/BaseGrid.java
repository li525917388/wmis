package com.ldh.hplus.common.util;

import java.util.List;

/**
 * 数据表格视图模型
 * @author Li Dehuan
 *
 */
public class BaseGrid<T> {

	private int id;
	
	private String cell;
	
	private int page;

	private long records;
	
	private int total;
	
	private List<T> rows;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public long getRecords() {
		return records;
	}

	public void setRecords(long records) {
		this.records = records;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

}
