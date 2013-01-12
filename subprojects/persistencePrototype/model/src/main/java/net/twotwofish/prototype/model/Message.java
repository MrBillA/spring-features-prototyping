/*
 * Copyright $today.year Thomson Reuters/ONESOURCE. All rights reserved.
 */

package net.twotwofish.prototype.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import static javax.persistence.GenerationType.AUTO;
import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang.builder.ToStringBuilder.reflectionToString;


/**
 * Message Description.
 *
 * @author Bill Andrews
 */
@Entity
@Table(name="message")
public final class Message implements Serializable
{
	private static final long serialVersionUID = 1L;

	private Long id;
	private User user;
	private String text;

	@DateTimeFormat(pattern="hh:mma MMM d, YYYY")
	private Date when;

	public Message() {
		this.user = new User();  // HARD-CODED FOR NOW
		this.user.setId((long)1);
	}

	@Id
	@GeneratedValue(strategy = AUTO)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="messageText")
	@NotNull
	@Size(min=1, max=140)
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column(name="postedTime")
	public Date getWhen() {
		return this.when;
	}

	public void setWhen(Date when) {
		this.when = when;
	}

	@ManyToOne
	@JoinColumn(name="user_id")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// plumbing
	@Override
	public boolean equals(Object obj) {
		return reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return reflectionHashCode(this);
	}

	@Override
	public String toString() {
		return reflectionToString(this);
	}
}
