package springgenesys.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kysymykset {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String kysymys;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getKysymys() {
		return kysymys;
	}
	public void setKysymys(String kysymys) {
		this.kysymys = kysymys;
	}
	public Kysymykset() {
		super();
		this.kysymys = null;
	}
	public Kysymykset(String kysymys) {
		super();
		this.kysymys = kysymys;
	}
	public Kysymykset(long id, String kysymys) {
		super();
		this.id = id;
		this.kysymys = kysymys;
	}
	@Override
	public String toString() {
		return "Kysymykset [id=" + id + ", kysymys=" + kysymys + "]";
	}
}
