package org.bakara.dto;

public class Criteria {
	
	private int page ; 
	private int perPaegNum ; 
	
	public Criteria() {
		this.page =1 ; 
		this.perPaegNum = 10 ; 
	}

	public void setPage(int page) {
		if(page <=0 ) {
			this.page =1 ; 
			return ; 
		}
		this.page = page ; 
	}
	public void setPerPaegNum(int perPaeNum) {
		if(perPaeNum <=10 || perPaeNum > 100) {
			this.perPaegNum = 10 ; 
			return ; 
		}
		this.perPaegNum = perPaegNum;
	}
	
	public int getPage() {
		return page;
	}

	public int getPageStart() {
		return (this.page -1) * perPaegNum ;
	}

	public int getPerPaegNum() {
		return perPaegNum;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPaegNum=" + perPaegNum + "]";
	}
	

	
	

	


}
