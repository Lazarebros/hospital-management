/**
 * 
 */
package com.dev.hospital.management.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * @author dayanlazare
 *
 */
@ManagedBean(name = "message", eager = true)
@RequestScoped
public class Message {

	private String message = "Hello World!";

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
