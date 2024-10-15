package com.learning.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="QuestionOneToMany")
public class Question {
	@Id
	@Column(name="question_id")
	private Integer id;
	
	private String question;
	
	@OneToMany(cascade=CascadeType.ALL) // both question and answers should be tightly linked. if you delete question table answer table also should be deleted
	private List<Answers> answers; // one to many we create a collection of answers

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

	public List<Answers> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answers> answers) {
		this.answers = answers;
	}

	public Question() {
		super();
		System.out.println("Zero param Constructor of Question");
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", answers=" + answers + "]";
	}
	
}
