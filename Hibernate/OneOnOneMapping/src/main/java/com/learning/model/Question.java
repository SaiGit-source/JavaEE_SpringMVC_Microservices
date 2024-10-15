package com.learning.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Question 
{
	@Id
	@Column(name="question_id")
	private Integer id;
	
	private String question; // if we dont specify @Column annotation, the default name will be question
	
	@OneToOne(cascade=CascadeType.ALL) // for mapping Answer to Question
	private Answer answer; // reference variable for answer object
	// cascade : whatever happens to question should happen with answer also
	
	// one instance of Answer should map with one instance of Question
	
	public Question() {
		super();
		System.out.println("Zero parameter constructor of Question class");
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", answer=" + answer + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
	
}
