package com.example.demo.entity;

import java.io.Serializable;

/**
 * 字典值dto.
 * 
 * @author aominglei
 *
 * @2018年9月7日
 * version:1.0
 */
public class DictDto implements Serializable {

	private static final long serialVersionUID = -4203490827672977983L;

	private Long dictId;
	
	private Long dictTypeId;
	
	private String code;
	
	private String description;
	
	private Integer sort;

	/**
	 * @return  dictId
	 */
	public Long getDictId() {
		return this.dictId;
	}

	/**
	 * @param dictId 
	 *            the dictId to set
	 */
	public void setDictId(Long dictId) {
		this.dictId = dictId;
	}

	/**
	 * @return  dictTypeId
	 */
	public Long getDictTypeId() {
		return this.dictTypeId;
	}

	/**
	 * @param dictTypeId 
	 *            the dictTypeId to set
	 */
	public void setDictTypeId(Long dictTypeId) {
		this.dictTypeId = dictTypeId;
	}

	/**
	 * @return  code
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * @param code 
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return  description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * @param description 
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
