package onlineShop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "WordCount")
public class Word implements Serializable {
		private static final long serialVersionUID = 2683242425040385345U;
	    private String word;

	    public Word() {
	    }

	    public Word(String word) {
	        this.word = word;
	    }

	    public void setWord(String word) {
	        this.word = word;
	    }

	    public String getWord() {
	        return word;
	    }
	}

public class Count implements Serializable {
	    private String word;
	    private long count;

	    public Count() {
	    }

	    public Count(String word, long count) {
	        this.word = word;
	        this.count = count;
	    }

	    public String getWord() {
	        return word;
	    }

	    public void setWord(String word) {
	        this.word = word;
	    }

	    public long getCount() {
	        return count;
	    }

	    public void setCount(long count) {
	        this.count = count;
	    }
	}
