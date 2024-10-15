package com.learning.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="AnswersManyToOne")
public class Answers {
	
	@Id
	@Column(name="answer_id")
	private Integer id;
	private String answer;
	
	@ManyToOne(cascade=CascadeType.ALL) // this is bi-directional
	private Question question;

	public Answers() {
		super();
		System.out.println("Zero param Constructor of Answers");
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	
}
