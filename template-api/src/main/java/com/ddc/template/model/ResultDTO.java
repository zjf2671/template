package com.ddc.template.model;

import java.io.Serializable;

/**
 * 返回结果集
 * @author harry.zhang
 *
 */
public class ResultDTO<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int total ;
    
    private T datas ;
    
    private int code = 0;
    
	private String error;
	
	/**
	 * 结果状态 0:成功, -1:异常失败 ;
	 * 
	 */
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getError() {
		return error;
	}

	public void setError(int code, String error) {
		this.setCode(code);
		this.error = error;
	}

	public void setError(String error) {
		if (code == 0)
			this.setCode(-1);
		this.error = error;
	}

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public T getDatas() {
        return datas;
    }

    public void setDatas(T datas) {
        this.datas = datas;
    }
    
}
