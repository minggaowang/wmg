package com.wmg.web.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页
 * @author Administrator
 *
 * @param <T>
 */
public class Page<T> {

	private List<T> list = new ArrayList<T>();//数据集合
	private long totalCount;//总记录数
	private long countMin;//当前页记录数下标最小值
	private long countMax;//当前页记录数下标最大值
	private int pageCount;//总页数
	private int pageSize;//页大小
	private int pageIndex;//当前页
	
	public Page() {

    }
	public Page(List<T> list, long totalCount, long countMin, long countMax, int pageCount, int pageSize, int pageIndex) {
		this.list = list;
		this.totalCount = totalCount;
		this.countMin = countMin;
		this.countMax = countMax;
		this.pageCount = pageCount;
		this.pageSize = pageSize;
		this.pageIndex = pageIndex;
	}
	
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	public long getCountMin() {
		return countMin;
	}
	public void setCountMin(long countMin) {
		this.countMin = countMin;
	}
	public long getCountMax() {
		return countMax;
	}
	public void setCountMax(long countMax) {
		this.countMax = countMax;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	@Override
	public String toString() {
		return "Page [list=" + list + ", totalCount=" + totalCount + ", countMin=" + countMin + ", countMax=" + countMax + ", pageCount=" + pageCount + ", pageSize=" + pageSize + ", pageIndex="
				+ pageIndex + "]";
	}
}
